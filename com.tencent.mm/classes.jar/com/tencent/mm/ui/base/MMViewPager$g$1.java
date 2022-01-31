package com.tencent.mm.ui.base;

import android.graphics.Matrix;

final class MMViewPager$g$1
  implements Runnable
{
  MMViewPager$g$1(MMViewPager.g paramg) {}
  
  public final void run()
  {
    MMViewPager.a(this.uZp.uZn).getImageMatrix().getValues(this.uZp.kLk);
    float f5 = MMViewPager.a(this.uZp.uZn).getScale() * MMViewPager.a(this.uZp.uZn).getImageWidth();
    float f1 = MMViewPager.a(this.uZp.uZn).getScale();
    float f8 = MMViewPager.a(this.uZp.uZn).getImageHeight() * f1;
    float f7 = this.uZp.kLk[2];
    float f10 = this.uZp.kLk[5];
    float f6 = this.uZp.kLk[2];
    float f9 = this.uZp.kLk[5];
    float f2 = 0.0F;
    f1 = MMViewPager.d(this.uZp.uZn);
    float f3 = 0.0F;
    float f4 = MMViewPager.b(this.uZp.uZn);
    if (f8 < MMViewPager.d(this.uZp.uZn))
    {
      f2 = MMViewPager.d(this.uZp.uZn) / 2.0F - f8 / 2.0F;
      f1 = MMViewPager.d(this.uZp.uZn) / 2.0F + f8 / 2.0F;
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
        if (f5 < MMViewPager.b(this.uZp.uZn))
        {
          f3 = MMViewPager.b(this.uZp.uZn) / 2.0F;
          f4 = f5 / 2.0F;
          f2 = MMViewPager.b(this.uZp.uZn) / 2.0F + f5 / 2.0F;
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
            label326:
            if ((MMViewPager.a(this.uZp.uZn) instanceof WxImageView))
            {
              f2 = ((WxImageView)MMViewPager.a(this.uZp.uZn)).getTranslationX();
              f1 = ((WxImageView)MMViewPager.a(this.uZp.uZn)).getTranslationY();
            }
            if ((Math.abs(f2) <= 5.0F) && (Math.abs(f1) <= 5.0F)) {
              this.uZp.bur = true;
            }
            for (;;)
            {
              MMViewPager.a(this.uZp.uZn).ae(f2, f1);
              if ((MMViewPager.a(this.uZp.uZn) instanceof WxImageView)) {
                ((WxImageView)MMViewPager.a(this.uZp.uZn)).translate(-f2, -f1);
              }
              return;
              if (f1 <= 0.0F) {
                break label614;
              }
              break;
              if (f2 <= 0.0F) {
                break label603;
              }
              break label326;
              if (f2 >= 0.0F) {}
              for (f2 = (float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F;; f2 = -(float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F)
              {
                if (f1 < 0.0F) {
                  break label573;
                }
                f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                break;
              }
              label573:
              f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
            label603:
            f2 = 0.0F;
          }
          f2 = f4;
        }
        label614:
        f1 = 0.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.g.1
 * JD-Core Version:    0.7.0.1
 */