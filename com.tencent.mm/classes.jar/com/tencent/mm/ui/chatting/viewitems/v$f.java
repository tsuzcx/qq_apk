package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.widget.MMTextView;

final class v$f
  extends s.e
{
  public v$f(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37035);
    parama = (bk)paramView.getTag();
    if (parambu.frz())
    {
      if (this.JBI != null)
      {
        paramView = new Intent();
        paramView.addFlags(67108864);
        d.b(this.JBI.JOR.getContext(), "shake", ".ui.ShakeReportUI", paramView);
      }
      AppMethodBeat.o(37035);
      return;
    }
    if ((parambu.isText()) && ((paramView instanceof MMTextView)))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.m.a.a.fGX();
      com.tencent.mm.ui.chatting.m.a.a.a(paramView.getText(), parama.dBd);
    }
    AppMethodBeat.o(37035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.f
 * JD-Core Version:    0.7.0.1
 */