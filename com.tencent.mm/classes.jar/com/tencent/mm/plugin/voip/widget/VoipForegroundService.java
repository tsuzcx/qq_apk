package com.tencent.mm.plugin.voip.widget;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.plugin.voip.model.q;
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
    com.tencent.mm.kernel.h.baF();
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      stopSelf();
      AppMethodBeat.o(115789);
      return;
    }
    if (d.rb(26))
    {
      Object localObject = q.UBj;
      q.hXn();
      localObject = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), "reminder_channel_id").bt(System.currentTimeMillis()).eb(b.guX());
      ((f.d)localObject).q(2, true);
      localObject = m.e((f.d)localObject);
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
    q localq = q.UBj;
    q.hXp();
    try
    {
      stopForeground(true);
      ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(40);
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
    if (paramIntent == null)
    {
      Log.w("MicroMsg.VoipForegroundService", "null intent");
      AppMethodBeat.o(115788);
      return 2;
    }
    com.tencent.mm.kernel.h.baF();
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      Log.e("MicroMsg.VoipForegroundService", "error called voip foreground service in onStartCommand process");
      paramIntent = q.UBj;
      q.hXs();
      stopSelf();
      AppMethodBeat.o(115788);
      return 2;
    }
    Object localObject;
    if ((d.rb(26)) && (paramIntent != null))
    {
      Log.i("MicroMsg.VoipForegroundService", "foreground service is on bind ");
      if (paramIntent.getBooleanExtra("isRecalled", false))
      {
        localObject = q.UBj;
        q.hXr();
      }
      localObject = q.UBj;
      q.hXo();
      Log.i("MicroMsg.VoipForegroundService", "setNotificationBind");
      Log.i("MicroMsg.VoipForegroundService", "voip notification type is 40");
      com.tencent.mm.kernel.h.baF();
      if (!com.tencent.mm.kernel.h.baC().aZN())
      {
        Log.e("MicroMsg.VoipForegroundService", "error called voip foreground service in setNotification process");
        paramIntent = q.UBj;
        q.hXs();
        stopSelf();
      }
    }
    else
    {
      AppMethodBeat.o(115788);
      return 3;
    }
    paramIntent.setFlags(268435456);
    paramIntent.putExtra("Voip_Call_From", 2);
    String str = paramIntent.getStringExtra("Voip_User");
    boolean bool = paramIntent.getBooleanExtra("Voip_VideoCall", false);
    paramIntent.getBooleanExtra("Voip_Outcall", false);
    if (com.tencent.mm.plugin.voip.f.h.ibz()) {
      if (com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.flutter.voip.a.a.class) != null)
      {
        localObject = ((com.tencent.mm.plugin.flutter.voip.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.flutter.voip.a.a.class)).aQ(MMApplicationContext.getContext(), str);
        label230:
        if (bool) {
          break label398;
        }
        if (((Intent)localObject).getStringExtra("mTickerText") != null) {
          break label387;
        }
        paramIntent = MMApplicationContext.getContext().getString(b.g.voip_voice_is_talking_tip_foreround);
      }
    }
    for (;;)
    {
      localObject = PendingIntent.getActivity(MMApplicationContext.getContext(), 40, (Intent)localObject, 134217728);
      paramIntent = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o(paramIntent).bt(System.currentTimeMillis()).l(aa.getDisplayName(str)).m(paramIntent).eb(b.guX());
      paramIntent.bor = ((PendingIntent)localObject);
      paramIntent.q(2, true);
      paramIntent = m.e(paramIntent);
      ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().a(40, paramIntent, false);
      break;
      Log.e("MicroMsg.VoipForegroundService", "error called voip foreground service in setNotification process");
      paramIntent = q.UBj;
      q.hXs();
      stopSelf();
      break;
      paramIntent.setClass(MMApplicationContext.getContext(), VideoActivity.class);
      localObject = paramIntent;
      break label230;
      label387:
      paramIntent = ((Intent)localObject).getStringExtra("mTickerText");
      continue;
      label398:
      paramIntent = MMApplicationContext.getContext().getString(b.g.voip_video_is_talking_tip_foreround);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoipForegroundService
 * JD-Core Version:    0.7.0.1
 */