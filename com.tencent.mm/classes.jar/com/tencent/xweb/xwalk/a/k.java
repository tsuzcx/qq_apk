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
  private String aajP = "";
  private j aajQ = null;
  private l aajR = null;
  
  public static void Xo(long paramLong)
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
  
  private static long izk()
  {
    AppMethodBeat.i(205094);
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localSharedPreferences == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "get time sp is null");
      AppMethodBeat.o(205094);
      return 0L;
    }
    long l = localSharedPreferences.getLong("nLastFetchPluginConfigTime", 0L);
    AppMethodBeat.o(205094);
    return l;
  }
  
  public static boolean izl()
  {
    AppMethodBeat.i(205095);
    if (izm())
    {
      XWalkEnvironment.addXWalkInitializeLog("has plugin need update, fetch pluginconfig first");
      AppMethodBeat.o(205095);
      return true;
    }
    long l1 = System.currentTimeMillis();
    long l2 = izk();
    if ((l1 - l2 >= XWalkEnvironment.getPluginUpdatePeriod()) || (l1 < l2))
    {
      AppMethodBeat.o(205095);
      return true;
    }
    AppMethodBeat.o(205095);
    return false;
  }
  
  private static boolean izm()
  {
    AppMethodBeat.i(205096);
    Iterator localIterator = h.izh().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if ((localg != null) && (a.bFR(localg.getPluginName()).IZ(false)))
      {
        AppMethodBeat.o(205096);
        return true;
      }
    }
    AppMethodBeat.o(205096);
    return false;
  }
  
  public static boolean izn()
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
      izo();
      AppMethodBeat.o(154510);
    }
    return false;
  }
  
  public static void izo()
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
    this.aajP = paramString;
    this.aajQ = paramj;
  }
  
  public final void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154508);
    try
    {
      this.aajR = new l();
      this.aajR.a(paramHashMap, this.aajP, this.aajQ);
      this.aajR.execute(new String[0]);
      this.aajP = "";
      this.aajQ = null;
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
    if (this.aajR != null)
    {
      bool1 = bool2;
      if (!this.aajR.aaka) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void iwn()
  {
    AppMethodBeat.i(205093);
    if (this.aajR != null) {
      this.aajR.b(4, -1, null);
    }
    AppMethodBeat.o(205093);
  }
  
  public final boolean iwo()
  {
    AppMethodBeat.i(205092);
    if (izl())
    {
      AppMethodBeat.o(205092);
      return true;
    }
    AppMethodBeat.o(205092);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.k
 * JD-Core Version:    0.7.0.1
 */