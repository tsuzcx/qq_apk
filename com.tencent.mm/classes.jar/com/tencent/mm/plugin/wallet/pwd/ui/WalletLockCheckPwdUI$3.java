package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pwd.a.q;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class WalletLockCheckPwdUI$3
  implements EditHintPasswdView.a
{
  WalletLockCheckPwdUI$3(WalletLockCheckPwdUI paramWalletLockCheckPwdUI) {}
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    int i = 8;
    AppMethodBeat.i(46339);
    if (paramBoolean)
    {
      if (WalletLockCheckPwdUI.b(this.tZF) == null)
      {
        AppMethodBeat.o(46339);
        return;
      }
      if (WalletLockCheckPwdUI.b(this.tZF).equals("action.close_wallet_lock"))
      {
        WalletLockCheckPwdUI.c(this.tZF);
        AppMethodBeat.o(46339);
        return;
      }
      if (WalletLockCheckPwdUI.b(this.tZF).equals("action.verify_paypwd"))
      {
        if (WalletLockCheckPwdUI.d(this.tZF) == 1) {
          i = 6;
        }
        for (;;)
        {
          WalletLockCheckPwdUI.a(this.tZF, new u(WalletLockCheckPwdUI.e(this.tZF).getText(), i, this.tZF.getPayReqKey()));
          this.tZF.doSceneForceProgress(WalletLockCheckPwdUI.f(this.tZF));
          AppMethodBeat.o(46339);
          return;
          if (WalletLockCheckPwdUI.d(this.tZF) != 2) {
            i = -1;
          }
        }
      }
      if (WalletLockCheckPwdUI.b(this.tZF).equals("action.touchlock_verify_by_paypwd"))
      {
        q localq = new q(WalletLockCheckPwdUI.e(this.tZF).getText());
        this.tZF.doSceneForceProgress(localq);
        AppMethodBeat.o(46339);
        return;
      }
      if (WalletLockCheckPwdUI.b(this.tZF).equals("action.touchlock_need_verify_paypwd")) {
        if (WalletLockCheckPwdUI.d(this.tZF) != 2) {
          break label280;
        }
      }
    }
    for (;;)
    {
      WalletLockCheckPwdUI.a(this.tZF, new u(WalletLockCheckPwdUI.e(this.tZF).getText(), i, this.tZF.getPayReqKey()));
      this.tZF.doSceneForceProgress(WalletLockCheckPwdUI.f(this.tZF));
      AppMethodBeat.o(46339);
      return;
      label280:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI.3
 * JD-Core Version:    0.7.0.1
 */