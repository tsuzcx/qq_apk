package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class n$52
  implements Runnable
{
  n$52(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(7769);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7769);
      return;
    }
    ((WebViewUI)n.a(this.vdr).get()).vfo = null;
    AppMethodBeat.o(7769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.52
 * JD-Core Version:    0.7.0.1
 */