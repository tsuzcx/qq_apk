package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.AssetManager;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.s;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public final class al
  implements l
{
  String TAG = "MicroMsg.WebSearch.WebSearchPreloadMgr";
  private ai eAg;
  private boolean fAo = false;
  private HashSet<Object> hbh = new HashSet();
  int qUH;
  boolean qUI;
  List<am> qUJ = new LinkedList();
  long qUK;
  
  public al(int paramInt)
  {
    this.qUH = paramInt;
    this.TAG = (this.TAG + "_" + paramInt);
    this.eAg = new ai();
  }
  
  public final void Rq(String paramString)
  {
    if (!ae.cqX()) {
      y.w(this.TAG, "preload please call from tools proc");
    }
    label114:
    do
    {
      return;
      if ((this.qUH != 2) && (aq.bZW().bZX()))
      {
        y.i(this.TAG, "use sys webview");
        y.i(this.TAG, "use sys webview 2");
      }
      for (;;)
      {
        int i = 0;
        if (i == 0) {
          break;
        }
        y.w(this.TAG, " preload forbidden");
        return;
        Context localContext = ae.getContext();
        if ((!WebView.isXWalk()) && (WebView.getUsingTbsCoreVersion(localContext) == 0)) {
          y.i("XWebUtil", "can not preload without x5 or xwalk");
        }
        for (i = 0;; i = 1)
        {
          if (i != 0) {
            break label114;
          }
          y.i(this.TAG, "isOpenRecommendPreload webview not support");
          i = 1;
          break;
        }
      }
      if (!ae.cqX())
      {
        y.w(this.TAG, "preload please call from tools proc");
        return;
      }
      if (!ai.isMainThread())
      {
        y.w(this.TAG, "preload please call from main thread");
        return;
      }
    } while (this.fAo);
    this.fAo = true;
    y.i(this.TAG, "preloading %s ", new Object[] { paramString });
    this.eAg.O(new al.1(this, paramString));
  }
  
  final boolean b(MMWebView paramMMWebView)
  {
    y.i(this.TAG, "begin jsapi init,wv %s", new Object[] { paramMMWebView.toString() });
    try
    {
      String str = bk.convertStreamToString(paramMMWebView.getContext().getAssets().open("jsapi/wxjs.js"));
      if (str == null)
      {
        y.e(this.TAG, "loadJavaScript fail, jsContent is null");
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace(this.TAG, localException, "", new Object[0]);
        localObject = null;
      }
      if (paramMMWebView == null)
      {
        y.e(this.TAG, "loadJavaScript, viewWV is null");
        return false;
      }
      paramMMWebView.evaluateJavascript("javascript:" + (String)localObject, new al.3(this, paramMMWebView));
      Object localObject = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      HashMap localHashMap = new HashMap();
      localHashMap.put("webview_type", "1");
      localHashMap.put("init_url", paramMMWebView.getUrl());
      localHashMap.put("init_font_size", "1");
      paramMMWebView.getRandomStr();
      paramMMWebView.evaluateJavascript(al.a.f("event", "sys:init", localHashMap) + ")", new al.4(this, paramMMWebView));
      localObject = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      paramMMWebView.getRandomStr();
      paramMMWebView.evaluateJavascript(al.a.f("event", "sys:bridged", null) + ")", new al.5(this, paramMMWebView));
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
      if (!bk.dk(null)) {
        localLinkedList.addAll(null);
      }
      localHashMap.put("__runOn3rd_apis", new JSONArray(localLinkedList));
      paramMMWebView.getRandomStr();
      paramMMWebView.evaluateJavascript(al.a.f("event", "sys:attach_runOn3rd_apis", localHashMap) + ")", new al.6(this, paramMMWebView));
      y.i(this.TAG, "jsapi init done");
    }
    return true;
  }
  
  final MMWebView bZI()
  {
    try
    {
      Object localObject = new MutableContextWrapper(ae.getContext());
      if (this.qUH == 2) {
        return MMWebView.a.cO((Context)localObject);
      }
      if (aq.bZW().bZX()) {
        return MMWebView.a.hj((Context)localObject);
      }
      localObject = MMWebView.a.cO((Context)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace(this.TAG, localException, "", new Object[0]);
    }
    return null;
  }
  
  final void done()
  {
    try
    {
      y.i(this.TAG, "preInit finished");
      this.fAo = false;
      Iterator localIterator = this.hbh.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      this.hbh.clear();
    }
    finally {}
  }
  
  public final Object ew(Context paramContext)
  {
    if (!ae.cqX())
    {
      y.w(this.TAG, "getWebView please call from tools proc");
      return null;
    }
    y.i(this.TAG, "getWebView cached webview size %d", new Object[] { Integer.valueOf(this.qUJ.size()) });
    if (this.qUJ.size() <= 0) {
      return null;
    }
    if (!this.qUI)
    {
      y.i(this.TAG, "preload unfinished");
      return null;
    }
    am localam = (am)this.qUJ.get(0);
    if (localam == null)
    {
      this.qUJ.remove(0);
      return null;
    }
    MMWebView localMMWebView = (MMWebView)localam.qUO;
    if ((localMMWebView.getContext() instanceof MutableContextWrapper))
    {
      ((MutableContextWrapper)localMMWebView.getContext()).setBaseContext(paramContext);
      s.q("BASE_CONTEXT_CHANGED", localMMWebView.getContext());
    }
    this.qUJ.remove(localam);
    this.qUI = false;
    return localam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.al
 * JD-Core Version:    0.7.0.1
 */