package com.tencent.mm.ui.tools;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;

final class e$3
  extends ScaleAnimation
{
  e$3(e parame, float paramFloat1, float paramFloat2, View paramView, e.a parama)
  {
    super(1.0F, paramFloat1, 1.0F, paramFloat2);
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int k;
    int i;
    int n;
    int i1;
    if ((this.wcP.wcq != 0) && (this.wcP.wcr != 0) && (this.wcP.wcx == 1.0F))
    {
      Rect localRect = new Rect();
      this.wcQ.getGlobalVisibleRect(localRect);
      int m = (localRect.right - localRect.left) / 2;
      int j = (localRect.bottom - localRect.top + this.wcP.wcB) / 2;
      k = (int)(((this.wcP.wcq - this.wcP.mWidth) * (1.0F - paramFloat) + this.wcP.mWidth) / (1.0F - (1.0F - this.wcP.wcu) * paramFloat));
      i = (int)(((this.wcP.wcr - this.wcP.mHeight) * (1.0F - paramFloat) + this.wcP.mHeight) / (1.0F - (1.0F - this.wcP.wcu) * paramFloat));
      if (this.wcP.wcx != 1.0F)
      {
        this.wcP.wcu = (this.wcP.wcv / this.wcP.wcx);
        i = localRect.right;
        i = localRect.left;
        m = (localRect.right + localRect.left) / 2;
        j = this.wcP.wcz - localRect.top + (int)(this.wcP.wcr / 2.0F);
        k = (int)(((this.wcP.wcq - this.wcP.mWidth) * (1.0F - paramFloat) + this.wcP.mWidth) / (1.0F - (1.0F - this.wcP.wcu) * paramFloat));
        i = (int)(((this.wcP.wcr - this.wcP.mHeight) * (1.0F - paramFloat) + this.wcP.mHeight) / (1.0F - (1.0F - this.wcP.wcu) * paramFloat));
      }
      n = (int)(m - k / 2 + this.wcP.wcC * paramFloat / (1.0F - (1.0F - this.wcP.wcu) * paramFloat));
      i1 = (int)(j - i / 2 - this.wcP.wcB * (1.0F - paramFloat) / 2.0F + this.wcP.wcE * paramFloat / (1.0F - (1.0F - this.wcP.wcu) * paramFloat));
      k = (int)(k / 2 + m - this.wcP.wcD * paramFloat / (1.0F - (1.0F - this.wcP.wcu) * paramFloat));
      i = (int)(i / 2 + j - this.wcP.wcF * paramFloat / (1.0F - (1.0F - this.wcP.wcu) * paramFloat));
      if (Build.VERSION.SDK_INT < 21) {
        break label551;
      }
      this.wcQ.setClipBounds(new Rect(n, i1, k, i));
    }
    for (;;)
    {
      super.applyTransformation(paramFloat, paramTransformation);
      return;
      label551:
      if (Build.VERSION.SDK_INT >= 18) {
        if (this.wcR != null) {
          this.wcR.y(n, i1, k, i);
        } else {
          this.wcQ.setClipBounds(new Rect(n + this.wcQ.getScrollX(), i1, k + this.wcQ.getScrollX(), i));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.e.3
 * JD-Core Version:    0.7.0.1
 */