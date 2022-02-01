package com.tencent.mm.plugin.music.f;

import android.os.Looper;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.mg.a;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
  implements com.tencent.mm.plugin.music.f.a.d
{
  protected long bmD = 0L;
  public boolean dAS;
  protected long duration = 0L;
  protected long hOz = 0L;
  protected String wBA = "";
  protected com.tencent.mm.plugin.music.e.d wBB;
  protected com.tencent.mm.plugin.music.e.a wBC;
  protected long wBD = 0L;
  protected LinkedList<d.a> wBE = new LinkedList();
  private bd wxX;
  protected boolean wxY;
  protected d.a wxZ;
  
  public final void C(f paramf)
  {
    ae.i("MicroMsg.Music.BaseMusicPlayer", "onPreparingEvent %b", new Object[] { Boolean.valueOf(aJZ()) });
    this.wBA = "waiting";
    mg localmg = new mg();
    localmg.dAP.action = 11;
    localmg.dAP.dAJ = paramf;
    localmg.dAP.state = "waiting";
    localmg.dAP.duration = getDuration();
    localmg.dAP.dAR = duY();
    com.tencent.mm.sdk.b.a.IvT.a(localmg, Looper.getMainLooper());
  }
  
  public final void D(f paramf)
  {
    ae.i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", new Object[] { Boolean.valueOf(aJZ()) });
    this.wBA = "canplay";
    mg localmg = new mg();
    localmg.dAP.action = 9;
    localmg.dAP.dAJ = paramf;
    localmg.dAP.state = "canplay";
    localmg.dAP.duration = getDuration();
    localmg.dAP.dAR = duY();
    com.tencent.mm.sdk.b.a.IvT.a(localmg, Looper.getMainLooper());
  }
  
  public final void E(f paramf)
  {
    ae.i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(aJZ()) });
    this.wBA = "play";
    mg localmg = new mg();
    localmg.dAP.action = 0;
    localmg.dAP.dAJ = paramf;
    localmg.dAP.state = "play";
    localmg.dAP.duration = getDuration();
    localmg.dAP.dAR = duY();
    com.tencent.mm.sdk.b.a.IvT.a(localmg, Looper.getMainLooper());
    if (this.wBC != null) {
      this.wBC.n(paramf);
    }
  }
  
  public final void F(f paramf)
  {
    ae.i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
    this.wBA = "play";
    mg localmg = new mg();
    localmg.dAP.action = 1;
    localmg.dAP.dAJ = paramf;
    localmg.dAP.state = "play";
    localmg.dAP.duration = getDuration();
    localmg.dAP.dAR = duY();
    com.tencent.mm.sdk.b.a.IvT.a(localmg, Looper.getMainLooper());
    if (this.wBC != null) {
      this.wBC.o(paramf);
    }
  }
  
  public final void G(f paramf)
  {
    ae.i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
    this.wBA = "pause";
    mg localmg = new mg();
    localmg.dAP.action = 3;
    localmg.dAP.dAJ = paramf;
    localmg.dAP.state = "pause";
    localmg.dAP.duration = getDuration();
    localmg.dAP.dAR = duY();
    com.tencent.mm.sdk.b.a.IvT.a(localmg, Looper.getMainLooper());
    if (this.wBC != null) {
      this.wBC.p(paramf);
    }
  }
  
  public final void H(f paramf)
  {
    ae.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.wBA = "stop";
    mg localmg = new mg();
    localmg.dAP.action = 2;
    localmg.dAP.dAJ = paramf;
    localmg.dAP.state = "stop";
    localmg.dAP.duration = getDuration();
    localmg.dAP.dAR = duY();
    mg.a locala = localmg.dAP;
    boolean bool = this.dAS;
    this.dAS = false;
    locala.dAS = bool;
    com.tencent.mm.sdk.b.a.IvT.a(localmg, Looper.getMainLooper());
    if (this.wBC != null) {
      this.wBC.q(paramf);
    }
  }
  
  public final void I(f paramf)
  {
    ae.i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
    this.wBA = "seeked";
    mg localmg = new mg();
    localmg.dAP.action = 8;
    localmg.dAP.dAJ = paramf;
    localmg.dAP.state = "seeked";
    localmg.dAP.duration = getDuration();
    localmg.dAP.dAR = duY();
    com.tencent.mm.sdk.b.a.IvT.a(localmg, Looper.getMainLooper());
  }
  
  public final void J(f paramf)
  {
    ae.i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
    this.wBA = "seeking";
    mg localmg = new mg();
    localmg.dAP.action = 12;
    localmg.dAP.dAJ = paramf;
    localmg.dAP.state = "seeking";
    localmg.dAP.duration = getDuration();
    localmg.dAP.dAR = duY();
    com.tencent.mm.sdk.b.a.IvT.a(localmg, Looper.getMainLooper());
  }
  
  public final void K(f paramf)
  {
    ae.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.wBA = "ended";
    mg localmg = new mg();
    localmg.dAP.action = 7;
    localmg.dAP.dAJ = paramf;
    localmg.dAP.state = "ended";
    localmg.dAP.duration = getDuration();
    localmg.dAP.dAQ = paramf.ijZ;
    localmg.dAP.dAR = duY();
    com.tencent.mm.sdk.b.a.IvT.a(localmg, Looper.getMainLooper());
    if (this.wBC != null) {
      this.wBC.r(paramf);
    }
  }
  
  public final void L(f paramf)
  {
    ae.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(paramf, -1);
  }
  
  public void a(f paramf, int paramInt1, int paramInt2)
  {
    ae.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(paramf, -1);
  }
  
  public final void a(d.a parama)
  {
    if (parama == null) {}
    while (this.wBE.contains(parama)) {
      return;
    }
    this.wBE.add(parama);
  }
  
  public final void b(d.a parama)
  {
    if (parama == null) {}
    while (!this.wBE.contains(parama)) {
      return;
    }
    this.wBE.remove(parama);
  }
  
  public final void d(f paramf, int paramInt)
  {
    ae.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.wBA = "error";
    mg localmg = new mg();
    localmg.dAP.action = 4;
    localmg.dAP.dAJ = paramf;
    localmg.dAP.state = "error";
    localmg.dAP.duration = getDuration();
    localmg.dAP.dAR = duY();
    localmg.dAP.errCode = e.Mf(paramInt);
    localmg.dAP.errMsg = e.uF(paramInt);
    com.tencent.mm.sdk.b.a.IvT.a(localmg, Looper.getMainLooper());
    if (this.wBC != null) {
      this.wBC.a(paramf, paramInt);
    }
  }
  
  protected final void duW()
  {
    if (this.wxX != null)
    {
      this.wxX.end();
      this.wxX.fpi();
      this.wxX = null;
    }
  }
  
  protected abstract void dvS();
  
  protected final void dwH()
  {
    if (this.wxX != null) {
      return;
    }
    if (b.checkSelfPermission(ak.getContext(), "android.permission.READ_PHONE_STATE") != 0)
    {
      ae.e("MicroMsg.Music.BaseMusicPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
      return;
    }
    this.wxX = new bd();
    this.wxX.jg(ak.getContext());
    this.wxX.a(new bd.a()
    {
      public final void kM(int paramAnonymousInt)
      {
        AppMethodBeat.i(137297);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(137297);
          return;
          if (a.this.wxY)
          {
            a.this.wxY = false;
            a.this.resume();
            AppMethodBeat.o(137297);
            return;
            if (a.this.aJZ())
            {
              a.this.wxY = true;
              a.this.pause();
            }
          }
        }
      }
    });
  }
  
  protected final String dwI()
  {
    return this.wBA;
  }
  
  protected final void fa(int paramInt1, int paramInt2)
  {
    if (this.wxZ != null) {
      this.wxZ.fa(paramInt1, paramInt2);
    }
    Iterator localIterator = this.wBE.iterator();
    while (localIterator.hasNext()) {
      ((d.a)localIterator.next()).fa(paramInt1, paramInt2);
    }
  }
  
  public void h(f paramf)
  {
    dvS();
  }
  
  public void m(f paramf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a
 * JD-Core Version:    0.7.0.1
 */