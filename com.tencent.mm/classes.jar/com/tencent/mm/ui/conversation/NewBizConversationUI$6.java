package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class NewBizConversationUI$6
  implements MMSlideDelView.f
{
  NewBizConversationUI$6(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final void bg(Object paramObject)
  {
    if (paramObject == null)
    {
      y.e("MicroMsg.NewBizConversationUI", "onItemDel object null");
      return;
    }
    paramObject = paramObject.toString();
    NewBizConversationUI.b(this.vTG, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.6
 * JD-Core Version:    0.7.0.1
 */