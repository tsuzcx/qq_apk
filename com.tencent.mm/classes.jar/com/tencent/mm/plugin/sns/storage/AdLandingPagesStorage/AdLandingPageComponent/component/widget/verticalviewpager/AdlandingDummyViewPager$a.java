package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

final class AdlandingDummyViewPager$a
  implements ViewPager.OnPageChangeListener
{
  private AdlandingDummyViewPager$a(AdlandingDummyViewPager paramAdlandingDummyViewPager) {}
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(37591);
    if (paramInt == 0) {
      this.ryW.ryX = this.ryW.getScrollX();
    }
    Iterator localIterator = AdlandingDummyViewPager.a(this.ryW).iterator();
    while (localIterator.hasNext()) {
      ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrollStateChanged(paramInt);
    }
    AppMethodBeat.o(37591);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(37589);
    Iterator localIterator = AdlandingDummyViewPager.a(this.ryW).iterator();
    while (localIterator.hasNext()) {
      ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    AppMethodBeat.o(37589);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(37590);
    Iterator localIterator = AdlandingDummyViewPager.a(this.ryW).iterator();
    while (localIterator.hasNext()) {
      ((ViewPager.OnPageChangeListener)localIterator.next()).onPageSelected(paramInt);
    }
    AppMethodBeat.o(37590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager.a
 * JD-Core Version:    0.7.0.1
 */