package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.AssetManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public final class ak
  implements l
{
  String TAG;
  private com.tencent.mm.sdk.platformtools.al fPW;
  private boolean gRS;
  private HashSet<Object> iKa;
  int uJR;
  boolean uJS;
  List<al> uJT;
  long uJU;
  
  public ak(int paramInt)
  {
    AppMethodBeat.i(124200);
    this.TAG = "MicroMsg.WebSearch.WebSearchPreloadMgr";
    this.gRS = false;
    this.iKa = new HashSet();
    this.uJT = new LinkedList();
    this.uJR = paramInt;
    this.TAG = (this.TAG + "_" + paramInt);
    this.fPW = new com.tencent.mm.sdk.platformtools.al();
    AppMethodBeat.o(124200);
  }
  
  final MMWebView aYh()
  {
    AppMethodBeat.i(124203);
    try
    {
      Object localObject = new MutableContextWrapper(ah.getContext());
      if (this.uJR == 2)
      {
        localObject = MMWebView.a.iI((Context)localObject);
        AppMethodBeat.o(124203);
        return localObject;
      }
      if (ap.cZR().cZS())
      {
        localObject = MMWebView.a.iH((Context)localObject);
        AppMethodBeat.o(124203);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, localException, "", new Object[0]);
      AppMethodBeat.o(124203);
      return null;
    }
    MMWebView localMMWebView = MMWebView.a.iI(localException);
    AppMethodBeat.o(124203);
    return localMMWebView;
  }
  
  public final void agp(final String paramString)
  {
    AppMethodBeat.i(124201);
    if (!ah.dsW())
    {
      ab.w(this.TAG, "preload please call from tools proc");
      AppMethodBeat.o(124201);
      return;
    }
    if ((this.uJR != 2) && (ap.cZR().cZS()))
    {
      ab.i(this.TAG, "use sys webview");
      ab.i(this.TAG, "use sys webview 2");
    }
    label129:
    for (;;)
    {
      int i = 0;
      if (i == 0) {
        break;
      }
      ab.w(this.TAG, " preload forbidden");
      AppMethodBeat.o(124201);
      return;
      Context localContext = ah.getContext();
      if ((!WebView.isXWalk()) && (WebView.getUsingTbsCoreVersion(localContext) == 0)) {
        ab.i("XWebUtil", "can not preload without x5 or xwalk");
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label129;
        }
        ab.i(this.TAG, "isOpenRecommendPreload webview not support");
        i = 1;
        break;
      }
    }
    if (!ah.dsW())
    {
      ab.w(this.TAG, "preload please call from tools proc");
      AppMethodBeat.o(124201);
      return;
    }
    if (!com.tencent.mm.sdk.platformtools.al.isMainThread())
    {
      ab.w(this.TAG, "preload please call from main thread");
      AppMethodBeat.o(124201);
      return;
    }
    if (!this.gRS)
    {
      this.gRS = true;
      ab.i(this.TAG, "preloading %s ", new Object[] { paramString });
      this.fPW.ac(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124189);
          ab.i(ak.this.TAG, "preload start");
          ak.7 local7 = new ak.7(ak.this, paramString);
          if (Looper.getMainLooper().getThread() == Thread.currentThread())
          {
            local7.run();
            AppMethodBeat.o(124189);
            return;
          }
          com.tencent.mm.sdk.platformtools.al.d(local7);
          AppMethodBeat.o(124189);
        }
      });
    }
    AppMethodBeat.o(124201);
  }
  
  final boolean b(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(124202);
    ab.i(this.TAG, "begin jsapi init,wv %s", new Object[] { paramMMWebView.toString() });
    try
    {
      String str = bo.convertStreamToString(paramMMWebView.getContext().getAssets().open("jsapi/wxjs.js"));
      if (str == null)
      {
        ab.e(this.TAG, "loadJavaScript fail, jsContent is null");
        AppMethodBeat.o(124202);
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace(this.TAG, localException, "", new Object[0]);
        localObject = null;
      }
      if (paramMMWebView == null)
      {
        ab.e(this.TAG, "loadJavaScript, viewWV is null");
        AppMethodBeat.o(124202);
        return false;
      }
      paramMMWebView.evaluateJavascript("javascript:".concat(String.valueOf(localObject)), new ak.3(this, paramMMWebView));
      Object localObject = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      HashMap localHashMap = new HashMap();
      localHashMap.put("webview_type", "1");
      localHashMap.put("init_url", paramMMWebView.getUrl());
      localHashMap.put("init_font_size", "1");
      paramMMWebView.getRandomStr();
      paramMMWebView.evaluateJavascript(ak.a.i("event", "sys:init", localHashMap) + ")", new ak.4(this, paramMMWebView));
      localObject = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      paramMMWebView.getRandomStr();
      paramMMWebView.evaluateJavascript(ak.a.i("event", "sys:bridged", null) + ")", new ak.5(this, paramMMWebView));
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
      if (!bo.es(null)) {
        localLinkedList.addAll(null);
      }
      localHashMap.put("__runOn3rd_apis", new JSONArray(localLinkedList));
      paramMMWebView.getRandomStr();
      paramMMWebView.evaluateJavascript(ak.a.i("event", "sys:attach_runOn3rd_apis", localHashMap) + ")", new ak.6(this, paramMMWebView));
      ab.i(this.TAG, "jsapi init done");
      AppMethodBeat.o(124202);
    }
    return true;
  }
  
  final void done()
  {
    try
    {
      AppMethodBeat.i(124205);
      ab.i(this.TAG, "preInit finished");
      this.gRS = false;
      Iterator localIterator = this.iKa.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.iKa.clear();
    }
    finally {}
    AppMethodBeat.o(124205);
  }
  
  public final Object ft(Context paramContext)
  {
    AppMethodBeat.i(124204);
    if (!ah.dsW())
    {
      ab.w(this.TAG, "getWebView please call from tools proc");
      AppMethodBeat.o(124204);
      return null;
    }
    ab.i(this.TAG, "getWebView cached webview size %d", new Object[] { Integer.valueOf(this.uJT.size()) });
    if (this.uJT.size() <= 0)
    {
      AppMethodBeat.o(124204);
      return null;
    }
    if (!this.uJS)
    {
      ab.i(this.TAG, "preload unfinished");
      AppMethodBeat.o(124204);
      return null;
    }
    al localal = (al)this.uJT.get(0);
    if (localal == null)
    {
      this.uJT.remove(0);
      AppMethodBeat.o(124204);
      return null;
    }
    MMWebView localMMWebView = (MMWebView)localal.uJY;
    if ((localMMWebView.getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)localMMWebView.getContext()).setBaseContext(paramContext);
    }
    this.uJT.remove(localal);
    this.uJS = false;
    AppMethodBeat.o(124204);
    return localal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ak
 * JD-Core Version:    0.7.0.1
 */