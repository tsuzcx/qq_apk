package com.tencent.mm.ui.transmit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.ui.widget.b.c;

final class MsgRetransmitUI$2
  implements g
{
  MsgRetransmitUI$2(MsgRetransmitUI paramMsgRetransmitUI) {}
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(35062);
    if ((MsgRetransmitUI.b(this.Azx) == null) || (paramInt2 == 0))
    {
      AppMethodBeat.o(35062);
      return;
    }
    paramInt1 = (int)(paramInt1 * 100L / paramInt2);
    MsgRetransmitUI.b(this.Azx).setMessage(this.Azx.getString(2131301646, new Object[] { Integer.valueOf(MsgRetransmitUI.c(this.Azx)), Integer.valueOf(MsgRetransmitUI.d(this.Azx)), Integer.valueOf(paramInt1) }));
    AppMethodBeat.o(35062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.2
 * JD-Core Version:    0.7.0.1
 */