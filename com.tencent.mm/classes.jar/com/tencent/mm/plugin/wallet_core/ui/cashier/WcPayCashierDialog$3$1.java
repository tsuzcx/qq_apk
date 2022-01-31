package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.b;
import com.tencent.mm.plugin.wallet_core.ui.l.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.ad;
import java.util.List;

final class WcPayCashierDialog$3$1
  implements l.b
{
  WcPayCashierDialog$3$1(WcPayCashierDialog.3 param3) {}
  
  public final void a(FavorPayInfo paramFavorPayInfo)
  {
    int i = 0;
    AppMethodBeat.i(142535);
    ab.i("MicroMsg.WcPayCashierDialog", "on select favor: %s", new Object[] { paramFavorPayInfo.uhU });
    WcPayCashierDialog.a(this.uvG.uvD, null);
    this.uvG.uvD.tVQ = paramFavorPayInfo;
    if (this.uvG.uvD.mPayInfo == null)
    {
      if (this.uvG.uvD.mPayInfo != null) {
        break label281;
      }
      paramFavorPayInfo = "";
      label77:
      ad.e(i, paramFavorPayInfo, 15, this.uvG.uvD.tVQ.uhU);
      paramFavorPayInfo = b.bt(this.uvG.uvD.tVQ.uhV, this.uvG.uvD.tVQ.uhW);
      this.uvG.uvD.tVQ.uhY = "";
      if (!b.a(this.uvG.uvD.tVQ, this.uvG.uvD.uvr)) {
        break label329;
      }
      if (paramFavorPayInfo.size() != 0) {
        break label298;
      }
      this.uvG.uvD.tVQ.uhY = this.uvG.uvD.getContext().getString(2131305066);
      label205:
      WcPayCashierDialog.q(this.uvG.uvD);
    }
    for (;;)
    {
      WcPayCashierDialog.r(this.uvG.uvD);
      WcPayCashierDialog.s(this.uvG.uvD);
      WcPayCashierDialog.a(this.uvG.uvD, WcPayCashierDialog.t(this.uvG.uvD).ldI);
      AppMethodBeat.o(142535);
      return;
      i = this.uvG.uvD.mPayInfo.cCD;
      break;
      label281:
      paramFavorPayInfo = this.uvG.uvD.mPayInfo.cnI;
      break label77;
      label298:
      this.uvG.uvD.tVQ.uhY = this.uvG.uvD.getContext().getString(2131305067);
      break label205;
      label329:
      this.uvG.uvD.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.3.1
 * JD-Core Version:    0.7.0.1
 */