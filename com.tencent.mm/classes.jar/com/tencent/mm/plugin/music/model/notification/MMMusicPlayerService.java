package com.tencent.mm.plugin.music.model.notification;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class MMMusicPlayerService
  extends Service
{
  a oZZ;
  Runnable paa;
  
  public MMMusicPlayerService()
  {
    AppMethodBeat.i(104992);
    this.paa = new MMMusicPlayerService.1(this);
    AppMethodBeat.o(104992);
  }
  
  public final void c(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(104995);
    ab.i("MicroMsg.Music.MMMusicPlayerService", "play");
    if (parama == null)
    {
      ab.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
      AppMethodBeat.o(104995);
      return;
    }
    al.ae(this.paa);
    this.oZZ.c(parama);
    AppMethodBeat.o(104995);
  }
  
  public final void d(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(104996);
    ab.i("MicroMsg.Music.MMMusicPlayerService", "pause");
    if (parama == null)
    {
      ab.e("MicroMsg.Music.MMMusicPlayerService", "music is null, return");
      AppMethodBeat.o(104996);
      return;
    }
    al.ae(this.paa);
    this.oZZ.d(parama);
    AppMethodBeat.o(104996);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(104999);
    paramIntent = new MMMusicPlayerService.a(this);
    AppMethodBeat.o(104999);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(104993);
    super.onCreate();
    ab.i("MicroMsg.Music.MMMusicPlayerService", "onCreate");
    ab.i("MicroMsg.Music.MMMusicPlayerService", "init");
    this.oZZ = new a();
    a locala = this.oZZ;
    ab.i("MicroMsg.Music.MMMusicNotification", "init");
    locala.oZR = this;
    locala.oZS = ((NotificationManager)getSystemService("notification"));
    locala.oZU = new a.2(locala);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mm.Intent.ACTION_MMMUSIC_NOTIFICATION_CLICK");
    registerReceiver(locala.oZU, localIntentFilter);
    locala.bRB = true;
    refresh();
    AppMethodBeat.o(104993);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104998);
    super.onDestroy();
    ab.i("MicroMsg.Music.MMMusicPlayerService", "onDestroy");
    a locala = this.oZZ;
    ab.i("MicroMsg.Music.MMMusicNotification", "uninit");
    locala.oZR.unregisterReceiver(locala.oZU);
    locala.oZU = null;
    locala.oZR = null;
    locala.oZS = null;
    locala.bRB = false;
    AppMethodBeat.o(104998);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
  
  final void refresh()
  {
    AppMethodBeat.i(104994);
    ab.i("MicroMsg.Music.MMMusicPlayerService", "initNotification");
    com.tencent.mm.plugin.music.model.e.a locala = ((e)b.am(e.class)).bVw();
    if (locala == null)
    {
      ab.e("MicroMsg.Music.MMMusicPlayerService", "initNotification music is null, return");
      AppMethodBeat.o(104994);
      return;
    }
    if (!bo.isNullOrNil(locala.field_protocol))
    {
      ab.e("MicroMsg.Music.MMMusicPlayerService", "exoplayer play audio, ingore");
      AppMethodBeat.o(104994);
      return;
    }
    d locald = k.bVH().bVu();
    if (locald == null)
    {
      ab.e("MicroMsg.Music.MMMusicPlayerService", "musicPlayer is null, return");
      AppMethodBeat.o(104994);
      return;
    }
    if (locald.aiw())
    {
      c(locala);
      AppMethodBeat.o(104994);
      return;
    }
    if (locald.aix())
    {
      d(locala);
      AppMethodBeat.o(104994);
      return;
    }
    AppMethodBeat.o(104994);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(104997);
    ab.i("MicroMsg.Music.MMMusicPlayerService", "stop");
    this.oZZ.close();
    al.ae(this.paa);
    al.p(this.paa, 60000L);
    AppMethodBeat.o(104997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService
 * JD-Core Version:    0.7.0.1
 */