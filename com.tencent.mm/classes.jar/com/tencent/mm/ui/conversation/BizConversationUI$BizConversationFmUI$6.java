package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class BizConversationUI$BizConversationFmUI$6
  implements MMSlideDelView.f
{
  BizConversationUI$BizConversationFmUI$6(BizConversationUI.BizConversationFmUI paramBizConversationFmUI) {}
  
  public final void cW(Object paramObject)
  {
    AppMethodBeat.i(38240);
    if (paramObject == null)
    {
      Log.e("MicroMsg.BizConversationUI", "onItemDel object null");
      AppMethodBeat.o(38240);
      return;
    }
    paramObject = paramObject.toString();
    BizConversationUI.BizConversationFmUI.b(this.XzJ, paramObject);
    AppMethodBeat.o(38240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.6
 * JD-Core Version:    0.7.0.1
 */