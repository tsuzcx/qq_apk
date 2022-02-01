package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ChatFooter$14
  implements View.OnClickListener
{
  ChatFooter$14(ChatFooter paramChatFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(185761);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ChatFooter.w(this.FcF);
    a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(185761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.14
 * JD-Core Version:    0.7.0.1
 */