package com.tencent.mm.plugin.music.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.plugin.music.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;

public abstract class h
  implements c
{
  private com.tencent.mm.plugin.music.f.d veP = new com.tencent.mm.plugin.music.f.d();
  private e veQ = new e();
  private com.tencent.mm.plugin.music.d.a veR = new com.tencent.mm.plugin.music.d.a();
  private Runnable veS = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(137281);
      boolean bool1 = h.this.diB().aGx();
      boolean bool2 = h.this.diB().aGv();
      ac.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (!bool2)) {
        h.this.diB().stopPlay();
      }
      AppMethodBeat.o(137281);
    }
  };
  
  private void diM()
  {
    if (this.veP.aGv()) {
      this.veP.stopPlay();
    }
    if (this.veQ.aGv()) {
      this.veQ.stopPlay();
    }
    if (this.veR.aGv()) {
      this.veR.stopPlay();
    }
  }
  
  public static void diN()
  {
    ac.i("MicroMsg.Music.MusicBasePlayEngine", "sendPreemptedEvent");
    lw locallw = new lw();
    locallw.dnW.action = 10;
    locallw.dnW.state = "preempted";
    locallw.dnW.appId = "not from app brand appid";
    locallw.dnW.dnY = true;
    com.tencent.mm.sdk.b.a.GpY.a(locallw, Looper.getMainLooper());
  }
  
  public void JL(int paramInt)
  {
    ac.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(paramInt) });
    ap.aB(this.veS);
    ap.n(this.veS, paramInt);
  }
  
  public void aGt()
  {
    this.veP.stopPlay();
    if (this.veQ != null) {
      this.veQ.stopPlay();
    }
    if (this.veR != null) {
      this.veR.stopPlay();
    }
    ap.aB(this.veS);
  }
  
  public com.tencent.mm.plugin.music.f.a.d diB()
  {
    f localf = diz();
    if (com.tencent.mm.plugin.music.h.c.Q(localf)) {
      return this.veR;
    }
    if ((localf != null) && (com.tencent.mm.plugin.music.h.c.Kb(localf.hNQ))) {
      return this.veQ;
    }
    return this.veP;
  }
  
  public f diz()
  {
    return null;
  }
  
  public void finish()
  {
    aGt();
    release();
  }
  
  public void m(f paramf)
  {
    if (this.veP.aGv()) {
      this.veP.m(paramf);
    }
    if (this.veQ.aGv()) {
      this.veQ.m(paramf);
    }
    if (this.veR.aGv()) {
      this.veR.m(paramf);
    }
  }
  
  public void oD(boolean paramBoolean)
  {
    if (this.veP.aGv()) {
      this.veP.dnZ = paramBoolean;
    }
    if (this.veQ.aGv()) {
      this.veQ.dnZ = paramBoolean;
    }
    if (this.veR.aGv()) {
      this.veR.dnZ = paramBoolean;
    }
  }
  
  public void release()
  {
    ac.i("MicroMsg.Music.MusicBasePlayEngine", "release");
    if (this.veQ != null) {
      this.veQ.release();
    }
    if (this.veR != null) {
      this.veR.release();
    }
    ap.aB(this.veS);
  }
  
  public final void t(f paramf)
  {
    if (com.tencent.mm.plugin.music.h.c.Q(paramf))
    {
      ac.i("MicroMsg.Music.MusicBasePlayEngine", "use exoMusicPlayer");
      diM();
      this.veR.h(paramf);
    }
    for (;;)
    {
      if (paramf.hNQ != 11) {
        diN();
      }
      return;
      if (com.tencent.mm.plugin.music.h.c.Kb(paramf.hNQ))
      {
        ac.i("MicroMsg.Music.MusicBasePlayEngine", "use qqMusicPlayer");
        diM();
        this.veQ.h(paramf);
      }
      else
      {
        ac.i("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
        diM();
        this.veP.h(paramf);
      }
    }
  }
  
  public final void u(f paramf)
  {
    if (com.tencent.mm.plugin.music.h.c.Q(paramf))
    {
      this.veR.L(paramf);
      return;
    }
    if ((paramf != null) && (com.tencent.mm.plugin.music.h.c.Kb(paramf.hNQ)))
    {
      this.veQ.L(paramf);
      return;
    }
    this.veP.L(paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.h
 * JD-Core Version:    0.7.0.1
 */