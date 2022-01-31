package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import java.lang.ref.WeakReference;

final class n$31
  implements Runnable
{
  n$31(n paramn, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(7743);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7743);
      return;
    }
    ((WebViewUI)n.a(this.vdr).get()).uQS.a(this.uZm, this.uZn, i.az(this.uZo), this.uZp);
    AppMethodBeat.o(7743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.31
 * JD-Core Version:    0.7.0.1
 */