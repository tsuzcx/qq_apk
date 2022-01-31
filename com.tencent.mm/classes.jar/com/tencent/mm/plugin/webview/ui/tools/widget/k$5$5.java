package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class k$5$5
  implements Runnable
{
  k$5$5(k.5 param5, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(9929);
    if (this.vsJ.vsH.vmp != null)
    {
      String str = this.cax.getString("webview_network_type");
      this.vsJ.vsH.vmp.ajb(str);
    }
    AppMethodBeat.o(9929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k.5.5
 * JD-Core Version:    0.7.0.1
 */