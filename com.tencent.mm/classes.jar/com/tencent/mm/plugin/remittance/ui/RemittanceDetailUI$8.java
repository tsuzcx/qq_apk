package com.tencent.mm.plugin.remittance.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class RemittanceDetailUI$8
  implements Runnable
{
  boolean gWb = false;
  
  RemittanceDetailUI$8(RemittanceDetailUI paramRemittanceDetailUI, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(68131);
    ad.i("MicroMsg.RemittanceDetailUI", "WalletGetUserInfoEvent callback() hasCallback:%s", new Object[] { Boolean.valueOf(this.gWb) });
    if (!this.gWb) {
      RemittanceDetailUI.a(this.vHk, this.qcu);
    }
    this.gWb = true;
    AppMethodBeat.o(68131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.8
 * JD-Core Version:    0.7.0.1
 */