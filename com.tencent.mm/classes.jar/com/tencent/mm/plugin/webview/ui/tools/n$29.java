package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.c;
import java.lang.ref.WeakReference;

final class n$29
  implements Runnable
{
  n$29(n paramn, c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(7741);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7741);
      return;
    }
    ((WebViewUI)n.a(this.vdr).get()).b(this.vdN);
    AppMethodBeat.o(7741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.29
 * JD-Core Version:    0.7.0.1
 */