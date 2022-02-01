package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.internal.e;
import com.tencent.xweb.n;

public final class j
  implements e
{
  c ISi;
  b ISj;
  WebView ISk;
  
  public j(WebView paramWebView)
  {
    AppMethodBeat.i(153868);
    this.ISk = paramWebView;
    this.ISi = new c();
    this.ISj = new b();
    AppMethodBeat.o(153868);
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
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(153870);
    this.ISj.fsO();
    AppMethodBeat.o(153870);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public final void z(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(153869);
    this.ISi.b(this.ISk, paramString, paramBitmap);
    AppMethodBeat.o(153869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.j
 * JD-Core Version:    0.7.0.1
 */