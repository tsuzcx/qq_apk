package com.tencent.mm.plugin.webview.ui.tools.c;

import com.tencent.luggage.k.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import d.g.b.k;
import java.util.Map;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleVideoAction;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/BasePluginJsApi;", "()V", "TAG", "", "actionInsertSameLayerVideo", "actionOperateSameLayerVideo", "actionRemoveSameLayerVideo", "actionUpdateSameLayerVideo", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "getPluginType", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class h
  extends a
{
  private static final int Bpa = 371;
  public static final h BtA;
  private static final String dAn = "handleVideoAction";
  
  static
  {
    AppMethodBeat.i(188935);
    BtA = new h();
    Bpa = 371;
    dAn = "handleVideoAction";
    AppMethodBeat.o(188935);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    boolean bool = false;
    AppMethodBeat.i(188934);
    k.h(paramd, "env");
    k.h(paraml, "msg");
    Object localObject1 = (String)paraml.uLu.get("action");
    ad.i("MicroMsg.JsApiHandleVideoAction", "HandleVideoAction action=%s", new Object[] { localObject1 });
    if (bt.isNullOrNil((String)localObject1))
    {
      paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail action is empty", null);
      AppMethodBeat.o(188934);
      return true;
    }
    if ((k.g("insertSameLayerVideo", localObject1)) || (k.g("updateSameLayerVideo", localObject1)) || (k.g("operateSameLayerVideo", localObject1)) || (k.g("removeSameLayerVideo", localObject1)))
    {
      if (!x.eAY())
      {
        ad.e("MicroMsg.JsApiHandleVideoAction", "handleVideoAction not useSameLayerForVideo");
        paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail not support", null);
        AppMethodBeat.o(188934);
        return true;
      }
      k.h(paramd, "env");
      k.h(paraml, "msg");
      Object localObject2 = paraml.ASh;
      if ((localObject2 == null) || (!((JSONObject)localObject2).has("viewId")))
      {
        ad.w(this.TAG, "no viewId in data");
        paramd.ARd.h(paraml.ASg, paraml.kbU + "fail:no viewId in data", null);
      }
      for (;;)
      {
        if ((k.g("removeSameLayerVideo", localObject1)) && (paraml.ASh != null) && (paraml.ASh.has("viewId")))
        {
          paramd = a(paramd);
          if (paramd != null) {
            paramd.m("video", paraml.ASh.optInt("viewId"));
          }
        }
        AppMethodBeat.o(188934);
        return bool;
        c localc = a.a(paramd);
        if (localc == null)
        {
          ad.w(this.TAG, "webview has no plugin client");
          paramd.ARd.h(paraml.ASg, paraml.kbU + "fail:webview has no plugin client", null);
        }
        else
        {
          int i = ((JSONObject)localObject2).optInt("viewId");
          localObject2 = new com.tencent.mm.plugin.webview.ui.tools.d.a.f(paramd, paraml);
          localc.a(aVV(), i, (com.tencent.luggage.k.a.a)localObject2);
          bool = true;
        }
      }
    }
    if (k.g("supportIFrameSameLayer", localObject1))
    {
      localObject1 = paramd.ARe;
      if (localObject1 != null)
      {
        localObject1 = Boolean.valueOf(((MMWebView)localObject1).isXWalkKernel());
        if ((!((Boolean)localObject1).booleanValue()) || (!XWalkEnvironment.isCurrentVersionSupportNativeView())) {
          break label526;
        }
        paramd.ARd.h(paraml.ASg, paraml.kbU + ":ok", null);
      }
      for (;;)
      {
        AppMethodBeat.o(188934);
        return true;
        localObject1 = null;
        break;
        label526:
        paramd.ARd.h(paraml.ASg, paraml.kbU + ":fail", null);
      }
    }
    AppMethodBeat.o(188934);
    return false;
  }
  
  public final String aVV()
  {
    return "video";
  }
  
  public final int ekB()
  {
    return Bpa;
  }
  
  public final String ekC()
  {
    return dAn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c.h
 * JD-Core Version:    0.7.0.1
 */