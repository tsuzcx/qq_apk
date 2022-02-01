package android.support.wearable.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.wearable.k;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

@TargetApi(20)
public class WearableHeaderTextView
  extends TextView
{
  private int Gx = 0;
  private int Gy = 0;
  
  public WearableHeaderTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WearableHeaderTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.Ak, 0, 0);
    this.Gy = paramContext.getInt(k.Al, 0);
    this.Gx = paramContext.getDimensionPixelSize(k.Am, 0);
    paramContext.recycle();
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    if (paramWindowInsets.isRound())
    {
      if (this.Gy != 0)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
        localLayoutParams.gravity = this.Gy;
        setLayoutParams(localLayoutParams);
      }
      if (this.Gx != 0) {
        setTextSize(this.Gx);
      }
      requestLayout();
    }
    return paramWindowInsets;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.WearableHeaderTextView
 * JD-Core Version:    0.7.0.1
 */