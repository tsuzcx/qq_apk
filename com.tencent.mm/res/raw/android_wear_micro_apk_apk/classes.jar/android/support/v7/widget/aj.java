package android.support.v7.widget;

import android.view.animation.Interpolator;

public final class aj
{
  private Interpolator mInterpolator = null;
  private boolean wA = false;
  private int wB = 0;
  private int ww = 0;
  private int wx = 0;
  private int wy = -2147483648;
  private int wz = -1;
  
  public aj()
  {
    this(0, 0);
  }
  
  private aj(int paramInt1, int paramInt2) {}
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    this.ww = paramInt1;
    this.wx = paramInt2;
    this.wy = paramInt3;
    this.mInterpolator = paramInterpolator;
    this.wA = true;
  }
  
  public final void aJ(int paramInt)
  {
    this.wz = paramInt;
  }
  
  final boolean el()
  {
    return this.wz >= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.aj
 * JD-Core Version:    0.7.0.1
 */