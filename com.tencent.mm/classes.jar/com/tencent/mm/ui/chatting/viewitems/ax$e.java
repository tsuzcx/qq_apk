package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.e;
import com.tencent.mm.ui.widget.MMTextView;

final class ax$e
  extends t.e
{
  public ax$e(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37419);
    parama = (bk)paramView.getTag();
    if (parambv.fvz())
    {
      if (this.JWz != null)
      {
        g.yxI.kvStat(10221, "1");
        paramView = new Intent();
        paramView.addFlags(67108864);
        d.b(this.JWz.Kkd.getContext(), "shake", ".ui.ShakeReportUI", paramView);
      }
      AppMethodBeat.o(37419);
      return;
    }
    if ((parambv.isText()) && ((paramView instanceof MMTextView)))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.m.a.a.fLp();
      com.tencent.mm.ui.chatting.m.a.a.a(paramView.getText(), parama.dCi);
    }
    AppMethodBeat.o(37419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax.e
 * JD-Core Version:    0.7.0.1
 */