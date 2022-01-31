package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ny.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d;

final class a$3
  implements View.OnClickListener
{
  a$3(a parama, ny paramny, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153628);
    ab.i("MicroMsg.ImageViewWrapper", "request deal QBAR string");
    if (this.qag.mAF.isShowing()) {
      this.qag.mAF.cre();
    }
    if (this.mww == null)
    {
      AppMethodBeat.o(153628);
      return;
    }
    paramView = new cg();
    paramView.cpD.activity = ((Activity)this.val$context);
    paramView.cpD.cnR = this.mww.cEy.result;
    paramView.cpD.cpE = this.mww.cEy.cpE;
    paramView.cpD.cpF = this.mww.cEy.cpF;
    com.tencent.mm.sdk.b.a.ymk.l(paramView);
    AppMethodBeat.o(153628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a.3
 * JD-Core Version:    0.7.0.1
 */