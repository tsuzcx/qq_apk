package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;

final class WalletCardElementUI$16
  implements View.OnClickListener
{
  WalletCardElementUI$16(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47233);
    paramView = new Intent();
    paramView.putExtra("GetAddress", true);
    paramView.putExtra("ShowSelectedLocation", false);
    if (!Bankcard.Ix(WalletCardElementUI.o(this.uoW).ubU))
    {
      paramView.putExtra("IsRealNameVerifyScene", true);
      paramView.putExtra("IsNeedShowSearchBar", true);
    }
    d.b(this.uoW.getContext(), ".ui.tools.MultiStageCitySelectUI", paramView, 4);
    AppMethodBeat.o(47233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.16
 * JD-Core Version:    0.7.0.1
 */