package com.tencent.mm.plugin.music.logic;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.aw.f;
import com.tencent.mm.plugin.music.d.a;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract class g
  implements c
{
  private com.tencent.mm.plugin.music.e.d LLr = new com.tencent.mm.plugin.music.e.d();
  private e LLs = new e();
  private a LLt = new a();
  private Runnable LLu = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(137281);
      boolean bool1 = g.this.gnj().bLm();
      boolean bool2 = g.this.gnj().bLk();
      Log.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (!bool2)) {
        g.this.gnj().stopPlay();
      }
      AppMethodBeat.o(137281);
    }
  };
  
  public static void gnv()
  {
    Log.i("MicroMsg.Music.MusicBasePlayEngine", "sendPreemptedEvent");
    ox localox = new ox();
    localox.hRN.action = 10;
    localox.hRN.state = "preempted";
    localox.hRN.appId = "not from app brand appid";
    localox.hRN.hRO = true;
    localox.asyncPublish(Looper.getMainLooper());
  }
  
  public void adx(int paramInt)
  {
    Log.i("MicroMsg.Music.MusicBasePlayEngine", "stopMusicDelayIfPaused, delay_ms:%d", new Object[] { Integer.valueOf(paramInt) });
    MMHandlerThread.removeRunnable(this.LLu);
    MMHandlerThread.postToMainThreadDelayed(this.LLu, paramInt);
  }
  
  public void bLi()
  {
    this.LLr.stopPlay();
    if (this.LLs != null) {
      this.LLs.stopPlay();
    }
    if (this.LLt != null) {
      this.LLt.stopPlay();
    }
    MMHandlerThread.removeRunnable(this.LLu);
  }
  
  public void finish()
  {
    bLi();
    release();
  }
  
  public f gng()
  {
    return null;
  }
  
  public com.tencent.mm.plugin.music.e.a.d gnj()
  {
    f localf = gng();
    if (com.tencent.mm.plugin.music.h.c.aa(localf)) {
      return this.LLt;
    }
    if ((localf != null) && (com.tencent.mm.plugin.music.h.c.adO(localf.oOt))) {
      return this.LLs;
    }
    return this.LLr;
  }
  
  public final void gnu()
  {
    if (this.LLr.bLk()) {
      this.LLr.stopPlay();
    }
    if (this.LLs.bLk()) {
      this.LLs.stopPlay();
    }
    if (this.LLt.bLk()) {
      this.LLt.stopPlay();
    }
  }
  
  public void m(f paramf)
  {
    if (this.LLr.bLk()) {
      this.LLr.m(paramf);
    }
    if (this.LLs.bLk()) {
      this.LLs.m(paramf);
    }
    if (this.LLt.bLk()) {
      this.LLt.m(paramf);
    }
  }
  
  public void release()
  {
    Log.i("MicroMsg.Music.MusicBasePlayEngine", "release");
    if (this.LLs != null) {
      this.LLs.release();
    }
    if (this.LLt != null) {
      this.LLt.release();
    }
    MMHandlerThread.removeRunnable(this.LLu);
  }
  
  public final void x(f paramf)
  {
    if (com.tencent.mm.plugin.music.h.c.aa(paramf))
    {
      Log.i("MicroMsg.Music.MusicBasePlayEngine", "use exoMusicPlayer");
      gnu();
      this.LLt.h(paramf);
    }
    for (;;)
    {
      if (paramf.oOt != 11) {
        gnv();
      }
      return;
      if (com.tencent.mm.plugin.music.h.c.adO(paramf.oOt))
      {
        Log.i("MicroMsg.Music.MusicBasePlayEngine", "use qqMusicPlayer");
        gnu();
        if ((!paramf.oOX) && (adu(paramf.oOt)))
        {
          paramf.oOX = true;
          Log.i("MicroMsg.Music.MusicBasePlayEngine", "support useNetworkDataPlay, MusicType:%d", new Object[] { Integer.valueOf(paramf.oOt) });
        }
        this.LLs.h(paramf);
      }
      else
      {
        Log.i("MicroMsg.Music.MusicBasePlayEngine", "use musicPlayer");
        gnu();
        this.LLr.h(paramf);
      }
    }
  }
  
  public final void y(f paramf)
  {
    if (com.tencent.mm.plugin.music.h.c.aa(paramf))
    {
      this.LLt.U(paramf);
      return;
    }
    if ((paramf != null) && (com.tencent.mm.plugin.music.h.c.adO(paramf.oOt)))
    {
      this.LLs.U(paramf);
      return;
    }
    this.LLr.U(paramf);
  }
  
  public void zI(boolean paramBoolean)
  {
    if (this.LLr.bLk()) {
      this.LLr.hRP = paramBoolean;
    }
    if (this.LLs.bLk()) {
      this.LLs.hRP = paramBoolean;
    }
    if (this.LLt.bLk()) {
      this.LLt.hRP = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.logic.g
 * JD-Core Version:    0.7.0.1
 */