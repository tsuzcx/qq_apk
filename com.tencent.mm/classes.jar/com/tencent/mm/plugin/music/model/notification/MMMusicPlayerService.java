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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public class MMMusicPlayerService
  extends Service
{
  a tXj;
  Runnable tXk;
  
  public MMMusicPlayerService()
  {
    AppMethodBeat.i(63122);
    this.tXk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63121);
        ad.i("MicroMsg.Music.MMMusicPlayerService", "quit");
        aq.az(MMMusicPlayerService.a(MMMusicPlayerService.this));
        MMMusicPlayerService.this.stopSelf();
        AppMethodBeat.o(63121);
      }
    };
    AppMethodBeat.o(63122);
  }
  
  public final void c(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63125);
    ad.i("MicroMsg.Music.MMMusicPlayerService", "play");
    if (parama == null)
    {
      ad.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
      AppMethodBeat.o(63125);
      return;
    }
    aq.az(this.tXk);
    this.tXj.c(parama);
    AppMethodBeat.o(63125);
  }
  
  public final void d(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63126);
    ad.i("MicroMsg.Music.MMMusicPlayerService", "pause");
    if (parama == null)
    {
      ad.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
      AppMethodBeat.o(63126);
      return;
    }
    aq.az(this.tXk);
    this.tXj.d(parama);
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
    ad.i("MicroMsg.Music.MMMusicPlayerService", "onCreate");
    ad.i("MicroMsg.Music.MMMusicPlayerService", "init");
    this.tXj = new a();
    a locala = this.tXj;
    ad.i("MicroMsg.Music.MMMusicNotification", "init");
    locala.tXc = this;
    locala.tXd = ((NotificationManager)getSystemService("notification"));
    locala.tXf = new a.2(locala);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
    registerReceiver(locala.tXf, localIntentFilter);
    locala.csX = true;
    refresh();
    AppMethodBeat.o(63123);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63128);
    super.onDestroy();
    ad.i("MicroMsg.Music.MMMusicPlayerService", "onDestroy");
    a locala = this.tXj;
    ad.i("MicroMsg.Music.MMMusicNotification", "uninit");
    locala.tXc.unregisterReceiver(locala.tXf);
    locala.tXf = null;
    locala.tXc = null;
    locala.tXd = null;
    locala.csX = false;
    AppMethodBeat.o(63128);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
  
  final void refresh()
  {
    AppMethodBeat.i(63124);
    ad.i("MicroMsg.Music.MMMusicPlayerService", "initNotification");
    Object localObject = (e)b.aP(e.class);
    if (localObject == null)
    {
      ad.e("MicroMsg.Music.MMMusicPlayerService", "initNotification logic music is null, return");
      AppMethodBeat.o(63124);
      return;
    }
    localObject = ((e)localObject).cUX();
    if (localObject == null)
    {
      ad.e("MicroMsg.Music.MMMusicPlayerService", "initNotification music is null, return");
      AppMethodBeat.o(63124);
      return;
    }
    if (!bt.isNullOrNil(((com.tencent.mm.plugin.music.model.e.a)localObject).field_protocol))
    {
      ad.e("MicroMsg.Music.MMMusicPlayerService", "exoplayer play audio, ingore");
      AppMethodBeat.o(63124);
      return;
    }
    d locald = k.cVi().cUV();
    if (locald == null)
    {
      ad.e("MicroMsg.Music.MMMusicPlayerService", "musicPlayer is null, return");
      AppMethodBeat.o(63124);
      return;
    }
    if (locald.azF())
    {
      c((com.tencent.mm.plugin.music.model.e.a)localObject);
      AppMethodBeat.o(63124);
      return;
    }
    if (locald.azG())
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
    ad.i("MicroMsg.Music.MMMusicPlayerService", "stop");
    this.tXj.close();
    aq.az(this.tXk);
    aq.n(this.tXk, 60000L);
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