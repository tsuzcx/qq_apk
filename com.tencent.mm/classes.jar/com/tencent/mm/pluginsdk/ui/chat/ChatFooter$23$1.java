package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ChatFooter$23$1
  implements Runnable
{
  ChatFooter$23$1(ChatFooter.23 param23) {}
  
  public final void run()
  {
    AppMethodBeat.i(155431);
    ab.i("MicroMsg.ChatFooter", "reflesh smiley panel.");
    this.vXW.vXU.doz();
    AppMethodBeat.o(155431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.23.1
 * JD-Core Version:    0.7.0.1
 */