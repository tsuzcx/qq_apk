package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.mm.ui.widget.textview.a.e;

final class u$d
  implements a.e
{
  private a HQK;
  
  u$d(a parama)
  {
    this.HQK = parama;
  }
  
  public final void fqE()
  {
    AppMethodBeat.i(37033);
    ac.d("OnTouchOutside", "touchOutside");
    this.HQK.fwF();
    this.HQK.Jou = true;
    this.HQK.fwI();
    this.HQK.Jot = true;
    this.HQK.fwJ();
    this.HQK.fwL();
    AppMethodBeat.o(37033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.d
 * JD-Core Version:    0.7.0.1
 */