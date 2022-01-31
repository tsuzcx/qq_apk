package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class WalletCheckPwdUI$3
  implements EditHintPasswdView.a
{
  WalletCheckPwdUI$3(WalletCheckPwdUI paramWalletCheckPwdUI) {}
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(47334);
    if (paramBoolean)
    {
      WalletCheckPwdUI.a(this.uqg, this.uqg.nID.getText());
      c localc = a.aM(this.uqg);
      String str = null;
      if (localc != null) {
        str = localc.bzC();
      }
      if ((WalletCheckPwdUI.b(this.uqg)) && (!"UnbindProcess".equals(str)))
      {
        this.uqg.doSceneProgress(new v(WalletCheckPwdUI.c(this.uqg), WalletCheckPwdUI.d(this.uqg), (byte)0));
        h.qsU.e(15021, new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(47334);
        return;
      }
      if (!this.uqg.getNetController().p(new Object[] { WalletCheckPwdUI.c(this.uqg), this.uqg.getPayReqKey() })) {
        this.uqg.doSceneProgress(new u(WalletCheckPwdUI.c(this.uqg), 1, this.uqg.getPayReqKey()));
      }
    }
    AppMethodBeat.o(47334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.3
 * JD-Core Version:    0.7.0.1
 */