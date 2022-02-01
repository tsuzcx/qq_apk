package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.os.SystemClock;
import android.support.v4.view.t;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;

public final class b
  implements View.OnTouchListener
{
  private float cNR = 1.4E-45F;
  private DummyViewPager zZN;
  private float zZO = 1.4E-45F;
  
  public b(DummyViewPager paramDummyViewPager)
  {
    this.zZN = paramDummyViewPager;
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent, float paramFloat)
  {
    AppMethodBeat.i(97059);
    if (this.zZN.mFakeDragging) {
      if (!af((int)(this.zZN.getScrollX() - paramFloat) - this.zZN.getBaseScrollX(), this.zZN.getScrollX() - this.zZN.getBaseScrollX())) {
        break label142;
      }
    }
    label142:
    for (float f = this.zZN.getScrollX() - this.zZN.getBaseScrollX();; f = paramFloat)
    {
      this.zZN.fakeDragBy(f);
      new StringBuilder("fake drag, diff ").append(paramFloat).append(",step ").append(f).append(",scrollX ").append(this.zZN.getScrollX());
      d(paramView, paramMotionEvent);
      AppMethodBeat.o(97059);
      return true;
      AppMethodBeat.o(97059);
      return false;
    }
  }
  
  private static boolean af(float paramFloat1, float paramFloat2)
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
  
  private static void d(View paramView, MotionEvent paramMotionEvent)
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
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/VerticalVPOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    new StringBuilder("onTouchEvent , action ").append(paramMotionEvent.getAction()).append(", e.rawY ").append(paramMotionEvent.getRawY()).append(",lastMotionY ").append(this.zZO).append(",downY ").append(this.cNR);
    label329:
    int i;
    label383:
    Object localObject2;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        boolean bool = paramView.onTouchEvent(paramMotionEvent);
        a.a(bool, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/VerticalVPOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(97058);
        return bool;
        this.cNR = paramMotionEvent.getRawY();
        continue;
        if ((this.cNR != 1.4E-45F) || (this.zZO != 1.4E-45F)) {
          break;
        }
        this.cNR = paramMotionEvent.getRawY();
      }
      float f2 = paramMotionEvent.getRawY();
      if (this.zZO == 1.4E-45F) {}
      for (float f1 = this.cNR;; f1 = this.zZO)
      {
        this.zZO = paramMotionEvent.getRawY();
        f1 = (f2 - f1) / 2.0F;
        new StringBuilder("scrollX ").append(this.zZN.getScrollX()).append(",basescrollX ").append(this.zZN.getBaseScrollX());
        if (this.zZN.getScrollX() == this.zZN.getBaseScrollX()) {
          break label329;
        }
        if (!a(paramView, paramMotionEvent, f1)) {
          break;
        }
        a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/VerticalVPOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(97058);
        return false;
      }
      if (-f1 > 0.0F) {}
      for (i = 1;; i = -1)
      {
        if (!t.o(paramView, i)) {
          break label383;
        }
        new StringBuilder("scroll vertically  ").append(f1).append(", move.lastMotionY ").append(paramMotionEvent.getY());
        break;
      }
      localObject1 = this.zZN;
      if (!((AdLandingViewPager)localObject1).mIsBeingDragged)
      {
        ((AdLandingViewPager)localObject1).mFakeDragging = true;
        ((AdLandingViewPager)localObject1).setScrollState(1);
        ((AdLandingViewPager)localObject1).mLastMotionX = 0.0F;
        ((AdLandingViewPager)localObject1).mInitialMotionX = 0.0F;
        if (((AdLandingViewPager)localObject1).mVelocityTracker != null) {
          break label510;
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
        a(paramView, paramMotionEvent, f1);
        d(paramView, paramMotionEvent);
        a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/verticalviewpager/VerticalVPOnTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(97058);
        return false;
        label510:
        ((AdLandingViewPager)localObject1).mVelocityTracker.clear();
      }
    }
    if (this.zZN.mFakeDragging) {
      try
      {
        localObject1 = this.zZN;
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
      this.cNR = 1.4E-45F;
      this.zZO = 1.4E-45F;
      break;
      localObject2 = localException.mVelocityTracker;
      ((VelocityTracker)localObject2).computeCurrentVelocity(1000, localException.mMaximumVelocity);
      i = (int)((VelocityTracker)localObject2).getXVelocity(localException.mActivePointerId);
      localException.mPopulatePending = true;
      int j = localException.getClientWidth();
      int k = localException.getScrollX();
      localObject2 = localException.ebe();
      localException.setCurrentItemInternal(localException.determineTargetPage(((AdLandingViewPager.b)localObject2).position, (k / j - ((AdLandingViewPager.b)localObject2).offset) / ((AdLandingViewPager.b)localObject2).widthFactor, i, (int)(localException.mLastMotionX - localException.mInitialMotionX)), true, true, i);
      localException.endDrag();
      localException.mFakeDragging = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b
 * JD-Core Version:    0.7.0.1
 */