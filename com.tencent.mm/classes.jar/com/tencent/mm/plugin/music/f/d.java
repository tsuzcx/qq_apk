package com.tencent.mm.plugin.music.f;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.c.b.b;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;

public final class d
  extends a
{
  boolean rdQ;
  com.tencent.mm.az.f tVP;
  public boolean tWc;
  com.tencent.mm.plugin.music.f.a.b tXT;
  boolean tXU;
  private com.tencent.mm.az.c tXV;
  b.b tXW;
  com.tencent.mm.plugin.music.c.b tXy;
  
  public d()
  {
    AppMethodBeat.i(137335);
    this.tXW = new b.b()
    {
      public final void HH(final int paramAnonymousInt)
      {
        AppMethodBeat.i(137334);
        if (paramAnonymousInt == 1)
        {
          if ((d.this.tXy != null) && (!d.this.rdQ) && (d.this.tXT != null))
          {
            Object localObject = com.tencent.mm.plugin.music.h.b.bl(d.this.tXy.tVI.hnp, d.this.tXy.qbG);
            d.this.tXT.aiR((String)localObject);
            localObject = d.this;
            if (k.cVk().requestFocus())
            {
              ad.i("MicroMsg.Music.MusicPlayer", "startPlay");
              try
              {
                if (((d)localObject).tXT != null) {
                  ((d)localObject).tXT.play();
                }
                ((d)localObject).rdQ = true;
                ((d)localObject).tXU = false;
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
                d.a(d.this, d.this.tVP, paramAnonymousInt);
                AppMethodBeat.o(137332);
              }
            });
            AppMethodBeat.o(137334);
            return;
          }
          if ((paramAnonymousInt == -1) || (paramAnonymousInt == 6) || (paramAnonymousInt == 4))
          {
            aq.f(new d.2.2(this));
            d.a(d.this, d.this.tVP, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(137334);
      }
    };
    this.tWc = false;
    AppMethodBeat.o(137335);
  }
  
  private void aiS(String paramString)
  {
    AppMethodBeat.i(137350);
    if (this.tXL != null) {
      this.tXL.a(this.tVP, paramString);
    }
    AppMethodBeat.o(137350);
  }
  
  private int getDownloadPercent()
  {
    AppMethodBeat.i(137347);
    if (this.tXy != null)
    {
      com.tencent.mm.plugin.music.c.b localb = this.tXy;
      int i;
      if (localb.qbG)
      {
        ad.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.tVJ.tVG), Long.valueOf(localb.tVJ.tVE) });
        if (localb.tVJ.tVG != 0L) {
          i = (int)(localb.tVJ.tVE * 100L / localb.tVJ.tVG);
        }
      }
      while (i > 0)
      {
        AppMethodBeat.o(137347);
        return i;
        i = 0;
        continue;
        ad.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.tVJ.tVD), Long.valueOf(localb.tVJ.tVC) });
        if (localb.tVJ.tVD != 0L) {
          i = (int)(localb.tVJ.tVC * 100L / localb.tVJ.tVD);
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
  
  public final boolean azF()
  {
    AppMethodBeat.i(137343);
    if (this.tXT != null) {
      try
      {
        boolean bool = this.tXT.isPlaying();
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
  
  public final boolean azG()
  {
    return (this.rdQ) && (this.tWc);
  }
  
  public final boolean azH()
  {
    return this.rdQ;
  }
  
  final void b(com.tencent.mm.az.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(137338);
    if (this.tXT == null)
    {
      if ((paramBoolean) || (!com.tencent.mm.compatible.util.d.lh(15))) {
        break label71;
      }
      ad.i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
    }
    for (this.tXT = new c();; this.tXT = new b())
    {
      this.tXT.M(paramf);
      this.tXT.a(new com.tencent.mm.plugin.music.f.a.f()
      {
        long tXX;
        
        public final void L(com.tencent.mm.az.f paramAnonymousf)
        {
          AppMethodBeat.i(137329);
          com.tencent.mm.az.f localf = k.cVi().cUT();
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
          if ((localf.f(paramAnonymousf)) && (d.this.tXT != null) && (d.this.tXT.isPlaying()))
          {
            j = d.this.tXT.cVD();
            k = d.this.tXT.getDuration();
            if ((j > 0) && (k > 0))
            {
              f2 = j / k;
              if (d.this.tXy != null)
              {
                paramAnonymousf = d.this.tXy;
                paramAnonymousf.tVK = f2;
                boolean bool = ay.isNetworkConnected(aj.getContext());
                if ((paramAnonymousf.isStop) && (bool))
                {
                  if (!paramAnonymousf.qbG) {
                    break label363;
                  }
                  if (paramAnonymousf.tVJ.tVG != 0L)
                  {
                    f1 = (float)paramAnonymousf.tVJ.tVE / (float)paramAnonymousf.tVJ.tVG;
                    if ((f1 < 1.0F) && (f1 - f2 <= 0.15F) && (bool))
                    {
                      ad.v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Boolean.valueOf(bool) });
                      paramAnonymousf.start();
                    }
                  }
                }
                if ((d.this.tXy != null) && (d.this.tXy.isStop))
                {
                  paramAnonymousf = d.this.tXy;
                  if (!paramAnonymousf.qbG) {
                    break label396;
                  }
                  if (paramAnonymousf.tVJ.tVG == 0L) {
                    break label444;
                  }
                  f1 = (float)paramAnonymousf.tVJ.tVE / (float)paramAnonymousf.tVJ.tVG;
                  label303:
                  if (f1 < 1.0F) {
                    break label429;
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
            if (d.this.tUq != null) {
              d.this.tUq.eS(j, k);
            }
            AppMethodBeat.o(137329);
            return;
            label363:
            if (paramAnonymousf.tVJ.tVD == 0L) {
              break label235;
            }
            f1 = (float)paramAnonymousf.tVJ.tVC / (float)paramAnonymousf.tVJ.tVD;
            break;
            label396:
            if (paramAnonymousf.tVJ.tVD != 0L)
            {
              f1 = (float)paramAnonymousf.tVJ.tVC / (float)paramAnonymousf.tVJ.tVD;
              break label303;
              label429:
              if (f1 - f2 > 0.05F)
              {
                i = 1;
                continue;
              }
            }
            label444:
            i = 0;
          }
        }
        
        public final void c(com.tencent.mm.az.f paramAnonymousf, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(137330);
          ad.i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
          com.tencent.mm.az.f localf = k.cVi().cUT();
          if (localf == null)
          {
            AppMethodBeat.o(137330);
            return;
          }
          if (localf.f(paramAnonymousf)) {
            d.this.stopPlay();
          }
          d.this.G(d.this.tVP);
          if (paramAnonymousBoolean) {
            d.this.J(d.this.tVP);
          }
          AppMethodBeat.o(137330);
        }
        
        public final void d(com.tencent.mm.az.f paramAnonymousf, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(137331);
          com.tencent.mm.az.f localf = k.cVi().cUT();
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
              d.this.tXy = new com.tencent.mm.plugin.music.c.b(paramAnonymousf, e.air(paramAnonymousf.hnp));
              d.this.tXy.tVN = d.this.tXW;
              d.this.tXy.start();
              if (d.this.tXL == null) {
                break label245;
              }
              d.this.tXL.a(d.this.tXy);
              AppMethodBeat.o(137331);
              return;
              d.a(d.this, paramAnonymousf, 21);
            }
            else
            {
              aq.f(new d.1.1(this));
              d.this.G(d.this.tVP);
              AppMethodBeat.o(137331);
              return;
            }
          }
          ad.i("MicroMsg.Music.MusicPlayer", "send stop event");
          d.this.G(d.this.tVP);
          label245:
          AppMethodBeat.o(137331);
        }
        
        public final void n(com.tencent.mm.az.f paramAnonymousf)
        {
          AppMethodBeat.i(137328);
          ad.i("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
          d.this.D(paramAnonymousf);
          AppMethodBeat.o(137328);
        }
      });
      AppMethodBeat.o(137338);
      return;
      label71:
      ad.i("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
    }
  }
  
  public final void cTO()
  {
    AppMethodBeat.i(137341);
    this.tWc = true;
    ad.i("MicroMsg.Music.MusicPlayer", "passivePause");
    try
    {
      if ((this.tXT != null) && (this.tXT.isPlaying()))
      {
        this.tXT.pause();
        F(this.tVP);
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
  
  public final boolean cTP()
  {
    return false;
  }
  
  public final com.tencent.mm.az.c cTQ()
  {
    AppMethodBeat.i(137349);
    int k = getDuration();
    int m = cUi();
    int i;
    int j;
    if (azF())
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
      if (this.tXV != null) {
        this.tXV.t(k, m, i, j);
      }
      for (;;)
      {
        this.tXV.dqn = false;
        this.tXV.hnk = cVB();
        com.tencent.mm.az.c localc = this.tXV;
        AppMethodBeat.o(137349);
        return localc;
        if ((this.rdQ) && ((this.tXU) || (this.tUp))) {}
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
        this.tXV = new com.tencent.mm.az.c(k, m, i, j);
      }
      label165:
      j = 0;
    }
  }
  
  protected final void cUL()
  {
    AppMethodBeat.i(137337);
    this.tXL = ((com.tencent.mm.plugin.music.e.d)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.d.class));
    this.tXM = k.cVi().tWk;
    AppMethodBeat.o(137337);
  }
  
  public final void cUc()
  {
    AppMethodBeat.i(137340);
    ad.i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.cVk().bfc();
    AppMethodBeat.o(137340);
  }
  
  public final int cUi()
  {
    AppMethodBeat.i(137345);
    if (this.tXT != null)
    {
      int i = this.tXT.cVD();
      AppMethodBeat.o(137345);
      return i;
    }
    AppMethodBeat.o(137345);
    return -1;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137346);
    if (this.tXT != null)
    {
      int i = this.tXT.getDuration();
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
    this.tXy = new com.tencent.mm.plugin.music.c.b(paramf, e.air(paramf.hnp));
    this.tXy.tVN = this.tXW;
    if (this.tXL != null)
    {
      this.tXL.v(paramf);
      ad.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
      this.tXL.cUW();
      this.tXL.a(this.tXy);
    }
    this.tVP = paramf;
    b(paramf, false);
    ad.i("MicroMsg.Music.MusicPlayer", "startPlay src:%s,  playUrl:%s", new Object[] { paramf.hnv, paramf.playUrl });
    this.tXy.start();
    cVA();
    AppMethodBeat.o(137336);
  }
  
  public final boolean ox(int paramInt)
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
      if ((this.tXT != null) && (i >= 0))
      {
        this.tXT.seek(i);
        H(this.tVP);
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
    this.tWc = false;
    ad.i("MicroMsg.Music.MusicPlayer", "pause");
    try
    {
      if ((this.tXT != null) && (this.tXT.isPlaying()))
      {
        this.tXT.pause();
        this.tXU = true;
        F(this.tVP);
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
      if ((this.tXT != null) && (!this.tXT.isPlaying()))
      {
        ad.i("MicroMsg.Music.MusicPlayer", "resume");
        if (k.cVk().requestFocus())
        {
          this.tXT.play();
          E(this.tVP);
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
    if ((this.tXT != null) && ((this.tXT instanceof c))) {
      aiS(this.tXT.cVE());
    }
    try
    {
      if (this.tXy != null)
      {
        this.tXy.isStop = true;
        this.tXy = null;
      }
      if (this.tXT != null)
      {
        this.tXT.stop();
        this.tXT = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "stopPlay", new Object[0]);
      }
    }
    k.cVk().bfc();
    this.rdQ = false;
    this.tWc = false;
    AppMethodBeat.o(137344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d
 * JD-Core Version:    0.7.0.1
 */