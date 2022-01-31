package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.bs;
import com.tencent.mm.h.a.bs.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.y;

final class WalletPasswordSettingUI$8$1
  implements Runnable
{
  WalletPasswordSettingUI$8$1(WalletPasswordSettingUI.8 param8, bs parambs) {}
  
  public final void run()
  {
    if (this.kkU.bHT != null)
    {
      if (this.kkU.bHT.retCode == 0)
      {
        WalletPasswordSettingUI.e(this.qpF.qpD);
        g.DQ();
        g.DO().dJT.a(new y(null, 19), 0);
      }
    }
    else {
      return;
    }
    WalletPasswordSettingUI.a(this.qpF.qpD, 1);
    WalletPasswordSettingUI.f(this.qpF.qpD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.8.1
 * JD-Core Version:    0.7.0.1
 */