package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements c
{
  public c Efj;
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getAllHosts(String paramString)
  {
    AppMethodBeat.i(193465);
    if (this.Efj != null) {
      this.Efj._getAllHosts(paramString);
    }
    AppMethodBeat.o(193465);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getHtmlContent(String paramString)
  {
    AppMethodBeat.i(193466);
    if (this.Efj != null) {
      this.Efj._getHtmlContent(paramString);
    }
    AppMethodBeat.o(193466);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _ready(boolean paramBoolean)
  {
    AppMethodBeat.i(193467);
    if (this.Efj != null) {
      this.Efj._ready(paramBoolean);
    }
    AppMethodBeat.o(193467);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _sendMessage(String paramString)
  {
    AppMethodBeat.i(193464);
    if (this.Efj != null) {
      this.Efj._sendMessage(paramString);
    }
    AppMethodBeat.o(193464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.g
 * JD-Core Version:    0.7.0.1
 */