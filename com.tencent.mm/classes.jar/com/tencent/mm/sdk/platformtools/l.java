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
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public final class l
{
  private static BroadcastReceiver kmq = null;
  private static int ueq = 0;
  private static int uer = -1;
  private static b ues = new l.a();
  
  public static int a(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo)
  {
    if (!(ues instanceof l.a)) {
      return -1;
    }
    Field localField = ((l.a)ues).uet;
    if ((Build.VERSION.SDK_INT >= 21) && (localField != null)) {
      try
      {
        int i = localField.getInt(paramRunningAppProcessInfo);
        return i;
      }
      catch (Throwable paramRunningAppProcessInfo)
      {
        y.printErrStackTrace("MicroMsg.GreenManUtil", paramRunningAppProcessInfo, "", new Object[0]);
      }
    }
    return -1;
  }
  
  public static String bC(Context paramContext)
  {
    if (!dR(paramContext)) {
      return "";
    }
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramContext = paramContext.getAppTasks();
        if ((paramContext == null) || (paramContext.size() <= 0)) {
          break label144;
        }
        paramContext = paramContext.iterator();
        if (paramContext.hasNext())
        {
          paramContext = ((ActivityManager.AppTask)paramContext.next()).getTaskInfo().topActivity;
          if (paramContext == null) {
            return null;
          }
          return paramContext.getClassName();
        }
      }
      else
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.getRunningTasks(1).get(0)).topActivity.getClassName();
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.GreenManUtil", "getTopActivityName Exception:%s stack:%s", new Object[] { paramContext.getMessage(), bk.j(paramContext) });
    }
    return "";
    label144:
    return "";
  }
  
  public static boolean dR(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName.startsWith("com.tencent.mm"))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean fr(Context paramContext)
  {
    try
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      if (Build.VERSION.SDK_INT >= 20) {
        return paramContext.isInteractive();
      }
      boolean bool = paramContext.isScreenOn();
      return bool;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.GreenManUtil", "isScreenOn ERROR use isScreenOn e:%s", new Object[] { bk.j(paramContext) });
    }
    return false;
  }
  
  public static void fs(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(10);
    if (paramContext == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)paramContext.next();
        y.i("MicroMsg.GreenManUtil", "dumpRunningServices %s %s", new Object[] { localRunningServiceInfo.service, Boolean.valueOf(localRunningServiceInfo.foreground), Long.valueOf(localRunningServiceInfo.activeSince) });
      }
    }
  }
  
  public static boolean ft(Context paramContext)
  {
    return ues.fu(paramContext);
  }
  
  public static abstract interface b
  {
    public abstract boolean fu(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.l
 * JD-Core Version:    0.7.0.1
 */