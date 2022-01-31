package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.bag.h;

final class n$25
  implements Runnable
{
  n$25(n paramn, WebViewUI paramWebViewUI, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(7737);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7737);
      return;
    }
    if (this.cax != null) {
      this.vdo.uRy.aiE(this.cax.getString("key_bag_icon"));
    }
    AppMethodBeat.o(7737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.25
 * JD-Core Version:    0.7.0.1
 */