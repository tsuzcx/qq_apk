package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class n$38
  implements Runnable
{
  n$38(n paramn, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(7751);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7751);
      return;
    }
    if (!bo.isNullOrNil(((WebViewUI)n.a(this.vdr).get()).pOd.getUrl()))
    {
      ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, userName = " + this.fwC);
      ((WebViewUI)n.a(this.vdr).get()).vfl.put(((WebViewUI)n.a(this.vdr).get()).pOd.getUrl(), this.fwC);
      AppMethodBeat.o(7751);
      return;
    }
    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "setPageOwner, null url");
    AppMethodBeat.o(7751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.38
 * JD-Core Version:    0.7.0.1
 */