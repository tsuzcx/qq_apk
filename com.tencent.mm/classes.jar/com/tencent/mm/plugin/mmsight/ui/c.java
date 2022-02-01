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
  long gkt;
  av igC;
  boolean isStart;
  private float vWd;
  float vWe;
  float vWf;
  float vWg;
  a vWh;
  
  public c(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(94630);
    this.igC = null;
    this.vWd = 0.0F;
    this.vWe = paramFloat1;
    this.vWf = paramFloat2;
    this.duration = paramInt;
    this.vWd = (100.0F / this.duration * 20.0F);
    ad.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Float.valueOf(this.vWd) });
    this.isStart = false;
    this.gkt = 0L;
    this.igC = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(94628);
        c localc = c.this;
        localc.vWg = ((float)bt.aO(localc.gkt) / localc.duration * 100.0F + localc.vWe);
        if (localc.vWh != null) {
          localc.vWh.bl(localc.vWg);
        }
        if (c.this.isStart)
        {
          if (c.this.vWg < c.this.vWf)
          {
            AppMethodBeat.o(94628);
            return true;
          }
          c.this.isStart = false;
          ad.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", new Object[] { Float.valueOf(c.this.vWg), Float.valueOf(c.this.vWf), c.this.vWh });
          if (c.this.vWh != null) {
            c.this.vWh.onAnimationEnd();
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
    this.gkt = 0L;
  }
  
  public static abstract interface a
  {
    public abstract void bl(float paramFloat);
    
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.c
 * JD-Core Version:    0.7.0.1
 */