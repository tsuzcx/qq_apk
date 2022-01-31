package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class WebViewUI$z
{
  final WeakReference<WebViewUI> hkv;
  final int id;
  
  public WebViewUI$z(WebViewUI paramWebViewUI)
  {
    AppMethodBeat.i(7980);
    this.hkv = new WeakReference(paramWebViewUI);
    this.id = paramWebViewUI.hashCode();
    AppMethodBeat.o(7980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.z
 * JD-Core Version:    0.7.0.1
 */