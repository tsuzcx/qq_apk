package com.tencent.voip.mars.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.voip.mars.xlog.Log;
import java.util.Iterator;
import java.util.TreeSet;

public class Alarm
  extends BroadcastReceiver
{
  private static final String KEXTRA_ID = "ID";
  private static final String KEXTRA_PID = "PID";
  private static final String TAG = "MicroMsg.Alarm";
  private static TreeSet<Object[]> alarm_waiting_set = new TreeSet(new Alarm.ComparatorAlarm(null));
  private static Alarm bc_alarm;
  private static WakerLock wakerlock = null;
  
  static
  {
    bc_alarm = null;
  }
  
  private static boolean cancelAlarmMgr(Context paramContext, PendingIntent paramPendingIntent)
  {
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    if (paramContext == null)
    {
      Log.e("MicroMsg.Alarm", "am == null");
      return false;
    }
    if (paramPendingIntent == null)
    {
      Log.e("MicroMsg.Alarm", "pendingIntent == null");
      return false;
    }
    paramContext.cancel(paramPendingIntent);
    paramPendingIntent.cancel();
    return true;
  }
  
  private native void onAlarm(long paramLong);
  
  public static void resetAlarm(Context paramContext)
  {
    synchronized (alarm_waiting_set)
    {
      Iterator localIterator = alarm_waiting_set.iterator();
      if (!localIterator.hasNext())
      {
        alarm_waiting_set.clear();
        if (bc_alarm != null)
        {
          paramContext.unregisterReceiver(bc_alarm);
          bc_alarm = null;
        }
        return;
      }
      cancelAlarmMgr(paramContext, (PendingIntent)((Object[])localIterator.next())[Alarm.TSetData.PENDINGINTENT.ordinal()]);
    }
  }
  
  private static PendingIntent setAlarmMgr(long paramLong1, long paramLong2, Context paramContext)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null)
    {
      Log.e("MicroMsg.Alarm", "am == null");
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("ALARM_ACTION(" + String.valueOf(Process.myPid()) + ")");
    localIntent.putExtra("ID", paramLong1);
    localIntent.putExtra("PID", Process.myPid());
    paramContext = PendingIntent.getBroadcast(paramContext, (int)paramLong1, localIntent, 268435456);
    if (Build.VERSION.SDK_INT < 19) {
      localAlarmManager.set(2, paramLong2, paramContext);
    }
    for (;;)
    {
      return paramContext;
      localAlarmManager.setExact(2, paramLong2, paramContext);
    }
  }
  
  public static boolean start(long paramLong, int paramInt, Context paramContext)
  {
    long l2 = SystemClock.elapsedRealtime();
    if (paramInt < 0)
    {
      Log.e("MicroMsg.Alarm", "id:%d, after:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      return false;
    }
    if (paramContext == null)
    {
      Log.e("MicroMsg.Alarm", "null==context, id:%d, after:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      return false;
    }
    synchronized (alarm_waiting_set)
    {
      if (wakerlock == null)
      {
        wakerlock = new WakerLock(paramContext);
        Log.i("MicroMsg.Alarm", "start new wakerlock");
      }
      if (bc_alarm == null)
      {
        bc_alarm = new Alarm();
        paramContext.registerReceiver(bc_alarm, new IntentFilter("ALARM_ACTION(" + String.valueOf(Process.myPid()) + ")"));
      }
      Iterator localIterator = alarm_waiting_set.iterator();
      long l1;
      do
      {
        if (!localIterator.hasNext())
        {
          l1 = l2;
          if (paramInt >= 0) {
            l1 = l2 + paramInt;
          }
          paramContext = setAlarmMgr(paramLong, l1, paramContext);
          if (paramContext != null) {
            break;
          }
          return false;
        }
      } while (((Long)((Object[])localIterator.next())[Alarm.TSetData.ID.ordinal()]).longValue() != paramLong);
      Log.e("MicroMsg.Alarm", "id exist=%d", new Object[] { Long.valueOf(paramLong) });
      return false;
      alarm_waiting_set.add(new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), paramContext });
      return true;
    }
  }
  
  public static boolean stop(long paramLong, Context paramContext)
  {
    if (paramContext == null)
    {
      Log.e("MicroMsg.Alarm", "context==null");
      return false;
    }
    synchronized (alarm_waiting_set)
    {
      if (wakerlock == null)
      {
        wakerlock = new WakerLock(paramContext);
        Log.i("MicroMsg.Alarm", "stop new wakerlock");
      }
      if (bc_alarm == null)
      {
        bc_alarm = new Alarm();
        localObject = new IntentFilter();
        paramContext.registerReceiver(bc_alarm, (IntentFilter)localObject);
        Log.i("MicroMsg.Alarm", "stop new Alarm");
      }
      Object localObject = alarm_waiting_set.iterator();
      Object[] arrayOfObject;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          return false;
        }
        arrayOfObject = (Object[])((Iterator)localObject).next();
      } while (((Long)arrayOfObject[Alarm.TSetData.ID.ordinal()]).longValue() != paramLong);
      cancelAlarmMgr(paramContext, (PendingIntent)arrayOfObject[Alarm.TSetData.PENDINGINTENT.ordinal()]);
      ((Iterator)localObject).remove();
      return true;
    }
  }
  
  public void onReceive(Context paramContext, Intent arg2)
  {
    if ((paramContext == null) || (??? == null)) {}
    for (;;)
    {
      return;
      paramContext = Long.valueOf(???.getLongExtra("ID", 0L));
      Integer localInteger = Integer.valueOf(???.getIntExtra("PID", 0));
      if ((0L == paramContext.longValue()) || (localInteger.intValue() == 0)) {
        continue;
      }
      if (localInteger.intValue() != Process.myPid())
      {
        Log.w("MicroMsg.Alarm", "onReceive id:%d, pid:%d, mypid:%d", new Object[] { paramContext, localInteger, Integer.valueOf(Process.myPid()) });
        return;
      }
      synchronized (alarm_waiting_set)
      {
        Iterator localIterator = alarm_waiting_set.iterator();
        Object[] arrayOfObject;
        Long localLong;
        do
        {
          if (!localIterator.hasNext())
          {
            i = 0;
            if (i == 0) {
              Log.e("MicroMsg.Alarm", "onReceive not found id:%d, pid:%d, alarm_waiting_set.size:%d", new Object[] { paramContext, localInteger, Integer.valueOf(alarm_waiting_set.size()) });
            }
            if (wakerlock != null) {
              wakerlock.lock(200L);
            }
            if (i == 0) {
              break;
            }
            onAlarm(paramContext.longValue());
            return;
          }
          arrayOfObject = (Object[])localIterator.next();
          localLong = (Long)arrayOfObject[Alarm.TSetData.ID.ordinal()];
          Log.i("MicroMsg.Alarm", "onReceive id=%d, curId=%d", new Object[] { paramContext, localLong });
        } while (!localLong.equals(paramContext));
        Log.i("MicroMsg.Alarm", "onReceive find alarm id:%d, pid:%d, delta miss time:%d", new Object[] { paramContext, localInteger, Long.valueOf(SystemClock.elapsedRealtime() - ((Long)arrayOfObject[Alarm.TSetData.WAITTIME.ordinal()]).longValue()) });
        localIterator.remove();
        int i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.voip.mars.comm.Alarm
 * JD-Core Version:    0.7.0.1
 */