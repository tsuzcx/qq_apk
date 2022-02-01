package com.tencent.mm.plugin.music.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.plugin.music.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

public abstract class h
  implements c
{
  private com.tencent.mm.plugin.music.f.d wzP = new com.tencent.mm.plugin.music.f.d();
  private e wzQ = new e();
  private com.tencent.mm.plugin.music.d.a wzR = new com.tencent.mm.plugin.music.d.a();
  private Runnable wzS = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(137281);
      boolean bool1 = h.this.dwc().aKb();
      boolean bool2 = h.this.dwc().aJZ();
      ae.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (!bool2)) {
        h.this.dwc().stopPlay();
      }
      AppMethodBeat.o(137281);
    }
  };
  
  private void dwn()
  {
    if (this.wzP.aJZ()) {
      this.wzP.stopPlay();
    }
    if (this.wzQ.aJZ()) {
      this.wzQ.stopPlay();
    }
    if (this.wzR.aJZ()) {
      this.wzR.stopPlay();
    }
  }
  
  public static void dwo()
  {
    ae.i("MicroMsg.Music.MusicBasePlayEngine", "sendPreemptedEvent");
    mg localmg = new mg();
    localmg.dAP.action = 10;
    localmg.dAP.state = "preempted";
    localmg.dAP.appId = "not from app brand appid";
    localmg.dAP.dAR = true;
    com.tencent.mm.sdk.b.a.IvT.a(localmg, Looper.getMainLooper());
  }
  
  public void LS(int paramInt)
  {
    ae.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(paramInt) });
    ar.ay(this.wzS);
    ar.o(this.wzS, paramInt);
  }
  
  public void aJX()
  {
    this.wzP.stopPlay();
    if (this.wzQ != null) {
      this.wzQ.stopPlay();
    }
    if (this.wzR != null) {
      this.wzR.stopPlay();
    }
    ar.ay(this.wzS);
  }
  
  public f dwa()
  {
    return null;
  }
  
  public com.tencent.mm.plugin.music.f.a.d dwc()
  {
    f localf = dwa();
    if (com.tencent.mm.plugin.music.h.c.Q(localf)) {
      return this.wzR;
    }
    if ((localf != null) && (com.tencent.mm.plugin.music.h.c.Mi(localf.ijX))) {
      return this.wzQ;
    }
    return this.wzP;
  }
  
  public void finish()
  {
    aJX();
    release();
  }
  
  public void m(f paramf)
  {
    if (this.wzP.aJZ()) {
      this.wzP.m(paramf);
    }
    if (this.wzQ.aJZ()) {
      this.wzQ.m(paramf);
    }
    if (this.wzR.aJZ()) {
      this.wzR.m(paramf);
    }
  }
  
  public void pk(boolean paramBoolean)
  {
    if (this.wzP.aJZ()) {
      this.wzP.dAS = paramBoolean;
    }
    if (this.wzQ.aJZ()) {
      this.wzQ.dAS = paramBoolean;
    }
    if (this.wzR.aJZ()) {
      this.wzR.dAS = paramBoolean;
    }
  }
  
  public void release()
  {
    ae.i("MicroMsg.Music.MusicBasePlayEngine", "release");
    if (this.wzQ != null) {
      this.wzQ.release();
    }
    if (this.wzR != null) {
      this.wzR.release();
    }
    ar.ay(this.wzS);
  }
  
  public final void t(f paramf)
  {
    if (com.tencent.mm.plugin.music.h.c.Q(paramf))
    {
      ae.i("MicroMsg.Music.MusicBasePlayEngine", "use exoMusicPlayer");
      dwn();
      this.wzR.h(paramf);
    }
    for (;;)
    {
      if (paramf.ijX != 11) {
        dwo();
      }
      return;
      if (com.tencent.mm.plugin.music.h.c.Mi(paramf.ijX))
      {
        ae.i("MicroMsg.Music.MusicBasePlayEngine", "use qqMusicPlayer");
        dwn();
        this.wzQ.h(paramf);
      }
      else
      {
        ae.i("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
        dwn();
        this.wzP.h(paramf);
      }
    }
  }
  
  public final void u(f paramf)
  {
    if (com.tencent.mm.plugin.music.h.c.Q(paramf))
    {
      this.wzR.L(paramf);
      return;
    }
    if ((paramf != null) && (com.tencent.mm.plugin.music.h.c.Mi(paramf.ijX)))
    {
      this.wzQ.L(paramf);
      return;
    }
    this.wzP.L(paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.h
 * JD-Core Version:    0.7.0.1
 */