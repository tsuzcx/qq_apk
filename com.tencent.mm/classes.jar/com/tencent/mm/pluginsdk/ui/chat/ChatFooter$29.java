package com.tencent.mm.pluginsdk.ui.chat;

import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatFooter$29
  implements Runnable
{
  ChatFooter$29(ChatFooter paramChatFooter) {}
  
  public final void run()
  {
    AppMethodBeat.i(155435);
    ChatFooter.a(this.vXU, true);
    this.vXU.setToSendTextColor(true);
    ChatFooter.aq(this.vXU).showSoftInput(ChatFooter.a(this.vXU), 0);
    AppMethodBeat.o(155435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.29
 * JD-Core Version:    0.7.0.1
 */