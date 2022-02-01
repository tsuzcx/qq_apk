package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public final class q
{
  private static int ETD;
  private static int ETE;
  private static q.b ETF;
  private static BroadcastReceiver broadcastReceiver;
  
  static
  {
    AppMethodBeat.i(157554);
    broadcastReceiver = null;
    ETD = 0;
    ETE = -1;
    ETF = new q.a();
    AppMethodBeat.o(157554);
  }
  
  public static int a(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo)
  {
    AppMethodBeat.i(157550);
    if (!(ETF instanceof q.a))
    {
      AppMethodBeat.o(157550);
      return -1;
    }
    Field localField = ((q.a)ETF).ETG;
    if ((Build.VERSION.SDK_INT >= 21) && (localField != null)) {
      try
      {
        int i = localField.getInt(paramRunningAppProcessInfo);
        AppMethodBeat.o(157550);
        return i;
      }
      catch (Throwable paramRunningAppProcessInfo)
      {
        ad.printErrStackTrace("MicroMsg.GreenManUtil", paramRunningAppProcessInfo, "", new Object[0]);
      }
    }
    AppMethodBeat.o(157550);
    return -1;
  }
  
  public static boolean cB(Context paramContext)
  {
    AppMethodBeat.i(157549);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null)
    {
      AppMethodBeat.o(157549);
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName.startsWith("com.tencent.mm")))
      {
        AppMethodBeat.o(157549);
        return true;
      }
    }
    AppMethodBeat.o(157549);
    return false;
  }
  
  public static String cC(Context paramContext)
  {
    AppMethodBeat.i(157553);
    if (!cB(paramContext))
    {
      AppMethodBeat.o(157553);
      return "";
    }
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramContext = paramContext.getAppTasks();
        if ((paramContext == null) || (paramContext.size() <= 0))
        {
          AppMethodBeat.o(157553);
          return "";
        }
        paramContext = paramContext.iterator();
        if (paramContext.hasNext())
        {
          paramContext = ((ActivityManager.AppTask)paramContext.next()).getTaskInfo().topActivity;
          if (paramContext == null)
          {
            AppMethodBeat.o(157553);
            return null;
          }
          paramContext = paramContext.getClassName();
          AppMethodBeat.o(157553);
          return paramContext;
        }
      }
      else
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.getRunningTasks(1).get(0)).topActivity.getClassName();
        AppMethodBeat.o(157553);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.GreenManUtil", "getTopActivityName Exception:%s stack:%s", new Object[] { paramContext.getMessage(), bt.m(paramContext) });
      AppMethodBeat.o(157553);
    }
    return "";
  }
  
  public static boolean ig(Context paramContext)
  {
    AppMethodBeat.i(157548);
    try
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      if (Build.VERSION.SDK_INT >= 20)
      {
        bool = paramContext.isInteractive();
        AppMethodBeat.o(157548);
        return bool;
      }
      boolean bool = paramContext.isScreenOn();
      AppMethodBeat.o(157548);
      return bool;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.GreenManUtil", "isScreenOn ERROR use isScreenOn e:%s", new Object[] { bt.m(paramContext) });
      AppMethodBeat.o(157548);
    }
    return false;
  }
  
  public static void ih(Context paramContext)
  {
    AppMethodBeat.i(157551);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(10);
    if (paramContext == null)
    {
      AppMethodBeat.o(157551);
      return;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)paramContext.next();
      ad.i("MicroMsg.GreenManUtil", "dumpRunningServices %s %s", new Object[] { localRunningServiceInfo.service, Boolean.valueOf(localRunningServiceInfo.foreground), Long.valueOf(localRunningServiceInfo.activeSince) });
    }
    AppMethodBeat.o(157551);
  }
  
  public static boolean ii(Context paramContext)
  {
    AppMethodBeat.i(157552);
    boolean bool = ETF.ij(paramContext);
    AppMethodBeat.o(157552);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.q
 * JD-Core Version:    0.7.0.1
 */