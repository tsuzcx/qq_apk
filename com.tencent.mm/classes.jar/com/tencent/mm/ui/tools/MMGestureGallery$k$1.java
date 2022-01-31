package com.tencent.mm.ui.tools;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MMGestureGallery$k$1
  implements Runnable
{
  MMGestureGallery$k$1(MMGestureGallery.k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(107674);
    MMGestureGallery.a(this.AvU.AvP).getImageMatrix().getValues(this.AvU.nhN);
    float f2 = this.AvU.nhN[5];
    float f1 = MMGestureGallery.a(this.AvU.AvP).getScale() * MMGestureGallery.a(this.AvU.AvP).getImageHeight();
    if (f1 < MMGestureGallery.d(this.AvU.AvP)) {}
    for (f1 = MMGestureGallery.d(this.AvU.AvP) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
    {
      f1 -= f2;
      if (f1 >= 0.0F) {
        this.AvU.bVC = true;
      }
      for (;;)
      {
        MMGestureGallery.a(this.AvU.AvP).ap(0.0F, f1);
        AppMethodBeat.o(107674);
        return;
        if (Math.abs(f1) <= 5.0F) {
          this.AvU.bVC = true;
        } else {
          f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.k.1
 * JD-Core Version:    0.7.0.1
 */