package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.f;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class a
{
  private static final c lD;
  private static final View.AccessibilityDelegate lE;
  final View.AccessibilityDelegate lF = lD.a(this);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (lD = new b();; lD = new c())
    {
      lE = new View.AccessibilityDelegate();
      return;
    }
  }
  
  public static f c(View paramView)
  {
    return lD.a(lE, paramView);
  }
  
  public static void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    lE.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static void sendAccessibilityEvent(View paramView, int paramInt)
  {
    lE.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public static void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    lE.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
  
  public void a(View paramView, android.support.v4.view.a.b paramb)
  {
    lE.onInitializeAccessibilityNodeInfo(paramView, paramb.bX());
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return lE.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    lE.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return lE.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return lD.a(lE, paramView, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a
 * JD-Core Version:    0.7.0.1
 */