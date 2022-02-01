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
  Looper vLH;
  ap vLI;
  HandlerThread vLJ;
  HandlerThread vLK;
  com.tencent.e.j.a vLL;
  public k vLM;
  public d vLN;
  private ap.a vLO;
  
  public j(Looper paramLooper)
  {
    this(paramLooper, (byte)0);
  }
  
  private j(Looper paramLooper, byte paramByte)
  {
    this(paramLooper, 0);
    AppMethodBeat.i(133915);
    AppMethodBeat.o(133915);
  }
  
  public j(Looper paramLooper, int paramInt)
  {
    AppMethodBeat.i(197029);
    this.vLO = new ap.a()
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
          if (j.this.vLN != null)
          {
            j.this.vLN.ta();
            continue;
            ad.i("MicroMsg.VideoPlayer", "%s call completion ", new Object[] { j.this.info() });
            if (j.this.vLN != null)
            {
              j.this.vLN.onCompletion();
              continue;
              ad.i("MicroMsg.VideoPlayer", "%s call seek completion ", new Object[] { j.this.info() });
              if (j.this.vLN != null)
              {
                j.this.vLN.ckp();
                continue;
                ad.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", new Object[] { j.this.info(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2), Integer.valueOf(((Integer)paramAnonymousMessage.obj).intValue()) });
                if (j.this.vLN != null)
                {
                  j.this.vLN.Z(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2, ((Integer)paramAnonymousMessage.obj).intValue());
                  continue;
                  ad.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", new Object[] { j.this.info(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
                  if (j.this.vLN != null)
                  {
                    j.this.vLN.onError(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
                    continue;
                    try
                    {
                      paramAnonymousMessage = j.this;
                      ad.i("MicroMsg.VideoPlayer", "%s clear now.", new Object[] { paramAnonymousMessage.info() });
                      paramAnonymousMessage.vLL.quit();
                      paramAnonymousMessage.vLJ.quit();
                      if (paramAnonymousMessage.vLK != null) {
                        paramAnonymousMessage.vLK.quit();
                      }
                      paramAnonymousMessage.vLI.removeMessages(1);
                      paramAnonymousMessage.vLI.removeMessages(2);
                      paramAnonymousMessage.vLI.removeMessages(3);
                      paramAnonymousMessage.vLI.removeMessages(4);
                      paramAnonymousMessage.vLI.removeMessages(5);
                      paramAnonymousMessage.vLJ = null;
                      paramAnonymousMessage.vLI = null;
                      paramAnonymousMessage.vLH = null;
                      paramAnonymousMessage.vLN = null;
                      paramAnonymousMessage.vLM = null;
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
    this.vLL = com.tencent.e.j.a.aZF("VideoPlayer:inner");
    this.vLJ = com.tencent.e.c.d.gX("VideoPlayer:video", 10);
    this.vLJ.start();
    this.vLK = com.tencent.e.c.d.gX("VideoPlayer:audio", 10);
    ad.i("MicroMsg.VideoPlayer", "VideoPlayer init 4");
    this.vLK.start();
    this.vLH = paramLooper;
    this.vLI = new ap(this.vLH, this.vLO);
    this.vLM = new k(this.vLI, this.vLL, this.vLJ.getLooper(), this.vLK.getLooper(), paramInt);
    AppMethodBeat.o(197029);
  }
  
  public final void Kb(int paramInt)
  {
    AppMethodBeat.i(133925);
    this.vLM.Kb(paramInt);
    AppMethodBeat.o(133925);
  }
  
  public final void a(d paramd)
  {
    this.vLN = paramd;
  }
  
  public final boolean cQr()
  {
    AppMethodBeat.i(133921);
    this.vLM.cQr();
    AppMethodBeat.o(133921);
    return true;
  }
  
  public final int dmz()
  {
    AppMethodBeat.i(133929);
    int i;
    int j;
    if (this.vLM != null)
    {
      k localk = this.vLM;
      if (localk.vLw == null) {
        break label170;
      }
      i = (int)(localk.vLw.vLn / 1000L);
      j = (int)localk.vLw.vLm;
      if (j == -1)
      {
        j = i;
        if (i < localk.vLw.vLo / 1000L) {
          j = (int)(localk.vLw.vLo / 1000L);
        }
        if (j != localk.vLY) {
          ad.i("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", new Object[] { localk.info(), Integer.valueOf(j), Long.valueOf(localk.vLw.vLn), Long.valueOf(localk.vLw.vLo) });
        }
        localk.vLY = j;
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
  
  public final long getDurationMs()
  {
    return this.vLM.bup;
  }
  
  public final float getPlayRate()
  {
    float f2 = 1.0F;
    float f1 = f2;
    if (this.vLM != null)
    {
      k localk = this.vLM;
      f1 = f2;
      if (localk.vLV != null) {
        f1 = localk.vLV.llC;
      }
    }
    return f1;
  }
  
  public final void i(Surface paramSurface)
  {
    AppMethodBeat.i(133920);
    if (paramSurface != null)
    {
      Object localObject = this.vLM;
      ad.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", new Object[] { ((k)localObject).info(), Integer.valueOf(paramSurface.hashCode()) });
      localObject = ((k)localObject).vLV;
      ad.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", new Object[] { ((l)localObject).info() });
      ((l)localObject).surface = paramSurface;
      if (com.tencent.mm.compatible.util.d.ly(23))
      {
        ((l)localObject).dmC();
        AppMethodBeat.o(133920);
        return;
      }
      ((l)localObject).dmD();
    }
    AppMethodBeat.o(133920);
  }
  
  public final String info()
  {
    AppMethodBeat.i(133931);
    if (this.vLM != null)
    {
      String str = this.vLM.info();
      AppMethodBeat.o(133931);
      return str;
    }
    AppMethodBeat.o(133931);
    return "has no player!";
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(133930);
    if (this.vLM != null)
    {
      boolean bool = e.JT(this.vLM.state);
      AppMethodBeat.o(133930);
      return bool;
    }
    AppMethodBeat.o(133930);
    return false;
  }
  
  public final void oq(boolean paramBoolean)
  {
    this.vLM.vLV.vMi = paramBoolean;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(133923);
    if (ad.getLogLevel() > 0) {
      ad.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", new Object[] { info(), Integer.valueOf(this.vLM.state), bt.flS() });
    }
    if ((e.JX(this.vLM.state)) || (e.JV(this.vLM.state)))
    {
      ad.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", new Object[] { info() });
      AppMethodBeat.o(133923);
      return;
    }
    this.vLM.pause();
    AppMethodBeat.o(133923);
  }
  
  public final void release()
  {
    AppMethodBeat.i(133928);
    try
    {
      this.vLM.release();
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
    this.vLM.seek(paramInt);
    AppMethodBeat.o(133924);
  }
  
  public final void setIOnlineCache(b paramb)
  {
    if ((paramb != null) && (this.vLM != null)) {
      this.vLM.vLV.vLz = paramb;
    }
  }
  
  public final void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(133918);
    if (this.vLM != null)
    {
      k localk = this.vLM;
      if (localk.vLw != null)
      {
        ad.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
        localk.vLw.pUQ = paramBoolean;
      }
    }
    AppMethodBeat.o(133918);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(133926);
    try
    {
      if (this.vLM != null)
      {
        k localk = this.vLM;
        if (localk.vLX != null)
        {
          ad.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
          localk.vLX.setMute(paramBoolean);
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
    if (this.vLM != null)
    {
      k localk = this.vLM;
      ad.i("MicroMsg.VideoPlayerImpl", "%s setNeedResetExtractor [%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
      if (localk.vLw != null) {
        localk.vLw.pUP = paramBoolean;
      }
    }
    AppMethodBeat.o(133917);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(133916);
    ad.i("MicroMsg.VideoPlayer", "%s video player set path %s", new Object[] { info(), paramString });
    this.vLM.setPath(paramString);
    AppMethodBeat.o(133916);
  }
  
  public final void setPlayRate(float paramFloat)
  {
    if (this.vLM != null)
    {
      Object localObject = this.vLM;
      if (((k)localObject).vLV != null)
      {
        localObject = ((k)localObject).vLV;
        if (paramFloat > 0.0F) {
          ((l)localObject).llC = paramFloat;
        }
      }
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(133919);
    if (paramSurface != null) {
      this.vLM.setSurface(paramSurface);
    }
    AppMethodBeat.o(133919);
  }
  
  public final void start()
  {
    AppMethodBeat.i(133922);
    if (ad.getLogLevel() > 0) {
      ad.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", new Object[] { info(), Integer.valueOf(this.vLM.state), bt.flS() });
    }
    if ((e.JX(this.vLM.state)) || (e.JV(this.vLM.state)))
    {
      ad.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", new Object[] { info() });
      AppMethodBeat.o(133922);
      return;
    }
    this.vLM.start();
    AppMethodBeat.o(133922);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(133927);
    this.vLM.stop();
    AppMethodBeat.o(133927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.o.j
 * JD-Core Version:    0.7.0.1
 */