package com.tencent.mm.plugin.voip.widget;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.voip.b.l;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public class VoipForegroundService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(115791);
    ac.i("MicroMsg.VoipForegroundService", "onBind");
    AppMethodBeat.o(115791);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(115789);
    ac.i("MicroMsg.VoipForegroundService", "VoipForegroundService onCreate");
    super.onCreate();
    g.agS();
    if (!g.agP().afY())
    {
      stopSelf();
      AppMethodBeat.o(115789);
      return;
    }
    if (d.kZ(26))
    {
      Object localObject = q.ADO;
      q.eiV();
      localObject = com.tencent.mm.bq.a.bE(ai.getContext(), "reminder_channel_id").i(System.currentTimeMillis()).as(b.dlN());
      ((s.c)localObject).f(2, true);
      localObject = l.e((s.c)localObject);
      try
      {
        if (ai.eVi()) {
          ac.i("MicroMsg.VoipForegroundService", "current mmprocess is exits");
        }
        startForeground(40, (Notification)localObject);
        AppMethodBeat.o(115789);
        return;
      }
      catch (Exception localException)
      {
        ac.i("MicroMsg.VoipForegroundService", "start foreground service happened error %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(115789);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115790);
    ac.i("MicroMsg.VoipForegroundService", "VoipForegroundService onDestroy");
    q localq = q.ADO;
    q.eiX();
    try
    {
      stopForeground(true);
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
      g.agS();
      if (g.agP().afY())
      {
        sendBroadcast(new Intent("com.tencent.mm.foregroundDestroy"));
        if (c.ehb().cUz)
        {
          localq = q.ADO;
          q.eiZ();
        }
      }
      super.onDestroy();
      AppMethodBeat.o(115790);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.VoipForegroundService", "onDestroy happened error %s", new Object[] { localException });
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115788);
    g.agS();
    if (!g.agP().afY())
    {
      ac.e("MicroMsg.VoipForegroundService", "error called voip foreground service in onStartCommand process");
      paramIntent = q.ADO;
      q.ejb();
      stopSelf();
      AppMethodBeat.o(115788);
      return 2;
    }
    Object localObject;
    String str;
    if ((d.kZ(26)) && (paramIntent != null))
    {
      ac.i("MicroMsg.VoipForegroundService", "foreground service is on bind ");
      if (paramIntent.getBooleanExtra("isRecalled", false))
      {
        localObject = q.ADO;
        q.eja();
      }
      localObject = q.ADO;
      q.eiW();
      ac.i("MicroMsg.VoipForegroundService", "setNotificationBind");
      paramIntent.setClass(ai.getContext(), VideoActivity.class);
      paramIntent.setFlags(268435456);
      str = paramIntent.getStringExtra("Voip_User");
      if (paramIntent.getBooleanExtra("Voip_VideoCall", false)) {
        break label205;
      }
      if (paramIntent.getStringExtra("mTickerText") != null) {
        break label194;
      }
      localObject = ai.getContext().getString(2131764941);
      ac.i("MicroMsg.VoipForegroundService", "voip notification type is 40");
      g.agS();
      if (g.agP().afY()) {
        break label218;
      }
      ac.e("MicroMsg.VoipForegroundService", "error called voip foreground service in setNotification process");
      paramIntent = q.ADO;
      q.ejb();
      stopSelf();
    }
    for (;;)
    {
      AppMethodBeat.o(115788);
      return 3;
      label194:
      localObject = paramIntent.getStringExtra("mTickerText");
      break;
      label205:
      localObject = ai.getContext().getString(2131764933);
      break;
      label218:
      paramIntent = PendingIntent.getActivity(ai.getContext(), 40, paramIntent, 134217728);
      localObject = com.tencent.mm.bq.a.bE(ai.getContext(), "reminder_channel_id").i((CharSequence)localObject).i(System.currentTimeMillis()).f(v.wk(str)).g((CharSequence)localObject).as(b.dlN());
      ((s.c)localObject).Fu = paramIntent;
      ((s.c)localObject).f(2, true);
      paramIntent = l.e((s.c)localObject);
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, paramIntent, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoipForegroundService
 * JD-Core Version:    0.7.0.1
 */