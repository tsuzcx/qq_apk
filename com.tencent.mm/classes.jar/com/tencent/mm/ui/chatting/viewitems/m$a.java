package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.v.e;

public final class m$a
  extends v.e
{
  m$a(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, cc paramcc)
  {
    AppMethodBeat.i(36920);
    ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
    paramView = (bz)paramView.getTag();
    bh.bCz();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
      {
        Log.i("MicroMsg.AppEmojClickListener", "exit in teen mode");
        ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(this.aeiK.aezO.getContext());
        AppMethodBeat.o(36920);
        return;
      }
      parama = paramView.hTm;
      if (!au.bwE(parama.field_talker)) {
        break label171;
      }
    }
    label171:
    for (paramView = this.aeiK.getTalkerUserName();; paramView = null)
    {
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a(this.aeiK.aezO.getContext(), parama, paramView);
      com.tencent.mm.plugin.report.service.h.OAn.b(11592, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(36920);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.a
 * JD-Core Version:    0.7.0.1
 */