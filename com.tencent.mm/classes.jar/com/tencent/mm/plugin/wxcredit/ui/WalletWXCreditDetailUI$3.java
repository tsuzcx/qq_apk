package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxcredit.a.j;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.wallet_core.ui.e;

final class WalletWXCreditDetailUI$3
  implements View.OnClickListener
{
  WalletWXCreditDetailUI$3(WalletWXCreditDetailUI paramWalletWXCreditDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48722);
    if (paramView.getId() == 2131829429)
    {
      if (WalletWXCreditDetailUI.b(this.vIB) != null)
      {
        e.ae(this.vIB, WalletWXCreditDetailUI.b(this.vIB).vHS.username);
        AppMethodBeat.o(48722);
      }
    }
    else if ((paramView.getId() == 2131829430) && (WalletWXCreditDetailUI.b(this.vIB) != null)) {
      e.m(this.vIB, WalletWXCreditDetailUI.b(this.vIB).vHR, false);
    }
    AppMethodBeat.o(48722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI.3
 * JD-Core Version:    0.7.0.1
 */