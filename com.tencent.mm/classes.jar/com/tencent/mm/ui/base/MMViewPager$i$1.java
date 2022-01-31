package com.tencent.mm.ui.base;

import android.graphics.Matrix;

final class MMViewPager$i$1
  implements Runnable
{
  MMViewPager$i$1(MMViewPager.i parami) {}
  
  public final void run()
  {
    MMViewPager.a(this.uZr.uZn).getImageMatrix().getValues(this.uZr.kLk);
    float f1 = MMViewPager.a(this.uZr.uZn).getScale();
    float f2 = MMViewPager.a(this.uZr.uZn).getImageWidth() * f1;
    float f3 = this.uZr.kLk[2];
    f1 = MMViewPager.b(this.uZr.uZn);
    if (f2 < MMViewPager.b(this.uZr.uZn)) {
      f1 = MMViewPager.b(this.uZr.uZn) / 2.0F + f2 / 2.0F;
    }
    f1 -= f3 + f2;
    if ((MMViewPager.a(this.uZr.uZn) instanceof WxImageView)) {
      f1 = -((WxImageView)MMViewPager.a(this.uZr.uZn)).getTranslationX();
    }
    if (f1 <= 0.0F) {
      this.uZr.bur = true;
    }
    for (;;)
    {
      MMViewPager.a(this.uZr.uZn).ae(f1, 0.0F);
      if ((MMViewPager.a(this.uZr.uZn) instanceof WxImageView)) {
        ((WxImageView)MMViewPager.a(this.uZr.uZn)).translate(f1, 0.0F);
      }
      return;
      if (Math.abs(f1) <= 5.0F) {
        this.uZr.bur = true;
      } else {
        f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.i.1
 * JD-Core Version:    0.7.0.1
 */