package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityRecord;

public final class aa
{
  private static final ad nh = new ad();
  private final AccessibilityRecord ni;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      nh = new ac();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      nh = new ab();
      return;
    }
  }
  
  @Deprecated
  public aa(Object paramObject)
  {
    this.ni = ((AccessibilityRecord)paramObject);
  }
  
  public static void a(AccessibilityRecord paramAccessibilityRecord, int paramInt)
  {
    nh.a(paramAccessibilityRecord, paramInt);
  }
  
  public static void b(AccessibilityRecord paramAccessibilityRecord, int paramInt)
  {
    nh.b(paramAccessibilityRecord, paramInt);
  }
  
  @Deprecated
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (aa)paramObject;
        if (this.ni != null) {
          break;
        }
      } while (paramObject.ni == null);
      return false;
    } while (this.ni.equals(paramObject.ni));
    return false;
  }
  
  @Deprecated
  public final int hashCode()
  {
    if (this.ni == null) {
      return 0;
    }
    return this.ni.hashCode();
  }
  
  @Deprecated
  public final void setFromIndex(int paramInt)
  {
    this.ni.setFromIndex(paramInt);
  }
  
  @Deprecated
  public final void setItemCount(int paramInt)
  {
    this.ni.setItemCount(paramInt);
  }
  
  @Deprecated
  public final void setScrollable(boolean paramBoolean)
  {
    this.ni.setScrollable(paramBoolean);
  }
  
  @Deprecated
  public final void setToIndex(int paramInt)
  {
    this.ni.setToIndex(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a.aa
 * JD-Core Version:    0.7.0.1
 */