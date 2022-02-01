package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s$g
  implements View.OnTouchListener
{
  private int[] HOb;
  
  public s$g()
  {
    AppMethodBeat.i(34598);
    this.HOb = new int[2];
    AppMethodBeat.o(34598);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34599);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34599);
      return false;
      this.HOb[0] = ((int)paramMotionEvent.getRawX());
      this.HOb[1] = ((int)paramMotionEvent.getRawY());
      paramView.setTag(2131306044, this.HOb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.g
 * JD-Core Version:    0.7.0.1
 */