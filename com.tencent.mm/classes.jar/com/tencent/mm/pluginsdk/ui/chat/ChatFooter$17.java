package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatFooter$17
  implements Runnable
{
  ChatFooter$17(ChatFooter paramChatFooter) {}
  
  public final void run()
  {
    AppMethodBeat.i(155428);
    ChatFooter.ai(this.vXU).destroy();
    ChatFooter.ai(this.vXU).setVisibility(8);
    AppMethodBeat.o(155428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.17
 * JD-Core Version:    0.7.0.1
 */