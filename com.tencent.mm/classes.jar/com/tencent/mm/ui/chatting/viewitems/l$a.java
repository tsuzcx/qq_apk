package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.e;

public final class l$a
  extends t.e
{
  l$a(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bv parambv)
  {
    AppMethodBeat.i(36920);
    ((b)com.tencent.mm.kernel.g.ab(b.class)).aaK(parambv.field_talker);
    paramView = (bk)paramView.getTag();
    bc.aCg();
    if (c.isSDCardAvailable())
    {
      parama = paramView.dCi;
      if (!x.wb(parama.field_talker)) {
        break label119;
      }
    }
    label119:
    for (paramView = this.JWz.getTalkerUserName();; paramView = null)
    {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.JWz.Kkd.getContext(), parama, paramView);
      com.tencent.mm.plugin.report.service.g.yxI.f(11592, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(36920);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.a
 * JD-Core Version:    0.7.0.1
 */