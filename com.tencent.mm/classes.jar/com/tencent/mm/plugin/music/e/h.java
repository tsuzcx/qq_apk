package com.tencent.mm.plugin.music.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.plugin.music.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public abstract class h
  implements c
{
  private com.tencent.mm.plugin.music.f.d wkk = new com.tencent.mm.plugin.music.f.d();
  private e wkl = new e();
  private com.tencent.mm.plugin.music.d.a wkm = new com.tencent.mm.plugin.music.d.a();
  private Runnable wkn = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(137281);
      boolean bool1 = h.this.dsN().aJI();
      boolean bool2 = h.this.dsN().aJG();
      ad.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (!bool2)) {
        h.this.dsN().stopPlay();
      }
      AppMethodBeat.o(137281);
    }
  };
  
  private void dsY()
  {
    if (this.wkk.aJG()) {
      this.wkk.stopPlay();
    }
    if (this.wkl.aJG()) {
      this.wkl.stopPlay();
    }
    if (this.wkm.aJG()) {
      this.wkm.stopPlay();
    }
  }
  
  public static void dsZ()
  {
    ad.i("MicroMsg.Music.MusicBasePlayEngine", "sendPreemptedEvent");
    mf localmf = new mf();
    localmf.dzK.action = 10;
    localmf.dzK.state = "preempted";
    localmf.dzK.appId = "not from app brand appid";
    localmf.dzK.dzM = true;
    com.tencent.mm.sdk.b.a.IbL.a(localmf, Looper.getMainLooper());
  }
  
  public void Ln(int paramInt)
  {
    ad.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(paramInt) });
    aq.aA(this.wkn);
    aq.o(this.wkn, paramInt);
  }
  
  public void aJE()
  {
    this.wkk.stopPlay();
    if (this.wkl != null) {
      this.wkl.stopPlay();
    }
    if (this.wkm != null) {
      this.wkm.stopPlay();
    }
    aq.aA(this.wkn);
  }
  
  public f dsL()
  {
    return null;
  }
  
  public com.tencent.mm.plugin.music.f.a.d dsN()
  {
    f localf = dsL();
    if (com.tencent.mm.plugin.music.h.c.Q(localf)) {
      return this.wkm;
    }
    if ((localf != null) && (com.tencent.mm.plugin.music.h.c.LD(localf.ihe))) {
      return this.wkl;
    }
    return this.wkk;
  }
  
  public void finish()
  {
    aJE();
    release();
  }
  
  public void m(f paramf)
  {
    if (this.wkk.aJG()) {
      this.wkk.m(paramf);
    }
    if (this.wkl.aJG()) {
      this.wkl.m(paramf);
    }
    if (this.wkm.aJG()) {
      this.wkm.m(paramf);
    }
  }
  
  public void pc(boolean paramBoolean)
  {
    if (this.wkk.aJG()) {
      this.wkk.dzN = paramBoolean;
    }
    if (this.wkl.aJG()) {
      this.wkl.dzN = paramBoolean;
    }
    if (this.wkm.aJG()) {
      this.wkm.dzN = paramBoolean;
    }
  }
  
  public void release()
  {
    ad.i("MicroMsg.Music.MusicBasePlayEngine", "release");
    if (this.wkl != null) {
      this.wkl.release();
    }
    if (this.wkm != null) {
      this.wkm.release();
    }
    aq.aA(this.wkn);
  }
  
  public final void t(f paramf)
  {
    if (com.tencent.mm.plugin.music.h.c.Q(paramf))
    {
      ad.i("MicroMsg.Music.MusicBasePlayEngine", "use exoMusicPlayer");
      dsY();
      this.wkm.h(paramf);
    }
    for (;;)
    {
      if (paramf.ihe != 11) {
        dsZ();
      }
      return;
      if (com.tencent.mm.plugin.music.h.c.LD(paramf.ihe))
      {
        ad.i("MicroMsg.Music.MusicBasePlayEngine", "use qqMusicPlayer");
        dsY();
        this.wkl.h(paramf);
      }
      else
      {
        ad.i("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
        dsY();
        this.wkk.h(paramf);
      }
    }
  }
  
  public final void u(f paramf)
  {
    if (com.tencent.mm.plugin.music.h.c.Q(paramf))
    {
      this.wkm.L(paramf);
      return;
    }
    if ((paramf != null) && (com.tencent.mm.plugin.music.h.c.LD(paramf.ihe)))
    {
      this.wkl.L(paramf);
      return;
    }
    this.wkk.L(paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.h
 * JD-Core Version:    0.7.0.1
 */