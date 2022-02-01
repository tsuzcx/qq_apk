package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class ChatFooter$10
  implements View.OnClickListener
{
  ChatFooter$10(ChatFooter paramChatFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31503);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    ChatFooter.q(this.RmK);
    Log.i("MicroMsg.ChatFooter", "close ime guide");
    a.a(this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(31503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.10
 * JD-Core Version:    0.7.0.1
 */