package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.t.d;

public final class k$a
  extends t.d
{
  k$a(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bi parambi)
  {
    paramView = (aw)paramView.getTag();
    au.Hx();
    if (c.isSDCardAvailable())
    {
      parama = paramView.bWO;
      if (!s.fn(parama.field_talker)) {
        break label92;
      }
    }
    label92:
    for (paramView = this.vko.getTalkerUserName();; paramView = null)
    {
      ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.vko.vtz.getContext(), parama, paramView);
      h.nFQ.f(11592, new Object[] { Integer.valueOf(0) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.a
 * JD-Core Version:    0.7.0.1
 */