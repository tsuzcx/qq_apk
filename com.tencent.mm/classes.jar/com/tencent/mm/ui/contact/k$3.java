package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class k$3
  implements View.OnTouchListener
{
  k$3(k paramk) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(33714);
    if ((k.d(this.AcQ) instanceof MMActivity)) {
      ((MMActivity)k.d(this.AcQ)).hideVKB();
    }
    AppMethodBeat.o(33714);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k.3
 * JD-Core Version:    0.7.0.1
 */