package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.f;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadTask;", "", "biz", "", "url", "", "(ILjava/lang/String;)V", "beginTimestamp", "", "getBeginTimestamp", "()J", "setBeginTimestamp", "(J)V", "getBiz", "()I", "getUrl", "()Ljava/lang/String;", "webSearchPreloadObj", "Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;", "getWebSearchPreloadObj", "()Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;", "setWebSearchPreloadObj", "(Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;)V", "buildDefaultParams", "", "getRunOn3rdApis", "loadJavaScript", "", "webView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "reportPreloadCompleted", "", "start", "Builder", "plugin-webview_release"})
public final class e
{
  long QmY;
  d QmZ;
  final int ppO;
  final String url;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(214476);
    this.ppO = paramInt;
    this.url = paramString;
    AppMethodBeat.o(214476);
  }
  
  final boolean a(WebSearchWebView paramWebSearchWebView)
  {
    AppMethodBeat.i(214473);
    Log.i(c.getTAG(), "loadJavaScript");
    try
    {
      Object localObject1 = Util.convertStreamToString(MMApplicationContext.getContext().getAssets().open("jsapi/wxjs.js"));
      paramWebSearchWebView.evaluateJavascript("javascript:".concat(String.valueOf(localObject1)), (ValueCallback)new b(this));
      localObject1 = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      Object localObject3 = a.Qna;
      localObject3 = (Map)new HashMap();
      ((Map)localObject3).put("webview_type", "1");
      ((Map)localObject3).put("init_url", this.url);
      ((Map)localObject3).put("init_font_size", "1");
      paramWebSearchWebView.evaluateJavascript(e.a.a.T("sys:init", (Map)localObject3) + ")", (ValueCallback)new c(this));
      localObject1 = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      localObject3 = a.Qna;
      paramWebSearchWebView.evaluateJavascript(e.a.a.T("sys:bridged", null) + ")", (ValueCallback)new d(this));
      localObject1 = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      localObject3 = a.Qna;
      localObject3 = (Map)new HashMap();
      List localList = (List)new LinkedList();
      localList.add("menu:share:timeline");
      localList.add("menu:share:appmessage");
      localList.add("menu:share:weiboApp");
      localList.add("menu:share:QZone");
      localList.add("menu:share:qq");
      localList.add("onVoiceRecordEnd");
      localList.add("onVoicePlayBegin");
      localList.add("onVoicePlayEnd");
      localList.add("onLocalImageUploadProgress");
      localList.add("onImageDownloadProgress");
      localList.add("onVoiceUploadProgress");
      localList.add("onVoiceDownloadProgress");
      localList.add("onVideoUploadProgress");
      localList.add("onMediaFileUploadProgress");
      localList.add("menu:setfont");
      localList.add("menu:share:weibo");
      localList.add("menu:share:email");
      localList.add("wxdownload:state_change");
      localList.add("wxdownload:progress_change");
      localList.add("hdOnDeviceStateChanged");
      localList.add("activity:state_change");
      localList.add("onWXDeviceBluetoothStateChange");
      localList.add("onWXDeviceLanStateChange");
      localList.add("onWXDeviceBindStateChange");
      localList.add("onReceiveDataFromWXDevice");
      localList.add("onScanWXDeviceResult");
      localList.add("onWXDeviceStateChange");
      localList.add("onNfcTouch");
      localList.add("onBeaconMonitoring");
      localList.add("onBeaconsInRange");
      localList.add("menu:custom");
      localList.add("onSearchWAWidgetOpenApp");
      localList.add("onSearchDataReady");
      localList.add("onClientNavAction");
      localList.add("onNavBarShadowManuallyHidden");
      localList.add("onGetVertSearchEntriesData");
      localList.add("onChatSearchDataReady");
      localList.add("onSearchHistoryReady");
      localList.add("onSearchWAWidgetOnTapCallback");
      localList.add("onSearchImageListReady");
      localList.add("onTeachSearchDataReady");
      localList.add("onSearchGuideDataReady");
      localList.add("onSearchInputChange");
      localList.add("onSearchInputConfirm");
      localList.add("onSearchSuggestionDataReady");
      localList.add("onMusicStatusChanged");
      localList.add("switchToTabSearch");
      localList.add("onVideoPlayerCallback");
      localList.add("onSelectContact");
      localList.add("onSearchWAWidgetAttrChanged");
      localList.add("onSearchWAWidgetReloadData");
      localList.add("onSearchWAWidgetReloadDataFinish");
      localList.add("onSearchWAWidgetStateChange");
      localList.add("onSearchWAWidgetDataPush");
      localList.add("emoticonIsChosen");
      localList.add("onSimilarEmoticonReady");
      localList.add("onSearchWebQueryReady");
      localList.add("onPullDownRefresh");
      localList.add("onPageStateChange");
      localList.add("onGetKeyboardHeight");
      localList.add("onGetSmiley");
      localList.add("onAddShortcutStatus");
      localList.add("onFocusSearchInput");
      localList.add("onGetA8KeyUrl");
      localList.add("deleteAccountSuccess");
      localList.add("onGetMsgProofItems");
      localList.add("WNJSHandlerInsert");
      localList.add("WNJSHandlerMultiInsert");
      localList.add("WNJSHandlerExportData");
      localList.add("WNJSHandlerHeaderAndFooterChange");
      localList.add("WNJSHandlerEditableChange");
      localList.add("WNJSHandlerEditingChange");
      localList.add("WNJSHandlerSaveSelectionRange");
      localList.add("WNJSHandlerLoadSelectionRange");
      localList.add("onCustomGameMenuClicked");
      localList.add("showLoading");
      localList.add("getSearchEmotionDataCallBack");
      localList.add("onNavigationBarRightButtonClick");
      localList.add("onSearchActionSheetClick");
      localList.add("onGetMatchContactList");
      localList.add("onUiInit");
      localList.add("onNetWorkChange");
      localList.add("onBackgroundAudioStateChange");
      ((Map)localObject3).put("__runOn3rd_apis", new JSONArray((Collection)localList));
      paramWebSearchWebView.evaluateJavascript(e.a.a.T("sys:attach_runOn3rd_apis", (Map)localObject3) + ")", (ValueCallback)new e(this));
      AppMethodBeat.o(214473);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(c.getTAG(), (Throwable)localException, "", new Object[0]);
        Object localObject2 = null;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadTask$Builder;", "", "()V", "Companion", "plugin-webview_release"})
  public static final class a
  {
    public static final a Qna;
    
    static
    {
      AppMethodBeat.i(267936);
      Qna = new a((byte)0);
      AppMethodBeat.o(267936);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadTask$Builder$Companion;", "", "()V", "EVENT_ID", "", "MSG_PARAMS", "MSG_TYPE", "TYPE_EVENT", "convertMapToJSON", "Lorg/json/JSONObject;", "map", "", "eventToString", "eventId", "params", "plugin-webview_release"})
    public static final class a
    {
      public static String T(String paramString, Map<String, ? extends Object> paramMap)
      {
        AppMethodBeat.i(248391);
        p.k(paramString, "eventId");
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("__msg_type", "event");
          localJSONObject.put("__event_id", paramString);
          if (paramMap != null)
          {
            paramString = e.a.Qna;
            localJSONObject.put("__params", aY(paramMap));
          }
        }
        catch (Exception paramString)
        {
          label55:
          break label55;
        }
        paramString = localJSONObject.toString();
        p.j(paramString, "json.toString()");
        AppMethodBeat.o(248391);
        return paramString;
      }
      
      private static JSONObject aY(Map<String, ? extends Object> paramMap)
      {
        AppMethodBeat.i(248392);
        p.k(paramMap, "map");
        JSONObject localJSONObject = new JSONObject();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          try
          {
            localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(248392);
        return localJSONObject;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
  static final class b<T>
    implements ValueCallback<String>
  {
    b(e parame) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
  static final class c<T>
    implements ValueCallback<String>
  {
    c(e parame) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
  static final class d<T>
    implements ValueCallback<String>
  {
    d(e parame) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
  static final class e<T>
    implements ValueCallback<String>
  {
    e(e parame) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.preload.e
 * JD-Core Version:    0.7.0.1
 */