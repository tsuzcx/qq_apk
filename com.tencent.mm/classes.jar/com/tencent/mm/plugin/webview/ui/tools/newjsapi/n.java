package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.pluginsdk.ui.tools.z;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleVideoAction;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/BasePluginJsApi;", "()V", "TAG", "", "actionInsertSameLayerVideo", "actionOperateSameLayerVideo", "actionRemoveSameLayerVideo", "actionUpdateSameLayerVideo", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "getPluginType", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class n
  extends a
{
  private static final int CDJ = 371;
  public static final n Jxy;
  private static final String edq = "handleVideoAction";
  
  static
  {
    AppMethodBeat.i(210625);
    Jxy = new n();
    CDJ = 371;
    edq = "handleVideoAction";
    AppMethodBeat.o(210625);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, com.tencent.mm.plugin.webview.d.n paramn)
  {
    boolean bool = false;
    AppMethodBeat.i(210624);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    Object localObject1 = (String)paramn.params.get("action");
    Log.i("MicroMsg.JsApiHandleVideoAction", "HandleVideoAction action=%s", new Object[] { localObject1 });
    if (Util.isNullOrNil((String)localObject1))
    {
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail action is empty", null);
      AppMethodBeat.o(210624);
      return true;
    }
    Object localObject3;
    if ((p.j("insertSameLayerVideo", localObject1)) || (p.j("updateSameLayerVideo", localObject1)) || (p.j("operateSameLayerVideo", localObject1)) || (p.j("removeSameLayerVideo", localObject1)))
    {
      if (!z.gsK())
      {
        Log.e("MicroMsg.JsApiHandleVideoAction", "handleVideoAction not useSameLayerForVideo");
        paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail not support", null);
        AppMethodBeat.o(210624);
        return true;
      }
      p.h(paramf, "env");
      p.h(paramn, "msg");
      localObject3 = paramn.ISf;
      if ((localObject3 == null) || (!((JSONObject)localObject3).has("viewId")))
      {
        Log.w(this.TAG, "no viewId in data");
        paramf.IQZ.h(paramn.ISe, paramn.mhO + "fail:no viewId in data", null);
      }
      for (;;)
      {
        if ((p.j("removeSameLayerVideo", localObject1)) && (paramn.ISf != null) && (paramn.ISf.has("viewId")))
        {
          paramf = c(paramf);
          if (paramf != null) {
            paramf.p("video", paramn.ISf.optInt("viewId"));
          }
        }
        AppMethodBeat.o(210624);
        return bool;
        localObject2 = a.c(paramf);
        if (localObject2 == null)
        {
          Log.w(this.TAG, "webview has no plugin client");
          paramf.IQZ.h(paramn.ISe, paramn.mhO + "fail:webview has no plugin client", null);
        }
        else
        {
          int i = ((JSONObject)localObject3).optInt("viewId");
          localObject3 = new com.tencent.mm.plugin.webview.ui.tools.video.samelayer.f(paramf, paramn);
          ((c)localObject2).a(bCy(), i, (com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
          bool = true;
        }
      }
    }
    if (p.j("supportIFrameSameLayer", localObject1))
    {
      localObject1 = paramf.IRa;
      if (localObject1 == null) {
        p.hyc();
      }
      if ((((MMWebView)localObject1).isXWalkKernel()) && (XWalkEnvironment.isCurrentVersionSupportNativeView())) {
        paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", null);
      }
      for (;;)
      {
        AppMethodBeat.o(210624);
        return true;
        paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail", null);
      }
    }
    Object localObject2 = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
    if ((com.tencent.mm.plugin.webview.ui.tools.video.a.gic()) && (p.j("getInitialParams", localObject1)))
    {
      localObject1 = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
      localObject3 = new HashMap();
      String str = ((MultiProcessMMKV)com.tencent.mm.plugin.webview.ui.tools.video.a.JxM.getSlot()).getString("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
      if (Util.isNullOrNil(str)) {
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "getInitialParams vid null");
      }
      for (localObject1 = null;; localObject1 = (Map)localObject3)
      {
        paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", (Map)localObject1);
        AppMethodBeat.o(210624);
        return true;
        Map localMap1 = com.tencent.mm.plugin.webview.ui.tools.video.a.bbj(str);
        Map localMap2 = (Map)localObject3;
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
        localMap2 = (Map)localObject3;
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
        ((MultiProcessMMKV)com.tencent.mm.plugin.webview.ui.tools.video.a.JxM.getSlot()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
        Log.i("MicroMsg.MPVideoPreviewDataMgr", "getInitialParams vid = " + str + ", time = " + ((HashMap)localObject3).get("videoInitialTime"));
      }
    }
    AppMethodBeat.o(210624);
    return false;
  }
  
  public final String bCy()
  {
    return "video";
  }
  
  public final int ePA()
  {
    return CDJ;
  }
  
  public final String ePz()
  {
    return edq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.n
 * JD-Core Version:    0.7.0.1
 */