package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.o;

final class ChatFooter$21
  implements Runnable
{
  ChatFooter$21(ChatFooter paramChatFooter) {}
  
  public final void run()
  {
    AppMethodBeat.i(27812);
    if (ChatFooter.x(this.vXU) != null)
    {
      ChatFooter.x(this.vXU).dismiss();
      ChatFooter.s(this.vXU).getContentView().animate().alpha(0.0F).setDuration(300L).withEndAction(ChatFooter.aj(this.vXU)).start();
      ChatFooter.ak(this.vXU).setVisibility(0);
      ChatFooter.al(this.vXU).setVisibility(8);
      ChatFooter.am(this.vXU).setVisibility(8);
      ChatFooter.ab(this.vXU).setVisibility(8);
      ChatFooter.H(this.vXU).setVisibility(8);
      ChatFooter.aa(this.vXU).setVisibility(0);
    }
    ChatFooter.u(this.vXU).setBackgroundDrawable(a.k(this.vXU.getContext(), 2130840961));
    ChatFooter.u(this.vXU).setText(2131298127);
    ChatFooter.d(this.vXU, false);
    ChatFooter.c(this.vXU, false);
    AppMethodBeat.o(27812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.21
 * JD-Core Version:    0.7.0.1
 */