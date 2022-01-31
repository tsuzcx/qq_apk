package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class k$5$11
  implements Runnable
{
  k$5$11(k.5 param5, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(9935);
    if ((this.vsJ.vsH.vmp != null) && (this.vsJ.vsH.voA != null) && (this.vsJ.vsH.voA.ddV() != null) && (this.vsJ.vsH.voA.ddV().jy(42))) {
      this.vsJ.vsH.vmp.i(this.cax, "download_removed");
    }
    AppMethodBeat.o(9935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k.5.11
 * JD-Core Version:    0.7.0.1
 */