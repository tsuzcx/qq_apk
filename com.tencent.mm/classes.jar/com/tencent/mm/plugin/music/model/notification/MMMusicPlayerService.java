package com.tencent.mm.plugin.music.model.notification;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class MMMusicPlayerService
  extends Service
{
  a Alg;
  Runnable Alh;
  
  public MMMusicPlayerService()
  {
    AppMethodBeat.i(63122);
    this.Alh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63121);
        Log.i("MicroMsg.Music.MMMusicPlayerService", "quit");
        MMHandlerThread.removeRunnable(MMMusicPlayerService.a(MMMusicPlayerService.this));
        MMMusicPlayerService.this.stopSelf();
        AppMethodBeat.o(63121);
      }
    };
    AppMethodBeat.o(63122);
  }
  
  public final void d(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63125);
    Log.i("MicroMsg.Music.MMMusicPlayerService", "play");
    if (parama == null)
    {
      Log.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
      AppMethodBeat.o(63125);
      return;
    }
    MMHandlerThread.removeRunnable(this.Alh);
    this.Alg.d(parama);
    AppMethodBeat.o(63125);
  }
  
  public final void e(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63126);
    Log.i("MicroMsg.Music.MMMusicPlayerService", "pause");
    if (parama == null)
    {
      Log.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
      AppMethodBeat.o(63126);
      return;
    }
    MMHandlerThread.removeRunnable(this.Alh);
    this.Alg.e(parama);
    AppMethodBeat.o(63126);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(63129);
    paramIntent = new a();
    AppMethodBeat.o(63129);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(63123);
    super.onCreate();
    Log.i("MicroMsg.Music.MMMusicPlayerService", "onCreate");
    Log.i("MicroMsg.Music.MMMusicPlayerService", "init");
    this.Alg = new a();
    a locala = this.Alg;
    Log.i("MicroMsg.Music.MMMusicNotification", "init");
    locala.AkZ = this;
    locala.Ala = ((NotificationManager)getSystemService("notification"));
    locala.Alc = new a.2(locala);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
    registerReceiver(locala.Alc, localIntentFilter);
    locala.isInit = true;
    refresh();
    AppMethodBeat.o(63123);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63128);
    super.onDestroy();
    Log.i("MicroMsg.Music.MMMusicPlayerService", "onDestroy");
    a locala = this.Alg;
    Log.i("MicroMsg.Music.MMMusicNotification", "uninit");
    locala.AkZ.unregisterReceiver(locala.Alc);
    locala.Alc = null;
    locala.AkZ = null;
    locala.Ala = null;
    locala.isInit = false;
    AppMethodBeat.o(63128);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
  
  final void refresh()
  {
    AppMethodBeat.i(63124);
    Log.i("MicroMsg.Music.MMMusicPlayerService", "initNotification");
    Object localObject = (e)b.aS(e.class);
    if (localObject == null)
    {
      Log.e("MicroMsg.Music.MMMusicPlayerService", "initNotification logic music is null, return");
      AppMethodBeat.o(63124);
      return;
    }
    localObject = ((e)localObject).etY();
    if (localObject == null)
    {
      Log.e("MicroMsg.Music.MMMusicPlayerService", "initNotification music is null, return");
      AppMethodBeat.o(63124);
      return;
    }
    if (!Util.isNullOrNil(((com.tencent.mm.plugin.music.model.e.a)localObject).field_protocol))
    {
      Log.e("MicroMsg.Music.MMMusicPlayerService", "exoplayer play audio, ingore");
      AppMethodBeat.o(63124);
      return;
    }
    d locald = k.euj().etW();
    if (locald == null)
    {
      Log.e("MicroMsg.Music.MMMusicPlayerService", "musicPlayer is null, return");
      AppMethodBeat.o(63124);
      return;
    }
    if (locald.bec())
    {
      d((com.tencent.mm.plugin.music.model.e.a)localObject);
      AppMethodBeat.o(63124);
      return;
    }
    if (locald.bed())
    {
      e((com.tencent.mm.plugin.music.model.e.a)localObject);
      AppMethodBeat.o(63124);
      return;
    }
    AppMethodBeat.o(63124);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(63127);
    Log.i("MicroMsg.Music.MMMusicPlayerService", "stop");
    this.Alg.close();
    MMHandlerThread.removeRunnable(this.Alh);
    MMHandlerThread.postToMainThreadDelayed(this.Alh, 60000L);
    AppMethodBeat.o(63127);
  }
  
  public final class a
    extends Binder
  {
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService
 * JD-Core Version:    0.7.0.1
 */