package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;

public class MMSmoothHorizontalScrollView
  extends HorizontalScrollView
{
  private float GS;
  private Interpolator eO = new DecelerateInterpolator();
  private Rect mRect = new Rect();
  private TranslateAnimation nmv;
  private View uXV;
  
  public MMSmoothHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFadingEdgeLength(0);
  }
  
  protected void onFinishInflate()
  {
    if (getChildCount() > 0) {
      this.uXV = getChildAt(0);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 1;
    int i = 0;
    if (this.uXV == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    label407:
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.GS = paramMotionEvent.getX();
      continue;
      float f = paramMotionEvent.getX();
      if (this.GS == 0.0F) {
        this.GS = f;
      }
      j = (int)(this.GS - f) / 2;
      scrollBy(j, 0);
      this.GS = f;
      int k = this.uXV.getMeasuredWidth();
      int m = getWidth();
      int n = getPaddingLeft();
      int i1 = getPaddingRight();
      int i2 = getScrollX();
      if ((i2 == 0) || (i2 == k - (m - n - i1))) {
        i = 1;
      }
      if (i != 0)
      {
        if (this.mRect.isEmpty()) {
          this.mRect.set(this.uXV.getLeft(), this.uXV.getTop(), this.uXV.getRight(), this.uXV.getBottom());
        }
        this.uXV.layout(this.uXV.getLeft() - j, this.uXV.getTop(), this.uXV.getRight() - j, this.uXV.getBottom());
        continue;
        this.GS = 0.0F;
        if (!this.mRect.isEmpty()) {}
        for (i = j;; i = 0)
        {
          if (i == 0) {
            break label407;
          }
          this.nmv = new TranslateAnimation(this.uXV.getLeft(), this.mRect.left, 0.0F, 0.0F);
          this.nmv.setInterpolator(this.eO);
          this.nmv.setDuration(Math.abs(this.uXV.getLeft() - this.mRect.left));
          this.uXV.startAnimation(this.nmv);
          this.uXV.layout(this.mRect.left, this.mRect.top, this.mRect.right, this.mRect.bottom);
          this.mRect.setEmpty();
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSmoothHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */