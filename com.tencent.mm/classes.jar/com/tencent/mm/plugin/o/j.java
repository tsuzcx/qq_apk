package com.tencent.mm.plugin.o;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class j
  implements c
{
  Looper vXL;
  aq vXM;
  HandlerThread vXN;
  HandlerThread vXO;
  com.tencent.e.j.a vXP;
  public k vXQ;
  public d vXR;
  private aq.a vXS;
  
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
    AppMethodBeat.i(220263);
    this.vXS = new aq.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133914);
        int i = paramAnonymousMessage.what;
        switch (i)
        {
        default: 
          ae.w("MicroMsg.VideoPlayer", "%s it has no idea for msg %d ", new Object[] { j.this.info(), Integer.valueOf(i) });
        }
        for (;;)
        {
          AppMethodBeat.o(133914);
          return false;
          ae.i("MicroMsg.VideoPlayer", "%s call prepared ", new Object[] { j.this.info() });
          if (j.this.vXR != null)
          {
            j.this.vXR.ta();
            continue;
            ae.i("MicroMsg.VideoPlayer", "%s call completion ", new Object[] { j.this.info() });
            if (j.this.vXR != null)
            {
              j.this.vXR.onCompletion();
              continue;
              ae.i("MicroMsg.VideoPlayer", "%s call seek completion ", new Object[] { j.this.info() });
              if (j.this.vXR != null)
              {
                j.this.vXR.clF();
                continue;
                ae.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", new Object[] { j.this.info(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2), Integer.valueOf(((Integer)paramAnonymousMessage.obj).intValue()) });
                if (j.this.vXR != null)
                {
                  j.this.vXR.Z(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2, ((Integer)paramAnonymousMessage.obj).intValue());
                  continue;
                  ae.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", new Object[] { j.this.info(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
                  if (j.this.vXR != null)
                  {
                    j.this.vXR.onError(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
                    continue;
                    try
                    {
                      paramAnonymousMessage = j.this;
                      ae.i("MicroMsg.VideoPlayer", "%s clear now.", new Object[] { paramAnonymousMessage.info() });
                      paramAnonymousMessage.vXP.quit();
                      paramAnonymousMessage.vXN.quit();
                      if (paramAnonymousMessage.vXO != null) {
                        paramAnonymousMessage.vXO.quit();
                      }
                      paramAnonymousMessage.vXM.removeMessages(1);
                      paramAnonymousMessage.vXM.removeMessages(2);
                      paramAnonymousMessage.vXM.removeMessages(3);
                      paramAnonymousMessage.vXM.removeMessages(4);
                      paramAnonymousMessage.vXM.removeMessages(5);
                      paramAnonymousMessage.vXN = null;
                      paramAnonymousMessage.vXM = null;
                      paramAnonymousMessage.vXL = null;
                      paramAnonymousMessage.vXR = null;
                      paramAnonymousMessage.vXQ = null;
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
    this.vXP = com.tencent.e.j.a.bbi("VideoPlayer:inner");
    this.vXN = com.tencent.e.c.d.hg("VideoPlayer:video", 10);
    this.vXN.start();
    this.vXO = com.tencent.e.c.d.hg("VideoPlayer:audio", 10);
    ae.i("MicroMsg.VideoPlayer", "VideoPlayer init 4");
    this.vXO.start();
    this.vXL = paramLooper;
    this.vXM = new aq(this.vXL, this.vXS);
    this.vXQ = new k(this.vXM, this.vXP, this.vXN.getLooper(), this.vXO.getLooper(), paramInt);
    AppMethodBeat.o(220263);
  }
  
  public final void KB(int paramInt)
  {
    AppMethodBeat.i(133925);
    this.vXQ.KB(paramInt);
    AppMethodBeat.o(133925);
  }
  
  public final void a(d paramd)
  {
    this.vXR = paramd;
  }
  
  public final boolean cSW()
  {
    AppMethodBeat.i(133921);
    this.vXQ.cSW();
    AppMethodBeat.o(133921);
    return true;
  }
  
  public final int dpx()
  {
    AppMethodBeat.i(133929);
    int i;
    int j;
    if (this.vXQ != null)
    {
      k localk = this.vXQ;
      if (localk.vXA == null) {
        break label170;
      }
      i = (int)(localk.vXA.vXr / 1000L);
      j = (int)localk.vXA.vXq;
      if (j == -1)
      {
        j = i;
        if (i < localk.vXA.vXs / 1000L) {
          j = (int)(localk.vXA.vXs / 1000L);
        }
        if (j != localk.vYc) {
          ae.i("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", new Object[] { localk.info(), Integer.valueOf(j), Long.valueOf(localk.vXA.vXr), Long.valueOf(localk.vXA.vXs) });
        }
        localk.vYc = j;
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
    return this.vXQ.bup;
  }
  
  public final float getPlayRate()
  {
    float f2 = 1.0F;
    float f1 = f2;
    if (this.vXQ != null)
    {
      k localk = this.vXQ;
      f1 = f2;
      if (localk.vXZ != null) {
        f1 = localk.vXZ.lqb;
      }
    }
    return f1;
  }
  
  public final void i(Surface paramSurface)
  {
    AppMethodBeat.i(133920);
    if (paramSurface != null)
    {
      Object localObject = this.vXQ;
      ae.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", new Object[] { ((k)localObject).info(), Integer.valueOf(paramSurface.hashCode()) });
      localObject = ((k)localObject).vXZ;
      ae.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", new Object[] { ((l)localObject).info() });
      ((l)localObject).surface = paramSurface;
      if (com.tencent.mm.compatible.util.d.lA(23))
      {
        ((l)localObject).dpA();
        AppMethodBeat.o(133920);
        return;
      }
      ((l)localObject).dpB();
    }
    AppMethodBeat.o(133920);
  }
  
  public final String info()
  {
    AppMethodBeat.i(133931);
    if (this.vXQ != null)
    {
      String str = this.vXQ.info();
      AppMethodBeat.o(133931);
      return str;
    }
    AppMethodBeat.o(133931);
    return "has no player!";
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(133930);
    if (this.vXQ != null)
    {
      boolean bool = e.Kt(this.vXQ.state);
      AppMethodBeat.o(133930);
      return bool;
    }
    AppMethodBeat.o(133930);
    return false;
  }
  
  public final void ov(boolean paramBoolean)
  {
    this.vXQ.vXZ.vYm = paramBoolean;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(133923);
    if (ae.getLogLevel() > 0) {
      ae.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", new Object[] { info(), Integer.valueOf(this.vXQ.state), bu.fpN() });
    }
    if ((e.Kx(this.vXQ.state)) || (e.Kv(this.vXQ.state)))
    {
      ae.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", new Object[] { info() });
      AppMethodBeat.o(133923);
      return;
    }
    this.vXQ.pause();
    AppMethodBeat.o(133923);
  }
  
  public final void release()
  {
    AppMethodBeat.i(133928);
    try
    {
      this.vXQ.release();
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
    this.vXQ.seek(paramInt);
    AppMethodBeat.o(133924);
  }
  
  public final void setIOnlineCache(b paramb)
  {
    if ((paramb != null) && (this.vXQ != null)) {
      this.vXQ.vXZ.vXD = paramb;
    }
  }
  
  public final void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(133918);
    if (this.vXQ != null)
    {
      k localk = this.vXQ;
      if (localk.vXA != null)
      {
        ae.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
        localk.vXA.qbv = paramBoolean;
      }
    }
    AppMethodBeat.o(133918);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(133926);
    try
    {
      if (this.vXQ != null)
      {
        k localk = this.vXQ;
        if (localk.vYb != null)
        {
          ae.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
          localk.vYb.setMute(paramBoolean);
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
    if (this.vXQ != null)
    {
      k localk = this.vXQ;
      ae.i("MicroMsg.VideoPlayerImpl", "%s setNeedResetExtractor [%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
      if (localk.vXA != null) {
        localk.vXA.qbu = paramBoolean;
      }
    }
    AppMethodBeat.o(133917);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(133916);
    ae.i("MicroMsg.VideoPlayer", "%s video player set path %s", new Object[] { info(), paramString });
    this.vXQ.setPath(paramString);
    AppMethodBeat.o(133916);
  }
  
  public final void setPlayRate(float paramFloat)
  {
    if (this.vXQ != null)
    {
      Object localObject = this.vXQ;
      if (((k)localObject).vXZ != null)
      {
        localObject = ((k)localObject).vXZ;
        if (paramFloat > 0.0F) {
          ((l)localObject).lqb = paramFloat;
        }
      }
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(133919);
    if (paramSurface != null) {
      this.vXQ.setSurface(paramSurface);
    }
    AppMethodBeat.o(133919);
  }
  
  public final void start()
  {
    AppMethodBeat.i(133922);
    if (ae.getLogLevel() > 0) {
      ae.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", new Object[] { info(), Integer.valueOf(this.vXQ.state), bu.fpN() });
    }
    if ((e.Kx(this.vXQ.state)) || (e.Kv(this.vXQ.state)))
    {
      ae.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", new Object[] { info() });
      AppMethodBeat.o(133922);
      return;
    }
    this.vXQ.start();
    AppMethodBeat.o(133922);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(133927);
    this.vXQ.stop();
    AppMethodBeat.o(133927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.o.j
 * JD-Core Version:    0.7.0.1
 */