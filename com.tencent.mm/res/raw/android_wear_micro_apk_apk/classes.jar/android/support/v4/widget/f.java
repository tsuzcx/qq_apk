package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.c;
import android.support.v4.view.r;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

final class f
  extends a
{
  private final Rect qy = new Rect();
  
  f(DrawerLayout paramDrawerLayout) {}
  
  public final void a(View paramView, b paramb)
  {
    if (DrawerLayout.pT) {
      super.a(paramView, paramb);
    }
    for (;;)
    {
      paramb.setClassName(DrawerLayout.class.getName());
      paramb.setFocusable(false);
      paramb.setFocused(false);
      paramb.a(c.oo);
      paramb.a(c.op);
      return;
      Object localObject1 = b.a(paramb);
      super.a(paramView, (b)localObject1);
      paramb.setSource(paramView);
      Object localObject2 = r.k(paramView);
      if ((localObject2 instanceof View)) {
        paramb.setParent((View)localObject2);
      }
      localObject2 = this.qy;
      ((b)localObject1).getBoundsInParent((Rect)localObject2);
      paramb.setBoundsInParent((Rect)localObject2);
      ((b)localObject1).getBoundsInScreen((Rect)localObject2);
      paramb.setBoundsInScreen((Rect)localObject2);
      paramb.setVisibleToUser(((b)localObject1).isVisibleToUser());
      paramb.setPackageName(((b)localObject1).getPackageName());
      paramb.setClassName(((b)localObject1).getClassName());
      paramb.setContentDescription(((b)localObject1).getContentDescription());
      paramb.setEnabled(((b)localObject1).isEnabled());
      paramb.setClickable(((b)localObject1).isClickable());
      paramb.setFocusable(((b)localObject1).isFocusable());
      paramb.setFocused(((b)localObject1).isFocused());
      paramb.setAccessibilityFocused(((b)localObject1).isAccessibilityFocused());
      paramb.setSelected(((b)localObject1).isSelected());
      paramb.setLongClickable(((b)localObject1).isLongClickable());
      paramb.addAction(((b)localObject1).getActions());
      ((b)localObject1).recycle();
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject1 = paramView.getChildAt(i);
        if (DrawerLayout.O((View)localObject1)) {
          paramb.addChild((View)localObject1);
        }
        i += 1;
      }
    }
  }
  
  public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramView = paramAccessibilityEvent.getText();
      paramAccessibilityEvent = this.qx.ci();
      if (paramAccessibilityEvent != null)
      {
        int i = this.qx.I(paramAccessibilityEvent);
        paramAccessibilityEvent = this.qx.T(i);
        if (paramAccessibilityEvent != null) {
          paramView.add(paramAccessibilityEvent);
        }
      }
      return true;
    }
    return super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
  }
  
  public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if ((DrawerLayout.pT) || (DrawerLayout.O(paramView))) {
      return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.f
 * JD-Core Version:    0.7.0.1
 */