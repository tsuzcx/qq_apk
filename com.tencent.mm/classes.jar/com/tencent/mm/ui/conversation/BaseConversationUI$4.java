package com.tencent.mm.ui.conversation;

import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.ui.chatting.y;

final class BaseConversationUI$4
  implements Runnable
{
  BaseConversationUI$4(BaseConversationUI paramBaseConversationUI, boolean paramBoolean) {}
  
  public final void run()
  {
    String str;
    if (this.vPh)
    {
      str = "ChattingUI" + BaseConversationUI.access$000(this.vPi);
      if (!this.vPh) {
        break label108;
      }
    }
    label108:
    for (int i = BaseConversationUI.access$100(this.vPi).hashCode();; i = this.vPi.hashCode())
    {
      d.b(4, str, i);
      if (this.vPh) {
        d.h("ChattingUI" + BaseConversationUI.access$000(this.vPi), BaseConversationUI.access$400(this.vPi), ah.UX());
      }
      return;
      str = this.vPi.getLocalClassName();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.4
 * JD-Core Version:    0.7.0.1
 */