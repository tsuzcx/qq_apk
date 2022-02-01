package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class l$3
  implements View.OnTouchListener
{
  l$3(l paraml) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(37833);
    if ((l.d(this.PVH) instanceof MMActivity)) {
      ((MMActivity)l.d(this.PVH)).hideVKB();
    }
    AppMethodBeat.o(37833);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.l.3
 * JD-Core Version:    0.7.0.1
 */