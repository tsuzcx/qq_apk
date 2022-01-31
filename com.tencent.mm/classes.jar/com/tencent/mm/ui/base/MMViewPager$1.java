package com.tencent.mm.ui.base;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMViewPager$1
  implements ViewPager.OnPageChangeListener
{
  MMViewPager$1(MMViewPager paramMMViewPager) {}
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(106897);
    if (MMViewPager.f(this.znE) != null) {
      MMViewPager.f(this.znE).onPageScrollStateChanged(paramInt);
    }
    if (paramInt == 0) {
      MMViewPager.a(this.znE, 0.0F);
    }
    AppMethodBeat.o(106897);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(106896);
    if (MMViewPager.f(this.znE) != null) {
      MMViewPager.f(this.znE).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    MMViewPager.a(this.znE, paramFloat);
    if ((paramInt2 == 0) && (MMViewPager.j(this.znE) != -1)) {
      MMViewPager.c(this.znE, MMViewPager.j(this.znE));
    }
    AppMethodBeat.o(106896);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(106895);
    MMViewPager.a(this.znE, MMViewPager.e(this.znE));
    MMViewPager.b(this.znE, paramInt);
    if (MMViewPager.f(this.znE) != null) {
      MMViewPager.f(this.znE).onPageSelected(paramInt);
    }
    if (MMViewPager.g(this.znE))
    {
      MMViewPager.h(this.znE);
      AppMethodBeat.o(106895);
      return;
    }
    MMViewPager.i(this.znE);
    AppMethodBeat.o(106895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.1
 * JD-Core Version:    0.7.0.1
 */