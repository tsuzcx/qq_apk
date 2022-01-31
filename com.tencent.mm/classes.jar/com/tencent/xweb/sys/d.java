package com.tencent.xweb.sys;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.xweb.e;

public final class d
  implements com.tencent.xweb.c.f
{
  WebViewClient xjL;
  WebChromeClient xjM;
  WebView xjN;
  
  public d(WebView paramWebView)
  {
    this.xjN = paramWebView;
    this.xjL = new WebViewClient();
    this.xjM = new WebChromeClient();
  }
  
  public final boolean a(String paramString1, String paramString2, com.tencent.xweb.f paramf)
  {
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, e parame)
  {
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, com.tencent.xweb.f paramf)
  {
    return false;
  }
  
  public final void onHideCustomView() {}
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public final void u(String paramString, Bitmap paramBitmap)
  {
    this.xjL.onPageStarted(this.xjN, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.sys.d
 * JD-Core Version:    0.7.0.1
 */