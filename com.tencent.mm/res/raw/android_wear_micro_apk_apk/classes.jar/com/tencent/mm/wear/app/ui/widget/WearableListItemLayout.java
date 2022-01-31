package com.tencent.mm.wear.app.ui.widget;

import android.content.Context;
import android.support.wearable.view.aa;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WearableListItemLayout
  extends LinearLayout
  implements aa
{
  private ImageView aeA;
  private TextView afL;
  private final float aiK = 0.6F;
  
  public WearableListItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WearableListItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void fK()
  {
    this.afL.setAlpha(1.0F);
    this.aeA.setScaleX(1.3F);
    this.aeA.setScaleY(1.3F);
  }
  
  public final void fL()
  {
    this.afL.setAlpha(this.aiK);
    this.aeA.setScaleX(1.0F);
    this.aeA.setScaleY(1.0F);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.aeA = ((ImageView)findViewById(2131558442));
    this.afL = ((TextView)findViewById(2131558443));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.WearableListItemLayout
 * JD-Core Version:    0.7.0.1
 */