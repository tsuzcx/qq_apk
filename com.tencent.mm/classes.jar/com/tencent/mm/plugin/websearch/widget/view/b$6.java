package com.tencent.mm.plugin.websearch.widget.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$6
  implements View.OnTouchListener
{
  b$6(b paramb) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(116708);
    this.IIZ.IIO[0] = paramMotionEvent.getX();
    this.IIZ.IIO[1] = paramMotionEvent.getY();
    AppMethodBeat.o(116708);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b.6
 * JD-Core Version:    0.7.0.1
 */