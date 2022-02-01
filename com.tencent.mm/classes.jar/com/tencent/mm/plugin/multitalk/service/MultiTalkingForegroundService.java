package com.tencent.mm.plugin.multitalk.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.notification.b.b;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MultiTalkingForegroundService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(284593);
    Log.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onBind");
    if (d.rb(26))
    {
      Log.i("MicroMsg.MultiTalkingForegroundService", "foreground service is on bind MicroMsg.MultiTalkingForegroundService");
      Object localObject = MMApplicationContext.getContext().getString(a.h.multitalk);
      String str = MMApplicationContext.getContext().getString(a.h.multitalk_recover);
      paramIntent.setClass(MMApplicationContext.getContext(), MultiTalkMainUI.class);
      paramIntent = PendingIntent.getActivity(MMApplicationContext.getContext(), 43, paramIntent, 134217728);
      int i = a.d.notification_icon_gray;
      if (d.rc(19)) {
        i = a.d.notification_icon;
      }
      localObject = a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o(str).bt(System.currentTimeMillis()).l((CharSequence)localObject).m(str);
      ((f.d)localObject).bor = paramIntent;
      paramIntent = m.e((f.d)localObject);
      paramIntent.icon = i;
      paramIntent.flags |= 0x20;
      ((b)h.az(b.class)).getNotification().a(43, paramIntent, false);
      startForeground(43, paramIntent);
    }
    AppMethodBeat.o(284593);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(284599);
    Log.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onCreate");
    AppMethodBeat.o(284599);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(284603);
    Log.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onDestroy");
    AppMethodBeat.o(284603);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(284595);
    Log.i("MicroMsg.MultiTalkingForegroundService", "MultiTalkingForegroundService onUnbind");
    stopSelf();
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(284595);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.service.MultiTalkingForegroundService
 * JD-Core Version:    0.7.0.1
 */