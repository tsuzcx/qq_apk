package com.tencent.mm.plugin.sport.model;

import android.app.Notification.Builder;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;

public class SportForegroundService
  extends Service
{
  private static boolean AHi;
  private ap lRx;
  
  public static void egw()
  {
    AppMethodBeat.i(149339);
    if (d.ly(26))
    {
      if (b.fmu())
      {
        ad.i("MicroMsg.Sport.SportForegroundService", "miui, not need to start sport foreground");
        AppMethodBeat.o(149339);
        return;
      }
      if (!AHi)
      {
        ad.i("MicroMsg.Sport.SportForegroundService", "startSportForegroundService");
        AHi = true;
        Intent localIntent = new Intent(aj.getContext(), SportForegroundService.class);
        try
        {
          aj.getContext().startForegroundService(localIntent);
          AppMethodBeat.o(149339);
          return;
        }
        catch (Exception localException) {}
      }
    }
    AppMethodBeat.o(149339);
  }
  
  public static void egx()
  {
    AppMethodBeat.i(149340);
    if (d.ly(26))
    {
      ad.i("MicroMsg.Sport.SportForegroundService", "stopSportForegroundService");
      AHi = false;
      Intent localIntent = new Intent(aj.getContext(), SportForegroundService.class);
      try
      {
        aj.getContext().stopService(localIntent);
        AppMethodBeat.o(149340);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(149340);
  }
  
  public static boolean egy()
  {
    return AHi;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(149338);
    ad.i("MicroMsg.Sport.SportForegroundService", "onDestroy");
    if (this.lRx != null) {
      this.lRx.removeCallbacksAndMessages(null);
    }
    stopForeground(true);
    super.onDestroy();
    AppMethodBeat.o(149338);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149337);
    ad.i("MicroMsg.Sport.SportForegroundService", "onStartCommand %d", new Object[] { Integer.valueOf(paramInt2) });
    if (d.ly(26))
    {
      Notification.Builder localBuilder = new Notification.Builder(getApplicationContext(), "reminder_channel_id");
      localBuilder.setContentTitle(aj.getResources().getString(2131764117)).setWhen(System.currentTimeMillis());
      startForeground(419430, localBuilder.build());
      ad.i("MicroMsg.Sport.SportForegroundService", "onStartCommand startForeground");
      ((PluginSport)com.tencent.mm.kernel.g.ad(PluginSport.class)).getPushSportStepDetector().egh();
      this.lRx = new ap(Looper.getMainLooper());
      this.lRx.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149336);
          SportForegroundService.egx();
          AppMethodBeat.o(149336);
        }
      }, 6000L);
    }
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(149337);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.SportForegroundService
 * JD-Core Version:    0.7.0.1
 */