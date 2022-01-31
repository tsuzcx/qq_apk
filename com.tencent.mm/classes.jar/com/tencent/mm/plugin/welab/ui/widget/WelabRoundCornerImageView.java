package com.tencent.mm.plugin.welab.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.b;
import android.support.v4.a.a.d;
import android.util.AttributeSet;
import android.widget.ImageView;

public class WelabRoundCornerImageView
  extends ImageView
{
  private float rEX;
  
  public WelabRoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WelabRoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public Bitmap getDisplayingBitmap()
  {
    Drawable localDrawable = getDrawable();
    if ((localDrawable == null) || (!(localDrawable instanceof b))) {
      return null;
    }
    return ((b)localDrawable).mBitmap;
  }
  
  public void setCornerRadiusPercent(float paramFloat)
  {
    this.rEX = paramFloat;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (paramBitmap.getWidth() < 0) || (paramBitmap.getHeight() < 0))
    {
      super.setImageBitmap(paramBitmap);
      return;
    }
    if (this.rEX <= 0.0F)
    {
      super.setImageBitmap(paramBitmap);
      return;
    }
    b localb = d.a(getResources(), paramBitmap);
    float f = Math.min(paramBitmap.getWidth() * this.rEX, paramBitmap.getHeight() * this.rEX);
    if (localb.js != f)
    {
      localb.At = false;
      if (!b.q(f)) {
        break label127;
      }
      localb.mPaint.setShader(localb.Ao);
    }
    for (;;)
    {
      localb.js = f;
      localb.invalidateSelf();
      super.setImageDrawable(localb);
      return;
      label127:
      localb.mPaint.setShader(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */