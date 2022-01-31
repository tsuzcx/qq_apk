package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.a;
import android.support.v4.view.a.f;
import android.support.v4.view.r;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

final class e
  extends a
{
  private final Rect oI = new Rect();
  
  e(DrawerLayout paramDrawerLayout) {}
  
  public final void a(View paramView, android.support.v4.view.a.e parame)
  {
    if (DrawerLayout.ob) {
      super.a(paramView, parame);
    }
    for (;;)
    {
      parame.setClassName(DrawerLayout.class.getName());
      parame.setFocusable(false);
      parame.setFocused(false);
      parame.a(f.mu);
      parame.a(f.mv);
      return;
      Object localObject1 = android.support.v4.view.a.e.a(parame);
      super.a(paramView, (android.support.v4.view.a.e)localObject1);
      parame.setSource(paramView);
      Object localObject2 = r.j(paramView);
      if ((localObject2 instanceof View)) {
        parame.setParent((View)localObject2);
      }
      localObject2 = this.oI;
      ((android.support.v4.view.a.e)localObject1).getBoundsInParent((Rect)localObject2);
      parame.setBoundsInParent((Rect)localObject2);
      ((android.support.v4.view.a.e)localObject1).getBoundsInScreen((Rect)localObject2);
      parame.setBoundsInScreen((Rect)localObject2);
      parame.setVisibleToUser(((android.support.v4.view.a.e)localObject1).isVisibleToUser());
      parame.setPackageName(((android.support.v4.view.a.e)localObject1).getPackageName());
      parame.setClassName(((android.support.v4.view.a.e)localObject1).getClassName());
      parame.setContentDescription(((android.support.v4.view.a.e)localObject1).getContentDescription());
      parame.setEnabled(((android.support.v4.view.a.e)localObject1).isEnabled());
      parame.setClickable(((android.support.v4.view.a.e)localObject1).isClickable());
      parame.setFocusable(((android.support.v4.view.a.e)localObject1).isFocusable());
      parame.setFocused(((android.support.v4.view.a.e)localObject1).isFocused());
      parame.setAccessibilityFocused(((android.support.v4.view.a.e)localObject1).isAccessibilityFocused());
      parame.setSelected(((android.support.v4.view.a.e)localObject1).isSelected());
      parame.setLongClickable(((android.support.v4.view.a.e)localObject1).isLongClickable());
      parame.addAction(((android.support.v4.view.a.e)localObject1).getActions());
      ((android.support.v4.view.a.e)localObject1).recycle();
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject1 = paramView.getChildAt(i);
        if (DrawerLayout.I((View)localObject1)) {
          parame.addChild((View)localObject1);
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
      paramAccessibilityEvent = this.oH.cd();
      if (paramAccessibilityEvent != null)
      {
        int i = this.oH.D(paramAccessibilityEvent);
        paramAccessibilityEvent = this.oH.I(i);
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
    if ((DrawerLayout.ob) || (DrawerLayout.I(paramView))) {
      return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.e
 * JD-Core Version:    0.7.0.1
 */