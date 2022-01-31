package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

final class ChatFooter$1
  implements m.a
{
  ChatFooter$1(ChatFooter paramChatFooter) {}
  
  public final void clear()
  {
    AppMethodBeat.i(27786);
    ChatFooter localChatFooter = this.vXU;
    if (localChatFooter.oxm != null)
    {
      localChatFooter.oxm.setText("");
      localChatFooter.dod();
    }
    AppMethodBeat.o(27786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.1
 * JD-Core Version:    0.7.0.1
 */