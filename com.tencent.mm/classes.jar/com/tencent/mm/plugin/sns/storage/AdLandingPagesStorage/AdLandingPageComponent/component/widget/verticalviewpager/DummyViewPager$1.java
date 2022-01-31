package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.support.v4.view.ViewPager.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DummyViewPager$1
  extends ViewPager.f
{
  DummyViewPager$1(DummyViewPager paramDummyViewPager) {}
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(37593);
    super.onPageScrollStateChanged(paramInt);
    if (paramInt == 0) {
      this.ryY.ryX = this.ryY.getScrollX();
    }
    AppMethodBeat.o(37593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager.1
 * JD-Core Version:    0.7.0.1
 */