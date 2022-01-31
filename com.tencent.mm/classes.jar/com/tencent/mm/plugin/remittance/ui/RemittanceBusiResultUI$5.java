package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceBusiResultUI$5
  implements View.OnClickListener
{
  RemittanceBusiResultUI$5(RemittanceBusiResultUI paramRemittanceBusiResultUI, nm paramnm) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44873);
    ab.i("MicroMsg.RemittanceBusiResultUI", "app type: %s", new Object[] { Integer.valueOf(this.qno.type) });
    if (this.qno.type == 1)
    {
      RemittanceBusiResultUI.g(this.qnm);
      paramView = new so();
      paramView.cIQ.userName = this.qno.wCy;
      paramView.cIQ.cIS = bo.bf(this.qno.wCz, "");
      paramView.cIQ.scene = 1034;
      paramView.cIQ.cIT = 0;
      a.ymk.l(paramView);
      AppMethodBeat.o(44873);
      return;
    }
    if (this.qno.type == 2)
    {
      RemittanceBusiResultUI.g(this.qnm);
      e.m(this.qnm.getContext(), this.qno.url, true);
    }
    AppMethodBeat.o(44873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.5
 * JD-Core Version:    0.7.0.1
 */