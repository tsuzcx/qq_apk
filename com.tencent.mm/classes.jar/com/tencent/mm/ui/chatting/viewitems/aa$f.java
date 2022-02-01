package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.e;
import com.tencent.mm.ui.widget.MMTextView;

final class aa$f
  extends t.e
{
  public aa$f(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37035);
    parama = (bq)paramView.getTag();
    if (paramca.gDg())
    {
      if (this.PhN != null)
      {
        paramView = new Intent();
        paramView.addFlags(67108864);
        c.b(this.PhN.Pwc.getContext(), "shake", ".ui.ShakeReportUI", paramView);
      }
      AppMethodBeat.o(37035);
      return;
    }
    if ((paramca.isText()) && ((paramView instanceof MMTextView)))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.m.a.a.gTK();
      com.tencent.mm.ui.chatting.m.a.a.a(paramView.getText(), parama.dTX);
    }
    AppMethodBeat.o(37035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.f
 * JD-Core Version:    0.7.0.1
 */