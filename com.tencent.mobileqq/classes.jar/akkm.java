import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;

public class akkm
{
  static akko a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "AREngine_ARPromotion";
  }
  
  public static akkf a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return (akkf)((QQAppInterface)paramAppInterface).getManager(279);
    }
    if (AudioHelper.d()) {
      throw new IllegalArgumentException(ajjy.a(2131642732));
    }
    return null;
  }
  
  public static akko a(AppInterface paramAppInterface)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (AudioHelper.d())) {
      throw new IllegalArgumentException(ajjy.a(2131642730));
    }
    if (jdField_a_of_type_Akko == null) {}
    try
    {
      if (jdField_a_of_type_Akko == null) {
        jdField_a_of_type_Akko = new akko(paramAppInterface);
      }
      return jdField_a_of_type_Akko;
    }
    finally {}
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      a(paramAppInterface).a(paramAppInterface);
      BusinessCommonConfig.getInstance(paramAppInterface).doOnReconnect();
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "doOnReconnect, 不是主进程");
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong < AudioHelper.a();
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    long l = AudioHelper.a();
    return (paramLong1 < l) && (paramLong2 > l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akkm
 * JD-Core Version:    0.7.0.1
 */