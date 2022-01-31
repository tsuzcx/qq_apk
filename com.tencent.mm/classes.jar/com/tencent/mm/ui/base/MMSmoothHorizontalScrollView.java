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
  private Interpolator fO;
  private float mLastMotionX;
  private Rect mRect;
  private TranslateAnimation pRK;
  private View zmm;
  
  public MMSmoothHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106794);
    this.mRect = new Rect();
    this.fO = new DecelerateInterpolator();
    setFadingEdgeLength(0);
    AppMethodBeat.o(106794);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(106795);
    if (getChildCount() > 0) {
      this.zmm = getChildAt(0);
    }
    AppMethodBeat.o(106795);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(106796);
    boolean bool;
    if (this.zmm == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106796);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    label432:
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106796);
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
      int k = this.zmm.getMeasuredWidth();
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
          this.mRect.set(this.zmm.getLeft(), this.zmm.getTop(), this.zmm.getRight(), this.zmm.getBottom());
        }
        this.zmm.layout(this.zmm.getLeft() - j, this.zmm.getTop(), this.zmm.getRight() - j, this.zmm.getBottom());
        continue;
        this.mLastMotionX = 0.0F;
        if (!this.mRect.isEmpty()) {}
        for (i = j;; i = 0)
        {
          if (i == 0) {
            break label432;
          }
          this.pRK = new TranslateAnimation(this.zmm.getLeft(), this.mRect.left, 0.0F, 0.0F);
          this.pRK.setInterpolator(this.fO);
          this.pRK.setDuration(Math.abs(this.zmm.getLeft() - this.mRect.left));
          this.zmm.startAnimation(this.pRK);
          this.zmm.layout(this.mRect.left, this.mRect.top, this.mRect.right, this.mRect.bottom);
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