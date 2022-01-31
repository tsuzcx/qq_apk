package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.widget.MMTextView;

final class am$e
  extends s.e
{
  public am$e(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33320);
    parama = (az)paramView.getTag();
    if (parambi.dxM())
    {
      if (this.zzP != null)
      {
        h.qsU.kvStat(10221, "1");
        paramView = new Intent();
        paramView.addFlags(67108864);
        d.b(this.zzP.zJz.getContext(), "shake", ".ui.ShakeReportUI", paramView);
      }
      AppMethodBeat.o(33320);
      return;
    }
    if ((parambi.isText()) && ((paramView instanceof MMTextView)))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.k.a.a.dLf();
      com.tencent.mm.ui.chatting.k.a.a.a(paramView.getText(), parama.cEE);
    }
    AppMethodBeat.o(33320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.e
 * JD-Core Version:    0.7.0.1
 */