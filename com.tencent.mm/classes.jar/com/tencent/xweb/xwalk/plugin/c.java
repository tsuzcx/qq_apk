package com.tencent.xweb.xwalk.plugin;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.xweb.i.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public final class c
  implements i.a
{
  public String xmt = "";
  public c.b xmu = null;
  public d xmv = null;
  
  public static boolean cTH()
  {
    Object localObject1 = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localObject1 == null) {
      return false;
    }
    int i = ((SharedPreferences)localObject1).getInt("nUpdatingProcessId", -1);
    if (i < 0) {
      return false;
    }
    int j = Process.myPid();
    int k = Process.myUid();
    if (i == j)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "current process is updating plugin");
      return true;
    }
    localObject1 = (ActivityManager)XWalkEnvironment.getApplicationContext().getSystemService("activity");
    try
    {
      localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
          if (localRunningAppProcessInfo.pid == i) {
            if (localRunningAppProcessInfo.uid == k)
            {
              XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "other process is in updating plugin progress");
              return true;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("XWalkPluginUp", localException.getMessage());
        Object localObject2 = null;
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "plugin update process pid invalid, clear");
      cTI();
    }
    return false;
  }
  
  public static void cTI()
  {
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).remove("nUpdatingProcessId");
    ((SharedPreferences.Editor)localObject).commit();
    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "plugin update progress finish");
  }
  
  public static void iB(long paramLong)
  {
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localObject == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "set time sp is null");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("nLastFetchPluginConfigTime", paramLong);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public final void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    this.xmv = new d();
    paramContext = this.xmv;
    String str = this.xmt;
    c.b localb = this.xmu;
    if (paramHashMap != null)
    {
      paramHashMap = (String)paramHashMap.get("UpdaterCheckType");
      if ((paramHashMap != null) && (paramHashMap.equals("1"))) {
        iB(0L);
      }
    }
    paramContext.xmt = str;
    paramContext.xmu = localb;
    this.xmv.execute(new String[0]);
    this.xmt = "";
    this.xmu = null;
  }
  
  public final boolean isBusy()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.xmv != null)
    {
      bool1 = bool2;
      if (!this.xmv.xmG) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.plugin.c
 * JD-Core Version:    0.7.0.1
 */