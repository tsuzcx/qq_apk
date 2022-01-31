package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class ChatFooter$7
  implements View.OnClickListener
{
  ChatFooter$7(ChatFooter paramChatFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27791);
    paramView = a.exi;
    a.OX();
    if (ChatFooter.i(this.vXU) != null) {
      ChatFooter.i(this.vXU).bPj();
    }
    if (ChatFooter.m(this.vXU) == 2)
    {
      this.vXU.showVKB();
      AppMethodBeat.o(27791);
      return;
    }
    if (ChatFooter.n(this.vXU)) {
      this.vXU.Az();
    }
    this.vXU.doj();
    if (!g.RL().Ru().getBoolean(ac.a.yKq, false))
    {
      g.RL().Ru().set(ac.a.yKq, Boolean.TRUE);
      ChatFooter.o(this.vXU).findViewById(2131822481).setVisibility(8);
    }
    AppMethodBeat.o(27791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.7
 * JD-Core Version:    0.7.0.1
 */