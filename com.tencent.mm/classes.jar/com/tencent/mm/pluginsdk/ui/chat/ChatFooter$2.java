package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class ChatFooter$2
  implements View.OnLongClickListener
{
  ChatFooter$2(ChatFooter paramChatFooter, Context paramContext) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(27787);
    paramView = com.tencent.mm.pluginsdk.f.a.dlQ();
    h.qsU.j(1014L, 0L, 1L);
    com.tencent.mm.plugin.c.a.asD();
    if (com.tencent.mm.plugin.c.a.v(paramView))
    {
      h.qsU.j(1014L, 1L, 1L);
      ab.i("MicroMsg.ChatFooter", "anti paste text %s", new Object[] { paramView });
      AppMethodBeat.o(27787);
      return true;
    }
    AppMethodBeat.o(27787);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.2
 * JD-Core Version:    0.7.0.1
 */