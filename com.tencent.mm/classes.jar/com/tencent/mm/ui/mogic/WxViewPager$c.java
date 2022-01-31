package com.tencent.mm.ui.mogic;

import android.os.Bundle;
import android.support.v4.view.a.c;
import android.support.v4.view.n;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

final class WxViewPager$c
  extends android.support.v4.view.a
{
  WxViewPager$c(WxViewPager paramWxViewPager) {}
  
  private boolean dt()
  {
    return (WxViewPager.b(this.vXq) != null) && (WxViewPager.b(this.vXq).getCount() > 1);
  }
  
  public final void a(View paramView, android.support.v4.view.a.a parama)
  {
    super.a(paramView, parama);
    parama.setClassName(WxViewPager.class.getName());
    parama.setScrollable(dt());
    if (this.vXq.canScrollHorizontally(1)) {
      parama.addAction(4096);
    }
    if (this.vXq.canScrollHorizontally(-1)) {
      parama.addAction(8192);
    }
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(WxViewPager.class.getName());
    paramView = c.dw();
    paramView.setScrollable(dt());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (WxViewPager.b(this.vXq) != null))
    {
      paramView.setItemCount(WxViewPager.b(this.vXq).getCount());
      paramView.setFromIndex(WxViewPager.c(this.vXq));
      paramView.setToIndex(WxViewPager.c(this.vXq));
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
      if (this.vXq.canScrollHorizontally(1))
      {
        this.vXq.setCurrentItem(WxViewPager.c(this.vXq) + 1);
        return true;
      }
      return false;
    }
    if (this.vXq.canScrollHorizontally(-1))
    {
      this.vXq.setCurrentItem(WxViewPager.c(this.vXq) - 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.mogic.WxViewPager.c
 * JD-Core Version:    0.7.0.1
 */