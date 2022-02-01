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
  private ImageView aic;
  private TextView ajn;
  private final float amm = 0.6F;
  
  public WearableListItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WearableListItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void fU()
  {
    this.ajn.setAlpha(1.0F);
    this.aic.setScaleX(1.3F);
    this.aic.setScaleY(1.3F);
  }
  
  public final void fV()
  {
    this.ajn.setAlpha(this.amm);
    this.aic.setScaleX(1.0F);
    this.aic.setScaleY(1.0F);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.aic = ((ImageView)findViewById(2131558443));
    this.ajn = ((TextView)findViewById(2131558444));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.WearableListItemLayout
 * JD-Core Version:    0.7.0.1
 */