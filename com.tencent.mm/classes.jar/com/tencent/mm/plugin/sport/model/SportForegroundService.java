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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;

public class SportForegroundService
  extends Service
{
  private static boolean AYL;
  private aq lVY;
  
  public static void eke()
  {
    AppMethodBeat.i(149339);
    if (d.lA(26))
    {
      if (b.fqp())
      {
        ae.i("MicroMsg.Sport.SportForegroundService", "miui, not need to start sport foreground");
        AppMethodBeat.o(149339);
        return;
      }
      if (!AYL)
      {
        ae.i("MicroMsg.Sport.SportForegroundService", "startSportForegroundService");
        AYL = true;
        Intent localIntent = new Intent(ak.getContext(), SportForegroundService.class);
        try
        {
          ak.getContext().startForegroundService(localIntent);
          AppMethodBeat.o(149339);
          return;
        }
        catch (Exception localException) {}
      }
    }
    AppMethodBeat.o(149339);
  }
  
  public static void ekf()
  {
    AppMethodBeat.i(149340);
    if (d.lA(26))
    {
      ae.i("MicroMsg.Sport.SportForegroundService", "stopSportForegroundService");
      AYL = false;
      Intent localIntent = new Intent(ak.getContext(), SportForegroundService.class);
      try
      {
        ak.getContext().stopService(localIntent);
        AppMethodBeat.o(149340);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(149340);
  }
  
  public static boolean ekg()
  {
    return AYL;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(149338);
    ae.i("MicroMsg.Sport.SportForegroundService", "onDestroy");
    if (this.lVY != null) {
      this.lVY.removeCallbacksAndMessages(null);
    }
    stopForeground(true);
    super.onDestroy();
    AppMethodBeat.o(149338);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149337);
    ae.i("MicroMsg.Sport.SportForegroundService", "onStartCommand %d", new Object[] { Integer.valueOf(paramInt2) });
    if (d.lA(26))
    {
      Notification.Builder localBuilder = new Notification.Builder(getApplicationContext(), "reminder_channel_id");
      localBuilder.setContentTitle(ak.getResources().getString(2131764117)).setWhen(System.currentTimeMillis());
      startForeground(419430, localBuilder.build());
      ae.i("MicroMsg.Sport.SportForegroundService", "onStartCommand startForeground");
      ((PluginSport)com.tencent.mm.kernel.g.ad(PluginSport.class)).getPushSportStepDetector().ejP();
      this.lVY = new aq(Looper.getMainLooper());
      this.lVY.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149336);
          SportForegroundService.ekf();
          AppMethodBeat.o(149336);
        }
      }, 6000L);
    }
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(149337);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.SportForegroundService
 * JD-Core Version:    0.7.0.1
 */