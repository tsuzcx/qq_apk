package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class a
{
  WeakReference<WebViewUI> Jbp;
  
  public a(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(79534);
    this.Jbp = new WeakReference(paramWebViewUI);
    AppMethodBeat.o(79534);
  }
  
  public final boolean gcd()
  {
    AppMethodBeat.i(79535);
    if ((geo() == null) || (geo().isFinishing()))
    {
      AppMethodBeat.o(79535);
      return true;
    }
    AppMethodBeat.o(79535);
    return false;
  }
  
  public final WebViewUI geo()
  {
    AppMethodBeat.i(79536);
    WebViewUI localWebViewUI = (WebViewUI)this.Jbp.get();
    AppMethodBeat.o(79536);
    return localWebViewUI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.a
 * JD-Core Version:    0.7.0.1
 */