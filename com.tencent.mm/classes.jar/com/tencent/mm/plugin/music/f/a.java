package com.tencent.mm.plugin.music.f;

import android.os.Looper;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.mx.a;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
  implements com.tencent.mm.plugin.music.f.a.d
{
  protected boolean AhH;
  protected d.a AhI;
  private PhoneStatusWatcher Ahk;
  protected String AlI = "";
  protected com.tencent.mm.plugin.music.e.d AlJ;
  protected com.tencent.mm.plugin.music.e.a AlK;
  protected long AlL = 0L;
  protected LinkedList<d.a> AlM = new LinkedList();
  protected long bmy = 0L;
  public boolean dSH;
  protected long duration = 0L;
  protected long iJF = 0L;
  
  public final void G(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onPreparingEvent %b", new Object[] { Boolean.valueOf(bec()) });
    this.AlI = "waiting";
    mx localmx = new mx();
    localmx.dSE.action = 11;
    localmx.dSE.dSy = paramf;
    localmx.dSE.state = "waiting";
    localmx.dSE.duration = getDuration();
    localmx.dSE.dSG = esV();
    EventCenter.instance.asyncPublish(localmx, Looper.getMainLooper());
  }
  
  public final void H(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", new Object[] { Boolean.valueOf(bec()) });
    this.AlI = "canplay";
    mx localmx = new mx();
    localmx.dSE.action = 9;
    localmx.dSE.dSy = paramf;
    localmx.dSE.state = "canplay";
    localmx.dSE.duration = getDuration();
    localmx.dSE.dSG = esV();
    EventCenter.instance.asyncPublish(localmx, Looper.getMainLooper());
  }
  
  public final void I(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(bec()) });
    this.AlI = "play";
    mx localmx = new mx();
    localmx.dSE.action = 0;
    localmx.dSE.dSy = paramf;
    localmx.dSE.state = "play";
    localmx.dSE.duration = getDuration();
    localmx.dSE.dSG = esV();
    EventCenter.instance.asyncPublish(localmx, Looper.getMainLooper());
    if (this.AlK != null) {
      this.AlK.n(paramf);
    }
  }
  
  public final void J(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
    this.AlI = "play";
    mx localmx = new mx();
    localmx.dSE.action = 1;
    localmx.dSE.dSy = paramf;
    localmx.dSE.state = "play";
    localmx.dSE.duration = getDuration();
    localmx.dSE.dSG = esV();
    EventCenter.instance.asyncPublish(localmx, Looper.getMainLooper());
    if (this.AlK != null) {
      this.AlK.o(paramf);
    }
  }
  
  public final void K(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
    this.AlI = "pause";
    mx localmx = new mx();
    localmx.dSE.action = 3;
    localmx.dSE.dSy = paramf;
    localmx.dSE.state = "pause";
    localmx.dSE.duration = getDuration();
    localmx.dSE.dSG = esV();
    EventCenter.instance.asyncPublish(localmx, Looper.getMainLooper());
    if (this.AlK != null) {
      this.AlK.p(paramf);
    }
  }
  
  public final void L(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.AlI = "stop";
    mx localmx = new mx();
    localmx.dSE.action = 2;
    localmx.dSE.dSy = paramf;
    localmx.dSE.state = "stop";
    localmx.dSE.duration = getDuration();
    localmx.dSE.dSG = esV();
    mx.a locala = localmx.dSE;
    boolean bool = this.dSH;
    this.dSH = false;
    locala.dSH = bool;
    EventCenter.instance.asyncPublish(localmx, Looper.getMainLooper());
    if (this.AlK != null) {
      this.AlK.q(paramf);
    }
  }
  
  public final void M(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
    this.AlI = "seeked";
    mx localmx = new mx();
    localmx.dSE.action = 8;
    localmx.dSE.dSy = paramf;
    localmx.dSE.state = "seeked";
    localmx.dSE.duration = getDuration();
    localmx.dSE.dSG = esV();
    EventCenter.instance.asyncPublish(localmx, Looper.getMainLooper());
  }
  
  public final void N(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
    this.AlI = "seeking";
    mx localmx = new mx();
    localmx.dSE.action = 12;
    localmx.dSE.dSy = paramf;
    localmx.dSE.state = "seeking";
    localmx.dSE.duration = getDuration();
    localmx.dSE.dSG = esV();
    EventCenter.instance.asyncPublish(localmx, Looper.getMainLooper());
  }
  
  public final void O(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.AlI = "ended";
    mx localmx = new mx();
    localmx.dSE.action = 7;
    localmx.dSE.dSy = paramf;
    localmx.dSE.state = "ended";
    localmx.dSE.duration = getDuration();
    localmx.dSE.dSF = paramf.jeV;
    localmx.dSE.dSG = esV();
    EventCenter.instance.asyncPublish(localmx, Looper.getMainLooper());
    if (this.AlK != null) {
      this.AlK.r(paramf);
    }
  }
  
  public final void P(f paramf)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(paramf, -1);
  }
  
  public void a(f paramf, int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(paramf, -1);
  }
  
  public final void a(d.a parama)
  {
    this.AhI = parama;
  }
  
  public final void b(d.a parama)
  {
    if (parama == null) {}
    while (this.AlM.contains(parama)) {
      return;
    }
    this.AlM.add(parama);
  }
  
  public final void c(d.a parama)
  {
    if (parama == null) {}
    while (!this.AlM.contains(parama)) {
      return;
    }
    this.AlM.remove(parama);
  }
  
  public final void d(f paramf, int paramInt)
  {
    Log.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.AlI = "error";
    mx localmx = new mx();
    localmx.dSE.action = 4;
    localmx.dSE.dSy = paramf;
    localmx.dSE.state = "error";
    localmx.dSE.duration = getDuration();
    localmx.dSE.dSG = esV();
    localmx.dSE.errCode = e.Tc(paramInt);
    localmx.dSE.errMsg = e.yw(paramInt);
    EventCenter.instance.asyncPublish(localmx, Looper.getMainLooper());
    if (this.AlK != null) {
      this.AlK.a(paramf, paramInt);
    }
  }
  
  protected final void esT()
  {
    if (this.Ahk != null)
    {
      this.Ahk.end();
      this.Ahk.clearPhoneCallListener();
      this.Ahk = null;
    }
  }
  
  protected abstract void etM();
  
  protected final void euP()
  {
    if (this.Ahk != null) {
      return;
    }
    if (b.checkSelfPermission(MMApplicationContext.getContext(), "android.permission.READ_PHONE_STATE") != 0)
    {
      Log.e("MicroMsg.Music.BaseMusicPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
      return;
    }
    this.Ahk = new PhoneStatusWatcher();
    this.Ahk.begin(MMApplicationContext.getContext());
    this.Ahk.addPhoneCallListener(new PhoneStatusWatcher.PhoneCallListener()
    {
      public final void onPhoneCall(int paramAnonymousInt)
      {
        AppMethodBeat.i(137297);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(137297);
          return;
          if (a.this.AhH)
          {
            a.this.AhH = false;
            a.this.resume();
            AppMethodBeat.o(137297);
            return;
            if (a.this.bec())
            {
              a.this.AhH = true;
              a.this.pause();
            }
          }
        }
      }
    });
  }
  
  protected final String euQ()
  {
    return this.AlI;
  }
  
  protected final void fn(int paramInt1, int paramInt2)
  {
    if (this.AhI != null) {
      this.AhI.fn(paramInt1, paramInt2);
    }
    Iterator localIterator = this.AlM.iterator();
    while (localIterator.hasNext()) {
      ((d.a)localIterator.next()).fn(paramInt1, paramInt2);
    }
  }
  
  public void h(f paramf)
  {
    etM();
  }
  
  public void m(f paramf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a
 * JD-Core Version:    0.7.0.1
 */