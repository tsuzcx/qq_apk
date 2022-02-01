package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.mm.ui.widget.textview.a.e;

final class v$d
  implements a.e
{
  private a JEA;
  
  v$d(a parama)
  {
    this.JEA = parama;
  }
  
  public final void fHr()
  {
    AppMethodBeat.i(37033);
    ad.d("OnTouchOutside", "touchOutside");
    this.JEA.fNt();
    this.JEA.LfR = true;
    this.JEA.fNw();
    this.JEA.LfQ = true;
    this.JEA.fNx();
    this.JEA.fNz();
    AppMethodBeat.o(37033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.d
 * JD-Core Version:    0.7.0.1
 */