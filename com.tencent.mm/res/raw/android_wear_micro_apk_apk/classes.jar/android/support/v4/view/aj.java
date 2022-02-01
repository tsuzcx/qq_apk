package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

final class aj
  extends a
{
  aj(ViewPager paramViewPager) {}
  
  private boolean bW()
  {
    return (this.nS.mX != null) && (this.nS.mX.getCount() > 1);
  }
  
  public final void a(View paramView, b paramb)
  {
    super.a(paramView, paramb);
    paramb.setClassName(ViewPager.class.getName());
    paramb.setScrollable(bW());
    if (this.nS.canScrollHorizontally(1)) {
      paramb.addAction(4096);
    }
    if (this.nS.canScrollHorizontally(-1)) {
      paramb.addAction(8192);
    }
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    paramAccessibilityEvent.setScrollable(bW());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (this.nS.mX != null))
    {
      paramAccessibilityEvent.setItemCount(this.nS.mX.getCount());
      paramAccessibilityEvent.setFromIndex(this.nS.mY);
      paramAccessibilityEvent.setToIndex(this.nS.mY);
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
      if (this.nS.canScrollHorizontally(1))
      {
        this.nS.L(this.nS.mY + 1);
        return true;
      }
      return false;
    }
    if (this.nS.canScrollHorizontally(-1))
    {
      this.nS.L(this.nS.mY - 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.aj
 * JD-Core Version:    0.7.0.1
 */