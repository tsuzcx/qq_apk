package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.mm.ui.widget.textview.a.e;

final class x$d
  implements a.e
{
  private a aelU;
  
  x$d(a parama)
  {
    this.aelU = parama;
  }
  
  public final void jxt()
  {
    AppMethodBeat.i(36963);
    Log.d("OnTouchOutside", "touchOutside");
    this.aelU.cRQ();
    this.aelU.agoX = true;
    this.aelU.jJp();
    this.aelU.agoW = true;
    this.aelU.jJq();
    this.aelU.jJs();
    AppMethodBeat.o(36963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.d
 * JD-Core Version:    0.7.0.1
 */