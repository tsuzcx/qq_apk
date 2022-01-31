package com.tencent.mm.ui.tools;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MMGestureGallery$h$1
  implements Runnable
{
  MMGestureGallery$h$1(MMGestureGallery.h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(107665);
    MMGestureGallery.a(this.AvR.AvP).getImageMatrix().getValues(this.AvR.nhN);
    float f5 = MMGestureGallery.a(this.AvR.AvP).getScale() * MMGestureGallery.a(this.AvR.AvP).getImageWidth();
    float f1 = MMGestureGallery.a(this.AvR.AvP).getScale();
    float f8 = MMGestureGallery.a(this.AvR.AvP).getImageHeight() * f1;
    float f7 = this.AvR.nhN[2];
    float f10 = this.AvR.nhN[5];
    float f6 = this.AvR.nhN[2];
    float f9 = this.AvR.nhN[5];
    float f2 = 0.0F;
    f1 = MMGestureGallery.d(this.AvR.AvP);
    float f3 = 0.0F;
    float f4 = MMGestureGallery.b(this.AvR.AvP);
    if (f8 < MMGestureGallery.d(this.AvR.AvP))
    {
      f2 = MMGestureGallery.d(this.AvR.AvP) / 2.0F - f8 / 2.0F;
      f1 = MMGestureGallery.d(this.AvR.AvP) / 2.0F + f8 / 2.0F;
    }
    for (;;)
    {
      f2 -= f10;
      f1 -= f9 + f8;
      if (f2 < 0.0F) {
        f1 = f2;
      }
      for (;;)
      {
        if (f5 < MMGestureGallery.b(this.AvR.AvP))
        {
          f3 = MMGestureGallery.b(this.AvR.AvP) / 2.0F;
          f4 = f5 / 2.0F;
          f2 = MMGestureGallery.b(this.AvR.AvP) / 2.0F + f5 / 2.0F;
          f3 -= f4;
        }
        for (;;)
        {
          f3 -= f7;
          f2 -= f6 + f5;
          if (f3 < 0.0F) {
            f2 = f3;
          }
          for (;;)
          {
            label321:
            if ((Math.abs(f2) <= 5.0F) && (Math.abs(f1) <= 5.0F)) {
              this.AvR.bVC = true;
            }
            for (;;)
            {
              MMGestureGallery.a(this.AvR.AvP).ap(f2, f1);
              AppMethodBeat.o(107665);
              return;
              if (f1 <= 0.0F) {
                break label526;
              }
              break;
              if (f2 <= 0.0F) {
                break label515;
              }
              break label321;
              if (f2 >= 0.0F) {}
              for (f2 = (float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F;; f2 = -(float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F)
              {
                if (f1 < 0.0F) {
                  break label485;
                }
                f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                break;
              }
              label485:
              f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
            label515:
            f2 = 0.0F;
          }
          f2 = f4;
        }
        label526:
        f1 = 0.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.h.1
 * JD-Core Version:    0.7.0.1
 */