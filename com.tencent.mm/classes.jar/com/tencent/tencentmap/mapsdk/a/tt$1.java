package com.tencent.tencentmap.mapsdk.a;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

final class tt$1
  implements GestureDetector.OnGestureListener
{
  tt$1(tt paramtt) {}
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    if (tt.b(this.a))
    {
      float f1 = tt.a(this.a).c().getX();
      float f2 = tt.a(this.a).c().getY();
      tt.a(this.a, true);
      tt.b(this.a, this.a.e());
      if (tt.e(this.a)) {
        this.a.g();
      }
      tt.a(this.a, f1, f2 - tt.f(this.a));
      if (tt.a(this.a).e() != null) {
        tt.a(this.a).e().c(new sa(this.a));
      }
    }
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((!tt.b(this.a)) || (!tt.c(this.a)))
    {
      tt.d(this.a).requestDisallowInterceptTouchEvent(false);
      return false;
    }
    return true;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.a.n();
    if (tt.a(this.a).d() == null)
    {
      if (this.a.e())
      {
        this.a.g();
        return true;
      }
      this.a.f();
      return true;
    }
    tt.a(this.a).d().a(new sa(this.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.tt.1
 * JD-Core Version:    0.7.0.1
 */