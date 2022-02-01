package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI;

public class WalletPayUPwdConfirmUI
  extends LuckyMoneyHistoryEnvelopeUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI
 * JD-Core Version:    0.7.0.1
 */