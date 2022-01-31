package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WalletCardElementUI$15
  implements View.OnClickListener
{
  WalletCardElementUI$15(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("GetAddress", true);
    paramView.putExtra("ShowSelectedLocation", false);
    if (!Bankcard.AM(WalletCardElementUI.n(this.qCj).qqY))
    {
      paramView.putExtra("IsRealNameVerifyScene", true);
      paramView.putExtra("IsNeedShowSearchBar", true);
    }
    d.c(this.qCj.mController.uMN, ".ui.tools.MultiStageCitySelectUI", paramView, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.15
 * JD-Core Version:    0.7.0.1
 */