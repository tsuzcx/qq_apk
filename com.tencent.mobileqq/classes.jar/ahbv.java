import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.util.LinkedList;
import mqq.app.AppRuntime;

public abstract class ahbv
{
  public static boolean b = TextUtils.isEmpty(c());
  public AppRuntime a;
  
  public ahbv(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      if (paramString.equalsIgnoreCase("WiFi")) {
        return 1;
      }
      if (paramString.equalsIgnoreCase("4G")) {
        return 4;
      }
      if (paramString.equalsIgnoreCase("3G")) {
        return 3;
      }
      if (paramString.equalsIgnoreCase("2G")) {
        return 2;
      }
    } while (!paramString.equalsIgnoreCase("5G"));
    return 6;
  }
  
  public static String a()
  {
    return a(0);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 1) {
      return b();
    }
    String str = c();
    if (!TextUtils.isEmpty(str))
    {
      b = false;
      return str;
    }
    b = true;
    return b();
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = b(paramString, paramInt);
      if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
      {
        ahcw.a(paramString, paramInt, NetConnInfoCenter.getServerTimeMillis());
        return str;
      }
    }
    return null;
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    return ahje.c + paramAppRuntime.getAccount() + "/" + ".preloaduni" + "/";
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString)
  {
    return a(paramAppRuntime) + paramString;
  }
  
  public static String b()
  {
    return ahje.c + ".preloaduni" + "/";
  }
  
  public static String b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = MD5.toMD5(paramString);
    return a(paramInt) + paramString;
  }
  
  public static String c()
  {
    String str1 = null;
    try
    {
      String str2 = ahje.a;
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2 + ".preloaduni" + "/";
      }
      return str1;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static String e(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static String f(String paramString)
  {
    return b(paramString, 0);
  }
  
  public abstract void a(DownloadParam paramDownloadParam, ahbt paramahbt);
  
  public abstract void a(LinkedList<DownloadParam> paramLinkedList, ahbu paramahbu);
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramString = paramString.split("\\|");
    int j = bbev.a(this.a.getApplication());
    int k = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label57;
      }
      if (a(paramString[i]) == j) {
        break;
      }
      i += 1;
    }
    label57:
    return false;
  }
  
  public void c(String paramString, ahbt paramahbt)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.url = paramString;
    a(localDownloadParam, paramahbt);
  }
  
  public String d(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahbv
 * JD-Core Version:    0.7.0.1
 */