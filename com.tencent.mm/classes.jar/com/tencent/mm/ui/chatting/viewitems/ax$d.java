package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.mm.ui.widget.textview.a.e;

final class ax$d
  implements a.e
{
  private a JZr;
  
  ax$d(a parama)
  {
    this.JZr = parama;
  }
  
  public final void fLJ()
  {
    AppMethodBeat.i(37418);
    ae.d("OnTouchOutside", "touchOutside");
    this.JZr.fRO();
    this.JZr.LCt = true;
    this.JZr.fRR();
    this.JZr.LCs = true;
    this.JZr.fRS();
    this.JZr.fRU();
    AppMethodBeat.o(37418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax.d
 * JD-Core Version:    0.7.0.1
 */