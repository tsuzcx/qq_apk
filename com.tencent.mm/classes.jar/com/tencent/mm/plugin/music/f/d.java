package com.tencent.mm.plugin.music.f;

import android.content.Context;
import android.widget.Toast;
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
  boolean AhL;
  com.tencent.mm.ay.f Ajg;
  public boolean Aju;
  com.tencent.mm.plugin.music.f.a.b AlR;
  boolean AlS;
  private com.tencent.mm.ay.c AlT;
  b.b AlU;
  com.tencent.mm.plugin.music.c.b Alw;
  
  public d()
  {
    AppMethodBeat.i(137335);
    this.AlU = new b.b()
    {
      public final void SK(final int paramAnonymousInt)
      {
        AppMethodBeat.i(137334);
        if (paramAnonymousInt == 1)
        {
          if ((d.this.Alw != null) && (!d.this.AhL) && (d.this.AlR != null))
          {
            Object localObject = com.tencent.mm.plugin.music.h.b.bT(d.this.Alw.AiZ.jeV, d.this.Alw.tcf);
            d.this.AlR.aHY((String)localObject);
            localObject = d.this;
            if (k.eul().requestFocus())
            {
              Log.i("MicroMsg.Music.MusicPlayer", "startPlay");
              try
              {
                if (((d)localObject).AlR != null) {
                  ((d)localObject).AlR.play();
                }
                ((d)localObject).AhL = true;
                ((d)localObject).AlS = false;
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
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(137332);
                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131763415), 0).show();
                d.a(d.this, d.this.Ajg, paramAnonymousInt);
                AppMethodBeat.o(137332);
              }
            });
            AppMethodBeat.o(137334);
            return;
          }
          if ((paramAnonymousInt == -1) || (paramAnonymousInt == 6) || (paramAnonymousInt == 4))
          {
            MMHandlerThread.postToMainThread(new d.2.2(this));
            d.a(d.this, d.this.Ajg, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(137334);
      }
    };
    this.Aju = false;
    AppMethodBeat.o(137335);
  }
  
  private void aHZ(String paramString)
  {
    AppMethodBeat.i(137350);
    if (this.AlJ != null) {
      this.AlJ.a(this.Ajg, paramString);
    }
    AppMethodBeat.o(137350);
  }
  
  private int getDownloadPercent()
  {
    AppMethodBeat.i(137347);
    if (this.Alw != null)
    {
      com.tencent.mm.plugin.music.c.b localb = this.Alw;
      int i;
      if (localb.tcf)
      {
        Log.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.Aja.AiX), Long.valueOf(localb.Aja.AiV) });
        if (localb.Aja.AiX != 0L) {
          i = (int)(localb.Aja.AiV * 100L / localb.Aja.AiX);
        }
      }
      while (i > 0)
      {
        AppMethodBeat.o(137347);
        return i;
        i = 0;
        continue;
        Log.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", new Object[] { Long.valueOf(localb.Aja.AiU), Long.valueOf(localb.Aja.AiT) });
        if (localb.Aja.AiU != 0L) {
          i = (int)(localb.Aja.AiT * 100L / localb.Aja.AiU);
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
  
  final void b(com.tencent.mm.ay.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(137338);
    if (this.AlR == null)
    {
      if ((paramBoolean) || (!com.tencent.mm.compatible.util.d.oF(15))) {
        break label71;
      }
      Log.i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
    }
    for (this.AlR = new c();; this.AlR = new b())
    {
      this.AlR.R(paramf);
      this.AlR.a(new com.tencent.mm.plugin.music.f.a.f()
      {
        long AlV;
        
        public final void Q(com.tencent.mm.ay.f paramAnonymousf)
        {
          AppMethodBeat.i(137329);
          com.tencent.mm.ay.f localf = k.euj().etU();
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
          if ((localf.f(paramAnonymousf)) && (d.this.AlR != null) && (d.this.AlR.isPlaying()))
          {
            j = d.this.AlR.euS();
            k = d.this.AlR.getDuration();
            if ((j > 0) && (k > 0))
            {
              f2 = j / k;
              if (d.this.Alw != null)
              {
                paramAnonymousf = d.this.Alw;
                paramAnonymousf.Ajb = f2;
                boolean bool = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
                if ((paramAnonymousf.isStop) && (bool))
                {
                  if (!paramAnonymousf.tcf) {
                    break label348;
                  }
                  if (paramAnonymousf.Aja.AiX != 0L)
                  {
                    f1 = (float)paramAnonymousf.Aja.AiV / (float)paramAnonymousf.Aja.AiX;
                    if ((f1 < 1.0F) && (f1 - f2 <= 0.15F) && (bool))
                    {
                      Log.v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Boolean.valueOf(bool) });
                      paramAnonymousf.start();
                    }
                  }
                }
                if ((d.this.Alw != null) && (d.this.Alw.isStop))
                {
                  paramAnonymousf = d.this.Alw;
                  if (!paramAnonymousf.tcf) {
                    break label381;
                  }
                  if (paramAnonymousf.Aja.AiX == 0L) {
                    break label429;
                  }
                  f1 = (float)paramAnonymousf.Aja.AiV / (float)paramAnonymousf.Aja.AiX;
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
            d.this.fn(j, k);
            AppMethodBeat.o(137329);
            return;
            label348:
            if (paramAnonymousf.Aja.AiU == 0L) {
              break label235;
            }
            f1 = (float)paramAnonymousf.Aja.AiT / (float)paramAnonymousf.Aja.AiU;
            break;
            label381:
            if (paramAnonymousf.Aja.AiU != 0L)
            {
              f1 = (float)paramAnonymousf.Aja.AiT / (float)paramAnonymousf.Aja.AiU;
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
          Log.i("MicroMsg.Music.MusicPlayer", "setEvents, onStop");
          com.tencent.mm.ay.f localf = k.euj().etU();
          if (localf == null)
          {
            AppMethodBeat.o(137330);
            return;
          }
          if (localf.f(paramAnonymousf)) {
            d.this.stopPlay();
          }
          d.this.L(d.this.Ajg);
          if (paramAnonymousBoolean) {
            d.this.O(d.this.Ajg);
          }
          AppMethodBeat.o(137330);
        }
        
        public final void d(com.tencent.mm.ay.f paramAnonymousf, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(137331);
          com.tencent.mm.ay.f localf = k.euj().etU();
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
              d.this.Alw = new com.tencent.mm.plugin.music.c.b(paramAnonymousf, e.aHw(paramAnonymousf.jeV));
              d.this.Alw.Aje = d.this.AlU;
              d.this.Alw.start();
              if (d.this.AlJ == null) {
                break label245;
              }
              d.this.AlJ.a(d.this.Alw);
              AppMethodBeat.o(137331);
              return;
              d.a(d.this, paramAnonymousf, 21);
            }
            else
            {
              MMHandlerThread.postToMainThread(new d.1.1(this));
              d.this.L(d.this.Ajg);
              AppMethodBeat.o(137331);
              return;
            }
          }
          Log.i("MicroMsg.Music.MusicPlayer", "send stop event");
          d.this.L(d.this.Ajg);
          label245:
          AppMethodBeat.o(137331);
        }
        
        public final void n(com.tencent.mm.ay.f paramAnonymousf)
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
  
  public final boolean bec()
  {
    AppMethodBeat.i(137343);
    if (this.AlR != null) {
      try
      {
        boolean bool = this.AlR.isPlaying();
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
  
  public final boolean bed()
  {
    return (this.AhL) && (this.Aju);
  }
  
  public final boolean bee()
  {
    return this.AhL;
  }
  
  public final void esU()
  {
    AppMethodBeat.i(137341);
    this.Aju = true;
    Log.i("MicroMsg.Music.MusicPlayer", "passivePause");
    try
    {
      if ((this.AlR != null) && (this.AlR.isPlaying()))
      {
        this.AlR.pause();
        K(this.Ajg);
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
  
  public final boolean esV()
  {
    return false;
  }
  
  public final com.tencent.mm.ay.c esW()
  {
    AppMethodBeat.i(137349);
    int k = getDuration();
    int m = etn();
    int i;
    int j;
    if (bec())
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
      if (this.AlT != null) {
        this.AlT.t(k, m, i, j);
      }
      for (;;)
      {
        this.AlT.dSG = false;
        this.AlT.jeQ = euQ();
        com.tencent.mm.ay.c localc = this.AlT;
        AppMethodBeat.o(137349);
        return localc;
        if ((this.AhL) && ((this.AlS) || (this.AhH))) {}
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
        this.AlT = new com.tencent.mm.ay.c(k, m, i, j);
      }
      label165:
      j = 0;
    }
  }
  
  protected final void etM()
  {
    AppMethodBeat.i(137337);
    this.AlJ = ((com.tencent.mm.plugin.music.e.d)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.d.class));
    this.AlK = k.euj().AjC;
    AppMethodBeat.o(137337);
  }
  
  public final void eth()
  {
    AppMethodBeat.i(137340);
    Log.i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
    pause();
    k.eul().bLZ();
    AppMethodBeat.o(137340);
  }
  
  public final int etn()
  {
    AppMethodBeat.i(137345);
    if (this.AlR != null)
    {
      int i = this.AlR.euS();
      AppMethodBeat.o(137345);
      return i;
    }
    AppMethodBeat.o(137345);
    return -1;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(137346);
    if (this.AlR != null)
    {
      int i = this.AlR.getDuration();
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
    Log.i("MicroMsg.Music.MusicPlayer", "init and start download");
    stopPlay();
    if (paramf == null)
    {
      Log.i("MicroMsg.Music.MusicPlayer", "music is null");
      AppMethodBeat.o(137336);
      return;
    }
    this.Alw = new com.tencent.mm.plugin.music.c.b(paramf, e.aHw(paramf.jeV));
    this.Alw.Aje = this.AlU;
    if (this.AlJ != null)
    {
      this.AlJ.v(paramf);
      Log.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
      this.AlJ.etX();
      this.AlJ.a(this.Alw);
    }
    this.Ajg = paramf;
    b(paramf, false);
    Log.i("MicroMsg.Music.MusicPlayer", "startPlay src:%s,  playUrl:%s", new Object[] { paramf.jfb, paramf.playUrl });
    this.Alw.start();
    euP();
    AppMethodBeat.o(137336);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137339);
    this.Aju = false;
    Log.i("MicroMsg.Music.MusicPlayer", "pause");
    try
    {
      if ((this.AlR != null) && (this.AlR.isPlaying()))
      {
        this.AlR.pause();
        this.AlS = true;
        K(this.Ajg);
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
      if ((this.AlR != null) && (!this.AlR.isPlaying()))
      {
        Log.i("MicroMsg.Music.MusicPlayer", "resume");
        if (k.eul().requestFocus())
        {
          this.AlR.play();
          J(this.Ajg);
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
    if ((this.AlR != null) && ((this.AlR instanceof c))) {
      aHZ(this.AlR.ZV());
    }
    try
    {
      if (this.Alw != null)
      {
        this.Alw.isStop = true;
        this.Alw = null;
      }
      if (this.AlR != null)
      {
        this.AlR.stop();
        this.AlR = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Music.MusicPlayer", localException, "stopPlay", new Object[0]);
      }
    }
    k.eul().bLZ();
    this.AhL = false;
    this.Aju = false;
    AppMethodBeat.o(137344);
  }
  
  public final boolean tG(int paramInt)
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
      if ((this.AlR != null) && (i >= 0))
      {
        this.AlR.seek(i);
        M(this.Ajg);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.d
 * JD-Core Version:    0.7.0.1
 */