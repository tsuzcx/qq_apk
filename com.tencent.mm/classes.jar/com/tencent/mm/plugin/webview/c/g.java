package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements c
{
  public c Cke;
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getAllHosts(String paramString)
  {
    AppMethodBeat.i(199199);
    if (this.Cke != null) {
      this.Cke._getAllHosts(paramString);
    }
    AppMethodBeat.o(199199);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getHtmlContent(String paramString)
  {
    AppMethodBeat.i(199200);
    if (this.Cke != null) {
      this.Cke._getHtmlContent(paramString);
    }
    AppMethodBeat.o(199200);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _ready(boolean paramBoolean)
  {
    AppMethodBeat.i(199201);
    if (this.Cke != null) {
      this.Cke._ready(paramBoolean);
    }
    AppMethodBeat.o(199201);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _sendMessage(String paramString)
  {
    AppMethodBeat.i(199198);
    if (this.Cke != null) {
      this.Cke._sendMessage(paramString);
    }
    AppMethodBeat.o(199198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.g
 * JD-Core Version:    0.7.0.1
 */