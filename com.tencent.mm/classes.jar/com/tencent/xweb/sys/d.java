package com.tencent.xweb.sys;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.internal.e;
import com.tencent.xweb.n;

public final class d
  implements e
{
  WebViewClient IRa;
  WebChromeClient IRb;
  WebView IRc;
  
  public d(WebView paramWebView)
  {
    AppMethodBeat.i(153668);
    this.IRc = paramWebView;
    this.IRa = new WebViewClient();
    this.IRb = new WebChromeClient();
    AppMethodBeat.o(153668);
  }
  
  public final boolean a(String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, n paramn)
  {
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public final void onHideCustomView() {}
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public final void z(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(153669);
    this.IRa.onPageStarted(this.IRc, paramString, paramBitmap);
    AppMethodBeat.o(153669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.sys.d
 * JD-Core Version:    0.7.0.1
 */