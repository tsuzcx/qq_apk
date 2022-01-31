package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.utils.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class WalletBankCardSelectUI$3
  implements a.a
{
  WalletBankCardSelectUI$3(WalletBankCardSelectUI paramWalletBankCardSelectUI) {}
  
  public final void am(Map<String, g> paramMap)
  {
    AppMethodBeat.i(47145);
    ab.i("WalletBankCardSelectUI", "get logo callback: %s", new Object[] { Integer.valueOf(paramMap.size()) });
    WalletBankCardSelectUI.access$200(this.umW, paramMap);
    AppMethodBeat.o(47145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI.3
 * JD-Core Version:    0.7.0.1
 */