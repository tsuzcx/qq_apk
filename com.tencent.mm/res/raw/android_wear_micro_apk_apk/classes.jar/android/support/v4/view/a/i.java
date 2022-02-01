package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

public final class i
{
  private final AccessibilityRecord oW;
  
  @Deprecated
  public i(Object paramObject)
  {
    this.oW = ((AccessibilityRecord)paramObject);
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
        paramObject = (i)paramObject;
        if (this.oW != null) {
          break;
        }
      } while (paramObject.oW == null);
      return false;
    } while (this.oW.equals(paramObject.oW));
    return false;
  }
  
  @Deprecated
  public final int hashCode()
  {
    if (this.oW == null) {
      return 0;
    }
    return this.oW.hashCode();
  }
  
  @Deprecated
  public final void setFromIndex(int paramInt)
  {
    this.oW.setFromIndex(paramInt);
  }
  
  @Deprecated
  public final void setItemCount(int paramInt)
  {
    this.oW.setItemCount(paramInt);
  }
  
  @Deprecated
  public final void setScrollable(boolean paramBoolean)
  {
    this.oW.setScrollable(paramBoolean);
  }
  
  @Deprecated
  public final void setToIndex(int paramInt)
  {
    this.oW.setToIndex(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.a.i
 * JD-Core Version:    0.7.0.1
 */