package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class BizConversationUI$a$5
  implements MMSlideDelView.f
{
  BizConversationUI$a$5(BizConversationUI.a parama) {}
  
  public final void bg(Object paramObject)
  {
    if (paramObject == null)
    {
      y.e("MicroMsg.BizConversationUI", "onItemDel object null");
      return;
    }
    paramObject = paramObject.toString();
    BizConversationUI.a.b(this.vPu, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.a.5
 * JD-Core Version:    0.7.0.1
 */