package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import java.util.HashMap;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiAppBindGroup;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class b
  extends a
{
  public static final b Epk;
  
  static
  {
    AppMethodBeat.i(207630);
    Epk = new b();
    AppMethodBeat.o(207630);
  }
  
  public final boolean a(final d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    c.b localb = null;
    AppMethodBeat.i(207629);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    Object localObject2 = paraml.xaW.get("url");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    localObject1 = (String)localObject1;
    localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.i("MicroMsg.JsApiAppBindGroup.", "url is null");
      paramd.Dyx.i(paraml.DNz, "bindGroup:fail", null);
      AppMethodBeat.o(207629);
      return true;
    }
    String str1 = paramd.Dyx.aGD((String)localObject1);
    localObject1 = (CharSequence)str1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      ad.i("MicroMsg.JsApiAppBindGroup.", "appId is null");
      paramd.Dyx.i(paraml.DNz, "bindGroup:fail", null);
      AppMethodBeat.o(207629);
      return true;
    }
    localObject2 = paraml.xaW.get("signature");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    String str2 = (String)localObject1;
    localObject2 = paraml.xaW.get("groupId");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    localObject2 = (String)localObject1;
    localObject1 = paraml.xaW.get("nonceStr");
    if (!(localObject1 instanceof String)) {
      localObject1 = localb;
    }
    for (;;)
    {
      localObject1 = (String)localObject1;
      localb = new c.b();
      localb.appId = str1;
      localb.signature = str2;
      localb.vJO = ((String)localObject2);
      localb.vJP = ((String)localObject1);
      ((c)g.ab(c.class)).a(paramd.context, localb, (c.a)new a((String)localObject2, paramd, paraml));
      AppMethodBeat.o(207629);
      return true;
    }
  }
  
  public final int eOL()
  {
    return 376;
  }
  
  public final String eOM()
  {
    return "bindGroup";
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "success", "", "errorMsg", "", "groupOpenId", "onDealEnd"})
  static final class a
    implements c.a
  {
    a(String paramString, d paramd, com.tencent.mm.plugin.webview.c.l paraml) {}
    
    public final void a(boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(207628);
      if (paramBoolean)
      {
        localObject1 = (CharSequence)paramString2;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          ad.i("MicroMsg.JsApiAppBindGroup.", "success:" + this.Epl);
          paramString1 = new HashMap();
          ((Map)paramString1).put("openId", paramString2);
          paramString2 = paramd.Dyx;
          localObject1 = paraml.DNz;
          localObject2 = new StringBuilder();
          b localb = b.Epk;
          paramString2.i((String)localObject1, "bindGroup:success", (Map)paramString1);
          AppMethodBeat.o(207628);
          return;
        }
      }
      ad.i("MicroMsg.JsApiAppBindGroup.", "fail:".concat(String.valueOf(paramString1)));
      paramString1 = paramd.Dyx;
      paramString2 = paraml.DNz;
      Object localObject1 = new StringBuilder();
      Object localObject2 = b.Epk;
      paramString1.i(paramString2, "bindGroup:fail", null);
      AppMethodBeat.o(207628);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.b
 * JD-Core Version:    0.7.0.1
 */