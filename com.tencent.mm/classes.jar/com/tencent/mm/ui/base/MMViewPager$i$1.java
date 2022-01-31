package com.tencent.mm.ui.base;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMViewPager$i$1
  implements Runnable
{
  MMViewPager$i$1(MMViewPager.i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(106914);
    MMViewPager.a(this.znI.znE).getImageMatrix().getValues(this.znI.nhN);
    float f1 = MMViewPager.a(this.znI.znE).getScale();
    float f2 = MMViewPager.a(this.znI.znE).getImageWidth() * f1;
    float f3 = this.znI.nhN[2];
    f1 = MMViewPager.b(this.znI.znE);
    if (f2 < MMViewPager.b(this.znI.znE)) {
      f1 = MMViewPager.b(this.znI.znE) / 2.0F + f2 / 2.0F;
    }
    f1 -= f3 + f2;
    if ((MMViewPager.a(this.znI.znE) instanceof WxImageView)) {
      f1 = -((WxImageView)MMViewPager.a(this.znI.znE)).getTranslationX();
    }
    if (f1 <= 0.0F) {
      this.znI.bVC = true;
    }
    for (;;)
    {
      MMViewPager.a(this.znI.znE).ap(f1, 0.0F);
      if ((MMViewPager.a(this.znI.znE) instanceof WxImageView)) {
        ((WxImageView)MMViewPager.a(this.znI.znE)).translate(f1, 0.0F);
      }
      AppMethodBeat.o(106914);
      return;
      if (Math.abs(f1) <= 5.0F) {
        this.znI.bVC = true;
      } else {
        f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.i.1
 * JD-Core Version:    0.7.0.1
 */