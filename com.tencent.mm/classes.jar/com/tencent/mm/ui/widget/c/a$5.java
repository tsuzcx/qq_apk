package com.tencent.mm.ui.widget.c;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;

final class a$5
  implements View.OnTouchListener
{
  a$5(a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(112759);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(112759);
      return false;
      a.Rt((int)paramMotionEvent.getRawX());
      a.Ru((int)paramMotionEvent.getRawY());
      a.b(this.AIL, a.e(this.AIL));
      a.dPm();
      ak.i("MicroMsg.MMPopupMenu", "popmenu view set , x_down=" + a.bjJ() + "y_down=" + a.cQS(), new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.c.a.5
 * JD-Core Version:    0.7.0.1
 */