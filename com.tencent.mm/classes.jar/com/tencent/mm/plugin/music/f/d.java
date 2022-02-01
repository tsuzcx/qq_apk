package com.tencent.mm.plugin.music.f;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.c.b.b;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;

public final class d
  extends a
{
  boolean vdc;
  public boolean veM;
  com.tencent.mm.ay.f vey;
  com.tencent.mm.plugin.music.f.a.b vgG;
  boolean vgH;
  private com.tencent.mm.ay.c vgI;
  b.b vgJ;
  com.tencent.mm.plugin.music.c.b vgk;
  
  public d()
  {
    AppMethodBeat.i(137335);
    this.vgJ = new b.b()
    {
      public final void JG(final int paramAnonymousInt)
      {
        AppMethodBeat.i(137334);
        if (paramAnonymousInt == 1)
        {
          if ((d.this.vgk != null) && (!d.this.vdc) && (d.this.vgG != null))
          {
            Object localObject = com.tencent.mm.plugin.music.h.b.bs(d.this.vgk.veq.hNS, d.this.vgk.qKm);
            d.this.vgG.anM((String)localObject);
            localObject = d.this;
            if (k.diQ().requestFocus())
            {
              ac.i("MicroMsg.Music.MusicPlayer", "startPlay");
              try
              {
                if (((d)localObject).vgG != null) {
                  ((d)localObject).vgG.play();
                }
                ((d)localObject).vdc = true;
                ((d)localObject).vgH = false;
                AppMethodBeat.o(137334);
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ac.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "startPlay", new Object[0]);
                }
              }
            }
            ac.e("MicroMsg.Music.MusicPlayer", "request focus error");
            AppMethodBeat.o(137334);
          }
        }
        else
        {
          if ((paramAnonymousInt == -2) || (paramAnonymousInt == 5) || (paramAnonymousInt == 19))
          {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(137332);
                Toast.makeText(ai.getContext(), ai.getContext().getString(2131761480), 0).show();
                d.a(d.this, d.this.vey, paramAnonymousInt);
                AppMethodBeat.o(137332);
              }
            });
            AppMethodBeat.o(137334);
            return;
          }
          if ((paramAnonymousInt == -1) || (paramAnonymousInt == 6) || (paramAnonymousInt == 4))
          {
            ap.f(new d.2.2(this));
            d.a(d.this, d.this.vey, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(137334);
      }
    };
    this.veM = false;
    AppMethodBeat.o(137335);
  }
  
  private void anN(String paramString)
  {
    AppMethodBeat.i(137350);
    if (this.vgx != null) {
      this.vgx.a(this.vey, paramString);
    }
    AppMethodBeat.o(137350);
  }
  
  private int getDownloadPercent()
  {
    AppMethodBeat.i(137347);
    if (this.vgk != null)
    {
      com.tencent.mm.plugin.music.c.b localb = this.vgk;
      int i;
      if (localb.qKm)
      {
        ac.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.ves.veo), Long.valueOf(localb.ves.vem) });
        if (localb.ves.veo != 0L) {
          i = (int)(localb.ves.vem * 100L / localb.ves.veo);
        }
      }
      while (i > 0)
      {
        AppMethodBeat.o(137347);
        return i;
        i = 0;
        continue;
        ac.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.ves.vel), Long.valueOf(localb.ves.vek) });
        if (localb.ves.vel != 0L) {
          i = (int)(localb.ves.vek * 100L / localb.ves.vel);
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
  
  public final void EM()
  {
    AppMethodBeat.i(137341);
    this.veM = true;
    ac.i("MicroMsg.Music.MusicPlayer", "passivePause");
    try
    {
      if ((this.vgG != null) && (this.vgG.isPlaying()))
      {
        this.vgG.pause();
        G(this.vey);
      }
      AppMethodBeat.o(137341);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "passivePause", new Object[0]);
      AppMethodBeat.o(137341);
    }
  }
  
  public final boolean aGv()
  {
    AppMethodBeat.i(137343);
    if (this.vgG != null) {
      try
      {
        boolean bool = this.vgG.isPlaying();
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
  
  public final boolean aGw()
  {
    return (this.vdc) && (this.veM);
  }
  
  public final boolean aGx()
  {
    return this.vdc;
  }
  
  final void b(com.tencent.mm.ay.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(137338);
    if (this.vgG == null)
    {
      if ((paramBoolean) || (!com.tencent.mm.compatible.util.d.lb(15))) {
        break label71;
      }
      ac.i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
    }
    for (this.vgG = new c();; this.vgG = new b())
    {
      this.vgG.N(paramf);
      this.vgG.a(new com.tencent.mm.plugin.music.f.a.f()
      {
        long vgK;
        
        public final void M(com.tencent.mm.ay.f paramAnonymousf)
        {
          AppMethodBeat.i(137329);
          com.tencent.mm.ay.f localf = k.diO().diz();
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
          if ((localf.f(paramAnonymousf)) && (d.this.vgG != null) && (d.this.vgG.isPlaying()))
          {
            j = d.this.vgG.djj();
            k = d.this.vgG.getDuration();
            if ((j > 0) && (k > 0))
            {
              f2 = j / k;
              if (d.this.vgk != null)
              {
                paramAnonymousf = d.this.vgk;
                paramAnonymousf.vet = f2;
                boolean bool = ax.isNetworkConnected(ai.getContext());
                if ((paramAnonymousf.isStop) && (bool))
                {
                  if (!paramAnonymousf.qKm) {
                    break label348;
                  }
                  if (paramAnonymousf.ves.veo != 0L)
                  {
                    f1 = (float)paramAnonymousf.ves.vem / (float)paramAnonymousf.ves.veo;
                    if ((f1 < 1.0F) && (f1 - f2 <= 0.15F) && (bool))
                    {
                      ac.v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Boolean.valueOf(bool) });
                      paramAnonymousf.start();
                    }
                  }
                }
                if ((d.this.vgk != null) && (d.this.vgk.isStop))
                {
                  paramAnonymousf = d.this.vgk;
                  if (!paramAnonymousf.qKm) {
                    break label381;
                  }
                  if (paramAnonymousf.ves.veo == 0L) {
                    break label429;
                  }
                  f1 = (float)paramAnonymousf.ves.vem / (float)paramAnonymousf.ves.veo;
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
              ac.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
              d.this.stopPlay();
            }
            d.this.eV(j, k);
            AppMethodBeat.o(137329);
            return;
            label348:
            if (paramAnonymousf.ves.vel == 0L) {
              break label235;
            }
            f1 = (float)paramAnonymousf.ves.vek / (float)paramAnonymousf.ves.vel;
            break;
            label381:
            if (paramAnonymousf.ves.vel != 0L)
            {
              f1 = (float)paramAnonymousf.ves.vek / (float)paramAnonymousf.ves.vel;
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
          ac.i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
          com.tencent.mm.ay.f localf = k.diO().diz();
          if (localf == null)
          {
            AppMethodBeat.o(137330);
            return;
          }
          if (localf.f(paramAnonymousf)) {
            d.this.stopPlay();
          }
          d.this.H(d.this.vey);
          if (paramAnonymousBoolean) {
            d.this.K(d.this.vey);
          }
          AppMethodBeat.o(137330);
        }
        
        public final void d(com.tencent.mm.ay.f paramAnonymousf, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(137331);
          com.tencent.mm.ay.f localf = k.diO().diz();
          if (localf == null)
          {
            AppMethodBeat.o(137331);
            return;
          }
          ac.i("MicroMsg.Music.MusicPlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean) {
            d.a(d.this, paramAnonymousf, 20);
          }
          while (localf.f(paramAnonymousf))
          {
            ac.i("MicroMsg.Music.MusicPlayer", "stop");
            d.this.stopPlay();
            if (paramAnonymousBoolean)
            {
              ac.i("MicroMsg.Music.MusicPlayer", "retry system media player again");
              d.this.b(localf, true);
              d.this.vgk = new com.tencent.mm.plugin.music.c.b(paramAnonymousf, e.anm(paramAnonymousf.hNS));
              d.this.vgk.vew = d.this.vgJ;
              d.this.vgk.start();
              if (d.this.vgx == null) {
                break label245;
              }
              d.this.vgx.a(d.this.vgk);
              AppMethodBeat.o(137331);
              return;
              d.a(d.this, paramAnonymousf, 21);
            }
            else
            {
              ap.f(new d.1.1(this));
              d.this.H(d.this.vey);
              AppMethodBeat.o(137331);
              return;
            }
          }
          ac.i("MicroMsg.Music.MusicPlayer", "send stop event");
          d.this.H(d.this.vey);
          label245:
          AppMethodBeat.o(137331);
        }
        
        public final void n(com.tencent.mm.ay.f paramAnonymousf)
        {
          AppMethodBeat.i(137328);
          ac.i("MicroMsg.Music.MusicPlayer", "setEvents, onStart");
          d.this.E(paramAnonymousf);
          AppMethodBeat.o(137328);
        }
      });
      AppMethodBeat.o(137338);
      return;
      label71:
      ac.i("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
    }
  }
  
  public final void dhJ()
  {
    AppMethodBeat.i(137340);
    ac.i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.diQ().bjF();
    AppMethodBeat.o(137340);
  }
  
  public final int dhO()
  {
    AppMethodBeat.i(137345);
    if (this.vgG != null)
    {
      int i = this.vgG.djj();
      AppMethodBeat.o(137345);
      return i;
    }
    AppMethodBeat.o(137345);
    return -1;
  }
  
  public final boolean dhw()
  {
    return false;
  }
  
  public final com.tencent.mm.ay.c dhx()
  {
    AppMethodBeat.i(137349);
    int k = getDuration();
    int m = dhO();
    int i;
    int j;
    if (aGv())
    {
      i = 1;
      ac.i("MicroMsg.Music.MusicPlayer", "get music status = %d", new Object[] { Integer.valueOf(i) });
      j = getDownloadPercent();
      if (k <= 0) {
        break label165;
      }
    }
    for (;;)
    {
      if (this.vgI != null) {
        this.vgI.t(k, m, i, j);
      }
      for (;;)
      {
        this.vgI.dnY = false;
        this.vgI.hNN = djh();
        com.tencent.mm.ay.c localc = this.vgI;
        AppMethodBeat.o(137349);
        return localc;
        if ((this.vdc) && ((this.vgH) || (this.vcX))) {}
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
        this.vgI = new com.tencent.mm.ay.c(k, m, i, j);
      }
      label165:
      j = 0;
    }
  }
  
  protected final void dir()
  {
    AppMethodBeat.i(137337);
    this.vgx = ((com.tencent.mm.plugin.music.e.d)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.d.class));
    this.vgy = k.diO().veU;
    AppMethodBeat.o(137337);
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137346);
    if (this.vgG != null)
    {
      int i = this.vgG.getDuration();
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
    ac.i("MicroMsg.Music.MusicPlayer", "init and start download");
    stopPlay();
    if (paramf == null)
    {
      ac.i("MicroMsg.Music.MusicPlayer", "music is null");
      AppMethodBeat.o(137336);
      return;
    }
    this.vgk = new com.tencent.mm.plugin.music.c.b(paramf, e.anm(paramf.hNS));
    this.vgk.vew = this.vgJ;
    if (this.vgx != null)
    {
      this.vgx.v(paramf);
      ac.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
      this.vgx.diC();
      this.vgx.a(this.vgk);
    }
    this.vey = paramf;
    b(paramf, false);
    ac.i("MicroMsg.Music.MusicPlayer", "startPlay src:%s,  playUrl:%s", new Object[] { paramf.hNY, paramf.playUrl });
    this.vgk.start();
    djg();
    AppMethodBeat.o(137336);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137339);
    this.veM = false;
    ac.i("MicroMsg.Music.MusicPlayer", "pause");
    try
    {
      if ((this.vgG != null) && (this.vgG.isPlaying()))
      {
        this.vgG.pause();
        this.vgH = true;
        G(this.vey);
      }
      AppMethodBeat.o(137339);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "pause", new Object[0]);
      AppMethodBeat.o(137339);
    }
  }
  
  public final boolean pl(int paramInt)
  {
    AppMethodBeat.i(137348);
    ac.i("MicroMsg.Music.MusicPlayer", "seekToMusic pos:%d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = getDuration();
      int j = getDownloadPercent();
      if ((i < 0) || (paramInt > i))
      {
        ac.e("MicroMsg.Music.MusicPlayer", "duration or position is illegal, stop");
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
          ac.i("MicroMsg.Music.MusicPlayer", "on completed seekto, position is %d =", new Object[] { Integer.valueOf(i) });
        }
      }
      if ((this.vgG != null) && (i >= 0))
      {
        this.vgG.seek(i);
        I(this.vey);
        AppMethodBeat.o(137348);
        return true;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "seekTo", new Object[0]);
      AppMethodBeat.o(137348);
    }
    return false;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(137342);
    try
    {
      if ((this.vgG != null) && (!this.vgG.isPlaying()))
      {
        ac.i("MicroMsg.Music.MusicPlayer", "resume");
        if (k.diQ().requestFocus())
        {
          this.vgG.play();
          F(this.vey);
          AppMethodBeat.o(137342);
          return;
        }
        ac.e("MicroMsg.Music.MusicPlayer", "request focus error");
        AppMethodBeat.o(137342);
        return;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "resume", new Object[0]);
      AppMethodBeat.o(137342);
      return;
    }
    ac.i("MicroMsg.Music.MusicPlayer", "music is playing");
    AppMethodBeat.o(137342);
  }
  
  public final void stopPlay()
  {
    AppMethodBeat.i(137344);
    ac.i("MicroMsg.Music.MusicPlayer", "stopPlay");
    if ((this.vgG != null) && ((this.vgG instanceof c))) {
      anN(this.vgG.djk());
    }
    try
    {
      if (this.vgk != null)
      {
        this.vgk.isStop = true;
        this.vgk = null;
      }
      if (this.vgG != null)
      {
        this.vgG.stop();
        this.vgG = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "stopPlay", new Object[0]);
      }
    }
    k.diQ().bjF();
    this.vdc = false;
    this.veM = false;
    AppMethodBeat.o(137344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d
 * JD-Core Version:    0.7.0.1
 */