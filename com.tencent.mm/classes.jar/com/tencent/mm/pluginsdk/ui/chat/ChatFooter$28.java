package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

final class ChatFooter$28
  implements Runnable
{
  ChatFooter$28(ChatFooter paramChatFooter, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(153705);
    ChatFooter.q(this.vXU).setVisibility(4);
    if (this.inP != null) {
      this.inP.run();
    }
    AppMethodBeat.o(153705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.28
 * JD-Core Version:    0.7.0.1
 */