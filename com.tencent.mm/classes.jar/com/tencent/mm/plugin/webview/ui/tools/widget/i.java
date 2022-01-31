package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import com.tencent.xweb.p;

public class i
  extends p
{
  private Activity cup;
  private int vfE;
  
  public i(MMWebViewWithJsApi paramMMWebViewWithJsApi)
  {
    AppMethodBeat.i(9912);
    this.vfE = 0;
    this.cup = ((Activity)paramMMWebViewWithJsApi.getContext());
    AppMethodBeat.o(9912);
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, j paramj)
  {
    AppMethodBeat.i(9915);
    this.vfE += 1;
    if (this.vfE > 2) {}
    for (c localc = h.a(this.cup, paramString2, "", this.cup.getString(2131306013), this.cup.getString(2131297018), new i.3(this, paramj), new i.4(this, paramj), 2131690214); localc != null; localc = h.a(this.cup, paramString2, "", this.cup.getString(2131297018), new i.5(this, paramj)))
    {
      localc.setCanceledOnTouchOutside(false);
      localc.rD(false);
      AppMethodBeat.o(9915);
      return true;
    }
    boolean bool = super.a(paramWebView, paramString1, paramString2, paramj);
    AppMethodBeat.o(9915);
    return bool;
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, com.tencent.xweb.i parami)
  {
    AppMethodBeat.i(9917);
    boolean bool = super.a(paramWebView, paramString1, paramString2, paramString3, parami);
    AppMethodBeat.o(9917);
    return bool;
  }
  
  public final boolean b(WebView paramWebView, String paramString1, String paramString2, j paramj)
  {
    AppMethodBeat.i(9916);
    this.vfE += 1;
    if (this.vfE > 2) {}
    for (c localc = h.a(this.cup, paramString2, "", this.cup.getString(2131306013), this.cup.getString(2131297018), new i.6(this, paramj), new i.7(this, paramj), 2131689794); localc != null; localc = h.a(this.cup, false, paramString2, "", this.cup.getString(2131297018), this.cup.getString(2131296888), new i.8(this, paramj), new i.9(this, paramj)))
    {
      localc.setCancelable(false);
      localc.setCanceledOnTouchOutside(false);
      AppMethodBeat.o(9916);
      return true;
    }
    boolean bool = super.b(paramWebView, paramString1, paramString2, paramj);
    AppMethodBeat.o(9916);
    return bool;
  }
  
  public void d(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(9913);
    super.d(paramWebView, paramString);
    AppMethodBeat.o(9913);
  }
  
  protected void onClose()
  {
    AppMethodBeat.i(9918);
    this.cup.finish();
    AppMethodBeat.o(9918);
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    AppMethodBeat.i(9914);
    h.a(this.cup, false, this.cup.getString(2131306020, new Object[] { paramString }), this.cup.getString(2131306021), this.cup.getString(2131297018), this.cup.getString(2131296888), new i.1(this, paramCallback, paramString), new i.2(this, paramCallback, paramString));
    AppMethodBeat.o(9914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.i
 * JD-Core Version:    0.7.0.1
 */