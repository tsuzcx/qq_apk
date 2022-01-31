package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.s.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletBindCardResultUI$5
  implements View.OnClickListener
{
  WalletBindCardResultUI$5(WalletBindCardResultUI paramWalletBindCardResultUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47190);
    ab.i("MicroMsg.WalletBindCardResultUI", "click tiny app, userName: %s, path: %s, version: %s", new Object[] { WalletBindCardResultUI.c(this.unQ), WalletBindCardResultUI.d(this.unQ), Integer.valueOf(WalletBindCardResultUI.e(this.unQ)) });
    this.unQ.jU(2);
    paramView = new so();
    paramView.cIQ.userName = WalletBindCardResultUI.c(this.unQ);
    paramView.cIQ.cIS = bo.bf(WalletBindCardResultUI.d(this.unQ), "");
    paramView.cIQ.scene = 1034;
    paramView.cIQ.cIT = 0;
    if (WalletBindCardResultUI.e(this.unQ) > 0) {
      paramView.cIQ.bDc = WalletBindCardResultUI.e(this.unQ);
    }
    a.ymk.l(paramView);
    if ((!bo.isNullOrNil(WalletBindCardResultUI.f(this.unQ).ugN.uiS)) && (WalletBindCardResultUI.f(this.unQ).ugL.ubC > 0L))
    {
      WalletBindCardResultUI.a(this.unQ, true);
      AppMethodBeat.o(47190);
      return;
    }
    WalletBindCardResultUI.a(this.unQ, false);
    AppMethodBeat.o(47190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.5
 * JD-Core Version:    0.7.0.1
 */