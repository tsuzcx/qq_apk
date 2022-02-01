import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class abue
{
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      bjqp.a("GameCenterSpUtils", "getStringOutAccount fail, group=" + paramString1 + ",key=" + paramString2);
      return "";
    }
    String str = BaseApplicationImpl.sApplication.getSharedPreferences(paramString1, 4).getString(paramString2, "");
    bjqp.c("GameCenterSpUtils", "getStringOutAccount group=" + paramString1 + ",key=" + paramString2 + ",value=" + str);
    return str;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      bjqp.a("GameCenterSpUtils", "setStringOutAccount fail, group=" + paramString1 + ",key=" + paramString2 + ",value=" + paramString3);
      return;
    }
    boolean bool = BaseApplicationImpl.sApplication.getSharedPreferences(paramString1, 4).edit().putString(paramString2, paramString3).commit();
    bjqp.c("GameCenterSpUtils", "setStringOutAccount group=" + paramString1 + ",key=" + paramString2 + ",value=" + paramString3 + ",ret=" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abue
 * JD-Core Version:    0.7.0.1
 */