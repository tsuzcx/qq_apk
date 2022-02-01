package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ChatFooter$26
  implements View.OnClickListener
{
  ChatFooter$26(ChatFooter paramChatFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(245382);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    ChatFooter.I(this.YiY);
    a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(245382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.26
 * JD-Core Version:    0.7.0.1
 */