package com.tencent.mm.ui.widget.sortlist;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

final class a$1
  extends GestureDetector.SimpleOnGestureListener
{
  a$1(a parama) {}
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i;
    if ((a.a(this.wqA)) && (a.b(this.wqA)))
    {
      i = a.c(this.wqA).getWidth() / 5;
      if (paramFloat1 <= a.d(this.wqA)) {
        break label81;
      }
      if (a.e(this.wqA) > -i) {
        a.c(this.wqA).aO(paramFloat1);
      }
    }
    for (;;)
    {
      a.f(this.wqA);
      return false;
      label81:
      if ((paramFloat1 < -a.d(this.wqA)) && (a.e(this.wqA) < i)) {
        a.c(this.wqA).aO(paramFloat1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.a.1
 * JD-Core Version:    0.7.0.1
 */