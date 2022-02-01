package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.mm.ui.widget.textview.a.e;

final class ab$d
  implements a.e
{
  private a aelU;
  
  ab$d(a parama)
  {
    this.aelU = parama;
  }
  
  public final void jxt()
  {
    AppMethodBeat.i(37033);
    Log.d("OnTouchOutside", "touchOutside");
    this.aelU.cRQ();
    this.aelU.agoX = true;
    this.aelU.jJp();
    this.aelU.agoW = true;
    this.aelU.jJq();
    this.aelU.jJs();
    AppMethodBeat.o(37033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.d
 * JD-Core Version:    0.7.0.1
 */