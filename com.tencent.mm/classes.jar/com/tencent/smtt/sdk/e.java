package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

class e
{
  public static void a(Context paramContext, WebView paramWebView)
  {
    AppMethodBeat.i(193934);
    WebSettings localWebSettings = paramWebView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setAllowFileAccess(true);
    localWebSettings.setAllowFileAccessFromFileURLs(false);
    localWebSettings.setAllowUniversalAccessFromFileURLs(false);
    localWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setSupportMultipleWindows(false);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setAppCacheEnabled(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setGeolocationEnabled(true);
    localWebSettings.setAppCacheMaxSize(9223372036854775807L);
    localWebSettings.setAppCachePath(paramContext.getDir("appcache", 0).getPath());
    localWebSettings.setDatabasePath(paramContext.getDir("databases", 0).getPath());
    localWebSettings.setGeolocationDatabasePath(paramContext.getDir("geolocation", 0).getPath());
    localWebSettings.setPluginState(WebSettings.PluginState.ON_DEMAND);
    localWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    if (Build.VERSION.SDK_INT >= 11) {
      localWebSettings.setDisplayZoomControls(false);
    }
    CookieSyncManager.createInstance(paramContext);
    CookieSyncManager.getInstance().sync();
    paramWebView.setDownloadListener(new e.1(paramContext));
    AppMethodBeat.o(193934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.e
 * JD-Core Version:    0.7.0.1
 */