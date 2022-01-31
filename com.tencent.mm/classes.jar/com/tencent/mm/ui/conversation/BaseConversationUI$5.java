package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.tools.TestTimeForChatting;

final class BaseConversationUI$5
  implements Runnable
{
  BaseConversationUI$5(BaseConversationUI paramBaseConversationUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(34049);
    aw.RO().dtd();
    al.Nf(0);
    this.AgT.onSwipe(1.0F);
    if ((BaseConversationUI.access$200(this.AgT) != null) && (BaseConversationUI.access$100(this.AgT) != null)) {
      BaseConversationUI.access$200(this.AgT).dOc();
    }
    BaseConversationUI.access$500(this.AgT).onEnterEnd();
    BaseConversationUI.access$600(this.AgT);
    AppMethodBeat.o(34049);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(34050);
    String str = super.toString() + "|chattingView_onAnimationEnd";
    AppMethodBeat.o(34050);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.5
 * JD-Core Version:    0.7.0.1
 */