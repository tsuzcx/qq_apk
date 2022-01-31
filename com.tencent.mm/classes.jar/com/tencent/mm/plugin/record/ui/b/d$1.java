package com.tencent.mm.plugin.record.ui.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1
  implements View.OnTouchListener
{
  d$1(d paramd) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153638);
    if (paramMotionEvent.getAction() == 0)
    {
      this.qau.jUm = ((int)paramMotionEvent.getRawX());
      this.qau.jUn = ((int)paramMotionEvent.getRawY());
    }
    AppMethodBeat.o(153638);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.d.1
 * JD-Core Version:    0.7.0.1
 */