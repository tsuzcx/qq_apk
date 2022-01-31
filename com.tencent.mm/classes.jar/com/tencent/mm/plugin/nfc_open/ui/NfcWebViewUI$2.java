package com.tencent.mm.plugin.nfc_open.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class NfcWebViewUI$2
  implements Runnable
{
  NfcWebViewUI$2(NfcWebViewUI paramNfcWebViewUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(23070);
    h.qsU.e(12794, new Object[] { this.pgD, Integer.valueOf(0) });
    ab.d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + this.pgD);
    AppMethodBeat.o(23070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI.2
 * JD-Core Version:    0.7.0.1
 */