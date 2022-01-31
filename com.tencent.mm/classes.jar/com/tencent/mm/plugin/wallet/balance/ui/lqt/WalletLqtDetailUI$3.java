package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.balance.a.a.k;
import com.tencent.mm.protocal.c.bhm;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;

final class WalletLqtDetailUI$3
  implements View.OnClickListener
{
  WalletLqtDetailUI$3(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = WalletLqtDetailUI.f(this.qil).qfH;
    f.ci(Integer.valueOf(WalletLqtDetailUI.c(this.qil).sOy)).c(paramView);
    paramView = new Intent(this.qil, WalletLqtSaveFetchUI.class);
    paramView.putExtra("lqt_save_fetch_mode", 2);
    paramView.putExtra("lqt_balance", WalletLqtDetailUI.c(this.qil).balance);
    paramView.putExtra("lqt_max_redeem_amount", WalletLqtDetailUI.c(this.qil).tCg);
    paramView.putExtra("lqt_redeem_invalid_amount_hint", WalletLqtDetailUI.c(this.qil).tCh);
    paramView.putExtra("lqt_account_type", WalletLqtDetailUI.c(this.qil).sOy);
    this.qil.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.3
 * JD-Core Version:    0.7.0.1
 */