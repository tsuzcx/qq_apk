package com.tencent.mm.ui.conversation;

import com.tencent.mm.ai.c.a;
import com.tencent.mm.ai.c.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.g;

final class EnterpriseConversationUI$a$10
  implements c.a
{
  EnterpriseConversationUI$a$10(EnterpriseConversationUI.a parama) {}
  
  public final void a(c.a.a parama)
  {
    if ((parama != null) && (!bk.bl(parama.eeM)) && (parama.eeM.equals(EnterpriseConversationUI.a.c(this.vSW))))
    {
      int i = EnterpriseConversationUI.a.e(this.vSW);
      EnterpriseConversationUI.a.b(this.vSW, g.bw(this.vSW.getContext(), EnterpriseConversationUI.a.c(this.vSW)));
      if (EnterpriseConversationUI.a.e(this.vSW) != i) {
        EnterpriseConversationUI.a.q(this.vSW);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.a.10
 * JD-Core Version:    0.7.0.1
 */