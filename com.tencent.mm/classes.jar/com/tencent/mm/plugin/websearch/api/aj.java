package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.c;
import com.tencent.xweb.z;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class aj
{
  int DUg;
  public AtomicBoolean DUh;
  public List<ak> DUi;
  long DUj;
  public String TAG;
  
  public aj(int paramInt)
  {
    AppMethodBeat.i(117750);
    this.TAG = "MicroMsg.WebSearch.WebSearchPreloadMgr";
    this.DUh = new AtomicBoolean(false);
    this.DUi = new LinkedList();
    this.DUg = paramInt;
    this.TAG = (this.TAG + "_" + paramInt);
    AppMethodBeat.o(117750);
  }
  
  final boolean a(final MMWebView paramMMWebView, final ak paramak)
  {
    AppMethodBeat.i(188478);
    ae.i(this.TAG, "begin jsapi init,wv %s", new Object[] { paramMMWebView.toString() });
    try
    {
      String str = bu.convertStreamToString(paramMMWebView.getContext().getAssets().open("jsapi/wxjs.js"));
      if (str == null)
      {
        ae.e(this.TAG, "loadJavaScript fail, jsContent is null");
        AppMethodBeat.o(188478);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace(this.TAG, localException, "", new Object[0]);
        localObject = null;
      }
      if (paramMMWebView == null)
      {
        ae.e(this.TAG, "loadJavaScript, viewWV is null");
        AppMethodBeat.o(188478);
        return false;
      }
      paramMMWebView.evaluateJavascript("javascript:".concat(String.valueOf(localObject)), new ValueCallback() {});
      Object localObject = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      HashMap localHashMap = new HashMap();
      localHashMap.put("webview_type", "1");
      localHashMap.put("init_url", paramMMWebView.getUrl());
      localHashMap.put("init_font_size", "1");
      paramMMWebView.getRandomStr();
      paramMMWebView.evaluateJavascript(a.j("event", "sys:init", localHashMap) + ")", new ValueCallback() {});
      localObject = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      paramMMWebView.getRandomStr();
      paramMMWebView.evaluateJavascript(a.j("event", "sys:bridged", null) + ")", new ValueCallback() {});
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
      localLinkedList.add("onChatSearchDataReady");
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
      if (!bu.ht(null)) {
        localLinkedList.addAll(null);
      }
      localHashMap.put("__runOn3rd_apis", new JSONArray(localLinkedList));
      paramMMWebView.getRandomStr();
      paramMMWebView.evaluateJavascript(a.j("event", "sys:attach_runOn3rd_apis", localHashMap) + ")", new ValueCallback() {});
      ae.i(this.TAG, "jsapi init done");
      AppMethodBeat.o(188478);
    }
    return true;
  }
  
  public final void aHn(final String paramString)
  {
    AppMethodBeat.i(117751);
    if (!com.tencent.mm.sdk.platformtools.ak.foD())
    {
      ae.i(this.TAG, "preload please call from toolsmp proc");
      AppMethodBeat.o(117751);
      return;
    }
    if (this.DUh.get())
    {
      ae.i(this.TAG, "preloading webview %s", new Object[] { Integer.valueOf(this.DUg) });
      AppMethodBeat.o(117751);
      return;
    }
    if (this.DUi.size() > 0)
    {
      ae.i(this.TAG, "already preload webview %s", new Object[] { Integer.valueOf(this.DUg) });
      AppMethodBeat.o(117751);
      return;
    }
    this.DUh.set(true);
    ae.i(this.TAG, "start to preload webview %d", new Object[] { Integer.valueOf(this.DUg) });
    h.MqF.aM(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(117739);
        aj localaj = aj.this;
        String str1 = paramString;
        ae.i(localaj.TAG, "real start preloadWebView cached webview preloadBiz %d", new Object[] { Integer.valueOf(localaj.DUg) });
        localaj.DUj = System.currentTimeMillis();
        MMWebView localMMWebView = MMWebView.a.kO(com.tencent.mm.sdk.platformtools.ak.getContext());
        ae.i(localaj.TAG, "Create MMWebView %s", new Object[] { localMMWebView.getWebCoreType() });
        localMMWebView.setPreload(true);
        localMMWebView.setRandomStr(bu.abf(16));
        localMMWebView.getSettings().setJavaScriptEnabled(true);
        localMMWebView.getSettings().setPluginsEnabled(true);
        localMMWebView.getSettings().gfD();
        localMMWebView.getSettings().setBuiltInZoomControls(false);
        localMMWebView.getSettings().setUseWideViewPort(true);
        localMMWebView.getSettings().setLoadWithOverviewMode(true);
        localMMWebView.getSettings().gfw();
        localMMWebView.getSettings().gfv();
        localMMWebView.getSettings().setGeolocationEnabled(true);
        localMMWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        localMMWebView.getSettings().gfF();
        localMMWebView.getSettings().gfB();
        localMMWebView.getSettings().setAppCachePath(localMMWebView.getContext().getDir("webviewcache", 0).getAbsolutePath());
        localMMWebView.getSettings().gfA();
        localMMWebView.getSettings().gfC();
        localMMWebView.getSettings().setDatabasePath(b.asa() + "databases/");
        c.geY().geZ();
        c.geY().e(localMMWebView);
        Object localObject = x.bX(localMMWebView.getContext(), localMMWebView.getSettings().getUserAgentString());
        localMMWebView.getSettings().setUserAgentString((String)localObject);
        localObject = new com.tencent.mm.plugin.webview.c.g();
        localMMWebView.addJavascriptInterface(localObject, "__wx");
        localMMWebView.loadUrl(str1);
        Uri localUri = Uri.parse(str1);
        str1 = localUri.getQueryParameter("sessionId");
        String str2 = localUri.getQueryParameter("subSessionId");
        try
        {
          i = Integer.valueOf(localUri.getQueryParameter("scene")).intValue();
          localMMWebView.setWebViewClient(new aj.2(localaj, localMMWebView, new ak(localMMWebView, str1, str2, (com.tencent.mm.plugin.webview.c.g)localObject, i)));
          com.tencent.mm.plugin.report.service.g.yxI.f(15005, new Object[] { Integer.valueOf(localaj.DUg), Integer.valueOf(1), Integer.valueOf(0) });
          AppMethodBeat.o(117739);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i = 0;
          }
        }
      }
    });
    AppMethodBeat.o(117751);
  }
  
  public static final class a
  {
    private static JSONObject bf(Map<String, Object> paramMap)
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
        ae.e("MicroMsg.WebViewPreLoadMgr.Builder", "convertMapToJSON fail, exception = " + paramMap.getMessage());
        AppMethodBeat.o(117749);
        return null;
      }
      return localJSONObject;
    }
    
    static String j(String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(117748);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("__msg_type", paramString1);
        if (paramString1.equals("event")) {
          localJSONObject.put("__event_id", paramString2);
        }
        localJSONObject.put("__params", bf(paramMap));
        paramString1 = localJSONObject.toString();
        AppMethodBeat.o(117748);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        ae.e("MicroMsg.WebViewPreLoadMgr.Builder", "build fail, exception = " + paramString1.getMessage());
        AppMethodBeat.o(117748);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aj
 * JD-Core Version:    0.7.0.1
 */