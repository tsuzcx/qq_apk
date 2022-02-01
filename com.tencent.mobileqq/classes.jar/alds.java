import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import mqq.app.AppRuntime;

public abstract class alds
{
  public static boolean b = TextUtils.isEmpty(c());
  public AppRuntime a;
  
  public alds(AppRuntime paramAppRuntime)
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
  
  public static PreloadManager.PathResult a(DownloadParam paramDownloadParam)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManager", 2, "getResPathSync: param" + paramDownloadParam);
      }
      if ((paramDownloadParam == null) || (TextUtils.isEmpty(paramDownloadParam.url))) {
        return null;
      }
      paramDownloadParam.standardlize();
      localObject = PreloadManager.a(paramDownloadParam.url, paramDownloadParam.isForceUnzip, paramDownloadParam.filePos);
      if (PreloadManager.a((ResourceInfo)localObject, paramDownloadParam))
      {
        PreloadManager.PathResult localPathResult = new PreloadManager.PathResult();
        localPathResult.url = paramDownloadParam.url;
        localPathResult.filePath = ((ResourceInfo)localObject).filePath;
        localPathResult.folderPath = ((ResourceInfo)localObject).folderPath;
        localPathResult.isAlreadyExist = true;
        return localPathResult;
      }
      return null;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("method_type", 4);
    ((Bundle)localObject).putSerializable("download_params", paramDownloadParam);
    paramDownloadParam = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "preloadCommon", (Bundle)localObject);
    if ((paramDownloadParam != null) && (paramDownloadParam.isSuccess()) && (paramDownloadParam.data != null)) {
      try
      {
        paramDownloadParam = (PreloadManager.PathResult)paramDownloadParam.data.getSerializable("path_result");
        return paramDownloadParam;
      }
      catch (Throwable paramDownloadParam) {}
    }
    return null;
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
        alev.a(paramString, paramInt, NetConnInfoCenter.getServerTimeMillis());
        return str;
      }
    }
    return null;
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    return alir.c + paramAppRuntime.getAccount() + "/" + ".preloaduni" + "/";
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString)
  {
    return a(paramAppRuntime) + paramString;
  }
  
  public static String b()
  {
    return alir.c + ".preloaduni" + "/";
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
      String str2 = alir.a;
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2 + ".preloaduni" + "/";
      }
      return str1;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static String f(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static String g(String paramString)
  {
    return b(paramString, 0);
  }
  
  public abstract void a(DownloadParam paramDownloadParam, aldq paramaldq);
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramString = paramString.split("\\|");
    int j = bhnv.a(this.a.getApplication());
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
  
  public void c(String paramString, aldq paramaldq)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.url = paramString;
    a(localDownloadParam, paramaldq);
  }
  
  public String e(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alds
 * JD-Core Version:    0.7.0.1
 */