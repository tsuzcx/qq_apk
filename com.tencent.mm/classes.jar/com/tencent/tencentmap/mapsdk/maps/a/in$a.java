package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

class in$a
  extends GestureDetector.SimpleOnGestureListener
{
  private PointF b;
  private boolean c;
  
  private in$a(in paramin)
  {
    AppMethodBeat.i(148567);
    this.b = new PointF();
    this.c = true;
    AppMethodBeat.o(148567);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148572);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(148572);
      return true;
      this.c = true;
      in.d(this.a).setIsLongpressEnabled(false);
      this.b.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      in.a(this.a).f(f1, f2);
      continue;
      if (this.c)
      {
        if (!in.a(this.a, f1, f2)) {
          break label170;
        }
        in.a(this.a).a(f1, f2);
      }
      for (;;)
      {
        this.b.set(0.0F, 0.0F);
        in.d(this.a).setIsLongpressEnabled(true);
        in.a(this.a).h(f1, f2);
        break;
        label170:
        in.a(this.a).a(f1, f2);
      }
      float f3 = this.b.x;
      float f4 = this.b.y;
      if ((Math.abs(f1 - f3) > 10.0F) || (Math.abs(f2 - f4) > 10.0F))
      {
        this.c = false;
        in.a(this.a).g(f1, f2);
      }
      in.d(this.a).setIsLongpressEnabled(true);
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148569);
    in.a(this.a).c(paramFloat1, paramFloat2);
    AppMethodBeat.o(148569);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148571);
    if (!in.c(this.a)) {
      in.a(this.a).e(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    AppMethodBeat.o(148571);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148570);
    if ((in.b(this.a) != null) && (in.b(this.a).get() != null) && (((ib)in.b(this.a).get()).m()))
    {
      double d = Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
      if (((paramMotionEvent1 != null) && ((paramMotionEvent1.getX() < 0.0F) || (paramMotionEvent1.getY() < 0.0F))) || ((paramMotionEvent2 != null) && ((paramMotionEvent2.getX() < 0.0F) || (paramMotionEvent2.getY() < 0.0F))) || (d > 50.0D))
      {
        AppMethodBeat.o(148570);
        return true;
      }
    }
    in.a(this.a).d(-paramFloat1, -paramFloat2);
    AppMethodBeat.o(148570);
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148568);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    in.a(this.a).b(f1, f2);
    AppMethodBeat.o(148568);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.in.a
 * JD-Core Version:    0.7.0.1
 */