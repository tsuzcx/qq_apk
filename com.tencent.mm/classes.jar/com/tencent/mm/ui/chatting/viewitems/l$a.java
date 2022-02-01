package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.s.e;

public final class l$a
  extends s.e
{
  l$a(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bu parambu)
  {
    AppMethodBeat.i(36920);
    ((b)com.tencent.mm.kernel.g.ab(b.class)).ZT(parambu.field_talker);
    paramView = (bk)paramView.getTag();
    ba.aBQ();
    if (c.isSDCardAvailable())
    {
      parama = paramView.dBd;
      if (!w.vF(parama.field_talker)) {
        break label119;
      }
    }
    label119:
    for (paramView = this.JBI.getTalkerUserName();; paramView = null)
    {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.JBI.JOR.getContext(), parama, paramView);
      com.tencent.mm.plugin.report.service.g.yhR.f(11592, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(36920);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.a
 * JD-Core Version:    0.7.0.1
 */