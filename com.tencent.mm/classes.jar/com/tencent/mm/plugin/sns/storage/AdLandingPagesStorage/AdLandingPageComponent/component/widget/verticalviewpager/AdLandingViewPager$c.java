package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.os.Bundle;
import android.support.v4.view.a.c;
import android.support.v4.view.n;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

final class AdLandingViewPager$c
  extends android.support.v4.view.a
{
  AdLandingViewPager$c(AdLandingViewPager paramAdLandingViewPager) {}
  
  private boolean dt()
  {
    return (AdLandingViewPager.b(this.oIY) != null) && (AdLandingViewPager.b(this.oIY).getCount() > 1);
  }
  
  public final void a(View paramView, android.support.v4.view.a.a parama)
  {
    super.a(paramView, parama);
    parama.setClassName(AdLandingViewPager.class.getName());
    parama.setScrollable(dt());
    if (this.oIY.canScrollHorizontally(1)) {
      parama.addAction(4096);
    }
    if (this.oIY.canScrollHorizontally(-1)) {
      parama.addAction(8192);
    }
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(AdLandingViewPager.class.getName());
    paramView = c.dw();
    paramView.setScrollable(dt());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (AdLandingViewPager.b(this.oIY) != null))
    {
      paramView.setItemCount(AdLandingViewPager.b(this.oIY).getCount());
      paramView.setFromIndex(AdLandingViewPager.c(this.oIY));
      paramView.setToIndex(AdLandingViewPager.c(this.oIY));
    }
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 4096: 
      if (this.oIY.canScrollHorizontally(1))
      {
        this.oIY.setCurrentItem(AdLandingViewPager.c(this.oIY) + 1);
        return true;
      }
      return false;
    }
    if (this.oIY.canScrollHorizontally(-1))
    {
      this.oIY.setCurrentItem(AdLandingViewPager.c(this.oIY) - 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.c
 * JD-Core Version:    0.7.0.1
 */