package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.v.e;
import com.tencent.mm.ui.widget.MMTextView;

final class x$e
  extends v.e
{
  public x$e(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(36964);
    parama = (bz)paramView.getTag();
    if (paramcc.jbw())
    {
      if (this.aeiK != null)
      {
        paramView = new Intent();
        paramView.addFlags(67108864);
        paramView.putExtra("enter_from_scene", 3);
        c.b(this.aeiK.aezO.getContext(), "shake", ".ui.ShakeReportUI", paramView);
      }
      AppMethodBeat.o(36964);
      return;
    }
    if ((paramcc.iYl()) && ((paramView instanceof MMTextView)))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.j.a.a.jwS();
      com.tencent.mm.ui.chatting.j.a.a.a(paramView.getText(), parama.hTm);
    }
    AppMethodBeat.o(36964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.e
 * JD-Core Version:    0.7.0.1
 */