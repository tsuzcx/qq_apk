package com.tencent.mm.ui.widget.textview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$10
  implements View.OnTouchListener
{
  a$10(a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113127);
    if (this.ANs.AMV != null) {
      this.ANs.AMV.onTouch(paramView, paramMotionEvent);
    }
    this.ANs.AMY = ((int)paramMotionEvent.getX());
    this.ANs.AMZ = ((int)paramMotionEvent.getY());
    AppMethodBeat.o(113127);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.10
 * JD-Core Version:    0.7.0.1
 */