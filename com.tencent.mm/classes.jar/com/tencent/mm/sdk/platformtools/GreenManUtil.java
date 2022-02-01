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
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class GreenManUtil
{
  private static final String TAG = "MicroMsg.GreenManUtil";
  private static int batteryStatus;
  private static int batteryStatusPlugged;
  private static BroadcastReceiver broadcastReceiver;
  private static IForeground sForeground;
  
  static
  {
    AppMethodBeat.i(157554);
    broadcastReceiver = null;
    batteryStatusPlugged = 0;
    batteryStatus = -1;
    sForeground = new ForegroundImpl();
    AppMethodBeat.o(157554);
  }
  
  public static void dumpRunningServices(Context paramContext)
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
      Log.i("MicroMsg.GreenManUtil", "dumpRunningServices %s %s", new Object[] { localRunningServiceInfo.service, Boolean.valueOf(localRunningServiceInfo.foreground), Long.valueOf(localRunningServiceInfo.activeSince) });
    }
    AppMethodBeat.o(157551);
  }
  
  public static String getTopActivityName(Context paramContext)
  {
    AppMethodBeat.i(157553);
    if (!isAppOnForeground(paramContext))
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
      Log.e("MicroMsg.GreenManUtil", "getTopActivityName Exception:%s stack:%s", new Object[] { paramContext.getMessage(), Util.stackTraceToString(paramContext) });
      AppMethodBeat.o(157553);
    }
    return "";
  }
  
  public static boolean isAppOnForeground(Context paramContext)
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
  
  public static boolean isAppOnForeground(String paramString, Context paramContext)
  {
    AppMethodBeat.i(243762);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null)
    {
      AppMethodBeat.o(243762);
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((localRunningAppProcessInfo.processName.equals(paramString)) && (localRunningAppProcessInfo.importance == 100))
      {
        AppMethodBeat.o(243762);
        return true;
      }
    }
    AppMethodBeat.o(243762);
    return false;
  }
  
  public static boolean isAppVisibleForeground(Context paramContext)
  {
    AppMethodBeat.i(157552);
    boolean bool = sForeground.isAppForeground(paramContext);
    AppMethodBeat.o(157552);
    return bool;
  }
  
  /* Error */
  public static boolean isCharging(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 217
    //   7: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 34	com/tencent/mm/sdk/platformtools/GreenManUtil:broadcastReceiver	Landroid/content/BroadcastReceiver;
    //   13: ifnonnull +50 -> 63
    //   16: new 6	com/tencent/mm/sdk/platformtools/GreenManUtil$1
    //   19: dup
    //   20: invokespecial 218	com/tencent/mm/sdk/platformtools/GreenManUtil$1:<init>	()V
    //   23: putstatic 34	com/tencent/mm/sdk/platformtools/GreenManUtil:broadcastReceiver	Landroid/content/BroadcastReceiver;
    //   26: aload_0
    //   27: getstatic 34	com/tencent/mm/sdk/platformtools/GreenManUtil:broadcastReceiver	Landroid/content/BroadcastReceiver;
    //   30: new 220	android/content/IntentFilter
    //   33: dup
    //   34: ldc 222
    //   36: invokespecial 225	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   39: invokevirtual 229	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   42: astore_0
    //   43: aload_0
    //   44: ldc 231
    //   46: iconst_m1
    //   47: invokevirtual 237	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   50: putstatic 38	com/tencent/mm/sdk/platformtools/GreenManUtil:batteryStatus	I
    //   53: aload_0
    //   54: ldc 239
    //   56: iconst_0
    //   57: invokevirtual 237	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   60: putstatic 36	com/tencent/mm/sdk/platformtools/GreenManUtil:batteryStatusPlugged	I
    //   63: getstatic 38	com/tencent/mm/sdk/platformtools/GreenManUtil:batteryStatus	I
    //   66: iconst_2
    //   67: if_icmpeq +32 -> 99
    //   70: getstatic 36	com/tencent/mm/sdk/platformtools/GreenManUtil:batteryStatusPlugged	I
    //   73: iconst_1
    //   74: if_icmpeq +25 -> 99
    //   77: getstatic 36	com/tencent/mm/sdk/platformtools/GreenManUtil:batteryStatusPlugged	I
    //   80: iconst_2
    //   81: if_icmpeq +18 -> 99
    //   84: getstatic 135	android/os/Build$VERSION:SDK_INT	I
    //   87: bipush 17
    //   89: if_icmplt +22 -> 111
    //   92: getstatic 36	com/tencent/mm/sdk/platformtools/GreenManUtil:batteryStatusPlugged	I
    //   95: iconst_4
    //   96: if_icmpne +15 -> 111
    //   99: ldc 217
    //   101: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: iconst_1
    //   105: istore_1
    //   106: ldc 2
    //   108: monitorexit
    //   109: iload_1
    //   110: ireturn
    //   111: ldc 217
    //   113: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: goto -10 -> 106
    //   119: astore_0
    //   120: ldc 2
    //   122: monitorexit
    //   123: aload_0
    //   124: athrow
    //   125: astore_0
    //   126: goto -63 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramContext	Context
    //   1	109	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	26	119	finally
    //   63	99	119	finally
    //   99	104	119	finally
    //   111	116	119	finally
    //   26	63	125	finally
  }
  
  public static boolean isScreenOn(Context paramContext)
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
      Log.e("MicroMsg.GreenManUtil", "isScreenOn ERROR use isScreenOn e:%s", new Object[] { Util.stackTraceToString(paramContext) });
      AppMethodBeat.o(157548);
    }
    return false;
  }
  
  public static int reflectProcessState(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo)
  {
    AppMethodBeat.i(157550);
    if (!(sForeground instanceof ForegroundImpl))
    {
      AppMethodBeat.o(157550);
      return -1;
    }
    Field localField = ((ForegroundImpl)sForeground).Field_processState;
    if ((Build.VERSION.SDK_INT >= 21) && (localField != null)) {
      try
      {
        int i = localField.getInt(paramRunningAppProcessInfo);
        AppMethodBeat.o(157550);
        return i;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.GreenManUtil", paramRunningAppProcessInfo, "", new Object[0]);
      }
    }
    AppMethodBeat.o(157550);
    return -1;
  }
  
  public static boolean reflectScreenOn(Context paramContext)
  {
    AppMethodBeat.i(243751);
    try
    {
      boolean bool = ((Boolean)PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager)paramContext.getSystemService("power"), new Object[0])).booleanValue();
      AppMethodBeat.o(243751);
      return bool;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.GreenManUtil", "reflectScreenOn invoke ERROR use isScreenOn e:%s", new Object[] { Util.stackTraceToString(paramContext) });
      AppMethodBeat.o(243751);
    }
    return true;
  }
  
  static class ForegroundImpl
    implements GreenManUtil.IForeground
  {
    private Field Field_processState;
    
    ForegroundImpl()
    {
      AppMethodBeat.i(157546);
      this.Field_processState = null;
      prepare();
      AppMethodBeat.o(157546);
    }
    
    private void prepare()
    {
      AppMethodBeat.i(243530);
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          if (this.Field_processState == null)
          {
            Field localField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
            localField.setAccessible(true);
            this.Field_processState = localField;
          }
          AppMethodBeat.o(243530);
          return;
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.GreenManUtil", localThrowable, "", new Object[0]);
        }
      }
      AppMethodBeat.o(243530);
    }
    
    public boolean isAppForeground(Context paramContext)
    {
      AppMethodBeat.i(157547);
      Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (localObject == null)
      {
        AppMethodBeat.o(157547);
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.processName.startsWith(paramContext.getPackageName()))
        {
          if ((Build.VERSION.SDK_INT >= 21) && (this.Field_processState != null)) {}
          for (;;)
          {
            try
            {
              i = this.Field_processState.getInt(localRunningAppProcessInfo);
              Log.i("MicroMsg.GreenManUtil", "isAppForeground processState %s", new Object[] { Integer.valueOf(i) });
              if (i <= 2)
              {
                AppMethodBeat.o(157547);
                return true;
              }
              i = 0;
              if ((i == 0) || (localRunningAppProcessInfo.importance != 100)) {
                break;
              }
              AppMethodBeat.o(157547);
              return true;
            }
            finally
            {
              Log.printErrStackTrace("MicroMsg.GreenManUtil", localThrowable, "", new Object[0]);
            }
            int i = 1;
          }
        }
      }
      AppMethodBeat.o(157547);
      return false;
    }
  }
  
  public static abstract interface IForeground
  {
    public abstract boolean isAppForeground(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.GreenManUtil
 * JD-Core Version:    0.7.0.1
 */