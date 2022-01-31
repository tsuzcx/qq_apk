package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;

final class WalletCardElementUI$4
  implements View.OnClickListener
{
  WalletCardElementUI$4(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
    if (Bankcard.AM(WalletCardElementUI.n(this.qCj).qqY)) {
      paramView.putExtra("IsAutoPosition", false);
    }
    for (;;)
    {
      this.qCj.startActivityForResult(paramView, 2);
      return;
      paramView.putExtra("IsRealNameVerifyScene", true);
      paramView.putExtra("IsNeedShowSearchBar", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.4
 * JD-Core Version:    0.7.0.1
 */