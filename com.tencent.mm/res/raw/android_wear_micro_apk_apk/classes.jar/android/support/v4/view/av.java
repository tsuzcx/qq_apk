package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public final class av
{
  private final Object ol;
  
  private av(Object paramObject)
  {
    this.ol = paramObject;
  }
  
  static Object c(av paramav)
  {
    if (paramav == null) {
      return null;
    }
    return paramav.ol;
  }
  
  static av u(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new av(paramObject);
  }
  
  public final av a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return new av(((WindowInsets)this.ol).replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (av)paramObject;
      if (this.ol != null) {
        break;
      }
    } while (paramObject.ol == null);
    return false;
    return this.ol.equals(paramObject.ol);
  }
  
  public final int getSystemWindowInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.ol).getSystemWindowInsetBottom();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.ol).getSystemWindowInsetLeft();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.ol).getSystemWindowInsetRight();
    }
    return 0;
  }
  
  public final int getSystemWindowInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return ((WindowInsets)this.ol).getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int hashCode()
  {
    if (this.ol == null) {
      return 0;
    }
    return this.ol.hashCode();
  }
  
  public final boolean isConsumed()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((WindowInsets)this.ol).isConsumed();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.av
 * JD-Core Version:    0.7.0.1
 */