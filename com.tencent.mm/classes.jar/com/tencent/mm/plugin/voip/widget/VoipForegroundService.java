package com.tencent.mm.plugin.voip.widget;

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
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.c.m;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class VoipForegroundService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(115791);
    Log.i("MicroMsg.VoipForegroundService", "onBind");
    AppMethodBeat.o(115791);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(115789);
    Log.i("MicroMsg.VoipForegroundService", "VoipForegroundService onCreate");
    super.onCreate();
    h.aHH();
    if (!h.aHE().aGM())
    {
      stopSelf();
      AppMethodBeat.o(115789);
      return;
    }
    if (d.qV(26))
    {
      Object localObject = q.NOm;
      q.gzr();
      localObject = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").e(System.currentTimeMillis()).bn(b.fkG());
      ((e.d)localObject).e(2, true);
      localObject = m.e((e.d)localObject);
      try
      {
        if (MMApplicationContext.isMMProcessExist()) {
          Log.i("MicroMsg.VoipForegroundService", "current mmprocess is exits");
        }
        startForeground(40, (Notification)localObject);
        AppMethodBeat.o(115789);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.VoipForegroundService", "start foreground service happened error %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(115789);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115790);
    Log.i("MicroMsg.VoipForegroundService", "VoipForegroundService onDestroy");
    q localq = q.NOm;
    q.gzt();
    try
    {
      stopForeground(true);
      ((com.tencent.mm.plugin.notification.b.a)h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
      h.aHH();
      if (h.aHE().aGM())
      {
        sendBroadcast(new Intent("com.tencent.mm.foregroundDestroy"));
        if (c.gxs().fqP)
        {
          localq = q.NOm;
          q.gzv();
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
        Log.e("MicroMsg.VoipForegroundService", "onDestroy happened error %s", new Object[] { localException });
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115788);
    h.aHH();
    if (!h.aHE().aGM())
    {
      Log.e("MicroMsg.VoipForegroundService", "error called voip foreground service in onStartCommand process");
      paramIntent = q.NOm;
      q.gzx();
      stopSelf();
      AppMethodBeat.o(115788);
      return 2;
    }
    Object localObject;
    String str;
    if ((d.qV(26)) && (paramIntent != null))
    {
      Log.i("MicroMsg.VoipForegroundService", "foreground service is on bind ");
      if (paramIntent.getBooleanExtra("isRecalled", false))
      {
        localObject = q.NOm;
        q.gzw();
      }
      localObject = q.NOm;
      q.gzs();
      Log.i("MicroMsg.VoipForegroundService", "setNotificationBind");
      paramIntent.setClass(MMApplicationContext.getContext(), VideoActivity.class);
      paramIntent.setFlags(268435456);
      paramIntent.putExtra("Voip_Call_From", 2);
      str = paramIntent.getStringExtra("Voip_User");
      if (paramIntent.getBooleanExtra("Voip_VideoCall", false)) {
        break label216;
      }
      if (paramIntent.getStringExtra("mTickerText") != null) {
        break label205;
      }
      localObject = MMApplicationContext.getContext().getString(b.g.voip_voice_is_talking_tip_foreround);
      Log.i("MicroMsg.VoipForegroundService", "voip notification type is 40");
      h.aHH();
      if (h.aHE().aGM()) {
        break label230;
      }
      Log.e("MicroMsg.VoipForegroundService", "error called voip foreground service in setNotification process");
      paramIntent = q.NOm;
      q.gzx();
      stopSelf();
    }
    for (;;)
    {
      AppMethodBeat.o(115788);
      return 3;
      label205:
      localObject = paramIntent.getStringExtra("mTickerText");
      break;
      label216:
      localObject = MMApplicationContext.getContext().getString(b.g.voip_video_is_talking_tip_foreround);
      break;
      label230:
      paramIntent = PendingIntent.getActivity(MMApplicationContext.getContext(), 40, paramIntent, 134217728);
      localObject = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n((CharSequence)localObject).e(System.currentTimeMillis()).k(aa.PJ(str)).l((CharSequence)localObject).bn(b.fkG());
      ((e.d)localObject).Ip = paramIntent;
      ((e.d)localObject).e(2, true);
      paramIntent = m.e((e.d)localObject);
      ((com.tencent.mm.plugin.notification.b.a)h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, paramIntent, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoipForegroundService
 * JD-Core Version:    0.7.0.1
 */