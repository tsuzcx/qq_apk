package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah
  implements c
{
  public c uJH;
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getAllHosts(String paramString)
  {
    AppMethodBeat.i(124171);
    if (this.uJH != null) {
      this.uJH._getAllHosts(paramString);
    }
    AppMethodBeat.o(124171);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getHtmlContent(String paramString)
  {
    AppMethodBeat.i(124172);
    if (this.uJH != null) {
      this.uJH._getHtmlContent(paramString);
    }
    AppMethodBeat.o(124172);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _ready(boolean paramBoolean)
  {
    AppMethodBeat.i(124173);
    if (this.uJH != null) {
      this.uJH._ready(paramBoolean);
    }
    AppMethodBeat.o(124173);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _sendMessage(String paramString)
  {
    AppMethodBeat.i(124170);
    if (this.uJH != null) {
      this.uJH._sendMessage(paramString);
    }
    AppMethodBeat.o(124170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ah
 * JD-Core Version:    0.7.0.1
 */