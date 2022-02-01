package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  implements c
{
  public c POg;
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getAllHosts(String paramString)
  {
    AppMethodBeat.i(190288);
    if (this.POg != null) {
      this.POg._getAllHosts(paramString);
    }
    AppMethodBeat.o(190288);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getHtmlContent(String paramString)
  {
    AppMethodBeat.i(190295);
    if (this.POg != null) {
      this.POg._getHtmlContent(paramString);
    }
    AppMethodBeat.o(190295);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _ready(boolean paramBoolean)
  {
    AppMethodBeat.i(190299);
    if (this.POg != null) {
      this.POg._ready(paramBoolean);
    }
    AppMethodBeat.o(190299);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _sendMessage(String paramString)
  {
    AppMethodBeat.i(190286);
    if (this.POg != null) {
      this.POg._sendMessage(paramString);
    }
    AppMethodBeat.o(190286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.i
 * JD-Core Version:    0.7.0.1
 */