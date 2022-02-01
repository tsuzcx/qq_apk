package android.support.wearable.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.wearable.k;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;

public class WearableFrameLayout$LayoutParams
  extends FrameLayout.LayoutParams
{
  public int Gq = -1;
  public int Gr;
  public int Gs;
  public int Gt;
  public int Gu;
  public int Gv;
  public int Gw;
  
  public WearableFrameLayout$LayoutParams()
  {
    super(-1, -1);
    this.Gr = -1;
    this.Gs = -1;
  }
  
  public WearableFrameLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.zX);
    this.Gq = paramContext.getInt(k.Ac, this.gravity);
    this.Gr = paramContext.getLayoutDimension(k.Ad, this.width);
    this.Gs = paramContext.getLayoutDimension(k.Ae, this.height);
    int i = paramContext.getDimensionPixelSize(k.Af, -1);
    if (i >= 0)
    {
      this.Gw = i;
      this.Gu = i;
      this.Gv = i;
      this.Gt = i;
    }
    for (;;)
    {
      paramContext.recycle();
      return;
      this.Gt = paramContext.getDimensionPixelSize(k.Ag, this.leftMargin);
      this.Gu = paramContext.getDimensionPixelSize(k.Ah, this.topMargin);
      this.Gv = paramContext.getDimensionPixelSize(k.Ai, this.rightMargin);
      this.Gw = paramContext.getDimensionPixelSize(k.Aj, this.bottomMargin);
    }
  }
  
  public WearableFrameLayout$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.Gr = paramLayoutParams.Gr;
    this.Gs = paramLayoutParams.Gs;
    this.Gq = paramLayoutParams.Gq;
    this.Gt = paramLayoutParams.Gt;
    this.Gu = paramLayoutParams.Gu;
    this.Gv = paramLayoutParams.Gv;
    this.Gw = paramLayoutParams.Gw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.WearableFrameLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */