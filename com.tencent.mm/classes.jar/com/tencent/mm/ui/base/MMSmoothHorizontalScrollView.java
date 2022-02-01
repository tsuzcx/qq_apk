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
  private Interpolator Jkt;
  private View Jnu;
  private float mLastMotionX;
  private Rect mRect;
  private TranslateAnimation xke;
  
  public MMSmoothHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142152);
    this.mRect = new Rect();
    this.Jkt = new DecelerateInterpolator();
    setFadingEdgeLength(0);
    AppMethodBeat.o(142152);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(142153);
    if (getChildCount() > 0) {
      this.Jnu = getChildAt(0);
    }
    AppMethodBeat.o(142153);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(142154);
    boolean bool;
    if (this.Jnu == null)
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
      int k = this.Jnu.getMeasuredWidth();
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
          this.mRect.set(this.Jnu.getLeft(), this.Jnu.getTop(), this.Jnu.getRight(), this.Jnu.getBottom());
        }
        this.Jnu.layout(this.Jnu.getLeft() - j, this.Jnu.getTop(), this.Jnu.getRight() - j, this.Jnu.getBottom());
        continue;
        this.mLastMotionX = 0.0F;
        if (!this.mRect.isEmpty()) {}
        for (i = j;; i = 0)
        {
          if (i == 0) {
            break label432;
          }
          this.xke = new TranslateAnimation(this.Jnu.getLeft(), this.mRect.left, 0.0F, 0.0F);
          this.xke.setInterpolator(this.Jkt);
          this.xke.setDuration(Math.abs(this.Jnu.getLeft() - this.mRect.left));
          this.Jnu.startAnimation(this.xke);
          this.Jnu.layout(this.mRect.left, this.mRect.top, this.mRect.right, this.mRect.bottom);
          this.mRect.setEmpty();
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSmoothHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */