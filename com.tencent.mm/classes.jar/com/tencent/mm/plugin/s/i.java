package com.tencent.mm.plugin.s;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class i
{
  ah meA;
  HandlerThread meB = e.ds("VideoPlayer:inner", -16);
  HandlerThread meC;
  HandlerThread meD;
  public j meE;
  public c meF;
  private ah.a meG = new i.1(this);
  Looper mez;
  
  public i(Looper paramLooper)
  {
    this(paramLooper, (byte)0);
  }
  
  private i(Looper paramLooper, byte paramByte)
  {
    this.meB.start();
    this.meC = e.ds("VideoPlayer:video", -16);
    this.meC.start();
    this.meD = e.ds("VideoPlayer:audio", -16);
    this.meD.start();
    this.mez = paramLooper;
    this.meA = new ah(this.mez, this.meG);
    ah localah = this.meA;
    Looper localLooper1 = this.meB.getLooper();
    Looper localLooper2 = this.meC.getLooper();
    if (this.meD != null) {}
    for (paramLooper = this.meD.getLooper();; paramLooper = null)
    {
      this.meE = new j(localah, localLooper1, localLooper2, paramLooper);
      return;
    }
  }
  
  public final void a(c paramc)
  {
    this.meF = paramc;
  }
  
  public final String ayN()
  {
    if (this.meE != null) {
      return this.meE.mep.ayN();
    }
    return "has no player!";
  }
  
  public final long biw()
  {
    return this.meE.aGU;
  }
  
  public final int bix()
  {
    j localj = this.meE;
    if (localj.mep != null)
    {
      int i = (int)(localj.mep.meh / 1000L);
      int j = (int)localj.mep.meg;
      if (j == -1) {}
      for (;;)
      {
        j = i;
        if (i < localj.mep.mei / 1000L) {
          j = (int)(localj.mep.mei / 1000L);
        }
        y.d("MicroMsg.VideoPlayerImpl", "%s get curr play ms %d time[%d %d]", new Object[] { localj.mep.ayN(), Integer.valueOf(j), Long.valueOf(localj.mep.meh), Long.valueOf(localj.mep.mei) });
        return j;
        i = j;
      }
    }
    return 0;
  }
  
  public final void d(Surface paramSurface)
  {
    Object localObject;
    if (paramSurface != null)
    {
      localObject = this.meE;
      y.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", new Object[] { ((j)localObject).mep.ayN(), Integer.valueOf(paramSurface.hashCode()) });
      localObject = ((j)localObject).meN;
      y.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", new Object[] { ((k)localObject).ayN() });
      ((k)localObject).avf = paramSurface;
      if (com.tencent.mm.compatible.util.d.gF(23)) {
        ((k)localObject).biA();
      }
    }
    else
    {
      return;
    }
    ((k)localObject).biB();
  }
  
  public final float getPlayRate()
  {
    float f2 = 1.0F;
    float f1 = f2;
    if (this.meE != null)
    {
      j localj = this.meE;
      f1 = f2;
      if (localj.meN != null) {
        f1 = localj.meN.gEy;
      }
    }
    return f1;
  }
  
  public final void hr(boolean paramBoolean)
  {
    this.meE.meN.meW = paramBoolean;
  }
  
  public final boolean isPlaying()
  {
    return d.tI(this.meE.state);
  }
  
  public final void pause()
  {
    y.d("MicroMsg.VideoPlayer", "%s pause state[%d] stack %s", new Object[] { ayN(), Integer.valueOf(this.meE.state), bk.csb() });
    if ((d.tL(this.meE.state)) || (d.tJ(this.meE.state)))
    {
      y.w("MicroMsg.VideoPlayer", "%s it seek now, do not response pause event.", new Object[] { ayN() });
      return;
    }
    this.meE.pause();
  }
  
  public final boolean prepare()
  {
    j localj = this.meE;
    y.i("MicroMsg.VideoPlayerImpl", "%s player start to prepare ", new Object[] { localj.mep.ayN() });
    localj.meI.obtainMessage(1).sendToTarget();
    if (localj.meP != null) {
      localj.meJ.obtainMessage(1).sendToTarget();
    }
    return true;
  }
  
  public final void release()
  {
    try
    {
      this.meE.release();
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void setIOnlineCache(b paramb)
  {
    if ((paramb != null) && (this.meE != null)) {
      this.meE.meN.mes = paramb;
    }
  }
  
  public final void setIsOnlineVideoType(boolean paramBoolean)
  {
    if (this.meE != null)
    {
      j localj = this.meE;
      if (localj.mep != null)
      {
        y.i("MicroMsg.VideoPlayerImpl", "%s set is online video type [%b]", new Object[] { localj.mep.ayN(), Boolean.valueOf(paramBoolean) });
        localj.mep.joR = paramBoolean;
      }
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    try
    {
      if (this.meE != null)
      {
        j localj = this.meE;
        if (localj.meP != null)
        {
          y.i("MicroMsg.VideoPlayerImpl", "%s play set mute[%b]", new Object[] { localj.mep.ayN(), Boolean.valueOf(paramBoolean) });
          localj.meP.setMute(paramBoolean);
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void setNeedResetExtractor(boolean paramBoolean)
  {
    if (this.meE != null)
    {
      j localj = this.meE;
      if (localj.mep != null) {
        localj.mep.joQ = paramBoolean;
      }
    }
  }
  
  public final void setPath(String paramString)
  {
    y.i("MicroMsg.VideoPlayer", "%s video player set path %s", new Object[] { ayN(), paramString });
    j localj = this.meE;
    y.i("MicroMsg.VideoPlayerImpl", "%s set path %s", new Object[] { localj.mep.ayN(), paramString });
    localj.meN.setPath(paramString);
    if (localj.meP != null) {
      localj.meP.setPath(paramString);
    }
  }
  
  public final void setPlayRate(float paramFloat)
  {
    if (this.meE != null)
    {
      Object localObject = this.meE;
      if (((j)localObject).meN != null)
      {
        localObject = ((j)localObject).meN;
        if (paramFloat > 0.0F) {
          ((k)localObject).gEy = paramFloat;
        }
      }
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    if (paramSurface != null)
    {
      j localj = this.meE;
      y.i("MicroMsg.VideoPlayerImpl", "%s set surface[%d] ", new Object[] { localj.mep.ayN(), Integer.valueOf(paramSurface.hashCode()) });
      localj.meN.avf = paramSurface;
    }
  }
  
  public final void start()
  {
    y.d("MicroMsg.VideoPlayer", "%s start state[%d] stack %s", new Object[] { ayN(), Integer.valueOf(this.meE.state), bk.csb() });
    if ((d.tL(this.meE.state)) || (d.tJ(this.meE.state)))
    {
      y.w("MicroMsg.VideoPlayer", "%s it seek now, do not response start event.", new Object[] { ayN() });
      return;
    }
    this.meE.start();
  }
  
  public final void stop()
  {
    this.meE.stop();
  }
  
  public final void tP(int paramInt)
  {
    this.meE.tP(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.s.i
 * JD-Core Version:    0.7.0.1
 */