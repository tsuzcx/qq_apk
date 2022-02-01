package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  private float Lde;
  float Ldf;
  a Ldg;
  float adl;
  float adm;
  int duration;
  boolean isStart;
  long moe;
  MTimerHandler oNL;
  
  public c(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(94630);
    this.oNL = null;
    this.Lde = 0.0F;
    this.adl = paramFloat1;
    this.adm = paramFloat2;
    this.duration = paramInt;
    this.Lde = (100.0F / this.duration * 20.0F);
    Log.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Float.valueOf(this.Lde) });
    this.isStart = false;
    this.moe = 0L;
    this.oNL = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(94628);
        c localc = c.this;
        localc.Ldf = ((float)Util.ticksToNow(localc.moe) / localc.duration * 100.0F + localc.adl);
        if (localc.Ldg != null) {
          localc.Ldg.cB(localc.Ldf);
        }
        if (c.this.isStart)
        {
          if (c.this.Ldf < c.this.adm)
          {
            AppMethodBeat.o(94628);
            return true;
          }
          c.this.isStart = false;
          Log.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", new Object[] { Float.valueOf(c.this.Ldf), Float.valueOf(c.this.adm), c.this.Ldg });
          if (c.this.Ldg != null) {
            c.this.Ldg.onAnimationEnd();
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
    this.moe = 0L;
  }
  
  public static abstract interface a
  {
    public abstract void cB(float paramFloat);
    
    public abstract void onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.c
 * JD-Core Version:    0.7.0.1
 */