package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$2
  implements MMSlideDelView.f
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$2(EnterpriseConversationUI.EnterpriseConversationFmUI paramEnterpriseConversationFmUI) {}
  
  public final void bC(Object paramObject)
  {
    AppMethodBeat.i(34418);
    if (paramObject == null)
    {
      ab.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
      AppMethodBeat.o(34418);
      return;
    }
    paramObject = paramObject.toString();
    EnterpriseConversationUI.EnterpriseConversationFmUI.a(this.AkO, paramObject);
    AppMethodBeat.o(34418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.2
 * JD-Core Version:    0.7.0.1
 */