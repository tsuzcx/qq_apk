package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.os.SystemClock;
import android.support.v4.view.n;
import android.support.v4.view.q;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.ArrayList;

public final class a
  implements View.OnTouchListener
{
  private float fSz = 1.4E-45F;
  private DummyViewPager oJe;
  private float oJf = 1.4E-45F;
  
  public a(DummyViewPager paramDummyViewPager)
  {
    this.oJe = paramDummyViewPager;
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent, float paramFloat)
  {
    boolean bool = false;
    float f1;
    float f2;
    int i;
    if (this.oJe.GY)
    {
      f1 = (int)(this.oJe.getScrollX() - paramFloat) - this.oJe.getBaseScrollX();
      f2 = this.oJe.getScrollX() - this.oJe.getBaseScrollX();
      if (Math.abs(f1 + f2) < Math.abs(f1 - f2))
      {
        i = 1;
        if (i == 0) {
          break label449;
        }
      }
    }
    label449:
    for (float f3 = this.oJe.getScrollX() - this.oJe.getBaseScrollX();; f3 = paramFloat)
    {
      DummyViewPager localDummyViewPager = this.oJe;
      if (!localDummyViewPager.GY)
      {
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        i = 0;
        break;
      }
      localDummyViewPager.GS += f3;
      float f4 = localDummyViewPager.getScrollX() - f3;
      i = localDummyViewPager.getClientWidth();
      f1 = i;
      float f6 = localDummyViewPager.GI;
      f2 = i;
      float f5 = localDummyViewPager.GJ;
      Object localObject = (AdLandingViewPager.b)localDummyViewPager.dU.get(0);
      AdLandingViewPager.b localb = (AdLandingViewPager.b)localDummyViewPager.dU.get(localDummyViewPager.dU.size() - 1);
      if (((AdLandingViewPager.b)localObject).position != 0) {}
      for (f1 = ((AdLandingViewPager.b)localObject).Hs * i;; f1 *= f6)
      {
        if (localb.position != localDummyViewPager.Gw.getCount() - 1) {}
        for (f2 = localb.Hs * i;; f2 *= f5)
        {
          if (f4 < f1) {}
          for (;;)
          {
            localDummyViewPager.GS += f1 - (int)f1;
            localDummyViewPager.scrollTo((int)f1, localDummyViewPager.getScrollY());
            localDummyViewPager.aA((int)f1);
            long l = SystemClock.uptimeMillis();
            localObject = MotionEvent.obtain(localDummyViewPager.oIS, l, 2, localDummyViewPager.GS, 0.0F, 0);
            localDummyViewPager.fB.addMovement((MotionEvent)localObject);
            ((MotionEvent)localObject).recycle();
            new StringBuilder("fake drag, diff ").append(paramFloat).append(",step ").append(f3).append(",scrollX ").append(this.oJe.getScrollX());
            c(paramView, paramMotionEvent);
            bool = true;
            return bool;
            if (f4 > f2) {
              f1 = f2;
            } else {
              f1 = f4;
            }
          }
        }
      }
    }
  }
  
  private static void c(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(0);
    paramView.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    new StringBuilder("onTouchEvent , action ").append(paramMotionEvent.getAction()).append(", e.rawY ").append(paramMotionEvent.getRawY()).append(",lastMotionY ").append(this.oJf).append(",downY ").append(this.fSz);
    label244:
    int i;
    label298:
    DummyViewPager localDummyViewPager;
    Object localObject;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return paramView.onTouchEvent(paramMotionEvent);
        this.fSz = paramMotionEvent.getRawY();
        continue;
        if ((this.fSz != 1.4E-45F) || (this.oJf != 1.4E-45F)) {
          break;
        }
        this.fSz = paramMotionEvent.getRawY();
      }
      float f2 = paramMotionEvent.getRawY();
      if (this.oJf == 1.4E-45F) {}
      for (float f1 = this.fSz;; f1 = this.oJf)
      {
        this.oJf = paramMotionEvent.getRawY();
        f1 = (f2 - f1) / 2.0F;
        new StringBuilder("scrollX ").append(this.oJe.getScrollX()).append(",basescrollX ").append(this.oJe.getBaseScrollX());
        if (this.oJe.getScrollX() == this.oJe.getBaseScrollX()) {
          break label244;
        }
        if (!a(paramView, paramMotionEvent, f1)) {
          break;
        }
        return false;
      }
      if (-f1 > 0.0F) {}
      for (i = 1;; i = -1)
      {
        if (!q.m(paramView, i)) {
          break label298;
        }
        new StringBuilder("scroll vertically  ").append(f1).append(", move.lastMotionY ").append(paramMotionEvent.getY());
        break;
      }
      localDummyViewPager = this.oJe;
      if (!localDummyViewPager.iZ)
      {
        localDummyViewPager.GY = true;
        localDummyViewPager.setScrollState(1);
        localDummyViewPager.GS = 0.0F;
        localDummyViewPager.FH = 0.0F;
        if (localDummyViewPager.fB != null) {
          break label407;
        }
        localDummyViewPager.fB = VelocityTracker.obtain();
      }
      for (;;)
      {
        long l = SystemClock.uptimeMillis();
        localObject = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
        localDummyViewPager.fB.addMovement((MotionEvent)localObject);
        ((MotionEvent)localObject).recycle();
        localDummyViewPager.oIS = l;
        a(paramView, paramMotionEvent, f1);
        c(paramView, paramMotionEvent);
        return false;
        label407:
        localDummyViewPager.fB.clear();
      }
    }
    if (this.oJe.GY) {
      try
      {
        localDummyViewPager = this.oJe;
        if (!localDummyViewPager.GY) {
          throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
      }
      catch (Exception localException) {}
    }
    for (;;)
    {
      this.fSz = 1.4E-45F;
      this.oJf = 1.4E-45F;
      break;
      localObject = localException.fB;
      ((VelocityTracker)localObject).computeCurrentVelocity(1000, localException.GV);
      i = (int)((VelocityTracker)localObject).getXVelocity(localException.fC);
      localException.GN = true;
      int j = localException.getClientWidth();
      int k = localException.getScrollX();
      localObject = localException.bFJ();
      localException.a(localException.a(((AdLandingViewPager.b)localObject).position, (k / j - ((AdLandingViewPager.b)localObject).Hs) / ((AdLandingViewPager.b)localObject).Hr, i, (int)(localException.GS - localException.FH)), true, true, i);
      localException.dO();
      localException.GY = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a
 * JD-Core Version:    0.7.0.1
 */