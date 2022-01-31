package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.t.d;
import com.tencent.mm.ui.widget.MMTextView;

final class aj$d
  extends t.d
{
  public aj$d(com.tencent.mm.ui.chatting.c.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    parama = (aw)paramView.getTag();
    if (parambi.cvi()) {
      if (this.vko != null)
      {
        h.nFQ.aC(10221, "1");
        paramView = new Intent();
        paramView.addFlags(67108864);
        d.b(this.vko.vtz.getContext(), "shake", ".ui.ShakeReportUI", paramView);
      }
    }
    while ((!parambi.isText()) || (!(paramView instanceof MMTextView))) {
      return;
    }
    paramView = (MMTextView)paramView;
    com.tencent.mm.ui.chatting.j.a.a.cGT();
    com.tencent.mm.ui.chatting.j.a.a.a(paramView.getText(), parama.bWO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.d
 * JD-Core Version:    0.7.0.1
 */