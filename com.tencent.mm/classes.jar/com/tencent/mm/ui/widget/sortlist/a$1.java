package com.tencent.mm.ui.widget.sortlist;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  extends GestureDetector.SimpleOnGestureListener
{
  a$1(a parama) {}
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(113009);
    int i;
    if ((a.a(this.ALd)) && (a.b(this.ALd)))
    {
      i = a.c(this.ALd).getWidth() / 5;
      if (paramFloat1 <= a.d(this.ALd)) {
        break label91;
      }
      if (a.e(this.ALd) > -i) {
        a.c(this.ALd).bz(paramFloat1);
      }
    }
    for (;;)
    {
      a.f(this.ALd);
      AppMethodBeat.o(113009);
      return false;
      label91:
      if ((paramFloat1 < -a.d(this.ALd)) && (a.e(this.ALd) < i)) {
        a.c(this.ALd).bz(paramFloat1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.a.1
 * JD-Core Version:    0.7.0.1
 */