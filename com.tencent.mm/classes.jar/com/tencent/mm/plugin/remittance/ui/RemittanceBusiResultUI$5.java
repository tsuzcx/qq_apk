package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.protocal.protobuf.pr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceBusiResultUI$5
  implements View.OnClickListener
{
  RemittanceBusiResultUI$5(RemittanceBusiResultUI paramRemittanceBusiResultUI, pr parampr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67994);
    ad.i("MicroMsg.RemittanceBusiResultUI", "app type: %s", new Object[] { Integer.valueOf(this.vEx.type) });
    if (this.vEx.type == 1)
    {
      RemittanceBusiResultUI.h(this.vEu);
      paramView = new uj();
      paramView.dzH.userName = this.vEx.COa;
      paramView.dzH.dzJ = bt.by(this.vEx.COb, "");
      paramView.dzH.scene = 1034;
      paramView.dzH.dzK = 0;
      a.ESL.l(paramView);
      AppMethodBeat.o(67994);
      return;
    }
    if (this.vEx.type == 2)
    {
      RemittanceBusiResultUI.h(this.vEu);
      e.p(this.vEu.getContext(), this.vEx.url, true);
    }
    AppMethodBeat.o(67994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.5
 * JD-Core Version:    0.7.0.1
 */