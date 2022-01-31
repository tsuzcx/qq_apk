package com.tencent.mm.wear.app.ui.img;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class TopCropImageView
  extends ImageView
{
  private float agb;
  
  public TopCropImageView(Context paramContext)
  {
    super(paramContext);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  public TopCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  public TopCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  public final float np()
  {
    return this.agb;
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getDrawable() == null) {
      return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    Matrix localMatrix = getImageMatrix();
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    int j = getHeight() - getPaddingTop() - getPaddingBottom();
    int k = getDrawable().getIntrinsicWidth();
    int m = getDrawable().getIntrinsicHeight();
    if (k * j > m * i) {}
    for (this.agb = (j / m);; this.agb = (i / k))
    {
      localMatrix.setScale(this.agb, this.agb);
      setImageMatrix(localMatrix);
      return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.img.TopCropImageView
 * JD-Core Version:    0.7.0.1
 */