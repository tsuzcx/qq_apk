package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class ChatFooter$55
  implements Runnable
{
  ChatFooter$55(ChatFooter paramChatFooter, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(185798);
    if (!this.Cfj) {
      h.c(this.Cff.getContext(), this.Cff.getContext().getString(2131761359), "", true);
    }
    this.Cff.eyS();
    AppMethodBeat.o(185798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.55
 * JD-Core Version:    0.7.0.1
 */