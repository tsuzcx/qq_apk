package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;

final class RemittanceBusiUI$31
  implements View.OnClickListener
{
  RemittanceBusiUI$31(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142203);
    h.qsU.e(15235, new Object[] { Integer.valueOf(5) });
    if (!RemittanceBusiUI.k(this.qoF)) {
      RemittanceBusiUI.a(this.qoF, RemittanceBusiUI.n(this.qoF));
    }
    if (RemittanceBusiUI.o(this.qoF) <= 0.0D)
    {
      t.makeText(this.qoF.getContext(), 2131304847, 0).show();
      AppMethodBeat.o(142203);
      return;
    }
    g localg = this.qoF.qop;
    if (this.qoF.qop == null) {}
    for (paramView = "";; paramView = this.qoF.qop.qjd)
    {
      ab.i("MicroMsg.RemittanceBusiUI", "mPayBtn onClick %s  isFinish:%s getFavorFlag: %s", new Object[] { localg, paramView, Boolean.valueOf(this.qoF.qon) });
      if (RemittanceBusiUI.h(this.qoF) != 32) {
        break label313;
      }
      if (!this.qoF.qon) {
        break label300;
      }
      if ((this.qoF.qop == null) || (this.qoF.qop.qjg != (int)(RemittanceBusiUI.o(this.qoF) * 100.0D))) {
        break;
      }
      if ((this.qoF.qop != null) && (this.qoF.qop.qjd)) {
        break label313;
      }
      if (this.qoF.qop == null) {
        break label320;
      }
      this.qoF.qop.qjb = new RemittanceBusiUI.31.1(this);
      AppMethodBeat.o(142203);
      return;
    }
    RemittanceBusiUI.a(this.qoF, new RemittanceBusiUI.31.2(this), 0);
    AppMethodBeat.o(142203);
    return;
    label300:
    RemittanceBusiUI.p(this.qoF);
    AppMethodBeat.o(142203);
    return;
    label313:
    RemittanceBusiUI.p(this.qoF);
    label320:
    AppMethodBeat.o(142203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.31
 * JD-Core Version:    0.7.0.1
 */