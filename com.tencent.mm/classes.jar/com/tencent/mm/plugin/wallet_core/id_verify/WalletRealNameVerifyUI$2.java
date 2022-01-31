package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class WalletRealNameVerifyUI$2
  implements View.OnClickListener
{
  WalletRealNameVerifyUI$2(WalletRealNameVerifyUI paramWalletRealNameVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46621);
    paramView = new Intent();
    paramView.putExtra("GetAddress", true);
    paramView.putExtra("ShowSelectedLocation", false);
    paramView.putExtra("IsRealNameVerifyScene", true);
    paramView.putExtra("IsNeedShowSearchBar", true);
    d.b(this.udf.getContext(), ".ui.tools.MultiStageCitySelectUI", paramView, 2);
    AppMethodBeat.o(46621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.2
 * JD-Core Version:    0.7.0.1
 */