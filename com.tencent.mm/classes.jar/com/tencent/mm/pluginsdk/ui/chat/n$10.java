package com.tencent.mm.pluginsdk.ui.chat;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$10
  implements View.OnTouchListener
{
  n$10(n paramn) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(27982);
    boolean bool = n.a(this.vZW, paramView, paramMotionEvent);
    AppMethodBeat.o(27982);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.10
 * JD-Core Version:    0.7.0.1
 */