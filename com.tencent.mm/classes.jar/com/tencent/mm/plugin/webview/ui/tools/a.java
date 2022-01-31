package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class a
{
  private final WeakReference<WebViewUI> uZU;
  
  public a(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(7340);
    this.uZU = new WeakReference(paramWebViewUI);
    AppMethodBeat.o(7340);
  }
  
  public final boolean dds()
  {
    AppMethodBeat.i(7341);
    if ((ddt() == null) || (ddt().isFinishing()))
    {
      AppMethodBeat.o(7341);
      return true;
    }
    AppMethodBeat.o(7341);
    return false;
  }
  
  public final WebViewUI ddt()
  {
    AppMethodBeat.i(7342);
    WebViewUI localWebViewUI = (WebViewUI)this.uZU.get();
    AppMethodBeat.o(7342);
    return localWebViewUI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.a
 * JD-Core Version:    0.7.0.1
 */