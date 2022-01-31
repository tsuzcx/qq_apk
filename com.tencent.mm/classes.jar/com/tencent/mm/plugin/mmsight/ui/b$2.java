package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    b.a(this.mpI);
    if (this.mpI.bSr)
    {
      if (this.mpI.mpF < this.mpI.mpE) {
        this.mpI.etU.post(this);
      }
      do
      {
        return;
        this.mpI.bSr = false;
        y.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s", new Object[] { Float.valueOf(this.mpI.mpF), Float.valueOf(this.mpI.mpE) });
      } while (this.mpI.mpG == null);
      this.mpI.mpG.onAnimationEnd();
      return;
    }
    y.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.b.2
 * JD-Core Version:    0.7.0.1
 */