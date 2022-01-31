package com.tencent.mm.plugin.wallet.bind.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBankcardManageUI$5
  implements Runnable
{
  WalletBankcardManageUI$5(WalletBankcardManageUI paramWalletBankcardManageUI, vd paramvd) {}
  
  public final void run()
  {
    AppMethodBeat.i(45767);
    if (!bo.isNullOrNil(this.kSA.cLF.cLG))
    {
      e.a((TextView)this.tTk.findViewById(2131821672), this.kSA.cLF.cLG, this.kSA.cLF.content, this.kSA.cLF.url);
      AppMethodBeat.o(45767);
      return;
    }
    ab.i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
    AppMethodBeat.o(45767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.5
 * JD-Core Version:    0.7.0.1
 */