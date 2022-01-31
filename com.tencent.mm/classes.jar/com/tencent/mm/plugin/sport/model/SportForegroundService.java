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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

public class SportForegroundService
  extends Service
{
  private static boolean spU;
  private ak ipC;
  
  public static void cyV()
  {
    AppMethodBeat.i(93697);
    if ((d.fv(26)) && (!spU))
    {
      ab.i("MicroMsg.Sport.SportForegroundService", "startSportForegroundService");
      spU = true;
      Intent localIntent = new Intent(ah.getContext(), SportForegroundService.class);
      try
      {
        ah.getContext().startForegroundService(localIntent);
        AppMethodBeat.o(93697);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(93697);
  }
  
  public static void cyW()
  {
    AppMethodBeat.i(93698);
    if ((d.fv(26)) && (spU))
    {
      ab.i("MicroMsg.Sport.SportForegroundService", "stopSportForegroundService");
      spU = false;
      Intent localIntent = new Intent(ah.getContext(), SportForegroundService.class);
      try
      {
        ah.getContext().stopService(localIntent);
        AppMethodBeat.o(93698);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(93698);
  }
  
  public static boolean cyX()
  {
    return spU;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(93696);
    ab.i("MicroMsg.Sport.SportForegroundService", "onDestroy");
    if (this.ipC != null) {
      this.ipC.removeCallbacksAndMessages(null);
    }
    stopForeground(true);
    super.onDestroy();
    AppMethodBeat.o(93696);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93695);
    ab.i("MicroMsg.Sport.SportForegroundService", "onStartCommand %d", new Object[] { Integer.valueOf(paramInt2) });
    if (d.fv(26))
    {
      Notification.Builder localBuilder = new Notification.Builder(getApplicationContext(), "reminder_channel_id");
      localBuilder.setContentTitle(ah.getResources().getString(2131304085)).setWhen(System.currentTimeMillis());
      startForeground(419430, localBuilder.build());
      ab.i("MicroMsg.Sport.SportForegroundService", "onStartCommand startForeground");
      ((PluginSport)com.tencent.mm.kernel.g.G(PluginSport.class)).getPushSportStepDetector().cyF();
      this.ipC = new ak(Looper.getMainLooper());
      this.ipC.postDelayed(new SportForegroundService.1(this), 6000L);
    }
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(93695);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.SportForegroundService
 * JD-Core Version:    0.7.0.1
 */