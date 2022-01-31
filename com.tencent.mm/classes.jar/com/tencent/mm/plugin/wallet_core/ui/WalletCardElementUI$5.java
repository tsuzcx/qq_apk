package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;

final class WalletCardElementUI$5
  implements View.OnClickListener
{
  WalletCardElementUI$5(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47215);
    paramView = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
    if (Bankcard.Ix(WalletCardElementUI.o(this.uoW).ubU)) {
      paramView.putExtra("IsAutoPosition", false);
    }
    for (;;)
    {
      this.uoW.startActivityForResult(paramView, 2);
      AppMethodBeat.o(47215);
      return;
      paramView.putExtra("IsRealNameVerifyScene", true);
      paramView.putExtra("IsNeedShowSearchBar", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.5
 * JD-Core Version:    0.7.0.1
 */