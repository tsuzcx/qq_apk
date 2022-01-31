package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;

final class ak$2
  implements Runnable
{
  ak$2(ak paramak, int paramInt1, int paramInt2, h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(31711);
    this.zIi.caz.hF(this.zIj, this.zIk);
    ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 111 %s %s %s", new Object[] { Integer.valueOf(this.zIi.caz.getFirstVisiblePosition()), Integer.valueOf(this.zIi.caz.getLastVisiblePosition()), Integer.valueOf(this.zIl.getCount()) });
    AppMethodBeat.o(31711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ak.2
 * JD-Core Version:    0.7.0.1
 */