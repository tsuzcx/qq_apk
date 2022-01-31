package android.support.v4.view.a;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

class k
  extends j
{
  public final Object a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    return AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, false);
  }
  
  public final Object a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    return AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean, paramInt3);
  }
  
  public final Object a(int paramInt, CharSequence paramCharSequence)
  {
    return new AccessibilityNodeInfo.AccessibilityAction(paramInt, null);
  }
  
  public final boolean c(AccessibilityNodeInfo paramAccessibilityNodeInfo, Object paramObject)
  {
    return paramAccessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a.k
 * JD-Core Version:    0.7.0.1
 */