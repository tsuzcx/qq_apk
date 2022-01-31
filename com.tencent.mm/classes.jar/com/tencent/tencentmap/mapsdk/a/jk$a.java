package com.tencent.tencentmap.mapsdk.a;

import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class jk$a
  extends GestureDetector.SimpleOnGestureListener
{
  private PointF b = new PointF();
  private boolean c = true;
  
  private jk$a(jk paramjk) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return true;
    case 0: 
      this.c = true;
      jk.c(this.a).setIsLongpressEnabled(false);
      this.b.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      jk.a(this.a).f(f1, f2);
      return true;
    case 1: 
      if (this.c)
      {
        if (!jk.a(this.a, f1, f2)) {
          break label159;
        }
        jk.a(this.a).a(f1, f2);
      }
      for (;;)
      {
        this.b.set(0.0F, 0.0F);
        jk.c(this.a).setIsLongpressEnabled(true);
        jk.a(this.a).h(f1, f2);
        return true;
        label159:
        jk.a(this.a).a(f1, f2);
      }
    }
    float f3 = this.b.x;
    float f4 = this.b.y;
    if ((Math.abs(f1 - f3) > 10.0F) || (Math.abs(f2 - f4) > 10.0F))
    {
      this.c = false;
      jk.a(this.a).g(f1, f2);
    }
    jk.c(this.a).setIsLongpressEnabled(true);
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    jk.a(this.a).c(paramFloat1, paramFloat2);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (!jk.b(this.a)) {
      jk.a(this.a).e(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    jk.a(this.a).d(-paramFloat1, -paramFloat2);
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    jk.a(this.a).b(f1, f2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jk.a
 * JD-Core Version:    0.7.0.1
 */