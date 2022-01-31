package com.tencent.mm.plugin.n;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
{
  Looper oEY;
  ak oEZ;
  HandlerThread oFa;
  HandlerThread oFb;
  HandlerThread oFc;
  public j oFd;
  public c oFe;
  private ak.a oFf;
  
  public i(Looper paramLooper)
  {
    this(paramLooper, (byte)0);
  }
  
  private i(Looper paramLooper, byte paramByte)
  {
    AppMethodBeat.i(117876);
    this.oFf = new ak.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(117875);
        int i = paramAnonymousMessage.what;
        switch (i)
        {
        default: 
          ab.w("MicroMsg.VideoPlayer", "%s it has no idea for msg %d ", new Object[] { i.this.bau(), Integer.valueOf(i) });
        }
        for (;;)
        {
          AppMethodBeat.o(117875);
          return false;
          ab.i("MicroMsg.VideoPlayer", "%s call prepared ", new Object[] { i.this.bau() });
          if (i.this.oFe != null)
          {
            i.this.oFe.mG();
            continue;
            ab.i("MicroMsg.VideoPlayer", "%s call completion ", new Object[] { i.this.bau() });
            if (i.this.oFe != null)
            {
              i.this.oFe.Es();
              continue;
              ab.i("MicroMsg.VideoPlayer", "%s call seek completion ", new Object[] { i.this.bau() });
              if (i.this.oFe != null)
              {
                i.this.oFe.boW();
                continue;
                ab.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", new Object[] { i.this.bau(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2), Integer.valueOf(((Integer)paramAnonymousMessage.obj).intValue()) });
                if (i.this.oFe != null)
                {
                  i.this.oFe.R(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2, ((Integer)paramAnonymousMessage.obj).intValue());
                  continue;
                  ab.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", new Object[] { i.this.bau(), Integer.valueOf(paramAnonymousMessage.arg1), Integer.valueOf(paramAnonymousMessage.arg2) });
                  if (i.this.oFe != null)
                  {
                    i.this.oFe.onError(paramAnonymousMessage.arg1, paramAnonymousMessage.arg2);
                    continue;
                    try
                    {
                      paramAnonymousMessage = i.this;
                      ab.i("MicroMsg.VideoPlayer", "%s clear now.", new Object[] { paramAnonymousMessage.bau() });
                      paramAnonymousMessage.oFa.quit();
                      paramAnonymousMessage.oFb.quit();
                      if (paramAnonymousMessage.oFc != null) {
                        paramAnonymousMessage.oFc.quit();
                      }
                      paramAnonymousMessage.oEZ.removeMessages(1);
                      paramAnonymousMessage.oEZ.removeMessages(2);
                      paramAnonymousMessage.oEZ.removeMessages(3);
                      paramAnonymousMessage.oEZ.removeMessages(4);
                      paramAnonymousMessage.oEZ.removeMessages(5);
                      paramAnonymousMessage.oFa = null;
                      paramAnonymousMessage.oFb = null;
                      paramAnonymousMessage.oEZ = null;
                      paramAnonymousMessage.oEY = null;
                      paramAnonymousMessage.oFe = null;
                      paramAnonymousMessage.oFd = null;
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
    this.oFa = com.tencent.mm.sdk.g.d.ey("VideoPlayer:inner", -16);
    this.oFa.start();
    this.oFb = com.tencent.mm.sdk.g.d.ey("VideoPlayer:video", -16);
    this.oFb.start();
    this.oFc = com.tencent.mm.sdk.g.d.ey("VideoPlayer:audio", -16);
    this.oFc.start();
    this.oEY = paramLooper;
    this.oEZ = new ak(this.oEY, this.oFf);
    ak localak = this.oEZ;
    Looper localLooper1 = this.oFa.getLooper();
    Looper localLooper2 = this.oFb.getLooper();
    if (this.oFc != null) {}
    for (paramLooper = this.oFc.getLooper();; paramLooper = null)
    {
      this.oFd = new j(localak, localLooper1, localLooper2, paramLooper);
      AppMethodBeat.o(117876);
      return;
    }
  }
  
  public final void a(c paramc)
  {
    this.oFe = paramc;
  }
  
  public final long bQy()
  {
    return this.oFd.aNP;
  }
  
  public final int bQz()
  {
    AppMethodBeat.i(117889);
    j localj = this.oFd;
    int i;
    int j;
    if (localj.oEN != null)
    {
      i = (int)(localj.oEN.oEF / 1000L);
      j = (int)localj.oEN.oEE;
      if (j == -1)
      {
        j = i;
        if (i < localj.oEN.oEG / 1000L) {
          j = (int)(localj.oEN.oEG / 1000L);
        }
        ab.d("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", new Object[] { localj.oEN.bau(), Integer.valueOf(j), Long.valueOf(localj.oEN.oEF), Long.valueOf(localj.oEN.oEG) });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(117889);
      return j;
      i = j;
      break;
      j = 0;
    }
  }
  
  public final String bau()
  {
    AppMethodBeat.i(117891);
    if (this.oFd != null)
    {
      String str = this.oFd.oEN.bau();
      AppMethodBeat.o(117891);
      return str;
    }
    AppMethodBeat.o(117891);
    return "has no player!";
  }
  
  public final void f(Surface paramSurface)
  {
    AppMethodBeat.i(117881);
    if (paramSurface != null)
    {
      Object localObject = this.oFd;
      ab.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", new Object[] { ((j)localObject).oEN.bau(), Integer.valueOf(paramSurface.hashCode()) });
      localObject = ((j)localObject).oFm;
      ab.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", new Object[] { ((k)localObject).bau() });
      ((k)localObject).axw = paramSurface;
      if (com.tencent.mm.compatible.util.d.fv(23))
      {
        ((k)localObject).bQC();
        AppMethodBeat.o(117881);
        return;
      }
      ((k)localObject).bQD();
    }
    AppMethodBeat.o(117881);
  }
  
  public final float getPlayRate()
  {
    float f2 = 1.0F;
    float f1 = f2;
    if (this.oFd != null)
    {
      j localj = this.oFd;
      f1 = f2;
      if (localj.oFm != null) {
        f1 = localj.oFm.idC;
      }
    }
    return f1;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(117890);
    if (this.oFd != null)
    {
      boolean bool = d.za(this.oFd.state);
      AppMethodBeat.o(117890);
      return bool;
    }
    AppMethodBeat.o(117890);
    return false;
  }
  
  public final void jl(boolean paramBoolean)
  {
    this.oFd.oFm.oFv = paramBoolean;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(117884);
    ab.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", new Object[] { bau(), Integer.valueOf(this.oFd.state), bo.dtY() });
    if ((d.ze(this.oFd.state)) || (d.zc(this.oFd.state)))
    {
      ab.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", new Object[] { bau() });
      AppMethodBeat.o(117884);
      return;
    }
    this.oFd.pause();
    AppMethodBeat.o(117884);
  }
  
  public final boolean prepare()
  {
    AppMethodBeat.i(117882);
    j localj = this.oFd;
    ab.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", new Object[] { localj.oEN.bau() });
    localj.oFh.obtainMessage(1).sendToTarget();
    if (localj.oFo != null) {
      localj.oFi.obtainMessage(1).sendToTarget();
    }
    AppMethodBeat.o(117882);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(117888);
    try
    {
      this.oFd.release();
      AppMethodBeat.o(117888);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(117888);
    }
  }
  
  public final void setIOnlineCache(b paramb)
  {
    if ((paramb != null) && (this.oFd != null)) {
      this.oFd.oFm.oEQ = paramb;
    }
  }
  
  public final void setIsOnlineVideoType(boolean paramBoolean)
  {
    AppMethodBeat.i(117879);
    if (this.oFd != null)
    {
      j localj = this.oFd;
      if (localj.oEN != null)
      {
        ab.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", new Object[] { localj.oEN.bau(), Boolean.valueOf(paramBoolean) });
        localj.oEN.lxF = paramBoolean;
      }
    }
    AppMethodBeat.o(117879);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(117886);
    try
    {
      if (this.oFd != null)
      {
        j localj = this.oFd;
        if (localj.oFo != null)
        {
          ab.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", new Object[] { localj.oEN.bau(), Boolean.valueOf(paramBoolean) });
          localj.oFo.setMute(paramBoolean);
        }
      }
      AppMethodBeat.o(117886);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(117886);
    }
  }
  
  public final void setNeedResetExtractor(boolean paramBoolean)
  {
    AppMethodBeat.i(117878);
    if (this.oFd != null)
    {
      j localj = this.oFd;
      ab.i("MicroMsg.VideoPlayerImpl", "%s setNeedResetExtractor [%b]", new Object[] { localj.oEN.bau(), Boolean.valueOf(paramBoolean) });
      if (localj.oEN != null) {
        localj.oEN.lxE = paramBoolean;
      }
    }
    AppMethodBeat.o(117878);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(117877);
    ab.i("MicroMsg.VideoPlayer", "%s video player set path %s", new Object[] { bau(), paramString });
    j localj = this.oFd;
    ab.i("MicroMsg.VideoPlayerImpl", "%s set path %s", new Object[] { localj.oEN.bau(), paramString });
    localj.oFm.setPath(paramString);
    if (localj.oFo != null) {
      localj.oFo.setPath(paramString);
    }
    AppMethodBeat.o(117877);
  }
  
  public final void setPlayRate(float paramFloat)
  {
    if (this.oFd != null)
    {
      Object localObject = this.oFd;
      if (((j)localObject).oFm != null)
      {
        localObject = ((j)localObject).oFm;
        if (paramFloat > 0.0F) {
          ((k)localObject).idC = paramFloat;
        }
      }
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(117880);
    if (paramSurface != null)
    {
      j localj = this.oFd;
      ab.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", new Object[] { localj.oEN.bau(), Integer.valueOf(paramSurface.hashCode()) });
      localj.oFm.axw = paramSurface;
    }
    AppMethodBeat.o(117880);
  }
  
  public final void start()
  {
    AppMethodBeat.i(117883);
    ab.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", new Object[] { bau(), Integer.valueOf(this.oFd.state), bo.dtY() });
    if ((d.ze(this.oFd.state)) || (d.zc(this.oFd.state)))
    {
      ab.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", new Object[] { bau() });
      AppMethodBeat.o(117883);
      return;
    }
    this.oFd.start();
    AppMethodBeat.o(117883);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(117887);
    this.oFd.stop();
    AppMethodBeat.o(117887);
  }
  
  public final void zi(int paramInt)
  {
    AppMethodBeat.i(117885);
    this.oFd.zi(paramInt);
    AppMethodBeat.o(117885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.n.i
 * JD-Core Version:    0.7.0.1
 */