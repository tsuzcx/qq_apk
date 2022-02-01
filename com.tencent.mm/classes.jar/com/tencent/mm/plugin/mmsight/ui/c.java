package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
{
  int duration;
  long fNi;
  av hmK;
  boolean isStart;
  private float tKm;
  float tKn;
  float tKo;
  float tKp;
  a tKq;
  
  public c(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(94630);
    this.hmK = null;
    this.tKm = 0.0F;
    this.tKn = paramFloat1;
    this.tKo = paramFloat2;
    this.duration = paramInt;
    this.tKm = (100.0F / this.duration * 20.0F);
    ad.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Float.valueOf(this.tKm) });
    this.isStart = false;
    this.fNi = 0L;
    this.hmK = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(94628);
        c localc = c.this;
        localc.tKp = ((float)bt.aS(localc.fNi) / localc.duration * 100.0F + localc.tKn);
        if (localc.tKq != null) {
          localc.tKq.bb(localc.tKp);
        }
        if (c.this.isStart)
        {
          if (c.this.tKp < c.this.tKo)
          {
            AppMethodBeat.o(94628);
            return true;
          }
          c.this.isStart = false;
          ad.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", new Object[] { Float.valueOf(c.this.tKp), Float.valueOf(c.this.tKo), c.this.tKq });
          if (c.this.tKq != null) {
            c.this.tKq.onAnimationEnd();
          }
          AppMethodBeat.o(94628);
          return false;
        }
        ad.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
        AppMethodBeat.o(94628);
        return false;
      }
    }, true);
    AppMethodBeat.o(94630);
  }
  
  public final void cancel()
  {
    this.isStart = false;
    this.fNi = 0L;
  }
  
  public static abstract interface a
  {
    public abstract void bb(float paramFloat);
    
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.c
 * JD-Core Version:    0.7.0.1
 */