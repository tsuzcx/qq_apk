package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class n$35
  implements Runnable
{
  n$35(n paramn, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(7748);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7748);
      return;
    }
    ((WebViewUI)n.a(this.vdr).get()).KD(this.vdP);
    AppMethodBeat.o(7748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.35
 * JD-Core Version:    0.7.0.1
 */