package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.luggage.xweb_ext.extendplugin.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import d.g.b.p;
import java.util.Map;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleVideoAction;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/BasePluginJsApi;", "()V", "TAG", "", "actionInsertSameLayerVideo", "actionOperateSameLayerVideo", "actionRemoveSameLayerVideo", "actionUpdateSameLayerVideo", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "getPluginType", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class m
  extends a
{
  private static final int EkT = 371;
  public static final m EpF;
  private static final String dKm = "handleVideoAction";
  
  static
  {
    AppMethodBeat.i(207659);
    EpF = new m();
    EkT = 371;
    dKm = "handleVideoAction";
    AppMethodBeat.o(207659);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    boolean bool = false;
    AppMethodBeat.i(207658);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    Object localObject1 = (String)paraml.xaW.get("action");
    ad.i("MicroMsg.JsApiHandleVideoAction", "HandleVideoAction action=%s", new Object[] { localObject1 });
    if (bt.isNullOrNil((String)localObject1))
    {
      paramd.Dyx.i(paraml.DNz, paraml.kYO + ":fail action is empty", null);
      AppMethodBeat.o(207658);
      return true;
    }
    if ((p.i("insertSameLayerVideo", localObject1)) || (p.i("updateSameLayerVideo", localObject1)) || (p.i("operateSameLayerVideo", localObject1)) || (p.i("removeSameLayerVideo", localObject1)))
    {
      if (!x.ffu())
      {
        ad.e("MicroMsg.JsApiHandleVideoAction", "handleVideoAction not useSameLayerForVideo");
        paramd.Dyx.i(paraml.DNz, paraml.kYO + ":fail not support", null);
        AppMethodBeat.o(207658);
        return true;
      }
      p.h(paramd, "env");
      p.h(paraml, "msg");
      Object localObject2 = paraml.DNA;
      if ((localObject2 == null) || (!((JSONObject)localObject2).has("viewId")))
      {
        ad.w(this.TAG, "no viewId in data");
        paramd.Dyx.i(paraml.DNz, paraml.kYO + "fail:no viewId in data", null);
      }
      for (;;)
      {
        if ((p.i("removeSameLayerVideo", localObject1)) && (paraml.DNA != null) && (paraml.DNA.has("viewId")))
        {
          paramd = a(paramd);
          if (paramd != null) {
            paramd.o("video", paraml.DNA.optInt("viewId"));
          }
        }
        AppMethodBeat.o(207658);
        return bool;
        c localc = a.a(paramd);
        if (localc == null)
        {
          ad.w(this.TAG, "webview has no plugin client");
          paramd.Dyx.i(paraml.DNz, paraml.kYO + "fail:webview has no plugin client", null);
        }
        else
        {
          int i = ((JSONObject)localObject2).optInt("viewId");
          localObject2 = new com.tencent.mm.plugin.webview.ui.tools.video.samelayer.f(paramd, paraml);
          localc.a(bgx(), i, (com.tencent.luggage.xweb_ext.extendplugin.a)localObject2);
          bool = true;
        }
      }
    }
    if (p.i("supportIFrameSameLayer", localObject1))
    {
      localObject1 = paramd.DMv;
      if (localObject1 == null) {
        p.gfZ();
      }
      if ((((MMWebView)localObject1).isXWalkKernel()) && (XWalkEnvironment.isCurrentVersionSupportNativeView())) {
        paramd.Dyx.i(paraml.DNz, paraml.kYO + ":ok", null);
      }
      for (;;)
      {
        AppMethodBeat.o(207658);
        return true;
        paramd.Dyx.i(paraml.DNz, paraml.kYO + ":fail", null);
      }
    }
    AppMethodBeat.o(207658);
    return false;
  }
  
  public final String bgx()
  {
    return "video";
  }
  
  public final int eOL()
  {
    return EkT;
  }
  
  public final String eOM()
  {
    return dKm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.m
 * JD-Core Version:    0.7.0.1
 */