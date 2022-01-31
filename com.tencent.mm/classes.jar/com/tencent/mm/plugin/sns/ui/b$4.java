package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;

final class b$4
  extends Animation
{
  b$4(b paramb, int paramInt1, int paramInt2) {}
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = (RelativeLayout.LayoutParams)this.oMj.oMh.getLayoutParams();
    if (paramFloat == 1.0F) {}
    for (int i = 0;; i = (int)((this.oMk - this.oMl) * (1.0F - paramFloat)))
    {
      paramTransformation.bottomMargin = i;
      this.oMj.oMh.requestLayout();
      return;
    }
  }
  
  public final boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b.4
 * JD-Core Version:    0.7.0.1
 */