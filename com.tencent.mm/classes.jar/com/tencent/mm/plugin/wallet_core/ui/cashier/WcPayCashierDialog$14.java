package com.tencent.mm.plugin.wallet_core.ui.cashier;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.t;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.ui.e;

final class WcPayCashierDialog$14
  extends t
{
  WcPayCashierDialog$14(WcPayCashierDialog paramWcPayCashierDialog) {}
  
  public final void bhX()
  {
    int i = 0;
    AppMethodBeat.i(47778);
    ab.i("MicroMsg.WcPayCashierDialog", "click pay btn: %s", new Object[] { Integer.valueOf(WcPayCashierDialog.h(this.uvD)) });
    if (this.uvD.mPayInfo == null) {
      if (this.uvD.mPayInfo != null) {
        break label113;
      }
    }
    label113:
    for (String str = "";; str = this.uvD.mPayInfo.cnI)
    {
      ad.e(i, str, 20, "");
      WcPayCashierDialog.i(this.uvD);
      if (WcPayCashierDialog.h(this.uvD) != 1) {
        break label127;
      }
      WcPayCashierDialog.j(this.uvD);
      e.RX(9);
      AppMethodBeat.o(47778);
      return;
      i = this.uvD.mPayInfo.cCD;
      break;
    }
    label127:
    if (WcPayCashierDialog.h(this.uvD) == 2)
    {
      WcPayCashierDialog.k(this.uvD);
      AppMethodBeat.o(47778);
      return;
    }
    ab.i("MicroMsg.WcPayCashierDialog", "wrong mode, switch pwd");
    WcPayCashierDialog.l(this.uvD);
    AppMethodBeat.o(47778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.14
 * JD-Core Version:    0.7.0.1
 */