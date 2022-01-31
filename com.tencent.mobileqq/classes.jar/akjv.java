import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class akjv
{
  public static int a;
  public static String a;
  public static boolean a;
  public static int b;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  
  static {}
  
  private static void a()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_app3d_config", 0);
    if (localSharedPreferences.getInt("show", 0) == 1) {}
    for (;;)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaLangString = localSharedPreferences.getString("packageName", null);
      jdField_b_of_type_JavaLangString = localSharedPreferences.getString("downloadUrl", "");
      c = localSharedPreferences.getString("iconUrl", "");
      d = localSharedPreferences.getString("progressUrl", "");
      e = localSharedPreferences.getString("md5", "");
      f = localSharedPreferences.getString("apkSize", "");
      jdField_a_of_type_Int = localSharedPreferences.getInt("versionCode", 0);
      h = localSharedPreferences.getString("apkSign", "");
      i = localSharedPreferences.getString("appName", "");
      g = localSharedPreferences.getString("appId", "");
      jdField_b_of_type_Int = localSharedPreferences.getInt("adId", 0);
      j = localSharedPreferences.getString("traceInfo", "");
      return;
      bool = false;
    }
  }
  
  private static void b(Map<String, String> paramMap, int paramInt, String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_app3d_config", 0);
    try
    {
      boolean bool;
      if (Integer.parseInt((String)paramMap.get("show")) == 1)
      {
        bool = true;
        jdField_a_of_type_Boolean = bool;
        jdField_a_of_type_JavaLangString = (String)paramMap.get("packageName");
        jdField_b_of_type_JavaLangString = (String)paramMap.get("downloadUrl");
        c = (String)paramMap.get("iconUrl");
        d = (String)paramMap.get("progressUrl");
        e = (String)paramMap.get("md5");
        f = (String)paramMap.get("apkSize");
        jdField_a_of_type_Int = Integer.parseInt((String)paramMap.get("versionCode"));
        h = (String)paramMap.get("apkSign");
        i = (String)paramMap.get("appName");
        g = (String)paramMap.get("appId");
        jdField_b_of_type_Int = paramInt;
        j = paramString;
        if ((TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(c)) || (TextUtils.isEmpty(g)))
        {
          jdField_a_of_type_Boolean = false;
          QLog.w("ApolloManager", 1, "App3DConfig parse invalid param");
        }
        paramMap = localSharedPreferences.edit();
        if (!jdField_a_of_type_Boolean) {
          break label391;
        }
      }
      label391:
      for (paramInt = 1;; paramInt = 0)
      {
        paramMap.putInt("show", paramInt).putString("packageName", jdField_a_of_type_JavaLangString).putString("downloadUrl", jdField_b_of_type_JavaLangString).putString("md5", e).putString("iconUrl", c).putString("progressUrl", d).putString("apkSize", f).putInt("versionCode", jdField_a_of_type_Int).putString("apkSign", h).putString("appName", i).putString("appId", g).putInt("adId", jdField_b_of_type_Int).putString("traceInfo", j).commit();
        return;
        bool = false;
        break;
      }
      return;
    }
    catch (Throwable paramMap)
    {
      QLog.e("ApolloManager", 1, "App3DConfig parse error:", paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjv
 * JD-Core Version:    0.7.0.1
 */