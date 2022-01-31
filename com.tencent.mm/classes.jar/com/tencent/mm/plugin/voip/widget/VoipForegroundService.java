package com.tencent.mm.plugin.voip.widget;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public class VoipForegroundService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(140265);
    ab.i("MicroMsg.VoipForegroundService", "onBind");
    AppMethodBeat.o(140265);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(5165);
    ab.i("MicroMsg.VoipForegroundService", "VoipForegroundService onCreate");
    super.onCreate();
    if (com.tencent.luggage.g.b.fv(26))
    {
      Object localObject = p.twZ;
      p.cMD();
      localObject = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id").g(System.currentTimeMillis()).Y(b.bYt());
      ((s.c)localObject).g(2, true);
      localObject = d.c((s.c)localObject);
      try
      {
        if (ah.dsZ()) {
          ab.i("MicroMsg.VoipForegroundService", "current mmprocess is exits");
        }
        startForeground(40, (Notification)localObject);
        AppMethodBeat.o(5165);
        return;
      }
      catch (Exception localException)
      {
        ab.i("MicroMsg.VoipForegroundService", "start foreground service happened error %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(5165);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5166);
    ab.i("MicroMsg.VoipForegroundService", "VoipForegroundService onDestroy");
    p localp = p.twZ;
    p.cMF();
    ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    stopForeground(true);
    super.onDestroy();
    AppMethodBeat.o(5166);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5164);
    Object localObject;
    String str;
    if ((com.tencent.luggage.g.b.fv(26)) && (paramIntent != null))
    {
      ab.i("MicroMsg.VoipForegroundService", "foreground service is on bind ");
      localObject = p.twZ;
      p.cME();
      ab.i("MicroMsg.VoipForegroundService", "setNotificationBind");
      paramIntent.setClass(ah.getContext(), VideoActivity.class);
      str = paramIntent.getStringExtra("Voip_User");
      if (paramIntent.getBooleanExtra("Voip_VideoCall", false)) {
        break label206;
      }
      if (paramIntent.getStringExtra("mTickerText") != null) {
        break label195;
      }
      localObject = ah.getContext().getString(2131304758);
    }
    for (;;)
    {
      ab.i("MicroMsg.VoipForegroundService", "voip notification type is 40");
      paramIntent = PendingIntent.getActivity(ah.getContext(), 40, paramIntent, 134217728);
      localObject = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id").h((CharSequence)localObject).g(System.currentTimeMillis()).e(s.nE(str)).f((CharSequence)localObject).Y(b.bYt());
      ((s.c)localObject).ya = paramIntent;
      ((s.c)localObject).g(2, true);
      paramIntent = d.c((s.c)localObject);
      ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, paramIntent, false);
      AppMethodBeat.o(5164);
      return 2;
      label195:
      localObject = paramIntent.getStringExtra("mTickerText");
      continue;
      label206:
      localObject = ah.getContext().getString(2131304750);
    }
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    AppMethodBeat.i(138296);
    ab.i("MicroMsg.VoipForegroundService", "onTaskRemoved: %s", new Object[] { paramIntent });
    super.onTaskRemoved(paramIntent);
    ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    stopSelf();
    AppMethodBeat.o(138296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoipForegroundService
 * JD-Core Version:    0.7.0.1
 */