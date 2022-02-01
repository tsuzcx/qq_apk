package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiAppJoinGroup;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class c
  extends a
{
  public static final c Epm;
  
  static
  {
    AppMethodBeat.i(207632);
    Epm = new c();
    AppMethodBeat.o(207632);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(207631);
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
      ad.i("MicroMsg.JsApiAppJoinGroup.", "url is null");
      paramd.Dyx.i(paraml.DNz, "joinGroup:fail", null);
      AppMethodBeat.o(207631);
      return true;
    }
    String str1 = paramd.Dyx.aGD((String)localObject1);
    localObject1 = (CharSequence)str1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      ad.i("MicroMsg.JsApiAppJoinGroup.", "appId is null");
      paramd.Dyx.i(paraml.DNz, "joinGroup:fail", null);
      AppMethodBeat.o(207631);
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
    String str3 = (String)localObject1;
    localObject2 = paraml.xaW.get("nonceStr");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    localObject1 = (String)localObject1;
    localObject2 = new c.b();
    ((c.b)localObject2).appId = str1;
    ((c.b)localObject2).signature = str2;
    ((c.b)localObject2).vJO = str3;
    ((c.b)localObject2).vJP = ((String)localObject1);
    ((com.tencent.mm.plugin.messenger.foundation.a.c)g.ab(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(paramd.context, (c.b)localObject2);
    paramd.Dyx.i(paraml.DNz, "joinGroup:success", null);
    AppMethodBeat.o(207631);
    return true;
  }
  
  public final int eOL()
  {
    return 377;
  }
  
  public final String eOM()
  {
    return "joinGroup";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.c
 * JD-Core Version:    0.7.0.1
 */