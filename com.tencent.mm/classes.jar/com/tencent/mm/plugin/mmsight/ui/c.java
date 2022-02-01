package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  private float FhD;
  float FhE;
  float FhF;
  float FhG;
  a FhH;
  int duration;
  boolean isStart;
  long jID;
  MTimerHandler lUQ;
  
  public c(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(94630);
    this.lUQ = null;
    this.FhD = 0.0F;
    this.FhE = paramFloat1;
    this.FhF = paramFloat2;
    this.duration = paramInt;
    this.FhD = (100.0F / this.duration * 20.0F);
    Log.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Float.valueOf(this.FhD) });
    this.isStart = false;
    this.jID = 0L;
    this.lUQ = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(94628);
        c localc = c.this;
        localc.FhG = ((float)Util.ticksToNow(localc.jID) / localc.duration * 100.0F + localc.FhE);
        if (localc.FhH != null) {
          localc.FhH.bx(localc.FhG);
        }
        if (c.this.isStart)
        {
          if (c.this.FhG < c.this.FhF)
          {
            AppMethodBeat.o(94628);
            return true;
          }
          c.this.isStart = false;
          Log.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", new Object[] { Float.valueOf(c.this.FhG), Float.valueOf(c.this.FhF), c.this.FhH });
          if (c.this.FhH != null) {
            c.this.FhH.onAnimationEnd();
          }
          AppMethodBeat.o(94628);
          return false;
        }
        Log.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
        AppMethodBeat.o(94628);
        return false;
      }
    }, true);
    AppMethodBeat.o(94630);
  }
  
  public final void cancel()
  {
    this.isStart = false;
    this.jID = 0L;
  }
  
  public static abstract interface a
  {
    public abstract void bx(float paramFloat);
    
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.c
 * JD-Core Version:    0.7.0.1
 */