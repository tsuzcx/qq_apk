package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class n$43
  implements Runnable
{
  n$43(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(7756);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7756);
      return;
    }
    ((WebViewUI)n.a(this.vdr).get()).vgh.ddX();
    AppMethodBeat.o(7756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.43
 * JD-Core Version:    0.7.0.1
 */