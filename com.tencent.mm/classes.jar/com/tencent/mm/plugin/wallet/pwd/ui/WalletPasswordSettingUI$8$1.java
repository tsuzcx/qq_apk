package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.bu;
import com.tencent.mm.g.a.bu.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.ab;

final class WalletPasswordSettingUI$8$1
  implements Runnable
{
  WalletPasswordSettingUI$8$1(WalletPasswordSettingUI.8 param8, bu parambu) {}
  
  public final void run()
  {
    AppMethodBeat.i(46357);
    if (this.tYE.cpj != null)
    {
      if (this.tYE.cpj.retCode == 0)
      {
        WalletPasswordSettingUI.d(this.uab.tZZ);
        g.RM();
        g.RK().eHt.a(new ab(null, 19), 0);
        AppMethodBeat.o(46357);
        return;
      }
      WalletPasswordSettingUI.e(this.uab.tZZ);
      WalletPasswordSettingUI.f(this.uab.tZZ);
    }
    AppMethodBeat.o(46357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.8.1
 * JD-Core Version:    0.7.0.1
 */