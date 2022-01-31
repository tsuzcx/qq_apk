package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

final class ChatFooter$13
  implements View.OnKeyListener
{
  ChatFooter$13(ChatFooter paramChatFooter) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(155419);
    switch (paramKeyEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(155419);
      return false;
      if (((paramInt == 23) || (paramInt == 66)) && (!ChatFooter.F(this.vXU)) && (!ChatFooter.E(this.vXU)))
      {
        ChatFooter.d(this.vXU, true);
        ChatFooter.u(this.vXU).setBackgroundDrawable(a.k(this.vXU.getContext(), 2130840130));
        ChatFooter.u(this.vXU).setText(2131298128);
        if (ChatFooter.i(this.vXU) != null) {
          ChatFooter.i(this.vXU).bPi();
        }
        ChatFooter.u(this.vXU).setContentDescription(this.vXU.getContext().getString(2131298103));
        continue;
        if ((paramInt == 23) || (paramInt == 66))
        {
          ChatFooter.u(this.vXU).setBackgroundDrawable(a.k(this.vXU.getContext(), 2130840961));
          ChatFooter.u(this.vXU).setText(2131298127);
          if (ChatFooter.i(this.vXU) != null) {
            ChatFooter.i(this.vXU).bPe();
          }
          ChatFooter.d(this.vXU, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.13
 * JD-Core Version:    0.7.0.1
 */