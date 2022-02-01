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
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MultiTalkingForegroundService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(114608);
    Log.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onBind");
    if (d.oD(26))
    {
      Log.i("MicroMsg.MultiTalkingForegroundService", "foreground service is on bind MicroMsg.MultiTalkingForegroundService");
      Object localObject = MMApplicationContext.getContext().getString(2131763241);
      String str = MMApplicationContext.getContext().getString(2131763290);
      paramIntent.setClass(MMApplicationContext.getContext(), MultiTalkMainUI.class);
      paramIntent = PendingIntent.getActivity(MMApplicationContext.getContext(), 43, paramIntent, 134217728);
      int i = 2131234305;
      if (d.oE(19)) {
        i = 2131234303;
      }
      localObject = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(str).i(System.currentTimeMillis()).f((CharSequence)localObject).g(str);
      ((s.c)localObject).Hv = paramIntent;
      paramIntent = m.e((s.c)localObject);
      paramIntent.icon = i;
      paramIntent.flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, paramIntent, false);
      startForeground(43, paramIntent);
    }
    AppMethodBeat.o(114608);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(114610);
    Log.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onCreate");
    AppMethodBeat.o(114610);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(114611);
    Log.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onDestroy");
    AppMethodBeat.o(114611);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(114609);
    Log.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onUnbind");
    stopSelf();
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(114609);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.MultiTalkingForegroundService
 * JD-Core Version:    0.7.0.1
 */