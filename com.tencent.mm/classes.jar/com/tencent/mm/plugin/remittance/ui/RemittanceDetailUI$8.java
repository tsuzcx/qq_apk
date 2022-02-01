package com.tencent.mm.plugin.remittance.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class RemittanceDetailUI$8
  implements Runnable
{
  boolean hRI = false;
  
  RemittanceDetailUI$8(RemittanceDetailUI paramRemittanceDetailUI, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(68131);
    ae.i("MicroMsg.RemittanceDetailUI", "WalletGetUserInfoEvent callback() hasCallback:%s", new Object[] { Boolean.valueOf(this.hRI) });
    if (!this.hRI) {
      RemittanceDetailUI.a(this.yuO, this.rDo);
    }
    this.hRI = true;
    AppMethodBeat.o(68131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.8
 * JD-Core Version:    0.7.0.1
 */