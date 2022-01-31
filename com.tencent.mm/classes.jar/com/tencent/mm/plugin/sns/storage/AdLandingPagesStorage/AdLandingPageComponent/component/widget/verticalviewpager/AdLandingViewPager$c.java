package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.d;
import android.support.v4.view.q;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AdLandingViewPager$c
  extends a
{
  AdLandingViewPager$c(AdLandingViewPager paramAdLandingViewPager) {}
  
  private boolean dI()
  {
    AppMethodBeat.i(37509);
    if ((AdLandingViewPager.b(this.ryT) != null) && (AdLandingViewPager.b(this.ryT).getCount() > 1))
    {
      AppMethodBeat.o(37509);
      return true;
    }
    AppMethodBeat.o(37509);
    return false;
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(37506);
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(AdLandingViewPager.class.getName());
    paramView = d.dL();
    paramView.setScrollable(dI());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (AdLandingViewPager.b(this.ryT) != null))
    {
      paramView.setItemCount(AdLandingViewPager.b(this.ryT).getCount());
      paramView.setFromIndex(AdLandingViewPager.c(this.ryT));
      paramView.setToIndex(AdLandingViewPager.c(this.ryT));
    }
    AppMethodBeat.o(37506);
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, b paramb)
  {
    AppMethodBeat.i(37507);
    super.onInitializeAccessibilityNodeInfo(paramView, paramb);
    paramb.setClassName(AdLandingViewPager.class.getName());
    paramb.setScrollable(dI());
    if (this.ryT.canScrollHorizontally(1)) {
      paramb.addAction(4096);
    }
    if (this.ryT.canScrollHorizontally(-1)) {
      paramb.addAction(8192);
    }
    AppMethodBeat.o(37507);
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(37508);
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
    {
      AppMethodBeat.o(37508);
      return true;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(37508);
      return false;
    case 4096: 
      if (this.ryT.canScrollHorizontally(1))
      {
        this.ryT.setCurrentItem(AdLandingViewPager.c(this.ryT) + 1);
        AppMethodBeat.o(37508);
        return true;
      }
      AppMethodBeat.o(37508);
      return false;
    }
    if (this.ryT.canScrollHorizontally(-1))
    {
      this.ryT.setCurrentItem(AdLandingViewPager.c(this.ryT) - 1);
      AppMethodBeat.o(37508);
      return true;
    }
    AppMethodBeat.o(37508);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.c
 * JD-Core Version:    0.7.0.1
 */