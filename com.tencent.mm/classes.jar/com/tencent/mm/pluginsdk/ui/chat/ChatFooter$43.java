package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatFooter$43
  implements View.OnClickListener
{
  ChatFooter$43(ChatFooter paramChatFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(191302);
    if (ChatFooter.bh(this.Cff) != null) {
      ChatFooter.bh(this.Cff).us(false);
    }
    AppMethodBeat.o(191302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.43
 * JD-Core Version:    0.7.0.1
 */