package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.base.h;

final class WalletVerifyCodeUI$6
  implements View.OnClickListener
{
  WalletVerifyCodeUI$6(WalletVerifyCodeUI paramWalletVerifyCodeUI, Bankcard paramBankcard) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47695);
    h.d(this.uul, this.uul.getString(2131305490, new Object[] { this.tNr.field_desc, this.tNr.field_mobile }), "", this.uul.getString(2131305489), this.uul.getString(2131296888), new WalletVerifyCodeUI.6.1(this), null);
    AppMethodBeat.o(47695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.6
 * JD-Core Version:    0.7.0.1
 */