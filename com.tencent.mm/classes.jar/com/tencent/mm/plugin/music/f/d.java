package com.tencent.mm.plugin.music.f;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.c.b.b;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;

public final class d
  extends a
{
  com.tencent.mm.plugin.music.f.a.b wBK;
  boolean wBL;
  private com.tencent.mm.ay.c wBM;
  b.b wBN;
  com.tencent.mm.plugin.music.c.b wBo;
  boolean wyd;
  public boolean wzM;
  com.tencent.mm.ay.f wzy;
  
  public d()
  {
    AppMethodBeat.i(137335);
    this.wBN = new b.b()
    {
      public final void LN(final int paramAnonymousInt)
      {
        AppMethodBeat.i(137334);
        if (paramAnonymousInt == 1)
        {
          if ((d.this.wBo != null) && (!d.this.wyd) && (d.this.wBK != null))
          {
            Object localObject = com.tencent.mm.plugin.music.h.b.bD(d.this.wBo.wzr.ijZ, d.this.wBo.rCA);
            d.this.wBK.atY((String)localObject);
            localObject = d.this;
            if (k.dwr().requestFocus())
            {
              ae.i("MicroMsg.Music.MusicPlayer", "startPlay");
              try
              {
                if (((d)localObject).wBK != null) {
                  ((d)localObject).wBK.play();
                }
                ((d)localObject).wyd = true;
                ((d)localObject).wBL = false;
                AppMethodBeat.o(137334);
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ae.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "startPlay", new Object[0]);
                }
              }
            }
            ae.e("MicroMsg.Music.MusicPlayer", "request focus error");
            AppMethodBeat.o(137334);
          }
        }
        else
        {
          if ((paramAnonymousInt == -2) || (paramAnonymousInt == 5) || (paramAnonymousInt == 19))
          {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(137332);
                Toast.makeText(ak.getContext(), ak.getContext().getString(2131761480), 0).show();
                d.a(d.this, d.this.wzy, paramAnonymousInt);
                AppMethodBeat.o(137332);
              }
            });
            AppMethodBeat.o(137334);
            return;
          }
          if ((paramAnonymousInt == -1) || (paramAnonymousInt == 6) || (paramAnonymousInt == 4))
          {
            ar.f(new d.2.2(this));
            d.a(d.this, d.this.wzy, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(137334);
      }
    };
    this.wzM = false;
    AppMethodBeat.o(137335);
  }
  
  private void atZ(String paramString)
  {
    AppMethodBeat.i(137350);
    if (this.wBB != null) {
      this.wBB.a(this.wzy, paramString);
    }
    AppMethodBeat.o(137350);
  }
  
  private int getDownloadPercent()
  {
    AppMethodBeat.i(137347);
    if (this.wBo != null)
    {
      com.tencent.mm.plugin.music.c.b localb = this.wBo;
      int i;
      if (localb.rCA)
      {
        ae.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.wzs.wzp), Long.valueOf(localb.wzs.wzn) });
        if (localb.wzs.wzp != 0L) {
          i = (int)(localb.wzs.wzn * 100L / localb.wzs.wzp);
        }
      }
      while (i > 0)
      {
        AppMethodBeat.o(137347);
        return i;
        i = 0;
        continue;
        ae.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.wzs.wzm), Long.valueOf(localb.wzs.wzl) });
        if (localb.wzs.wzm != 0L) {
          i = (int)(localb.wzs.wzl * 100L / localb.wzs.wzm);
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
  
  public final boolean aJZ()
  {
    AppMethodBeat.i(137343);
    if (this.wBK != null) {
      try
      {
        boolean bool = this.wBK.isPlaying();
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
  
  public final boolean aKa()
  {
    return (this.wyd) && (this.wzM);
  }
  
  public final boolean aKb()
  {
    return this.wyd;
  }
  
  final void b(com.tencent.mm.ay.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(137338);
    if (this.wBK == null)
    {
      if ((paramBoolean) || (!com.tencent.mm.compatible.util.d.lC(15))) {
        break label71;
      }
      ae.i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
    }
    for (this.wBK = new c();; this.wBK = new b())
    {
      this.wBK.N(paramf);
      this.wBK.a(new com.tencent.mm.plugin.music.f.a.f()
      {
        long wBO;
        
        public final void M(com.tencent.mm.ay.f paramAnonymousf)
        {
          AppMethodBeat.i(137329);
          com.tencent.mm.ay.f localf = k.dwp().dwa();
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
          if ((localf.f(paramAnonymousf)) && (d.this.wBK != null) && (d.this.wBK.isPlaying()))
          {
            j = d.this.wBK.dwK();
            k = d.this.wBK.getDuration();
            if ((j > 0) && (k > 0))
            {
              f2 = j / k;
              if (d.this.wBo != null)
              {
                paramAnonymousf = d.this.wBo;
                paramAnonymousf.wzt = f2;
                boolean bool = az.isNetworkConnected(ak.getContext());
                if ((paramAnonymousf.isStop) && (bool))
                {
                  if (!paramAnonymousf.rCA) {
                    break label348;
                  }
                  if (paramAnonymousf.wzs.wzp != 0L)
                  {
                    f1 = (float)paramAnonymousf.wzs.wzn / (float)paramAnonymousf.wzs.wzp;
                    if ((f1 < 1.0F) && (f1 - f2 <= 0.15F) && (bool))
                    {
                      ae.v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Boolean.valueOf(bool) });
                      paramAnonymousf.start();
                    }
                  }
                }
                if ((d.this.wBo != null) && (d.this.wBo.isStop))
                {
                  paramAnonymousf = d.this.wBo;
                  if (!paramAnonymousf.rCA) {
                    break label381;
                  }
                  if (paramAnonymousf.wzs.wzp == 0L) {
                    break label429;
                  }
                  f1 = (float)paramAnonymousf.wzs.wzn / (float)paramAnonymousf.wzs.wzp;
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
              ae.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
              d.this.stopPlay();
            }
            d.this.fa(j, k);
            AppMethodBeat.o(137329);
            return;
            label348:
            if (paramAnonymousf.wzs.wzm == 0L) {
              break label235;
            }
            f1 = (float)paramAnonymousf.wzs.wzl / (float)paramAnonymousf.wzs.wzm;
            break;
            label381:
            if (paramAnonymousf.wzs.wzm != 0L)
            {
              f1 = (float)paramAnonymousf.wzs.wzl / (float)paramAnonymousf.wzs.wzm;
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
        
        public final void c(com.tencent.mm.ay.f paramAnonymousf, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(137330);
          ae.i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
          com.tencent.mm.ay.f localf = k.dwp().dwa();
          if (localf == null)
          {
            AppMethodBeat.o(137330);
            return;
          }
          if (localf.f(paramAnonymousf)) {
            d.this.stopPlay();
          }
          d.this.H(d.this.wzy);
          if (paramAnonymousBoolean) {
            d.this.K(d.this.wzy);
          }
          AppMethodBeat.o(137330);
        }
        
        public final void d(com.tencent.mm.ay.f paramAnonymousf, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(137331);
          com.tencent.mm.ay.f localf = k.dwp().dwa();
          if (localf == null)
          {
            AppMethodBeat.o(137331);
            return;
          }
          ae.i("MicroMsg.Music.MusicPlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean) {
            d.a(d.this, paramAnonymousf, 20);
          }
          while (localf.f(paramAnonymousf))
          {
            ae.i("MicroMsg.Music.MusicPlayer", "stop");
            d.this.stopPlay();
            if (paramAnonymousBoolean)
            {
              ae.i("MicroMsg.Music.MusicPlayer", "retry system media player again");
              d.this.b(localf, true);
              d.this.wBo = new com.tencent.mm.plugin.music.c.b(paramAnonymousf, e.atz(paramAnonymousf.ijZ));
              d.this.wBo.wzw = d.this.wBN;
              d.this.wBo.start();
              if (d.this.wBB == null) {
                break label245;
              }
              d.this.wBB.a(d.this.wBo);
              AppMethodBeat.o(137331);
              return;
              d.a(d.this, paramAnonymousf, 21);
            }
            else
            {
              ar.f(new d.1.1(this));
              d.this.H(d.this.wzy);
              AppMethodBeat.o(137331);
              return;
            }
          }
          ae.i("MicroMsg.Music.MusicPlayer", "send stop event");
          d.this.H(d.this.wzy);
          label245:
          AppMethodBeat.o(137331);
        }
        
        public final void n(com.tencent.mm.ay.f paramAnonymousf)
        {
          AppMethodBeat.i(137328);
          ae.i("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
          d.this.E(paramAnonymousf);
          AppMethodBeat.o(137328);
        }
      });
      AppMethodBeat.o(137338);
      return;
      label71:
      ae.i("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
    }
  }
  
  public final void duX()
  {
    AppMethodBeat.i(137341);
    this.wzM = true;
    ae.i("MicroMsg.Music.MusicPlayer", "passivePause");
    try
    {
      if ((this.wBK != null) && (this.wBK.isPlaying()))
      {
        this.wBK.pause();
        G(this.wzy);
      }
      AppMethodBeat.o(137341);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "passivePause", new Object[0]);
      AppMethodBeat.o(137341);
    }
  }
  
  public final boolean duY()
  {
    return false;
  }
  
  public final com.tencent.mm.ay.c duZ()
  {
    AppMethodBeat.i(137349);
    int k = getDuration();
    int m = dvr();
    int i;
    int j;
    if (aJZ())
    {
      i = 1;
      ae.i("MicroMsg.Music.MusicPlayer", "get music status = %d", new Object[] { Integer.valueOf(i) });
      j = getDownloadPercent();
      if (k <= 0) {
        break label165;
      }
    }
    for (;;)
    {
      if (this.wBM != null) {
        this.wBM.t(k, m, i, j);
      }
      for (;;)
      {
        this.wBM.dAR = false;
        this.wBM.ijU = dwI();
        com.tencent.mm.ay.c localc = this.wBM;
        AppMethodBeat.o(137349);
        return localc;
        if ((this.wyd) && ((this.wBL) || (this.wxY))) {}
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
        this.wBM = new com.tencent.mm.ay.c(k, m, i, j);
      }
      label165:
      j = 0;
    }
  }
  
  protected final void dvS()
  {
    AppMethodBeat.i(137337);
    this.wBB = ((com.tencent.mm.plugin.music.e.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.d.class));
    this.wBC = k.dwp().wzU;
    AppMethodBeat.o(137337);
  }
  
  public final void dvl()
  {
    AppMethodBeat.i(137340);
    ae.i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.dwr().bqr();
    AppMethodBeat.o(137340);
  }
  
  public final int dvr()
  {
    AppMethodBeat.i(137345);
    if (this.wBK != null)
    {
      int i = this.wBK.dwK();
      AppMethodBeat.o(137345);
      return i;
    }
    AppMethodBeat.o(137345);
    return -1;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137346);
    if (this.wBK != null)
    {
      int i = this.wBK.getDuration();
      AppMethodBeat.o(137346);
      return i;
    }
    AppMethodBeat.o(137346);
    return -1;
  }
  
  public final void h(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(137336);
    super.h(paramf);
    ae.i("MicroMsg.Music.MusicPlayer", "init and start download");
    stopPlay();
    if (paramf == null)
    {
      ae.i("MicroMsg.Music.MusicPlayer", "music is null");
      AppMethodBeat.o(137336);
      return;
    }
    this.wBo = new com.tencent.mm.plugin.music.c.b(paramf, e.atz(paramf.ijZ));
    this.wBo.wzw = this.wBN;
    if (this.wBB != null)
    {
      this.wBB.v(paramf);
      ae.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
      this.wBB.dwd();
      this.wBB.a(this.wBo);
    }
    this.wzy = paramf;
    b(paramf, false);
    ae.i("MicroMsg.Music.MusicPlayer", "startPlay src:%s,  playUrl:%s", new Object[] { paramf.ikf, paramf.playUrl });
    this.wBo.start();
    dwH();
    AppMethodBeat.o(137336);
  }
  
  public final boolean pR(int paramInt)
  {
    AppMethodBeat.i(137348);
    ae.i("MicroMsg.Music.MusicPlayer", "seekToMusic pos:%d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = getDuration();
      int j = getDownloadPercent();
      if ((i < 0) || (paramInt > i))
      {
        ae.e("MicroMsg.Music.MusicPlayer", "duration or position is illegal, stop");
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
          ae.i("MicroMsg.Music.MusicPlayer", "on completed seekto, position is %d =", new Object[] { Integer.valueOf(i) });
        }
      }
      if ((this.wBK != null) && (i >= 0))
      {
        this.wBK.seek(i);
        I(this.wzy);
        AppMethodBeat.o(137348);
        return true;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "seekTo", new Object[0]);
      AppMethodBeat.o(137348);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137339);
    this.wzM = false;
    ae.i("MicroMsg.Music.MusicPlayer", "pause");
    try
    {
      if ((this.wBK != null) && (this.wBK.isPlaying()))
      {
        this.wBK.pause();
        this.wBL = true;
        G(this.wzy);
      }
      AppMethodBeat.o(137339);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "pause", new Object[0]);
      AppMethodBeat.o(137339);
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137342);
    try
    {
      if ((this.wBK != null) && (!this.wBK.isPlaying()))
      {
        ae.i("MicroMsg.Music.MusicPlayer", "resume");
        if (k.dwr().requestFocus())
        {
          this.wBK.play();
          F(this.wzy);
          AppMethodBeat.o(137342);
          return;
        }
        ae.e("MicroMsg.Music.MusicPlayer", "request focus error");
        AppMethodBeat.o(137342);
        return;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "resume", new Object[0]);
      AppMethodBeat.o(137342);
      return;
    }
    ae.i("MicroMsg.Music.MusicPlayer", "music is playing");
    AppMethodBeat.o(137342);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137344);
    ae.i("MicroMsg.Music.MusicPlayer", "stopPlay");
    if ((this.wBK != null) && ((this.wBK instanceof c))) {
      atZ(this.wBK.dwL());
    }
    try
    {
      if (this.wBo != null)
      {
        this.wBo.isStop = true;
        this.wBo = null;
      }
      if (this.wBK != null)
      {
        this.wBK.stop();
        this.wBK = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "stopPlay", new Object[0]);
      }
    }
    k.dwr().bqr();
    this.wyd = false;
    this.wzM = false;
    AppMethodBeat.o(137344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d
 * JD-Core Version:    0.7.0.1
 */