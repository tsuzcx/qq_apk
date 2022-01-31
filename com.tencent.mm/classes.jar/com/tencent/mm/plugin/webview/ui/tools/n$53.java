package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class n$53
  implements Runnable
{
  n$53(n paramn, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(153230);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(153230);
      return;
    }
    ((WebViewUI)n.a(this.vdr).get()).al(this.cax);
    AppMethodBeat.o(153230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.53
 * JD-Core Version:    0.7.0.1
 */