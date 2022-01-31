package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class n$32
  implements Runnable
{
  n$32(n paramn, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void run()
  {
    AppMethodBeat.i(7744);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7744);
      return;
    }
    if (this.vdO)
    {
      if ((((WebViewUI)n.a(this.vdr).get()).pOd != null) && (!bo.isNullOrNil(((WebViewUI)n.a(this.vdr).get()).pOd.getUrl()))) {
        ((WebViewUI)n.a(this.vdr).get()).vfk.put(((WebViewUI)n.a(this.vdr).get()).pOd.getUrl(), Boolean.FALSE);
      }
      ((WebViewUI)n.a(this.vdr).get()).or(false);
      AppMethodBeat.o(7744);
      return;
    }
    if ((((WebViewUI)n.a(this.vdr).get()).pOd != null) && (!bo.isNullOrNil(((WebViewUI)n.a(this.vdr).get()).pOd.getUrl()))) {
      ((WebViewUI)n.a(this.vdr).get()).vfk.put(((WebViewUI)n.a(this.vdr).get()).pOd.getUrl(), Boolean.valueOf(this.ixx));
    }
    ((WebViewUI)n.a(this.vdr).get()).or(this.ixx);
    AppMethodBeat.o(7744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.32
 * JD-Core Version:    0.7.0.1
 */