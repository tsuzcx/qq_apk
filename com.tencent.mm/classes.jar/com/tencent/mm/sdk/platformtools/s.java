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

public final class s
{
  private static int IwP;
  private static int IwQ;
  private static s.b IwR;
  private static BroadcastReceiver broadcastReceiver;
  
  static
  {
    AppMethodBeat.i(157554);
    broadcastReceiver = null;
    IwP = 0;
    IwQ = -1;
    IwR = new s.a();
    AppMethodBeat.o(157554);
  }
  
  public static int a(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo)
  {
    AppMethodBeat.i(157550);
    if (!(IwR instanceof s.a))
    {
      AppMethodBeat.o(157550);
      return -1;
    }
    Field localField = ((s.a)IwR).IwS;
    if ((Build.VERSION.SDK_INT >= 21) && (localField != null)) {
      try
      {
        int i = localField.getInt(paramRunningAppProcessInfo);
        AppMethodBeat.o(157550);
        return i;
      }
      catch (Throwable paramRunningAppProcessInfo)
      {
        ae.printErrStackTrace("MicroMsg.GreenManUtil", paramRunningAppProcessInfo, "", new Object[0]);
      }
    }
    AppMethodBeat.o(157550);
    return -1;
  }
  
  public static boolean cJ(Context paramContext)
  {
    AppMethodBeat.i(157549);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localObject == null)
    {
      AppMethodBeat.o(157549);
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName.startsWith(paramContext.getPackageName())))
      {
        AppMethodBeat.o(157549);
        return true;
      }
    }
    AppMethodBeat.o(157549);
    return false;
  }
  
  public static String cK(Context paramContext)
  {
    AppMethodBeat.i(157553);
    if (!cJ(paramContext))
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
      ae.e("MicroMsg.GreenManUtil", "getTopActivityName Exception:%s stack:%s", new Object[] { paramContext.getMessage(), bu.o(paramContext) });
      AppMethodBeat.o(157553);
    }
    return "";
  }
  
  public static boolean iG(Context paramContext)
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
      ae.e("MicroMsg.GreenManUtil", "isScreenOn ERROR use isScreenOn e:%s", new Object[] { bu.o(paramContext) });
      AppMethodBeat.o(157548);
    }
    return false;
  }
  
  public static void iH(Context paramContext)
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
      ae.i("MicroMsg.GreenManUtil", "dumpRunningServices %s %s", new Object[] { localRunningServiceInfo.service, Boolean.valueOf(localRunningServiceInfo.foreground), Long.valueOf(localRunningServiceInfo.activeSince) });
    }
    AppMethodBeat.o(157551);
  }
  
  public static boolean iI(Context paramContext)
  {
    AppMethodBeat.i(157552);
    boolean bool = IwR.iJ(paramContext);
    AppMethodBeat.o(157552);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.s
 * JD-Core Version:    0.7.0.1
 */