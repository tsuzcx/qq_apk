package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ChatFooter$26
  implements Runnable
{
  ChatFooter$26(ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(27808);
    AppMethodBeat.o(27808);
  }
  
  public final void run()
  {
    AppMethodBeat.i(153699);
    if (!this.vXU.doA())
    {
      ChatFooter.ap(this.vXU);
      AppMethodBeat.o(153699);
      return;
    }
    ab.i("changelcai", "isScrolling!! pass this event!");
    AppMethodBeat.o(153699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.26
 * JD-Core Version:    0.7.0.1
 */