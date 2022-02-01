package com.tencent.mm.plugin.webview.fts.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.h.37;
import com.tencent.mm.plugin.webview.d.h.50;
import com.tencent.mm.plugin.webview.d.h.51;
import com.tencent.mm.plugin.webview.d.h.53;
import com.tencent.mm.plugin.webview.d.h.54;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements n
{
  public h IBw;
  private WebView IQP;
  
  public a(WebView paramWebView)
  {
    this.IQP = paramWebView;
  }
  
  public final void aXa(String paramString)
  {
    AppMethodBeat.i(78181);
    h localh = this.IBw;
    if (!localh.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData fail, not ready");
      AppMethodBeat.o(78181);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    MMHandlerThread.postToMainThread(new h.51(localh, n.a.b("onSearchWAWidgetReloadData", localHashMap, localh.IRj, localh.zpY)));
    AppMethodBeat.o(78181);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(78177);
    ViewGroup localViewGroup = this.IQP.getTopView();
    if ((localViewGroup != null) && ((localViewGroup instanceof AbsoluteLayout)))
    {
      localViewGroup.addView(paramView);
      AppMethodBeat.o(78177);
      return;
    }
    Log.e("MicroMsg.WebSearch.WebViewWidgetWrap", "webview invalid viewgroup ".concat(String.valueOf(localViewGroup)));
    AppMethodBeat.o(78177);
  }
  
  public final void b(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78184);
    this.IBw.b(paramString1, paramBoolean, paramString2, paramString3);
    AppMethodBeat.o(78184);
  }
  
  public final void fXJ() {}
  
  public final void gd(String paramString, int paramInt)
  {
    AppMethodBeat.i(78179);
    h localh = this.IBw;
    if (!localh.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange fail, not ready");
      AppMethodBeat.o(78179);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    localHashMap.put("state", Integer.valueOf(paramInt));
    MMHandlerThread.postToMainThread(new h.53(localh, n.a.b("onSearchWAWidgetStateChange", localHashMap, localh.IRj, localh.zpY)));
    AppMethodBeat.o(78179);
  }
  
  public final void ge(String paramString, int paramInt)
  {
    AppMethodBeat.i(78185);
    h localh = this.IBw;
    if (!localh.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, not ready");
      AppMethodBeat.o(78185);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString);
    localHashMap.put("height", Integer.valueOf(paramInt));
    MMHandlerThread.postToMainThread(new h.37(localh, n.a.b("onSearchWAWidgetAttrChanged", localHashMap, localh.IRj, localh.zpY)));
    AppMethodBeat.o(78185);
  }
  
  public final void i(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(78180);
    this.IBw.b(paramString1, paramBoolean, "", paramString2);
    AppMethodBeat.o(78180);
  }
  
  public final void j(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(78183);
    h localh = this.IBw;
    if (!localh.GBl)
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
    MMHandlerThread.postToMainThread(new h.50(localh, n.a.b("onSearchWAWidgetOpenApp", localHashMap, localh.IRj, localh.zpY)));
    AppMethodBeat.o(78183);
  }
  
  public final void lH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78182);
    h localh = this.IBw;
    if (!localh.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, not ready");
      AppMethodBeat.o(78182);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("widgetId", paramString1);
    localHashMap.put("data", paramString2);
    MMHandlerThread.postToMainThread(new h.54(localh, n.a.b("onSearchWAWidgetDataPush", localHashMap, localh.IRj, localh.zpY)));
    AppMethodBeat.o(78182);
  }
  
  public final void removeView(View paramView)
  {
    AppMethodBeat.i(78178);
    ViewGroup localViewGroup = this.IQP.getTopView();
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