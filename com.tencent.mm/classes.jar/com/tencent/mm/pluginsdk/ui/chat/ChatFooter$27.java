package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatFooter$27
  implements Runnable
{
  ChatFooter$27(ChatFooter paramChatFooter, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(153704);
    this.vXU.setAppPanelVisible(4);
    if (this.inP != null) {
      this.inP.run();
    }
    AppMethodBeat.o(153704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.27
 * JD-Core Version:    0.7.0.1
 */