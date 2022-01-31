package com.tencent.mm.ui.base;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.OverScroller;
import com.tencent.mm.sdk.platformtools.y;

final class MMViewPager$d
  extends GestureDetector.SimpleOnGestureListener
{
  private MMViewPager$d(MMViewPager paramMMViewPager) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (MMViewPager.a(this.uZn) == null) {
      return false;
    }
    if (MMViewPager.a(this.uZn).getScale() <= MMViewPager.a(this.uZn).getScaleRate()) {
      MMViewPager.a(this.uZn).ad(f.c(paramMotionEvent, 0), f.d(paramMotionEvent, 0));
    }
    for (;;)
    {
      return true;
      MMViewPager.a(this.uZn).ac(f.c(paramMotionEvent, 0), f.d(paramMotionEvent, 0));
    }
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    if (MMViewPager.r(this.uZn) != null) {
      MMViewPager.r(this.uZn).forceFinished(true);
    }
    return super.onDown(paramMotionEvent);
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    y.d("MicroMsg.MMViewPager", "onFling");
    Object localObject2 = MMViewPager.t(this.uZn);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = MMViewPager.u(this.uZn);
    }
    if (localObject1 != null)
    {
      y.d("MicroMsg.MMViewPager", "onFling MultiTouchImageView");
      if ((localObject1 instanceof MultiTouchImageView)) {
        localObject1 = (MultiTouchImageView)localObject1;
      }
    }
    for (;;)
    {
      float f2 = ((g)localObject1).getScale() * ((g)localObject1).getImageWidth();
      float f5 = ((g)localObject1).getScale() * ((g)localObject1).getImageHeight();
      float f3;
      float f4;
      float f6;
      if ((((g)localObject1).cAw()) || (((g)localObject1).cAx()) || ((int)f2 > MMViewPager.b(this.uZn)) || ((int)f5 > MMViewPager.d(this.uZn)))
      {
        localObject2 = new float[9];
        ((g)localObject1).getImageMatrix().getValues((float[])localObject2);
        f3 = localObject2[2];
        f4 = f3 + f2;
        f6 = localObject2[5];
        y.d("MicroMsg.MMViewPager", "left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(MMViewPager.c(paramMotionEvent1, paramMotionEvent2)), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
        if ((Math.round(f3) < MMViewPager.v(this.uZn).left) && (Math.round(f4) > MMViewPager.v(this.uZn).right)) {
          break label658;
        }
      }
      label658:
      for (float f1 = 0.0F;; f1 = paramFloat1)
      {
        if ((Math.round(f6) >= MMViewPager.v(this.uZn).top) || (Math.round(f6 + f5) <= MMViewPager.v(this.uZn).bottom)) {
          paramFloat2 = 0.0F;
        }
        int i = (int)(MMViewPager.v(this.uZn).right - f2);
        int j = (int)(f2 + MMViewPager.v(this.uZn).right);
        int k = (int)(MMViewPager.v(this.uZn).bottom - f5);
        int m = (int)(MMViewPager.v(this.uZn).bottom + f5);
        if (f1 >= 0.0F)
        {
          f2 = f1;
          if (Math.abs(f1) >= MMViewPager.w(this.uZn)) {
            f2 = MMViewPager.w(this.uZn);
          }
          label424:
          if (paramFloat2 < 0.0F) {
            break label600;
          }
          f1 = paramFloat2;
          if (Math.abs(paramFloat2) >= MMViewPager.w(this.uZn)) {
            f1 = MMViewPager.w(this.uZn);
          }
        }
        for (;;)
        {
          MMViewPager.r(this.uZn).fling(MMViewPager.r(this.uZn).getCurrX(), MMViewPager.r(this.uZn).getCurrY(), (int)f2, (int)f1, i, j, k, m, 0, 0);
          if (((MMViewPager.c(paramMotionEvent1, paramMotionEvent2)) && (f3 >= 0.0F)) || ((!MMViewPager.c(paramMotionEvent1, paramMotionEvent2)) && (f4 <= MMViewPager.b(this.uZn)))) {
            break label635;
          }
          return false;
          if (!(localObject1 instanceof WxImageView)) {
            break label664;
          }
          localObject1 = (WxImageView)localObject1;
          break;
          f2 = f1;
          if (Math.abs(f1) >= MMViewPager.w(this.uZn)) {
            f2 = -MMViewPager.w(this.uZn);
          }
          break label424;
          label600:
          f1 = paramFloat2;
          if (Math.abs(paramFloat2) >= MMViewPager.w(this.uZn)) {
            f1 = -MMViewPager.w(this.uZn);
          }
        }
        label635:
        if (MMViewPager.m(this.uZn)) {
          return false;
        }
        return MMViewPager.a(this.uZn, paramMotionEvent1, paramMotionEvent2, paramFloat1);
      }
      label664:
      localObject1 = null;
    }
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    MMViewPager.s(this.uZn);
    if (MMViewPager.p(this.uZn) != null) {
      MMViewPager.p(this.uZn).aRg();
    }
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (MMViewPager.q(this.uZn) != null) {
      MMViewPager.q(this.uZn).aBS();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.d
 * JD-Core Version:    0.7.0.1
 */