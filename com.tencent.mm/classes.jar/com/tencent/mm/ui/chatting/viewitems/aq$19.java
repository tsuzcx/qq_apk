package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.w;

final class aq$19
  implements Runnable
{
  aq$19(aq paramaq) {}
  
  public final void run()
  {
    AppMethodBeat.i(255643);
    if ((aq.n(this.aeTe) != null) && (aq.n(this.aeTe).isShowing())) {
      aq.n(this.aeTe).dismiss();
    }
    AppMethodBeat.o(255643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.19
 * JD-Core Version:    0.7.0.1
 */