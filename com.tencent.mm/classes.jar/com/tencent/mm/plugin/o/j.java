package com.tencent.mm.plugin.o;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class j
  implements c
{
  Looper tAf;
  ap tAg;
  HandlerThread tAh;
  HandlerThread tAi;
  com.tencent.e.j.a tAj;
  public k tAk;
  public d tAl;
  private ap.a tAm;
  
  public j(Looper paramLooper)
  {
    this(paramLooper, (byte)0);
  }
  
  private j(Looper paramLooper, byte paramByte)
  {
    AppMethodBeat.i(133915);
    this.tAm = new ap.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133914);
        int i = paramAnonymousMessage.what;
        switch (i)
        {
        default: 
          ad.w("MicroMsg.VideoPlayer", "%s it has no idea for msg %d ", new Object[] { j.this.info(), Integer.valueOf(i) });
        }
        for (;;)
        {
          AppMethodBeat.o(133914);
          return false;
          ad.i("MicroMsg.VideoPlayer", "%s call prepared ", new Object[] { j.this.info() });
          if (j.this.tAl != null)
          {
            j.this.tAl.rq();
            continue;
            ad.i("MicroMsg.VideoPlayer", "%s call completion ", new Object[] { j.this.info() });
            if (j.this.tAl != null)
            {
              j.this.tAl.onCompletion();
              continue;
              ad.i("MicroMsg.VideoPlayer", "%s call seek completion ", new Object[] { j.this.info() });
              if (j.this.tAl != null)
              {
                j.this.tAl.bYy();
                continue;
                ad.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", new Object[] { j.this.info(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2), Integer.valueOf(((Integer)paramAnonymousMessage.obj).intValue()) });
                if (j.this.tAl != null)
                {
                  j.this.tAl.W(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2, ((Integer)paramAnonymousMessage.obj).intValue());
                  continue;
                  ad.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", new Object[] { j.this.info(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
                  if (j.this.tAl != null)
                  {
                    j.this.tAl.onError(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
                    continue;
                    try
                    {
                      paramAnonymousMessage = j.this;
                      ad.i("MicroMsg.VideoPlayer", "%s clear now.", new Object[] { paramAnonymousMessage.info() });
                      paramAnonymousMessage.tAj.quit();
                      paramAnonymousMessage.tAh.quit();
                      if (paramAnonymousMessage.tAi != null) {
                        paramAnonymousMessage.tAi.quit();
                      }
                      paramAnonymousMessage.tAg.removeMessages(1);
                      paramAnonymousMessage.tAg.removeMessages(2);
                      paramAnonymousMessage.tAg.removeMessages(3);
                      paramAnonymousMessage.tAg.removeMessages(4);
                      paramAnonymousMessage.tAg.removeMessages(5);
                      paramAnonymousMessage.tAh = null;
                      paramAnonymousMessage.tAg = null;
                      paramAnonymousMessage.tAf = null;
                      paramAnonymousMessage.tAl = null;
                      paramAnonymousMessage.tAk = null;
                    }
                    catch (Exception paramAnonymousMessage) {}
                  }
                }
              }
            }
          }
        }
      }
    };
    this.tAj = com.tencent.e.j.a.aOc("VideoPlayer:inner");
    this.tAh = com.tencent.e.c.d.gv("VideoPlayer:video", 10);
    this.tAh.start();
    this.tAi = com.tencent.e.c.d.gv("VideoPlayer:audio", 10);
    ad.i("MicroMsg.VideoPlayer", "VideoPlayer init 4");
    this.tAi.start();
    this.tAf = paramLooper;
    this.tAg = new ap(this.tAf, this.tAm);
    this.tAk = new k(this.tAg, this.tAj, this.tAh.getLooper(), this.tAi.getLooper());
    AppMethodBeat.o(133915);
  }
  
  public final void GI(int paramInt)
  {
    AppMethodBeat.i(133925);
    this.tAk.GI(paramInt);
    AppMethodBeat.o(133925);
  }
  
  public final void a(d paramd)
  {
    this.tAl = paramd;
  }
  
  public final int cPu()
  {
    AppMethodBeat.i(133929);
    int i;
    int j;
    if (this.tAk != null)
    {
      k localk = this.tAk;
      if (localk.tzT == null) {
        break label170;
      }
      i = (int)(localk.tzT.tzL / 1000L);
      j = (int)localk.tzT.tzK;
      if (j == -1)
      {
        j = i;
        if (i < localk.tzT.tzM / 1000L) {
          j = (int)(localk.tzT.tzM / 1000L);
        }
        if (j != localk.LmI) {
          ad.i("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", new Object[] { localk.info(), Integer.valueOf(j), Long.valueOf(localk.tzT.tzL), Long.valueOf(localk.tzT.tzM) });
        }
        localk.LmI = j;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(133929);
      return j;
      i = Math.max(i, j);
      break;
      AppMethodBeat.o(133929);
      return 0;
      label170:
      j = 0;
    }
  }
  
  public final boolean cuQ()
  {
    AppMethodBeat.i(133921);
    this.tAk.cuQ();
    AppMethodBeat.o(133921);
    return true;
  }
  
  public final long cuR()
  {
    return this.tAk.bjp;
  }
  
  public final float getPlayRate()
  {
    float f2 = 1.0F;
    float f1 = f2;
    if (this.tAk != null)
    {
      k localk = this.tAk;
      f1 = f2;
      if (localk.tAt != null) {
        f1 = localk.tAt.knF;
      }
    }
    return f1;
  }
  
  public final String info()
  {
    AppMethodBeat.i(133931);
    if (this.tAk != null)
    {
      String str = this.tAk.info();
      AppMethodBeat.o(133931);
      return str;
    }
    AppMethodBeat.o(133931);
    return "has no player!";
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(133930);
    if (this.tAk != null)
    {
      boolean bool = e.GA(this.tAk.state);
      AppMethodBeat.o(133930);
      return bool;
    }
    AppMethodBeat.o(133930);
    return false;
  }
  
  public final void j(Surface paramSurface)
  {
    AppMethodBeat.i(133920);
    if (paramSurface != null)
    {
      Object localObject = this.tAk;
      ad.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", new Object[] { ((k)localObject).info(), Integer.valueOf(paramSurface.hashCode()) });
      localObject = ((k)localObject).tAt;
      ad.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", new Object[] { ((l)localObject).info() });
      ((l)localObject).surface = paramSurface;
      if (com.tencent.mm.compatible.util.d.lf(23))
      {
        ((l)localObject).cPx();
        AppMethodBeat.o(133920);
        return;
      }
      ((l)localObject).cPy();
    }
    AppMethodBeat.o(133920);
  }
  
  public final void nd(boolean paramBoolean)
  {
    this.tAk.tAt.tAF = paramBoolean;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(133923);
    if (ad.getLogLevel() > 0) {
      ad.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", new Object[] { info(), Integer.valueOf(this.tAk.state), bt.eGN() });
    }
    if ((e.GE(this.tAk.state)) || (e.GC(this.tAk.state)))
    {
      ad.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", new Object[] { info() });
      AppMethodBeat.o(133923);
      return;
    }
    this.tAk.pause();
    AppMethodBeat.o(133923);
  }
  
  public final void release()
  {
    AppMethodBeat.i(133928);
    try
    {
      this.tAk.release();
      AppMethodBeat.o(133928);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(133928);
    }
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(133924);
    this.tAk.seek(paramInt);
    AppMethodBeat.o(133924);
  }
  
  public final void setIOnlineCache(b paramb)
  {
    if ((paramb != null) && (this.tAk != null)) {
      this.tAk.tAt.tzW = paramb;
    }
  }
  
  public final void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(133918);
    if (this.tAk != null)
    {
      k localk = this.tAk;
      if (localk.tzT != null)
      {
        ad.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
        localk.tzT.oNQ = paramBoolean;
      }
    }
    AppMethodBeat.o(133918);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(133926);
    try
    {
      if (this.tAk != null)
      {
        k localk = this.tAk;
        if (localk.tAv != null)
        {
          ad.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
          localk.tAv.setMute(paramBoolean);
        }
      }
      AppMethodBeat.o(133926);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(133926);
    }
  }
  
  public final void setNeedResetExtractor(boolean paramBoolean)
  {
    AppMethodBeat.i(133917);
    if (this.tAk != null)
    {
      k localk = this.tAk;
      ad.i("MicroMsg.VideoPlayerImpl", "%s setNeedResetExtractor [%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
      if (localk.tzT != null) {
        localk.tzT.oNP = paramBoolean;
      }
    }
    AppMethodBeat.o(133917);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(133916);
    ad.i("MicroMsg.VideoPlayer", "%s video player set path %s", new Object[] { info(), paramString });
    this.tAk.setPath(paramString);
    AppMethodBeat.o(133916);
  }
  
  public final void setPlayRate(float paramFloat)
  {
    if (this.tAk != null)
    {
      Object localObject = this.tAk;
      if (((k)localObject).tAt != null)
      {
        localObject = ((k)localObject).tAt;
        if (paramFloat > 0.0F) {
          ((l)localObject).knF = paramFloat;
        }
      }
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(133919);
    if (paramSurface != null) {
      this.tAk.setSurface(paramSurface);
    }
    AppMethodBeat.o(133919);
  }
  
  public final void start()
  {
    AppMethodBeat.i(133922);
    if (ad.getLogLevel() > 0) {
      ad.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", new Object[] { info(), Integer.valueOf(this.tAk.state), bt.eGN() });
    }
    if ((e.GE(this.tAk.state)) || (e.GC(this.tAk.state)))
    {
      ad.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", new Object[] { info() });
      AppMethodBeat.o(133922);
      return;
    }
    this.tAk.start();
    AppMethodBeat.o(133922);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(133927);
    this.tAk.stop();
    AppMethodBeat.o(133927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.o.j
 * JD-Core Version:    0.7.0.1
 */