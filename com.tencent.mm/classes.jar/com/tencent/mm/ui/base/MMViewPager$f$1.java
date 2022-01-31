package com.tencent.mm.ui.base;

import android.graphics.Matrix;

final class MMViewPager$f$1
  implements Runnable
{
  MMViewPager$f$1(MMViewPager.f paramf) {}
  
  public final void run()
  {
    MMViewPager.a(this.uZo.uZn).getImageMatrix().getValues(this.uZo.kLk);
    float f1 = MMViewPager.a(this.uZo.uZn).getScale();
    float f2 = MMViewPager.a(this.uZo.uZn).getImageHeight() * f1;
    float f3 = this.uZo.kLk[5];
    f1 = MMViewPager.d(this.uZo.uZn);
    if (f2 < MMViewPager.d(this.uZo.uZn)) {
      f1 = MMViewPager.d(this.uZo.uZn) / 2.0F + f2 / 2.0F;
    }
    f1 -= f3 + f2;
    if ((MMViewPager.a(this.uZo.uZn) instanceof WxImageView)) {
      f1 = -((WxImageView)MMViewPager.a(this.uZo.uZn)).getTranslationY();
    }
    if (f1 <= 0.0F) {
      this.uZo.bur = true;
    }
    for (;;)
    {
      MMViewPager.a(this.uZo.uZn).ae(0.0F, f1);
      if ((MMViewPager.a(this.uZo.uZn) instanceof WxImageView)) {
        ((WxImageView)MMViewPager.a(this.uZo.uZn)).translate(0.0F, f1);
      }
      return;
      if (Math.abs(f1) <= 5.0F) {
        this.uZo.bur = true;
      } else {
        f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.f.1
 * JD-Core Version:    0.7.0.1
 */