package android.support.v4.widget;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.widget.ScrollView;

final class l
  extends a
{
  public final void a(View paramView, b paramb)
  {
    super.a(paramView, paramb);
    paramView = (NestedScrollView)paramView;
    paramb.setClassName(ScrollView.class.getName());
    if (paramView.isEnabled())
    {
      int i = paramView.cq();
      if (i > 0)
      {
        paramb.setScrollable(true);
        if (paramView.getScrollY() > 0) {
          paramb.addAction(8192);
        }
        if (paramView.getScrollY() < i) {
          paramb.addAction(4096);
        }
      }
    }
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramView = (NestedScrollView)paramView;
    paramAccessibilityEvent.setClassName(ScrollView.class.getName());
    if (paramView.cq() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramAccessibilityEvent.setScrollable(bool);
      paramAccessibilityEvent.setScrollX(paramView.getScrollX());
      paramAccessibilityEvent.setScrollY(paramView.getScrollY());
      int i = paramView.getScrollX();
      if (Build.VERSION.SDK_INT >= 15) {
        paramAccessibilityEvent.setMaxScrollX(i);
      }
      i = paramView.cq();
      if (Build.VERSION.SDK_INT >= 15) {
        paramAccessibilityEvent.setMaxScrollY(i);
      }
      return;
    }
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    paramView = (NestedScrollView)paramView;
    if (!paramView.isEnabled()) {
      return false;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 4096: 
      paramInt = Math.min(paramView.getHeight() - paramView.getPaddingBottom() - paramView.getPaddingTop() + paramView.getScrollY(), paramView.cq());
      if (paramInt != paramView.getScrollY())
      {
        paramView.Z(paramInt);
        return true;
      }
      return false;
    }
    paramInt = paramView.getHeight();
    int i = paramView.getPaddingBottom();
    int j = paramView.getPaddingTop();
    paramInt = Math.max(paramView.getScrollY() - (paramInt - i - j), 0);
    if (paramInt != paramView.getScrollY())
    {
      paramView.Z(paramInt);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.l
 * JD-Core Version:    0.7.0.1
 */