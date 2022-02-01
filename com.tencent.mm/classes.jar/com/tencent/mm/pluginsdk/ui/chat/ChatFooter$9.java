package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ChatFooter$9
  implements View.OnClickListener
{
  ChatFooter$9(ChatFooter paramChatFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31502);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ChatFooter.q(this.FcF);
    a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(31502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.9
 * JD-Core Version:    0.7.0.1
 */