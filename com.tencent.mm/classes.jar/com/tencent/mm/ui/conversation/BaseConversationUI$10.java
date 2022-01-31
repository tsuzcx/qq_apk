package com.tencent.mm.ui.conversation;

import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.ui.chatting.y;

final class BaseConversationUI$10
  implements Runnable
{
  BaseConversationUI$10(BaseConversationUI paramBaseConversationUI) {}
  
  public final void run()
  {
    d.b(4, "ChattingUI" + BaseConversationUI.access$000(this.vPi), BaseConversationUI.access$100(this.vPi).hashCode());
    d.h("ChattingUI" + BaseConversationUI.access$000(this.vPi), BaseConversationUI.access$400(this.vPi), ah.UX());
    d.b(3, this.vPi.getLocalClassName(), this.vPi.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.10
 * JD-Core Version:    0.7.0.1
 */