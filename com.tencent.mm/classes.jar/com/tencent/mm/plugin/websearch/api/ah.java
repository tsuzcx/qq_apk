package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.c;
import com.tencent.xweb.y;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ah
  implements h
{
  int AGW;
  boolean AGX;
  private List<ai> AGY;
  long AGZ;
  String TAG;
  private boolean mnE;
  
  public ah(int paramInt)
  {
    AppMethodBeat.i(117750);
    this.TAG = "MicroMsg.WebSearch.WebSearchPreloadMgr";
    this.mnE = false;
    this.AGY = new LinkedList();
    this.AGW = paramInt;
    this.TAG = (this.TAG + "_" + paramInt);
    AppMethodBeat.o(117750);
  }
  
  private MMWebView bEY()
  {
    AppMethodBeat.i(117753);
    try
    {
      Object localObject = new MutableContextWrapper(aj.getContext());
      if (this.AGW == 2)
      {
        localObject = MMWebView.a.kk((Context)localObject);
        AppMethodBeat.o(117753);
        return localObject;
      }
      an.eir();
      localObject = MMWebView.a.kk((Context)localObject);
      AppMethodBeat.o(117753);
      return localObject;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, localException, "", new Object[0]);
      AppMethodBeat.o(117753);
    }
    return null;
  }
  
  public final void bY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(184557);
    if (!aj.eFK())
    {
      ad.w(this.TAG, "preload please call from toolsmp proc");
      AppMethodBeat.o(184557);
      return;
    }
    if (!aq.isMainThread())
    {
      ad.w(this.TAG, "preload please call from main thread");
      AppMethodBeat.o(184557);
      return;
    }
    if (paramBoolean)
    {
      this.mnE = false;
      this.AGY.clear();
    }
    if (this.mnE)
    {
      ad.i(this.TAG, "preloading webview %s", new Object[] { Integer.valueOf(this.AGW) });
      AppMethodBeat.o(184557);
      return;
    }
    this.mnE = true;
    ad.i(this.TAG, "preLoadWebView cached webview size %d preloadBiz %d", new Object[] { Integer.valueOf(this.AGY.size()), Integer.valueOf(this.AGW) });
    final MMWebView localMMWebView;
    if (this.AGY.size() <= 0)
    {
      this.AGZ = System.currentTimeMillis();
      localMMWebView = bEY();
      if (localMMWebView != null) {
        break label206;
      }
      ad.w(this.TAG, "create webview fail preloadBiz:%s", new Object[] { Integer.valueOf(this.AGW) });
    }
    for (;;)
    {
      this.mnE = false;
      AppMethodBeat.o(184557);
      return;
      label206:
      this.AGX = false;
      ad.i(this.TAG, "preload %s", new Object[] { localMMWebView.toString() });
      localMMWebView.setPreload(true);
      localMMWebView.setRandomStr(bt.Wl(16));
      localMMWebView.getSettings().setJavaScriptEnabled(true);
      localMMWebView.getSettings().setPluginsEnabled(true);
      localMMWebView.getSettings().frg();
      localMMWebView.getSettings().setBuiltInZoomControls(false);
      localMMWebView.getSettings().setUseWideViewPort(true);
      localMMWebView.getSettings().setLoadWithOverviewMode(true);
      localMMWebView.getSettings().fqZ();
      localMMWebView.getSettings().fqY();
      localMMWebView.getSettings().setGeolocationEnabled(true);
      localMMWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
      localMMWebView.getSettings().fri();
      localMMWebView.getSettings().fre();
      localMMWebView.getSettings().setAppCachePath(localMMWebView.getContext().getDir("webviewcache", 0).getAbsolutePath());
      localMMWebView.getSettings().frd();
      localMMWebView.getSettings().frf();
      localMMWebView.getSettings().setDatabasePath(b.ahY() + "databases/");
      c.fqC().fqD();
      c.fqC().e(localMMWebView);
      Object localObject = x.bR(localMMWebView.getContext(), localMMWebView.getSettings().getUserAgentString());
      localMMWebView.getSettings().setUserAgentString((String)localObject);
      localObject = new g();
      localMMWebView.addJavascriptInterface(localObject, "__wx");
      localMMWebView.loadUrl(paramString);
      localMMWebView.setWebViewClient(new ab()
      {
        public final boolean a(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          AppMethodBeat.i(190957);
          if (!x.A(paramAnonymousString, "weixin://private/setresult/"))
          {
            AppMethodBeat.o(190957);
            return false;
          }
          ad.i(ah.this.TAG, "handleUrl %s ,view %s", new Object[] { paramAnonymousString, paramAnonymousWebView.toString() });
          localMMWebView.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
          AppMethodBeat.o(190957);
          return true;
        }
        
        public final void b(WebView paramAnonymousWebView, String paramAnonymousString)
        {
          AppMethodBeat.i(190955);
          ad.i(ah.this.TAG, "onPageFinished, view %s", new Object[] { paramAnonymousWebView.toString() });
          ah.this.d(localMMWebView);
          AppMethodBeat.o(190955);
        }
        
        public final void b(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(190956);
          super.b(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
          ad.i(ah.this.TAG, "onPageStarted, view %s", new Object[] { paramAnonymousWebView.toString() });
          x.c(localMMWebView);
          AppMethodBeat.o(190956);
        }
      });
      paramString = Uri.parse(paramString);
      paramString = new ai(localMMWebView, paramString.getQueryParameter("sessionId"), paramString.getQueryParameter("subSessionId"), (g)localObject);
      this.AGY.add(paramString);
      ad.i(this.TAG, "prelaod cacheWebView size %d", new Object[] { Integer.valueOf(this.AGY.size()) });
      com.tencent.mm.plugin.report.service.h.vKh.f(15005, new Object[] { Integer.valueOf(this.AGW), Integer.valueOf(1), Integer.valueOf(0) });
    }
  }
  
  final boolean d(final MMWebView paramMMWebView)
  {
    AppMethodBeat.i(117752);
    ad.i(this.TAG, "begin jsapi init,wv %s", new Object[] { paramMMWebView.toString() });
    try
    {
      String str = bt.convertStreamToString(paramMMWebView.getContext().getAssets().open("jsapi/wxjs.js"));
      if (str == null)
      {
        ad.e(this.TAG, "loadJavaScript fail, jsContent is null");
        AppMethodBeat.o(117752);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace(this.TAG, localException, "", new Object[0]);
        localObject = null;
      }
      if (paramMMWebView == null)
      {
        ad.e(this.TAG, "loadJavaScript, viewWV is null");
        AppMethodBeat.o(117752);
        return false;
      }
      paramMMWebView.evaluateJavascript("javascript:".concat(String.valueOf(localObject)), new ValueCallback() {});
      Object localObject = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      HashMap localHashMap = new HashMap();
      localHashMap.put("webview_type", "1");
      localHashMap.put("init_url", paramMMWebView.getUrl());
      localHashMap.put("init_font_size", "1");
      paramMMWebView.getRandomStr();
      paramMMWebView.evaluateJavascript(a.g("event", "sys:init", localHashMap) + ")", new ValueCallback() {});
      localObject = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      paramMMWebView.getRandomStr();
      paramMMWebView.evaluateJavascript(a.g("event", "sys:bridged", null) + ")", new ValueCallback() {});
      localObject = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      localHashMap = new HashMap();
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add("menu:share:timeline");
      localLinkedList.add("menu:share:appmessage");
      localLinkedList.add("menu:share:weiboApp");
      localLinkedList.add("menu:share:QZone");
      localLinkedList.add("menu:share:qq");
      localLinkedList.add("onVoiceRecordEnd");
      localLinkedList.add("onVoicePlayBegin");
      localLinkedList.add("onVoicePlayEnd");
      localLinkedList.add("onLocalImageUploadProgress");
      localLinkedList.add("onImageDownloadProgress");
      localLinkedList.add("onVoiceUploadProgress");
      localLinkedList.add("onVoiceDownloadProgress");
      localLinkedList.add("onVideoUploadProgress");
      localLinkedList.add("onMediaFileUploadProgress");
      localLinkedList.add("menu:setfont");
      localLinkedList.add("menu:share:weibo");
      localLinkedList.add("menu:share:email");
      localLinkedList.add("wxdownload:state_change");
      localLinkedList.add("wxdownload:progress_change");
      localLinkedList.add("hdOnDeviceStateChanged");
      localLinkedList.add("activity:state_change");
      localLinkedList.add("onWXDeviceBluetoothStateChange");
      localLinkedList.add("onWXDeviceLanStateChange");
      localLinkedList.add("onWXDeviceBindStateChange");
      localLinkedList.add("onReceiveDataFromWXDevice");
      localLinkedList.add("onScanWXDeviceResult");
      localLinkedList.add("onWXDeviceStateChange");
      localLinkedList.add("onNfcTouch");
      localLinkedList.add("onBeaconMonitoring");
      localLinkedList.add("onBeaconsInRange");
      localLinkedList.add("menu:custom");
      localLinkedList.add("onSearchWAWidgetOpenApp");
      localLinkedList.add("onSearchDataReady");
      localLinkedList.add("onSearchHistoryReady");
      localLinkedList.add("onSearchWAWidgetOnTapCallback");
      localLinkedList.add("onSearchImageListReady");
      localLinkedList.add("onTeachSearchDataReady");
      localLinkedList.add("onSearchGuideDataReady");
      localLinkedList.add("onSearchInputChange");
      localLinkedList.add("onSearchInputConfirm");
      localLinkedList.add("onSearchSuggestionDataReady");
      localLinkedList.add("onMusicStatusChanged");
      localLinkedList.add("switchToTabSearch");
      localLinkedList.add("onVideoPlayerCallback");
      localLinkedList.add("onSelectContact");
      localLinkedList.add("onSearchWAWidgetAttrChanged");
      localLinkedList.add("onSearchWAWidgetReloadData");
      localLinkedList.add("onSearchWAWidgetReloadDataFinish");
      localLinkedList.add("onSearchWAWidgetStateChange");
      localLinkedList.add("onSearchWAWidgetDataPush");
      localLinkedList.add("emoticonIsChosen");
      localLinkedList.add("onSimilarEmoticonReady");
      localLinkedList.add("onSearchWebQueryReady");
      localLinkedList.add("onPullDownRefresh");
      localLinkedList.add("onPageStateChange");
      localLinkedList.add("onGetKeyboardHeight");
      localLinkedList.add("onGetSmiley");
      localLinkedList.add("onAddShortcutStatus");
      localLinkedList.add("onFocusSearchInput");
      localLinkedList.add("onGetA8KeyUrl");
      localLinkedList.add("deleteAccountSuccess");
      localLinkedList.add("onGetMsgProofItems");
      localLinkedList.add("WNJSHandlerInsert");
      localLinkedList.add("WNJSHandlerMultiInsert");
      localLinkedList.add("WNJSHandlerExportData");
      localLinkedList.add("WNJSHandlerHeaderAndFooterChange");
      localLinkedList.add("WNJSHandlerEditableChange");
      localLinkedList.add("WNJSHandlerEditingChange");
      localLinkedList.add("WNJSHandlerSaveSelectionRange");
      localLinkedList.add("WNJSHandlerLoadSelectionRange");
      localLinkedList.add("onCustomGameMenuClicked");
      localLinkedList.add("showLoading");
      localLinkedList.add("getSearchEmotionDataCallBack");
      localLinkedList.add("onNavigationBarRightButtonClick");
      localLinkedList.add("onSearchActionSheetClick");
      localLinkedList.add("onGetMatchContactList");
      localLinkedList.add("onUiInit");
      localLinkedList.add("onNetWorkChange");
      localLinkedList.add("onBackgroundAudioStateChange");
      if (!bt.gL(null)) {
        localLinkedList.addAll(null);
      }
      localHashMap.put("__runOn3rd_apis", new JSONArray(localLinkedList));
      paramMMWebView.getRandomStr();
      paramMMWebView.evaluateJavascript(a.g("event", "sys:attach_runOn3rd_apis", localHashMap) + ")", new ValueCallback() {});
      ad.i(this.TAG, "jsapi init done");
      AppMethodBeat.o(117752);
    }
    return true;
  }
  
  public final Object gy(Context paramContext)
  {
    AppMethodBeat.i(117754);
    if (!aj.eFK())
    {
      ad.w(this.TAG, "getWebView please call from tools proc");
      AppMethodBeat.o(117754);
      return null;
    }
    ad.i(this.TAG, "getWebView cached webview size %d", new Object[] { Integer.valueOf(this.AGY.size()) });
    if (this.AGY.size() <= 0)
    {
      AppMethodBeat.o(117754);
      return null;
    }
    if (!this.AGX)
    {
      ad.i(this.TAG, "preload unfinished");
      AppMethodBeat.o(117754);
      return null;
    }
    ai localai = (ai)this.AGY.get(0);
    if (localai == null)
    {
      this.AGY.remove(0);
      AppMethodBeat.o(117754);
      return null;
    }
    MMWebView localMMWebView = (MMWebView)localai.AHd;
    if ((localMMWebView.getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)localMMWebView.getContext()).setBaseContext(paramContext);
    }
    this.AGY.remove(localai);
    this.AGX = false;
    AppMethodBeat.o(117754);
    return localai;
  }
  
  public static final class a
  {
    private static JSONObject aT(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(117749);
      if ((paramMap == null) || (paramMap.size() == 0))
      {
        paramMap = new JSONObject();
        AppMethodBeat.o(117749);
        return paramMap;
      }
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str != null) {
            localJSONObject.put(str, paramMap.get(str));
          }
        }
        AppMethodBeat.o(117749);
      }
      catch (Exception paramMap)
      {
        ad.e("MicroMsg.WebViewPreLoadMgr.Builder", "convertMapToJSON fail, exception = " + paramMap.getMessage());
        AppMethodBeat.o(117749);
        return null;
      }
      return localJSONObject;
    }
    
    static String g(String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(117748);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("__msg_type", paramString1);
        if (paramString1.equals("event")) {
          localJSONObject.put("__event_id", paramString2);
        }
        localJSONObject.put("__params", aT(paramMap));
        paramString1 = localJSONObject.toString();
        AppMethodBeat.o(117748);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        ad.e("MicroMsg.WebViewPreLoadMgr.Builder", "build fail, exception = " + paramString1.getMessage());
        AppMethodBeat.o(117748);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ah
 * JD-Core Version:    0.7.0.1
 */