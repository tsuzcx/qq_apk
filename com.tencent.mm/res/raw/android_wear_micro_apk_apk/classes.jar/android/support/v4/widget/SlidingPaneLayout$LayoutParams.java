package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class SlidingPaneLayout$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  private static final int[] kz = { 16843137 };
  boolean pJ;
  boolean pK;
  Paint pL;
  public float weight = 0.0F;
  
  public SlidingPaneLayout$LayoutParams()
  {
    super(-1, -1);
  }
  
  public SlidingPaneLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, kz);
    this.weight = paramContext.getFloat(0, 0.0F);
    paramContext.recycle();
  }
  
  public SlidingPaneLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public SlidingPaneLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */