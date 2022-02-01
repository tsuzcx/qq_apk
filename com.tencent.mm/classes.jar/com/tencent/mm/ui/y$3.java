package com.tencent.mm.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class y$3
  implements View.OnTouchListener
{
  y$3(y paramy, y.a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(249502);
    boolean bool = y.a(this.adEy, paramView, paramMotionEvent, this.adEz);
    AppMethodBeat.o(249502);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.y.3
 * JD-Core Version:    0.7.0.1
 */