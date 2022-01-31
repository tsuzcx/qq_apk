package android.support.v4.view.a;

import android.view.accessibility.AccessibilityNodeInfo;

class g
  extends o
{
  public final void a(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt)
  {
    paramAccessibilityNodeInfo.setMovementGranularities(paramInt);
  }
  
  public final void a(AccessibilityNodeInfo paramAccessibilityNodeInfo, boolean paramBoolean)
  {
    paramAccessibilityNodeInfo.setVisibleToUser(paramBoolean);
  }
  
  public final void b(AccessibilityNodeInfo paramAccessibilityNodeInfo, boolean paramBoolean)
  {
    paramAccessibilityNodeInfo.setAccessibilityFocused(paramBoolean);
  }
  
  public final boolean b(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return paramAccessibilityNodeInfo.isVisibleToUser();
  }
  
  public final boolean c(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return paramAccessibilityNodeInfo.isAccessibilityFocused();
  }
  
  public final int d(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return paramAccessibilityNodeInfo.getMovementGranularities();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a.g
 * JD-Core Version:    0.7.0.1
 */