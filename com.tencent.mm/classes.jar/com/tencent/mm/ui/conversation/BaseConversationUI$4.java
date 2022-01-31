package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.ui.chatting.ChattingUIFragment;

final class BaseConversationUI$4
  implements Runnable
{
  BaseConversationUI$4(BaseConversationUI paramBaseConversationUI, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(34048);
    int i = 0;
    if (BaseConversationUI.access$100(this.AgT) != null) {
      i = BaseConversationUI.access$100(this.AgT).hashCode();
    }
    String str;
    if (this.AgS)
    {
      str = "ChattingUI" + BaseConversationUI.access$000(this.AgT);
      if (!this.AgS) {
        break label130;
      }
    }
    for (;;)
    {
      d.b(4, str, i);
      if (this.AgS) {
        d.o("ChattingUI" + BaseConversationUI.access$000(this.AgT), BaseConversationUI.access$400(this.AgT), ah.aox());
      }
      AppMethodBeat.o(34048);
      return;
      str = this.AgT.getLocalClassName();
      break;
      label130:
      i = this.AgT.hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.4
 * JD-Core Version:    0.7.0.1
 */