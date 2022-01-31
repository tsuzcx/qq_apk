package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.mm.plugin.wallet.pwd.a.j;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class WalletLockCheckPwdUI$3
  implements EditHintPasswdView.a
{
  WalletLockCheckPwdUI$3(WalletLockCheckPwdUI paramWalletLockCheckPwdUI) {}
  
  public final void gG(boolean paramBoolean)
  {
    int i = 8;
    if ((!paramBoolean) || (WalletLockCheckPwdUI.b(this.qps) == null)) {}
    do
    {
      return;
      if (WalletLockCheckPwdUI.b(this.qps).equals("action.close_wallet_lock"))
      {
        WalletLockCheckPwdUI.c(this.qps);
        return;
      }
      if (WalletLockCheckPwdUI.b(this.qps).equals("action.verify_paypwd"))
      {
        if (WalletLockCheckPwdUI.d(this.qps) == 1) {
          i = 6;
        }
        for (;;)
        {
          WalletLockCheckPwdUI.a(this.qps, new r(WalletLockCheckPwdUI.e(this.qps).getText(), i, this.qps.bTO()));
          this.qps.a(WalletLockCheckPwdUI.f(this.qps), true, false);
          return;
          if (WalletLockCheckPwdUI.d(this.qps) != 2) {
            i = -1;
          }
        }
      }
      if (WalletLockCheckPwdUI.b(this.qps).equals("action.touchlock_verify_by_paypwd"))
      {
        j localj = new j(WalletLockCheckPwdUI.e(this.qps).getText());
        this.qps.a(localj, true, false);
        return;
      }
    } while (!WalletLockCheckPwdUI.b(this.qps).equals("action.touchlock_need_verify_paypwd"));
    if (WalletLockCheckPwdUI.d(this.qps) == 2) {}
    for (;;)
    {
      WalletLockCheckPwdUI.a(this.qps, new r(WalletLockCheckPwdUI.e(this.qps).getText(), i, this.qps.bTO()));
      this.qps.a(WalletLockCheckPwdUI.f(this.qps), true, false);
      return;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI.3
 * JD-Core Version:    0.7.0.1
 */