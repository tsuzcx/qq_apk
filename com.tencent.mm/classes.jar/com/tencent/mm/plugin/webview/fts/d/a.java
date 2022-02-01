package com.tencent.mm.plugin.webview.fts.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.34;
import com.tencent.mm.plugin.webview.c.f.41;
import com.tencent.mm.plugin.webview.c.f.42;
import com.tencent.mm.plugin.webview.c.f.45;
import com.tencent.mm.plugin.webview.c.f.46;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements n
{
  public f AQP;
  private WebView AQY;
  
  public a(WebView paramWebView)
  {
    this.AQY = paramWebView;
  }
  
  public final void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78184);
    this.AQP.a(paramString1, paramBoolean, paramString2, paramString3);
    AppMethodBeat.o(78184);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(78177);
    ViewGroup localViewGroup = this.AQY.getTopView();
    if ((localViewGroup != null) && ((localViewGroup instanceof AbsoluteLayout)))
    {
      localViewGroup.addView(paramView);
      AppMethodBeat.o(78177);
      return;
    }
    ad.e("MicroMsg.WebSearch.WebViewWidgetWrap", "webview invalid viewgroup ".concat(String.valueOf(localViewGroup)));
    AppMethodBeat.o(78177);
  }
  
  public final void ava(String paramString)
  {
    AppMethodBeat.i(78181);
    f localf = this.AQP;
    if (!localf.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData fail, not ready");
      AppMethodBeat.o(78181);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    aq.f(new f.42(localf, l.a.b("onSearchWAWidgetReloadData", localHashMap, localf.ARm, localf.ARn)));
    AppMethodBeat.o(78181);
  }
  
  public final void eQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(78179);
    f localf = this.AQP;
    if (!localf.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange fail, not ready");
      AppMethodBeat.o(78179);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    localHashMap.put("state", Integer.valueOf(paramInt));
    aq.f(new f.45(localf, l.a.b("onSearchWAWidgetStateChange", localHashMap, localf.ARm, localf.ARn)));
    AppMethodBeat.o(78179);
  }
  
  public final void eR(String paramString, int paramInt)
  {
    AppMethodBeat.i(78185);
    f localf = this.AQP;
    if (!localf.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, not ready");
      AppMethodBeat.o(78185);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    localHashMap.put("height", Integer.valueOf(paramInt));
    aq.f(new f.34(localf, l.a.b("onSearchWAWidgetAttrChanged", localHashMap, localf.ARm, localf.ARn)));
    AppMethodBeat.o(78185);
  }
  
  public final void ehM() {}
  
  public final void h(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(78183);
    f localf = this.AQP;
    if (!localf.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp fail, not ready");
      AppMethodBeat.o(78183);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("path", paramString2);
    localHashMap.put("username", paramString3);
    localHashMap.put("debugMode", Integer.valueOf(paramInt));
    aq.f(new f.41(localf, l.a.b("onSearchWAWidgetOpenApp", localHashMap, localf.ARm, localf.ARn)));
    AppMethodBeat.o(78183);
  }
  
  public final void i(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(78180);
    this.AQP.a(paramString1, paramBoolean, "", paramString2);
    AppMethodBeat.o(78180);
  }
  
  public final void jK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78182);
    f localf = this.AQP;
    if (!localf.yZR)
    {
      ad.e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, not ready");
      AppMethodBeat.o(78182);
      return;
    }
    ad.i("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("data", paramString2);
    aq.f(new f.46(localf, l.a.b("onSearchWAWidgetDataPush", localHashMap, localf.ARm, localf.ARn)));
    AppMethodBeat.o(78182);
  }
  
  public final void removeView(View paramView)
  {
    AppMethodBeat.i(78178);
    ViewGroup localViewGroup = this.AQY.getTopView();
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