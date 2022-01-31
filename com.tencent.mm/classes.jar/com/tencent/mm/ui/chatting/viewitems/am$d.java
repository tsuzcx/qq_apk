package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.mm.ui.widget.textview.a.e;
import com.tencent.mm.ui.widget.textview.a.f;

final class am$d
  implements a.e
{
  private a zCw;
  
  am$d(a parama)
  {
    this.zCw = parama;
  }
  
  public final void dLu()
  {
    AppMethodBeat.i(33319);
    ab.d("OnTouchOutside", "touchOutside");
    this.zCw.dPQ();
    this.zCw.ANk = true;
    this.zCw.dPT();
    this.zCw.ANj = true;
    this.zCw.dPU();
    a locala = this.zCw;
    if (locala.AMU != null) {
      locala.AMU.dismiss();
    }
    AppMethodBeat.o(33319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.d
 * JD-Core Version:    0.7.0.1
 */