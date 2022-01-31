package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.bs;
import com.tencent.mm.h.a.bs.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.y;

final class WalletPasswordSettingUI$10$1
  implements Runnable
{
  WalletPasswordSettingUI$10$1(WalletPasswordSettingUI.10 param10, bs parambs) {}
  
  public final void run()
  {
    if (this.kkU.bHT != null)
    {
      if (this.kkU.bHT.retCode == 0)
      {
        WalletPasswordSettingUI.e(this.qpG.qpD);
        g.DQ();
        g.DO().dJT.a(new y(null, 19), 0);
      }
    }
    else {
      return;
    }
    WalletPasswordSettingUI.a(this.qpG.qpD, 0);
    WalletPasswordSettingUI.g(this.qpG.qpD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.10.1
 * JD-Core Version:    0.7.0.1
 */