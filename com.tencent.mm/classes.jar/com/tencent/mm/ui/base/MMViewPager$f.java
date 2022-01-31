package com.tencent.mm.ui.base;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class MMViewPager$f
  extends MMViewPager.a
{
  float[] nhN;
  
  public MMViewPager$f(MMViewPager paramMMViewPager)
  {
    super(paramMMViewPager);
    AppMethodBeat.i(106906);
    this.nhN = new float[9];
    AppMethodBeat.o(106906);
  }
  
  public final void play()
  {
    AppMethodBeat.i(106907);
    MMViewPager.c(this.znE).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106905);
        MMViewPager.a(MMViewPager.f.this.znE).getImageMatrix().getValues(MMViewPager.f.this.nhN);
        float f1 = MMViewPager.a(MMViewPager.f.this.znE).getScale();
        float f2 = MMViewPager.a(MMViewPager.f.this.znE).getImageHeight() * f1;
        float f3 = MMViewPager.f.this.nhN[5];
        f1 = MMViewPager.d(MMViewPager.f.this.znE);
        if (f2 < MMViewPager.d(MMViewPager.f.this.znE)) {
          f1 = MMViewPager.d(MMViewPager.f.this.znE) / 2.0F + f2 / 2.0F;
        }
        f1 -= f3 + f2;
        if ((MMViewPager.a(MMViewPager.f.this.znE) instanceof WxImageView)) {
          f1 = -((WxImageView)MMViewPager.a(MMViewPager.f.this.znE)).getTranslationY();
        }
        if (f1 <= 0.0F) {
          MMViewPager.f.this.bVC = true;
        }
        for (;;)
        {
          MMViewPager.a(MMViewPager.f.this.znE).ap(0.0F, f1);
          if ((MMViewPager.a(MMViewPager.f.this.znE) instanceof WxImageView)) {
            ((WxImageView)MMViewPager.a(MMViewPager.f.this.znE)).translate(0.0F, f1);
          }
          AppMethodBeat.o(106905);
          return;
          if (Math.abs(f1) <= 5.0F) {
            MMViewPager.f.this.bVC = true;
          } else {
            f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
          }
        }
      }
    });
    AppMethodBeat.o(106907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.f
 * JD-Core Version:    0.7.0.1
 */