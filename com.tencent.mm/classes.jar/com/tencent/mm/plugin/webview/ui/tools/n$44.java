package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class n$44
  implements Runnable
{
  n$44(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(7757);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7757);
      return;
    }
    ((WebViewUI)n.a(this.vdr).get()).vgh.startLoading();
    AppMethodBeat.o(7757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.44
 * JD-Core Version:    0.7.0.1
 */