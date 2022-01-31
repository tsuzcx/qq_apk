package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class w$2
  implements View.OnTouchListener
{
  w$2(w paramw) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(33812);
    if ((w.b(this.Aez) instanceof MMActivity)) {
      ((MMActivity)w.b(this.Aez)).hideVKB();
    }
    AppMethodBeat.o(33812);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.w.2
 * JD-Core Version:    0.7.0.1
 */