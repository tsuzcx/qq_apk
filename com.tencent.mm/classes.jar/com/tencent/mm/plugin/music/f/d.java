package com.tencent.mm.plugin.music.f;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.c.b.b;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;

public final class d
  extends a
{
  boolean wiy;
  com.tencent.mm.az.f wjT;
  public boolean wkh;
  com.tencent.mm.plugin.music.c.b wlF;
  com.tencent.mm.plugin.music.f.a.b wmb;
  boolean wmc;
  private com.tencent.mm.az.c wmd;
  b.b wme;
  
  public d()
  {
    AppMethodBeat.i(137335);
    this.wme = new b.b()
    {
      public final void Li(final int paramAnonymousInt)
      {
        AppMethodBeat.i(137334);
        if (paramAnonymousInt == 1)
        {
          if ((d.this.wlF != null) && (!d.this.wiy) && (d.this.wmb != null))
          {
            Object localObject = com.tencent.mm.plugin.music.h.b.bz(d.this.wlF.wjM.ihg, d.this.wlF.ruo);
            d.this.wmb.asL((String)localObject);
            localObject = d.this;
            if (k.dtc().requestFocus())
            {
              ad.i("MicroMsg.Music.MusicPlayer", "startPlay");
              try
              {
                if (((d)localObject).wmb != null) {
                  ((d)localObject).wmb.play();
                }
                ((d)localObject).wiy = true;
                ((d)localObject).wmc = false;
                AppMethodBeat.o(137334);
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ad.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "startPlay", new Object[0]);
                }
              }
            }
            ad.e("MicroMsg.Music.MusicPlayer", "request focus error");
            AppMethodBeat.o(137334);
          }
        }
        else
        {
          if ((paramAnonymousInt == -2) || (paramAnonymousInt == 5) || (paramAnonymousInt == 19))
          {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(137332);
                Toast.makeText(aj.getContext(), aj.getContext().getString(2131761480), 0).show();
                d.a(d.this, d.this.wjT, paramAnonymousInt);
                AppMethodBeat.o(137332);
              }
            });
            AppMethodBeat.o(137334);
            return;
          }
          if ((paramAnonymousInt == -1) || (paramAnonymousInt == 6) || (paramAnonymousInt == 4))
          {
            aq.f(new d.2.2(this));
            d.a(d.this, d.this.wjT, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(137334);
      }
    };
    this.wkh = false;
    AppMethodBeat.o(137335);
  }
  
  private void asM(String paramString)
  {
    AppMethodBeat.i(137350);
    if (this.wlS != null) {
      this.wlS.a(this.wjT, paramString);
    }
    AppMethodBeat.o(137350);
  }
  
  private int getDownloadPercent()
  {
    AppMethodBeat.i(137347);
    if (this.wlF != null)
    {
      com.tencent.mm.plugin.music.c.b localb = this.wlF;
      int i;
      if (localb.ruo)
      {
        ad.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.wjN.wjK), Long.valueOf(localb.wjN.wjI) });
        if (localb.wjN.wjK != 0L) {
          i = (int)(localb.wjN.wjI * 100L / localb.wjN.wjK);
        }
      }
      while (i > 0)
      {
        AppMethodBeat.o(137347);
        return i;
        i = 0;
        continue;
        ad.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.wjN.wjH), Long.valueOf(localb.wjN.wjG) });
        if (localb.wjN.wjH != 0L) {
          i = (int)(localb.wjN.wjG * 100L / localb.wjN.wjH);
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
  
  public final boolean aJG()
  {
    AppMethodBeat.i(137343);
    if (this.wmb != null) {
      try
      {
        boolean bool = this.wmb.isPlaying();
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
  
  public final boolean aJH()
  {
    return (this.wiy) && (this.wkh);
  }
  
  public final boolean aJI()
  {
    return this.wiy;
  }
  
  final void b(com.tencent.mm.az.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(137338);
    if (this.wmb == null)
    {
      if ((paramBoolean) || (!com.tencent.mm.compatible.util.d.lA(15))) {
        break label71;
      }
      ad.i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
    }
    for (this.wmb = new c();; this.wmb = new b())
    {
      this.wmb.N(paramf);
      this.wmb.a(new com.tencent.mm.plugin.music.f.a.f()
      {
        long wmf;
        
        public final void M(com.tencent.mm.az.f paramAnonymousf)
        {
          AppMethodBeat.i(137329);
          com.tencent.mm.az.f localf = k.dta().dsL();
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
          if ((localf.f(paramAnonymousf)) && (d.this.wmb != null) && (d.this.wmb.isPlaying()))
          {
            j = d.this.wmb.dtv();
            k = d.this.wmb.getDuration();
            if ((j > 0) && (k > 0))
            {
              f2 = j / k;
              if (d.this.wlF != null)
              {
                paramAnonymousf = d.this.wlF;
                paramAnonymousf.wjO = f2;
                boolean bool = ay.isNetworkConnected(aj.getContext());
                if ((paramAnonymousf.isStop) && (bool))
                {
                  if (!paramAnonymousf.ruo) {
                    break label348;
                  }
                  if (paramAnonymousf.wjN.wjK != 0L)
                  {
                    f1 = (float)paramAnonymousf.wjN.wjI / (float)paramAnonymousf.wjN.wjK;
                    if ((f1 < 1.0F) && (f1 - f2 <= 0.15F) && (bool))
                    {
                      ad.v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Boolean.valueOf(bool) });
                      paramAnonymousf.start();
                    }
                  }
                }
                if ((d.this.wlF != null) && (d.this.wlF.isStop))
                {
                  paramAnonymousf = d.this.wlF;
                  if (!paramAnonymousf.ruo) {
                    break label381;
                  }
                  if (paramAnonymousf.wjN.wjK == 0L) {
                    break label429;
                  }
                  f1 = (float)paramAnonymousf.wjN.wjI / (float)paramAnonymousf.wjN.wjK;
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
              ad.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
              d.this.stopPlay();
            }
            d.this.eZ(j, k);
            AppMethodBeat.o(137329);
            return;
            label348:
            if (paramAnonymousf.wjN.wjH == 0L) {
              break label235;
            }
            f1 = (float)paramAnonymousf.wjN.wjG / (float)paramAnonymousf.wjN.wjH;
            break;
            label381:
            if (paramAnonymousf.wjN.wjH != 0L)
            {
              f1 = (float)paramAnonymousf.wjN.wjG / (float)paramAnonymousf.wjN.wjH;
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
        
        public final void c(com.tencent.mm.az.f paramAnonymousf, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(137330);
          ad.i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
          com.tencent.mm.az.f localf = k.dta().dsL();
          if (localf == null)
          {
            AppMethodBeat.o(137330);
            return;
          }
          if (localf.f(paramAnonymousf)) {
            d.this.stopPlay();
          }
          d.this.H(d.this.wjT);
          if (paramAnonymousBoolean) {
            d.this.K(d.this.wjT);
          }
          AppMethodBeat.o(137330);
        }
        
        public final void d(com.tencent.mm.az.f paramAnonymousf, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(137331);
          com.tencent.mm.az.f localf = k.dta().dsL();
          if (localf == null)
          {
            AppMethodBeat.o(137331);
            return;
          }
          ad.i("MicroMsg.Music.MusicPlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean) {
            d.a(d.this, paramAnonymousf, 20);
          }
          while (localf.f(paramAnonymousf))
          {
            ad.i("MicroMsg.Music.MusicPlayer", "stop");
            d.this.stopPlay();
            if (paramAnonymousBoolean)
            {
              ad.i("MicroMsg.Music.MusicPlayer", "retry system media player again");
              d.this.b(localf, true);
              d.this.wlF = new com.tencent.mm.plugin.music.c.b(paramAnonymousf, e.asl(paramAnonymousf.ihg));
              d.this.wlF.wjR = d.this.wme;
              d.this.wlF.start();
              if (d.this.wlS == null) {
                break label245;
              }
              d.this.wlS.a(d.this.wlF);
              AppMethodBeat.o(137331);
              return;
              d.a(d.this, paramAnonymousf, 21);
            }
            else
            {
              aq.f(new d.1.1(this));
              d.this.H(d.this.wjT);
              AppMethodBeat.o(137331);
              return;
            }
          }
          ad.i("MicroMsg.Music.MusicPlayer", "send stop event");
          d.this.H(d.this.wjT);
          label245:
          AppMethodBeat.o(137331);
        }
        
        public final void n(com.tencent.mm.az.f paramAnonymousf)
        {
          AppMethodBeat.i(137328);
          ad.i("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
          d.this.E(paramAnonymousf);
          AppMethodBeat.o(137328);
        }
      });
      AppMethodBeat.o(137338);
      return;
      label71:
      ad.i("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
    }
  }
  
  public final void drJ()
  {
    AppMethodBeat.i(137341);
    this.wkh = true;
    ad.i("MicroMsg.Music.MusicPlayer", "passivePause");
    try
    {
      if ((this.wmb != null) && (this.wmb.isPlaying()))
      {
        this.wmb.pause();
        G(this.wjT);
      }
      AppMethodBeat.o(137341);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "passivePause", new Object[0]);
      AppMethodBeat.o(137341);
    }
  }
  
  public final boolean drK()
  {
    return false;
  }
  
  public final com.tencent.mm.az.c drL()
  {
    AppMethodBeat.i(137349);
    int k = getDuration();
    int m = dsc();
    int i;
    int j;
    if (aJG())
    {
      i = 1;
      ad.i("MicroMsg.Music.MusicPlayer", "get music status = %d", new Object[] { Integer.valueOf(i) });
      j = getDownloadPercent();
      if (k <= 0) {
        break label165;
      }
    }
    for (;;)
    {
      if (this.wmd != null) {
        this.wmd.t(k, m, i, j);
      }
      for (;;)
      {
        this.wmd.dzM = false;
        this.wmd.ihb = dtt();
        com.tencent.mm.az.c localc = this.wmd;
        AppMethodBeat.o(137349);
        return localc;
        if ((this.wiy) && ((this.wmc) || (this.wit))) {}
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
        this.wmd = new com.tencent.mm.az.c(k, m, i, j);
      }
      label165:
      j = 0;
    }
  }
  
  public final void drX()
  {
    AppMethodBeat.i(137340);
    ad.i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.dtc().bpH();
    AppMethodBeat.o(137340);
  }
  
  protected final void dsD()
  {
    AppMethodBeat.i(137337);
    this.wlS = ((com.tencent.mm.plugin.music.e.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.d.class));
    this.wlT = k.dta().wkp;
    AppMethodBeat.o(137337);
  }
  
  public final int dsc()
  {
    AppMethodBeat.i(137345);
    if (this.wmb != null)
    {
      int i = this.wmb.dtv();
      AppMethodBeat.o(137345);
      return i;
    }
    AppMethodBeat.o(137345);
    return -1;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137346);
    if (this.wmb != null)
    {
      int i = this.wmb.getDuration();
      AppMethodBeat.o(137346);
      return i;
    }
    AppMethodBeat.o(137346);
    return -1;
  }
  
  public final void h(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(137336);
    super.h(paramf);
    ad.i("MicroMsg.Music.MusicPlayer", "init and start download");
    stopPlay();
    if (paramf == null)
    {
      ad.i("MicroMsg.Music.MusicPlayer", "music is null");
      AppMethodBeat.o(137336);
      return;
    }
    this.wlF = new com.tencent.mm.plugin.music.c.b(paramf, e.asl(paramf.ihg));
    this.wlF.wjR = this.wme;
    if (this.wlS != null)
    {
      this.wlS.v(paramf);
      ad.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
      this.wlS.dsO();
      this.wlS.a(this.wlF);
    }
    this.wjT = paramf;
    b(paramf, false);
    ad.i("MicroMsg.Music.MusicPlayer", "startPlay src:%s,  playUrl:%s", new Object[] { paramf.ihm, paramf.playUrl });
    this.wlF.start();
    dts();
    AppMethodBeat.o(137336);
  }
  
  public final boolean pO(int paramInt)
  {
    AppMethodBeat.i(137348);
    ad.i("MicroMsg.Music.MusicPlayer", "seekToMusic pos:%d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = getDuration();
      int j = getDownloadPercent();
      if ((i < 0) || (paramInt > i))
      {
        ad.e("MicroMsg.Music.MusicPlayer", "duration or position is illegal, stop");
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
          ad.i("MicroMsg.Music.MusicPlayer", "on completed seekto, position is %d =", new Object[] { Integer.valueOf(i) });
        }
      }
      if ((this.wmb != null) && (i >= 0))
      {
        this.wmb.seek(i);
        I(this.wjT);
        AppMethodBeat.o(137348);
        return true;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "seekTo", new Object[0]);
      AppMethodBeat.o(137348);
    }
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137339);
    this.wkh = false;
    ad.i("MicroMsg.Music.MusicPlayer", "pause");
    try
    {
      if ((this.wmb != null) && (this.wmb.isPlaying()))
      {
        this.wmb.pause();
        this.wmc = true;
        G(this.wjT);
      }
      AppMethodBeat.o(137339);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "pause", new Object[0]);
      AppMethodBeat.o(137339);
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137342);
    try
    {
      if ((this.wmb != null) && (!this.wmb.isPlaying()))
      {
        ad.i("MicroMsg.Music.MusicPlayer", "resume");
        if (k.dtc().requestFocus())
        {
          this.wmb.play();
          F(this.wjT);
          AppMethodBeat.o(137342);
          return;
        }
        ad.e("MicroMsg.Music.MusicPlayer", "request focus error");
        AppMethodBeat.o(137342);
        return;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "resume", new Object[0]);
      AppMethodBeat.o(137342);
      return;
    }
    ad.i("MicroMsg.Music.MusicPlayer", "music is playing");
    AppMethodBeat.o(137342);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137344);
    ad.i("MicroMsg.Music.MusicPlayer", "stopPlay");
    if ((this.wmb != null) && ((this.wmb instanceof c))) {
      asM(this.wmb.dtw());
    }
    try
    {
      if (this.wlF != null)
      {
        this.wlF.isStop = true;
        this.wlF = null;
      }
      if (this.wmb != null)
      {
        this.wmb.stop();
        this.wmb = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "stopPlay", new Object[0]);
      }
    }
    k.dtc().bpH();
    this.wiy = false;
    this.wkh = false;
    AppMethodBeat.o(137344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d
 * JD-Core Version:    0.7.0.1
 */