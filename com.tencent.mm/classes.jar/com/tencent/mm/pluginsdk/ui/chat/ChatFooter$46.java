package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class ChatFooter$46
  implements Runnable
{
  ChatFooter$46(ChatFooter paramChatFooter) {}
  
  public final void run()
  {
    AppMethodBeat.i(31552);
    ad.i("MicroMsg.ChatFooter", "withLastText: ");
    this.Cff.showVKB();
    ChatFooter.a(this.Cff, true);
    AppMethodBeat.o(31552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.46
 * JD-Core Version:    0.7.0.1
 */