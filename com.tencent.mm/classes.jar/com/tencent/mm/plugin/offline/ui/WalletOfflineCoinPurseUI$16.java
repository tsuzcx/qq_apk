package com.tencent.mm.plugin.offline.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

final class WalletOfflineCoinPurseUI$16
  implements h.c
{
  WalletOfflineCoinPurseUI$16(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(43522);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(43522);
      return;
      a.eK(this.pny);
      AppMethodBeat.o(43522);
      return;
      c localc = WalletOfflineCoinPurseUI.z(this.pny);
      if (!((b)g.E(b.class)).cXu())
      {
        h.d(localc.mActivity, localc.getString(2131305737), "", localc.getString(2131305772), localc.getString(2131305734), new c.7(localc), new c.8(localc));
        AppMethodBeat.o(43522);
        return;
      }
      h.d(localc.mActivity, localc.getString(2131305735), "", localc.getString(2131305734), localc.getString(2131296888), new c.9(localc), new c.10(localc));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.16
 * JD-Core Version:    0.7.0.1
 */