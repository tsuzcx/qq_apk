package com.tencent.mm.ui.bizchat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class BizChatConversationUI$BizChatConversationFmUI$2
  implements MMSlideDelView.f
{
  BizChatConversationUI$BizChatConversationFmUI$2(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI) {}
  
  public final void cZ(Object paramObject)
  {
    AppMethodBeat.i(33914);
    if (paramObject == null)
    {
      Log.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
      AppMethodBeat.o(33914);
      return;
    }
    AppMethodBeat.o(33914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.2
 * JD-Core Version:    0.7.0.1
 */