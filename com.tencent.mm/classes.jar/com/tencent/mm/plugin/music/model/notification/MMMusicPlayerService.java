package com.tencent.mm.plugin.music.model.notification;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.c.b;
import com.tencent.mm.plugin.music.logic.e;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.music.model.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.CopyOnWriteArraySet;

public class MMMusicPlayerService
  extends Service
{
  a LNk;
  Runnable LNl;
  
  public MMMusicPlayerService()
  {
    AppMethodBeat.i(63122);
    this.LNl = new Runnable()
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
  
  final void bDL()
  {
    AppMethodBeat.i(63124);
    Log.i("MicroMsg.Music.MMMusicPlayerService", "initNotification");
    Object localObject = (e)b.bU(e.class);
    if (localObject == null)
    {
      Log.e("MicroMsg.Music.MMMusicPlayerService", "initNotification logic music is null, return");
      AppMethodBeat.o(63124);
      return;
    }
    localObject = ((e)localObject).gnl();
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
    com.tencent.mm.plugin.music.e.a.d locald = j.gnw().gnj();
    if (locald == null)
    {
      Log.e("MicroMsg.Music.MMMusicPlayerService", "musicPlayer is null, return");
      AppMethodBeat.o(63124);
      return;
    }
    if (locald.bLk())
    {
      e((com.tencent.mm.plugin.music.model.e.a)localObject);
      AppMethodBeat.o(63124);
      return;
    }
    if (locald.bLl())
    {
      f((com.tencent.mm.plugin.music.model.e.a)localObject);
      AppMethodBeat.o(63124);
      return;
    }
    AppMethodBeat.o(63124);
  }
  
  public final void e(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63125);
    Log.i("MicroMsg.Music.MMMusicPlayerService", "play");
    if (parama == null)
    {
      Log.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
      AppMethodBeat.o(63125);
      return;
    }
    MMHandlerThread.removeRunnable(this.LNl);
    this.LNk.e(parama);
    AppMethodBeat.o(63125);
  }
  
  public final void f(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63126);
    Log.i("MicroMsg.Music.MMMusicPlayerService", "pause");
    if (parama == null)
    {
      Log.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
      AppMethodBeat.o(63126);
      return;
    }
    MMHandlerThread.removeRunnable(this.LNl);
    this.LNk.f(parama);
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
    this.LNk = new a();
    a locala = this.LNk;
    Log.i("MicroMsg.Music.MMMusicNotification", "init");
    locala.LNd = this;
    locala.Lfw = ((NotificationManager)getSystemService("notification"));
    locala.LNg = new a.2(locala);
    locala.LNe = new a.3(locala);
    Object localObject = com.tencent.mm.plugin.music.model.d.gnU();
    d.c localc = locala.LNe;
    if (localc != null) {
      ((com.tencent.mm.plugin.music.model.d)localObject).LMc.add(localc);
    }
    localObject = new IntentFilter("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
    registerReceiver(locala.LNg, (IntentFilter)localObject);
    locala.isInit = true;
    bDL();
    AppMethodBeat.o(63123);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63128);
    super.onDestroy();
    Log.i("MicroMsg.Music.MMMusicPlayerService", "onDestroy");
    a locala = this.LNk;
    Log.i("MicroMsg.Music.MMMusicNotification", "uninit");
    locala.LNd.unregisterReceiver(locala.LNg);
    com.tencent.mm.plugin.music.model.d locald = com.tencent.mm.plugin.music.model.d.gnU();
    d.c localc = locala.LNe;
    if (localc != null) {
      locald.LMc.remove(localc);
    }
    locala.LNg = null;
    locala.LNd = null;
    locala.Lfw = null;
    locala.isInit = false;
    AppMethodBeat.o(63128);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(63127);
    Log.i("MicroMsg.Music.MMMusicPlayerService", "stop");
    this.LNk.close();
    MMHandlerThread.removeRunnable(this.LNl);
    MMHandlerThread.postToMainThreadDelayed(this.LNl, 60000L);
    AppMethodBeat.o(63127);
  }
  
  public final class a
    extends Binder
  {
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService
 * JD-Core Version:    0.7.0.1
 */