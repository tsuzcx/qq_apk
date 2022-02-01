package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements View.OnTouchListener
{
  private DummyViewPager QTV;
  private float QTW = 1.4E-45F;
  private float fig = 1.4E-45F;
  
  public b(DummyViewPager paramDummyViewPager)
  {
    this.QTV = paramDummyViewPager;
  }
  
  private static boolean aU(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(97061);
    if (Math.abs(paramFloat1 + paramFloat2) < Math.abs(paramFloat1 - paramFloat2))
    {
      AppMethodBeat.o(97061);
      return true;
    }
    AppMethodBeat.o(97061);
    return false;
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent, float paramFloat)
  {
    AppMethodBeat.i(97059);
    if (this.QTV.mFakeDragging) {
      if (!aU((int)(this.QTV.getScrollX() - paramFloat) - this.QTV.getBaseScrollX(), this.QTV.getScrollX() - this.QTV.getBaseScrollX())) {
        break label142;
      }
    }
    label142:
    for (float f = this.QTV.getScrollX() - this.QTV.getBaseScrollX();; f = paramFloat)
    {
      this.QTV.fakeDragBy(f);
      new StringBuilder("fake drag, diff ").append(paramFloat).append(",step ").append(f).append(",scrollX ").append(this.QTV.getScrollX());
      n(paramView, paramMotionEvent);
      AppMethodBeat.o(97059);
      return true;
      AppMethodBeat.o(97059);
      return false;
    }
  }
  
  private static void n(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97060);
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(0);
    paramView.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(97060);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97058);
    new StringBuilder("onTouchEvent , action ").append(paramMotionEvent.getAction()).append(", e.rawY ").append(paramMotionEvent.getRawY()).append(",lastMotionY ").append(this.QTW).append(",downY ").append(this.fig);
    label262:
    int i;
    label316:
    Object localObject1;
    Object localObject2;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        boolean bool = paramView.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(97058);
        return bool;
        this.fig = paramMotionEvent.getRawY();
        continue;
        if ((this.fig != 1.4E-45F) || (this.QTW != 1.4E-45F)) {
          break;
        }
        this.fig = paramMotionEvent.getRawY();
      }
      float f2 = paramMotionEvent.getRawY();
      if (this.QTW == 1.4E-45F) {}
      for (float f1 = this.fig;; f1 = this.QTW)
      {
        this.QTW = paramMotionEvent.getRawY();
        f1 = (f2 - f1) / 2.0F;
        new StringBuilder("scrollX ").append(this.QTV.getScrollX()).append(",basescrollX ").append(this.QTV.getBaseScrollX());
        if (this.QTV.getScrollX() == this.QTV.getBaseScrollX()) {
          break label262;
        }
        if (!b(paramView, paramMotionEvent, f1)) {
          break;
        }
        AppMethodBeat.o(97058);
        return false;
      }
      if (-f1 > 0.0F) {}
      for (i = 1;; i = -1)
      {
        if (!z.o(paramView, i)) {
          break label316;
        }
        new StringBuilder("scroll vertically  ").append(f1).append(", move.lastMotionY ").append(paramMotionEvent.getY());
        break;
      }
      localObject1 = this.QTV;
      if (!((AdLandingViewPager)localObject1).mIsBeingDragged)
      {
        ((AdLandingViewPager)localObject1).mFakeDragging = true;
        ((AdLandingViewPager)localObject1).setScrollState(1);
        ((AdLandingViewPager)localObject1).mLastMotionX = 0.0F;
        ((AdLandingViewPager)localObject1).mInitialMotionX = 0.0F;
        if (((AdLandingViewPager)localObject1).mVelocityTracker != null) {
          break label430;
        }
        ((AdLandingViewPager)localObject1).mVelocityTracker = VelocityTracker.obtain();
      }
      for (;;)
      {
        long l = SystemClock.uptimeMillis();
        localObject2 = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
        ((AdLandingViewPager)localObject1).mVelocityTracker.addMovement((MotionEvent)localObject2);
        ((MotionEvent)localObject2).recycle();
        ((AdLandingViewPager)localObject1).mFakeDragBeginTime = l;
        b(paramView, paramMotionEvent, f1);
        n(paramView, paramMotionEvent);
        AppMethodBeat.o(97058);
        return false;
        label430:
        ((AdLandingViewPager)localObject1).mVelocityTracker.clear();
      }
    }
    if (this.QTV.mFakeDragging) {
      try
      {
        localObject1 = this.QTV;
        if (!((AdLandingViewPager)localObject1).mFakeDragging)
        {
          localObject1 = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
          AppMethodBeat.o(97058);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException) {}
    }
    for (;;)
    {
      this.fig = 1.4E-45F;
      this.QTW = 1.4E-45F;
      break;
      localObject2 = localException.mVelocityTracker;
      ((VelocityTracker)localObject2).computeCurrentVelocity(1000, localException.mMaximumVelocity);
      i = (int)((VelocityTracker)localObject2).getXVelocity(localException.mActivePointerId);
      localException.mPopulatePending = true;
      int j = localException.getClientWidth();
      int k = localException.getScrollX();
      localObject2 = localException.hjS();
      localException.setCurrentItemInternal(localException.determineTargetPage(((AdLandingViewPager.b)localObject2).position, (k / j - ((AdLandingViewPager.b)localObject2).offset) / ((AdLandingViewPager.b)localObject2).widthFactor, i, (int)(localException.mLastMotionX - localException.mInitialMotionX)), true, true, i);
      localException.endDrag();
      localException.mFakeDragging = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b
 * JD-Core Version:    0.7.0.1
 */