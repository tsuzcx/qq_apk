package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.widget.MMTextView;

final class aw$e
  extends s.e
{
  public aw$e(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37419);
    parama = (bj)paramView.getTag();
    if (parambo.fbw())
    {
      if (this.HNS != null)
      {
        h.wUl.kvStat(10221, "1");
        paramView = new Intent();
        paramView.addFlags(67108864);
        d.b(this.HNS.HZF.getContext(), "shake", ".ui.ShakeReportUI", paramView);
      }
      AppMethodBeat.o(37419);
      return;
    }
    if ((parambo.isText()) && ((paramView instanceof MMTextView)))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.l.a.a.fqj();
      com.tencent.mm.ui.chatting.l.a.a.a(paramView.getText(), parama.dpq);
    }
    AppMethodBeat.o(37419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw.e
 * JD-Core Version:    0.7.0.1
 */