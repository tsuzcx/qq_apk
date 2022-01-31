package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.c.f;
import com.tencent.xweb.j;

public final class i
  implements f
{
  c BIg;
  b BIh;
  WebView BIi;
  
  public i(WebView paramWebView)
  {
    AppMethodBeat.i(84853);
    this.BIi = paramWebView;
    this.BIg = new c();
    this.BIh = new b();
    AppMethodBeat.o(84853);
  }
  
  public final boolean a(String paramString1, String paramString2, j paramj)
  {
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, com.tencent.xweb.i parami)
  {
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, j paramj)
  {
    return false;
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(84855);
    this.BIh.dZW();
    AppMethodBeat.o(84855);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public final void w(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(84854);
    this.BIg.b(this.BIi, paramString, paramBitmap);
    AppMethodBeat.o(84854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.i
 * JD-Core Version:    0.7.0.1
 */