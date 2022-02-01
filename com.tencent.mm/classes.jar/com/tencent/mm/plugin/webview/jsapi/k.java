package com.tencent.mm.plugin.webview.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  implements d
{
  public d WEs;
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getAllHosts(String paramString)
  {
    AppMethodBeat.i(295241);
    if (this.WEs != null) {
      this.WEs._getAllHosts(paramString);
    }
    AppMethodBeat.o(295241);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getHtmlContent(String paramString)
  {
    AppMethodBeat.i(295244);
    if (this.WEs != null) {
      this.WEs._getHtmlContent(paramString);
    }
    AppMethodBeat.o(295244);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _ready(boolean paramBoolean)
  {
    AppMethodBeat.i(295253);
    if (this.WEs != null) {
      this.WEs._ready(paramBoolean);
    }
    AppMethodBeat.o(295253);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _sendMessage(String paramString)
  {
    AppMethodBeat.i(295235);
    if (this.WEs != null) {
      this.WEs._sendMessage(paramString);
    }
    AppMethodBeat.o(295235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.k
 * JD-Core Version:    0.7.0.1
 */