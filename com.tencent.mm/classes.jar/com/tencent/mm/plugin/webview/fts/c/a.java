package com.tencent.mm.plugin.webview.fts.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.j.38;
import com.tencent.mm.plugin.webview.jsapi.j.51;
import com.tencent.mm.plugin.webview.jsapi.j.52;
import com.tencent.mm.plugin.webview.jsapi.j.54;
import com.tencent.mm.plugin.webview.jsapi.j.56;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements n
{
  private WebView WDl;
  public j WlX;
  
  public a(WebView paramWebView)
  {
    this.WDl = paramWebView;
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(78177);
    ViewGroup localViewGroup = this.WDl.getTopView();
    if ((localViewGroup != null) && ((localViewGroup instanceof AbsoluteLayout)))
    {
      localViewGroup.addView(paramView);
      AppMethodBeat.o(78177);
      return;
    }
    Log.e("MicroMsg.WebSearch.WebViewWidgetWrap", "webview invalid viewgroup ".concat(String.valueOf(localViewGroup)));
    AppMethodBeat.o(78177);
  }
  
  public final void bit(String paramString)
  {
    AppMethodBeat.i(78181);
    j localj = this.WlX;
    if (!localj.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData fail, not ready");
      AppMethodBeat.o(78181);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    MMHandlerThread.postToMainThread(new j.52(localj, p.a.b("onSearchWAWidgetReloadData", localHashMap, localj.WDI, localj.KQY)));
    AppMethodBeat.o(78181);
  }
  
  public final void c(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78184);
    this.WlX.c(paramString1, paramBoolean, paramString2, paramString3);
    AppMethodBeat.o(78184);
  }
  
  public final void hL(String paramString, int paramInt)
  {
    AppMethodBeat.i(78179);
    j localj = this.WlX;
    if (!localj.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange fail, not ready");
      AppMethodBeat.o(78179);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    localHashMap.put("state", Integer.valueOf(paramInt));
    MMHandlerThread.postToMainThread(new j.54(localj, p.a.b("onSearchWAWidgetStateChange", localHashMap, localj.WDI, localj.KQY)));
    AppMethodBeat.o(78179);
  }
  
  public final void hM(String paramString, int paramInt)
  {
    AppMethodBeat.i(78185);
    j localj = this.WlX;
    if (!localj.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, not ready");
      AppMethodBeat.o(78185);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    localHashMap.put("height", Integer.valueOf(paramInt));
    MMHandlerThread.postToMainThread(new j.38(localj, p.a.b("onSearchWAWidgetAttrChanged", localHashMap, localj.WDI, localj.KQY)));
    AppMethodBeat.o(78185);
  }
  
  public final void ipL() {}
  
  public final void l(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(78183);
    j localj = this.WlX;
    if (!localj.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp fail, not ready");
      AppMethodBeat.o(78183);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("path", paramString2);
    localHashMap.put("username", paramString3);
    localHashMap.put("debugMode", Integer.valueOf(paramInt));
    MMHandlerThread.postToMainThread(new j.51(localj, p.a.b("onSearchWAWidgetOpenApp", localHashMap, localj.WDI, localj.KQY)));
    AppMethodBeat.o(78183);
  }
  
  public final void l(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(78180);
    this.WlX.c(paramString1, paramBoolean, "", paramString2);
    AppMethodBeat.o(78180);
  }
  
  public final void nS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78182);
    j localj = this.WlX;
    if (!localj.UcS)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, not ready");
      AppMethodBeat.o(78182);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("data", paramString2);
    MMHandlerThread.postToMainThread(new j.56(localj, p.a.b("onSearchWAWidgetDataPush", localHashMap, localj.WDI, localj.KQY)));
    AppMethodBeat.o(78182);
  }
  
  public final void removeView(View paramView)
  {
    AppMethodBeat.i(78178);
    ViewGroup localViewGroup = this.WDl.getTopView();
    if ((localViewGroup != null) && ((localViewGroup instanceof AbsoluteLayout))) {
      localViewGroup.removeView(paramView);
    }
    AppMethodBeat.o(78178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.a
 * JD-Core Version:    0.7.0.1
 */