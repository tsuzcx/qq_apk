package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c.a;
import com.tencent.mm.aj.c.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.g;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$10
  implements c.a
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$10(EnterpriseConversationUI.EnterpriseConversationFmUI paramEnterpriseConversationFmUI) {}
  
  public final void a(c.a.a parama)
  {
    AppMethodBeat.i(34428);
    if ((parama != null) && (!bo.isNullOrNil(parama.fuO)) && (parama.fuO.equals(EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.AkO))))
    {
      int i = EnterpriseConversationUI.EnterpriseConversationFmUI.e(this.AkO);
      EnterpriseConversationUI.EnterpriseConversationFmUI.b(this.AkO, g.bJ(this.AkO.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.AkO)));
      if (EnterpriseConversationUI.EnterpriseConversationFmUI.e(this.AkO) != i) {
        EnterpriseConversationUI.EnterpriseConversationFmUI.q(this.AkO);
      }
    }
    AppMethodBeat.o(34428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.10
 * JD-Core Version:    0.7.0.1
 */