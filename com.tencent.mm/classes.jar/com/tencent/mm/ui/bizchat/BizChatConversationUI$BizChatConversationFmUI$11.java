package com.tencent.mm.ui.bizchat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.a;
import com.tencent.mm.aj.a.b.a;
import com.tencent.mm.aj.a.b.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class BizChatConversationUI$BizChatConversationFmUI$11
  implements b.a
{
  BizChatConversationUI$BizChatConversationFmUI$11(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI) {}
  
  public final void a(b.a.b paramb)
  {
    AppMethodBeat.i(30068);
    if ((paramb != null) && (paramb.fxr != null) && (BizChatConversationUI.BizChatConversationFmUI.a(this.ztv).equals(paramb.fxr.field_brandUserName)))
    {
      ab.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
      BizChatConversationUI.BizChatConversationFmUI.b(this.ztv).ov(paramb.fxq);
      if (BizChatConversationUI.BizChatConversationFmUI.q(this.ztv)) {
        BizChatConversationUI.BizChatConversationFmUI.b(this.ztv).Ku();
      }
    }
    AppMethodBeat.o(30068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.11
 * JD-Core Version:    0.7.0.1
 */