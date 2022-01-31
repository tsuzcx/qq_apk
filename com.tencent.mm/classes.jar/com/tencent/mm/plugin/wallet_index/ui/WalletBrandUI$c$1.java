package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity.a;

final class WalletBrandUI$c$1
  implements MMActivity.a
{
  WalletBrandUI$c$1(WalletBrandUI.c paramc) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(142593);
    if (paramInt1 == WalletBrandUI.g(this.uBf.uBc))
    {
      this.uBf.uBc.setResult(paramInt2, paramIntent);
      this.uBf.uBc.finish();
    }
    AppMethodBeat.o(142593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.c.1
 * JD-Core Version:    0.7.0.1
 */