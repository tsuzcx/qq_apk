package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;

final class ChatFooter$5
  implements View.OnLongClickListener
{
  ChatFooter$5(ChatFooter paramChatFooter, Context paramContext) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(185755);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/ChatFooter$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
    paramView = com.tencent.mm.pluginsdk.i.a.fee();
    g.yxI.n(1014L, 0L, 1L);
    com.tencent.mm.plugin.c.a.aVH();
    if (com.tencent.mm.plugin.c.a.z(paramView))
    {
      g.yxI.n(1014L, 1L, 1L);
      ae.i("MicroMsg.ChatFooter", "anti paste text %s", new Object[] { paramView });
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(185755);
      return true;
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/pluginsdk/ui/chat/ChatFooter$13", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(185755);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.5
 * JD-Core Version:    0.7.0.1
 */