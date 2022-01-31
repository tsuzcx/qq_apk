package com.tencent.mm.plugin.offline.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class WalletOfflineCoinPurseUI$5
  implements Runnable
{
  WalletOfflineCoinPurseUI$5(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, vd paramvd) {}
  
  public final void run()
  {
    AppMethodBeat.i(43508);
    if (!bo.isNullOrNil(this.kSA.cLF.cLG))
    {
      e.a((TextView)this.pny.findViewById(2131821672), this.kSA.cLF.cLG, this.kSA.cLF.content, this.kSA.cLF.url);
      AppMethodBeat.o(43508);
      return;
    }
    ab.i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
    AppMethodBeat.o(43508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.5
 * JD-Core Version:    0.7.0.1
 */