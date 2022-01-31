package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public final class c
{
  private int duration;
  float end;
  long ewN;
  ap fJH;
  boolean isStart;
  private float oPd;
  float oPe;
  c.a oPf;
  private Runnable oPg;
  private float start;
  
  public c(float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(55178);
    this.fJH = null;
    this.oPd = 0.0F;
    this.oPg = new c.2(this);
    this.start = paramFloat1;
    this.end = paramFloat2;
    this.duration = paramInt;
    if (paramFloat2 > paramFloat1) {
      this.oPd = ((paramFloat2 - paramFloat1) / this.duration * 20.0F);
    }
    ab.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt), Float.valueOf(this.oPd) });
    this.isStart = false;
    this.ewN = 0L;
    this.fJH = new ap(Looper.getMainLooper(), new c.1(this), true);
    AppMethodBeat.o(55178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.c
 * JD-Core Version:    0.7.0.1
 */