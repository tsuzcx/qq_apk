package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class n$57
  implements Runnable
{
  n$57(n paramn, WebViewUI paramWebViewUI, d paramd, k paramk, String paramString, long paramLong, int paramInt, float paramFloat) {}
  
  public final void run()
  {
    AppMethodBeat.i(7771);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7771);
      return;
    }
    if ((this.vdp != null) && (this.vdq != null) && (this.vdq.ddV() != null) && (this.vdq.ddV().jy(42))) {
      this.vdp.a(this.val$appId, this.kXZ, this.gQj, this.vdW);
    }
    AppMethodBeat.o(7771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.57
 * JD-Core Version:    0.7.0.1
 */