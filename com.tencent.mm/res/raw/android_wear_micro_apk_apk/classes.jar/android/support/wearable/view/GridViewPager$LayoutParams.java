package android.support.wearable.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;

public class GridViewPager$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  public int gravity;
  public boolean mb;
  
  public GridViewPager$LayoutParams()
  {
    super(-1, -1);
  }
  
  public GridViewPager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, GridViewPager.fo());
    this.gravity = paramContext.getInteger(0, 48);
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.GridViewPager.LayoutParams
 * JD-Core Version:    0.7.0.1
 */