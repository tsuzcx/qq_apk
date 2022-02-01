package com.tencent.mm.plugin.talkroom.model;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MAlarmHandler.IBumper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class TalkRoomReceiver
  extends BroadcastReceiver
{
  private static void a(long paramLong, Context paramContext)
  {
    AppMethodBeat.i(29475);
    long l = SystemClock.elapsedRealtime();
    Log.w("MicroMsg.TalkRoomReceiver", "reset bumper, interval:%d, now:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    a.set(paramContext, 107, 2, l + paramLong, new Intent(paramContext, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), 268435456);
    AppMethodBeat.o(29475);
  }
  
  public static void cP(Context paramContext)
  {
    long l1 = 30000L;
    AppMethodBeat.i(29474);
    long l2 = MAlarmHandler.fire();
    Log.d("MicroMsg.TalkRoomReceiver", "bumper comes, next=".concat(String.valueOf(l2)));
    if (l2 > 600000L)
    {
      AppMethodBeat.o(29474);
      return;
    }
    if (l2 < 30000L) {}
    for (;;)
    {
      a(l1, paramContext);
      AppMethodBeat.o(29474);
      return;
      l1 = l2;
    }
  }
  
  public static void cQ(Context paramContext)
  {
    AppMethodBeat.i(29476);
    PendingIntent localPendingIntent = a.b(paramContext, 107, new Intent(paramContext, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true));
    if (localPendingIntent != null)
    {
      a.cancel(paramContext, 107, localPendingIntent);
      localPendingIntent.cancel();
    }
    AppMethodBeat.o(29476);
  }
  
  protected static void init()
  {
    AppMethodBeat.i(29472);
    MAlarmHandler.initAlarmBumper(new MAlarmHandler.IBumper()
    {
      public final void cancel()
      {
        AppMethodBeat.i(29471);
        TalkRoomReceiver.cQ(MMApplicationContext.getContext());
        AppMethodBeat.o(29471);
      }
      
      public final void prepare()
      {
        AppMethodBeat.i(29470);
        TalkRoomReceiver.cP(MMApplicationContext.getContext());
        AppMethodBeat.o(29470);
      }
    });
    AppMethodBeat.o(29472);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(29473);
    Log.i("MicroMsg.TalkRoomReceiver", "[ALARM NOTIFICATION] bump:".concat(String.valueOf(paramIntent.getBooleanExtra("MMBoot_Bump", false))));
    cP(paramContext);
    AppMethodBeat.o(29473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.TalkRoomReceiver
 * JD-Core Version:    0.7.0.1
 */