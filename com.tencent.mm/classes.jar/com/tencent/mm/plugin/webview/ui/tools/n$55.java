package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

final class n$55
  implements Runnable
{
  n$55(n paramn, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(154910);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(154910);
      return;
    }
    if (!bo.isNullOrNil(this.val$url))
    {
      if (!bo.isNullOrNil(this.vdV)) {
        n.b(this.vdr).putExtra("view_port_code", this.vdV);
      }
      ((WebViewUI)n.a(this.vdr).get()).loadUrl(this.val$url);
    }
    AppMethodBeat.o(154910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.55
 * JD-Core Version:    0.7.0.1
 */