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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public class MMMusicPlayerService
  extends Service
{
  a vfV;
  Runnable vfW;
  
  public MMMusicPlayerService()
  {
    AppMethodBeat.i(63122);
    this.vfW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63121);
        ac.i("MicroMsg.Music.MMMusicPlayerService", "quit");
        ap.aB(MMMusicPlayerService.a(MMMusicPlayerService.this));
        MMMusicPlayerService.this.stopSelf();
        AppMethodBeat.o(63121);
      }
    };
    AppMethodBeat.o(63122);
  }
  
  public final void c(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63125);
    ac.i("MicroMsg.Music.MMMusicPlayerService", "play");
    if (parama == null)
    {
      ac.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
      AppMethodBeat.o(63125);
      return;
    }
    ap.aB(this.vfW);
    this.vfV.c(parama);
    AppMethodBeat.o(63125);
  }
  
  public final void d(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63126);
    ac.i("MicroMsg.Music.MMMusicPlayerService", "pause");
    if (parama == null)
    {
      ac.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
      AppMethodBeat.o(63126);
      return;
    }
    ap.aB(this.vfW);
    this.vfV.d(parama);
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
    ac.i("MicroMsg.Music.MMMusicPlayerService", "onCreate");
    ac.i("MicroMsg.Music.MMMusicPlayerService", "init");
    this.vfV = new a();
    a locala = this.vfV;
    ac.i("MicroMsg.Music.MMMusicNotification", "init");
    locala.vfO = this;
    locala.vfP = ((NotificationManager)getSystemService("notification"));
    locala.vfR = new a.2(locala);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
    registerReceiver(locala.vfR, localIntentFilter);
    locala.cqf = true;
    refresh();
    AppMethodBeat.o(63123);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63128);
    super.onDestroy();
    ac.i("MicroMsg.Music.MMMusicPlayerService", "onDestroy");
    a locala = this.vfV;
    ac.i("MicroMsg.Music.MMMusicNotification", "uninit");
    locala.vfO.unregisterReceiver(locala.vfR);
    locala.vfR = null;
    locala.vfO = null;
    locala.vfP = null;
    locala.cqf = false;
    AppMethodBeat.o(63128);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
  
  final void refresh()
  {
    AppMethodBeat.i(63124);
    ac.i("MicroMsg.Music.MMMusicPlayerService", "initNotification");
    Object localObject = (e)b.aQ(e.class);
    if (localObject == null)
    {
      ac.e("MicroMsg.Music.MMMusicPlayerService", "initNotification logic music is null, return");
      AppMethodBeat.o(63124);
      return;
    }
    localObject = ((e)localObject).diD();
    if (localObject == null)
    {
      ac.e("MicroMsg.Music.MMMusicPlayerService", "initNotification music is null, return");
      AppMethodBeat.o(63124);
      return;
    }
    if (!bs.isNullOrNil(((com.tencent.mm.plugin.music.model.e.a)localObject).field_protocol))
    {
      ac.e("MicroMsg.Music.MMMusicPlayerService", "exoplayer play audio, ingore");
      AppMethodBeat.o(63124);
      return;
    }
    d locald = k.diO().diB();
    if (locald == null)
    {
      ac.e("MicroMsg.Music.MMMusicPlayerService", "musicPlayer is null, return");
      AppMethodBeat.o(63124);
      return;
    }
    if (locald.aGv())
    {
      c((com.tencent.mm.plugin.music.model.e.a)localObject);
      AppMethodBeat.o(63124);
      return;
    }
    if (locald.aGw())
    {
      d((com.tencent.mm.plugin.music.model.e.a)localObject);
      AppMethodBeat.o(63124);
      return;
    }
    AppMethodBeat.o(63124);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(63127);
    ac.i("MicroMsg.Music.MMMusicPlayerService", "stop");
    this.vfV.close();
    ap.aB(this.vfW);
    ap.n(this.vfW, 60000L);
    AppMethodBeat.o(63127);
  }
  
  public final class a
    extends Binder
  {
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService
 * JD-Core Version:    0.7.0.1
 */