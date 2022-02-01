package com.tencent.mm.plugin.u;

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
  Looper EXo;
  MMHandler EXp;
  HandlerThread EXq;
  HandlerThread EXr;
  com.tencent.e.j.a EXs;
  public k EXt;
  public d EXu;
  private MMHandler.Callback EXv;
  
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
    AppMethodBeat.i(204830);
    this.EXv = new MMHandler.Callback()
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
          if (j.this.EXu != null)
          {
            j.this.EXu.qX();
            continue;
            Log.i("MicroMsg.VideoPlayer", "%s call completion ", new Object[] { j.this.info() });
            if (j.this.EXu != null)
            {
              j.this.EXu.onCompletion();
              continue;
              Log.i("MicroMsg.VideoPlayer", "%s call seek completion ", new Object[] { j.this.info() });
              if (j.this.EXu != null)
              {
                j.this.EXu.cYp();
                continue;
                Log.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", new Object[] { j.this.info(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2), Integer.valueOf(((Integer)paramAnonymousMessage.obj).intValue()) });
                if (j.this.EXu != null)
                {
                  j.this.EXu.ab(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2, ((Integer)paramAnonymousMessage.obj).intValue());
                  continue;
                  Log.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", new Object[] { j.this.info(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
                  if (j.this.EXu != null)
                  {
                    j.this.EXu.onError(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
                    continue;
                    try
                    {
                      paramAnonymousMessage = j.this;
                      Log.i("MicroMsg.VideoPlayer", "%s clear now.", new Object[] { paramAnonymousMessage.info() });
                      paramAnonymousMessage.EXs.quit();
                      paramAnonymousMessage.EXq.quitSafely();
                      if (paramAnonymousMessage.EXr != null) {
                        paramAnonymousMessage.EXr.quitSafely();
                      }
                      paramAnonymousMessage.EXp.removeMessages(1);
                      paramAnonymousMessage.EXp.removeMessages(2);
                      paramAnonymousMessage.EXp.removeMessages(3);
                      paramAnonymousMessage.EXp.removeMessages(4);
                      paramAnonymousMessage.EXp.removeMessages(5);
                      paramAnonymousMessage.EXq = null;
                      paramAnonymousMessage.EXp = null;
                      paramAnonymousMessage.EXo = null;
                      paramAnonymousMessage.EXu = null;
                      paramAnonymousMessage.EXt = null;
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
    this.EXs = com.tencent.e.j.a.bDn("VideoPlayer:inner");
    this.EXq = com.tencent.e.c.d.ik("VideoPlayer:video", 10);
    this.EXq.start();
    this.EXr = com.tencent.e.c.d.ik("VideoPlayer:audio", 10);
    Log.i("MicroMsg.VideoPlayer", "VideoPlayer init 4");
    this.EXr.start();
    this.EXo = paramLooper;
    this.EXp = new MMHandler(this.EXo, this.EXv);
    this.EXt = new k(this.EXp, this.EXs, this.EXq.getLooper(), this.EXr.getLooper(), false, paramInt);
    AppMethodBeat.o(204830);
  }
  
  public final void WQ(int paramInt)
  {
    AppMethodBeat.i(133925);
    this.EXt.WQ(paramInt);
    AppMethodBeat.o(133925);
  }
  
  public final void a(d paramd)
  {
    this.EXu = paramd;
  }
  
  public final int eST()
  {
    AppMethodBeat.i(133929);
    int i;
    int j;
    if (this.EXt != null)
    {
      k localk = this.EXt;
      if (localk.EXa == null) {
        break label170;
      }
      i = (int)(localk.EXa.EWR / 1000L);
      j = (int)localk.EXa.EWQ;
      if (j == -1)
      {
        j = i;
        if (i < localk.EXa.EWS / 1000L) {
          j = (int)(localk.EXa.EWS / 1000L);
        }
        if (j != localk.EXF) {
          Log.i("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", new Object[] { localk.info(), Integer.valueOf(j), Long.valueOf(localk.EXa.EWR), Long.valueOf(localk.EXa.EWS) });
        }
        localk.EXF = j;
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
    return this.EXt.durationMs;
  }
  
  public final float getPlayRate()
  {
    float f2 = 1.0F;
    float f1 = f2;
    if (this.EXt != null)
    {
      k localk = this.EXt;
      f1 = f2;
      if (localk.EXC != null) {
        f1 = localk.EXC.pvh;
      }
    }
    return f1;
  }
  
  public final String info()
  {
    AppMethodBeat.i(133931);
    if (this.EXt != null)
    {
      String str = this.EXt.info();
      AppMethodBeat.o(133931);
      return str;
    }
    AppMethodBeat.o(133931);
    return "has no player!";
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(133930);
    if (this.EXt != null)
    {
      boolean bool = e.WH(this.EXt.state);
      AppMethodBeat.o(133930);
      return bool;
    }
    AppMethodBeat.o(133930);
    return false;
  }
  
  public final void m(Surface paramSurface)
  {
    AppMethodBeat.i(133920);
    if (paramSurface != null)
    {
      Object localObject = this.EXt;
      Log.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", new Object[] { ((k)localObject).info(), Integer.valueOf(paramSurface.hashCode()) });
      localObject = ((k)localObject).EXC;
      Log.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", new Object[] { ((l)localObject).info() });
      ((l)localObject).surface = paramSurface;
      if (com.tencent.mm.compatible.util.d.qV(23))
      {
        ((l)localObject).eSW();
        AppMethodBeat.o(133920);
        return;
      }
      ((l)localObject).eSX();
    }
    AppMethodBeat.o(133920);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(133923);
    if (Log.getLogLevel() > 0) {
      Log.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", new Object[] { info(), Integer.valueOf(this.EXt.state), Util.getStack() });
    }
    if ((e.WM(this.EXt.state)) || (e.WJ(this.EXt.state)))
    {
      Log.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", new Object[] { info() });
      AppMethodBeat.o(133923);
      return;
    }
    this.EXt.pause();
    AppMethodBeat.o(133923);
  }
  
  public final boolean prepare()
  {
    AppMethodBeat.i(133921);
    this.EXt.prepare();
    AppMethodBeat.o(133921);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(133928);
    try
    {
      this.EXt.release();
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
    this.EXt.seek(paramInt);
    AppMethodBeat.o(133924);
  }
  
  public final void setIOnlineCache(b paramb)
  {
    if ((paramb != null) && (this.EXt != null)) {
      this.EXt.EXC.EXe = paramb;
    }
  }
  
  public final void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(133918);
    if (this.EXt != null)
    {
      k localk = this.EXt;
      if (localk.EXa != null)
      {
        Log.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
        localk.EXa.uXY = paramBoolean;
      }
    }
    AppMethodBeat.o(133918);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(133926);
    try
    {
      if (this.EXt != null)
      {
        k localk = this.EXt;
        if (localk.EXE != null)
        {
          Log.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
          localk.EXE.setMute(paramBoolean);
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
    if (this.EXt != null)
    {
      k localk = this.EXt;
      Log.i("MicroMsg.VideoPlayerImpl", "%s setNeedResetExtractor [%b]", new Object[] { localk.info(), Boolean.valueOf(paramBoolean) });
      if (localk.EXa != null) {
        localk.EXa.uXX = paramBoolean;
      }
    }
    AppMethodBeat.o(133917);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(133916);
    Log.i("MicroMsg.VideoPlayer", "%s video player set path %s", new Object[] { info(), paramString });
    this.EXt.setPath(paramString);
    AppMethodBeat.o(133916);
  }
  
  public final void setPlayRate(float paramFloat)
  {
    if (this.EXt != null)
    {
      Object localObject = this.EXt;
      if (((k)localObject).EXC != null)
      {
        localObject = ((k)localObject).EXC;
        if (paramFloat > 0.0F) {
          ((l)localObject).pvh = paramFloat;
        }
      }
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(133919);
    if (paramSurface != null) {
      this.EXt.setSurface(paramSurface);
    }
    AppMethodBeat.o(133919);
  }
  
  public final void start()
  {
    AppMethodBeat.i(133922);
    if (Log.getLogLevel() > 0) {
      Log.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", new Object[] { info(), Integer.valueOf(this.EXt.state), Util.getStack() });
    }
    if ((e.WM(this.EXt.state)) || (e.WJ(this.EXt.state)))
    {
      Log.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", new Object[] { info() });
      AppMethodBeat.o(133922);
      return;
    }
    this.EXt.start();
    AppMethodBeat.o(133922);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(133927);
    this.EXt.stop();
    AppMethodBeat.o(133927);
  }
  
  public final void ud(boolean paramBoolean)
  {
    this.EXt.EXC.EXP = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.u.j
 * JD-Core Version:    0.7.0.1
 */