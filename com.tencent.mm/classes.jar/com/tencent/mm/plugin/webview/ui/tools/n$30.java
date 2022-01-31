package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import java.lang.ref.WeakReference;

final class n$30
  implements Runnable
{
  n$30(n paramn, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(7742);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7742);
      return;
    }
    ((WebViewUI)n.a(this.vdr).get()).setProgressBarIndeterminateVisibility(false);
    ab.d("MicroMsg.WebViewStubCallbackAIDLStub", "[cpan] set title pb visibility:%d", new Object[] { Integer.valueOf(this.apl) });
    if (this.apl == 0)
    {
      if ((!((WebViewUI)n.a(this.vdr).get()).vfw) && (!((WebViewUI)n.a(this.vdr).get()).vfz))
      {
        ((WebViewUI)n.a(this.vdr).get()).ved.start();
        AppMethodBeat.o(7742);
      }
    }
    else {
      ((WebViewUI)n.a(this.vdr).get()).ved.finish();
    }
    AppMethodBeat.o(7742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.30
 * JD-Core Version:    0.7.0.1
 */