package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatFooter$20
  implements Runnable
{
  ChatFooter$20(ChatFooter paramChatFooter) {}
  
  public final void run()
  {
    AppMethodBeat.i(27811);
    if (ChatFooter.B(this.vXU))
    {
      ChatFooter.aa(this.vXU).setVisibility(8);
      ChatFooter.G(this.vXU).setVisibility(0);
      AppMethodBeat.o(27811);
      return;
    }
    ChatFooter.aa(this.vXU).setVisibility(0);
    ChatFooter.G(this.vXU).setVisibility(8);
    AppMethodBeat.o(27811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.20
 * JD-Core Version:    0.7.0.1
 */