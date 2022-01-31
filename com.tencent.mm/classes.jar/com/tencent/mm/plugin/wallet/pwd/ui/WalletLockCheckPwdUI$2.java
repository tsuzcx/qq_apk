package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class WalletLockCheckPwdUI$2
  implements View.OnClickListener
{
  WalletLockCheckPwdUI$2(WalletLockCheckPwdUI paramWalletLockCheckPwdUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
    WalletLockCheckPwdUI.a(this.qps);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI.2
 * JD-Core Version:    0.7.0.1
 */