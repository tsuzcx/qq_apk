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
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMSmoothHorizontalScrollView
  extends HorizontalScrollView
{
  private TranslateAnimation Nth;
  private Interpolator adQi;
  private View adTC;
  private float mLastMotionX;
  private Rect mRect;
  
  public MMSmoothHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142152);
    this.mRect = new Rect();
    this.adQi = new DecelerateInterpolator();
    setFadingEdgeLength(0);
    AppMethodBeat.o(142152);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(142153);
    if (getChildCount() > 0) {
      this.adTC = getChildAt(0);
    }
    AppMethodBeat.o(142153);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(142154);
    boolean bool;
    if (this.adTC == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142154);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    label432:
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142154);
      return bool;
      this.mLastMotionX = paramMotionEvent.getX();
      continue;
      float f = paramMotionEvent.getX();
      if (this.mLastMotionX == 0.0F) {
        this.mLastMotionX = f;
      }
      j = (int)(this.mLastMotionX - f) / 2;
      scrollBy(j, 0);
      this.mLastMotionX = f;
      int k = this.adTC.getMeasuredWidth();
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
          this.mRect.set(this.adTC.getLeft(), this.adTC.getTop(), this.adTC.getRight(), this.adTC.getBottom());
        }
        this.adTC.layout(this.adTC.getLeft() - j, this.adTC.getTop(), this.adTC.getRight() - j, this.adTC.getBottom());
        continue;
        this.mLastMotionX = 0.0F;
        if (!this.mRect.isEmpty()) {}
        for (i = j;; i = 0)
        {
          if (i == 0) {
            break label432;
          }
          this.Nth = new TranslateAnimation(this.adTC.getLeft(), this.mRect.left, 0.0F, 0.0F);
          this.Nth.setInterpolator(this.adQi);
          this.Nth.setDuration(Math.abs(this.adTC.getLeft() - this.mRect.left));
          this.adTC.startAnimation(this.Nth);
          this.adTC.layout(this.mRect.left, this.mRect.top, this.mRect.right, this.mRect.bottom);
          this.mRect.setEmpty();
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSmoothHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */