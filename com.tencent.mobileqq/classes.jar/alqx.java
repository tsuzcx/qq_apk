import android.os.Build;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class alqx
{
  public static String a;
  private static List<String> jdField_a_of_type_JavaUtilList;
  public static Map<String, List<alqy>> a;
  public static boolean a;
  public static volatile boolean b;
  public static volatile boolean c;
  public static boolean d;
  public static boolean e;
  public static boolean f;
  public static boolean g;
  public static boolean h;
  public static boolean i;
  public static boolean j;
  private alri jdField_a_of_type_Alri;
  private alrl jdField_a_of_type_Alrl;
  private ArkAppCenter jdField_a_of_type_ComTencentMobileqqArkArkAppCenter;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    f = true;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilList = new ArrayList();
    if (Build.MODEL.contains("Android SDK built for x86")) {
      c = true;
    }
    String str1 = Build.CPU_ABI;
    String str2 = Build.CPU_ABI2;
    if ((!c) && ((a(str1).booleanValue()) || (a(str2).booleanValue()))) {
      jdField_b_of_type_Boolean = true;
    }
  }
  
  public alqx(ArkAppCenter paramArkAppCenter)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter = paramArkAppCenter;
    Object localObject = amqq.b(159).a();
    if ((localObject != null) && (((amqo)localObject).a() != null))
    {
      localObject = ((amqo)localObject).a();
      jdField_a_of_type_Boolean = ((amri)localObject).jdField_a_of_type_Boolean;
      f = ((amri)localObject).jdField_b_of_type_Boolean;
    }
    this.jdField_a_of_type_Alri = new alri(paramArkAppCenter.b());
    this.jdField_a_of_type_Alrl = new alrl(paramArkAppCenter.b());
    d();
    a();
    paramArkAppCenter = amqq.b(186).a();
    if ((paramArkAppCenter != null) && (paramArkAppCenter.a() != null))
    {
      ArkAppCenter.c("ArkApp.AI", "ArkAiAppCenter updateDialogConfig content =" + paramArkAppCenter.a());
      a(paramArkAppCenter.a());
    }
  }
  
  private static Boolean a(String paramString)
  {
    if ((paramString.equalsIgnoreCase("armeabi-v7a")) || (paramString.equalsIgnoreCase("arm64-v8a"))) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (localAppRuntime == null) {
      return "";
    }
    return localAppRuntime.getAccount();
  }
  
  public static String a(String paramString)
  {
    return bbax.a(BaseApplication.getContext(), paramString + a());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    bbax.a(BaseApplication.getContext(), paramString1 + a(), paramString2);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "open";; str = "close")
    {
      bbax.a(BaseApplication.getContext(), "ark_use_android_http_" + a(), str);
      return;
    }
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = "open".equals(bbax.a(BaseApplication.getContext(), "ark_use_android_http_" + a()));
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilList.contains(paramString);
  }
  
  public static void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "open";; str = "close") {
      try
      {
        bbax.a(BaseApplication.getContext(), "ark_support_android9_emoji", str);
        return;
      }
      catch (Exception localException)
      {
        ArkAppCenter.c("ArkApp.AI", "setAndroid9EmojiSupportState exception: " + localException.getMessage());
      }
    }
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = "open".equals(bbax.a(BaseApplication.getContext(), "ark_support_android9_emoji"));
      return bool;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkApp.AI", "getAndroid9EmojiSupportState exception: " + localException.getMessage());
    }
    return false;
  }
  
  private void d()
  {
    alri.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter.b());
  }
  
  public void a()
  {
    this.jdField_a_of_type_Alrl.a();
  }
  
  public void a(amrn paramamrn)
  {
    if (paramamrn == null)
    {
      ArkAppCenter.c("ArkApp.AI", String.format("updateDialogConfig,dialogConfig is null", new Object[0]));
      return;
    }
    e = paramamrn.jdField_a_of_type_Boolean;
    d = this.jdField_a_of_type_Alrl.a(paramamrn.jdField_b_of_type_JavaLangString);
    g = paramamrn.jdField_b_of_type_Boolean;
    a(g);
    if (ArkAppCenter.jdField_b_of_type_Boolean) {
      ark.SetUseAndroidHTTP(g);
    }
    h = paramamrn.c;
    b(h);
    if (ArkAppCenter.jdField_b_of_type_Boolean) {
      ark.arkSetAndroid9EmojiFeatureSupport(h);
    }
    i = paramamrn.d;
    Object localObject;
    if (i) {
      localObject = "true";
    }
    for (;;)
    {
      a("ark_engine_multi_thread", (String)localObject);
      jdField_a_of_type_JavaLangString = paramamrn.jdField_a_of_type_JavaLangString;
      boolean bool;
      if (ArkAppCenter.jdField_b_of_type_Boolean)
      {
        localObject = ArkEnvironmentManager.getInstance();
        if (i) {
          break label183;
        }
        bool = true;
        ((ArkEnvironmentManager)localObject).setSingleThreadMode(bool);
        ArkEnvironmentManager.getInstance().setThreadMode();
      }
      try
      {
        localObject = new JSONObject(jdField_a_of_type_JavaLangString);
        ArkEnvironmentManager.getInstance().setHardwareDisableList((JSONObject)localObject);
        j = paramamrn.e;
        return;
        localObject = "false";
        continue;
        label183:
        bool = false;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ArkAppCenter.c("ArkApp.AI", String.format("updateDialogConfig, parse json failed, err=%s", new Object[] { localJSONException.getMessage() }));
        }
      }
    }
  }
  
  public void b()
  {
    alri localalri = this.jdField_a_of_type_Alri;
    alri.b(this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter.a());
  }
  
  public void c()
  {
    this.jdField_a_of_type_Alri.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alqx
 * JD-Core Version:    0.7.0.1
 */