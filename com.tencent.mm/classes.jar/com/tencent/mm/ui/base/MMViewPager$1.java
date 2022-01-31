package com.tencent.mm.ui.base;

import android.support.v4.view.ViewPager.e;

final class MMViewPager$1
  implements ViewPager.e
{
  MMViewPager$1(MMViewPager paramMMViewPager) {}
  
  public final void Q(int paramInt)
  {
    if (MMViewPager.f(this.uZn) != null) {
      MMViewPager.f(this.uZn).Q(paramInt);
    }
    if (paramInt == 0) {
      MMViewPager.a(this.uZn, 0.0F);
    }
  }
  
  public final void R(int paramInt)
  {
    MMViewPager.a(this.uZn, MMViewPager.e(this.uZn));
    MMViewPager.b(this.uZn, paramInt);
    if (MMViewPager.f(this.uZn) != null) {
      MMViewPager.f(this.uZn).R(paramInt);
    }
    g localg = MMViewPager.g(this.uZn);
    if ((localg != null) && ((localg instanceof WxImageView)))
    {
      MMViewPager.a(this.uZn, true);
      MMViewPager.h(this.uZn);
      return;
    }
    MMViewPager.a(this.uZn, false);
    MMViewPager.i(this.uZn);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (MMViewPager.f(this.uZn) != null) {
      MMViewPager.f(this.uZn).a(paramInt1, paramFloat, paramInt2);
    }
    MMViewPager.a(this.uZn, paramFloat);
    if ((paramInt2 == 0) && (MMViewPager.j(this.uZn) != -1)) {
      MMViewPager.c(this.uZn, MMViewPager.j(this.uZn));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.1
 * JD-Core Version:    0.7.0.1
 */