package com.tencent.mm.plugin.webview.fts.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.32;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.40;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.41;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.43;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.45;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements r
{
  public d rbk;
  private WebView rbt;
  
  public a(WebView paramWebView)
  {
    this.rbt = paramWebView;
  }
  
  public final void Rr(String paramString)
  {
    d locald = this.rbk;
    if (!locald.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    ai.d(new d.41(locald, i.a.a("onSearchWAWidgetReloadData", localHashMap, locald.rxI, locald.rxJ)));
  }
  
  public final void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    this.rbk.a(paramString1, paramBoolean, paramString2, paramString3);
  }
  
  public final void addView(View paramView)
  {
    ViewGroup localViewGroup = this.rbt.getTopView();
    if ((localViewGroup != null) && ((localViewGroup instanceof AbsoluteLayout)))
    {
      localViewGroup.addView(paramView);
      return;
    }
    y.e("WebViewWidgetWrap", "webview invalid viewgroup " + localViewGroup);
  }
  
  public final void bZn() {}
  
  public final void cJ(String paramString, int paramInt)
  {
    d locald = this.rbk;
    if (!locald.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    localHashMap.put("state", Integer.valueOf(paramInt));
    ai.d(new d.43(locald, i.a.a("onSearchWAWidgetStateChange", localHashMap, locald.rxI, locald.rxJ)));
  }
  
  public final void cK(String paramString, int paramInt)
  {
    d locald = this.rbk;
    if (!locald.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    localHashMap.put("height", Integer.valueOf(paramInt));
    ai.d(new d.32(locald, i.a.a("onSearchWAWidgetAttrChanged", localHashMap, locald.rxI, locald.rxJ)));
  }
  
  public final void e(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.rbk.a(paramString1, paramBoolean, "", paramString2);
  }
  
  public final void fo(String paramString1, String paramString2)
  {
    d locald = this.rbk;
    if (!locald.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("data", paramString2);
    ai.d(new d.45(locald, i.a.a("onSearchWAWidgetDataPush", localHashMap, locald.rxI, locald.rxJ)));
  }
  
  public final void g(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    d locald = this.rbk;
    if (!locald.ready)
    {
      y.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp fail, not ready");
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("path", paramString2);
    localHashMap.put("username", paramString3);
    localHashMap.put("debugMode", Integer.valueOf(paramInt));
    ai.d(new d.40(locald, i.a.a("onSearchWAWidgetOpenApp", localHashMap, locald.rxI, locald.rxJ)));
  }
  
  public final void removeView(View paramView)
  {
    ViewGroup localViewGroup = this.rbt.getTopView();
    if ((localViewGroup != null) && ((localViewGroup instanceof AbsoluteLayout))) {
      localViewGroup.removeView(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.d.a
 * JD-Core Version:    0.7.0.1
 */