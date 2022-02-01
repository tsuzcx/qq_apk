package com.tencent.xweb.x5;

import android.webkit.WebView.FindListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;

public final class a$b
  implements IX5WebViewBase.FindListener
{
  WebView.FindListener IRN;
  
  public a$b(WebView.FindListener paramFindListener)
  {
    this.IRN = paramFindListener;
  }
  
  public final void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(153813);
    if (this.IRN != null) {
      this.IRN.onFindResultReceived(paramInt1, paramInt2, paramBoolean);
    }
    AppMethodBeat.o(153813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.a.b
 * JD-Core Version:    0.7.0.1
 */