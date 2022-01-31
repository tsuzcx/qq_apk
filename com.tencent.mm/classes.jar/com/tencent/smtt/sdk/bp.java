package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;

class bp
  extends X5ProxyWebViewClientExtension
{
  bp(WebView paramWebView, IX5WebViewClientExtension paramIX5WebViewClientExtension)
  {
    super(paramIX5WebViewClientExtension);
  }
  
  public void invalidate() {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(139424);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    WebView.a(this.a, paramInt3, paramInt4, paramInt1, paramInt2);
    AppMethodBeat.o(139424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.bp
 * JD-Core Version:    0.7.0.1
 */