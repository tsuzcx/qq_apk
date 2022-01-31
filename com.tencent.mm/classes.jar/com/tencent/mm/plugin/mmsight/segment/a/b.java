package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.plugin.s.j;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  implements a
{
  boolean PT = false;
  boolean bSr = false;
  boolean eaP = false;
  i mnK = new i(Looper.getMainLooper());
  int mnL;
  int mnM = 0;
  private int mnN = 0;
  a.a mnO;
  a.d mnP;
  a.b mnQ;
  a.c mnR;
  
  public b()
  {
    Object localObject = this.mnK;
    if (((i)localObject).meE != null)
    {
      localObject = ((i)localObject).meE;
      if (((j)localObject).mep != null) {
        ((j)localObject).mep.mel = false;
      }
    }
    this.mnK.setNeedResetExtractor(false);
    this.mnK.meF = new b.1(this);
  }
  
  public final void a(a.a parama)
  {
    this.mnO = parama;
  }
  
  public final void a(a.b paramb)
  {
    this.mnQ = paramb;
  }
  
  public final void a(a.c paramc)
  {
    this.mnR = paramc;
  }
  
  public final void a(a.d paramd)
  {
    this.mnP = paramd;
  }
  
  public final int getCurrentPosition()
  {
    return this.mnK.bix();
  }
  
  public final int getDuration()
  {
    return (int)this.mnK.meE.aGU;
  }
  
  public final boolean isPlaying()
  {
    return this.mnK.isPlaying();
  }
  
  public final void pause()
  {
    this.mnK.pause();
  }
  
  public final void prepareAsync()
  {
    this.mnK.prepare();
  }
  
  public final void release()
  {
    this.mnK.release();
  }
  
  public final void seekTo(int paramInt)
  {
    if (this.mnK != null)
    {
      y.i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", new Object[] { Integer.valueOf(paramInt) });
      this.mnK.tP(paramInt);
    }
  }
  
  public final void setAudioStreamType(int paramInt) {}
  
  public final void setDataSource(String paramString)
  {
    this.mnK.setPath(paramString);
  }
  
  public final void setLoop(int paramInt1, int paramInt2)
  {
    this.mnM = paramInt1;
    this.mnN = paramInt2;
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    this.eaP = paramBoolean;
  }
  
  public final void setSurface(Surface paramSurface)
  {
    this.mnK.setSurface(paramSurface);
  }
  
  public final void start()
  {
    if (this.PT) {
      this.mnK.start();
    }
    this.bSr = true;
  }
  
  public final void stop()
  {
    this.mnK.meE.stop();
    this.bSr = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.a.b
 * JD-Core Version:    0.7.0.1
 */