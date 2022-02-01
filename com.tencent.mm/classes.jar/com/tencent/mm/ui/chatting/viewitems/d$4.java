package com.tencent.mm.ui.chatting.viewitems;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$4
  implements View.OnTouchListener
{
  d$4(d paramd) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(254978);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(254978);
      return false;
      d.d(this.aeMN)[0] = ((int)paramMotionEvent.getRawX());
      d.d(this.aeMN)[1] = ((int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.4
 * JD-Core Version:    0.7.0.1
 */