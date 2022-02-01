package com.tencent.mm.pluginsdk.ui.chat;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$4
  implements View.OnTouchListener
{
  n$4(n paramn) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(31770);
    boolean bool = n.a(this.DzN, paramView, paramMotionEvent);
    AppMethodBeat.o(31770);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.4
 * JD-Core Version:    0.7.0.1
 */