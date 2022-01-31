package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;

final class WalletBalanceManagerUI$8
  implements View.OnClickListener
{
  WalletBalanceManagerUI$8(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    p.bTK();
    paramView = p.bTL().bWb();
    if ((paramView == null) || (paramView.size() == 0))
    {
      y.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
      WalletBalanceManagerUI.b(this.qhk);
      return;
    }
    y.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
    a.a(this.qhk, b.class, null, null);
    e.Jc(15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.8
 * JD-Core Version:    0.7.0.1
 */