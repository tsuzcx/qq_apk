package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.q;

public final class g
  implements com.tencent.xweb.internal.f
{
  private WebView aimV;
  k aini;
  f ainj;
  
  public g(WebView paramWebView)
  {
    AppMethodBeat.i(153868);
    this.aimV = paramWebView;
    this.aini = new k();
    this.ainj = new f();
    AppMethodBeat.o(153868);
  }
  
  public final boolean a(String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, q paramq)
  {
    return false;
  }
  
  public final boolean b(String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public final boolean cxL()
  {
    return false;
  }
  
  public final boolean khc()
  {
    return false;
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(153870);
    this.ainj.kiK();
    AppMethodBeat.o(153870);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public final void y(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(153869);
    this.aini.b(this.aimV, paramString, paramBitmap);
    AppMethodBeat.o(153869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.g
 * JD-Core Version:    0.7.0.1
 */