package com.zpp.test;

import com.zpp.test.bean.User;
import com.zpp.test.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws IOException {

        InputStream resourceAsStream =
                Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build =
                new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        UserMapper mapper =
                sqlSession.getMapper(UserMapper.class);

        List<User> allUser = mapper.findAllUser();
        System.out.println(allUser);

    }
}
