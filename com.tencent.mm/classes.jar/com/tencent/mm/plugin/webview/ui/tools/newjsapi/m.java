package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import d.g.b.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleVideoAction;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/BasePluginJsApi;", "()V", "TAG", "", "actionInsertSameLayerVideo", "actionOperateSameLayerVideo", "actionRemoveSameLayerVideo", "actionUpdateSameLayerVideo", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "getPluginType", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class m
  extends a
{
  private static final int ECX = 371;
  public static final m EHQ;
  private static final String dLB = "handleVideoAction";
  
  static
  {
    AppMethodBeat.i(199425);
    EHQ = new m();
    ECX = 371;
    dLB = "handleVideoAction";
    AppMethodBeat.o(199425);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    boolean bool = false;
    AppMethodBeat.i(199424);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    Object localObject1 = (String)paraml.xqN.get("action");
    ae.i("MicroMsg.JsApiHandleVideoAction", "HandleVideoAction action=%s", new Object[] { localObject1 });
    if (bu.isNullOrNil((String)localObject1))
    {
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail action is empty", null);
      AppMethodBeat.o(199424);
      return true;
    }
    Object localObject3;
    if ((p.i("insertSameLayerVideo", localObject1)) || (p.i("updateSameLayerVideo", localObject1)) || (p.i("operateSameLayerVideo", localObject1)) || (p.i("removeSameLayerVideo", localObject1)))
    {
      if (!x.fjk())
      {
        ae.e("MicroMsg.JsApiHandleVideoAction", "handleVideoAction not useSameLayerForVideo");
        paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail not support", null);
        AppMethodBeat.o(199424);
        return true;
      }
      p.h(paramd, "env");
      p.h(paraml, "msg");
      localObject3 = paraml.Efz;
      if ((localObject3 == null) || (!((JSONObject)localObject3).has("viewId")))
      {
        ae.w(this.TAG, "no viewId in data");
        paramd.DQe.i(paraml.Efy, paraml.lcx + "fail:no viewId in data", null);
      }
      for (;;)
      {
        if ((p.i("removeSameLayerVideo", localObject1)) && (paraml.Efz != null) && (paraml.Efz.has("viewId")))
        {
          paramd = a(paramd);
          if (paramd != null) {
            paramd.p("video", paraml.Efz.optInt("viewId"));
          }
        }
        AppMethodBeat.o(199424);
        return bool;
        localObject2 = a.a(paramd);
        if (localObject2 == null)
        {
          ae.w(this.TAG, "webview has no plugin client");
          paramd.DQe.i(paraml.Efy, paraml.lcx + "fail:webview has no plugin client", null);
        }
        else
        {
          int i = ((JSONObject)localObject3).optInt("viewId");
          localObject3 = new com.tencent.mm.plugin.webview.ui.tools.video.samelayer.f(paramd, paraml);
          ((c)localObject2).a(bhf(), i, (com.tencent.luggage.xweb_ext.extendplugin.a)localObject3);
          bool = true;
        }
      }
    }
    if (p.i("supportIFrameSameLayer", localObject1))
    {
      localObject1 = paramd.Eet;
      if (localObject1 == null) {
        p.gkB();
      }
      if ((((MMWebView)localObject1).isXWalkKernel()) && (XWalkEnvironment.isCurrentVersionSupportNativeView())) {
        paramd.DQe.i(paraml.Efy, paraml.lcx + ":ok", null);
      }
      for (;;)
      {
        AppMethodBeat.o(199424);
        return true;
        paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail", null);
      }
    }
    Object localObject2 = com.tencent.mm.plugin.webview.ui.tools.video.a.EHX;
    if ((com.tencent.mm.plugin.webview.ui.tools.video.a.bSZ()) && (p.i("getInitialParams", localObject1)))
    {
      localObject1 = com.tencent.mm.plugin.webview.ui.tools.video.a.EHX;
      localObject3 = new HashMap();
      String str = ((ay)com.tencent.mm.plugin.webview.ui.tools.video.a.EHW.fnP()).getString("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
      if (bu.isNullOrNil(str)) {
        ae.i("MicroMsg.MPVideoPreviewDataMgr", "getInitialParams vid null");
      }
      for (localObject1 = null;; localObject1 = (Map)localObject3)
      {
        paramd.DQe.i(paraml.Efy, paraml.lcx + ":ok", (Map)localObject1);
        AppMethodBeat.o(199424);
        return true;
        Map localMap1 = com.tencent.mm.plugin.webview.ui.tools.video.a.aKT(str);
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
        ((ay)com.tencent.mm.plugin.webview.ui.tools.video.a.EHW.fnP()).encode("MicroMsg.MPVideoPreviewDataMgr_prepareOnReceivePageData_vid", "");
        ae.i("MicroMsg.MPVideoPreviewDataMgr", "getInitialParams vid = " + str + ", time = " + ((HashMap)localObject3).get("videoInitialTime"));
      }
    }
    AppMethodBeat.o(199424);
    return false;
  }
  
  public final String bhf()
  {
    return "video";
  }
  
  public final int eSw()
  {
    return ECX;
  }
  
  public final String eSx()
  {
    return dLB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.m
 * JD-Core Version:    0.7.0.1
 */