package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;

final class ChatFooter$19
  implements PopupWindow.OnDismissListener
{
  ChatFooter$19(ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(153701);
    AppMethodBeat.o(153701);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(155430);
    ChatFooter.s(this.vXU).getContentView().setAlpha(0.0F);
    AppMethodBeat.o(155430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.19
 * JD-Core Version:    0.7.0.1
 */