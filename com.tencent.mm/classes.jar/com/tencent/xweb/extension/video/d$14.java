package com.tencent.xweb.extension.video;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.xweb.WebView;

final class d$14
  implements View.OnTouchListener
{
  d$14(d paramd) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!d.c(this.xiF)) {
      return false;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 1) && (d.d(this.xiF) == 3))
      {
        double d = d.a(this.xiF) * d.e(this.xiF) / 100.0D;
        this.xiF.e(d, true);
        d.b(this.xiF).evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", new Object[] { Double.valueOf(d) }), new d.14.1(this));
        d.f(this.xiF);
      }
      if (d.g(this.xiF) != 1) {
        break;
      }
      return d.h(this.xiF).onTouchEvent(paramMotionEvent);
      if (paramMotionEvent.getPointerCount() == 2)
      {
        d.a(this.xiF, 1);
        continue;
        d.a(this.xiF, 0);
        continue;
        d.a(this.xiF, 0);
      }
    }
    return d.i(this.xiF).onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.14
 * JD-Core Version:    0.7.0.1
 */