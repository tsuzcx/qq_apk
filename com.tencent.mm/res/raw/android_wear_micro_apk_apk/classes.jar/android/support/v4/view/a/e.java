package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public final class e
{
  final Object oT;
  
  private e(Object paramObject)
  {
    this.oT = paramObject;
  }
  
  public static e a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new e(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, false));
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return new e(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean));
    }
    return new e(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a.e
 * JD-Core Version:    0.7.0.1
 */