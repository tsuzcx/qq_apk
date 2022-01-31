package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class k$5$12
  implements Runnable
{
  k$5$12(k.5 param5, String paramString, long paramLong, int paramInt, float paramFloat) {}
  
  public final void run()
  {
    AppMethodBeat.i(9936);
    if ((this.vsJ.vsH.vmp != null) && (this.vsJ.vsH.voA != null) && (this.vsJ.vsH.voA.ddV() != null) && (this.vsJ.vsH.voA.ddV().jy(42))) {
      this.vsJ.vsH.vmp.a(this.val$appId, this.kXZ, this.gQj, this.vdW);
    }
    AppMethodBeat.o(9936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k.5.12
 * JD-Core Version:    0.7.0.1
 */