package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import com.tencent.xweb.util.a;
import java.io.File;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.FileListMD5Checker;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

public class l
  implements XWalkInitializer.XWalkInitListener, XWalkUpdater.XWalkBackgroundUpdateListener
{
  static l xmo;
  protected Context mContext;
  XWalkInitializer xmp;
  XWalkUpdater xmq;
  
  public l(Context paramContext)
  {
    this.mContext = paramContext;
    this.xmp = new XWalkInitializer(this, paramContext);
    this.xmq = new XWalkUpdater(this, paramContext);
  }
  
  private static File KI(int paramInt)
  {
    try
    {
      File localFile1 = new File(XWalkEnvironment.getPatchFileListConfig(paramInt));
      if (localFile1.exists()) {
        return localFile1;
      }
      localFile1 = new File(XWalkEnvironment.getDownloadZipFileListConfig(paramInt));
      boolean bool = localFile1.exists();
      if (!bool) {
        return null;
      }
    }
    catch (Exception localException)
    {
      File localFile2 = null;
      return localFile2;
    }
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (xmo == null) {
      xmo = new l(paramContext);
    }
    ox(false);
    y(paramContext, false);
    xmo.o(paramHashMap);
  }
  
  private static int ao(File paramFile)
  {
    if (paramFile == null) {}
    String str;
    do
    {
      return -1;
      str = paramFile.getName();
    } while ((str == null) || (!str.startsWith("app_xwalk_")) || (!paramFile.isDirectory()));
    paramFile = str.substring(10);
    try
    {
      int i = Integer.parseInt(paramFile);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("XWalkUpdaterImp", "get apk version strApkVer  is " + paramFile);
    }
    return -1;
  }
  
  public static boolean isBusy()
  {
    if (xmo == null) {
      return false;
    }
    return com.tencent.xweb.xwalk.a.e.cTT();
  }
  
  public static void ox(boolean paramBoolean)
  {
    int i = XWalkEnvironment.getAvailableVersion();
    if (i <= 0) {}
    SharedPreferences localSharedPreferences;
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        localSharedPreferences = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
      } while (localSharedPreferences == null);
      l1 = localSharedPreferences.getLong("CHECK_FILES_MD5_TIME", 0L);
      l2 = System.currentTimeMillis();
    } while ((!paramBoolean) && (l2 >= l1) && (l2 - l1 <= 7200000L));
    localSharedPreferences.edit().putLong("CHECK_FILES_MD5_TIME", l2).commit();
    File localFile = KI(i);
    if (localFile == null)
    {
      Log.e("XWalkUpdaterImp", "checkfiles no config file");
      return;
    }
    if (XWalkUpdater.FileListMD5Checker.checkFileListMd5(i, localFile))
    {
      localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", i).commit();
      Log.i("XWalkUpdaterImp", "checkfiles sucsess");
      return;
    }
    int j = localSharedPreferences.getInt("LAST_CHECK_VERSION", -1);
    localSharedPreferences.edit().putInt("LAST_CHECK_VERSION", -1).commit();
    if (j != i)
    {
      com.tencent.xweb.util.e.it(64L);
      XWalkEnvironment.addXWalkInitializeLog("", "some files corrupted at first time, set version to -1");
    }
    for (;;)
    {
      XWalkEnvironment.setAvailableVersion(-1, null);
      com.tencent.xweb.util.e.it(63L);
      return;
      XWalkEnvironment.addXWalkInitializeLog("", "some files corrupted, set version to -1");
    }
  }
  
  public static void y(Context paramContext, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
    if (localSharedPreferences == null) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = localSharedPreferences.getLong("LAST_TRY_CLEAR_APK_TIME", 0L);
      l2 = System.currentTimeMillis();
    } while ((!paramBoolean) && (l2 >= l1) && (l2 - l1 <= 259200000L));
    if (paramContext != null) {}
    int k;
    int j;
    int m;
    for (;;)
    {
      try
      {
        if (paramContext.getApplicationInfo() != null)
        {
          str = paramContext.getApplicationInfo().dataDir;
          if (str != null) {
            continue;
          }
        }
      }
      catch (Exception paramContext)
      {
        String str;
        int n;
        int i;
        Log.e("XWalkUpdaterImp", "tryClearOldXWebCore failed " + paramContext.getMessage());
        continue;
      }
      localSharedPreferences.edit().putLong("LAST_TRY_CLEAR_APK_TIME", l2).commit();
      return;
      paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
      if (paramContext != null)
      {
        n = paramContext.length;
        k = 0;
        j = 0;
        i = 0;
        if (k < n)
        {
          m = ao(paramContext[k]);
          if (m < 0) {
            break label333;
          }
          if (m < i) {
            break label342;
          }
          j = i;
          i = m;
          break label333;
        }
        k = paramContext.length;
        i = 0;
        while (i < k)
        {
          str = paramContext[i];
          m = ao(str);
          if ((m > 0) && (m < j))
          {
            n = XWalkEnvironment.getAvailableVersion();
            if (m == n) {}
          }
          try
          {
            a.agX(str.getAbsolutePath());
            XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "cleared version = " + m);
            com.tencent.xweb.util.e.f(577L, 65L, 1);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", " FileUtils.deleteAll failed " + localException.getMessage());
              com.tencent.xweb.util.e.f(577L, 66L, 1);
            }
          }
        }
      }
    }
    for (;;)
    {
      label333:
      k += 1;
      break;
      label342:
      if (m >= j) {
        j = m;
      }
    }
  }
  
  public final boolean o(HashMap<String, String> paramHashMap)
  {
    new com.tencent.xweb.xwalk.a.e(this.xmq, paramHashMap).execute(new String[0]);
    return false;
  }
  
  public void onXWalkInitCancelled() {}
  
  public void onXWalkInitCompleted() {}
  
  public void onXWalkInitFailed() {}
  
  public void onXWalkInitStarted() {}
  
  public void onXWalkUpdateCancelled() {}
  
  public void onXWalkUpdateCompleted() {}
  
  public void onXWalkUpdateFailed(int paramInt)
  {
    com.tencent.xweb.xwalk.a.e.KK(paramInt);
  }
  
  public void onXWalkUpdateProgress(int paramInt) {}
  
  public void onXWalkUpdateStarted() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.l
 * JD-Core Version:    0.7.0.1
 */