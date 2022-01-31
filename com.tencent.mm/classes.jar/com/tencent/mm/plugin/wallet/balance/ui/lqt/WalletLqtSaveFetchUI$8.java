package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.balance.a.a.p;
import com.tencent.mm.plugin.wallet.balance.a.a.p.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.protocal.c.fu;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletLqtSaveFetchUI$8
  implements View.OnClickListener
{
  WalletLqtSaveFetchUI$8(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void onClick(View paramView)
  {
    if (bk.cp(WalletLqtSaveFetchUI.t(this.qiZ)) < 800L) {
      y.d("MicroMsg.WalletLqtSaveFetchUI", "saveButton click too soon");
    }
    int j;
    do
    {
      do
      {
        return;
        WalletLqtSaveFetchUI.a(this.qiZ, bk.UZ());
        j = WalletLqtSaveFetchUI.fh(WalletLqtSaveFetchUI.c(this.qiZ).getText(), "100");
      } while (j <= 0);
      if (WalletLqtSaveFetchUI.h(this.qiZ) == 1)
      {
        y.i("MicroMsg.WalletLqtSaveFetchUI", "click save lqt");
        paramView = WalletLqtSaveFetchUI.v(this.qiZ).qgg;
        f.c(Integer.valueOf(j), Integer.valueOf(WalletLqtSaveFetchUI.u(this.qiZ)), WalletLqtSaveFetchUI.d(this.qiZ)).c(paramView).f(new WalletLqtSaveFetchUI.8.2(this, j)).a(new WalletLqtSaveFetchUI.8.1(this));
        return;
      }
    } while (WalletLqtSaveFetchUI.h(this.qiZ) != 2);
    y.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
    p.a locala = null;
    paramView = locala;
    if (WalletLqtSaveFetchUI.d(this.qiZ) != null)
    {
      paramView = locala;
      if (!WalletLqtSaveFetchUI.d(this.qiZ).bUQ())
      {
        paramView = new fu();
        paramView.lnT = WalletLqtSaveFetchUI.d(this.qiZ).field_bankName;
        paramView.mOb = WalletLqtSaveFetchUI.d(this.qiZ).field_bankcardType;
        paramView.szR = WalletLqtSaveFetchUI.d(this.qiZ).field_bindSerial;
        paramView.mOY = WalletLqtSaveFetchUI.d(this.qiZ).field_bankcardTail;
      }
    }
    int i = -1;
    if (WalletLqtSaveFetchUI.w(this.qiZ).getSelectRedeemType() != null) {
      i = WalletLqtSaveFetchUI.w(this.qiZ).getSelectRedeemType().tAb;
    }
    locala = WalletLqtSaveFetchUI.v(this.qiZ).qgh;
    f.a(Integer.valueOf(j), Integer.valueOf(WalletLqtSaveFetchUI.u(this.qiZ)), Integer.valueOf(i), paramView).c(locala).f(new WalletLqtSaveFetchUI.8.4(this, j)).a(new WalletLqtSaveFetchUI.8.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.8
 * JD-Core Version:    0.7.0.1
 */