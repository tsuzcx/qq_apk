package com.tencent.mm.plugin.n;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
  implements c
{
  Looper zrN;
  MMHandler zrO;
  HandlerThread zrP;
  HandlerThread zrQ;
  com.tencent.f.j.a zrR;
  public k zrS;
  public d zrT;
  private MMHandler.Callback zrU;
  
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
    AppMethodBeat.i(208744);
    this.zrU = new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(133914);
        int i = paramAnonymousMessage.what;
        switch (i)
        {
        default: 
          Log.w("MicroMsg.VideoPlayer", "%s it has no idea for msg %d ", new Object[] { j.this.info(), Integer.valueOf(i) });
        }
        for (;;)
        {
          AppMethodBeat.o(133914);
          return false;
          Log.i("MicroMsg.VideoPlayer", "%s call prepared ", new Object[] { j.this.info() });
          if (j.this.zrT != null)
          {
            j.this.zrT.tf();
            continue;
            Log.i("MicroMsg.VideoPlayer", "%s call completion ", new Object[] { j.this.info() });
            if (j.this.zrT != null)
            {
              j.this.zrT.onCompletion();
              continue;
              Log.i("MicroMsg.VideoPlayer", "%s call seek completion ", new Object[] { j.this.info() });
              if (j.this.zrT != null)
              {
                j.this.zrT.cJH();
                continue;
                Log.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", new Object[] { j.this.info(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2), Integer.valueOf(((Integer)paramAnonymousMessage.obj).intValue()) });
                if (j.this.zrT != null)
                {
                  j.this.zrT.aa(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2, ((Integer)paramAnonymousMessage.obj).intValue());
                  continue;
                  Log.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", new Object[] { j.this.info(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
                  if (j.this.zrT != null)
                  {
                    j.this.zrT.onError(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
                    continue;
                    try
                    {
                      paramAnonymousMessage = j.this;
                      Log.i("MicroMsg.VideoPlayer", "%s clear now.", new Object[] { paramAnonymousMessage.info() });
                      paramAnonymousMessage.zrR.quit();
                      paramAnonymousMessage.zrP.quit();
                      if (paramAnonymousMessage.zrQ != null) {
                        paramAnonymousMessage.zrQ.quit();
                      }
                      paramAnonymousMessage.zrO.removeMessages(1);
                      paramAnonymousMessage.zrO.removeMessages(2);
                      paramAnonymousMessage.zrO.removeMessages(3);
                      paramAnonymousMessage.zrO.removeMessages(4);
                      paramAnonymousMessage.zrO.removeMessages(5);
                      paramAnonymousMessage.zrP = null;
                      paramAnonymousMessage.zrO = null;
                      paramAnonymousMessage.zrN = null;
                      paramAnonymousMessage.zrT = null;
                      paramAnonymousMessage.zrS = null;
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
    this.zrR = com.tencent.f.j.a.bqt("VideoPlayer:inner");
    this.zrP = com.tencent.f.c.d.hA("VideoPlayer:video", 10);
    this.zrP.start();
    this.zrQ = com.tencent.f.c.d.hA("VideoPlayer:audio", 10);
    Log.i("MicroMsg.VideoPlayer", "VideoPlayer init 4");
    this.zrQ.start();
    this.zrN = paramLooper;
    this.zrO = new MMHandler(this.zrN, this.zrU);
    this.zrS = new k(this.zrO, this.zrR, this.zrP.getLooper(), this.zrQ.getLooper(), false, paramInt);
    AppMethodBeat.o(208744);
  }
  
  public final void QC(int paramInt)
  {
    AppMethodBeat.i(133925);
    this.zrS.QC(paramInt);
    AppMethodBeat.o(133925);
  }
  
  public final void a(d paramd)
  {
    this.zrT = paramd;
  }
  
  public final int ejm()
  {
    AppMethodBeat.i(133929);
    int i;
    int j;
    if (this.zrS != null)
    {
      k localk = this.zrS;
      if (localk.zrC == null) {
        break label170;
      }
      i = (int)(localk.zrC.zrt / 1000L);
      j = (int)localk.zrC.zrs;
      if (j == -1)
      {
        j = i;
        if (i < localk.zrC.zru / 1000L) {
          j = (int)(localk.zrC.zru / 1000L);
        }
        if (j != localk.zse) {
          Log.i("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", new Object[] { localk.info(), Integer.valueOf(j), Long.valueOf(localk.zrC.zrt), Long.valueOf(localk.zrC.zru) });
        }
        localk.zse = j;
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
    return this.zrS.durationMs;
  }
  
  public final float getPlayRate()
  {
    float f2 = 1.0F;
    float f1 = f2;
    if (this.zrS != null)
    {
      k localk = this.zrS;
      f1 = f2;
      if (localk.zsb != null) {
        f1 = localk.zsb.mwH;
      }
    }
    return f1;
  }
  
  public final void i(Surface paramSurface)
  {
    AppMethodBeat.i(133920);
    if (paramSurface != null)
    {
      Object localObject = this.zrS;
      Log.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", new Object[] { ((k)localObject).info(), Integer.valueOf(paramSurface.hashCode()) });
      localObject = ((k)localObject).zsb;
      Log.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", new Object[] { ((l)localObject).info() });
      ((l)localObject).surface = paramSurface;
      if (com.tencent.mm.compatible.util.d.oD(23))
      {
        ((l)localObject).ejp();
        AppMethodBeat.o(133920);
        return;
      }
      ((l)localObject).ejq();
    }
    AppMethodBeat.o(133920);
  }
  
  public final String info()
  {
    AppMethodBeat.i(133931);
    if (this.zrS != null)
    {
      String str = this.zrS.info();
      AppMethodBeat.o(133931);
      return str;
    }
    AppMethodBeat.o(133931);
    return "has no player!";
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(133930);
    if (this.zrS != null)
    {
      boolean bool = e.Qu(this.zrS.state);
      AppMethodBeat.o(133930);
      return bool;
    }
    AppMethodBeat.o(133930);
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(133923);
    if (Log.getLogLevel() > 0) {
      Log.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", new Object[] { info(), Integer.valueOf(this.zrS.state), Util.getStack() });
    }
    if ((e.Qy(this.zrS.state)) || (e.Qw(this.zrS.state)))
    {
      Log.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", new Object[] { info() });
      AppMethodBeat.o(133923);
      return;
    }
    this.zrS.pause();
    AppMethodBeat.o(133923);
  }
  
  public final boolean prepare()
  {
    AppMethodBeat.i(133921);
    this.zrS.prepare();
    AppMethodBeat.o(133921);
    return true;
  }
  
  public final void ra(boolean paramBoolean)
  {
    this.zrS.zsb.zso = paramBoolean;
  }
  
  public final void release()
  {
    AppMethodBeat.i(133928);
    try
    {
      this.zrS.release();
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
    this.zrS.seek(paramInt);
    AppMethodBeat.o(133924);
  }
  
  public final void setIOnlineCache(b paramb)
  {
    if ((paramb != null) && (this.zrS != null)) {
      this.zrS.zsb.zrF = paramb;
    }
  }
  
  public final void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(133918);
    if (this.zrS != null)
    {
      k localk = this.zrS;
      if (localk.zrC != null)
      {
        Log.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
        localk.zrC.rss = paramBoolean;
      }
    }
    AppMethodBeat.o(133918);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(133926);
    try
    {
      if (this.zrS != null)
      {
        k localk = this.zrS;
        if (localk.zsd != null)
        {
          Log.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
          localk.zsd.setMute(paramBoolean);
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
    if (this.zrS != null)
    {
      k localk = this.zrS;
      Log.i("MicroMsg.VideoPlayerImpl", "%s setNeedResetExtractor [%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
      if (localk.zrC != null) {
        localk.zrC.rsr = paramBoolean;
      }
    }
    AppMethodBeat.o(133917);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(133916);
    Log.i("MicroMsg.VideoPlayer", "%s video player set path %s", new Object[] { info(), paramString });
    this.zrS.setPath(paramString);
    AppMethodBeat.o(133916);
  }
  
  public final void setPlayRate(float paramFloat)
  {
    if (this.zrS != null)
    {
      Object localObject = this.zrS;
      if (((k)localObject).zsb != null)
      {
        localObject = ((k)localObject).zsb;
        if (paramFloat > 0.0F) {
          ((l)localObject).mwH = paramFloat;
        }
      }
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(133919);
    if (paramSurface != null) {
      this.zrS.setSurface(paramSurface);
    }
    AppMethodBeat.o(133919);
  }
  
  public final void start()
  {
    AppMethodBeat.i(133922);
    if (Log.getLogLevel() > 0) {
      Log.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", new Object[] { info(), Integer.valueOf(this.zrS.state), Util.getStack() });
    }
    if ((e.Qy(this.zrS.state)) || (e.Qw(this.zrS.state)))
    {
      Log.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", new Object[] { info() });
      AppMethodBeat.o(133922);
      return;
    }
    this.zrS.start();
    AppMethodBeat.o(133922);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(133927);
    this.zrS.stop();
    AppMethodBeat.o(133927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.n.j
 * JD-Core Version:    0.7.0.1
 */