package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.platformtools.ab;

final class ak$5
  implements Runnable
{
  ak$5(ak paramak, com.tencent.mm.storage.ak paramak1) {}
  
  public final void run()
  {
    AppMethodBeat.i(31714);
    ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify updateGoBackToHistoryMessage up UnDeliver:%d, UnRead:%d", new Object[] { Integer.valueOf(this.zIn.field_UnDeliverCount), Integer.valueOf(this.zIn.field_unReadCount) });
    AppMethodBeat.o(31714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ak.5
 * JD-Core Version:    0.7.0.1
 */