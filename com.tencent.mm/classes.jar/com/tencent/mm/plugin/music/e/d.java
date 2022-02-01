package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.c.b.b;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class d
  extends a
{
  boolean LJC;
  com.tencent.mm.aw.f LLa;
  public boolean LLo;
  com.tencent.mm.plugin.music.e.a.b LNU;
  boolean LNV;
  private com.tencent.mm.aw.c LNW;
  b.b LNX;
  com.tencent.mm.plugin.music.c.b LNz;
  
  public d()
  {
    AppMethodBeat.i(137335);
    this.LNX = new b.b()
    {
      public final void ads(int paramAnonymousInt)
      {
        AppMethodBeat.i(137334);
        if (paramAnonymousInt == 1)
        {
          if ((d.this.LNz != null) && (!d.this.LJC) && (d.this.LNU != null))
          {
            Object localObject = com.tencent.mm.plugin.music.h.b.cy(d.this.LNz.LKT.oOv, d.this.LNz.Aey);
            d.this.LNU.aPi((String)localObject);
            localObject = d.this;
            if (j.gny().requestFocus())
            {
              Log.i("MicroMsg.Music.MusicPlayer", "startPlay");
              try
              {
                if (((d)localObject).LNU != null) {
                  ((d)localObject).LNU.play();
                }
                ((d)localObject).LJC = true;
                ((d)localObject).LNV = false;
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
            d.a(d.this, d.this.LLa, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(137334);
      }
    };
    this.LLo = false;
    AppMethodBeat.o(137335);
  }
  
  private void aPj(String paramString)
  {
    AppMethodBeat.i(137350);
    if (this.LNM != null) {
      this.LNM.a(this.LLa, paramString);
    }
    AppMethodBeat.o(137350);
  }
  
  private int getDownloadPercent()
  {
    AppMethodBeat.i(137347);
    if (this.LNz != null)
    {
      com.tencent.mm.plugin.music.c.b localb = this.LNz;
      int i;
      if (localb.Aey)
      {
        Log.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.LKU.LKR), Long.valueOf(localb.LKU.LKP) });
        if (localb.LKU.LKR != 0L) {
          i = (int)(localb.LKU.LKP * 100L / localb.LKU.LKR);
        }
      }
      while (i > 0)
      {
        AppMethodBeat.o(137347);
        return i;
        i = 0;
        continue;
        Log.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.LKU.LKO), Long.valueOf(localb.LKU.LKN) });
        if (localb.LKU.LKO != 0L) {
          i = (int)(localb.LKU.LKN * 100L / localb.LKU.LKO);
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
  
  final void b(com.tencent.mm.aw.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(137338);
    if (this.LNU == null)
    {
      if ((paramBoolean) || (!com.tencent.mm.compatible.util.d.rd(15))) {
        break label71;
      }
      Log.i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
    }
    for (this.LNU = new c();; this.LNU = new b())
    {
      this.LNU.W(paramf);
      this.LNU.a(new com.tencent.mm.plugin.music.e.a.f()
      {
        long LNY;
        
        public final void V(com.tencent.mm.aw.f paramAnonymousf)
        {
          AppMethodBeat.i(137329);
          com.tencent.mm.aw.f localf = j.gnw().gng();
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
          if ((localf.f(paramAnonymousf)) && (d.this.LNU != null) && (d.this.LNU.isPlaying()))
          {
            j = d.this.LNU.gov();
            k = d.this.LNU.getDuration();
            if ((j > 0) && (k > 0))
            {
              f2 = j / k;
              if (d.this.LNz != null)
              {
                paramAnonymousf = d.this.LNz;
                paramAnonymousf.LKV = f2;
                boolean bool = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
                if ((paramAnonymousf.isStop) && (bool))
                {
                  if (!paramAnonymousf.Aey) {
                    break label348;
                  }
                  if (paramAnonymousf.LKU.LKR != 0L)
                  {
                    f1 = (float)paramAnonymousf.LKU.LKP / (float)paramAnonymousf.LKU.LKR;
                    if ((f1 < 1.0F) && (f1 - f2 <= 0.15F) && (bool))
                    {
                      Log.v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Boolean.valueOf(bool) });
                      paramAnonymousf.start();
                    }
                  }
                }
                if ((d.this.LNz != null) && (d.this.LNz.isStop))
                {
                  paramAnonymousf = d.this.LNz;
                  if (!paramAnonymousf.Aey) {
                    break label381;
                  }
                  if (paramAnonymousf.LKU.LKR == 0L) {
                    break label429;
                  }
                  f1 = (float)paramAnonymousf.LKU.LKP / (float)paramAnonymousf.LKU.LKR;
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
            d.this.onProgress(j, k);
            AppMethodBeat.o(137329);
            return;
            label348:
            if (paramAnonymousf.LKU.LKO == 0L) {
              break label235;
            }
            f1 = (float)paramAnonymousf.LKU.LKN / (float)paramAnonymousf.LKU.LKO;
            break;
            label381:
            if (paramAnonymousf.LKU.LKO != 0L)
            {
              f1 = (float)paramAnonymousf.LKU.LKN / (float)paramAnonymousf.LKU.LKO;
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
        
        public final void c(com.tencent.mm.aw.f paramAnonymousf, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(137330);
          Log.i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
          com.tencent.mm.aw.f localf = j.gnw().gng();
          if (localf == null)
          {
            AppMethodBeat.o(137330);
            return;
          }
          if (localf.f(paramAnonymousf)) {
            d.this.stopPlay();
          }
          d.this.Q(d.this.LLa);
          if (paramAnonymousBoolean) {
            d.this.T(d.this.LLa);
          }
          AppMethodBeat.o(137330);
        }
        
        public final void d(com.tencent.mm.aw.f paramAnonymousf, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(137331);
          com.tencent.mm.aw.f localf = j.gnw().gng();
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
              d.this.LNz = new com.tencent.mm.plugin.music.c.b(paramAnonymousf, e.aOC(paramAnonymousf.oOv));
              d.this.LNz.LKY = d.this.LNX;
              d.this.LNz.start();
              if (d.this.LNM == null) {
                break label245;
              }
              d.this.LNM.a(d.this.LNz);
              AppMethodBeat.o(137331);
              return;
              d.a(d.this, paramAnonymousf, 21);
            }
            else
            {
              MMHandlerThread.postToMainThread(new d.1.1(this));
              d.this.Q(d.this.LLa);
              AppMethodBeat.o(137331);
              return;
            }
          }
          Log.i("MicroMsg.Music.MusicPlayer", "send stop event");
          d.this.Q(d.this.LLa);
          label245:
          AppMethodBeat.o(137331);
        }
        
        public final void p(com.tencent.mm.aw.f paramAnonymousf)
        {
          AppMethodBeat.i(137328);
          Log.i("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
          d.this.N(paramAnonymousf);
          AppMethodBeat.o(137328);
        }
      });
      AppMethodBeat.o(137338);
      return;
      label71:
      Log.i("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
    }
  }
  
  public final boolean bLk()
  {
    AppMethodBeat.i(137343);
    if (this.LNU != null) {
      try
      {
        bool = this.LNU.isPlaying();
      }
      finally
      {
        boolean bool;
        AppMethodBeat.o(137343);
        return false;
      }
    }
    AppMethodBeat.o(137343);
    return false;
  }
  
  public final boolean bLl()
  {
    return (this.LJC) && (this.LLo);
  }
  
  public final boolean bLm()
  {
    return this.LJC;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137346);
    if (this.LNU != null)
    {
      int i = this.LNU.getDuration();
      AppMethodBeat.o(137346);
      return i;
    }
    AppMethodBeat.o(137346);
    return -1;
  }
  
  public final int gmA()
  {
    AppMethodBeat.i(137345);
    if (this.LNU != null)
    {
      int i = this.LNU.gov();
      AppMethodBeat.o(137345);
      return i;
    }
    AppMethodBeat.o(137345);
    return -1;
  }
  
  protected final void gmZ()
  {
    AppMethodBeat.i(137337);
    this.LNM = ((com.tencent.mm.plugin.music.logic.d)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.d.class));
    this.LNN = j.gnw().LLw;
    AppMethodBeat.o(137337);
  }
  
  public final void gmh()
  {
    AppMethodBeat.i(137341);
    this.LLo = true;
    Log.i("MicroMsg.Music.MusicPlayer", "passivePause");
    try
    {
      if ((this.LNU != null) && (this.LNU.isPlaying()))
      {
        this.LNU.pause();
        P(this.LLa);
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
  
  public final boolean gmi()
  {
    return false;
  }
  
  public final com.tencent.mm.aw.c gmj()
  {
    AppMethodBeat.i(137349);
    int k = getDuration();
    int m = gmA();
    int i;
    int j;
    if (bLk())
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
      if (this.LNW != null) {
        this.LNW.B(k, m, i, j);
      }
      for (;;)
      {
        this.LNW.hRO = false;
        this.LNW.mLR = got();
        com.tencent.mm.aw.c localc = this.LNW;
        AppMethodBeat.o(137349);
        return localc;
        if ((this.LJC) && ((this.LNV) || (this.LJy))) {}
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
        this.LNW = new com.tencent.mm.aw.c(k, m, i, j);
      }
      label165:
      j = 0;
    }
  }
  
  public final void gmu()
  {
    AppMethodBeat.i(137340);
    Log.i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
    pause();
    j.gny().cyG();
    AppMethodBeat.o(137340);
  }
  
  public final void h(com.tencent.mm.aw.f paramf)
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
    this.LNz = new com.tencent.mm.plugin.music.c.b(paramf, e.aOC(paramf.oOv));
    this.LNz.LKY = this.LNX;
    if (this.LNM != null)
    {
      this.LNM.z(paramf);
      Log.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
      this.LNM.gnk();
      this.LNM.a(this.LNz);
    }
    this.LLa = paramf;
    b(paramf, false);
    Log.i("MicroMsg.Music.MusicPlayer", "startPlay src:%s,  playUrl:%s", new Object[] { paramf.oOB, paramf.playUrl });
    this.LNz.start();
    gos();
    AppMethodBeat.o(137336);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137339);
    this.LLo = false;
    Log.i("MicroMsg.Music.MusicPlayer", "pause");
    try
    {
      if ((this.LNU != null) && (this.LNU.isPlaying()))
      {
        this.LNU.pause();
        this.LNV = true;
        P(this.LLa);
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
      if ((this.LNU != null) && (!this.LNU.isPlaying()))
      {
        Log.i("MicroMsg.Music.MusicPlayer", "resume");
        if (j.gny().requestFocus())
        {
          this.LNU.play();
          O(this.LLa);
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
    if ((this.LNU != null) && ((this.LNU instanceof c))) {
      aPj(this.LNU.aGC());
    }
    try
    {
      if (this.LNz != null)
      {
        this.LNz.isStop = true;
        this.LNz = null;
      }
      if (this.LNU != null)
      {
        this.LNU.stop();
        this.LNU = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "stopPlay", new Object[0]);
      }
    }
    j.gny().cyG();
    this.LJC = false;
    this.LLo = false;
    AppMethodBeat.o(137344);
  }
  
  public final boolean wH(int paramInt)
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
      if ((this.LNU != null) && (i >= 0))
      {
        this.LNU.seek(i);
        R(this.LLa);
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
 * Qualified Name:     com.tencent.mm.plugin.music.e.d
 * JD-Core Version:    0.7.0.1
 */