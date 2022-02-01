package com.tencent.mm.plugin.remittance.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class RemittanceDetailUI$8
  implements Runnable
{
  boolean hwA = false;
  
  RemittanceDetailUI$8(RemittanceDetailUI paramRemittanceDetailUI, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(68131);
    ac.i("MicroMsg.RemittanceDetailUI", "WalletGetUserInfoEvent callback() hasCallback:%s", new Object[] { Boolean.valueOf(this.hwA) });
    if (!this.hwA) {
      RemittanceDetailUI.a(this.wRp, this.qLa);
    }
    this.hwA = true;
    AppMethodBeat.o(68131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.8
 * JD-Core Version:    0.7.0.1
 */