package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.widget.MMTextView;

final class q$e
  extends s.e
{
  public q$e(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(36964);
    parama = (bj)paramView.getTag();
    if (parambo.fbw())
    {
      if (this.HNS != null)
      {
        paramView = new Intent();
        paramView.addFlags(67108864);
        d.b(this.HNS.HZF.getContext(), "shake", ".ui.ShakeReportUI", paramView);
      }
      AppMethodBeat.o(36964);
      return;
    }
    if ((parambo.isText()) && ((paramView instanceof MMTextView)))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.l.a.a.fqj();
      com.tencent.mm.ui.chatting.l.a.a.a(paramView.getText(), parama.dpq);
    }
    AppMethodBeat.o(36964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.e
 * JD-Core Version:    0.7.0.1
 */