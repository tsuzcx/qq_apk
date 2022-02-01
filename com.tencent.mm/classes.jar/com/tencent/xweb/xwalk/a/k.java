package com.tencent.xweb.xwalk.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.w.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public final class k
  implements w.a
{
  private String SHX = "";
  private j SHY = null;
  private l SHZ = null;
  
  public static void OY(long paramLong)
  {
    AppMethodBeat.i(154509);
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localObject == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "set time sp is null");
      AppMethodBeat.o(154509);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("nLastFetchPluginConfigTime", paramLong);
    ((SharedPreferences.Editor)localObject).commit();
    AppMethodBeat.o(154509);
  }
  
  public static boolean hvr()
  {
    AppMethodBeat.i(154510);
    Object localObject1 = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localObject1 == null)
    {
      AppMethodBeat.o(154510);
      return false;
    }
    int i = ((SharedPreferences)localObject1).getInt("nUpdatingProcessId", -1);
    if (i < 0)
    {
      AppMethodBeat.o(154510);
      return false;
    }
    int j = Process.myPid();
    int k = Process.myUid();
    if (i == j)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "current process is updating plugin");
      AppMethodBeat.o(154510);
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
              AppMethodBeat.o(154510);
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
      hvs();
      AppMethodBeat.o(154510);
    }
    return false;
  }
  
  public static void hvs()
  {
    AppMethodBeat.i(154511);
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(154511);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).remove("nUpdatingProcessId");
    ((SharedPreferences.Editor)localObject).commit();
    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "plugin update progress finish");
    AppMethodBeat.o(154511);
  }
  
  public final void a(String paramString, j paramj)
  {
    this.SHX = paramString;
    this.SHY = paramj;
  }
  
  public final void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154508);
    try
    {
      this.SHZ = new l();
      this.SHZ.a(paramHashMap, this.SHX, this.SHY);
      this.SHZ.execute(new String[0]);
      this.SHX = "";
      this.SHY = null;
      return;
    }
    finally
    {
      AppMethodBeat.o(154508);
    }
  }
  
  public final void hsE()
  {
    AppMethodBeat.i(207341);
    if (this.SHZ != null) {
      this.SHZ.b(4, -1, null);
    }
    AppMethodBeat.o(207341);
  }
  
  public final boolean isBusy()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.SHZ != null)
    {
      bool1 = bool2;
      if (!this.SHZ.SIi) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.k
 * JD-Core Version:    0.7.0.1
 */