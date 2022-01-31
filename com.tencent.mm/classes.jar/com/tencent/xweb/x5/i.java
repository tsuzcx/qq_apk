package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.e;

public final class i
  implements com.tencent.xweb.c.f
{
  c xkC;
  b xkD;
  WebView xkE;
  
  public i(WebView paramWebView)
  {
    this.xkE = paramWebView;
    this.xkC = new c();
    this.xkD = new b();
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
  
  public final void onHideCustomView()
  {
    this.xkD.cTw();
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public final void u(String paramString, Bitmap paramBitmap)
  {
    this.xkC.b(this.xkE, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.i
 * JD-Core Version:    0.7.0.1
 */