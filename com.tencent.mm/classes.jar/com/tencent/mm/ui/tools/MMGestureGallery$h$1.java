package com.tencent.mm.ui.tools;

import android.graphics.Matrix;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MMGestureGallery$h$1
  implements Runnable
{
  MMGestureGallery$h$1(MMGestureGallery.h paramh) {}
  
  public final void run()
  {
    MMGestureGallery.a(this.wdk.wdi).getImageMatrix().getValues(this.wdk.kLk);
    float f5 = MMGestureGallery.a(this.wdk.wdi).getScale() * MMGestureGallery.a(this.wdk.wdi).getImageWidth();
    float f1 = MMGestureGallery.a(this.wdk.wdi).getScale();
    float f8 = MMGestureGallery.a(this.wdk.wdi).getImageHeight() * f1;
    float f7 = this.wdk.kLk[2];
    float f10 = this.wdk.kLk[5];
    float f6 = this.wdk.kLk[2];
    float f9 = this.wdk.kLk[5];
    float f2 = 0.0F;
    f1 = MMGestureGallery.d(this.wdk.wdi);
    float f3 = 0.0F;
    float f4 = MMGestureGallery.b(this.wdk.wdi);
    if (f8 < MMGestureGallery.d(this.wdk.wdi))
    {
      f2 = MMGestureGallery.d(this.wdk.wdi) / 2.0F - f8 / 2.0F;
      f1 = MMGestureGallery.d(this.wdk.wdi) / 2.0F + f8 / 2.0F;
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
        if (f5 < MMGestureGallery.b(this.wdk.wdi))
        {
          f3 = MMGestureGallery.b(this.wdk.wdi) / 2.0F;
          f4 = f5 / 2.0F;
          f2 = MMGestureGallery.b(this.wdk.wdi) / 2.0F + f5 / 2.0F;
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
            label316:
            if ((Math.abs(f2) <= 5.0F) && (Math.abs(f1) <= 5.0F)) {
              this.wdk.bur = true;
            }
            for (;;)
            {
              MMGestureGallery.a(this.wdk.wdi).ae(f2, f1);
              return;
              if (f1 <= 0.0F) {
                break label516;
              }
              break;
              if (f2 <= 0.0F) {
                break label505;
              }
              break label316;
              if (f2 >= 0.0F) {}
              for (f2 = (float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F;; f2 = -(float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F)
              {
                if (f1 < 0.0F) {
                  break label475;
                }
                f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                break;
              }
              label475:
              f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
            label505:
            f2 = 0.0F;
          }
          f2 = f4;
        }
        label516:
        f1 = 0.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.h.1
 * JD-Core Version:    0.7.0.1
 */