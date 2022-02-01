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
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.c;
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
    g.aAi();
    if (!g.aAf().azp())
    {
      stopSelf();
      AppMethodBeat.o(115789);
      return;
    }
    if (d.oD(26))
    {
      Object localObject = q.GXY;
      q.fHd();
      localObject = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(System.currentTimeMillis()).as(b.ezb());
      ((s.c)localObject).g(2, true);
      localObject = m.e((s.c)localObject);
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
    q localq = q.GXY;
    q.fHf();
    try
    {
      stopForeground(true);
      ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
      g.aAi();
      if (g.aAf().azp())
      {
        sendBroadcast(new Intent("com.tencent.mm.foregroundDestroy"));
        if (c.fFg().dya)
        {
          localq = q.GXY;
          q.fHh();
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
    g.aAi();
    if (!g.aAf().azp())
    {
      Log.e("MicroMsg.VoipForegroundService", "error called voip foreground service in onStartCommand process");
      paramIntent = q.GXY;
      q.fHj();
      stopSelf();
      AppMethodBeat.o(115788);
      return 2;
    }
    Object localObject;
    String str;
    if ((d.oD(26)) && (paramIntent != null))
    {
      Log.i("MicroMsg.VoipForegroundService", "foreground service is on bind ");
      if (paramIntent.getBooleanExtra("isRecalled", false))
      {
        localObject = q.GXY;
        q.fHi();
      }
      localObject = q.GXY;
      q.fHe();
      Log.i("MicroMsg.VoipForegroundService", "setNotificationBind");
      paramIntent.setClass(MMApplicationContext.getContext(), VideoActivity.class);
      paramIntent.setFlags(268435456);
      paramIntent.putExtra("Voip_Call_From", 2);
      str = paramIntent.getStringExtra("Voip_User");
      if (paramIntent.getBooleanExtra("Voip_VideoCall", false)) {
        break label215;
      }
      if (paramIntent.getStringExtra("mTickerText") != null) {
        break label204;
      }
      localObject = MMApplicationContext.getContext().getString(2131767382);
      Log.i("MicroMsg.VoipForegroundService", "voip notification type is 40");
      g.aAi();
      if (g.aAf().azp()) {
        break label229;
      }
      Log.e("MicroMsg.VoipForegroundService", "error called voip foreground service in setNotification process");
      paramIntent = q.GXY;
      q.fHj();
      stopSelf();
    }
    for (;;)
    {
      AppMethodBeat.o(115788);
      return 3;
      label204:
      localObject = paramIntent.getStringExtra("mTickerText");
      break;
      label215:
      localObject = MMApplicationContext.getContext().getString(2131767374);
      break;
      label229:
      paramIntent = PendingIntent.getActivity(MMApplicationContext.getContext(), 40, paramIntent, 134217728);
      localObject = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i((CharSequence)localObject).i(System.currentTimeMillis()).f(aa.getDisplayName(str)).g((CharSequence)localObject).as(b.ezb());
      ((s.c)localObject).Hv = paramIntent;
      ((s.c)localObject).g(2, true);
      paramIntent = m.e((s.c)localObject);
      ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, paramIntent, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoipForegroundService
 * JD-Core Version:    0.7.0.1
 */