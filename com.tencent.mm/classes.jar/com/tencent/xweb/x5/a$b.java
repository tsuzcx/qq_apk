package com.tencent.xweb.x5;

import android.webkit.WebView.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;

public final class a$b
  implements IX5WebViewBase.FindListener
{
  WebView.FindListener xkj;
  
  public a$b(WebView.FindListener paramFindListener)
  {
    this.xkj = paramFindListener;
  }
  
  public final void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.xkj != null) {
      this.xkj.onFindResultReceived(paramInt1, paramInt2, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.a.b
 * JD-Core Version:    0.7.0.1
 */