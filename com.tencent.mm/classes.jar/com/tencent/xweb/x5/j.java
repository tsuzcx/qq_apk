package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.internal.e;
import com.tencent.xweb.o;

public final class j
  implements e
{
  c MSj;
  b MSk;
  WebView MSl;
  
  public j(WebView paramWebView)
  {
    AppMethodBeat.i(153868);
    this.MSl = paramWebView;
    this.MSj = new c();
    this.MSk = new b();
    AppMethodBeat.o(153868);
  }
  
  public final boolean a(String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, o paramo)
  {
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(153870);
    this.MSk.gho();
    AppMethodBeat.o(153870);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public final void y(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(153869);
    this.MSj.b(this.MSl, paramString, paramBitmap);
    AppMethodBeat.o(153869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.j
 * JD-Core Version:    0.7.0.1
 */