package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

final class k$1$1
  implements Runnable
{
  k$1$1(k.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(7026);
    try
    {
      this.uYv.uYu.destroy();
      AppMethodBeat.o(7026);
      return;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.WebViewReportOnLeaveHelper", "reportOnLeave, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(7026);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.k.1.1
 * JD-Core Version:    0.7.0.1
 */