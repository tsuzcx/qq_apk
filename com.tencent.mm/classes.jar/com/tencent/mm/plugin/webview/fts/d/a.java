package com.tencent.mm.plugin.webview.fts.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.35;
import com.tencent.mm.plugin.webview.c.f.43;
import com.tencent.mm.plugin.webview.c.f.45;
import com.tencent.mm.plugin.webview.c.f.47;
import com.tencent.mm.plugin.webview.c.f.48;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements n
{
  public f DRx;
  private WebView Eep;
  
  public a(WebView paramWebView)
  {
    this.Eep = paramWebView;
  }
  
  public final void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78184);
    this.DRx.a(paramString1, paramBoolean, paramString2, paramString3);
    AppMethodBeat.o(78184);
  }
  
  public final void aHf(String paramString)
  {
    AppMethodBeat.i(78181);
    f localf = this.DRx;
    if (!localf.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData fail, not ready");
      AppMethodBeat.o(78181);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    ar.f(new f.45(localf, l.a.b("onSearchWAWidgetReloadData", localHashMap, localf.EeC, localf.vVT)));
    AppMethodBeat.o(78181);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(78177);
    ViewGroup localViewGroup = this.Eep.getTopView();
    if ((localViewGroup != null) && ((localViewGroup instanceof AbsoluteLayout)))
    {
      localViewGroup.addView(paramView);
      AppMethodBeat.o(78177);
      return;
    }
    ae.e("MicroMsg.WebSearch.WebViewWidgetWrap", "webview invalid viewgroup ".concat(String.valueOf(localViewGroup)));
    AppMethodBeat.o(78177);
  }
  
  public final void ePD() {}
  
  public final void fG(String paramString, int paramInt)
  {
    AppMethodBeat.i(78179);
    f localf = this.DRx;
    if (!localf.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange fail, not ready");
      AppMethodBeat.o(78179);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    localHashMap.put("state", Integer.valueOf(paramInt));
    ar.f(new f.47(localf, l.a.b("onSearchWAWidgetStateChange", localHashMap, localf.EeC, localf.vVT)));
    AppMethodBeat.o(78179);
  }
  
  public final void fH(String paramString, int paramInt)
  {
    AppMethodBeat.i(78185);
    f localf = this.DRx;
    if (!localf.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, not ready");
      AppMethodBeat.o(78185);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    localHashMap.put("height", Integer.valueOf(paramInt));
    ar.f(new f.35(localf, l.a.b("onSearchWAWidgetAttrChanged", localHashMap, localf.EeC, localf.vVT)));
    AppMethodBeat.o(78185);
  }
  
  public final void h(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(78183);
    f localf = this.DRx;
    if (!localf.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp fail, not ready");
      AppMethodBeat.o(78183);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("path", paramString2);
    localHashMap.put("username", paramString3);
    localHashMap.put("debugMode", Integer.valueOf(paramInt));
    ar.f(new f.43(localf, l.a.b("onSearchWAWidgetOpenApp", localHashMap, localf.EeC, localf.vVT)));
    AppMethodBeat.o(78183);
  }
  
  public final void i(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(78180);
    this.DRx.a(paramString1, paramBoolean, "", paramString2);
    AppMethodBeat.o(78180);
  }
  
  public final void kL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78182);
    f localf = this.DRx;
    if (!localf.BZx)
    {
      ae.e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, not ready");
      AppMethodBeat.o(78182);
      return;
    }
    ae.i("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("data", paramString2);
    ar.f(new f.48(localf, l.a.b("onSearchWAWidgetDataPush", localHashMap, localf.EeC, localf.vVT)));
    AppMethodBeat.o(78182);
  }
  
  public final void removeView(View paramView)
  {
    AppMethodBeat.i(78178);
    ViewGroup localViewGroup = this.Eep.getTopView();
    if ((localViewGroup != null) && ((localViewGroup instanceof AbsoluteLayout))) {
      localViewGroup.removeView(paramView);
    }
    AppMethodBeat.o(78178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.d.a
 * JD-Core Version:    0.7.0.1
 */