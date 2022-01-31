package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletOrderInfoOldUI$a$2
  implements View.OnClickListener
{
  WalletOrderInfoOldUI$a$2(WalletOrderInfoOldUI.a parama, Orders.Commodity paramCommodity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47486);
    paramView = new so();
    paramView.cIQ.userName = this.urX.ujT.ugl;
    paramView.cIQ.cIS = bo.bf(this.urX.ujT.uaL, "");
    paramView.cIQ.scene = 1034;
    paramView.cIQ.cIT = 0;
    a.ymk.l(paramView);
    h.qsU.e(14118, new Object[] { this.urW.urV.plc, this.urW.urV.getPayReqKey(), Integer.valueOf(1) });
    AppMethodBeat.o(47486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.a.2
 * JD-Core Version:    0.7.0.1
 */