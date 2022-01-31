package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletOrderInfoNewUI$7
  implements View.OnClickListener
{
  WalletOrderInfoNewUI$7(WalletOrderInfoNewUI paramWalletOrderInfoNewUI, Orders.Commodity paramCommodity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142510);
    ab.i("MicroMsg.WalletOrderInfoNewUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletOrderInfoNewUI.q(this.ury), WalletOrderInfoNewUI.r(this.ury), Integer.valueOf(WalletOrderInfoNewUI.u(this.ury)) });
    paramView = new so();
    paramView.cIQ.userName = WalletOrderInfoNewUI.q(this.ury);
    paramView.cIQ.cIS = bo.bf(WalletOrderInfoNewUI.r(this.ury), "");
    paramView.cIQ.scene = 1034;
    paramView.cIQ.cIT = 0;
    if (WalletOrderInfoNewUI.u(this.ury) > 0) {
      paramView.cIQ.bDc = WalletOrderInfoNewUI.u(this.ury);
    }
    paramView.cIQ.context = this.ury;
    a.ymk.l(paramView);
    paramView = this.ury;
    if ((!bo.isNullOrNil(this.urA.ujT.uiS)) && (this.urA.ujT.uks > 0L)) {}
    for (boolean bool = true;; bool = false)
    {
      WalletOrderInfoNewUI.a(paramView, bool);
      if (!WalletOrderInfoNewUI.s(this.ury)) {
        break;
      }
      h.qsU.e(14118, new Object[] { WalletOrderInfoNewUI.p(this.ury), this.ury.getPayReqKey(), Integer.valueOf(3) });
      AppMethodBeat.o(142510);
      return;
    }
    h.qsU.e(14118, new Object[] { WalletOrderInfoNewUI.p(this.ury), this.ury.getPayReqKey(), Integer.valueOf(1) });
    AppMethodBeat.o(142510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.7
 * JD-Core Version:    0.7.0.1
 */