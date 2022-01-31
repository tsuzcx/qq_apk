package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.ui.chatting.ChattingUIFragment;

final class BaseConversationUI$8$1
  implements Runnable
{
  BaseConversationUI$8$1(BaseConversationUI.8 param8) {}
  
  public final void run()
  {
    AppMethodBeat.i(34057);
    if (BaseConversationUI.access$100(this.AgW.AgT) != null)
    {
      d.b(4, this.AgW.AgT.getLocalClassName(), this.AgW.AgT.hashCode());
      d.b(3, "ChattingUI" + BaseConversationUI.access$100(this.AgW.AgT).getIdentityString(), BaseConversationUI.access$100(this.AgW.AgT).hashCode());
    }
    AppMethodBeat.o(34057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.8.1
 * JD-Core Version:    0.7.0.1
 */