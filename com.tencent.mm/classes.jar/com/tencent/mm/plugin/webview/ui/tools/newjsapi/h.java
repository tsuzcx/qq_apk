package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.luggage.k.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMWebView;
import d.g.b.k;
import java.util.Map;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleVideoAction;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/BasePluginJsApi;", "()V", "TAG", "", "actionInsertSameLayerVideo", "actionOperateSameLayerVideo", "actionRemoveSameLayerVideo", "actionUpdateSameLayerVideo", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "getPluginType", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class h
  extends a
{
  private static final int CHh = 371;
  public static final h CLH;
  private static final String dxZ = "handleVideoAction";
  
  static
  {
    AppMethodBeat.i(189505);
    CLH = new h();
    CHh = 371;
    dxZ = "handleVideoAction";
    AppMethodBeat.o(189505);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    boolean bool = false;
    AppMethodBeat.i(189504);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    Object localObject1 = (String)paraml.vUl.get("action");
    ac.i("MicroMsg.JsApiHandleVideoAction", "HandleVideoAction action=%s", new Object[] { localObject1 });
    if (bs.isNullOrNil((String)localObject1))
    {
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail action is empty", null);
      AppMethodBeat.o(189504);
      return true;
    }
    if ((k.g("insertSameLayerVideo", localObject1)) || (k.g("updateSameLayerVideo", localObject1)) || (k.g("operateSameLayerVideo", localObject1)) || (k.g("removeSameLayerVideo", localObject1)))
    {
      if (!x.eQs())
      {
        ac.e("MicroMsg.JsApiHandleVideoAction", "handleVideoAction not useSameLayerForVideo");
        paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail not support", null);
        AppMethodBeat.o(189504);
        return true;
      }
      k.h(paramd, "env");
      k.h(paraml, "msg");
      Object localObject2 = paraml.Cku;
      if ((localObject2 == null) || (!((JSONObject)localObject2).has("viewId")))
      {
        ac.w(this.TAG, "no viewId in data");
        paramd.Cjq.j(paraml.Ckt, paraml.kCH + "fail:no viewId in data", null);
      }
      for (;;)
      {
        if ((k.g("removeSameLayerVideo", localObject1)) && (paraml.Cku != null) && (paraml.Cku.has("viewId")))
        {
          paramd = a(paramd);
          if (paramd != null) {
            paramd.m("video", paraml.Cku.optInt("viewId"));
          }
        }
        AppMethodBeat.o(189504);
        return bool;
        c localc = a.a(paramd);
        if (localc == null)
        {
          ac.w(this.TAG, "webview has no plugin client");
          paramd.Cjq.j(paraml.Ckt, paraml.kCH + "fail:webview has no plugin client", null);
        }
        else
        {
          int i = ((JSONObject)localObject2).optInt("viewId");
          localObject2 = new com.tencent.mm.plugin.webview.ui.tools.c.a.f(paramd, paraml);
          localc.a(bcT(), i, (com.tencent.luggage.k.a.a)localObject2);
          bool = true;
        }
      }
    }
    if (k.g("supportIFrameSameLayer", localObject1))
    {
      localObject1 = paramd.Cjr;
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((MMWebView)localObject1).isXWalkKernel());
        if ((!((Boolean)localObject1).booleanValue()) || (!XWalkEnvironment.isCurrentVersionSupportNativeView())) {
          break label526;
        }
        paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
      }
      for (;;)
      {
        AppMethodBeat.o(189504);
        return true;
        localObject1 = null;
        break;
        label526:
        paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail", null);
      }
    }
    AppMethodBeat.o(189504);
    return false;
  }
  
  public final String bcT()
  {
    return "video";
  }
  
  public final int ezX()
  {
    return CHh;
  }
  
  public final String ezY()
  {
    return dxZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.h
 * JD-Core Version:    0.7.0.1
 */