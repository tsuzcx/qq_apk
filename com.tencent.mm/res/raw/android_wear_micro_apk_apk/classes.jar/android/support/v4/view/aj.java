package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.e;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

final class aj
  extends a
{
  aj(ViewPager paramViewPager) {}
  
  private boolean bE()
  {
    return (this.lW.lb != null) && (this.lW.lb.getCount() > 1);
  }
  
  public final void a(View paramView, e parame)
  {
    super.a(paramView, parame);
    parame.setClassName(ViewPager.class.getName());
    parame.setScrollable(bE());
    if (this.lW.canScrollHorizontally(1)) {
      parame.addAction(4096);
    }
    if (this.lW.canScrollHorizontally(-1)) {
      parame.addAction(8192);
    }
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    paramAccessibilityEvent.setScrollable(bE());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (this.lW.lb != null))
    {
      paramAccessibilityEvent.setItemCount(this.lW.lb.getCount());
      paramAccessibilityEvent.setFromIndex(this.lW.lc);
      paramAccessibilityEvent.setToIndex(this.lW.lc);
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
      if (this.lW.canScrollHorizontally(1))
      {
        this.lW.A(this.lW.lc + 1);
        return true;
      }
      return false;
    }
    if (this.lW.canScrollHorizontally(-1))
    {
      this.lW.A(this.lW.lc - 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.aj
 * JD-Core Version:    0.7.0.1
 */