package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class m
{
  OverScroller qO;
  
  private m(Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {}
    for (paramContext = new OverScroller(paramContext, paramInterpolator);; paramContext = new OverScroller(paramContext))
    {
      this.qO = paramContext;
      return;
    }
  }
  
  @Deprecated
  public static m a(Context paramContext, Interpolator paramInterpolator)
  {
    return new m(paramContext, paramInterpolator);
  }
  
  @Deprecated
  public final void abortAnimation()
  {
    this.qO.abortAnimation();
  }
  
  @Deprecated
  public final void c(int paramInt1, int paramInt2, int paramInt3)
  {
    this.qO.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
  }
  
  @Deprecated
  public final boolean computeScrollOffset()
  {
    return this.qO.computeScrollOffset();
  }
  
  @Deprecated
  public final void g(int paramInt1, int paramInt2)
  {
    this.qO.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
  }
  
  @Deprecated
  public final float getCurrVelocity()
  {
    return this.qO.getCurrVelocity();
  }
  
  @Deprecated
  public final int getCurrX()
  {
    return this.qO.getCurrX();
  }
  
  @Deprecated
  public final int getCurrY()
  {
    return this.qO.getCurrY();
  }
  
  @Deprecated
  public final int getFinalX()
  {
    return this.qO.getFinalX();
  }
  
  @Deprecated
  public final int getFinalY()
  {
    return this.qO.getFinalY();
  }
  
  @Deprecated
  public final boolean isFinished()
  {
    return this.qO.isFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.m
 * JD-Core Version:    0.7.0.1
 */