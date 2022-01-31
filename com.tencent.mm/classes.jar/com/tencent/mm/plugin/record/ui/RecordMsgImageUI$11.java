package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ny.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d;

final class RecordMsgImageUI$11
  implements View.OnClickListener
{
  RecordMsgImageUI$11(RecordMsgImageUI paramRecordMsgImageUI, ny paramny) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153615);
    ab.i("MicroMsg.ShowImageUI", "request deal QBAR string");
    if (RecordMsgImageUI.f(this.pZV).isShowing()) {
      RecordMsgImageUI.f(this.pZV).cre();
    }
    if (this.mww == null)
    {
      AppMethodBeat.o(153615);
      return;
    }
    paramView = new cg();
    paramView.cpD.activity = this.pZV;
    paramView.cpD.cnR = this.mww.cEy.result;
    paramView.cpD.cpE = this.mww.cEy.cpE;
    paramView.cpD.cpG = 8;
    RecordMsgImageUI.a(this.pZV, paramView);
    paramView.cpD.cpF = this.mww.cEy.cpF;
    if (this.pZV.getIntent() != null) {
      paramView.cpD.cpJ = this.pZV.getIntent().getBundleExtra("_stat_obj");
    }
    a.ymk.l(paramView);
    AppMethodBeat.o(153615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI.11
 * JD-Core Version:    0.7.0.1
 */