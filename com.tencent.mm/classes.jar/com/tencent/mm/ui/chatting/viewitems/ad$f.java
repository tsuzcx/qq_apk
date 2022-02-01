package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.e;
import com.tencent.mm.ui.widget.MMTextView;

final class ad$f
  extends t.e
{
  public ad$f(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37035);
    parama = (by)paramView.getTag();
    if (paramca.hzt())
    {
      if (this.WBq != null)
      {
        paramView = new Intent();
        paramView.addFlags(67108864);
        c.b(this.WBq.WQv.getContext(), "shake", ".ui.ShakeReportUI", paramView);
      }
      AppMethodBeat.o(37035);
      return;
    }
    if ((paramca.hwH()) && ((paramView instanceof MMTextView)))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.n.a.a.hTq();
      com.tencent.mm.ui.chatting.n.a.a.a(paramView.getText(), parama.fNz);
    }
    AppMethodBeat.o(37035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.f
 * JD-Core Version:    0.7.0.1
 */