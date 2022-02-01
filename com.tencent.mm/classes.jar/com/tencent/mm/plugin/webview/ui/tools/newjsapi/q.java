package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleVideoAction;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/BasePluginJsApi;", "()V", "TAG", "", "actionInsertSameLayerVideo", "actionOperateSameLayerVideo", "actionRemoveSameLayerVideo", "actionUpdateSameLayerVideo", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "getPluginType", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class q
  extends a
{
  private static final int IIl = 371;
  public static final q Qvt;
  private static final String fXz = "handleVideoAction";
  
  static
  {
    AppMethodBeat.i(219718);
    Qvt = new q();
    IIl = 371;
    fXz = "handleVideoAction";
    AppMethodBeat.o(219718);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(219717);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Object localObject1 = (String)paramn.params.get("action");
    Log.i("MicroMsg.JsApiHandleVideoAction", "HandleVideoAction action=%s", new Object[] { localObject1 });
    if (Util.isNullOrNil((String)localObject1))
    {
      paramf.PNo.h(paramn.POu, paramn.function + ":fail action is empty", null);
      AppMethodBeat.o(219717);
      return true;
    }
    if ((p.h("insertSameLayerVideo", localObject1)) || (p.h("updateSameLayerVideo", localObject1)) || (p.h("operateSameLayerVideo", localObject1)) || (p.h("removeSameLayerVideo", localObject1)))
    {
      ab.hnS();
      boolean bool = d(paramf, paramn);
      if ((p.h("removeSameLayerVideo", localObject1)) && (paramn.POv != null) && (paramn.POv.has("viewId")))
      {
        paramf = c(paramf);
        if (paramf != null) {
          paramf.z("video", paramn.POv.optInt("viewId"));
        }
      }
      AppMethodBeat.o(219717);
      return bool;
    }
    if (p.h("supportIFrameSameLayer", localObject1))
    {
      localObject1 = paramf.PNp;
      if (localObject1 == null) {
        p.iCn();
      }
      if ((((MMWebView)localObject1).isXWalkKernel()) && (XWalkEnvironment.isCurrentVersionSupportNativeView())) {
        paramf.PNo.h(paramn.POu, paramn.function + ":ok", null);
      }
      for (;;)
      {
        AppMethodBeat.o(219717);
        return true;
        paramf.PNo.h(paramn.POu, paramn.function + ":fail", null);
      }
    }
    Object localObject2 = com.tencent.mm.plugin.webview.ui.tools.video.a.QvS;
    if ((com.tencent.mm.plugin.webview.ui.tools.video.a.hbB()) && (p.h("getInitialParams", localObject1)))
    {
      localObject1 = com.tencent.mm.plugin.webview.ui.tools.video.a.QvS;
      HashMap localHashMap = new HashMap();
      String str = com.tencent.mm.plugin.webview.ui.tools.video.a.QvR.decodeString("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
      if (Util.isNullOrNil(str)) {
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "getInitialParams vid null");
      }
      for (localObject1 = null;; localObject1 = (Map)localHashMap)
      {
        paramf.PNo.h(paramn.POu, paramn.function + ":ok", (Map)localObject1);
        AppMethodBeat.o(219717);
        return true;
        Map localMap1 = com.tencent.mm.plugin.webview.ui.tools.video.a.bni(str);
        Map localMap2 = (Map)localHashMap;
        if (localMap1 != null)
        {
          localObject2 = localMap1.get("videoInitialTime");
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = new Object();
        }
        localMap2.put("videoInitialTime", localObject1);
        localMap2 = (Map)localHashMap;
        if (localMap1 != null)
        {
          localObject2 = localMap1.get("videoInitialSnapshot");
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = new Object();
        }
        localMap2.put("videoInitialSnapshot", localObject1);
        ((MultiProcessMMKV)com.tencent.mm.plugin.webview.ui.tools.video.a.QvR.getSlotForWrite()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "getInitialParams vid = " + str + ", time = " + localHashMap.get("videoInitialTime"));
      }
    }
    AppMethodBeat.o(219717);
    return false;
  }
  
  public final String bNT()
  {
    return "video";
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.q
 * JD-Core Version:    0.7.0.1
 */