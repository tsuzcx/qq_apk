package com.tencent.mm.plugin.wallet.pay.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.i;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.c;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletChangeBankcardUI$5
  implements q.c
{
  WalletChangeBankcardUI$5(WalletChangeBankcardUI paramWalletChangeBankcardUI) {}
  
  public final void a(String paramString, FavorPayInfo paramFavorPayInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(45962);
    if (WalletChangeBankcardUI.b(this.tVU))
    {
      ab.w("MicroMsg.WalletChangeBankcardUI", "has receive cancel");
      h.qsU.j(965L, 3L, 1L);
      AppMethodBeat.o(45962);
      return;
    }
    this.tVU.tVQ = paramFavorPayInfo;
    this.tVU.getInput().putParcelable("key_favor_pay_info", this.tVU.tVQ);
    if ((this.tVU.tVQ != null) && (paramBoolean))
    {
      if (this.tVU.tVQ != null)
      {
        this.tVU.nx(true);
        this.tVU.tVO.g(this.tVU.tNG, false);
      }
      if (this.tVU.tVM != null) {
        this.tVU.tVM.dismiss();
      }
      this.tVU.bJ();
      this.tVU.setContentViewVisibility(0);
      AppMethodBeat.o(45962);
      return;
    }
    this.tVU.gJv = paramString;
    this.tVU.hideVKB();
    this.tVU.afb(paramString);
    this.tVU.tVS = null;
    AppMethodBeat.o(45962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.5
 * JD-Core Version:    0.7.0.1
 */