package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class n$1
  implements Runnable
{
  n$1(n paramn, WebViewUI paramWebViewUI, d paramd, k paramk, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(7713);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7713);
      return;
    }
    if ((this.vdp != null) && (this.vdq != null) && (this.vdq.ddV() != null) && (this.vdq.ddV().jy(42))) {
      this.vdp.i(this.cax, "download_succ");
    }
    AppMethodBeat.o(7713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.1
 * JD-Core Version:    0.7.0.1
 */