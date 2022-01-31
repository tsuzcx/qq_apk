package com.tencent.xweb.xwalk.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Process;
import com.tencent.xweb.XWebCoreContentProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.ErrorInfo;

public final class e
  extends AsyncTask<String, Integer, Integer>
{
  static XWalkUpdater xmq;
  private static String xnp = "0";
  private HashMap<String, String> xno;
  
  public e(XWalkUpdater paramXWalkUpdater, HashMap<String, String> paramHashMap)
  {
    xmq = paramXWalkUpdater;
    this.xno = paramHashMap;
    if (paramHashMap != null)
    {
      paramXWalkUpdater = (String)paramHashMap.get("UpdaterCheckType");
      xnp = paramXWalkUpdater;
      if ((paramXWalkUpdater == null) || (!xnp.equals("1"))) {
        break label74;
      }
      c.cTK().cTO();
    }
    for (;;)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdateChecker notify received !! mNotifyType = " + xnp);
      return;
      label74:
      xnp = "0";
    }
  }
  
  public static void KK(int paramInt)
  {
    cTV();
    c.KK(paramInt);
  }
  
  private static boolean b(c.a parama)
  {
    if (cTT()) {}
    label248:
    do
    {
      do
      {
        return false;
        XWalkUpdater.ErrorInfo localErrorInfo;
        if (!XWalkEnvironment.isSelfProvider())
        {
          cTU();
          localErrorInfo = xmq.updateRuntimeFromProvider(parama);
          try
          {
            Object localObject = XWalkEnvironment.getPackageName();
            String str = localErrorInfo.errorCode + "," + (String)localObject + "," + localErrorInfo.targetVer + "," + localErrorInfo.readFileListFailedCount + "," + localErrorInfo.noMatchedVersionCount + "," + localErrorInfo.copyFailedCount + "," + localErrorInfo.md5FailedCount + "," + localErrorInfo.extractFailedCount + "," + localErrorInfo.setVersionFailedCount + "," + localErrorInfo.extractRetryFailedCount;
            ContentResolver localContentResolver = XWalkEnvironment.getContentResolver();
            if (localContentResolver != null)
            {
              localObject = XWebCoreContentProvider.b("com.tencent.mm", (String)localObject, 3, 0, "");
              ContentValues localContentValues = new ContentValues();
              localContentValues.put("15626", str);
              localContentResolver.insert((Uri)localObject, localContentValues);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              XWalkInitializer.addXWalkInitializeLog("_doStartUpdate report error");
            }
            if (localErrorInfo.errorCode != -10) {
              break label248;
            }
            int i = localErrorInfo.errorCode;
            cTV();
            c.KK(i);
            return false;
            cTV();
          }
          if (localErrorInfo.errorCode == 0)
          {
            cTW();
            return true;
          }
        }
        XWalkInitializer.addXWalkInitializeLog("_doStartUpdate go on");
      } while (!NetworkUtil.isNetworkAvailable());
      if ((!parama.xmT) && (!NetworkUtil.isWifiAvailable()))
      {
        XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
        return false;
      }
    } while (!xmq.updateXWalkRuntime(parama.cTS()));
    cTU();
    return true;
  }
  
  static void c(c.a parama)
  {
    if (parama != null)
    {
      if (XWalkEnvironment.hasAvailableVersion()) {
        break label21;
      }
      XWalkInitializer.addXWalkInitializeLog("no availableversion installed, do start download ");
      b(parama);
    }
    label21:
    while (parama.xnh > System.currentTimeMillis()) {
      return;
    }
    b(parama);
  }
  
  public static boolean cTT()
  {
    int i = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getInt("UpdatingProcessId", -1);
    if (i == Process.myPid())
    {
      XWalkInitializer.addXWalkInitializeLog("current process is in updating progress");
      return true;
    }
    if (i < 0) {
      return false;
    }
    Object localObject = (ActivityManager)XWalkEnvironment.getApplicationContext().getSystemService("activity");
    Process.myPid();
    int j = Process.myUid();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid == i) {
        if (localRunningAppProcessInfo.uid == j)
        {
          XWalkInitializer.addXWalkInitializeLog("some process is in updating progress");
          return true;
        }
      }
    }
    cTV();
    return false;
  }
  
  public static void cTU()
  {
    int i = Process.myPid();
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putInt("UpdatingProcessId", i);
    localEditor.commit();
    XWalkInitializer.addXWalkInitializeLog("start updating progress");
  }
  
  public static void cTV()
  {
    Process.myPid();
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.remove("UpdatingProcessId");
    localEditor.commit();
    XWalkInitializer.addXWalkInitializeLog("finish updating progress");
  }
  
  public static void cTW()
  {
    XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    cTV();
    c.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.e
 * JD-Core Version:    0.7.0.1
 */