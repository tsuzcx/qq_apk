package com.tencent.xweb.extension.video;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;

final class d$14
  implements View.OnTouchListener
{
  d$14(d paramd) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(84589);
    if (!d.c(this.BFR))
    {
      AppMethodBeat.o(84589);
      return false;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 1) && (d.d(this.BFR) == 3))
      {
        double d = d.a(this.BFR) * d.e(this.BFR) / 100.0D;
        this.BFR.f(d, true);
        d.b(this.BFR).evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", new Object[] { Double.valueOf(d) }), new d.14.1(this));
        d.f(this.BFR);
      }
      if (d.g(this.BFR) != 1) {
        break;
      }
      bool = d.h(this.BFR).onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(84589);
      return bool;
      if (paramMotionEvent.getPointerCount() == 2)
      {
        d.a(this.BFR, 1);
        continue;
        d.a(this.BFR, 0);
        continue;
        d.a(this.BFR, 0);
      }
    }
    boolean bool = d.i(this.BFR).onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(84589);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.14
 * JD-Core Version:    0.7.0.1
 */