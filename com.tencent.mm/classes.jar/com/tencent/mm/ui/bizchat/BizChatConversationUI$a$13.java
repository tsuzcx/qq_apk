package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.d.a;
import com.tencent.mm.ai.a.d.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class BizChatConversationUI$a$13
  implements d.a
{
  BizChatConversationUI$a$13(BizChatConversationUI.a parama) {}
  
  public final void a(d.a.b paramb)
  {
    if ((paramb != null) && (paramb.ehx != null) && (BizChatConversationUI.a.a(this.veW).equals(paramb.ehx.field_brandUserName)))
    {
      y.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
      BizChatConversationUI.a.b(this.veW).hK(paramb.ehm);
      if (BizChatConversationUI.a.q(this.veW)) {
        BizChatConversationUI.a.b(this.veW).yc();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.a.13
 * JD-Core Version:    0.7.0.1
 */