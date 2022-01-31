import android.text.TextUtils;
import java.lang.reflect.Method;

public class ahis
{
  public static String a()
  {
    if (a()) {
      return a("ro.miui.ui.version.name", "");
    }
    return "";
  }
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString1 = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
  
  public static boolean a()
  {
    return !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""));
  }
  
  public static String b()
  {
    if (c()) {
      return a("ro.build.version.emui", "");
    }
    return "";
  }
  
  public static boolean b()
  {
    String str = a();
    try
    {
      if (!str.isEmpty())
      {
        int i = Integer.valueOf(str.substring(1)).intValue();
        if (i >= 6) {
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public static String c()
  {
    if (e()) {
      return a("ro.build.display.id", "");
    }
    return "";
  }
  
  public static boolean c()
  {
    return !TextUtils.isEmpty(a("ro.build.version.emui", ""));
  }
  
  private static String d()
  {
    return a("ro.build.display.id", "");
  }
  
  public static boolean d()
  {
    String str = b();
    return ("EmotionUI 3".equals(str)) || (str.contains("EmotionUI_3.1"));
  }
  
  public static boolean e()
  {
    return d().toLowerCase().contains("flyme");
  }
  
  public static boolean f()
  {
    String str = c();
    int i;
    try
    {
      if (!str.isEmpty()) {
        if (str.toLowerCase().contains("os")) {
          i = Integer.valueOf(str.substring(9, 10)).intValue();
        } else {
          i = Integer.valueOf(str.substring(6, 7)).intValue();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    while (i < 4) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ahis
 * JD-Core Version:    0.7.0.1
 */