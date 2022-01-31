package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.ui.chatting.ChattingUIFragment;

final class BaseConversationUI$10
  implements Runnable
{
  BaseConversationUI$10(BaseConversationUI paramBaseConversationUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(34062);
    if (BaseConversationUI.access$100(this.AgT) == null)
    {
      AppMethodBeat.o(34062);
      return;
    }
    d.b(4, "ChattingUI" + BaseConversationUI.access$000(this.AgT), BaseConversationUI.access$100(this.AgT).hashCode());
    d.o("ChattingUI" + BaseConversationUI.access$000(this.AgT), BaseConversationUI.access$400(this.AgT), ah.aox());
    d.b(3, this.AgT.getLocalClassName(), this.AgT.hashCode());
    AppMethodBeat.o(34062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.10
 * JD-Core Version:    0.7.0.1
 */