package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class n$45
  implements Runnable
{
  n$45(n paramn, WebViewUI paramWebViewUI, d paramd, k paramk, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(7758);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7758);
      return;
    }
    if ((this.vdp != null) && (this.vdq != null) && (this.vdq.ddV() != null) && (this.vdq.ddV().jy(42))) {
      this.vdp.i(this.cax, "download_resumed");
    }
    AppMethodBeat.o(7758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.45
 * JD-Core Version:    0.7.0.1
 */