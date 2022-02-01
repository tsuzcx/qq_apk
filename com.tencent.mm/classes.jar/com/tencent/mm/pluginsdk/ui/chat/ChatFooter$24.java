package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatFooter$24
  implements Runnable
{
  ChatFooter$24(ChatFooter paramChatFooter) {}
  
  public final void run()
  {
    AppMethodBeat.i(191290);
    if (ChatFooter.ax(this.Cff) != null)
    {
      ChatFooter.ax(this.Cff).destroy();
      ChatFooter.ax(this.Cff).setVisibility(8);
    }
    AppMethodBeat.o(191290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.24
 * JD-Core Version:    0.7.0.1
 */