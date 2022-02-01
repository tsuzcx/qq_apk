package com.tencent.mm.plugin.music.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.plugin.music.d.a;
import com.tencent.mm.plugin.music.f.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract class h
  implements c
{
  private Runnable AjA = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(137281);
      boolean bool1 = h.this.etW().bee();
      boolean bool2 = h.this.etW().bec();
      Log.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (!bool2)) {
        h.this.etW().stopPlay();
      }
      AppMethodBeat.o(137281);
    }
  };
  private com.tencent.mm.plugin.music.f.d Ajx = new com.tencent.mm.plugin.music.f.d();
  private e Ajy = new e();
  private a Ajz = new a();
  
  private void euh()
  {
    if (this.Ajx.bec()) {
      this.Ajx.stopPlay();
    }
    if (this.Ajy.bec()) {
      this.Ajy.stopPlay();
    }
    if (this.Ajz.bec()) {
      this.Ajz.stopPlay();
    }
  }
  
  public static void eui()
  {
    Log.i("MicroMsg.Music.MusicBasePlayEngine", "sendPreemptedEvent");
    mx localmx = new mx();
    localmx.dSE.action = 10;
    localmx.dSE.state = "preempted";
    localmx.dSE.appId = "not from app brand appid";
    localmx.dSE.dSG = true;
    EventCenter.instance.asyncPublish(localmx, Looper.getMainLooper());
  }
  
  public void SP(int paramInt)
  {
    Log.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(paramInt) });
    MMHandlerThread.removeRunnable(this.AjA);
    MMHandlerThread.postToMainThreadDelayed(this.AjA, paramInt);
  }
  
  public void bea()
  {
    this.Ajx.stopPlay();
    if (this.Ajy != null) {
      this.Ajy.stopPlay();
    }
    if (this.Ajz != null) {
      this.Ajz.stopPlay();
    }
    MMHandlerThread.removeRunnable(this.AjA);
  }
  
  public f etU()
  {
    return null;
  }
  
  public com.tencent.mm.plugin.music.f.a.d etW()
  {
    f localf = etU();
    if (com.tencent.mm.plugin.music.h.c.U(localf)) {
      return this.Ajz;
    }
    if ((localf != null) && (com.tencent.mm.plugin.music.h.c.Th(localf.jeT))) {
      return this.Ajy;
    }
    return this.Ajx;
  }
  
  public void finish()
  {
    bea();
    release();
  }
  
  public void m(f paramf)
  {
    if (this.Ajx.bec()) {
      this.Ajx.m(paramf);
    }
    if (this.Ajy.bec()) {
      this.Ajy.m(paramf);
    }
    if (this.Ajz.bec()) {
      this.Ajz.m(paramf);
    }
  }
  
  public void release()
  {
    Log.i("MicroMsg.Music.MusicBasePlayEngine", "release");
    if (this.Ajy != null) {
      this.Ajy.release();
    }
    if (this.Ajz != null) {
      this.Ajz.release();
    }
    MMHandlerThread.removeRunnable(this.AjA);
  }
  
  public void sl(boolean paramBoolean)
  {
    if (this.Ajx.bec()) {
      this.Ajx.dSH = paramBoolean;
    }
    if (this.Ajy.bec()) {
      this.Ajy.dSH = paramBoolean;
    }
    if (this.Ajz.bec()) {
      this.Ajz.dSH = paramBoolean;
    }
  }
  
  public final void t(f paramf)
  {
    if (com.tencent.mm.plugin.music.h.c.U(paramf))
    {
      Log.i("MicroMsg.Music.MusicBasePlayEngine", "use exoMusicPlayer");
      euh();
      this.Ajz.h(paramf);
    }
    for (;;)
    {
      if (paramf.jeT != 11) {
        eui();
      }
      return;
      if (com.tencent.mm.plugin.music.h.c.Th(paramf.jeT))
      {
        Log.i("MicroMsg.Music.MusicBasePlayEngine", "use qqMusicPlayer");
        euh();
        this.Ajy.h(paramf);
      }
      else
      {
        Log.i("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
        euh();
        this.Ajx.h(paramf);
      }
    }
  }
  
  public final void u(f paramf)
  {
    if (com.tencent.mm.plugin.music.h.c.U(paramf))
    {
      this.Ajz.P(paramf);
      return;
    }
    if ((paramf != null) && (com.tencent.mm.plugin.music.h.c.Th(paramf.jeT)))
    {
      this.Ajy.P(paramf);
      return;
    }
    this.Ajx.P(paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.h
 * JD-Core Version:    0.7.0.1
 */