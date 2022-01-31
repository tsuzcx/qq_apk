import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aisj
{
  public static int a;
  public static String a;
  public static boolean a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  
  static
  {
    b(null);
  }
  
  private static void b(JSONObject paramJSONObject)
  {
    int j = 1;
    boolean bool = true;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_app3d_config", 0);
    if (paramJSONObject == null)
    {
      if (localSharedPreferences.getInt("show", 0) == 1) {}
      for (;;)
      {
        jdField_a_of_type_Boolean = bool;
        jdField_a_of_type_JavaLangString = localSharedPreferences.getString("packageName", null);
        b = localSharedPreferences.getString("downloadUrl", "");
        c = localSharedPreferences.getString("iconUrl", "");
        d = localSharedPreferences.getString("progressUrl", "");
        e = localSharedPreferences.getString("md5", "");
        f = localSharedPreferences.getString("apkSize", "");
        jdField_a_of_type_Int = localSharedPreferences.getInt("versionCode", 0);
        h = localSharedPreferences.getString("apkSign", "");
        i = localSharedPreferences.getString("appName", "");
        g = localSharedPreferences.getString("appId", "");
        return;
        bool = false;
      }
    }
    if (paramJSONObject.optInt("show") == 1)
    {
      bool = true;
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaLangString = paramJSONObject.optString("packageName");
      b = paramJSONObject.optString("downloadUrl");
      c = paramJSONObject.optString("iconUrl");
      d = paramJSONObject.optString("progressUrl");
      e = paramJSONObject.optString("md5");
      f = paramJSONObject.optString("apkSize");
      jdField_a_of_type_Int = paramJSONObject.optInt("versionCode");
      h = paramJSONObject.optString("apkSign");
      i = paramJSONObject.optString("appName");
      g = paramJSONObject.optString("appId");
      if ((TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(b)) || (TextUtils.isEmpty(c)) || (TextUtils.isEmpty(g)))
      {
        jdField_a_of_type_Boolean = false;
        QLog.w("ApolloManager", 1, "App3DConfig pa");
      }
      paramJSONObject = localSharedPreferences.edit();
      if (!jdField_a_of_type_Boolean) {
        break label457;
      }
    }
    for (;;)
    {
      paramJSONObject.putInt("show", j).putString("packageName", jdField_a_of_type_JavaLangString).putString("downloadUrl", b).putString("md5", e).putString("iconUrl", c).putString("progressUrl", d).putString("apkSize", f).putInt("versionCode", jdField_a_of_type_Int).putString("apkSign", h).putString("appName", i).putString("appId", g).commit();
      return;
      bool = false;
      break;
      label457:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aisj
 * JD-Core Version:    0.7.0.1
 */