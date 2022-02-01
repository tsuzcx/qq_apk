package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.r;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

final class n
  extends a
{
  private final Rect qy = new Rect();
  
  n(SlidingPaneLayout paramSlidingPaneLayout) {}
  
  private boolean Y(View paramView)
  {
    return this.rx.X(paramView);
  }
  
  public final void a(View paramView, b paramb)
  {
    b localb = b.a(paramb);
    super.a(paramView, localb);
    Rect localRect = this.qy;
    localb.getBoundsInParent(localRect);
    paramb.setBoundsInParent(localRect);
    localb.getBoundsInScreen(localRect);
    paramb.setBoundsInScreen(localRect);
    paramb.setVisibleToUser(localb.isVisibleToUser());
    paramb.setPackageName(localb.getPackageName());
    paramb.setClassName(localb.getClassName());
    paramb.setContentDescription(localb.getContentDescription());
    paramb.setEnabled(localb.isEnabled());
    paramb.setClickable(localb.isClickable());
    paramb.setFocusable(localb.isFocusable());
    paramb.setFocused(localb.isFocused());
    paramb.setAccessibilityFocused(localb.isAccessibilityFocused());
    paramb.setSelected(localb.isSelected());
    paramb.setLongClickable(localb.isLongClickable());
    paramb.addAction(localb.getActions());
    paramb.setMovementGranularities(localb.getMovementGranularities());
    localb.recycle();
    paramb.setClassName(SlidingPaneLayout.class.getName());
    paramb.setSource(paramView);
    paramView = r.k(paramView);
    if ((paramView instanceof View)) {
      paramb.setParent((View)paramView);
    }
    int j = this.rx.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramView = this.rx.getChildAt(i);
      if ((!Y(paramView)) && (paramView.getVisibility() == 0))
      {
        r.f(paramView, 1);
        paramb.addChild(paramView);
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
    if (!Y(paramView)) {
      return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.n
 * JD-Core Version:    0.7.0.1
 */