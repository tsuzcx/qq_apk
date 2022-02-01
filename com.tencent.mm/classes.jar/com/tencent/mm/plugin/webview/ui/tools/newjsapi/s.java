package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ao;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleVideoAction;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/BasePluginJsApi;", "()V", "TAG", "", "actionInsertSameLayerVideo", "actionOperateSameLayerVideo", "actionRemoveSameLayerVideo", "actionUpdateSameLayerVideo", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "getPluginType", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends a
{
  private static final int OOk;
  public static final s Xnp;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297761);
    Xnp = new s();
    OOk = 371;
    idA = "handleVideoAction";
    AppMethodBeat.o(297761);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297788);
    kotlin.g.b.s.u(paramh, "env");
    kotlin.g.b.s.u(paramp, "msg");
    Object localObject1 = (String)paramp.params.get("action");
    Log.i("MicroMsg.JsApiHandleVideoAction", "HandleVideoAction action=%s", new Object[] { localObject1 });
    if (Util.isNullOrNil((String)localObject1))
    {
      paramh.WDy.doCallback(paramp.WEH, kotlin.g.b.s.X(paramp.function, ":fail action is empty"), null);
      AppMethodBeat.o(297788);
      return true;
    }
    if ((kotlin.g.b.s.p("insertSameLayerVideo", localObject1)) || (kotlin.g.b.s.p("updateSameLayerVideo", localObject1)) || (kotlin.g.b.s.p("operateSameLayerVideo", localObject1)) || (kotlin.g.b.s.p("removeSameLayerVideo", localObject1)))
    {
      if (!aa.iOK())
      {
        Log.e("MicroMsg.JsApiHandleVideoAction", "handleVideoAction not useSameLayerForVideo");
        paramh.WDy.doCallback(paramp.WEH, kotlin.g.b.s.X(paramp.function, ":fail not support"), null);
        AppMethodBeat.o(297788);
        return true;
      }
      boolean bool = d(paramh, paramp);
      if ((kotlin.g.b.s.p("removeSameLayerVideo", localObject1)) && (paramp.WEI != null) && (paramp.WEI.has("viewId")))
      {
        paramh = c(paramh);
        if (paramh != null) {
          paramh.H("video", paramp.WEI.optInt("viewId"));
        }
      }
      AppMethodBeat.o(297788);
      return bool;
    }
    if (kotlin.g.b.s.p("supportIFrameSameLayer", localObject1))
    {
      localObject1 = paramh.WDz;
      kotlin.g.b.s.checkNotNull(localObject1);
      if ((((MMWebView)localObject1).isXWalkKernel()) && (ao.isCurrentVersionSupportNativeView())) {
        paramh.WDy.doCallback(paramp.WEH, kotlin.g.b.s.X(paramp.function, ":ok"), null);
      }
      for (;;)
      {
        AppMethodBeat.o(297788);
        return true;
        paramh.WDy.doCallback(paramp.WEH, kotlin.g.b.s.X(paramp.function, ":fail"), null);
      }
    }
    Object localObject2 = com.tencent.mm.plugin.webview.ui.tools.video.a.Xok;
    if ((com.tencent.mm.plugin.webview.ui.tools.video.a.iBO()) && (kotlin.g.b.s.p("getInitialParams", localObject1)))
    {
      localObject1 = com.tencent.mm.plugin.webview.ui.tools.video.a.Xok;
      HashMap localHashMap = new HashMap();
      String str = com.tencent.mm.plugin.webview.ui.tools.video.a.Xom.decodeString("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
      if (Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "getInitialParams vid null");
        localObject1 = null;
        paramh.WDy.doCallback(paramp.WEH, kotlin.g.b.s.X(paramp.function, ":ok"), (Map)localObject1);
        AppMethodBeat.o(297788);
        return true;
      }
      Map localMap1 = com.tencent.mm.plugin.webview.ui.tools.video.a.bmP(str);
      Map localMap2 = (Map)localHashMap;
      if (localMap1 == null)
      {
        localObject1 = null;
        label448:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Object();
        }
        localMap2.put("videoInitialTime", localObject2);
        localMap2 = (Map)localHashMap;
        if (localMap1 != null) {
          break label604;
        }
      }
      label604:
      for (localObject1 = null;; localObject1 = localMap1.get("videoInitialSnapshot"))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Object();
        }
        localMap2.put("videoInitialSnapshot", localObject2);
        ((MultiProcessMMKV)com.tencent.mm.plugin.webview.ui.tools.video.a.Xom.getSlotForWrite()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "getInitialParams vid = " + str + ", time = " + localHashMap.get("videoInitialTime"));
        localObject1 = (Map)localHashMap;
        break;
        localObject1 = localMap1.get("videoInitialTime");
        break label448;
      }
    }
    if (kotlin.g.b.s.p("supportCodec", localObject1))
    {
      if (cr(paramp.params)) {
        paramh.WDy.doCallback(paramp.WEH, kotlin.g.b.s.X(paramp.function, ":ok"), null);
      }
      for (;;)
      {
        AppMethodBeat.o(297788);
        return true;
        paramh.WDy.doCallback(paramp.WEH, kotlin.g.b.s.X(paramp.function, ":fail"), null);
      }
    }
    AppMethodBeat.o(297788);
    return false;
  }
  
  public final String cog()
  {
    return "video";
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.s
 * JD-Core Version:    0.7.0.1
 */