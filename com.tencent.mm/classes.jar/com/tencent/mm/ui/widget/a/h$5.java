package com.tencent.mm.ui.widget.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$5
  implements View.OnTouchListener
{
  boolean Gxf = false;
  
  h$5(h paramh, ViewParent paramViewParent) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251884);
    this.uaG.getParent().requestDisallowInterceptTouchEvent(true);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(251884);
      return true;
      this.Gxf = true;
      continue;
      if (this.Gxf) {
        this.agfG.cyW();
      }
      this.Gxf = false;
      continue;
      this.Gxf = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.h.5
 * JD-Core Version:    0.7.0.1
 */