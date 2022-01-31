package com.tencent.mm.plugin.talkroom.model;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;

public class TalkRoomReceiver
  extends BroadcastReceiver
{
  private static void a(long paramLong, Context paramContext)
  {
    AppMethodBeat.i(25793);
    long l = SystemClock.elapsedRealtime();
    ab.w("MicroMsg.TalkRoomReceiver", "reset bumper, interval:%d, now:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null)
    {
      ab.e("MicroMsg.TalkRoomReceiver", "keep bumper failed, null am");
      AppMethodBeat.o(25793);
      return;
    }
    localAlarmManager.set(2, l + paramLong, PendingIntent.getBroadcast(paramContext, 1, new Intent(paramContext, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), 268435456));
    AppMethodBeat.o(25793);
  }
  
  public static void bu(Context paramContext)
  {
    long l1 = 30000L;
    AppMethodBeat.i(25792);
    long l2 = af.dsK();
    ab.d("MicroMsg.TalkRoomReceiver", "bumper comes, next=".concat(String.valueOf(l2)));
    if (l2 > 600000L)
    {
      AppMethodBeat.o(25792);
      return;
    }
    if (l2 < 30000L) {}
    for (;;)
    {
      a(l1, paramContext);
      AppMethodBeat.o(25792);
      return;
      l1 = l2;
    }
  }
  
  public static void bv(Context paramContext)
  {
    AppMethodBeat.i(25794);
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null)
    {
      ab.e("MicroMsg.TalkRoomReceiver", "stop bumper failed, null am");
      AppMethodBeat.o(25794);
      return;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, 1, new Intent(paramContext, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), 536870912);
    if (paramContext != null)
    {
      localAlarmManager.cancel(paramContext);
      paramContext.cancel();
    }
    AppMethodBeat.o(25794);
  }
  
  protected static void init()
  {
    AppMethodBeat.i(25790);
    af.a(new TalkRoomReceiver.1());
    AppMethodBeat.o(25790);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(25791);
    ab.i("MicroMsg.TalkRoomReceiver", "[ALARM NOTIFICATION] bump:".concat(String.valueOf(paramIntent.getBooleanExtra("MMBoot_Bump", false))));
    bu(paramContext);
    AppMethodBeat.o(25791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.TalkRoomReceiver
 * JD-Core Version:    0.7.0.1
 */