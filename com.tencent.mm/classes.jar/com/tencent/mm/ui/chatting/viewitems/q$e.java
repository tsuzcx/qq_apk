package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.storage.bl;
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
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(36964);
    parama = (bi)paramView.getTag();
    if (parambl.eLS())
    {
      if (this.Gob != null)
      {
        paramView = new Intent();
        paramView.addFlags(67108864);
        d.b(this.Gob.GzJ.getContext(), "shake", ".ui.ShakeReportUI", paramView);
      }
      AppMethodBeat.o(36964);
      return;
    }
    if ((parambl.isText()) && ((paramView instanceof MMTextView)))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.l.a.a.fat();
      com.tencent.mm.ui.chatting.l.a.a.a(paramView.getText(), parama.drF);
    }
    AppMethodBeat.o(36964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.e
 * JD-Core Version:    0.7.0.1
 */