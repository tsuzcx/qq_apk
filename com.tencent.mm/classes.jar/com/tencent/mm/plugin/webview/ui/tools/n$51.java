package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;
import java.lang.ref.WeakReference;

final class n$51
  implements Runnable
{
  n$51(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(7768);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7768);
      return;
    }
    if ((((WebViewUI)n.a(this.vdr).get()).vfp != null) && (((WebViewUI)n.a(this.vdr).get()).vfp.isShowing())) {
      ((WebViewUI)n.a(this.vdr).get()).vfp.dismiss();
    }
    AppMethodBeat.o(7768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.51
 * JD-Core Version:    0.7.0.1
 */