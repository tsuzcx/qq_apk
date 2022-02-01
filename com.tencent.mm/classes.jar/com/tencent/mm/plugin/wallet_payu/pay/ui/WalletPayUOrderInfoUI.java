package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.ui.RemittanceF2fLargeMoneyUI;

public class WalletPayUOrderInfoUI
  extends RemittanceF2fLargeMoneyUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUOrderInfoUI
 * JD-Core Version:    0.7.0.1
 */