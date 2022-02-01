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
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.vendor.MIUI;

public class SportForegroundService
  extends Service
{
  private static boolean SbX;
  private MMHandler tiG;
  
  public static void hun()
  {
    AppMethodBeat.i(149339);
    if (d.rb(26))
    {
      if (MIUI.ifMIUI())
      {
        Log.i("MicroMsg.Sport.SportForegroundService", "miui, not need to start sport foreground");
        AppMethodBeat.o(149339);
        return;
      }
      if ((!SbX) && (!MMApplicationContext.isMMProcessExist()))
      {
        Log.i("MicroMsg.Sport.SportForegroundService", "startSportForegroundService");
        Intent localIntent = new Intent(MMApplicationContext.getContext(), SportForegroundService.class);
        try
        {
          MMApplicationContext.getContext().startForegroundService(localIntent);
          AppMethodBeat.o(149339);
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.Sport.SportForegroundService", localException, "startSportForegroundService", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(149339);
  }
  
  public static void huo()
  {
    AppMethodBeat.i(149340);
    if (d.rb(26))
    {
      Log.i("MicroMsg.Sport.SportForegroundService", "stopSportForegroundService");
      SbX = false;
      Intent localIntent = new Intent(MMApplicationContext.getContext(), SportForegroundService.class);
      try
      {
        MMApplicationContext.getContext().stopService(localIntent);
        AppMethodBeat.o(149340);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(149340);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(149338);
    Log.i("MicroMsg.Sport.SportForegroundService", "onDestroy");
    if (this.tiG != null) {
      this.tiG.removeCallbacksAndMessages(null);
    }
    stopForeground(true);
    super.onDestroy();
    AppMethodBeat.o(149338);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149337);
    Log.i("MicroMsg.Sport.SportForegroundService", "onStartCommand %d", new Object[] { Integer.valueOf(paramInt2) });
    if (d.rb(26))
    {
      Log.i("MicroMsg.Sport.SportForegroundService", "onStartCommand startForeground");
      SbX = true;
      Notification.Builder localBuilder = new Notification.Builder(getApplicationContext(), "reminder_channel_id");
      localBuilder.setContentTitle(MMApplicationContext.getResources().getString(b.e.sport_notification_tips)).setWhen(System.currentTimeMillis());
      startForeground(419430, localBuilder.build());
      ((PluginSport)com.tencent.mm.kernel.h.az(PluginSport.class)).getPushSportStepDetector().hud();
      this.tiG = new MMHandler(Looper.getMainLooper());
      this.tiG.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(149336);
          SportForegroundService.huo();
          AppMethodBeat.o(149336);
        }
      }, 6000L);
    }
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(149337);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.SportForegroundService
 * JD-Core Version:    0.7.0.1
 */