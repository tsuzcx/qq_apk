package com.tencent.mm.plugin.webview.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements c
{
  public c ARR;
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getAllHosts(String paramString)
  {
    AppMethodBeat.i(187215);
    if (this.ARR != null) {
      this.ARR._getAllHosts(paramString);
    }
    AppMethodBeat.o(187215);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getHtmlContent(String paramString)
  {
    AppMethodBeat.i(187216);
    if (this.ARR != null) {
      this.ARR._getHtmlContent(paramString);
    }
    AppMethodBeat.o(187216);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _ready(boolean paramBoolean)
  {
    AppMethodBeat.i(187217);
    if (this.ARR != null) {
      this.ARR._ready(paramBoolean);
    }
    AppMethodBeat.o(187217);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _sendMessage(String paramString)
  {
    AppMethodBeat.i(187214);
    if (this.ARR != null) {
      this.ARR._sendMessage(paramString);
    }
    AppMethodBeat.o(187214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.g
 * JD-Core Version:    0.7.0.1
 */