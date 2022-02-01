package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements c
{
  public c DNk;
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getAllHosts(String paramString)
  {
    AppMethodBeat.i(190872);
    if (this.DNk != null) {
      this.DNk._getAllHosts(paramString);
    }
    AppMethodBeat.o(190872);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getHtmlContent(String paramString)
  {
    AppMethodBeat.i(190873);
    if (this.DNk != null) {
      this.DNk._getHtmlContent(paramString);
    }
    AppMethodBeat.o(190873);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _ready(boolean paramBoolean)
  {
    AppMethodBeat.i(190874);
    if (this.DNk != null) {
      this.DNk._ready(paramBoolean);
    }
    AppMethodBeat.o(190874);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _sendMessage(String paramString)
  {
    AppMethodBeat.i(190871);
    if (this.DNk != null) {
      this.DNk._sendMessage(paramString);
    }
    AppMethodBeat.o(190871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.g
 * JD-Core Version:    0.7.0.1
 */