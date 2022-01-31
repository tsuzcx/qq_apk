package com.tencent.mm.plugin.wallet_core.ui.cashier;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.ad;

final class WcPayCashierDialog$8
  implements a.a
{
  WcPayCashierDialog$8(WcPayCashierDialog paramWcPayCashierDialog, boolean paramBoolean) {}
  
  public final void cQU()
  {
    AppMethodBeat.i(142547);
    ab.i("MicroMsg.WcPayCashierDialog", "on click add new bankcard");
    WcPayCashierDialog.H(this.uvD).a(this.uvD);
    WcPayCashierDialog.I(this.uvD);
    if (WcPayCashierDialog.c(this.uvD) != null) {
      WcPayCashierDialog.c(this.uvD).cQU();
    }
    this.uvD.dismiss();
    AppMethodBeat.o(142547);
  }
  
  public final void i(Bankcard paramBankcard)
  {
    int i = 0;
    AppMethodBeat.i(142546);
    if (paramBankcard == null)
    {
      AppMethodBeat.o(142546);
      return;
    }
    ab.i("MicroMsg.WcPayCashierDialog", "on select bankcard: %s, %s", new Object[] { paramBankcard.field_bankName, paramBankcard.field_bindSerial });
    if ((this.uvD.uvr == null) || (!paramBankcard.field_bindSerial.equals(this.uvD.uvr.field_bindSerial)))
    {
      if (this.uvD.mPayInfo != null) {
        break label191;
      }
      if (this.uvD.mPayInfo != null) {
        break label205;
      }
    }
    label191:
    label205:
    for (String str = "";; str = this.uvD.mPayInfo.cnI)
    {
      ad.e(i, str, 13, paramBankcard.field_bindSerial);
      this.uvD.uvr = paramBankcard;
      WcPayCashierDialog.w(this.uvD);
      WcPayCashierDialog.r(this.uvD);
      WcPayCashierDialog.s(this.uvD);
      WcPayCashierDialog.x(this.uvD);
      WcPayCashierDialog.y(this.uvD);
      WcPayCashierDialog.G(this.uvD);
      WcPayCashierDialog.H(this.uvD).a(this.uvD);
      WcPayCashierDialog.I(this.uvD);
      this.uvD.show();
      AppMethodBeat.o(142546);
      return;
      i = this.uvD.mPayInfo.cCD;
      break;
    }
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(142548);
    ab.i("MicroMsg.WcPayCashierDialog", "on bankcard dialog cancel");
    WcPayCashierDialog.H(this.uvD).a(this.uvD);
    WcPayCashierDialog.I(this.uvD);
    if (this.uvI)
    {
      this.uvD.cancel();
      AppMethodBeat.o(142548);
      return;
    }
    this.uvD.show();
    AppMethodBeat.o(142548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.8
 * JD-Core Version:    0.7.0.1
 */