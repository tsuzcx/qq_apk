package com.tencent.mm.plugin.music.f;

import com.tencent.mm.plugin.music.c.b.b;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends a
{
  com.tencent.mm.plugin.music.f.a.b mAC;
  boolean mAD;
  private com.tencent.mm.av.c mAE;
  b.b mAF = new d.2(this);
  com.tencent.mm.plugin.music.c.b mAi;
  boolean mxr;
  com.tencent.mm.av.e myB;
  public boolean myO = false;
  
  private int getDownloadPercent()
  {
    if (this.mAi != null)
    {
      com.tencent.mm.plugin.music.c.b localb = this.mAi;
      int i;
      if (localb.kaC)
      {
        y.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.myv.mys), Long.valueOf(localb.myv.myq) });
        if (localb.myv.mys != 0L) {
          i = (int)(localb.myv.myq * 100L / localb.myv.mys);
        }
      }
      while (i > 0)
      {
        return i;
        i = 0;
        continue;
        y.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.myv.myp), Long.valueOf(localb.myv.myo) });
        if (localb.myv.myp != 0L) {
          i = (int)(localb.myv.myo * 100L / localb.myv.myp);
        } else {
          i = 0;
        }
      }
      return 0;
    }
    return 0;
  }
  
  public final boolean Pu()
  {
    boolean bool = false;
    if (this.mAC != null) {}
    try
    {
      bool = this.mAC.isPlaying();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public final boolean Pv()
  {
    return this.mxr;
  }
  
  final void a(com.tencent.mm.av.e parame, boolean paramBoolean)
  {
    if (this.mAC == null)
    {
      if ((paramBoolean) || (!com.tencent.mm.compatible.util.d.gH(15))) {
        break label61;
      }
      y.i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
    }
    for (this.mAC = new c();; this.mAC = new b())
    {
      this.mAC.J(parame);
      this.mAC.a(new d.1(this));
      return;
      label61:
      y.i("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
    }
  }
  
  public final int bmA()
  {
    if (this.mAC != null) {
      return this.mAC.bnF();
    }
    return -1;
  }
  
  protected final void bmO()
  {
    this.mAu = ((com.tencent.mm.plugin.music.e.d)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.d.class));
    this.mAv = k.bnl().myY;
  }
  
  public final void bmi()
  {
    this.myO = true;
    y.i("MicroMsg.Music.MusicPlayer", "passivePause");
    try
    {
      if ((this.mAC != null) && (this.mAC.isPlaying()))
      {
        this.mAC.pause();
        C(this.myB);
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "passivePause", new Object[0]);
    }
  }
  
  public final boolean bmj()
  {
    return (this.mxr) && (this.myO);
  }
  
  public final boolean bmk()
  {
    return false;
  }
  
  public final com.tencent.mm.av.c bml()
  {
    int k = getDuration();
    int m = bmA();
    int i;
    int j;
    if (Pu())
    {
      i = 1;
      y.i("MicroMsg.Music.MusicPlayer", "get music status = %d", new Object[] { Integer.valueOf(i) });
      j = getDownloadPercent();
      if (k <= 0) {
        break label151;
      }
    }
    for (;;)
    {
      if (this.mAE != null) {
        this.mAE.l(k, m, i, j);
      }
      for (;;)
      {
        this.mAE.bSC = false;
        this.mAE.euu = this.mAt;
        return this.mAE;
        if ((this.mxr) && ((this.mAD) || (this.mxm))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label127;
          }
          i = 0;
          break;
        }
        label127:
        i = 2;
        break;
        this.mAE = new com.tencent.mm.av.c(k, m, i, j);
      }
      label151:
      j = 0;
    }
  }
  
  public final void bmw()
  {
    y.i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.bnn().bmh();
  }
  
  public final void f(com.tencent.mm.av.e parame)
  {
    super.f(parame);
    y.i("MicroMsg.Music.MusicPlayer", "init and start download");
    stopPlay();
    if (parame == null)
    {
      y.i("MicroMsg.Music.MusicPlayer", "music is null");
      return;
    }
    this.mAi = new com.tencent.mm.plugin.music.c.b(parame, com.tencent.mm.plugin.music.cache.e.Jk(parame.eux));
    this.mAi.myz = this.mAF;
    if (this.mAu != null)
    {
      this.mAu.s(parame);
      y.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
      this.mAu.bmZ();
      this.mAu.a(this.mAi);
    }
    this.myB = parame;
    a(parame, false);
    y.i("MicroMsg.Music.MusicPlayer", "startPlay src:%s,  playUrl:%s", new Object[] { parame.euD, parame.playUrl });
    this.mAi.start();
    bnC();
  }
  
  public final int getDuration()
  {
    if (this.mAC != null) {
      return this.mAC.getDuration();
    }
    return -1;
  }
  
  public final boolean iV(int paramInt)
  {
    y.i("MicroMsg.Music.MusicPlayer", "seekToMusic pos:%d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = getDuration();
      int j = getDownloadPercent();
      if ((i < 0) || (paramInt > i))
      {
        y.e("MicroMsg.Music.MusicPlayer", "duration or position is illegal, stop");
        stopPlay();
        return false;
      }
      int k = (int)(j / 100.0D * i);
      i = paramInt;
      if (j != 100)
      {
        i = paramInt;
        if (paramInt > k)
        {
          i = k - 2000;
          y.i("MicroMsg.Music.MusicPlayer", "on completed seekto, position is %d =", new Object[] { Integer.valueOf(i) });
        }
      }
      if ((this.mAC != null) && (i >= 0))
      {
        this.mAC.seek(i);
        E(this.myB);
        return true;
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "seekTo", new Object[0]);
    }
    return false;
  }
  
  public final void pause()
  {
    this.myO = false;
    y.i("MicroMsg.Music.MusicPlayer", "pause");
    try
    {
      if ((this.mAC != null) && (this.mAC.isPlaying()))
      {
        this.mAC.pause();
        this.mAD = true;
        C(this.myB);
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "pause", new Object[0]);
    }
  }
  
  public final void resume()
  {
    try
    {
      if ((this.mAC != null) && (!this.mAC.isPlaying()))
      {
        y.i("MicroMsg.Music.MusicPlayer", "resume");
        if (k.bnn().requestFocus())
        {
          this.mAC.play();
          B(this.myB);
          return;
        }
        y.e("MicroMsg.Music.MusicPlayer", "request focus error");
        return;
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "resume", new Object[0]);
      return;
    }
    y.i("MicroMsg.Music.MusicPlayer", "music is playing");
  }
  
  public final void stopPlay()
  {
    y.i("MicroMsg.Music.MusicPlayer", "stopPlay");
    if ((this.mAC != null) && ((this.mAC instanceof c)))
    {
      String str = this.mAC.bnG();
      if (this.mAu != null) {
        this.mAu.a(this.myB, str);
      }
    }
    try
    {
      if (this.mAi != null)
      {
        this.mAi.isStop = true;
        this.mAi = null;
      }
      if (this.mAC != null)
      {
        this.mAC.stop();
        this.mAC = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "stopPlay", new Object[0]);
      }
    }
    k.bnn().bmh();
    this.mxr = false;
    this.myO = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d
 * JD-Core Version:    0.7.0.1
 */