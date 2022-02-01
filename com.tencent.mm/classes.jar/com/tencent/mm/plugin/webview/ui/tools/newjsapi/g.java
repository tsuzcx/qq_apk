package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.waid.b;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.g.b.q;
import d.v;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetAdIdInfo;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "hostList", "", "getHostList", "()Ljava/util/List;", "hostList$delegate", "Lkotlin/Lazy;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class g
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int ECX = 375;
  public static final g EHA;
  private static final d.f EHz;
  private static final String dLB = "getAdIdInfo";
  
  static
  {
    AppMethodBeat.i(199398);
    EHA = new g();
    ECX = 375;
    dLB = "getAdIdInfo";
    EHz = d.g.O((d.g.a.a)a.EHB);
    AppMethodBeat.o(199398);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199397);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    if ((paraml.EeL == null) || (bu.isNullOrNil(paraml.EeL.getString("name"))))
    {
      try
      {
        Object localObject1 = paraml.xqN.get("url");
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(199397);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        ae.w("MicroMsg.JsApiGetAdIdInfo", "getAdIdInfo ex " + localException1.getMessage());
        paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail", null);
        AppMethodBeat.o(199397);
        return false;
      }
      localObject2 = Uri.parse((String)localException1);
      p.g(localObject2, "Uri.parse(url)");
      localObject2 = ((Uri)localObject2).getHost();
      if (!((List)EHz.getValue()).contains(localObject2))
      {
        ae.w("MicroMsg.JsApiGetAdIdInfo", "getAdIdInfo but not valid host ".concat(String.valueOf(localObject2)));
        paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail invalid host", null);
        AppMethodBeat.o(199397);
        return false;
      }
    }
    Map localMap = (Map)new HashMap();
    Object localObject2 = com.tencent.mm.plugin.sns.ad.a.a.dUD();
    p.g(localObject2, "AdDeviceInfo.getImeiWx()");
    localMap.put("imei", localObject2);
    String str;
    if (com.tencent.mm.plugin.sns.ad.f.a.dVz())
    {
      str = com.tencent.mm.plugin.sns.ad.a.a.aaL();
      localObject2 = str;
      if (bu.isNullOrNil(str))
      {
        localObject2 = str;
        if (paramd.lzT == null) {}
      }
    }
    try
    {
      localObject2 = paramd.lzT;
      if (localObject2 == null) {
        p.gkB();
      }
      localObject2 = ((e)localObject2).k(112, new Bundle()).getString("oaid", "");
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ae.e("MicroMsg.JsApiGetAdIdInfo", "getOaid ex " + localException2.getMessage());
        localObject3 = str;
      }
      localObject3 = (String)localObject3;
      ae.i("MicroMsg.JsApiGetAdIdInfo", "waidPkg=".concat(String.valueOf(localObject3)));
      localObject3 = b.aCC((String)localObject3);
      p.g(localObject3, "WaidHelper.getAppWaid(waidPkg)");
      localMap.put("waid", localObject3);
    }
    p.g(localObject2, "oaid");
    localMap.put("oaid", localObject2);
    ae.d("MicroMsg.JsApiGetAdIdInfo", "getAdIdInfo oaid=".concat(String.valueOf(localObject2)));
    if (paraml.xqN.containsKey("waidPkg"))
    {
      localObject2 = paraml.xqN.get("waidPkg");
      if (localObject2 == null)
      {
        paramd = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(199397);
        throw paramd;
      }
    }
    for (;;)
    {
      Object localObject3 = com.tencent.mm.plugin.sns.ad.a.a.dUB();
      p.g(localObject3, "AdDeviceInfo.getAllDeviceInfo()");
      localMap.put("devIdInfo", localObject3);
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":ok", localMap);
      AppMethodBeat.o(199397);
      return true;
      ae.w("MicroMsg.JsApiGetAdIdInfo", "no waidPkg param");
    }
  }
  
  public final int eSw()
  {
    return ECX;
  }
  
  public final String eSx()
  {
    return dLB;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<List<? extends String>>
  {
    public static final a EHB;
    
    static
    {
      AppMethodBeat.i(199396);
      EHB = new a();
      AppMethodBeat.o(199396);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.g
 * JD-Core Version:    0.7.0.1
 */