package com.tencent.mm.plugin.o;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class j
  implements c
{
  Looper uIB;
  ao uIC;
  HandlerThread uID;
  HandlerThread uIE;
  com.tencent.e.j.a uIF;
  public k uIG;
  public d uIH;
  private ao.a uII;
  
  public j(Looper paramLooper)
  {
    this(paramLooper, (byte)0);
  }
  
  private j(Looper paramLooper, byte paramByte)
  {
    AppMethodBeat.i(133915);
    this.uII = new ao.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133914);
        int i = paramAnonymousMessage.what;
        switch (i)
        {
        default: 
          ac.w("MicroMsg.VideoPlayer", "%s it has no idea for msg %d ", new Object[] { j.this.info(), Integer.valueOf(i) });
        }
        for (;;)
        {
          AppMethodBeat.o(133914);
          return false;
          ac.i("MicroMsg.VideoPlayer", "%s call prepared ", new Object[] { j.this.info() });
          if (j.this.uIH != null)
          {
            j.this.uIH.rB();
            continue;
            ac.i("MicroMsg.VideoPlayer", "%s call completion ", new Object[] { j.this.info() });
            if (j.this.uIH != null)
            {
              j.this.uIH.onCompletion();
              continue;
              ac.i("MicroMsg.VideoPlayer", "%s call seek completion ", new Object[] { j.this.info() });
              if (j.this.uIH != null)
              {
                j.this.uIH.cfM();
                continue;
                ac.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", new Object[] { j.this.info(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2), Integer.valueOf(((Integer)paramAnonymousMessage.obj).intValue()) });
                if (j.this.uIH != null)
                {
                  j.this.uIH.X(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2, ((Integer)paramAnonymousMessage.obj).intValue());
                  continue;
                  ac.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", new Object[] { j.this.info(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
                  if (j.this.uIH != null)
                  {
                    j.this.uIH.onError(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
                    continue;
                    try
                    {
                      paramAnonymousMessage = j.this;
                      ac.i("MicroMsg.VideoPlayer", "%s clear now.", new Object[] { paramAnonymousMessage.info() });
                      paramAnonymousMessage.uIF.quit();
                      paramAnonymousMessage.uID.quit();
                      if (paramAnonymousMessage.uIE != null) {
                        paramAnonymousMessage.uIE.quit();
                      }
                      paramAnonymousMessage.uIC.removeMessages(1);
                      paramAnonymousMessage.uIC.removeMessages(2);
                      paramAnonymousMessage.uIC.removeMessages(3);
                      paramAnonymousMessage.uIC.removeMessages(4);
                      paramAnonymousMessage.uIC.removeMessages(5);
                      paramAnonymousMessage.uID = null;
                      paramAnonymousMessage.uIC = null;
                      paramAnonymousMessage.uIB = null;
                      paramAnonymousMessage.uIH = null;
                      paramAnonymousMessage.uIG = null;
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
    this.uIF = com.tencent.e.j.a.aTF("VideoPlayer:inner");
    this.uID = com.tencent.e.c.d.gz("VideoPlayer:video", 10);
    this.uID.start();
    this.uIE = com.tencent.e.c.d.gz("VideoPlayer:audio", 10);
    ac.i("MicroMsg.VideoPlayer", "VideoPlayer init 4");
    this.uIE.start();
    this.uIB = paramLooper;
    this.uIC = new ao(this.uIB, this.uII);
    this.uIG = new k(this.uIC, this.uIF, this.uID.getLooper(), this.uIE.getLooper());
    AppMethodBeat.o(133915);
  }
  
  public final void IE(int paramInt)
  {
    AppMethodBeat.i(133925);
    this.uIG.IE(paramInt);
    AppMethodBeat.o(133925);
  }
  
  public final void a(d paramd)
  {
    this.uIH = paramd;
  }
  
  public final boolean cIc()
  {
    AppMethodBeat.i(133921);
    this.uIG.cIc();
    AppMethodBeat.o(133921);
    return true;
  }
  
  public final int ddd()
  {
    AppMethodBeat.i(133929);
    int i;
    int j;
    if (this.uIG != null)
    {
      k localk = this.uIG;
      if (localk.uIq == null) {
        break label170;
      }
      i = (int)(localk.uIq.uIi / 1000L);
      j = (int)localk.uIq.uIh;
      if (j == -1)
      {
        j = i;
        if (i < localk.uIq.uIj / 1000L) {
          j = (int)(localk.uIq.uIj / 1000L);
        }
        if (j != localk.uIS) {
          ac.i("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", new Object[] { localk.info(), Integer.valueOf(j), Long.valueOf(localk.uIq.uIi), Long.valueOf(localk.uIq.uIj) });
        }
        localk.uIS = j;
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
    return this.uIG.bjU;
  }
  
  public final float getPlayRate()
  {
    float f2 = 1.0F;
    float f1 = f2;
    if (this.uIG != null)
    {
      k localk = this.uIG;
      f1 = f2;
      if (localk.uIP != null) {
        f1 = localk.uIP.kOZ;
      }
    }
    return f1;
  }
  
  public final void i(Surface paramSurface)
  {
    AppMethodBeat.i(133920);
    if (paramSurface != null)
    {
      Object localObject = this.uIG;
      ac.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", new Object[] { ((k)localObject).info(), Integer.valueOf(paramSurface.hashCode()) });
      localObject = ((k)localObject).uIP;
      ac.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", new Object[] { ((l)localObject).info() });
      ((l)localObject).surface = paramSurface;
      if (com.tencent.mm.compatible.util.d.kZ(23))
      {
        ((l)localObject).ddg();
        AppMethodBeat.o(133920);
        return;
      }
      ((l)localObject).ddh();
    }
    AppMethodBeat.o(133920);
  }
  
  public final String info()
  {
    AppMethodBeat.i(133931);
    if (this.uIG != null)
    {
      String str = this.uIG.info();
      AppMethodBeat.o(133931);
      return str;
    }
    AppMethodBeat.o(133931);
    return "has no player!";
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(133930);
    if (this.uIG != null)
    {
      boolean bool = e.Iw(this.uIG.state);
      AppMethodBeat.o(133930);
      return bool;
    }
    AppMethodBeat.o(133930);
    return false;
  }
  
  public final void nW(boolean paramBoolean)
  {
    this.uIG.uIP.uJc = paramBoolean;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(133923);
    if (ac.getLogLevel() > 0) {
      ac.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", new Object[] { info(), Integer.valueOf(this.uIG.state), bs.eWi() });
    }
    if ((e.IA(this.uIG.state)) || (e.Iy(this.uIG.state)))
    {
      ac.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", new Object[] { info() });
      AppMethodBeat.o(133923);
      return;
    }
    this.uIG.pause();
    AppMethodBeat.o(133923);
  }
  
  public final void release()
  {
    AppMethodBeat.i(133928);
    try
    {
      this.uIG.release();
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
    this.uIG.seek(paramInt);
    AppMethodBeat.o(133924);
  }
  
  public final void setIOnlineCache(b paramb)
  {
    if ((paramb != null) && (this.uIG != null)) {
      this.uIG.uIP.uIt = paramb;
    }
  }
  
  public final void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(133918);
    if (this.uIG != null)
    {
      k localk = this.uIG;
      if (localk.uIq != null)
      {
        ac.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
        localk.uIq.prk = paramBoolean;
      }
    }
    AppMethodBeat.o(133918);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(133926);
    try
    {
      if (this.uIG != null)
      {
        k localk = this.uIG;
        if (localk.uIR != null)
        {
          ac.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
          localk.uIR.setMute(paramBoolean);
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
    if (this.uIG != null)
    {
      k localk = this.uIG;
      ac.i("MicroMsg.VideoPlayerImpl", "%s setNeedResetExtractor [%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
      if (localk.uIq != null) {
        localk.uIq.prj = paramBoolean;
      }
    }
    AppMethodBeat.o(133917);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(133916);
    ac.i("MicroMsg.VideoPlayer", "%s video player set path %s", new Object[] { info(), paramString });
    this.uIG.setPath(paramString);
    AppMethodBeat.o(133916);
  }
  
  public final void setPlayRate(float paramFloat)
  {
    if (this.uIG != null)
    {
      Object localObject = this.uIG;
      if (((k)localObject).uIP != null)
      {
        localObject = ((k)localObject).uIP;
        if (paramFloat > 0.0F) {
          ((l)localObject).kOZ = paramFloat;
        }
      }
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(133919);
    if (paramSurface != null) {
      this.uIG.setSurface(paramSurface);
    }
    AppMethodBeat.o(133919);
  }
  
  public final void start()
  {
    AppMethodBeat.i(133922);
    if (ac.getLogLevel() > 0) {
      ac.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", new Object[] { info(), Integer.valueOf(this.uIG.state), bs.eWi() });
    }
    if ((e.IA(this.uIG.state)) || (e.Iy(this.uIG.state)))
    {
      ac.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", new Object[] { info() });
      AppMethodBeat.o(133922);
      return;
    }
    this.uIG.start();
    AppMethodBeat.o(133922);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(133927);
    this.uIG.stop();
    AppMethodBeat.o(133927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.o.j
 * JD-Core Version:    0.7.0.1
 */