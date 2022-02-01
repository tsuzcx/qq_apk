package com.tencent.mm.plugin.multitalk.model;

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
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public class MultiTalkingForegroundService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(114608);
    ad.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onBind");
    if (d.lf(26))
    {
      ad.i("MicroMsg.MultiTalkingForegroundService", "foreground service is on bind MicroMsg.MultiTalkingForegroundService");
      paramIntent = aj.getContext().getString(2131761388);
      String str = aj.getContext().getString(2131761434);
      Object localObject = new Intent();
      ((Intent)localObject).setClass(aj.getContext(), MultiTalkMainUI.class);
      localObject = PendingIntent.getActivity(aj.getContext(), 43, (Intent)localObject, 134217728);
      int i = 2131233502;
      if (d.lg(19)) {
        i = 2131233500;
      }
      paramIntent = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").i(str).g(System.currentTimeMillis()).f(paramIntent).g(str);
      paramIntent.Ew = ((PendingIntent)localObject);
      paramIntent = k.c(paramIntent);
      paramIntent.icon = i;
      paramIntent.flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, paramIntent, false);
      startForeground(43, paramIntent);
    }
    AppMethodBeat.o(114608);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(114610);
    ad.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onCreate");
    AppMethodBeat.o(114610);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(114611);
    ad.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onDestroy");
    AppMethodBeat.o(114611);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(114609);
    ad.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onUnbind");
    stopSelf();
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(114609);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.MultiTalkingForegroundService
 * JD-Core Version:    0.7.0.1
 */