package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ai.c.a;
import com.tencent.mm.ai.c.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.g;

final class BizChatConversationUI$a$14
  implements c.a
{
  BizChatConversationUI$a$14(BizChatConversationUI.a parama) {}
  
  public final void a(c.a.a parama)
  {
    String str = BizChatConversationUI.a.d(this.veW);
    if ((parama != null) && (!bk.bl(parama.eeM)) && (parama.eeM.equals(str)))
    {
      int i = BizChatConversationUI.a.l(this.veW);
      BizChatConversationUI.a.c(this.veW, g.bw(this.veW.getContext(), str));
      if (BizChatConversationUI.a.l(this.veW) != i) {
        BizChatConversationUI.a.r(this.veW);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.a.14
 * JD-Core Version:    0.7.0.1
 */