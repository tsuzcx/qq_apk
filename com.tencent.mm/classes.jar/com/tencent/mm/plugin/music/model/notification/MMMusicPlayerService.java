package com.tencent.mm.plugin.music.model.notification;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class MMMusicPlayerService
  extends Service
{
  a mzT;
  Runnable mzU = new MMMusicPlayerService.1(this);
  
  public final void c(com.tencent.mm.plugin.music.model.e.a parama)
  {
    y.i("MicroMsg.Music.MMMusicPlayerService", "play");
    if (parama == null)
    {
      y.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
      return;
    }
    ai.S(this.mzU);
    a locala = this.mzT;
    if (!locala.dBn)
    {
      y.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, play err");
      return;
    }
    if (locala.mzL == null)
    {
      y.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      return;
    }
    y.i("MicroMsg.Music.MMMusicNotification", "play");
    ai.S(locala.mzN);
    locala.mzL.startForeground(291, locala.a(locala.mzL, parama, true));
  }
  
  public final void d(com.tencent.mm.plugin.music.model.e.a parama)
  {
    y.i("MicroMsg.Music.MMMusicPlayerService", "pause");
    if (parama == null)
    {
      y.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
      return;
    }
    ai.S(this.mzU);
    a locala = this.mzT;
    if (!locala.dBn)
    {
      y.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, pause err");
      return;
    }
    if (locala.mzL == null)
    {
      y.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      return;
    }
    y.i("MicroMsg.Music.MMMusicNotification", "pause");
    ai.S(locala.mzN);
    locala.mzM.notify(291, locala.a(locala.mzL, parama, false));
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return new MMMusicPlayerService.a(this);
  }
  
  public void onCreate()
  {
    super.onCreate();
    y.i("MicroMsg.Music.MMMusicPlayerService", "onCreate");
    y.i("MicroMsg.Music.MMMusicPlayerService", "init");
    this.mzT = new a();
    a locala = this.mzT;
    y.i("MicroMsg.Music.MMMusicNotification", "init");
    locala.mzL = this;
    locala.mzM = ((NotificationManager)getSystemService("notification"));
    locala.mzO = new a.2(locala);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
    registerReceiver(locala.mzO, localIntentFilter);
    locala.dBn = true;
    refresh();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.Music.MMMusicPlayerService", "onDestroy");
    a locala = this.mzT;
    y.i("MicroMsg.Music.MMMusicNotification", "uninit");
    locala.mzL.unregisterReceiver(locala.mzO);
    locala.mzO = null;
    locala.mzL = null;
    locala.mzM = null;
    locala.dBn = false;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
  
  final void refresh()
  {
    y.i("MicroMsg.Music.MMMusicPlayerService", "initNotification");
    com.tencent.mm.plugin.music.model.e.a locala = ((e)b.Q(e.class)).bna();
    if (locala == null) {
      y.e("MicroMsg.Music.MMMusicPlayerService", "initNotification music is null, return");
    }
    d locald;
    do
    {
      return;
      if (!bk.bl(locala.field_protocol))
      {
        y.e("MicroMsg.Music.MMMusicPlayerService", "exoplayer play audio, ingore");
        return;
      }
      locald = k.bnl().bmY();
      if (locald == null)
      {
        y.e("MicroMsg.Music.MMMusicPlayerService", "musicPlayer is null, return");
        return;
      }
      if (locald.Pu())
      {
        c(locala);
        return;
      }
    } while (!locald.bmj());
    d(locala);
  }
  
  public final void stop()
  {
    y.i("MicroMsg.Music.MMMusicPlayerService", "stop");
    a locala = this.mzT;
    if (!locala.dBn) {
      y.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
    }
    for (;;)
    {
      ai.S(this.mzU);
      ai.l(this.mzU, 60000L);
      return;
      if (locala.mzL == null)
      {
        y.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
      }
      else
      {
        y.i("MicroMsg.Music.MMMusicNotification", "close");
        ai.S(locala.mzN);
        ai.l(locala.mzN, 1000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService
 * JD-Core Version:    0.7.0.1
 */