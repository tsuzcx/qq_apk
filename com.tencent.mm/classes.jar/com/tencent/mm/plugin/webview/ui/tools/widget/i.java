package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.xweb.WebView;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.j;

public class i
  extends j
{
  private Activity bMV;
  private int roS = 0;
  
  public i(MMWebViewWithJsApi paramMMWebViewWithJsApi)
  {
    this.bMV = ((Activity)paramMMWebViewWithJsApi.getContext());
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, f paramf)
  {
    this.roS += 1;
    if (this.roS > 2) {}
    for (c localc = h.a(this.bMV, paramString2, "", this.bMV.getString(R.l.wv_close_webview), this.bMV.getString(R.l.app_ok), new i.3(this, paramf), new i.4(this, paramf), R.e.link_color); localc != null; localc = h.a(this.bMV, paramString2, "", this.bMV.getString(R.l.app_ok), new i.5(this, paramf)))
    {
      localc.setCanceledOnTouchOutside(false);
      localc.nT(false);
      return true;
    }
    return super.a(paramWebView, paramString1, paramString2, paramf);
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, e parame)
  {
    return super.a(paramWebView, paramString1, paramString2, paramString3, parame);
  }
  
  public final boolean b(WebView paramWebView, String paramString1, String paramString2, f paramf)
  {
    this.roS += 1;
    if (this.roS > 2) {}
    for (c localc = h.a(this.bMV, paramString2, "", this.bMV.getString(R.l.wv_close_webview), this.bMV.getString(R.l.app_ok), new i.6(this, paramf), new i.7(this, paramf), R.e.btn_green_color_normal); localc != null; localc = h.a(this.bMV, false, paramString2, "", this.bMV.getString(R.l.app_ok), this.bMV.getString(R.l.app_cancel), new i.8(this, paramf), new i.9(this, paramf)))
    {
      localc.setCancelable(false);
      localc.setCanceledOnTouchOutside(false);
      return true;
    }
    return super.b(paramWebView, paramString1, paramString2, paramf);
  }
  
  public void d(WebView paramWebView, String paramString)
  {
    super.d(paramWebView, paramString);
  }
  
  public void onClose()
  {
    this.bMV.finish();
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    h.a(this.bMV, false, this.bMV.getString(R.l.wv_get_location_msg, new Object[] { paramString }), this.bMV.getString(R.l.wv_get_location_title), this.bMV.getString(R.l.app_ok), this.bMV.getString(R.l.app_cancel), new i.1(this, paramCallback, paramString), new i.2(this, paramCallback, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.i
 * JD-Core Version:    0.7.0.1
 */