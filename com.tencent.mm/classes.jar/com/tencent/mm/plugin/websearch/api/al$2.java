package com.tencent.mm.plugin.websearch.api;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

final class al$2
  extends p
{
  al$2(al paramal, MMWebView paramMMWebView) {}
  
  public final void a(WebView paramWebView, String paramString)
  {
    y.i(this.qUL.TAG, "onPageFinished, view %s", new Object[] { paramWebView.toString() });
    this.qUL.b(this.qUM);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.b(paramWebView, paramString, paramBitmap);
    y.i(this.qUL.TAG, "onPageStarted, view %s", new Object[] { paramWebView.toString() });
    aj.a(this.qUM);
  }
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    if (!aj.n(paramString, "weixin://private/setresult/")) {
      return false;
    }
    y.i(this.qUL.TAG, "handleUrl %s ,view %s", new Object[] { paramString, paramWebView.toString() });
    this.qUM.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.al.2
 * JD-Core Version:    0.7.0.1
 */