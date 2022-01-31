package com.tencent.mm.ui.chatting.viewitems;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.textview.a.f;

final class c$c$3
  implements PopupWindow.OnDismissListener
{
  c$c$3(c.c paramc) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(138191);
    if (c.c.c(this.zRJ) != null) {
      c.c.c(this.zRJ).dismiss();
    }
    AppMethodBeat.o(138191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c.c.3
 * JD-Core Version:    0.7.0.1
 */