package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.ui.chatting.ChattingUIFragment;

final class BaseConversationUI$1
  implements Runnable
{
  BaseConversationUI$1(BaseConversationUI paramBaseConversationUI, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(34045);
    String str;
    if (this.AgS)
    {
      str = "ChattingUI" + BaseConversationUI.access$000(this.AgT);
      if (!this.AgS) {
        break label76;
      }
    }
    label76:
    for (int i = BaseConversationUI.access$100(this.AgT).hashCode();; i = this.AgT.hashCode())
    {
      d.b(3, str, i);
      AppMethodBeat.o(34045);
      return;
      str = this.AgT.getLocalClassName();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.1
 * JD-Core Version:    0.7.0.1
 */