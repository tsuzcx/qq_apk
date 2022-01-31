package com.tencent.mm.ui.mogic;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.d;
import android.support.v4.view.q;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxViewPager$c
  extends a
{
  WxViewPager$c(WxViewPager paramWxViewPager) {}
  
  private boolean dI()
  {
    AppMethodBeat.i(107458);
    if ((WxViewPager.access$200(this.Apx) != null) && (WxViewPager.access$200(this.Apx).getCount() > 1))
    {
      AppMethodBeat.o(107458);
      return true;
    }
    AppMethodBeat.o(107458);
    return false;
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(107455);
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(WxViewPager.class.getName());
    paramView = d.dL();
    paramView.setScrollable(dI());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (WxViewPager.access$200(this.Apx) != null))
    {
      paramView.setItemCount(WxViewPager.access$200(this.Apx).getCount());
      paramView.setFromIndex(WxViewPager.access$300(this.Apx));
      paramView.setToIndex(WxViewPager.access$300(this.Apx));
    }
    AppMethodBeat.o(107455);
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, b paramb)
  {
    AppMethodBeat.i(107456);
    super.onInitializeAccessibilityNodeInfo(paramView, paramb);
    paramb.setClassName(WxViewPager.class.getName());
    paramb.setScrollable(dI());
    if (this.Apx.canScrollHorizontally(1)) {
      paramb.addAction(4096);
    }
    if (this.Apx.canScrollHorizontally(-1)) {
      paramb.addAction(8192);
    }
    AppMethodBeat.o(107456);
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(107457);
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle))
    {
      AppMethodBeat.o(107457);
      return true;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(107457);
      return false;
    case 4096: 
      if (this.Apx.canScrollHorizontally(1))
      {
        this.Apx.setCurrentItem(WxViewPager.access$300(this.Apx) + 1);
        AppMethodBeat.o(107457);
        return true;
      }
      AppMethodBeat.o(107457);
      return false;
    }
    if (this.Apx.canScrollHorizontally(-1))
    {
      this.Apx.setCurrentItem(WxViewPager.access$300(this.Apx) - 1);
      AppMethodBeat.o(107457);
      return true;
    }
    AppMethodBeat.o(107457);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.mogic.WxViewPager.c
 * JD-Core Version:    0.7.0.1
 */