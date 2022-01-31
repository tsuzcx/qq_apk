package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class k$5$1
  implements Runnable
{
  k$5$1(k.5 param5, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(9925);
    if ((this.vsJ.vsH.vmp != null) && (this.vsJ.vsH.voA != null) && (this.vsJ.vsH.voA.ddV() != null) && (this.vsJ.vsH.voA.ddV().jy(42))) {
      this.vsJ.vsH.vmp.i(this.cax, "download_succ");
    }
    AppMethodBeat.o(9925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k.5.1
 * JD-Core Version:    0.7.0.1
 */