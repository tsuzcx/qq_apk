package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ChatFooter$5
  implements View.OnLongClickListener
{
  ChatFooter$5(ChatFooter paramChatFooter) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(185755);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    ChatFooter.m(this.YiY);
    a.a(false, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(185755);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.5
 * JD-Core Version:    0.7.0.1
 */