package com.tencent.mm.plugin.music.f;

import android.os.Looper;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.mf.a;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
  implements com.tencent.mm.plugin.music.f.a.d
{
  protected long bmD = 0L;
  protected long duration = 0L;
  public boolean dzN;
  protected long hLG = 0L;
  private bc wis;
  protected boolean wit;
  protected d.a wiu;
  protected String wlR = "";
  protected com.tencent.mm.plugin.music.e.d wlS;
  protected com.tencent.mm.plugin.music.e.a wlT;
  protected long wlU = 0L;
  protected LinkedList<d.a> wlV = new LinkedList();
  
  public final void C(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onPreparingEvent %b", new Object[] { Boolean.valueOf(aJG()) });
    this.wlR = "waiting";
    mf localmf = new mf();
    localmf.dzK.action = 11;
    localmf.dzK.dzE = paramf;
    localmf.dzK.state = "waiting";
    localmf.dzK.duration = getDuration();
    localmf.dzK.dzM = drK();
    com.tencent.mm.sdk.b.a.IbL.a(localmf, Looper.getMainLooper());
  }
  
  public final void D(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", new Object[] { Boolean.valueOf(aJG()) });
    this.wlR = "canplay";
    mf localmf = new mf();
    localmf.dzK.action = 9;
    localmf.dzK.dzE = paramf;
    localmf.dzK.state = "canplay";
    localmf.dzK.duration = getDuration();
    localmf.dzK.dzM = drK();
    com.tencent.mm.sdk.b.a.IbL.a(localmf, Looper.getMainLooper());
  }
  
  public final void E(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(aJG()) });
    this.wlR = "play";
    mf localmf = new mf();
    localmf.dzK.action = 0;
    localmf.dzK.dzE = paramf;
    localmf.dzK.state = "play";
    localmf.dzK.duration = getDuration();
    localmf.dzK.dzM = drK();
    com.tencent.mm.sdk.b.a.IbL.a(localmf, Looper.getMainLooper());
    if (this.wlT != null) {
      this.wlT.n(paramf);
    }
  }
  
  public final void F(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
    this.wlR = "play";
    mf localmf = new mf();
    localmf.dzK.action = 1;
    localmf.dzK.dzE = paramf;
    localmf.dzK.state = "play";
    localmf.dzK.duration = getDuration();
    localmf.dzK.dzM = drK();
    com.tencent.mm.sdk.b.a.IbL.a(localmf, Looper.getMainLooper());
    if (this.wlT != null) {
      this.wlT.o(paramf);
    }
  }
  
  public final void G(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
    this.wlR = "pause";
    mf localmf = new mf();
    localmf.dzK.action = 3;
    localmf.dzK.dzE = paramf;
    localmf.dzK.state = "pause";
    localmf.dzK.duration = getDuration();
    localmf.dzK.dzM = drK();
    com.tencent.mm.sdk.b.a.IbL.a(localmf, Looper.getMainLooper());
    if (this.wlT != null) {
      this.wlT.p(paramf);
    }
  }
  
  public final void H(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.wlR = "stop";
    mf localmf = new mf();
    localmf.dzK.action = 2;
    localmf.dzK.dzE = paramf;
    localmf.dzK.state = "stop";
    localmf.dzK.duration = getDuration();
    localmf.dzK.dzM = drK();
    mf.a locala = localmf.dzK;
    boolean bool = this.dzN;
    this.dzN = false;
    locala.dzN = bool;
    com.tencent.mm.sdk.b.a.IbL.a(localmf, Looper.getMainLooper());
    if (this.wlT != null) {
      this.wlT.q(paramf);
    }
  }
  
  public final void I(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
    this.wlR = "seeked";
    mf localmf = new mf();
    localmf.dzK.action = 8;
    localmf.dzK.dzE = paramf;
    localmf.dzK.state = "seeked";
    localmf.dzK.duration = getDuration();
    localmf.dzK.dzM = drK();
    com.tencent.mm.sdk.b.a.IbL.a(localmf, Looper.getMainLooper());
  }
  
  public final void J(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
    this.wlR = "seeking";
    mf localmf = new mf();
    localmf.dzK.action = 12;
    localmf.dzK.dzE = paramf;
    localmf.dzK.state = "seeking";
    localmf.dzK.duration = getDuration();
    localmf.dzK.dzM = drK();
    com.tencent.mm.sdk.b.a.IbL.a(localmf, Looper.getMainLooper());
  }
  
  public final void K(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.wlR = "ended";
    mf localmf = new mf();
    localmf.dzK.action = 7;
    localmf.dzK.dzE = paramf;
    localmf.dzK.state = "ended";
    localmf.dzK.duration = getDuration();
    localmf.dzK.dzL = paramf.ihg;
    localmf.dzK.dzM = drK();
    com.tencent.mm.sdk.b.a.IbL.a(localmf, Looper.getMainLooper());
    if (this.wlT != null) {
      this.wlT.r(paramf);
    }
  }
  
  public final void L(f paramf)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(paramf, -1);
  }
  
  public void a(f paramf, int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    d(paramf, -1);
  }
  
  public final void a(d.a parama)
  {
    if (parama == null) {}
    while (this.wlV.contains(parama)) {
      return;
    }
    this.wlV.add(parama);
  }
  
  public final void b(d.a parama)
  {
    if (parama == null) {}
    while (!this.wlV.contains(parama)) {
      return;
    }
    this.wlV.remove(parama);
  }
  
  public final void d(f paramf, int paramInt)
  {
    ad.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.wlR = "error";
    mf localmf = new mf();
    localmf.dzK.action = 4;
    localmf.dzK.dzE = paramf;
    localmf.dzK.state = "error";
    localmf.dzK.duration = getDuration();
    localmf.dzK.dzM = drK();
    localmf.dzK.errCode = e.LA(paramInt);
    localmf.dzK.errMsg = e.uz(paramInt);
    com.tencent.mm.sdk.b.a.IbL.a(localmf, Looper.getMainLooper());
    if (this.wlT != null) {
      this.wlT.a(paramf, paramInt);
    }
  }
  
  protected final void drI()
  {
    if (this.wis != null)
    {
      this.wis.end();
      this.wis.fln();
      this.wis = null;
    }
  }
  
  protected abstract void dsD();
  
  protected final void dts()
  {
    if (this.wis != null) {
      return;
    }
    if (b.checkSelfPermission(aj.getContext(), "android.permission.READ_PHONE_STATE") != 0)
    {
      ad.e("MicroMsg.Music.BaseMusicPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
      return;
    }
    this.wis = new bc();
    this.wis.jb(aj.getContext());
    this.wis.a(new bc.a()
    {
      public final void kK(int paramAnonymousInt)
      {
        AppMethodBeat.i(137297);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(137297);
          return;
          if (a.this.wit)
          {
            a.this.wit = false;
            a.this.resume();
            AppMethodBeat.o(137297);
            return;
            if (a.this.aJG())
            {
              a.this.wit = true;
              a.this.pause();
            }
          }
        }
      }
    });
  }
  
  protected final String dtt()
  {
    return this.wlR;
  }
  
  protected final void eZ(int paramInt1, int paramInt2)
  {
    if (this.wiu != null) {
      this.wiu.eZ(paramInt1, paramInt2);
    }
    Iterator localIterator = this.wlV.iterator();
    while (localIterator.hasNext()) {
      ((d.a)localIterator.next()).eZ(paramInt1, paramInt2);
    }
  }
  
  public void h(f paramf)
  {
    dsD();
  }
  
  public void m(f paramf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a
 * JD-Core Version:    0.7.0.1
 */