package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.ui.n.b;
import com.tencent.mm.protocal.c.bya;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletPayCustomUI$1
  implements n.b
{
  WalletPayCustomUI$1(WalletPayCustomUI paramWalletPayCustomUI) {}
  
  public final void d(String paramString1, boolean paramBoolean, String paramString2)
  {
    int j = WalletPayCustomUI.a(this.qmU).tNX;
    String str1 = WalletPayCustomUI.a(this.qmU).tNW;
    String str2 = WalletPayCustomUI.a(this.qmU).sign;
    String str3 = WalletPayCustomUI.a(this.qmU).ivD;
    String str4 = WalletPayCustomUI.a(this.qmU).taA;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramString1 = new w(paramString1, j, str1, str2, str3, str4, i, paramString2, "");
      this.qmU.a(paramString1, true, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI.1
 * JD-Core Version:    0.7.0.1
 */