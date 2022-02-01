package com.tencent.mm.plugin.wallet_payu.pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUIV2;

public class WalletPayUChangeBankcardUI
  extends LuckyMoneyNewYearReceiveUIV2
{
  public WalletPayUChangeBankcardUI()
  {
    AppMethodBeat.i(72106);
    AppMethodBeat.o(72106);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI
 * JD-Core Version:    0.7.0.1
 */