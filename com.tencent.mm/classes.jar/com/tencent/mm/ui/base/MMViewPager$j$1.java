package com.tencent.mm.ui.base;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMViewPager$j$1
  implements Runnable
{
  MMViewPager$j$1(MMViewPager.j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(106917);
    MMViewPager.a(this.znJ.znE).getImageMatrix().getValues(this.znJ.nhN);
    float f2 = this.znJ.nhN[5];
    float f1 = MMViewPager.a(this.znJ.znE).getScale() * MMViewPager.a(this.znJ.znE).getImageHeight();
    if (f1 < MMViewPager.d(this.znJ.znE)) {}
    for (f1 = MMViewPager.d(this.znJ.znE) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
    {
      f1 -= f2;
      if ((MMViewPager.a(this.znJ.znE) instanceof WxImageView)) {
        f1 = -((WxImageView)MMViewPager.a(this.znJ.znE)).getTranslationY();
      }
      if (f1 >= 0.0F) {
        this.znJ.bVC = true;
      }
      for (;;)
      {
        MMViewPager.a(this.znJ.znE).ap(0.0F, f1);
        if ((MMViewPager.a(this.znJ.znE) instanceof WxImageView)) {
          ((WxImageView)MMViewPager.a(this.znJ.znE)).translate(0.0F, f1);
        }
        AppMethodBeat.o(106917);
        return;
        if (Math.abs(f1) <= 5.0F) {
          this.znJ.bVC = true;
        } else {
          f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.j.1
 * JD-Core Version:    0.7.0.1
 */