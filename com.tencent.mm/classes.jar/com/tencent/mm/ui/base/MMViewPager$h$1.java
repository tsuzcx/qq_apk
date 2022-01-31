package com.tencent.mm.ui.base;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMViewPager$h$1
  implements Runnable
{
  MMViewPager$h$1(MMViewPager.h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(106911);
    MMViewPager.a(this.znH.znE).getImageMatrix().getValues(this.znH.nhN);
    float f2 = this.znH.nhN[2];
    float f1 = MMViewPager.a(this.znH.znE).getScale() * MMViewPager.a(this.znH.znE).getImageWidth();
    if (f1 < MMViewPager.b(this.znH.znE)) {}
    for (f1 = MMViewPager.b(this.znH.znE) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
    {
      f1 -= f2;
      if ((MMViewPager.a(this.znH.znE) instanceof WxImageView)) {
        f1 = -((WxImageView)MMViewPager.a(this.znH.znE)).getTranslationX();
      }
      if (f1 >= 0.0F) {
        this.znH.bVC = true;
      }
      for (;;)
      {
        MMViewPager.a(this.znH.znE).ap(f1, 0.0F);
        if ((MMViewPager.a(this.znH.znE) instanceof WxImageView)) {
          ((WxImageView)MMViewPager.a(this.znH.znE)).translate(f1, 0.0F);
        }
        AppMethodBeat.o(106911);
        return;
        if (Math.abs(f1) <= 5.0F) {
          this.znH.bVC = true;
        } else {
          f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.h.1
 * JD-Core Version:    0.7.0.1
 */