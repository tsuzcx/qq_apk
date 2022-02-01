package com.tencent.mm.plugin.multitalk.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.c.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MultiTalkingForegroundService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(114608);
    Log.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onBind");
    if (d.qV(26))
    {
      Log.i("MicroMsg.MultiTalkingForegroundService", "foreground service is on bind MicroMsg.MultiTalkingForegroundService");
      Object localObject = MMApplicationContext.getContext().getString(a.h.multitalk);
      String str = MMApplicationContext.getContext().getString(a.h.multitalk_recover);
      paramIntent.setClass(MMApplicationContext.getContext(), MultiTalkMainUI.class);
      paramIntent = PendingIntent.getActivity(MMApplicationContext.getContext(), 43, paramIntent, 134217728);
      int i = a.d.notification_icon_gray;
      if (d.qW(19)) {
        i = a.d.notification_icon;
      }
      localObject = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n(str).e(System.currentTimeMillis()).k((CharSequence)localObject).l(str);
      ((e.d)localObject).Ip = paramIntent;
      paramIntent = m.e((e.d)localObject);
      paramIntent.icon = i;
      paramIntent.flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.a)h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, paramIntent, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.MultiTalkingForegroundService
 * JD-Core Version:    0.7.0.1
 */