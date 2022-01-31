package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.f.a;
import com.tencent.mm.sdk.platformtools.ab;

final class SDKOAuthUI$1
  implements Runnable
{
  SDKOAuthUI$1(SDKOAuthUI paramSDKOAuthUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(7524);
    ab.i("MicroMsg.SdkOAuthUI", "BackBtn click");
    a.vtM.a(SDKOAuthUI.a(this.vbR), SDKOAuthUI.b(this.vbR), 0, SDKOAuthUI.c(this.vbR), SDKOAuthUI.d(this.vbR), 1, 0);
    SDKOAuthUI.a(this.vbR, -2);
    this.vbR.finish();
    AppMethodBeat.o(7524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.1
 * JD-Core Version:    0.7.0.1
 */