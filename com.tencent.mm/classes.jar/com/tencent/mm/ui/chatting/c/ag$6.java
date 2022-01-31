package com.tencent.mm.ui.chatting.c;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.d.a;

final class ag$6
  implements View.OnTouchListener
{
  ag$6(ag paramag) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(31647);
    this.zHJ.caz.hideVKB();
    AppMethodBeat.o(31647);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ag.6
 * JD-Core Version:    0.7.0.1
 */