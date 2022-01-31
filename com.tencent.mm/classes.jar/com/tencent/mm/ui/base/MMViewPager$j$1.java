package com.tencent.mm.ui.base;

import android.graphics.Matrix;

final class MMViewPager$j$1
  implements Runnable
{
  MMViewPager$j$1(MMViewPager.j paramj) {}
  
  public final void run()
  {
    MMViewPager.a(this.uZs.uZn).getImageMatrix().getValues(this.uZs.kLk);
    float f2 = this.uZs.kLk[5];
    float f1 = MMViewPager.a(this.uZs.uZn).getScale() * MMViewPager.a(this.uZs.uZn).getImageHeight();
    if (f1 < MMViewPager.d(this.uZs.uZn)) {}
    for (f1 = MMViewPager.d(this.uZs.uZn) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
    {
      f1 -= f2;
      if ((MMViewPager.a(this.uZs.uZn) instanceof WxImageView)) {
        f1 = -((WxImageView)MMViewPager.a(this.uZs.uZn)).getTranslationY();
      }
      if (f1 >= 0.0F) {
        this.uZs.bur = true;
      }
      for (;;)
      {
        MMViewPager.a(this.uZs.uZn).ae(0.0F, f1);
        if ((MMViewPager.a(this.uZs.uZn) instanceof WxImageView)) {
          ((WxImageView)MMViewPager.a(this.uZs.uZn)).translate(0.0F, f1);
        }
        return;
        if (Math.abs(f1) <= 5.0F) {
          this.uZs.bur = true;
        } else {
          f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.j.1
 * JD-Core Version:    0.7.0.1
 */