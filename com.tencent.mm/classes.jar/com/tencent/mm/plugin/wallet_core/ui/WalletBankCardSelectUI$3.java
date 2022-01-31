package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.e.a.a;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class WalletBankCardSelectUI$3
  implements a.a
{
  WalletBankCardSelectUI$3(WalletBankCardSelectUI paramWalletBankCardSelectUI) {}
  
  public final void S(Map<String, e> paramMap)
  {
    y.i("WalletBankCardSelectUI", "get logo callback: %s", new Object[] { Integer.valueOf(paramMap.size()) });
    WalletBankCardSelectUI.a(this.qAo, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI.3
 * JD-Core Version:    0.7.0.1
 */