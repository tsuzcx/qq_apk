package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUIV2;

public class PayURemittanceResendMsgUI
  extends LuckyMoneyBusiReceiveUIV2
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceResendMsgUI
 * JD-Core Version:    0.7.0.1
 */