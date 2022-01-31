package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;

final class WalletRealNameVerifyUI$1
  implements View.OnClickListener
{
  WalletRealNameVerifyUI$1(WalletRealNameVerifyUI paramWalletRealNameVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(46620);
    paramView = new Intent(this.udf.getContext(), WalletSelectProfessionUI.class);
    paramView.putExtra("key_profession_list", WalletRealNameVerifyUI.a(this.udf));
    this.udf.startActivityForResult(paramView, 1);
    AppMethodBeat.o(46620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.1
 * JD-Core Version:    0.7.0.1
 */