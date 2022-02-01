package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import java.util.HashMap;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiAppBindGroup;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class b
  extends a
{
  public static final b EHp;
  
  static
  {
    AppMethodBeat.i(199388);
    EHp = new b();
    AppMethodBeat.o(199388);
  }
  
  public final boolean a(final d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    c.b localb = null;
    AppMethodBeat.i(199387);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    Object localObject2 = paraml.xqN.get("url");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    localObject1 = (String)localObject1;
    localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.i("MicroMsg.JsApiAppBindGroup.", "url is null");
      paramd.DQe.i(paraml.Efy, "bindGroup:fail", null);
      AppMethodBeat.o(199387);
      return true;
    }
    String str1 = paramd.DQe.aHX((String)localObject1);
    localObject1 = (CharSequence)str1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      ae.i("MicroMsg.JsApiAppBindGroup.", "appId is null");
      paramd.DQe.i(paraml.Efy, "bindGroup:fail", null);
      AppMethodBeat.o(199387);
      return true;
    }
    localObject2 = paraml.xqN.get("signature");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    String str2 = (String)localObject1;
    localObject2 = paraml.xqN.get("groupId");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    localObject2 = (String)localObject1;
    localObject1 = paraml.xqN.get("nonceStr");
    if (!(localObject1 instanceof String)) {
      localObject1 = localb;
    }
    for (;;)
    {
      localObject1 = (String)localObject1;
      localb = new c.b();
      localb.appId = str1;
      localb.signature = str2;
      localb.vVS = ((String)localObject2);
      localb.vVT = ((String)localObject1);
      ((c)g.ab(c.class)).a(paramd.context, localb, (c.a)new a((String)localObject2, paramd, paraml));
      AppMethodBeat.o(199387);
      return true;
    }
  }
  
  public final int eSw()
  {
    return 376;
  }
  
  public final String eSx()
  {
    return "bindGroup";
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "success", "", "errorMsg", "", "groupOpenId", "onDealEnd"})
  static final class a
    implements c.a
  {
    a(String paramString, d paramd, com.tencent.mm.plugin.webview.c.l paraml) {}
    
    public final void a(boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(199386);
      if (paramBoolean)
      {
        localObject1 = (CharSequence)paramString2;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          ae.i("MicroMsg.JsApiAppBindGroup.", "success:" + this.EHq);
          paramString1 = new HashMap();
          ((Map)paramString1).put("openId", paramString2);
          paramString2 = paramd.DQe;
          localObject1 = paraml.Efy;
          localObject2 = new StringBuilder();
          b localb = b.EHp;
          paramString2.i((String)localObject1, "bindGroup:success", (Map)paramString1);
          AppMethodBeat.o(199386);
          return;
        }
      }
      ae.i("MicroMsg.JsApiAppBindGroup.", "fail:".concat(String.valueOf(paramString1)));
      paramString1 = paramd.DQe;
      paramString2 = paraml.Efy;
      Object localObject1 = new StringBuilder();
      Object localObject2 = b.EHp;
      paramString1.i(paramString2, "bindGroup:fail", null);
      AppMethodBeat.o(199386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.b
 * JD-Core Version:    0.7.0.1
 */