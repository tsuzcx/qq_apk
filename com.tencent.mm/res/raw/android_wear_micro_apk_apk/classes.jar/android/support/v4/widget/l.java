package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class l
{
  OverScroller oY;
  
  private l(Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {}
    for (paramContext = new OverScroller(paramContext, paramInterpolator);; paramContext = new OverScroller(paramContext))
    {
      this.oY = paramContext;
      return;
    }
  }
  
  @Deprecated
  public static l a(Context paramContext, Interpolator paramInterpolator)
  {
    return new l(paramContext, paramInterpolator);
  }
  
  @Deprecated
  public final void abortAnimation()
  {
    this.oY.abortAnimation();
  }
  
  @Deprecated
  public final void c(int paramInt1, int paramInt2, int paramInt3)
  {
    this.oY.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
  }
  
  @Deprecated
  public final boolean computeScrollOffset()
  {
    return this.oY.computeScrollOffset();
  }
  
  @Deprecated
  public final void f(int paramInt1, int paramInt2)
  {
    this.oY.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
  }
  
  @Deprecated
  public final float getCurrVelocity()
  {
    return this.oY.getCurrVelocity();
  }
  
  @Deprecated
  public final int getCurrX()
  {
    return this.oY.getCurrX();
  }
  
  @Deprecated
  public final int getCurrY()
  {
    return this.oY.getCurrY();
  }
  
  @Deprecated
  public final int getFinalX()
  {
    return this.oY.getFinalX();
  }
  
  @Deprecated
  public final int getFinalY()
  {
    return this.oY.getFinalY();
  }
  
  @Deprecated
  public final boolean isFinished()
  {
    return this.oY.isFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.l
 * JD-Core Version:    0.7.0.1
 */