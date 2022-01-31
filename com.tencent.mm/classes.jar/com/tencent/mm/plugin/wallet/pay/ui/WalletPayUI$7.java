package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.o.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.aa;

final class WalletPayUI$7
  implements o.c
{
  WalletPayUI$7(WalletPayUI paramWalletPayUI) {}
  
  public final void a(String paramString, FavorPayInfo paramFavorPayInfo, boolean paramBoolean)
  {
    this.qnV.XM();
    this.qnV.qmA = paramFavorPayInfo;
    if (this.qnV.qmA == null) {}
    for (paramFavorPayInfo = "";; paramFavorPayInfo = this.qnV.qmA.toString())
    {
      y.i("MicroMsg.WalletPayUI", "WalletPwdDialog showAlert with favinfo %s isNeedChangeBankcard %s", new Object[] { paramFavorPayInfo, Boolean.valueOf(paramBoolean) });
      if ((this.qnV.qmA == null) || (!paramBoolean)) {
        break;
      }
      this.qnV.ac(-100, true);
      return;
    }
    int i;
    if (this.qnV.nDu == null)
    {
      i = 0;
      if (this.qnV.nDu != null) {
        break label168;
      }
    }
    label168:
    for (paramFavorPayInfo = "";; paramFavorPayInfo = this.qnV.nDu.bMX)
    {
      aa.d(i, paramFavorPayInfo, 9, "");
      this.qnV.frT = paramString;
      this.qnV.kx(false);
      c.bXt();
      this.qnV.qmC = null;
      return;
      i = this.qnV.nDu.bUV;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.7
 * JD-Core Version:    0.7.0.1
 */