package com.tencent.mm.plugin.nfc_open.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class NfcWebViewUI$2
  implements Runnable
{
  NfcWebViewUI$2(NfcWebViewUI paramNfcWebViewUI, String paramString) {}
  
  public final void run()
  {
    h.nFQ.f(12794, new Object[] { this.mGx, Integer.valueOf(0) });
    y.d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + this.mGx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI.2
 * JD-Core Version:    0.7.0.1
 */