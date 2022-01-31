package com.tencent.mm.ui.base;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMViewPager$g$1
  implements Runnable
{
  MMViewPager$g$1(MMViewPager.g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(106908);
    MMViewPager.a(this.znG.znE).getImageMatrix().getValues(this.znG.nhN);
    float f5 = MMViewPager.a(this.znG.znE).getScale() * MMViewPager.a(this.znG.znE).getImageWidth();
    float f1 = MMViewPager.a(this.znG.znE).getScale();
    float f8 = MMViewPager.a(this.znG.znE).getImageHeight() * f1;
    float f7 = this.znG.nhN[2];
    float f10 = this.znG.nhN[5];
    float f6 = this.znG.nhN[2];
    float f9 = this.znG.nhN[5];
    float f2 = 0.0F;
    f1 = MMViewPager.d(this.znG.znE);
    float f3 = 0.0F;
    float f4 = MMViewPager.b(this.znG.znE);
    if (f8 < MMViewPager.d(this.znG.znE))
    {
      f2 = MMViewPager.d(this.znG.znE) / 2.0F - f8 / 2.0F;
      f1 = MMViewPager.d(this.znG.znE) / 2.0F + f8 / 2.0F;
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
        if (f5 < MMViewPager.b(this.znG.znE))
        {
          f3 = MMViewPager.b(this.znG.znE) / 2.0F;
          f4 = f5 / 2.0F;
          f2 = MMViewPager.b(this.znG.znE) / 2.0F + f5 / 2.0F;
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
            label331:
            if ((MMViewPager.a(this.znG.znE) instanceof WxImageView))
            {
              f2 = ((WxImageView)MMViewPager.a(this.znG.znE)).getTranslationX();
              f1 = ((WxImageView)MMViewPager.a(this.znG.znE)).getTranslationY();
            }
            if ((Math.abs(f2) <= 5.0F) && (Math.abs(f1) <= 5.0F)) {
              this.znG.bVC = true;
            }
            for (;;)
            {
              MMViewPager.a(this.znG.znE).ap(f2, f1);
              if ((MMViewPager.a(this.znG.znE) instanceof WxImageView)) {
                ((WxImageView)MMViewPager.a(this.znG.znE)).translate(-f2, -f1);
              }
              AppMethodBeat.o(106908);
              return;
              if (f1 <= 0.0F) {
                break label624;
              }
              break;
              if (f2 <= 0.0F) {
                break label613;
              }
              break label331;
              if (f2 >= 0.0F) {}
              for (f2 = (float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F;; f2 = -(float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F)
              {
                if (f1 < 0.0F) {
                  break label583;
                }
                f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                break;
              }
              label583:
              f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
            label613:
            f2 = 0.0F;
          }
          f2 = f4;
        }
        label624:
        f1 = 0.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.g.1
 * JD-Core Version:    0.7.0.1
 */