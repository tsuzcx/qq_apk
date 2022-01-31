package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.q.c;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ad;

final class WalletPayUI$8
  implements q.c
{
  WalletPayUI$8(WalletPayUI paramWalletPayUI) {}
  
  public final void a(String paramString, FavorPayInfo paramFavorPayInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(46043);
    if (WalletPayUI.h(this.tXq))
    {
      ab.w(this.tXq.TAG, "has received canceled");
      h.qsU.j(965L, 3L, 1L);
      AppMethodBeat.o(46043);
      return;
    }
    WalletPayUI.k(this.tXq);
    this.tXq.hideVKB();
    this.tXq.tVQ = paramFavorPayInfo;
    String str = this.tXq.TAG;
    if (this.tXq.tVQ == null) {}
    for (paramFavorPayInfo = "";; paramFavorPayInfo = this.tXq.tVQ.toString())
    {
      ab.i(str, "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s", new Object[] { paramFavorPayInfo, Boolean.valueOf(paramBoolean) });
      if ((this.tXq.tVQ == null) || (!paramBoolean)) {
        break;
      }
      this.tXq.ar(-100, true);
      AppMethodBeat.o(46043);
      return;
    }
    int i;
    if (!bo.isNullOrNil(paramString))
    {
      if (this.tXq.mPayInfo != null) {
        break label232;
      }
      i = 0;
      if (this.tXq.mPayInfo != null) {
        break label247;
      }
    }
    label232:
    label247:
    for (paramFavorPayInfo = "";; paramFavorPayInfo = this.tXq.mPayInfo.cnI)
    {
      ad.e(i, paramFavorPayInfo, 9, "");
      this.tXq.gJv = paramString;
      this.tXq.nB(false);
      d.cWY();
      this.tXq.tVS = null;
      AppMethodBeat.o(46043);
      return;
      i = this.tXq.mPayInfo.cCD;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.8
 * JD-Core Version:    0.7.0.1
 */