package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  boolean bSr;
  private int duration;
  am etU = null;
  long iZh;
  private float mpC = 0.0F;
  private float mpD;
  float mpE;
  float mpF;
  b.a mpG;
  private Runnable mpH = new b.2(this);
  
  public b(float paramFloat1, float paramFloat2, int paramInt)
  {
    this.mpD = paramFloat1;
    this.mpE = paramFloat2;
    this.duration = paramInt;
    if (paramFloat2 > paramFloat1) {
      this.mpC = ((paramFloat2 - paramFloat1) / this.duration * 20.0F);
    }
    y.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Float.valueOf(this.mpC) });
    this.bSr = false;
    this.iZh = 0L;
    this.etU = new am(Looper.getMainLooper(), new am.a()
    {
      public final boolean tC()
      {
        b.a(b.this);
        if (b.this.bSr)
        {
          if (b.this.mpF < b.this.mpE) {
            return true;
          }
          b.this.bSr = false;
          y.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", new Object[] { Float.valueOf(b.this.mpF), Float.valueOf(b.this.mpE), b.this.mpG });
          if (b.this.mpG != null) {
            b.this.mpG.onAnimationEnd();
          }
          return false;
        }
        y.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
        return false;
      }
    }, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b
 * JD-Core Version:    0.7.0.1
 */