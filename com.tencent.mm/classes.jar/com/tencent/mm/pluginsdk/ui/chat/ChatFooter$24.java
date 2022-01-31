package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatFooter$24
  implements View.OnClickListener
{
  ChatFooter$24(ChatFooter paramChatFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155434);
    if (ChatFooter.ao(this.vXU) != null) {
      ChatFooter.ao(this.vXU).pu(false);
    }
    AppMethodBeat.o(155434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.24
 * JD-Core Version:    0.7.0.1
 */