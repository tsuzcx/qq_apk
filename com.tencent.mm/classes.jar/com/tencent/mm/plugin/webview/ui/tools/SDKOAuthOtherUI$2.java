package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.f.a;
import com.tencent.mm.plugin.webview.model.ai;

final class SDKOAuthOtherUI$2
  implements Runnable
{
  SDKOAuthOtherUI$2(SDKOAuthOtherUI paramSDKOAuthOtherUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(153183);
    a.vtM.a(SDKOAuthOtherUI.a(this.vbx), SDKOAuthOtherUI.b(this.vbx), 0, SDKOAuthOtherUI.c(this.vbx), 4, 1, 0);
    SDKOAuthOtherUI.d(this.vbx).JU(-2);
    this.vbx.finish();
    AppMethodBeat.o(153183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.2
 * JD-Core Version:    0.7.0.1
 */