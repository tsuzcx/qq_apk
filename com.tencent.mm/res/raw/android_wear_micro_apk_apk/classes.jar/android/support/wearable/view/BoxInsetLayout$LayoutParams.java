package android.support.wearable.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.wearable.k;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;

public class BoxInsetLayout$LayoutParams
  extends FrameLayout.LayoutParams
{
  public int Ck = 0;
  
  public BoxInsetLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.zf, 0, 0);
    this.Ck = paramContext.getInt(k.zg, 0);
    paramContext.recycle();
  }
  
  public BoxInsetLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.BoxInsetLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */