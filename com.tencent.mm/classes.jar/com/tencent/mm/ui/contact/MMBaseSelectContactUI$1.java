package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMBaseSelectContactUI$1
  implements View.OnTouchListener
{
  MMBaseSelectContactUI$1(MMBaseSelectContactUI paramMMBaseSelectContactUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105214);
    MMBaseSelectContactUI.a(this.Adz);
    this.Adz.dMc();
    this.Adz.dMd();
    AppMethodBeat.o(105214);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.MMBaseSelectContactUI.1
 * JD-Core Version:    0.7.0.1
 */