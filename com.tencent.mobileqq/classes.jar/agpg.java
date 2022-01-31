import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.MD5;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import java.util.LinkedList;
import mqq.app.AppRuntime;

public abstract class agpg
{
  public static boolean b = TextUtils.isEmpty(d());
  public AppRuntime a;
  
  public agpg(AppRuntime paramAppRuntime)
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
    String str = d();
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
        agqh.a(paramString, paramInt, NetConnInfoCenter.getServerTimeMillis());
        return str;
      }
    }
    return null;
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    return e() + paramAppRuntime.getAccount() + "/" + ".preloaduni" + "/";
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString)
  {
    return a(paramAppRuntime) + paramString;
  }
  
  public static String b()
  {
    return e() + ".preloaduni" + "/";
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
      String str2 = f();
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2 + ".preloaduni" + "/";
      }
      return str1;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static String d()
  {
    String str1 = null;
    try
    {
      String str2 = g();
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2 + ".preloaduni" + "/";
      }
      return str1;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  protected static String e()
  {
    return BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/QWallet/";
  }
  
  public static String e(String paramString)
  {
    return a(paramString, 0);
  }
  
  protected static String f()
  {
    String str = null;
    if (bace.a()) {
      str = Environment.getExternalStorageDirectory().getPath() + "/tencent/QWallet/";
    }
    return str;
  }
  
  public static String f(String paramString)
  {
    return b(paramString, 0);
  }
  
  protected static String g()
  {
    String str = null;
    if (bace.a()) {
      str = QWalletHelper.getQWalletExternalPath();
    }
    return str;
  }
  
  public abstract void a(DownloadParam paramDownloadParam, agpe paramagpe);
  
  public abstract void a(LinkedList<DownloadParam> paramLinkedList, agpf paramagpf);
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramString = paramString.split("\\|");
    int j = badq.a(this.a.getApplication());
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
  
  public void c(String paramString, agpe paramagpe)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.url = paramString;
    a(localDownloadParam, paramagpe);
  }
  
  public String d(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agpg
 * JD-Core Version:    0.7.0.1
 */