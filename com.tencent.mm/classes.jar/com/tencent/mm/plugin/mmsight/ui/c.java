package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
{
  int duration;
  long fQT;
  au hNn;
  boolean isStart;
  private float uST;
  float uSU;
  float uSV;
  float uSW;
  a uSX;
  
  public c(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(94630);
    this.hNn = null;
    this.uST = 0.0F;
    this.uSU = paramFloat1;
    this.uSV = paramFloat2;
    this.duration = paramInt;
    this.uST = (100.0F / this.duration * 20.0F);
    ac.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Float.valueOf(this.uST) });
    this.isStart = false;
    this.fQT = 0L;
    this.hNn = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(94628);
        c localc = c.this;
        localc.uSW = ((float)bs.aO(localc.fQT) / localc.duration * 100.0F + localc.uSU);
        if (localc.uSX != null) {
          localc.uSX.bi(localc.uSW);
        }
        if (c.this.isStart)
        {
          if (c.this.uSW < c.this.uSV)
          {
            AppMethodBeat.o(94628);
            return true;
          }
          c.this.isStart = false;
          ac.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", new Object[] { Float.valueOf(c.this.uSW), Float.valueOf(c.this.uSV), c.this.uSX });
          if (c.this.uSX != null) {
            c.this.uSX.onAnimationEnd();
          }
          AppMethodBeat.o(94628);
          return false;
        }
        ac.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
        AppMethodBeat.o(94628);
        return false;
      }
    }, true);
    AppMethodBeat.o(94630);
  }
  
  public final void cancel()
  {
    this.isStart = false;
    this.fQT = 0L;
  }
  
  public static abstract interface a
  {
    public abstract void bi(float paramFloat);
    
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.c
 * JD-Core Version:    0.7.0.1
 */