package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class n$33
  implements Runnable
{
  n$33(n paramn, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(7746);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7746);
      return;
    }
    ((WebViewUI)n.a(this.vdr).get()).os(this.ixx);
    AppMethodBeat.o(7746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.33
 * JD-Core Version:    0.7.0.1
 */