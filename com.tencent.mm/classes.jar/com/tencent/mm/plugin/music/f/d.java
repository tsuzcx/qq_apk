package com.tencent.mm.plugin.music.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.c.b.b;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class d
  extends a
{
  boolean FOH;
  com.tencent.mm.bb.f FQe;
  public boolean FQs;
  com.tencent.mm.plugin.music.c.b FSD;
  com.tencent.mm.plugin.music.f.a.b FSY;
  boolean FSZ;
  private com.tencent.mm.bb.c FTa;
  b.b FTb;
  
  public d()
  {
    AppMethodBeat.i(137335);
    this.FTb = new b.b()
    {
      public final void Zh(int paramAnonymousInt)
      {
        AppMethodBeat.i(137334);
        if (paramAnonymousInt == 1)
        {
          if ((d.this.FSD != null) && (!d.this.FOH) && (d.this.FSY != null))
          {
            Object localObject = com.tencent.mm.plugin.music.h.b.cc(d.this.FSD.FPX.lVt, d.this.FSD.wIk);
            d.this.FSY.aSo((String)localObject);
            localObject = d.this;
            if (k.fev().avy())
            {
              Log.i("MicroMsg.Music.MusicPlayer", "startPlay");
              try
              {
                if (((d)localObject).FSY != null) {
                  ((d)localObject).FSY.play();
                }
                ((d)localObject).FOH = true;
                ((d)localObject).FSZ = false;
                AppMethodBeat.o(137334);
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "startPlay", new Object[0]);
                }
              }
            }
            Log.e("MicroMsg.Music.MusicPlayer", "request focus error");
            AppMethodBeat.o(137334);
          }
        }
        else
        {
          if ((paramAnonymousInt == -2) || (paramAnonymousInt == 5) || (paramAnonymousInt == 19))
          {
            MMHandlerThread.postToMainThread(new d.2.1(this, paramAnonymousInt));
            AppMethodBeat.o(137334);
            return;
          }
          if ((paramAnonymousInt == -1) || (paramAnonymousInt == 6) || (paramAnonymousInt == 4))
          {
            MMHandlerThread.postToMainThread(new d.2.2(this));
            d.a(d.this, d.this.FQe, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(137334);
      }
    };
    this.FQs = false;
    AppMethodBeat.o(137335);
  }
  
  private void aSp(String paramString)
  {
    AppMethodBeat.i(137350);
    if (this.FSQ != null) {
      this.FSQ.a(this.FQe, paramString);
    }
    AppMethodBeat.o(137350);
  }
  
  private int getDownloadPercent()
  {
    AppMethodBeat.i(137347);
    if (this.FSD != null)
    {
      com.tencent.mm.plugin.music.c.b localb = this.FSD;
      int i;
      if (localb.wIk)
      {
        Log.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.FPY.FPV), Long.valueOf(localb.FPY.FPT) });
        if (localb.FPY.FPV != 0L) {
          i = (int)(localb.FPY.FPT * 100L / localb.FPY.FPV);
        }
      }
      while (i > 0)
      {
        AppMethodBeat.o(137347);
        return i;
        i = 0;
        continue;
        Log.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.FPY.FPS), Long.valueOf(localb.FPY.FPR) });
        if (localb.FPY.FPS != 0L) {
          i = (int)(localb.FPY.FPR * 100L / localb.FPY.FPS);
        } else {
          i = 0;
        }
      }
      AppMethodBeat.o(137347);
      return 0;
    }
    AppMethodBeat.o(137347);
    return 0;
  }
  
  final void b(com.tencent.mm.bb.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(137338);
    if (this.FSY == null)
    {
      if ((paramBoolean) || (!com.tencent.mm.compatible.util.d.qX(15))) {
        break label71;
      }
      Log.i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
    }
    for (this.FSY = new c();; this.FSY = new b())
    {
      this.FSY.R(paramf);
      this.FSY.a(new com.tencent.mm.plugin.music.f.a.f()
      {
        long FTc;
        
        public final void Q(com.tencent.mm.bb.f paramAnonymousf)
        {
          AppMethodBeat.i(137329);
          com.tencent.mm.bb.f localf = k.fet().fed();
          if (localf == null)
          {
            AppMethodBeat.o(137329);
            return;
          }
          int j;
          int k;
          float f2;
          float f1;
          label235:
          int i;
          if ((localf.f(paramAnonymousf)) && (d.this.FSY != null) && (d.this.FSY.isPlaying()))
          {
            j = d.this.FSY.ffm();
            k = d.this.FSY.getDuration();
            if ((j > 0) && (k > 0))
            {
              f2 = j / k;
              if (d.this.FSD != null)
              {
                paramAnonymousf = d.this.FSD;
                paramAnonymousf.FPZ = f2;
                boolean bool = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
                if ((paramAnonymousf.isStop) && (bool))
                {
                  if (!paramAnonymousf.wIk) {
                    break label348;
                  }
                  if (paramAnonymousf.FPY.FPV != 0L)
                  {
                    f1 = (float)paramAnonymousf.FPY.FPT / (float)paramAnonymousf.FPY.FPV;
                    if ((f1 < 1.0F) && (f1 - f2 <= 0.15F) && (bool))
                    {
                      Log.v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Boolean.valueOf(bool) });
                      paramAnonymousf.start();
                    }
                  }
                }
                if ((d.this.FSD != null) && (d.this.FSD.isStop))
                {
                  paramAnonymousf = d.this.FSD;
                  if (!paramAnonymousf.wIk) {
                    break label381;
                  }
                  if (paramAnonymousf.FPY.FPV == 0L) {
                    break label429;
                  }
                  f1 = (float)paramAnonymousf.FPY.FPT / (float)paramAnonymousf.FPY.FPV;
                  label303:
                  if (f1 < 1.0F) {
                    break label414;
                  }
                  i = 1;
                }
              }
            }
          }
          for (;;)
          {
            if (i == 0)
            {
              Log.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
              d.this.stopPlay();
            }
            d.this.fK(j, k);
            AppMethodBeat.o(137329);
            return;
            label348:
            if (paramAnonymousf.FPY.FPS == 0L) {
              break label235;
            }
            f1 = (float)paramAnonymousf.FPY.FPR / (float)paramAnonymousf.FPY.FPS;
            break;
            label381:
            if (paramAnonymousf.FPY.FPS != 0L)
            {
              f1 = (float)paramAnonymousf.FPY.FPR / (float)paramAnonymousf.FPY.FPS;
              break label303;
              if (f1 - f2 > 0.05F)
              {
                i = 1;
                continue;
              }
            }
            label414:
            label429:
            i = 0;
          }
        }
        
        public final void c(com.tencent.mm.bb.f paramAnonymousf, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(137330);
          Log.i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
          com.tencent.mm.bb.f localf = k.fet().fed();
          if (localf == null)
          {
            AppMethodBeat.o(137330);
            return;
          }
          if (localf.f(paramAnonymousf)) {
            d.this.stopPlay();
          }
          d.this.L(d.this.FQe);
          if (paramAnonymousBoolean) {
            d.this.O(d.this.FQe);
          }
          AppMethodBeat.o(137330);
        }
        
        public final void d(com.tencent.mm.bb.f paramAnonymousf, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(137331);
          com.tencent.mm.bb.f localf = k.fet().fed();
          if (localf == null)
          {
            AppMethodBeat.o(137331);
            return;
          }
          Log.i("MicroMsg.Music.MusicPlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean) {
            d.a(d.this, paramAnonymousf, 20);
          }
          while (localf.f(paramAnonymousf))
          {
            Log.i("MicroMsg.Music.MusicPlayer", "stop");
            d.this.stopPlay();
            if (paramAnonymousBoolean)
            {
              Log.i("MicroMsg.Music.MusicPlayer", "retry system media player again");
              d.this.b(localf, true);
              d.this.FSD = new com.tencent.mm.plugin.music.c.b(paramAnonymousf, e.aRK(paramAnonymousf.lVt));
              d.this.FSD.FQc = d.this.FTb;
              d.this.FSD.start();
              if (d.this.FSQ == null) {
                break label245;
              }
              d.this.FSQ.a(d.this.FSD);
              AppMethodBeat.o(137331);
              return;
              d.a(d.this, paramAnonymousf, 21);
            }
            else
            {
              MMHandlerThread.postToMainThread(new d.1.1(this));
              d.this.L(d.this.FQe);
              AppMethodBeat.o(137331);
              return;
            }
          }
          Log.i("MicroMsg.Music.MusicPlayer", "send stop event");
          d.this.L(d.this.FQe);
          label245:
          AppMethodBeat.o(137331);
        }
        
        public final void n(com.tencent.mm.bb.f paramAnonymousf)
        {
          AppMethodBeat.i(137328);
          Log.i("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
          d.this.I(paramAnonymousf);
          AppMethodBeat.o(137328);
        }
      });
      AppMethodBeat.o(137338);
      return;
      label71:
      Log.i("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
    }
  }
  
  public final boolean bnx()
  {
    AppMethodBeat.i(137343);
    if (this.FSY != null) {
      try
      {
        boolean bool = this.FSY.isPlaying();
        AppMethodBeat.o(137343);
        return bool;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(137343);
        return false;
      }
    }
    AppMethodBeat.o(137343);
    return false;
  }
  
  public final boolean bny()
  {
    return (this.FOH) && (this.FQs);
  }
  
  public final boolean bnz()
  {
    return this.FOH;
  }
  
  protected final void fdW()
  {
    AppMethodBeat.i(137337);
    this.FSQ = ((com.tencent.mm.plugin.music.e.d)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.d.class));
    this.FSR = k.fet().FQA;
    AppMethodBeat.o(137337);
  }
  
  public final void fde()
  {
    AppMethodBeat.i(137341);
    this.FQs = true;
    Log.i("MicroMsg.Music.MusicPlayer", "passivePause");
    try
    {
      if ((this.FSY != null) && (this.FSY.isPlaying()))
      {
        this.FSY.pause();
        K(this.FQe);
      }
      AppMethodBeat.o(137341);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "passivePause", new Object[0]);
      AppMethodBeat.o(137341);
    }
  }
  
  public final boolean fdf()
  {
    return false;
  }
  
  public final com.tencent.mm.bb.c fdg()
  {
    AppMethodBeat.i(137349);
    int k = getDuration();
    int m = fdx();
    int i;
    int j;
    if (bnx())
    {
      i = 1;
      Log.i("MicroMsg.Music.MusicPlayer", "get music status = %d", new Object[] { Integer.valueOf(i) });
      j = getDownloadPercent();
      if (k <= 0) {
        break label165;
      }
    }
    for (;;)
    {
      if (this.FTa != null) {
        this.FTa.v(k, m, i, j);
      }
      for (;;)
      {
        this.FTa.fMe = false;
        this.FTa.kkV = ffk();
        com.tencent.mm.bb.c localc = this.FTa;
        AppMethodBeat.o(137349);
        return localc;
        if ((this.FOH) && ((this.FSZ) || (this.FOD))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label141;
          }
          i = 0;
          break;
        }
        label141:
        i = 2;
        break;
        this.FTa = new com.tencent.mm.bb.c(k, m, i, j);
      }
      label165:
      j = 0;
    }
  }
  
  public final void fdr()
  {
    AppMethodBeat.i(137340);
    Log.i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.fev().bYq();
    AppMethodBeat.o(137340);
  }
  
  public final int fdx()
  {
    AppMethodBeat.i(137345);
    if (this.FSY != null)
    {
      int i = this.FSY.ffm();
      AppMethodBeat.o(137345);
      return i;
    }
    AppMethodBeat.o(137345);
    return -1;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137346);
    if (this.FSY != null)
    {
      int i = this.FSY.getDuration();
      AppMethodBeat.o(137346);
      return i;
    }
    AppMethodBeat.o(137346);
    return -1;
  }
  
  public final void h(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(137336);
    super.h(paramf);
    Log.i("MicroMsg.Music.MusicPlayer", "init and start download");
    stopPlay();
    if (paramf == null)
    {
      Log.i("MicroMsg.Music.MusicPlayer", "music is null");
      AppMethodBeat.o(137336);
      return;
    }
    this.FSD = new com.tencent.mm.plugin.music.c.b(paramf, e.aRK(paramf.lVt));
    this.FSD.FQc = this.FTb;
    if (this.FSQ != null)
    {
      this.FSQ.v(paramf);
      Log.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
      this.FSQ.feh();
      this.FSQ.a(this.FSD);
    }
    this.FQe = paramf;
    b(paramf, false);
    Log.i("MicroMsg.Music.MusicPlayer", "startPlay src:%s,  playUrl:%s", new Object[] { paramf.lVz, paramf.playUrl });
    this.FSD.start();
    ffj();
    AppMethodBeat.o(137336);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137339);
    this.FQs = false;
    Log.i("MicroMsg.Music.MusicPlayer", "pause");
    try
    {
      if ((this.FSY != null) && (this.FSY.isPlaying()))
      {
        this.FSY.pause();
        this.FSZ = true;
        K(this.FQe);
      }
      AppMethodBeat.o(137339);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "pause", new Object[0]);
      AppMethodBeat.o(137339);
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137342);
    try
    {
      if ((this.FSY != null) && (!this.FSY.isPlaying()))
      {
        Log.i("MicroMsg.Music.MusicPlayer", "resume");
        if (k.fev().avy())
        {
          this.FSY.play();
          J(this.FQe);
          AppMethodBeat.o(137342);
          return;
        }
        Log.e("MicroMsg.Music.MusicPlayer", "request focus error");
        AppMethodBeat.o(137342);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "resume", new Object[0]);
      AppMethodBeat.o(137342);
      return;
    }
    Log.i("MicroMsg.Music.MusicPlayer", "music is playing");
    AppMethodBeat.o(137342);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137344);
    Log.i("MicroMsg.Music.MusicPlayer", "stopPlay");
    if ((this.FSY != null) && ((this.FSY instanceof c))) {
      aSp(this.FSY.aeE());
    }
    try
    {
      if (this.FSD != null)
      {
        this.FSD.isStop = true;
        this.FSD = null;
      }
      if (this.FSY != null)
      {
        this.FSY.stop();
        this.FSY = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "stopPlay", new Object[0]);
      }
    }
    k.fev().bYq();
    this.FOH = false;
    this.FQs = false;
    AppMethodBeat.o(137344);
  }
  
  public final boolean wG(int paramInt)
  {
    AppMethodBeat.i(137348);
    Log.i("MicroMsg.Music.MusicPlayer", "seekToMusic pos:%d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = getDuration();
      int j = getDownloadPercent();
      if ((i < 0) || (paramInt > i))
      {
        Log.e("MicroMsg.Music.MusicPlayer", "duration or position is illegal, stop");
        stopPlay();
        AppMethodBeat.o(137348);
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
          Log.i("MicroMsg.Music.MusicPlayer", "on completed seekto, position is %d =", new Object[] { Integer.valueOf(i) });
        }
      }
      if ((this.FSY != null) && (i >= 0))
      {
        this.FSY.seek(i);
        M(this.FQe);
        AppMethodBeat.o(137348);
        return true;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "seekTo", new Object[0]);
      AppMethodBeat.o(137348);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d
 * JD-Core Version:    0.7.0.1
 */