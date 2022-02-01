package android.support.v7.widget;

import android.view.View;

final class l
{
  int tT;
  int tU;
  int tV;
  int tW;
  int tX = 0;
  int tY = 0;
  
  final View a(af paramaf)
  {
    paramaf = paramaf.aF(this.tU);
    this.tU += this.tV;
    return paramaf;
  }
  
  final boolean a(ak paramak)
  {
    return (this.tU >= 0) && (this.tU < paramak.getItemCount());
  }
  
  public final String toString()
  {
    return "LayoutState{mAvailable=" + this.tT + ", mCurrentPosition=" + this.tU + ", mItemDirection=" + this.tV + ", mLayoutDirection=" + this.tW + ", mStartLine=" + this.tX + ", mEndLine=" + this.tY + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.l
 * JD-Core Version:    0.7.0.1
 */