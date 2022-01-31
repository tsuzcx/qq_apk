package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class n$48
  implements Runnable
{
  n$48(n paramn, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(7765);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7765);
      return;
    }
    if (!((WebViewUI)n.a(this.vdr).get()).rNQ)
    {
      AppMethodBeat.o(7765);
      return;
    }
    if (this.cbK != null) {
      ((WebViewUI)n.a(this.vdr).get()).setMMTitle(this.cbK);
    }
    AppMethodBeat.o(7765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.48
 * JD-Core Version:    0.7.0.1
 */