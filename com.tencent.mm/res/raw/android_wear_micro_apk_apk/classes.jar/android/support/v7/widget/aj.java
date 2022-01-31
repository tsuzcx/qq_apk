package android.support.v7.widget;

import android.view.animation.Interpolator;

public final class aj
{
  private Interpolator mInterpolator = null;
  private int uH = 0;
  private int uI = 0;
  private int uJ = -2147483648;
  private int uK = -1;
  private boolean uL = false;
  private int uM = 0;
  
  public aj()
  {
    this(0, 0);
  }
  
  private aj(int paramInt1, int paramInt2) {}
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    this.uH = paramInt1;
    this.uI = paramInt2;
    this.uJ = paramInt3;
    this.mInterpolator = paramInterpolator;
    this.uL = true;
  }
  
  public final void ax(int paramInt)
  {
    this.uK = paramInt;
  }
  
  final boolean dX()
  {
    return this.uK >= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.aj
 * JD-Core Version:    0.7.0.1
 */