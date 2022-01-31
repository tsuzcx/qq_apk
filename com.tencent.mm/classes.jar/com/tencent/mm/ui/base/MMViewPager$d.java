package com.tencent.mm.ui.base;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MMViewPager$d
  extends GestureDetector.SimpleOnGestureListener
{
  private MMViewPager$d(MMViewPager paramMMViewPager) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106903);
    if (MMViewPager.a(this.znE) == null)
    {
      AppMethodBeat.o(106903);
      return false;
    }
    if (MMViewPager.a(this.znE).getScale() <= MMViewPager.a(this.znE).getScaleRate()) {
      MMViewPager.a(this.znE).ao(f.c(paramMotionEvent, 0), f.d(paramMotionEvent, 0));
    }
    for (;;)
    {
      AppMethodBeat.o(106903);
      return true;
      MMViewPager.a(this.znE).an(f.c(paramMotionEvent, 0), f.d(paramMotionEvent, 0));
    }
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106901);
    if (MMViewPager.r(this.znE) != null) {
      MMViewPager.r(this.znE).forceFinished(true);
    }
    boolean bool = super.onDown(paramMotionEvent);
    AppMethodBeat.o(106901);
    return bool;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(106904);
    ab.d("MicroMsg.MMViewPager", "onFling");
    Object localObject2 = this.znE.getSelectedImageView();
    Object localObject1;
    float f2;
    float f5;
    float f3;
    float f4;
    float f6;
    if (localObject2 != null)
    {
      ab.d("MicroMsg.MMViewPager", "onFling MultiTouchImageView");
      if ((localObject2 instanceof MultiTouchImageView))
      {
        localObject1 = (MultiTouchImageView)localObject2;
        f2 = ((g)localObject1).getScale() * ((g)localObject1).getImageWidth();
        f5 = ((g)localObject1).getScale() * ((g)localObject1).getImageHeight();
        if ((!((g)localObject1).dDH()) && (!((g)localObject1).dDI()) && ((int)f2 <= MMViewPager.b(this.znE)) && ((int)f5 <= MMViewPager.d(this.znE))) {
          break label631;
        }
        localObject2 = new float[9];
        ((g)localObject1).getImageMatrix().getValues((float[])localObject2);
        f3 = localObject2[2];
        f4 = f3 + f2;
        f6 = localObject2[5];
        ab.d("MicroMsg.MMViewPager", "left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(MMViewPager.c(paramMotionEvent1, paramMotionEvent2)), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
        if ((Math.round(f3) < MMViewPager.t(this.znE).left) && (Math.round(f4) > MMViewPager.t(this.znE).right)) {
          break label668;
        }
      }
    }
    label411:
    label668:
    for (float f1 = 0.0F;; f1 = paramFloat1)
    {
      if ((Math.round(f6) >= MMViewPager.t(this.znE).top) || (Math.round(f6 + f5) <= MMViewPager.t(this.znE).bottom)) {
        paramFloat2 = 0.0F;
      }
      int i = (int)(MMViewPager.t(this.znE).right - f2);
      int j = (int)(f2 + MMViewPager.t(this.znE).right);
      int k = (int)(MMViewPager.t(this.znE).bottom - f5);
      int m = (int)(MMViewPager.t(this.znE).bottom + f5);
      if (f1 >= 0.0F)
      {
        f2 = f1;
        if (Math.abs(f1) >= MMViewPager.u(this.znE)) {
          f2 = MMViewPager.u(this.znE);
        }
        if (paramFloat2 < 0.0F) {
          break label596;
        }
        f1 = paramFloat2;
        if (Math.abs(paramFloat2) >= MMViewPager.u(this.znE)) {
          f1 = MMViewPager.u(this.znE);
        }
      }
      for (;;)
      {
        MMViewPager.r(this.znE).fling(MMViewPager.r(this.znE).getCurrX(), MMViewPager.r(this.znE).getCurrY(), (int)f2, (int)f1, i, j, k, m, 0, 0);
        if (((MMViewPager.c(paramMotionEvent1, paramMotionEvent2)) && (f3 >= 0.0F)) || ((!MMViewPager.c(paramMotionEvent1, paramMotionEvent2)) && (f4 <= MMViewPager.b(this.znE)))) {
          break label631;
        }
        AppMethodBeat.o(106904);
        return false;
        localObject1 = localObject2;
        if (!(localObject2 instanceof WxImageView)) {
          break;
        }
        localObject1 = (WxImageView)localObject2;
        break;
        f2 = f1;
        if (Math.abs(f1) >= MMViewPager.u(this.znE)) {
          f2 = -MMViewPager.u(this.znE);
        }
        break label411;
        label596:
        f1 = paramFloat2;
        if (Math.abs(paramFloat2) >= MMViewPager.u(this.znE)) {
          f1 = -MMViewPager.u(this.znE);
        }
      }
      label631:
      if (MMViewPager.m(this.znE))
      {
        AppMethodBeat.o(106904);
        return false;
      }
      boolean bool = MMViewPager.a(this.znE, paramMotionEvent1, paramMotionEvent2, paramFloat1);
      AppMethodBeat.o(106904);
      return bool;
    }
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106902);
    MMViewPager.s(this.znE);
    if (MMViewPager.p(this.znE) != null) {
      MMViewPager.p(this.znE).bxv();
    }
    AppMethodBeat.o(106902);
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106900);
    if (MMViewPager.q(this.znE) != null) {
      MMViewPager.q(this.znE).bdW();
    }
    AppMethodBeat.o(106900);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager.d
 * JD-Core Version:    0.7.0.1
 */