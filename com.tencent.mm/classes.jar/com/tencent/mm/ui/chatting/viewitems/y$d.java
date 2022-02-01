package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.mm.ui.widget.textview.a.e;

final class y$d
  implements a.e
{
  private a WEu;
  
  y$d(a parama)
  {
    this.WEu = parama;
  }
  
  public final void hTP()
  {
    AppMethodBeat.i(36963);
    Log.d("OnTouchOutside", "touchOutside");
    this.WEu.cpn();
    this.WEu.YwF = true;
    this.WEu.ieg();
    this.WEu.YwE = true;
    this.WEu.ieh();
    this.WEu.iej();
    AppMethodBeat.o(36963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.d
 * JD-Core Version:    0.7.0.1
 */