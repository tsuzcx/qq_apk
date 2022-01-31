package android.support.wearable.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.wearable.k;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;

public class WearableFrameLayout$LayoutParams
  extends FrameLayout.LayoutParams
{
  public int EB = -1;
  public int EC;
  public int ED;
  public int EE;
  public int EF;
  public int EG;
  public int EH;
  
  public WearableFrameLayout$LayoutParams()
  {
    super(-1, -1);
    this.EC = -1;
    this.ED = -1;
  }
  
  public WearableFrameLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.yi);
    this.EB = paramContext.getInt(k.yn, this.gravity);
    this.EC = paramContext.getLayoutDimension(k.yo, this.width);
    this.ED = paramContext.getLayoutDimension(k.yp, this.height);
    int i = paramContext.getDimensionPixelSize(k.yq, -1);
    if (i >= 0)
    {
      this.EH = i;
      this.EF = i;
      this.EG = i;
      this.EE = i;
    }
    for (;;)
    {
      paramContext.recycle();
      return;
      this.EE = paramContext.getDimensionPixelSize(k.yr, this.leftMargin);
      this.EF = paramContext.getDimensionPixelSize(k.ys, this.topMargin);
      this.EG = paramContext.getDimensionPixelSize(k.yt, this.rightMargin);
      this.EH = paramContext.getDimensionPixelSize(k.yu, this.bottomMargin);
    }
  }
  
  public WearableFrameLayout$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.EC = paramLayoutParams.EC;
    this.ED = paramLayoutParams.ED;
    this.EB = paramLayoutParams.EB;
    this.EE = paramLayoutParams.EE;
    this.EF = paramLayoutParams.EF;
    this.EG = paramLayoutParams.EG;
    this.EH = paramLayoutParams.EH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.WearableFrameLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */