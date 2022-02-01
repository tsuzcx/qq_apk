package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.s.e;

public final class l$a
  extends s.e
{
  l$a(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bo parambo)
  {
    AppMethodBeat.i(36920);
    ((b)g.ab(b.class)).Wm(parambo.field_talker);
    paramView = (bj)paramView.getTag();
    az.ayM();
    if (c.isSDCardAvailable())
    {
      parama = paramView.dpq;
      if (!w.sQ(parama.field_talker)) {
        break label119;
      }
    }
    label119:
    for (paramView = this.HNS.getTalkerUserName();; paramView = null)
    {
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.HNS.HZF.getContext(), parama, paramView);
      h.wUl.f(11592, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(36920);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.a
 * JD-Core Version:    0.7.0.1
 */