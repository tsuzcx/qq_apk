package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  int duration;
  long gXF;
  boolean isStart;
  MTimerHandler jer;
  private float zCH;
  float zCI;
  float zCJ;
  float zCK;
  a zCL;
  
  public c(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(94630);
    this.jer = null;
    this.zCH = 0.0F;
    this.zCI = paramFloat1;
    this.zCJ = paramFloat2;
    this.duration = paramInt;
    this.zCH = (100.0F / this.duration * 20.0F);
    Log.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Float.valueOf(this.zCH) });
    this.isStart = false;
    this.gXF = 0L;
    this.jer = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(94628);
        c localc = c.this;
        localc.zCK = ((float)Util.ticksToNow(localc.gXF) / localc.duration * 100.0F + localc.zCI);
        if (localc.zCL != null) {
          localc.zCL.bv(localc.zCK);
        }
        if (c.this.isStart)
        {
          if (c.this.zCK < c.this.zCJ)
          {
            AppMethodBeat.o(94628);
            return true;
          }
          c.this.isStart = false;
          Log.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", new Object[] { Float.valueOf(c.this.zCK), Float.valueOf(c.this.zCJ), c.this.zCL });
          if (c.this.zCL != null) {
            c.this.zCL.onAnimationEnd();
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
    this.gXF = 0L;
  }
  
  public static abstract interface a
  {
    public abstract void bv(float paramFloat);
    
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.c
 * JD-Core Version:    0.7.0.1
 */