import android.content.SharedPreferences;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class aler
{
  private static final aler jdField_a_of_type_Aler = new aler(1);
  private static boolean jdField_a_of_type_Boolean;
  private static final aler jdField_b_of_type_Aler = new aler(2);
  private static aler jdField_c_of_type_Aler = jdField_b_of_type_Aler;
  private final int jdField_a_of_type_Int;
  private final SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private final String jdField_a_of_type_JavaLangString;
  private final SharedPreferences jdField_b_of_type_AndroidContentSharedPreferences;
  private final String jdField_b_of_type_JavaLangString;
  private final String jdField_c_of_type_JavaLangString;
  private final String d;
  
  private aler(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = a(paramInt);
    this.jdField_c_of_type_JavaLangString = b(paramInt);
    this.d = c(paramInt);
    this.jdField_a_of_type_AndroidContentSharedPreferences = a(paramInt);
    this.jdField_b_of_type_AndroidContentSharedPreferences = b(paramInt);
    if (paramInt == 1)
    {
      this.jdField_b_of_type_JavaLangString = "test.ark.qq.com";
      return;
    }
    this.jdField_b_of_type_JavaLangString = "cgi.ark.qq.com";
  }
  
  public static aler a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      ArkAppCenter.c("ArkApp", "ArkTemp.getCurrent sso env isTestEnv=" + false);
    }
    jdField_c_of_type_Aler = jdField_b_of_type_Aler;
    return jdField_c_of_type_Aler;
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
    if (a()) {}
    for (String str = ajed.aU;; str = f()) {
      switch (paramInt)
      {
      default: 
        return str + "/ArkApp";
      }
    }
    return str + "/ArkAppTest";
    return str + "/ArkApp";
  }
  
  private static boolean a()
  {
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      return bool;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkApp", String.format("getRootDirectoryByEnvType, getExternalStorageState fail, msg=%s", new Object[] { localException.getMessage() }));
    }
    return false;
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
    switch (paramInt)
    {
    default: 
      return f() + "/ArkApp";
    case 1: 
      if (a()) {}
      for (String str = ajed.aU;; str = f()) {
        return str + "/ArkAppTest";
      }
    }
    return f() + "/ArkApp";
  }
  
  private static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return f() + "/pddata/prd/arkapp";
    case 1: 
      if (a()) {}
      for (String str = ajed.aU;; str = f()) {
        return str + "/ArkAppTest";
      }
    }
    return f() + "/pddata/prd/arkapp";
  }
  
  private static String f()
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
    return this.jdField_c_of_type_JavaLangString + "/Install";
  }
  
  public String c()
  {
    return this.d + "/Dict";
  }
  
  public String d()
  {
    return this.jdField_c_of_type_JavaLangString + "/Debug";
  }
  
  public String e()
  {
    return this.jdField_a_of_type_JavaLangString + "/Crash";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aler
 * JD-Core Version:    0.7.0.1
 */