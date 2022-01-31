package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.support.v4.view.ViewPager.e;
import java.util.Iterator;
import java.util.Set;

final class AdlandingDummyViewPager$a
  implements ViewPager.e
{
  private AdlandingDummyViewPager$a(AdlandingDummyViewPager paramAdlandingDummyViewPager) {}
  
  public final void Q(int paramInt)
  {
    if (paramInt == 0) {
      this.oJb.oJc = this.oJb.getScrollX();
    }
    Iterator localIterator = AdlandingDummyViewPager.a(this.oJb).iterator();
    while (localIterator.hasNext()) {
      ((ViewPager.e)localIterator.next()).Q(paramInt);
    }
  }
  
  public final void R(int paramInt)
  {
    Iterator localIterator = AdlandingDummyViewPager.a(this.oJb).iterator();
    while (localIterator.hasNext()) {
      ((ViewPager.e)localIterator.next()).R(paramInt);
    }
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2)
  {
    Iterator localIterator = AdlandingDummyViewPager.a(this.oJb).iterator();
    while (localIterator.hasNext()) {
      ((ViewPager.e)localIterator.next()).a(paramInt1, paramFloat, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager.a
 * JD-Core Version:    0.7.0.1
 */