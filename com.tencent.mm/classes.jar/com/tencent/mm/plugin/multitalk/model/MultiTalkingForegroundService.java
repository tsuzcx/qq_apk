package com.tencent.mm.plugin.multitalk.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.s.c;
import com.tencent.luggage.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public class MultiTalkingForegroundService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(54077);
    ab.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onBind");
    if (b.fv(26))
    {
      ab.i("MicroMsg.MultiTalkingForegroundService", "foreground service is on bind MicroMsg.MultiTalkingForegroundService");
      paramIntent = ah.getContext().getString(2131301655);
      String str = ah.getContext().getString(2131301694);
      Object localObject = new Intent();
      ((Intent)localObject).setClass(ah.getContext(), MultiTalkMainUI.class);
      localObject = PendingIntent.getActivity(ah.getContext(), 43, (Intent)localObject, 134217728);
      int i = 2130839847;
      if (com.tencent.mm.compatible.util.d.fw(19)) {
        i = 2130839845;
      }
      paramIntent = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id").h(str).g(System.currentTimeMillis()).e(paramIntent).f(str);
      paramIntent.ya = ((PendingIntent)localObject);
      paramIntent = com.tencent.mm.plugin.voip.a.d.c(paramIntent);
      paramIntent.icon = i;
      paramIntent.flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, paramIntent, false);
      startForeground(43, paramIntent);
    }
    AppMethodBeat.o(54077);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(54079);
    ab.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onCreate");
    AppMethodBeat.o(54079);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(54080);
    ab.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onDestroy");
    AppMethodBeat.o(54080);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(54078);
    ab.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onUnbind");
    stopSelf();
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(54078);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.MultiTalkingForegroundService
 * JD-Core Version:    0.7.0.1
 */