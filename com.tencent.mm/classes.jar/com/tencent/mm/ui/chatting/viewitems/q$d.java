package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.mm.ui.widget.textview.a.e;

final class q$d
  implements a.e
{
  private a GqS;
  
  q$d(a parama)
  {
    this.GqS = parama;
  }
  
  public final void faO()
  {
    AppMethodBeat.i(36963);
    ad.d("OnTouchOutside", "touchOutside");
    this.GqS.fgF();
    this.GqS.HNY = true;
    this.GqS.fgI();
    this.GqS.HNX = true;
    this.GqS.fgJ();
    this.GqS.fgL();
    AppMethodBeat.o(36963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.d
 * JD-Core Version:    0.7.0.1
 */