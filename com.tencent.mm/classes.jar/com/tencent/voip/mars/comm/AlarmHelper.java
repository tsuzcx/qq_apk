package com.tencent.voip.mars.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.voip.mars.xlog.Log;

public class AlarmHelper
{
  private static final String TAG = "MicroMsg.AlarmHelper";
  
  public static void cancel(Context paramContext, int paramInt, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(183730);
    if (paramPendingIntent != null) {}
    for (String str = paramPendingIntent.toString();; str = "null")
    {
      Log.d("MicroMsg.AlarmHelper", "cancel(requestCode:%s operation:%s)", new Object[] { Integer.valueOf(paramInt), str });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(183730);
      return;
    }
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(183730);
      return;
    }
    paramContext.cancel(paramPendingIntent);
    AppMethodBeat.o(183730);
  }
  
  public static void cancel(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    AppMethodBeat.i(183731);
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      Log.d("MicroMsg.AlarmHelper", "cancel(requestCode:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt1), localObject, Integer.valueOf(paramInt2) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(183731);
      return;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(183731);
      return;
    }
    ((AlarmManager)localObject).cancel(getPendingIntent(paramContext, paramInt1, paramIntent, paramInt2));
    AppMethodBeat.o(183731);
  }
  
  public static void cancel(Context paramContext, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(183729);
    if (paramPendingIntent != null) {}
    for (String str = paramPendingIntent.toString();; str = "null")
    {
      Log.d("MicroMsg.AlarmHelper", "cancel(operation:%s)", new Object[] { str });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "cancel: context == null");
      AppMethodBeat.o(183729);
      return;
    }
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel: am == null");
      AppMethodBeat.o(183729);
      return;
    }
    paramContext.cancel(paramPendingIntent);
    AppMethodBeat.o(183729);
  }
  
  public static PendingIntent getPendingIntent(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    AppMethodBeat.i(183732);
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      Log.d("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt1), localObject, Integer.valueOf(paramInt2) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(183732);
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(183732);
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt2);
    AppMethodBeat.o(183732);
    return paramContext;
  }
  
  private static boolean isRequestCodeValid(int paramInt)
  {
    return (paramInt >= 100) && (paramInt <= 119);
  }
  
  public static PendingIntent set(Context paramContext, int paramInt1, int paramInt2, long paramLong, Intent paramIntent, int paramInt3)
  {
    AppMethodBeat.i(183726);
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      Log.d("MicroMsg.AlarmHelper", "set(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong), localObject, Integer.valueOf(paramInt3) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(183726);
      return null;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(183726);
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(183726);
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt3);
    ((AlarmManager)localObject).set(paramInt2, paramLong, paramContext);
    AppMethodBeat.o(183726);
    return paramContext;
  }
  
  public static PendingIntent setExact(Context paramContext, int paramInt1, int paramInt2, long paramLong, Intent paramIntent, int paramInt3)
  {
    AppMethodBeat.i(183727);
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      Log.d("MicroMsg.AlarmHelper", "setExact(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong), localObject, Integer.valueOf(paramInt3) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(183727);
      return null;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(183727);
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(183727);
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt3);
    ((AlarmManager)localObject).set(paramInt2, paramLong, paramContext);
    AppMethodBeat.o(183727);
    return paramContext;
  }
  
  public static PendingIntent setRepeating(Context paramContext, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Intent paramIntent, int paramInt3)
  {
    AppMethodBeat.i(183728);
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      Log.d("MicroMsg.AlarmHelper", "setRepeating(type:%s requestCode:%s triggerAtMillis:%s intervalMillis:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), localObject, Integer.valueOf(paramInt3) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(183728);
      return null;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(183728);
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(183728);
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt3);
    ((AlarmManager)localObject).set(paramInt2, paramLong1, paramContext);
    AppMethodBeat.o(183728);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.voip.mars.comm.AlarmHelper
 * JD-Core Version:    0.7.0.1
 */