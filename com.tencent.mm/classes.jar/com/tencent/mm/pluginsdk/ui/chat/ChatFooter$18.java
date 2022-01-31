package com.tencent.mm.pluginsdk.ui.chat;

import android.os.Message;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.o;

final class ChatFooter$18
  extends ak
{
  ChatFooter$18(ChatFooter paramChatFooter) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(155429);
    super.handleMessage(paramMessage);
    if (ChatFooter.x(this.vXU) != null)
    {
      ChatFooter.x(this.vXU).dismiss();
      ChatFooter.u(this.vXU).setBackgroundDrawable(a.k(this.vXU.getContext(), 2130840961));
      ChatFooter.u(this.vXU).setEnabled(true);
    }
    AppMethodBeat.o(155429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.18
 * JD-Core Version:    0.7.0.1
 */