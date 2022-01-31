package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.h;
import com.tencent.mm.plugin.transvoice.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class ChatFooter$10
  implements a.a
{
  ChatFooter$10(ChatFooter paramChatFooter) {}
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(155417);
    ab.d("MicroMsg.ChatFooter", "onCutFinish.");
    ChatFooter.a(this.vXU, paramh);
    AppMethodBeat.o(155417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.10
 * JD-Core Version:    0.7.0.1
 */