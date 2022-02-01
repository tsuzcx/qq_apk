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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;

public class SportForegroundService
  extends Service
{
  private static boolean zpo;
  private ao lso;
  
  public static void dUi()
  {
    AppMethodBeat.i(149339);
    if ((d.kZ(26)) && (!zpo))
    {
      ac.i("MicroMsg.Sport.SportForegroundService", "startSportForegroundService");
      zpo = true;
      Intent localIntent = new Intent(ai.getContext(), SportForegroundService.class);
      try
      {
        ai.getContext().startForegroundService(localIntent);
        AppMethodBeat.o(149339);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(149339);
  }
  
  public static void dUj()
  {
    AppMethodBeat.i(149340);
    if (d.kZ(26))
    {
      ac.i("MicroMsg.Sport.SportForegroundService", "stopSportForegroundService");
      zpo = false;
      Intent localIntent = new Intent(ai.getContext(), SportForegroundService.class);
      try
      {
        ai.getContext().stopService(localIntent);
        AppMethodBeat.o(149340);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(149340);
  }
  
  public static boolean dUk()
  {
    return zpo;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(149338);
    ac.i("MicroMsg.Sport.SportForegroundService", "onDestroy");
    if (this.lso != null) {
      this.lso.removeCallbacksAndMessages(null);
    }
    stopForeground(true);
    super.onDestroy();
    AppMethodBeat.o(149338);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149337);
    ac.i("MicroMsg.Sport.SportForegroundService", "onStartCommand %d", new Object[] { Integer.valueOf(paramInt2) });
    if (d.kZ(26))
    {
      Notification.Builder localBuilder = new Notification.Builder(getApplicationContext(), "reminder_channel_id");
      localBuilder.setContentTitle(ai.getResources().getString(2131764117)).setWhen(System.currentTimeMillis());
      startForeground(419430, localBuilder.build());
      ac.i("MicroMsg.Sport.SportForegroundService", "onStartCommand startForeground");
      ((PluginSport)com.tencent.mm.kernel.g.ad(PluginSport.class)).getPushSportStepDetector().dTT();
      this.lso = new ao(Looper.getMainLooper());
      this.lso.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149336);
          SportForegroundService.dUj();
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