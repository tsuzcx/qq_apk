package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.a.b.a;
import com.tencent.mm.ai.a.b.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class BizChatConversationUI$a$11
  implements b.a
{
  BizChatConversationUI$a$11(BizChatConversationUI.a parama) {}
  
  public final void a(b.a.b paramb)
  {
    if ((paramb != null) && (paramb.ehn != null) && (BizChatConversationUI.a.a(this.veW).equals(paramb.ehn.field_brandUserName)))
    {
      y.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
      BizChatConversationUI.a.b(this.veW).hK(paramb.ehm);
      if (BizChatConversationUI.a.q(this.veW)) {
        BizChatConversationUI.a.b(this.veW).yc();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.a.11
 * JD-Core Version:    0.7.0.1
 */