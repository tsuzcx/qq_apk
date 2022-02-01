package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  implements c
{
  public c IRQ;
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getAllHosts(String paramString)
  {
    AppMethodBeat.i(194245);
    if (this.IRQ != null) {
      this.IRQ._getAllHosts(paramString);
    }
    AppMethodBeat.o(194245);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _getHtmlContent(String paramString)
  {
    AppMethodBeat.i(194246);
    if (this.IRQ != null) {
      this.IRQ._getHtmlContent(paramString);
    }
    AppMethodBeat.o(194246);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _ready(boolean paramBoolean)
  {
    AppMethodBeat.i(194247);
    if (this.IRQ != null) {
      this.IRQ._ready(paramBoolean);
    }
    AppMethodBeat.o(194247);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void _sendMessage(String paramString)
  {
    AppMethodBeat.i(194244);
    if (this.IRQ != null) {
      this.IRQ._sendMessage(paramString);
    }
    AppMethodBeat.o(194244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.i
 * JD-Core Version:    0.7.0.1
 */