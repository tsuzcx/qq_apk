package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView.c;

final class PluginWebView$1
  implements WebView.c
{
  PluginWebView$1(PluginWebView paramPluginWebView) {}
  
  public final void BG()
  {
    AppMethodBeat.i(5613);
    ab.i("MPToolsMinifiedBootStep", "onCoreInitFailed");
    AppMethodBeat.o(5613);
  }
  
  public final void onCoreInitFinished()
  {
    AppMethodBeat.i(5612);
    ab.i("MPToolsMinifiedBootStep", "onCoreInitFinished");
    if (((b)g.E(b.class)).rU(20)) {
      ((b)g.E(b.class)).aWo();
    }
    AppMethodBeat.o(5612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.PluginWebView.1
 * JD-Core Version:    0.7.0.1
 */