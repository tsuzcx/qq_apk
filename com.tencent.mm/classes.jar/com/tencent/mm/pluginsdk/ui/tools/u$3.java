package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;

final class u$3
  implements u.b
{
  u$3(WebView paramWebView) {}
  
  public final void amY(String paramString)
  {
    AppMethodBeat.i(80459);
    this.wge.evaluateJavascript(paramString, null);
    AppMethodBeat.o(80459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.u.3
 * JD-Core Version:    0.7.0.1
 */