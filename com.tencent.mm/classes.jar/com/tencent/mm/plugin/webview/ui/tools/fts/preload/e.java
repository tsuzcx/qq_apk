package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mo;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.websearch.webview.j;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.WebViewKind;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadTask;", "", "biz", "", "url", "", "(ILjava/lang/String;)V", "beginTimestamp", "", "getBeginTimestamp", "()J", "setBeginTimestamp", "(J)V", "getBiz", "()I", "getUrl", "()Ljava/lang/String;", "webSearchPreloadObj", "Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;", "getWebSearchPreloadObj", "()Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;", "setWebSearchPreloadObj", "(Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;)V", "buildDefaultParams", "", "getRunOn3rdApis", "loadJavaScript", "", "webView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "reportPreloadCompleted", "", "start", "Builder", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  long Xfo;
  d Xfp;
  final int biz;
  final String url;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(296978);
    this.biz = paramInt;
    this.url = paramString;
    AppMethodBeat.o(296978);
  }
  
  private static final void a(e parame, String paramString)
  {
    AppMethodBeat.i(296982);
    s.u(parame, "this$0");
    long l1 = cn.bDw();
    long l2 = parame.Xfo;
    Log.i(c.getTAG(), "load wxjs cost:" + (l1 - l2) + ' ' + paramString);
    AppMethodBeat.o(296982);
  }
  
  private static final void b(e parame, String paramString)
  {
    AppMethodBeat.i(296987);
    s.u(parame, "this$0");
    long l1 = cn.bDw();
    long l2 = parame.Xfo;
    Log.i(c.getTAG(), "sys:init cost:" + (l1 - l2) + ' ' + paramString);
    AppMethodBeat.o(296987);
  }
  
  private static final void c(e parame, String paramString)
  {
    AppMethodBeat.i(296991);
    s.u(parame, "this$0");
    long l1 = cn.bDw();
    long l2 = parame.Xfo;
    Log.i(c.getTAG(), "sys:init bridged:" + (l1 - l2) + ' ' + paramString);
    AppMethodBeat.o(296991);
  }
  
  private static final void d(e parame, String paramString)
  {
    AppMethodBeat.i(296998);
    s.u(parame, "this$0");
    long l1 = cn.bDw();
    long l2 = parame.Xfo;
    Log.i(c.getTAG(), "sys:attach_runOn3rd_apis cost:" + (l1 - l2) + ' ' + paramString);
    paramString = parame.Xfp;
    if (paramString != null)
    {
      paramString = paramString.Xfn;
      if (paramString != null) {
        paramString.set(true);
      }
    }
    d locald = parame.Xfp;
    if (locald != null)
    {
      l1 = cn.bDw();
      l2 = parame.Xfo;
      paramString = new mo();
      paramString.jbO = parame.biz;
      paramString.ila = 2L;
      paramString.jbP = (l1 - l2);
      parame = locald.TPU;
      if (parame != null) {
        break label175;
      }
      parame = null;
      if (parame != WebView.WebViewKind.aifK) {
        break label183;
      }
    }
    label175:
    label183:
    for (l1 = 1L;; l1 = 0L)
    {
      paramString.jbQ = l1;
      paramString.bMH();
      as.a((com.tencent.mm.plugin.report.a)paramString);
      AppMethodBeat.o(296998);
      return;
      parame = parame.getWebCoreType();
      break;
    }
  }
  
  final boolean b(WebSearchWebView paramWebSearchWebView)
  {
    AppMethodBeat.i(297020);
    Log.i(c.getTAG(), "loadJavaScript");
    try
    {
      Object localObject1 = Util.convertStreamToString(MMApplicationContext.getContext().getAssets().open("jsapi/wxjs.js"));
      paramWebSearchWebView.evaluateJavascript(s.X("javascript:", localObject1), new e..ExternalSyntheticLambda1(this));
      localObject1 = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      Object localObject3 = a.Xfq;
      localObject3 = (Map)new HashMap();
      ((Map)localObject3).put("webview_type", "1");
      ((Map)localObject3).put("init_url", this.url);
      ((Map)localObject3).put("init_font_size", "1");
      paramWebSearchWebView.evaluateJavascript(e.a.a.ac("sys:init", (Map)localObject3) + ')', new e..ExternalSyntheticLambda3(this));
      localObject1 = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      localObject3 = a.Xfq;
      paramWebSearchWebView.evaluateJavascript(e.a.a.ac("sys:bridged", null) + ')', new e..ExternalSyntheticLambda0(this));
      localObject1 = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
      localObject3 = a.Xfq;
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
      localList.add("onDeviceMotionFired");
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
      paramWebSearchWebView.evaluateJavascript(e.a.a.ac("sys:attach_runOn3rd_apis", (Map)localObject3) + ')', new e..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(297020);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadTask$Builder;", "", "()V", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a Xfq;
    
    static
    {
      AppMethodBeat.i(296967);
      Xfq = new a((byte)0);
      AppMethodBeat.o(296967);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadTask$Builder$Companion;", "", "()V", "EVENT_ID", "", "MSG_PARAMS", "MSG_TYPE", "TYPE_EVENT", "convertMapToJSON", "Lorg/json/JSONObject;", "map", "", "eventToString", "eventId", "params", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static String ac(String paramString, Map<String, ? extends Object> paramMap)
      {
        AppMethodBeat.i(296972);
        s.u(paramString, "eventId");
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("__msg_type", "event");
          localJSONObject.put("__event_id", paramString);
          if (paramMap != null)
          {
            paramString = e.a.Xfq;
            localJSONObject.put("__params", bp(paramMap));
          }
        }
        catch (Exception paramString)
        {
          label55:
          break label55;
        }
        paramString = localJSONObject.toString();
        s.s(paramString, "json.toString()");
        AppMethodBeat.o(296972);
        return paramString;
      }
      
      private static JSONObject bp(Map<String, ? extends Object> paramMap)
      {
        AppMethodBeat.i(296974);
        s.u(paramMap, "map");
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
        AppMethodBeat.o(296974);
        return localJSONObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(e parame)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadTask$start$2$webSearchJSApi$1", "Lcom/tencent/mm/plugin/websearch/webview/IMultiProcessWebSearchUIComponent;", "getWebView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.plugin.websearch.webview.c
    {
      a(WebSearchWebView paramWebSearchWebView) {}
      
      public final WebSearchWebView getWebView()
      {
        return this.WrY;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.preload.e
 * JD-Core Version:    0.7.0.1
 */