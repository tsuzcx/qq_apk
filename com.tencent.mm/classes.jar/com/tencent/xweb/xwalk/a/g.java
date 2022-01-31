package com.tencent.xweb.xwalk.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.o.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public final class g
  implements o.a
{
  public String BKs = "";
  public a BKt = null;
  public h BKu = null;
  
  public static boolean eas()
  {
    AppMethodBeat.i(85420);
    Object localObject1 = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localObject1 == null)
    {
      AppMethodBeat.o(85420);
      return false;
    }
    int i = ((SharedPreferences)localObject1).getInt("nUpdatingProcessId", -1);
    if (i < 0)
    {
      AppMethodBeat.o(85420);
      return false;
    }
    int j = Process.myPid();
    int k = Process.myUid();
    if (i == j)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "current process is updating plugin");
      AppMethodBeat.o(85420);
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
              AppMethodBeat.o(85420);
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
      eat();
      AppMethodBeat.o(85420);
    }
    return false;
  }
  
  public static void eat()
  {
    AppMethodBeat.i(85421);
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(85421);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).remove("nUpdatingProcessId");
    ((SharedPreferences.Editor)localObject).commit();
    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "plugin update progress finish");
    AppMethodBeat.o(85421);
  }
  
  public static void pn(long paramLong)
  {
    AppMethodBeat.i(85419);
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localObject == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "set time sp is null");
      AppMethodBeat.o(85419);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("nLastFetchPluginConfigTime", paramLong);
    ((SharedPreferences.Editor)localObject).commit();
    AppMethodBeat.o(85419);
  }
  
  public final void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(85418);
    this.BKu = new h();
    this.BKu.a(paramHashMap, this.BKs, this.BKt);
    this.BKu.execute(new String[0]);
    this.BKs = "";
    this.BKt = null;
    AppMethodBeat.o(85418);
  }
  
  public final boolean isBusy()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.BKu != null)
    {
      bool1 = bool2;
      if (!this.BKu.BKD) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static abstract interface a
  {
    public abstract void TB(int paramInt);
    
    public abstract void TC(int paramInt);
    
    public abstract void eaf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.g
 * JD-Core Version:    0.7.0.1
 */