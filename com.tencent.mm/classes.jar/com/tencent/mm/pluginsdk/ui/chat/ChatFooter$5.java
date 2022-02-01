package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;

final class ChatFooter$5
  implements View.OnLongClickListener
{
  ChatFooter$5(ChatFooter paramChatFooter, Context paramContext) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(185755);
    paramView = com.tencent.mm.pluginsdk.g.a.ewb();
    h.vKh.m(1014L, 0L, 1L);
    com.tencent.mm.plugin.c.a.aLf();
    if (com.tencent.mm.plugin.c.a.z(paramView))
    {
      h.vKh.m(1014L, 1L, 1L);
      ad.i("MicroMsg.ChatFooter", "anti paste text %s", new Object[] { paramView });
      AppMethodBeat.o(185755);
      return true;
    }
    AppMethodBeat.o(185755);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.5
 * JD-Core Version:    0.7.0.1
 */