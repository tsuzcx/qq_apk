package com.tencent.xweb.xwalk.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.y.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializeLog;
import org.xwalk.core.XWalkSharedPreferenceUtil;
import org.xwalk.core.XWalkUpdateConfigUtil;

public final class l
  implements y.a
{
  private String aipU = "";
  private k aipV = null;
  private m aipW = null;
  
  public static void Bz(long paramLong)
  {
    AppMethodBeat.i(154509);
    Object localObject = XWalkSharedPreferenceUtil.getSharedPreferencesForPluginUpdateInfo();
    if (localObject == null)
    {
      XWalkInitializeLog.addXWalkInitializeLog("XWalkPluginUpdater", "set time sp is null");
      AppMethodBeat.o(154509);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("nLastFetchPluginConfigTime", paramLong);
    ((SharedPreferences.Editor)localObject).commit();
    AppMethodBeat.o(154509);
  }
  
  private static long kjF()
  {
    AppMethodBeat.i(213077);
    SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForPluginUpdateInfo();
    if (localSharedPreferences == null)
    {
      XWalkInitializeLog.addXWalkInitializeLog("XWalkPluginUpdater", "get time sp is null");
      AppMethodBeat.o(213077);
      return 0L;
    }
    long l = localSharedPreferences.getLong("nLastFetchPluginConfigTime", 0L);
    AppMethodBeat.o(213077);
    return l;
  }
  
  public static boolean kjG()
  {
    AppMethodBeat.i(213082);
    if (kjH())
    {
      XWalkInitializeLog.addXWalkInitializeLog("XWalkPluginUpdater", "has plugin need update, fetch plugin config first");
      AppMethodBeat.o(213082);
      return true;
    }
    long l1 = System.currentTimeMillis();
    long l2 = kjF();
    if ((l1 - l2 >= XWalkUpdateConfigUtil.getPluginUpdatePeriod()) || (l1 < l2))
    {
      AppMethodBeat.o(213082);
      return true;
    }
    AppMethodBeat.o(213082);
    return false;
  }
  
  private static boolean kjH()
  {
    AppMethodBeat.i(213086);
    Iterator localIterator = i.kjC().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if ((localg != null) && (a.bIp(localg.kjs()).Pe(false)))
      {
        AppMethodBeat.o(213086);
        return true;
      }
    }
    AppMethodBeat.o(213086);
    return false;
  }
  
  public static boolean kjI()
  {
    AppMethodBeat.i(154510);
    Object localObject1 = XWalkSharedPreferenceUtil.getSharedPreferencesForPluginUpdateInfo();
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
      XWalkInitializeLog.addXWalkInitializeLog("XWalkPluginUpdater", "current process is updating plugin");
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
              XWalkInitializeLog.addXWalkInitializeLog("XWalkPluginUpdater", "other process is in updating plugin progress");
              AppMethodBeat.o(154510);
              return true;
            }
          }
        }
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("XWalkPluginUpdater", localObject2.getMessage());
        Object localObject3 = null;
      }
      XWalkInitializeLog.addXWalkInitializeLog("XWalkPluginUpdater", "plugin update process pid invalid, clear");
      kjJ();
      AppMethodBeat.o(154510);
    }
    return false;
  }
  
  public static void kjJ()
  {
    AppMethodBeat.i(154511);
    Object localObject = XWalkSharedPreferenceUtil.getSharedPreferencesForPluginUpdateInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(154511);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).remove("nUpdatingProcessId");
    ((SharedPreferences.Editor)localObject).commit();
    XWalkInitializeLog.addXWalkInitializeLog("XWalkPluginUpdater", "plugin update progress finish");
    AppMethodBeat.o(154511);
  }
  
  public final void a(String paramString, k paramk)
  {
    this.aipU = paramString;
    this.aipV = paramk;
  }
  
  public final void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154508);
    try
    {
      this.aipW = new m();
      this.aipW.a(paramHashMap, this.aipU, this.aipV);
      this.aipW.execute(new String[0]);
      this.aipU = "";
      this.aipV = null;
      return;
    }
    finally
    {
      AppMethodBeat.o(154508);
    }
  }
  
  public final boolean isBusy()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.aipW != null)
    {
      bool1 = bool2;
      if (!this.aipW.aiqf) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void kfB()
  {
    AppMethodBeat.i(213110);
    if (this.aipW != null) {
      this.aipW.b(4, -1, null);
    }
    AppMethodBeat.o(213110);
  }
  
  public final boolean kfC()
  {
    AppMethodBeat.i(213104);
    if (kjG())
    {
      AppMethodBeat.o(213104);
      return true;
    }
    AppMethodBeat.o(213104);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.l
 * JD-Core Version:    0.7.0.1
 */