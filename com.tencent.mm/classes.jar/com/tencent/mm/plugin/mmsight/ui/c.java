package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
{
  int duration;
  long gmN;
  aw ijv;
  boolean isStart;
  private float wih;
  float wii;
  float wij;
  float wik;
  a wil;
  
  public c(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(94630);
    this.ijv = null;
    this.wih = 0.0F;
    this.wii = paramFloat1;
    this.wij = paramFloat2;
    this.duration = paramInt;
    this.wih = (100.0F / this.duration * 20.0F);
    ae.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Float.valueOf(this.wih) });
    this.isStart = false;
    this.gmN = 0L;
    this.ijv = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(94628);
        c localc = c.this;
        localc.wik = ((float)bu.aO(localc.gmN) / localc.duration * 100.0F + localc.wii);
        if (localc.wil != null) {
          localc.wil.bl(localc.wik);
        }
        if (c.this.isStart)
        {
          if (c.this.wik < c.this.wij)
          {
            AppMethodBeat.o(94628);
            return true;
          }
          c.this.isStart = false;
          ae.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", new Object[] { Float.valueOf(c.this.wik), Float.valueOf(c.this.wij), c.this.wil });
          if (c.this.wil != null) {
            c.this.wil.onAnimationEnd();
          }
          AppMethodBeat.o(94628);
          return false;
        }
        ae.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
        AppMethodBeat.o(94628);
        return false;
      }
    }, true);
    AppMethodBeat.o(94630);
  }
  
  public final void cancel()
  {
    this.isStart = false;
    this.gmN = 0L;
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