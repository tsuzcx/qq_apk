package com.tencent.tencentmap.mapsdk.a;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class tt$3
  implements View.OnTouchListener
{
  tt$3(tt paramtt) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return tt.i(this.a).onTouchEvent(paramMotionEvent);
        if ((tt.b(this.a)) && (tt.c(this.a)))
        {
          tt.a(this.a, false);
          this.a.n();
          new StringBuilder().append(tt.e(this.a));
          if (tt.e(this.a))
          {
            this.a.f();
            tt.b(this.a, false);
          }
          if (tt.a(this.a).e() != null) {
            tt.a(this.a).e().b(new sa(this.a));
          }
        }
      }
    } while ((!tt.b(this.a)) || (!tt.c(this.a)));
    float f1 = tt.a(this.a).c().getX();
    float f2 = tt.a(this.a).c().getY();
    tt.a(this.a, f1, f2 - tt.f(this.a));
    new StringBuilder().append(f1).append(",").append(f2);
    if (tt.a(this.a).e() != null) {
      tt.a(this.a).e().a(new sa(this.a));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.tt.3
 * JD-Core Version:    0.7.0.1
 */