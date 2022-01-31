package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class n$47
  implements Runnable
{
  n$47(n paramn, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(7764);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7764);
      return;
    }
    ((WebViewUI)n.a(this.vdr).get()).dS(this.vdR, this.vdS);
    AppMethodBeat.o(7764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.47
 * JD-Core Version:    0.7.0.1
 */