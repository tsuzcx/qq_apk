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

public final class o
{
  private static BroadcastReceiver broadcastReceiver;
  private static int ymR;
  private static int ymS;
  private static o.b ymT;
  
  static
  {
    AppMethodBeat.i(52000);
    broadcastReceiver = null;
    ymR = 0;
    ymS = -1;
    ymT = new o.a();
    AppMethodBeat.o(52000);
  }
  
  public static int a(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo)
  {
    AppMethodBeat.i(51996);
    if (!(ymT instanceof o.a))
    {
      AppMethodBeat.o(51996);
      return -1;
    }
    Field localField = ((o.a)ymT).ymU;
    if ((Build.VERSION.SDK_INT >= 21) && (localField != null)) {
      try
      {
        int i = localField.getInt(paramRunningAppProcessInfo);
        AppMethodBeat.o(51996);
        return i;
      }
      catch (Throwable paramRunningAppProcessInfo)
      {
        ab.printErrStackTrace("MicroMsg.GreenManUtil", paramRunningAppProcessInfo, "", new Object[0]);
      }
    }
    AppMethodBeat.o(51996);
    return -1;
  }
  
  public static String ch(Context paramContext)
  {
    AppMethodBeat.i(51999);
    if (!eD(paramContext))
    {
      AppMethodBeat.o(51999);
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
          AppMethodBeat.o(51999);
          return "";
        }
        paramContext = paramContext.iterator();
        if (paramContext.hasNext())
        {
          paramContext = ((ActivityManager.AppTask)paramContext.next()).getTaskInfo().topActivity;
          if (paramContext == null)
          {
            AppMethodBeat.o(51999);
            return null;
          }
          paramContext = paramContext.getClassName();
          AppMethodBeat.o(51999);
          return paramContext;
        }
      }
      else
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.getRunningTasks(1).get(0)).topActivity.getClassName();
        AppMethodBeat.o(51999);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.GreenManUtil", "getTopActivityName Exception:%s stack:%s", new Object[] { paramContext.getMessage(), bo.l(paramContext) });
      AppMethodBeat.o(51999);
    }
    return "";
  }
  
  public static boolean eD(Context paramContext)
  {
    AppMethodBeat.i(51995);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null)
    {
      AppMethodBeat.o(51995);
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName.startsWith("com.tencent.mm")))
      {
        AppMethodBeat.o(51995);
        return true;
      }
    }
    AppMethodBeat.o(51995);
    return false;
  }
  
  public static boolean gE(Context paramContext)
  {
    AppMethodBeat.i(51994);
    try
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      if (Build.VERSION.SDK_INT >= 20)
      {
        bool = paramContext.isInteractive();
        AppMethodBeat.o(51994);
        return bool;
      }
      boolean bool = paramContext.isScreenOn();
      AppMethodBeat.o(51994);
      return bool;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.GreenManUtil", "isScreenOn ERROR use isScreenOn e:%s", new Object[] { bo.l(paramContext) });
      AppMethodBeat.o(51994);
    }
    return false;
  }
  
  public static void gF(Context paramContext)
  {
    AppMethodBeat.i(51997);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(10);
    if (paramContext == null)
    {
      AppMethodBeat.o(51997);
      return;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)paramContext.next();
      ab.i("MicroMsg.GreenManUtil", "dumpRunningServices %s %s", new Object[] { localRunningServiceInfo.service, Boolean.valueOf(localRunningServiceInfo.foreground), Long.valueOf(localRunningServiceInfo.activeSince) });
    }
    AppMethodBeat.o(51997);
  }
  
  public static boolean gG(Context paramContext)
  {
    AppMethodBeat.i(51998);
    boolean bool = ymT.gH(paramContext);
    AppMethodBeat.o(51998);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.o
 * JD-Core Version:    0.7.0.1
 */