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
import com.tencent.threadpool.j.a;

public final class j
  implements c
{
  Looper KSZ;
  MMHandler KTa;
  HandlerThread KTb;
  HandlerThread KTc;
  a KTd;
  public k KTe;
  public d KTf;
  private MMHandler.Callback KTg;
  
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
    AppMethodBeat.i(260374);
    this.KTg = new MMHandler.Callback()
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
          if (j.this.KTf != null)
          {
            j.this.KTf.Qz();
            continue;
            Log.i("MicroMsg.VideoPlayer", "%s call completion ", new Object[] { j.this.info() });
            if (j.this.KTf != null)
            {
              j.this.KTf.onCompletion();
              continue;
              Log.i("MicroMsg.VideoPlayer", "%s call seek completion ", new Object[] { j.this.info() });
              if (j.this.KTf != null)
              {
                j.this.KTf.dEH();
                continue;
                Log.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", new Object[] { j.this.info(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2), Integer.valueOf(((Integer)paramAnonymousMessage.obj).intValue()) });
                if (j.this.KTf != null)
                {
                  j.this.KTf.as(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2, ((Integer)paramAnonymousMessage.obj).intValue());
                  continue;
                  Log.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", new Object[] { j.this.info(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
                  if (j.this.KTf != null)
                  {
                    j.this.KTf.onError(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
                    continue;
                    try
                    {
                      paramAnonymousMessage = j.this;
                      Log.i("MicroMsg.VideoPlayer", "%s clear now.", new Object[] { paramAnonymousMessage.info() });
                      paramAnonymousMessage.KTd.quit();
                      paramAnonymousMessage.KTb.quitSafely();
                      if (paramAnonymousMessage.KTc != null) {
                        paramAnonymousMessage.KTc.quitSafely();
                      }
                      paramAnonymousMessage.KTa.removeMessages(1);
                      paramAnonymousMessage.KTa.removeMessages(2);
                      paramAnonymousMessage.KTa.removeMessages(3);
                      paramAnonymousMessage.KTa.removeMessages(4);
                      paramAnonymousMessage.KTa.removeMessages(5);
                      paramAnonymousMessage.KTb = null;
                      paramAnonymousMessage.KTa = null;
                      paramAnonymousMessage.KSZ = null;
                      paramAnonymousMessage.KTf = null;
                      paramAnonymousMessage.KTe = null;
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
    this.KTd = a.bFV("VideoPlayer:inner");
    this.KTb = com.tencent.threadpool.c.d.jw("VideoPlayer:video", 10);
    this.KTb.start();
    this.KTc = com.tencent.threadpool.c.d.jw("VideoPlayer:audio", 10);
    Log.i("MicroMsg.VideoPlayer", "VideoPlayer init 4");
    this.KTc.start();
    this.KSZ = paramLooper;
    this.KTa = new MMHandler(this.KSZ, this.KTg);
    this.KTe = new k(this.KTa, this.KTd, this.KTb.getLooper(), this.KTc.getLooper(), false, paramInt);
    AppMethodBeat.o(260374);
  }
  
  public final void aaS(int paramInt)
  {
    AppMethodBeat.i(133925);
    this.KTe.aaS(paramInt);
    AppMethodBeat.o(133925);
  }
  
  public final int gbM()
  {
    AppMethodBeat.i(133929);
    int i;
    int j;
    if (this.KTe != null)
    {
      k localk = this.KTe;
      if (localk.KSM == null) {
        break label170;
      }
      i = (int)(localk.KSM.KSD / 1000L);
      j = (int)localk.KSM.KSC;
      if (j == -1)
      {
        j = i;
        if (i < localk.KSM.KSE / 1000L) {
          j = (int)(localk.KSM.KSE / 1000L);
        }
        if (j != localk.KTr) {
          Log.i("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", new Object[] { localk.info(), Integer.valueOf(j), Long.valueOf(localk.KSM.KSD), Long.valueOf(localk.KSM.KSE) });
        }
        localk.KTr = j;
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
    return this.KTe.durationMs;
  }
  
  public final String info()
  {
    AppMethodBeat.i(133931);
    if (this.KTe != null)
    {
      String str = this.KTe.info();
      AppMethodBeat.o(133931);
      return str;
    }
    AppMethodBeat.o(133931);
    return "has no player!";
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(133930);
    if (this.KTe != null)
    {
      boolean bool = e.aaJ(this.KTe.state);
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
      Log.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", new Object[] { info(), Integer.valueOf(this.KTe.state), Util.getStack() });
    }
    if ((e.aaO(this.KTe.state)) || (e.aaL(this.KTe.state)))
    {
      Log.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", new Object[] { info() });
      AppMethodBeat.o(133923);
      return;
    }
    this.KTe.pause();
    AppMethodBeat.o(133923);
  }
  
  public final boolean prepare()
  {
    AppMethodBeat.i(133921);
    this.KTe.prepare();
    AppMethodBeat.o(133921);
    return true;
  }
  
  public final void r(Surface paramSurface)
  {
    AppMethodBeat.i(133920);
    if (paramSurface != null) {
      this.KTe.r(paramSurface);
    }
    AppMethodBeat.o(133920);
  }
  
  public final void release()
  {
    AppMethodBeat.i(133928);
    try
    {
      this.KTe.release();
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
    this.KTe.seek(paramInt);
    AppMethodBeat.o(133924);
  }
  
  public final void setIOnlineCache(b paramb)
  {
    if ((paramb != null) && (this.KTe != null)) {
      this.KTe.KTn.KSQ = paramb;
    }
  }
  
  public final void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(133918);
    if (this.KTe != null) {
      this.KTe.setIsOnlineVideoType(paramBoolean);
    }
    AppMethodBeat.o(133918);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(133926);
    try
    {
      if (this.KTe != null) {
        this.KTe.setMute(paramBoolean);
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
    if (this.KTe != null) {
      this.KTe.setNeedResetExtractor(paramBoolean);
    }
    AppMethodBeat.o(133917);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(133916);
    Log.i("MicroMsg.VideoPlayer", "%s video player set path %s", new Object[] { info(), paramString });
    this.KTe.setPath(paramString);
    AppMethodBeat.o(133916);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(133919);
    if (paramSurface != null) {
      this.KTe.setSurface(paramSurface);
    }
    AppMethodBeat.o(133919);
  }
  
  public final void start()
  {
    AppMethodBeat.i(133922);
    if (Log.getLogLevel() > 0) {
      Log.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", new Object[] { info(), Integer.valueOf(this.KTe.state), Util.getStack() });
    }
    if ((e.aaO(this.KTe.state)) || (e.aaL(this.KTe.state)))
    {
      Log.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", new Object[] { info() });
      AppMethodBeat.o(133922);
      return;
    }
    this.KTe.start();
    AppMethodBeat.o(133922);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(133927);
    this.KTe.stop();
    AppMethodBeat.o(133927);
  }
  
  public final void yr(boolean paramBoolean)
  {
    AppMethodBeat.i(260381);
    this.KTe.yr(paramBoolean);
    AppMethodBeat.o(260381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.u.j
 * JD-Core Version:    0.7.0.1
 */