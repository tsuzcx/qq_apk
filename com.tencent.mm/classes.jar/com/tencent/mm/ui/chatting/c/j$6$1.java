package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.snackbar.a.c;

final class j$6$1
  implements a.c
{
  j$6$1(j.6 param6) {}
  
  public final void cPa()
  {
    AppMethodBeat.i(31316);
    ((o)this.zEY.zET.caz.ay(o.class)).dIo();
    AppMethodBeat.o(31316);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(31315);
    this.zEY.zET.dHU();
    AppMethodBeat.o(31315);
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(31314);
    this.zEY.zET.dHU();
    j.b(this.zEY.zET).setVisibility(4);
    AppMethodBeat.o(31314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j.6.1
 * JD-Core Version:    0.7.0.1
 */