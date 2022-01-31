package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bn.a;
import com.tencent.mm.bn.a.a;
import com.tencent.mm.bn.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class WebViewUI$3
  implements a.b
{
  WebViewUI$3(WebViewUI paramWebViewUI) {}
  
  public final void a(a.a parama1, a.a parama2)
  {
    AppMethodBeat.i(7811);
    ab.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + parama1.name() + "; newOrientation:" + parama2.name());
    this.vgz.screenOrientation = 4;
    this.vgz.setMMOrientation();
    if (this.vgz.vep != null) {
      this.vgz.vep.disable();
    }
    AppMethodBeat.o(7811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.3
 * JD-Core Version:    0.7.0.1
 */