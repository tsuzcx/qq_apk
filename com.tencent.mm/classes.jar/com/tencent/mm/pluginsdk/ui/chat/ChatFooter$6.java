package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;

final class ChatFooter$6
  implements View.OnClickListener
{
  ChatFooter$6(ChatFooter paramChatFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27790);
    this.vXU.dof();
    if ((r.ZU().booleanValue()) && (this.vXU.vWJ != null))
    {
      paramView = this.vXU.vWJ;
      Boolean localBoolean = Boolean.TRUE;
      paramView.a(localBoolean, localBoolean);
    }
    AppMethodBeat.o(27790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.6
 * JD-Core Version:    0.7.0.1
 */