package com.tencent.xweb.sys;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.f;
import com.tencent.xweb.i;
import com.tencent.xweb.j;

public final class d
  implements f
{
  WebViewClient BHp;
  WebChromeClient BHq;
  WebView BHr;
  
  public d(WebView paramWebView)
  {
    AppMethodBeat.i(84660);
    this.BHr = paramWebView;
    this.BHp = new WebViewClient();
    this.BHq = new WebChromeClient();
    AppMethodBeat.o(84660);
  }
  
  public final boolean a(String paramString1, String paramString2, j paramj)
  {
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, i parami)
  {
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, j paramj)
  {
    return false;
  }
  
  public final void onHideCustomView() {}
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public final void w(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(84661);
    this.BHp.onPageStarted(this.BHr, paramString, paramBitmap);
    AppMethodBeat.o(84661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.sys.d
 * JD-Core Version:    0.7.0.1
 */