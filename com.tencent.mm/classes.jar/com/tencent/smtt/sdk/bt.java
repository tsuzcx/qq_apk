package com.tencent.smtt.sdk;

import android.webkit.WebView.FindListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;

class bt
  implements WebView.FindListener
{
  bt(WebView paramWebView, IX5WebViewBase.FindListener paramFindListener) {}
  
  public void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(139428);
    this.a.onFindResultReceived(paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(139428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.bt
 * JD-Core Version:    0.7.0.1
 */