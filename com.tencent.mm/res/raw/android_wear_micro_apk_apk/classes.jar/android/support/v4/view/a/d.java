package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;

public final class d
{
  final Object oT;
  
  private d(Object paramObject)
  {
    this.oT = paramObject;
  }
  
  public static d a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new d(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, false, 0));
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return new d(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, false));
    }
    return new d(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a.d
 * JD-Core Version:    0.7.0.1
 */