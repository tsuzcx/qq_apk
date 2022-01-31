package com.tencent.mm.ui.base;

import android.graphics.Matrix;

final class MMViewPager$h$1
  implements Runnable
{
  MMViewPager$h$1(MMViewPager.h paramh) {}
  
  public final void run()
  {
    MMViewPager.a(this.uZq.uZn).getImageMatrix().getValues(this.uZq.kLk);
    float f2 = this.uZq.kLk[2];
    float f1 = MMViewPager.a(this.uZq.uZn).getScale() * MMViewPager.a(this.uZq.uZn).getImageWidth();
    if (f1 < MMViewPager.b(this.uZq.uZn)) {}
    for (f1 = MMViewPager.b(this.uZq.uZn) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
    {
      f1 -= f2;
      if ((MMViewPager.a(this.uZq.uZn) instanceof WxImageView)) {
        f1 = -((WxImageView)MMViewPager.a(this.uZq.uZn)).getTranslationX();
      }
      if (f1 >= 0.0F) {
        this.uZq.bur = true;
      }
      for (;;)
      {
        MMViewPager.a(this.uZq.uZn).ae(f1, 0.0F);
        if ((MMViewPager.a(this.uZq.uZn) instanceof WxImageView)) {
          ((WxImageView)MMViewPager.a(this.uZq.uZn)).translate(f1, 0.0F);
        }
        return;
        if (Math.abs(f1) <= 5.0F) {
          this.uZq.bur = true;
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