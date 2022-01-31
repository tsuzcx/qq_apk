package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletCardElementUI$17
  implements View.OnClickListener
{
  WalletCardElementUI$17(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47234);
    paramView = new Intent(this.uoW.getContext(), WalletSelectProfessionUI.class);
    paramView.putExtra("key_profession_list", WalletCardElementUI.p(this.uoW));
    this.uoW.startActivityForResult(paramView, 5);
    AppMethodBeat.o(47234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.17
 * JD-Core Version:    0.7.0.1
 */