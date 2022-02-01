package com.tencent.mm.plugin.music.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.plugin.music.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public abstract class h
  implements c
{
  private com.tencent.mm.plugin.music.f.d tWf = new com.tencent.mm.plugin.music.f.d();
  private e tWg = new e();
  private com.tencent.mm.plugin.music.d.a tWh = new com.tencent.mm.plugin.music.d.a();
  private Runnable tWi = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(137281);
      boolean bool1 = h.this.cUV().azH();
      boolean bool2 = h.this.cUV().azF();
      ad.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (!bool2)) {
        h.this.cUV().stopPlay();
      }
      AppMethodBeat.o(137281);
    }
  };
  
  private void cVg()
  {
    if (this.tWf.azF()) {
      this.tWf.stopPlay();
    }
    if (this.tWg.azF()) {
      this.tWg.stopPlay();
    }
    if (this.tWh.azF()) {
      this.tWh.stopPlay();
    }
  }
  
  public static void cVh()
  {
    ad.i("MicroMsg.Music.MusicBasePlayEngine", "sendPreemptedEvent");
    ln localln = new ln();
    localln.dql.action = 10;
    localln.dql.state = "preempted";
    localln.dql.appId = "not from app brand appid";
    localln.dql.dqn = true;
    com.tencent.mm.sdk.b.a.ESL.a(localln, Looper.getMainLooper());
  }
  
  public void HM(int paramInt)
  {
    ad.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(paramInt) });
    aq.az(this.tWi);
    aq.n(this.tWi, paramInt);
  }
  
  public void azD()
  {
    this.tWf.stopPlay();
    if (this.tWg != null) {
      this.tWg.stopPlay();
    }
    if (this.tWh != null) {
      this.tWh.stopPlay();
    }
    aq.az(this.tWi);
  }
  
  public f cUT()
  {
    return null;
  }
  
  public com.tencent.mm.plugin.music.f.a.d cUV()
  {
    f localf = cUT();
    if (com.tencent.mm.plugin.music.h.c.P(localf)) {
      return this.tWh;
    }
    if ((localf != null) && (com.tencent.mm.plugin.music.h.c.Ic(localf.hnn))) {
      return this.tWg;
    }
    return this.tWf;
  }
  
  public void finish()
  {
    azD();
    release();
  }
  
  public void m(f paramf)
  {
    if (this.tWf.azF()) {
      this.tWf.m(paramf);
    }
    if (this.tWg.azF()) {
      this.tWg.m(paramf);
    }
    if (this.tWh.azF()) {
      this.tWh.m(paramf);
    }
  }
  
  public void nJ(boolean paramBoolean)
  {
    if (this.tWf.azF()) {
      this.tWf.dqo = paramBoolean;
    }
    if (this.tWg.azF()) {
      this.tWg.dqo = paramBoolean;
    }
    if (this.tWh.azF()) {
      this.tWh.dqo = paramBoolean;
    }
  }
  
  public void release()
  {
    ad.i("MicroMsg.Music.MusicBasePlayEngine", "release");
    if (this.tWg != null) {
      this.tWg.release();
    }
    if (this.tWh != null) {
      this.tWh.release();
    }
    aq.az(this.tWi);
  }
  
  public final void t(f paramf)
  {
    if (com.tencent.mm.plugin.music.h.c.P(paramf))
    {
      ad.i("MicroMsg.Music.MusicBasePlayEngine", "use exoMusicPlayer");
      cVg();
      this.tWh.h(paramf);
    }
    for (;;)
    {
      if (paramf.hnn != 11) {
        cVh();
      }
      return;
      if (com.tencent.mm.plugin.music.h.c.Ic(paramf.hnn))
      {
        ad.i("MicroMsg.Music.MusicBasePlayEngine", "use qqMusicPlayer");
        cVg();
        this.tWg.h(paramf);
      }
      else
      {
        ad.i("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
        cVg();
        this.tWf.h(paramf);
      }
    }
  }
  
  public final void u(f paramf)
  {
    if (com.tencent.mm.plugin.music.h.c.P(paramf))
    {
      this.tWh.K(paramf);
      return;
    }
    if ((paramf != null) && (com.tencent.mm.plugin.music.h.c.Ic(paramf.hnn)))
    {
      this.tWg.K(paramf);
      return;
    }
    this.tWf.K(paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.h
 * JD-Core Version:    0.7.0.1
 */