package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.e;
import android.support.v4.view.a.r;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class a
{
  private static final c jG;
  private static final View.AccessibilityDelegate jH;
  final View.AccessibilityDelegate jI = jG.a(this);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (jG = new b();; jG = new c())
    {
      jH = new View.AccessibilityDelegate();
      return;
    }
  }
  
  public static r b(View paramView)
  {
    return jG.a(jH, paramView);
  }
  
  public static void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    jH.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static void sendAccessibilityEvent(View paramView, int paramInt)
  {
    jH.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public static void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    jH.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
  
  public void a(View paramView, e parame)
  {
    jH.onInitializeAccessibilityNodeInfo(paramView, parame.bF());
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return jH.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    jH.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return jH.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return jG.a(jH, paramView, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a
 * JD-Core Version:    0.7.0.1
 */