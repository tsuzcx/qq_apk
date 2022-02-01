package com.tencent.mm.plugin.music.f;

import android.os.Looper;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.lw.a;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bb.a;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
  implements com.tencent.mm.plugin.music.f.a.d
{
  protected long bci = 0L;
  public boolean dnZ;
  protected long duration = 0L;
  protected long hto = 0L;
  private bb vcW;
  protected boolean vcX;
  protected d.a vcY;
  protected LinkedList<d.a> vgA = new LinkedList();
  protected String vgw = "";
  protected com.tencent.mm.plugin.music.e.d vgx;
  protected com.tencent.mm.plugin.music.e.a vgy;
  protected long vgz = 0L;
  
  public final void C(f paramf)
  {
    ac.i("MicroMsg.Music.BaseMusicPlayer", "onPreparingEvent %b", new Object[] { Boolean.valueOf(aGv()) });
    this.vgw = "waiting";
    lw locallw = new lw();
    locallw.dnW.action = 11;
    locallw.dnW.dnQ = paramf;
    locallw.dnW.state = "waiting";
    locallw.dnW.duration = getDuration();
    locallw.dnW.dnY = dhw();
    com.tencent.mm.sdk.b.a.GpY.a(locallw, Looper.getMainLooper());
  }
  
  public final void D(f paramf)
  {
    ac.i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", new Object[] { Boolean.valueOf(aGv()) });
    this.vgw = "canplay";
    lw locallw = new lw();
    locallw.dnW.action = 9;
    locallw.dnW.dnQ = paramf;
    locallw.dnW.state = "canplay";
    locallw.dnW.duration = getDuration();
    locallw.dnW.dnY = dhw();
    com.tencent.mm.sdk.b.a.GpY.a(locallw, Looper.getMainLooper());
  }
  
  public final void E(f paramf)
  {
    ac.i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(aGv()) });
    this.vgw = "play";
    lw locallw = new lw();
    locallw.dnW.action = 0;
    locallw.dnW.dnQ = paramf;
    locallw.dnW.state = "play";
    locallw.dnW.duration = getDuration();
    locallw.dnW.dnY = dhw();
    com.tencent.mm.sdk.b.a.GpY.a(locallw, Looper.getMainLooper());
    if (this.vgy != null) {
      this.vgy.n(paramf);
    }
  }
  
  public final void F(f paramf)
  {
    ac.i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
    this.vgw = "play";
    lw locallw = new lw();
    locallw.dnW.action = 1;
    locallw.dnW.dnQ = paramf;
    locallw.dnW.state = "play";
    locallw.dnW.duration = getDuration();
    locallw.dnW.dnY = dhw();
    com.tencent.mm.sdk.b.a.GpY.a(locallw, Looper.getMainLooper());
    if (this.vgy != null) {
      this.vgy.o(paramf);
    }
  }
  
  public final void G(f paramf)
  {
    ac.i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
    this.vgw = "pause";
    lw locallw = new lw();
    locallw.dnW.action = 3;
    locallw.dnW.dnQ = paramf;
    locallw.dnW.state = "pause";
    locallw.dnW.duration = getDuration();
    locallw.dnW.dnY = dhw();
    com.tencent.mm.sdk.b.a.GpY.a(locallw, Looper.getMainLooper());
    if (this.vgy != null) {
      this.vgy.p(paramf);
    }
  }
  
  public final void H(f paramf)
  {
    ac.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.vgw = "stop";
    lw locallw = new lw();
    locallw.dnW.action = 2;
    locallw.dnW.dnQ = paramf;
    locallw.dnW.state = "stop";
    locallw.dnW.duration = getDuration();
    locallw.dnW.dnY = dhw();
    lw.a locala = locallw.dnW;
    boolean bool = this.dnZ;
    this.dnZ = false;
    locala.dnZ = bool;
    com.tencent.mm.sdk.b.a.GpY.a(locallw, Looper.getMainLooper());
    if (this.vgy != null) {
      this.vgy.q(paramf);
    }
  }
  
  public final void I(f paramf)
  {
    ac.i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
    this.vgw = "seeked";
    lw locallw = new lw();
    locallw.dnW.action = 8;
    locallw.dnW.dnQ = paramf;
    locallw.dnW.state = "seeked";
    locallw.dnW.duration = getDuration();
    locallw.dnW.dnY = dhw();
    com.tencent.mm.sdk.b.a.GpY.a(locallw, Looper.getMainLooper());
  }
  
  public final void J(f paramf)
  {
    ac.i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
    this.vgw = "seeking";
    lw locallw = new lw();
    locallw.dnW.action = 12;
    locallw.dnW.dnQ = paramf;
    locallw.dnW.state = "seeking";
    locallw.dnW.duration = getDuration();
    locallw.dnW.dnY = dhw();
    com.tencent.mm.sdk.b.a.GpY.a(locallw, Looper.getMainLooper());
  }
  
  public final void K(f paramf)
  {
    ac.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.vgw = "ended";
    lw locallw = new lw();
    locallw.dnW.action = 7;
    locallw.dnW.dnQ = paramf;
    locallw.dnW.state = "ended";
    locallw.dnW.duration = getDuration();
    locallw.dnW.dnX = paramf.hNS;
    locallw.dnW.dnY = dhw();
    com.tencent.mm.sdk.b.a.GpY.a(locallw, Looper.getMainLooper());
    if (this.vgy != null) {
      this.vgy.r(paramf);
    }
  }
  
  public final void L(f paramf)
  {
    ac.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(paramf, -1);
  }
  
  public void a(f paramf, int paramInt1, int paramInt2)
  {
    ac.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(paramf, -1);
  }
  
  public final void a(d.a parama)
  {
    if (parama == null) {}
    while (this.vgA.contains(parama)) {
      return;
    }
    this.vgA.add(parama);
  }
  
  public final void b(d.a parama)
  {
    if (parama == null) {}
    while (!this.vgA.contains(parama)) {
      return;
    }
    this.vgA.remove(parama);
  }
  
  public final void d(f paramf, int paramInt)
  {
    ac.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.vgw = "error";
    lw locallw = new lw();
    locallw.dnW.action = 4;
    locallw.dnW.dnQ = paramf;
    locallw.dnW.state = "error";
    locallw.dnW.duration = getDuration();
    locallw.dnW.dnY = dhw();
    locallw.dnW.errCode = e.JY(paramInt);
    locallw.dnW.errMsg = e.tV(paramInt);
    com.tencent.mm.sdk.b.a.GpY.a(locallw, Looper.getMainLooper());
    if (this.vgy != null) {
      this.vgy.a(paramf, paramInt);
    }
  }
  
  protected final void dhv()
  {
    if (this.vcW != null)
    {
      this.vcW.end();
      this.vcW.eVG();
      this.vcW = null;
    }
  }
  
  protected abstract void dir();
  
  protected final void djg()
  {
    if (this.vcW != null) {
      return;
    }
    if (b.checkSelfPermission(ai.getContext(), "android.permission.READ_PHONE_STATE") != 0)
    {
      ac.e("MicroMsg.Music.BaseMusicPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
      return;
    }
    this.vcW = new bb();
    this.vcW.iR(ai.getContext());
    this.vcW.a(new bb.a()
    {
      public final void kn(int paramAnonymousInt)
      {
        AppMethodBeat.i(137297);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(137297);
          return;
          if (a.this.vcX)
          {
            a.this.vcX = false;
            a.this.resume();
            AppMethodBeat.o(137297);
            return;
            if (a.this.aGv())
            {
              a.this.vcX = true;
              a.this.pause();
            }
          }
        }
      }
    });
  }
  
  protected final String djh()
  {
    return this.vgw;
  }
  
  protected final void eV(int paramInt1, int paramInt2)
  {
    if (this.vcY != null) {
      this.vcY.eV(paramInt1, paramInt2);
    }
    Iterator localIterator = this.vgA.iterator();
    while (localIterator.hasNext()) {
      ((d.a)localIterator.next()).eV(paramInt1, paramInt2);
    }
  }
  
  public void h(f paramf)
  {
    dir();
  }
  
  public void m(f paramf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a
 * JD-Core Version:    0.7.0.1
 */