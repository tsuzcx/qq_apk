package com.tencent.mm.plugin.remittance.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class RemittanceUI$4
  implements Runnable
{
  RemittanceUI$4(RemittanceUI paramRemittanceUI, vd paramvd) {}
  
  public final void run()
  {
    AppMethodBeat.i(45163);
    if (!bo.isNullOrNil(this.kSA.cLF.cLG))
    {
      e.a((TextView)this.qrA.findViewById(2131821672), this.kSA.cLF.cLG, this.kSA.cLF.content, this.kSA.cLF.url);
      AppMethodBeat.o(45163);
      return;
    }
    ab.i("MicroMsg.RemittanceUI", "no bulletin data");
    AppMethodBeat.o(45163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI.4
 * JD-Core Version:    0.7.0.1
 */