import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class altf
{
  private static final altf jdField_a_of_type_Altf = new altf(1);
  private static boolean jdField_a_of_type_Boolean;
  private static final altf jdField_b_of_type_Altf = new altf(2);
  private static altf jdField_c_of_type_Altf = jdField_b_of_type_Altf;
  private final int jdField_a_of_type_Int;
  private final SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private final String jdField_a_of_type_JavaLangString;
  private final SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private final String jdField_b_of_type_JavaLangString;
  private final String jdField_c_of_type_JavaLangString;
  
  private altf(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = a(paramInt);
    this.jdField_c_of_type_JavaLangString = b(paramInt);
    this.jdField_a_of_type_AndroidContentSharedPreferences = a(paramInt);
    this.jdField_b_of_type_AndroidContentSharedPreferences = b(paramInt);
    if (paramInt == 1)
    {
      this.jdField_b_of_type_JavaLangString = "test.ark.qq.com";
      return;
    }
    this.jdField_b_of_type_JavaLangString = "cgi.ark.qq.com";
  }
  
  public static altf a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      ArkAppCenter.c("ArkApp", "ArkTemp.getCurrent sso env isTestEnv=" + false);
    }
    jdField_c_of_type_Altf = jdField_b_of_type_Altf;
    return jdField_c_of_type_Altf;
  }
  
  private static SharedPreferences a(int paramInt)
  {
    if (paramInt == 2) {
      return BaseApplication.getContext().getSharedPreferences("ArkAppServerConfig", 0);
    }
    return BaseApplication.getContext().getSharedPreferences("ArkAppServerConfigDebug", 0);
  }
  
  private static String a(int paramInt)
  {
    String str = e();
    if (paramInt == 1) {
      return str + "/ArkAppTest";
    }
    return str + "/ArkApp";
  }
  
  private static SharedPreferences b(int paramInt)
  {
    if (paramInt == 2) {
      return BaseApplication.getContext().getSharedPreferences("ArkAppCacheConfig", 0);
    }
    return BaseApplication.getContext().getSharedPreferences("ArkAppCacheConfigDebug", 0);
  }
  
  private static String b(int paramInt)
  {
    String str = e();
    if (paramInt == 1) {
      return str + "/pddata/prd/arkapp/test";
    }
    return str + "/pddata/prd/arkapp";
  }
  
  private static String e()
  {
    return BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString + "/Dict";
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString + "/Debug";
  }
  
  public String d()
  {
    return this.jdField_a_of_type_JavaLangString + "/Crash";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     altf
 * JD-Core Version:    0.7.0.1
 */