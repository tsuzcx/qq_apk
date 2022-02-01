package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.mm.ui.widget.textview.a.e;

final class v$d
  implements a.e
{
  private a JZr;
  
  v$d(a parama)
  {
    this.JZr = parama;
  }
  
  public final void fLJ()
  {
    AppMethodBeat.i(37033);
    ae.d("OnTouchOutside", "touchOutside");
    this.JZr.fRO();
    this.JZr.LCt = true;
    this.JZr.fRR();
    this.JZr.LCs = true;
    this.JZr.fRS();
    this.JZr.fRU();
    AppMethodBeat.o(37033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.d
 * JD-Core Version:    0.7.0.1
 */