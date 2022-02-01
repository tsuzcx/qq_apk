package com.tencent.mm.plugin.music.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.f.a.np;
import com.tencent.mm.plugin.music.d.a;
import com.tencent.mm.plugin.music.f.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract class h
  implements c
{
  private com.tencent.mm.plugin.music.f.d FQv = new com.tencent.mm.plugin.music.f.d();
  private e FQw = new e();
  private a FQx = new a();
  private Runnable FQy = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(137281);
      boolean bool1 = h.this.feg().bnz();
      boolean bool2 = h.this.feg().bnx();
      Log.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (!bool2)) {
        h.this.feg().stopPlay();
      }
      AppMethodBeat.o(137281);
    }
  };
  
  public static void fes()
  {
    Log.i("MicroMsg.Music.MusicBasePlayEngine", "sendPreemptedEvent");
    np localnp = new np();
    localnp.fMc.action = 10;
    localnp.fMc.state = "preempted";
    localnp.fMc.appId = "not from app brand appid";
    localnp.fMc.fMe = true;
    EventCenter.instance.asyncPublish(localnp, Looper.getMainLooper());
  }
  
  public void Zl(int paramInt)
  {
    Log.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(paramInt) });
    MMHandlerThread.removeRunnable(this.FQy);
    MMHandlerThread.postToMainThreadDelayed(this.FQy, paramInt);
  }
  
  public void bnv()
  {
    this.FQv.stopPlay();
    if (this.FQw != null) {
      this.FQw.stopPlay();
    }
    if (this.FQx != null) {
      this.FQx.stopPlay();
    }
    MMHandlerThread.removeRunnable(this.FQy);
  }
  
  public f fed()
  {
    return null;
  }
  
  public com.tencent.mm.plugin.music.f.a.d feg()
  {
    f localf = fed();
    if (com.tencent.mm.plugin.music.h.c.U(localf)) {
      return this.FQx;
    }
    if ((localf != null) && (com.tencent.mm.plugin.music.h.c.ZB(localf.lVr))) {
      return this.FQw;
    }
    return this.FQv;
  }
  
  public final void fer()
  {
    if (this.FQv.bnx()) {
      this.FQv.stopPlay();
    }
    if (this.FQw.bnx()) {
      this.FQw.stopPlay();
    }
    if (this.FQx.bnx()) {
      this.FQx.stopPlay();
    }
  }
  
  public void finish()
  {
    bnv();
    release();
  }
  
  public void m(f paramf)
  {
    if (this.FQv.bnx()) {
      this.FQv.m(paramf);
    }
    if (this.FQw.bnx()) {
      this.FQw.m(paramf);
    }
    if (this.FQx.bnx()) {
      this.FQx.m(paramf);
    }
  }
  
  public void release()
  {
    Log.i("MicroMsg.Music.MusicBasePlayEngine", "release");
    if (this.FQw != null) {
      this.FQw.release();
    }
    if (this.FQx != null) {
      this.FQx.release();
    }
    MMHandlerThread.removeRunnable(this.FQy);
  }
  
  public final void t(f paramf)
  {
    if (com.tencent.mm.plugin.music.h.c.U(paramf))
    {
      Log.i("MicroMsg.Music.MusicBasePlayEngine", "use exoMusicPlayer");
      fer();
      this.FQx.h(paramf);
    }
    for (;;)
    {
      if (paramf.lVr != 11) {
        fes();
      }
      return;
      if (com.tencent.mm.plugin.music.h.c.ZB(paramf.lVr))
      {
        Log.i("MicroMsg.Music.MusicBasePlayEngine", "use qqMusicPlayer");
        fer();
        this.FQw.h(paramf);
      }
      else
      {
        Log.i("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
        fer();
        this.FQv.h(paramf);
      }
    }
  }
  
  public final void u(f paramf)
  {
    if (com.tencent.mm.plugin.music.h.c.U(paramf))
    {
      this.FQx.P(paramf);
      return;
    }
    if ((paramf != null) && (com.tencent.mm.plugin.music.h.c.ZB(paramf.lVr)))
    {
      this.FQw.P(paramf);
      return;
    }
    this.FQv.P(paramf);
  }
  
  public void vq(boolean paramBoolean)
  {
    if (this.FQv.bnx()) {
      this.FQv.fMf = paramBoolean;
    }
    if (this.FQw.bnx()) {
      this.FQw.fMf = paramBoolean;
    }
    if (this.FQx.bnx()) {
      this.FQx.fMf = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.h
 * JD-Core Version:    0.7.0.1
 */