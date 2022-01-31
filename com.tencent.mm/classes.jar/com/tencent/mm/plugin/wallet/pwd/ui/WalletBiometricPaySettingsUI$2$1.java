package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.bu;
import com.tencent.mm.g.a.bu.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class WalletBiometricPaySettingsUI$2$1
  implements Runnable
{
  WalletBiometricPaySettingsUI$2$1(WalletBiometricPaySettingsUI.2 param2, bu parambu, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(46221);
    if (this.tYE.cpj != null)
    {
      if (this.tYF != null) {
        this.tYF.dismiss();
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletBiometricPaySettingsUI", "close event result: %s", new Object[] { Integer.valueOf(this.tYE.cpj.retCode) });
      if (this.tYE.cpj.retCode == 0)
      {
        g.RK().eHt.a(new com.tencent.mm.plugin.wallet_core.c.ab(null, 19), 0);
        AppMethodBeat.o(46221);
        return;
      }
      WalletBiometricPaySettingsUI.b(this.tYG.tYD);
      WalletBiometricPaySettingsUI.c(this.tYG.tYD);
    }
    AppMethodBeat.o(46221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletBiometricPaySettingsUI.2.1
 * JD-Core Version:    0.7.0.1
 */