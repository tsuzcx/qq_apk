package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;

final class ak$3
  implements Runnable
{
  ak$3(ak paramak, int paramInt1, int paramInt2, h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(31712);
    this.zIi.caz.hF(this.zIj, this.zIk);
    ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 222 %s %s %s", new Object[] { Integer.valueOf(this.zIi.caz.getFirstVisiblePosition()), Integer.valueOf(this.zIi.caz.getLastVisiblePosition()), Integer.valueOf(this.zIl.getCount()) });
    AppMethodBeat.o(31712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ak.3
 * JD-Core Version:    0.7.0.1
 */