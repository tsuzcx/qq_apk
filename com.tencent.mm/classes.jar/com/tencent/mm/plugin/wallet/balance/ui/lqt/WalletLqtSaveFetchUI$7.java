package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletLqtSaveFetchUI$7
  implements a
{
  WalletLqtSaveFetchUI$7(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void gK(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (WalletLqtSaveFetchUI.h(this.qiZ) == 2) {
        WalletLqtSaveFetchUI.p(this.qiZ);
      }
    }
    do
    {
      do
      {
        return;
      } while (WalletLqtSaveFetchUI.h(this.qiZ) != 1);
      WalletLqtSaveFetchUI.q(this.qiZ).post(new WalletLqtSaveFetchUI.7.1(this));
      return;
      WalletLqtSaveFetchUI.q(this.qiZ).scrollTo(0, 0);
    } while ((WalletLqtSaveFetchUI.h(this.qiZ) != 2) || (!bk.bl(WalletLqtSaveFetchUI.c(this.qiZ).getText())));
    WalletLqtSaveFetchUI.s(this.qiZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.7
 * JD-Core Version:    0.7.0.1
 */