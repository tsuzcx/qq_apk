package com.tencent.mm.plugin.webview.f;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherJsLoader;", "", "()V", "JS_STORAGE_PATH", "", "PREFETCHER_JS_FILE_ASSETS_PATH", "TAG", "versionCode", "copyAssetFile", "assetFilePath", "destinationFilePath", "getVersion", "getWebPrefetcherJs", "getWebPrefetcherJsWithScriptTag", "inject", "", "prefetcherJsApiHandler", "Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherJsApiHandler;", "wv", "Lcom/tencent/mm/ui/widget/MMWebView;", "loadJavaScript", "", "Lcom/tencent/xweb/WebView;", "tryCopyAsset", "file", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e WPY;
  private static final String WPZ;
  
  static
  {
    AppMethodBeat.i(294610);
    WPY = new e();
    WPZ = s.X(b.bmr(), "/prefetcher_jscache/");
    AppMethodBeat.o(294610);
  }
  
  public static final void a(c paramc, MMWebView paramMMWebView)
  {
    AppMethodBeat.i(294592);
    s.u(paramc, "prefetcherJsApiHandler");
    s.u(paramMMWebView, "wv");
    try
    {
      Log.i("MicroMsg.WebPrefetcherJsLoader", "injectWebPrefetcherJsBridge");
      MMWebView localMMWebView = paramc.WDz;
      if (localMMWebView != null) {
        localMMWebView.addJavascriptInterface(paramc, "__wxPrefetcher");
      }
      paramMMWebView.evaluateJavascript("window.__wx_web_prefetcher_js_isLoaded = 'loaded';", null);
      AppMethodBeat.o(294592);
      return;
    }
    catch (Exception paramc)
    {
      Log.printErrStackTrace("MicroMsg.WebPrefetcherJsLoader", (Throwable)paramc, "injectWebPrefetcherJsBridge exception", new Object[0]);
      AppMethodBeat.o(294592);
    }
  }
  
  private static final String iwA()
  {
    AppMethodBeat.i(294604);
    Log.i("MicroMsg.WebPrefetcherJsLoader", "getWebPrefetcherJs path: %s", new Object[] { "jsapi/WebPrefetcherWebView.js" });
    try
    {
      Object localObject = org.apache.commons.b.d.toByteArray(MMApplicationContext.getContext().getAssets().open("jsapi/WebPrefetcherWebView.js"));
      s.s(localObject, "toByteArray(MMApplicatio…HER_JS_FILE_ASSETS_PATH))");
      localObject = new String((byte[])localObject, kotlin.n.d.UTF_8);
      AppMethodBeat.o(294604);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WebPrefetcherJsLoader", (Throwable)localException, "getWebPrefetcherJs exception", new Object[0]);
        String str = "";
      }
    }
  }
  
  public static final String iwz()
  {
    AppMethodBeat.i(294599);
    String str = "<script>" + iwA() + "</script>";
    AppMethodBeat.o(294599);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.e
 * JD-Core Version:    0.7.0.1
 */