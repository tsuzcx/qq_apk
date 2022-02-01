package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.waid.b;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.g.b.q;
import d.v;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetAdIdInfo;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "hostList", "", "getHostList", "()Ljava/util/List;", "hostList$delegate", "Lkotlin/Lazy;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class g
  extends com.tencent.mm.plugin.webview.c.c.a
{
  private static final int EkT = 375;
  private static final d.f Epr;
  public static final g Eps;
  private static final String dKm = "getAdIdInfo";
  
  static
  {
    AppMethodBeat.i(207639);
    Eps = new g();
    EkT = 375;
    dKm = "getAdIdInfo";
    Epr = d.g.O((d.g.a.a)a.Ept);
    AppMethodBeat.o(207639);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(207638);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    if ((paraml.DMM == null) || (bt.isNullOrNil(paraml.DMM.getString("name"))))
    {
      try
      {
        Object localObject1 = paraml.xaW.get("url");
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(207638);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        ad.w("MicroMsg.JsApiGetAdIdInfo", "getAdIdInfo ex " + localException1.getMessage());
        paramd.Dyx.i(paraml.DNz, paraml.kYO + ":fail", null);
        AppMethodBeat.o(207638);
        return false;
      }
      localObject2 = Uri.parse((String)localException1);
      p.g(localObject2, "Uri.parse(url)");
      localObject2 = ((Uri)localObject2).getHost();
      if (!((List)Epr.getValue()).contains(localObject2))
      {
        ad.w("MicroMsg.JsApiGetAdIdInfo", "getAdIdInfo but not valid host ".concat(String.valueOf(localObject2)));
        paramd.Dyx.i(paraml.DNz, paraml.kYO + ":fail invalid host", null);
        AppMethodBeat.o(207638);
        return false;
      }
    }
    Map localMap = (Map)new HashMap();
    Object localObject2 = com.tencent.mm.plugin.sns.ad.a.a.ftk();
    p.g(localObject2, "AdDeviceInfo.getImeiWx()");
    localMap.put("imei", localObject2);
    String str;
    if (com.tencent.mm.plugin.sns.ad.e.e.ftm())
    {
      str = com.tencent.mm.plugin.sns.ad.a.a.aaC();
      localObject2 = str;
      if (bt.isNullOrNil(str))
      {
        localObject2 = str;
        if (paramd.lvv == null) {}
      }
    }
    try
    {
      localObject2 = paramd.lvv;
      if (localObject2 == null) {
        p.gfZ();
      }
      localObject2 = ((com.tencent.mm.plugin.webview.stub.e)localObject2).k(112, new Bundle()).getString("oaid", "");
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiGetAdIdInfo", "getOaid ex " + localException2.getMessage());
        localObject3 = str;
      }
      localObject3 = (String)localObject3;
      ad.i("MicroMsg.JsApiGetAdIdInfo", "waidPkg=".concat(String.valueOf(localObject3)));
      localObject3 = b.aBl((String)localObject3);
      p.g(localObject3, "WaidHelper.getAppWaid(waidPkg)");
      localMap.put("waid", localObject3);
    }
    p.g(localObject2, "oaid");
    localMap.put("oaid", localObject2);
    ad.d("MicroMsg.JsApiGetAdIdInfo", "getAdIdInfo oaid=".concat(String.valueOf(localObject2)));
    if (paraml.xaW.containsKey("waidPkg"))
    {
      localObject2 = paraml.xaW.get("waidPkg");
      if (localObject2 == null)
      {
        paramd = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(207638);
        throw paramd;
      }
    }
    for (;;)
    {
      Object localObject3 = com.tencent.mm.plugin.sns.ad.a.a.dRf();
      p.g(localObject3, "AdDeviceInfo.getAllDeviceInfo()");
      localMap.put("devIdInfo", localObject3);
      paramd.Dyx.i(paraml.DNz, paraml.kYO + ":ok", localMap);
      AppMethodBeat.o(207638);
      return true;
      ad.w("MicroMsg.JsApiGetAdIdInfo", "no waidPkg param");
    }
  }
  
  public final int eOL()
  {
    return EkT;
  }
  
  public final String eOM()
  {
    return dKm;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<List<? extends String>>
  {
    public static final a Ept;
    
    static
    {
      AppMethodBeat.i(207637);
      Ept = new a();
      AppMethodBeat.o(207637);
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