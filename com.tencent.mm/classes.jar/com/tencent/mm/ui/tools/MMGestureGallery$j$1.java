package com.tencent.mm.ui.tools;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MMGestureGallery$j$1
  implements Runnable
{
  MMGestureGallery$j$1(MMGestureGallery.j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(107671);
    MMGestureGallery.a(this.AvT.AvP).getImageMatrix().getValues(this.AvT.nhN);
    float f1 = MMGestureGallery.a(this.AvT.AvP).getScale();
    float f2 = MMGestureGallery.a(this.AvT.AvP).getImageWidth() * f1;
    float f3 = this.AvT.nhN[2];
    f1 = MMGestureGallery.b(this.AvT.AvP);
    if (f2 < MMGestureGallery.b(this.AvT.AvP)) {
      f1 = MMGestureGallery.b(this.AvT.AvP) / 2.0F + f2 / 2.0F;
    }
    f1 -= f3 + f2;
    if (f1 <= 0.0F) {
      this.AvT.bVC = true;
    }
    for (;;)
    {
      MMGestureGallery.a(this.AvT.AvP).ap(f1, 0.0F);
      AppMethodBeat.o(107671);
      return;
      if (Math.abs(f1) <= 5.0F) {
        this.AvT.bVC = true;
      } else {
        f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.j.1
 * JD-Core Version:    0.7.0.1
 */