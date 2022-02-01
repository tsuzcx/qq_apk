package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.mm.ui.widget.textview.a.e;

final class aa$d
  implements a.e
{
  private a PkL;
  
  aa$d(a parama)
  {
    this.PkL = parama;
  }
  
  public final void gUe()
  {
    AppMethodBeat.i(37033);
    Log.d("OnTouchOutside", "touchOutside");
    this.PkL.hbA();
    this.PkL.QXX = true;
    this.PkL.hcR();
    this.PkL.QXW = true;
    this.PkL.hcS();
    this.PkL.hcU();
    AppMethodBeat.o(37033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.d
 * JD-Core Version:    0.7.0.1
 */