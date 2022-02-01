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
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public class VoipForegroundService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(115791);
    ad.i("MicroMsg.VoipForegroundService", "onBind");
    AppMethodBeat.o(115791);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(115789);
    ad.i("MicroMsg.VoipForegroundService", "VoipForegroundService onCreate");
    super.onCreate();
    g.afC();
    if (!g.afz().aeI())
    {
      stopSelf();
      AppMethodBeat.o(115789);
      return;
    }
    if (d.lf(26))
    {
      Object localObject = q.zld;
      q.dTJ();
      localObject = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").g(System.currentTimeMillis()).as(b.cYf());
      ((s.c)localObject).f(2, true);
      localObject = k.c((s.c)localObject);
      try
      {
        if (aj.eFN()) {
          ad.i("MicroMsg.VoipForegroundService", "current mmprocess is exits");
        }
        startForeground(40, (Notification)localObject);
        AppMethodBeat.o(115789);
        return;
      }
      catch (Exception localException)
      {
        ad.i("MicroMsg.VoipForegroundService", "start foreground service happened error %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(115789);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115790);
    ad.i("MicroMsg.VoipForegroundService", "VoipForegroundService onDestroy");
    q localq = q.zld;
    q.dTL();
    try
    {
      stopForeground(true);
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
      g.afC();
      if (g.afz().aeI())
      {
        sendBroadcast(new Intent("com.tencent.mm.foregroundDestroy"));
        if (c.dRQ().cXd)
        {
          localq = q.zld;
          q.dTN();
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
        ad.e("MicroMsg.VoipForegroundService", "onDestroy happened error %s", new Object[] { localException });
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115788);
    g.afC();
    if (!g.afz().aeI())
    {
      ad.e("MicroMsg.VoipForegroundService", "error called voip foreground service in onStartCommand process");
      paramIntent = q.zld;
      q.dTP();
      stopSelf();
      AppMethodBeat.o(115788);
      return 2;
    }
    Object localObject;
    String str;
    if ((d.lf(26)) && (paramIntent != null))
    {
      ad.i("MicroMsg.VoipForegroundService", "foreground service is on bind ");
      if (paramIntent.getBooleanExtra("isRecalled", false))
      {
        localObject = q.zld;
        q.dTO();
      }
      localObject = q.zld;
      q.dTK();
      ad.i("MicroMsg.VoipForegroundService", "setNotificationBind");
      paramIntent.setClass(aj.getContext(), VideoActivity.class);
      paramIntent.setFlags(268435456);
      str = paramIntent.getStringExtra("Voip_User");
      if (paramIntent.getBooleanExtra("Voip_VideoCall", false)) {
        break label205;
      }
      if (paramIntent.getStringExtra("mTickerText") != null) {
        break label194;
      }
      localObject = aj.getContext().getString(2131764941);
      ad.i("MicroMsg.VoipForegroundService", "voip notification type is 40");
      g.afC();
      if (g.afz().aeI()) {
        break label218;
      }
      ad.e("MicroMsg.VoipForegroundService", "error called voip foreground service in setNotification process");
      paramIntent = q.zld;
      q.dTP();
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
      localObject = aj.getContext().getString(2131764933);
      break;
      label218:
      paramIntent = PendingIntent.getActivity(aj.getContext(), 40, paramIntent, 134217728);
      localObject = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").i((CharSequence)localObject).g(System.currentTimeMillis()).f(v.sh(str)).g((CharSequence)localObject).as(b.cYf());
      ((s.c)localObject).Ew = paramIntent;
      ((s.c)localObject).f(2, true);
      paramIntent = k.c((s.c)localObject);
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, paramIntent, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoipForegroundService
 * JD-Core Version:    0.7.0.1
 */