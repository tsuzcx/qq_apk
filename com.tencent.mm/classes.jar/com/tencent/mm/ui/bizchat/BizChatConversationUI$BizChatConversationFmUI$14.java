package com.tencent.mm.ui.bizchat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c.a;
import com.tencent.mm.aj.c.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.g;

final class BizChatConversationUI$BizChatConversationFmUI$14
  implements c.a
{
  BizChatConversationUI$BizChatConversationFmUI$14(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI) {}
  
  public final void a(c.a.a parama)
  {
    AppMethodBeat.i(30071);
    String str = BizChatConversationUI.BizChatConversationFmUI.d(this.ztv);
    if ((parama != null) && (!bo.isNullOrNil(parama.fuO)) && (parama.fuO.equals(str)))
    {
      int i = BizChatConversationUI.BizChatConversationFmUI.l(this.ztv);
      BizChatConversationUI.BizChatConversationFmUI.c(this.ztv, g.bJ(this.ztv.getContext(), str));
      if (BizChatConversationUI.BizChatConversationFmUI.l(this.ztv) != i) {
        BizChatConversationUI.BizChatConversationFmUI.r(this.ztv);
      }
    }
    AppMethodBeat.o(30071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.14
 * JD-Core Version:    0.7.0.1
 */