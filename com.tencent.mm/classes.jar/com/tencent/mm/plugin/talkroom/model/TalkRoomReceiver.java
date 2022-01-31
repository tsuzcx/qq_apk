package com.tencent.mm.plugin.talkroom.model;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.y;

public class TalkRoomReceiver
  extends BroadcastReceiver
{
  public static void aT(Context paramContext)
  {
    long l2 = ac.cqN();
    y.d("MicroMsg.TalkRoomReceiver", "bumper comes, next=" + l2);
    if (l2 > 600000L) {
      return;
    }
    long l1 = l2;
    if (l2 < 30000L) {
      l1 = 30000L;
    }
    l2 = SystemClock.elapsedRealtime();
    y.w("MicroMsg.TalkRoomReceiver", "reset bumper, interval:%d, now:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null)
    {
      y.e("MicroMsg.TalkRoomReceiver", "keep bumper failed, null am");
      return;
    }
    localAlarmManager.set(2, l1 + l2, PendingIntent.getBroadcast(paramContext, 1, new Intent(paramContext, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), 268435456));
  }
  
  public static void aU(Context paramContext)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null) {
      y.e("MicroMsg.TalkRoomReceiver", "stop bumper failed, null am");
    }
    do
    {
      return;
      paramContext = PendingIntent.getBroadcast(paramContext, 1, new Intent(paramContext, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), 536870912);
    } while (paramContext == null);
    localAlarmManager.cancel(paramContext);
    paramContext.cancel();
  }
  
  protected static void init()
  {
    ac.a(new TalkRoomReceiver.1());
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("MMBoot_Bump", false);
    y.i("MicroMsg.TalkRoomReceiver", "[ALARM NOTIFICATION] bump:" + bool);
    aT(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.TalkRoomReceiver
 * JD-Core Version:    0.7.0.1
 */