package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ca;
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
  
  public final void a(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(36920);
    ((b)g.af(b.class)).akR(paramca.field_talker);
    paramView = (bq)paramView.getTag();
    bg.aVF();
    if (c.isSDCardAvailable())
    {
      parama = paramView.dTX;
      if (!ab.Eq(parama.field_talker)) {
        break label119;
      }
    }
    label119:
    for (paramView = this.PhN.getTalkerUserName();; paramView = null)
    {
      ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.PhN.Pwc.getContext(), parama, paramView);
      h.CyF.a(11592, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(36920);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.a
 * JD-Core Version:    0.7.0.1
 */