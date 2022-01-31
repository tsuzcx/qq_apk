package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.a;
import android.support.v4.view.a.e;
import android.support.v4.view.r;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

final class m
  extends a
{
  private final Rect oI = new Rect();
  
  m(SlidingPaneLayout paramSlidingPaneLayout) {}
  
  private boolean S(View paramView)
  {
    return this.pH.R(paramView);
  }
  
  public final void a(View paramView, e parame)
  {
    e locale = e.a(parame);
    super.a(paramView, locale);
    Rect localRect = this.oI;
    locale.getBoundsInParent(localRect);
    parame.setBoundsInParent(localRect);
    locale.getBoundsInScreen(localRect);
    parame.setBoundsInScreen(localRect);
    parame.setVisibleToUser(locale.isVisibleToUser());
    parame.setPackageName(locale.getPackageName());
    parame.setClassName(locale.getClassName());
    parame.setContentDescription(locale.getContentDescription());
    parame.setEnabled(locale.isEnabled());
    parame.setClickable(locale.isClickable());
    parame.setFocusable(locale.isFocusable());
    parame.setFocused(locale.isFocused());
    parame.setAccessibilityFocused(locale.isAccessibilityFocused());
    parame.setSelected(locale.isSelected());
    parame.setLongClickable(locale.isLongClickable());
    parame.addAction(locale.getActions());
    parame.setMovementGranularities(locale.getMovementGranularities());
    locale.recycle();
    parame.setClassName(SlidingPaneLayout.class.getName());
    parame.setSource(paramView);
    paramView = r.j(paramView);
    if ((paramView instanceof View)) {
      parame.setParent((View)paramView);
    }
    int j = this.pH.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramView = this.pH.getChildAt(i);
      if ((!S(paramView)) && (paramView.getVisibility() == 0))
      {
        r.c(paramView, 1);
        parame.addChild(paramView);
      }
      i += 1;
    }
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
  }
  
  public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (!S(paramView)) {
      return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.m
 * JD-Core Version:    0.7.0.1
 */