package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;

final class u$1
  implements u.b
{
  u$1(WebView paramWebView) {}
  
  public final void amY(String paramString)
  {
    AppMethodBeat.i(80457);
    this.wge.evaluateJavascript(paramString, null);
    AppMethodBeat.o(80457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.u.1
 * JD-Core Version:    0.7.0.1
 */