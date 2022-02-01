package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.app.Activity;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;

public class WalletPayUBalanceResultUI
  extends WalletBalanceResultUI
{
  public void initView()
  {
    AppMethodBeat.i(71969);
    super.initView();
    this.Ooi.setVisibility(8);
    AppMethodBeat.o(71969);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceResultUI
 * JD-Core Version:    0.7.0.1
 */