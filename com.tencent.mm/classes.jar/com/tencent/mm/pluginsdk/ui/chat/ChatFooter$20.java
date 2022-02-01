package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ChatFooter$20
  implements View.OnClickListener
{
  ChatFooter$20(ChatFooter paramChatFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(196486);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    ChatFooter.A(this.RmK);
    a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(196486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.20
 * JD-Core Version:    0.7.0.1
 */