package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.app.Activity;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

public class WalletPayUBalanceResultUI
  extends WalletBalanceResultUI
{
  public final void bJ()
  {
    AppMethodBeat.i(48329);
    if (this.qrf != null)
    {
      this.tON.setText(e.e(this.qrf.cnL, this.qrf.ppp));
      if ((this.tOQ != null) && (!bo.isNullOrNil(this.tOQ.field_bankName)))
      {
        if (!bo.isNullOrNil(this.tOQ.field_bankcardTail))
        {
          this.qgt.setText(this.tOQ.field_bankName + " " + getString(2131305466) + this.tOQ.field_bankcardTail);
          AppMethodBeat.o(48329);
          return;
        }
        this.qgt.setText(this.tOQ.field_bankName);
      }
    }
    AppMethodBeat.o(48329);
  }
  
  public void initView()
  {
    AppMethodBeat.i(48328);
    super.initView();
    this.tOP.setVisibility(8);
    AppMethodBeat.o(48328);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceResultUI
 * JD-Core Version:    0.7.0.1
 */