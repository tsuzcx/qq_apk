package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiAppJoinGroup;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class c
  extends a
{
  public static final c EHr;
  
  static
  {
    AppMethodBeat.i(199390);
    EHr = new c();
    AppMethodBeat.o(199390);
  }
  
  public final boolean a(d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199389);
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
      ae.i("MicroMsg.JsApiAppJoinGroup.", "url is null");
      paramd.DQe.i(paraml.Efy, "joinGroup:fail", null);
      AppMethodBeat.o(199389);
      return true;
    }
    String str1 = paramd.DQe.aHX((String)localObject1);
    localObject1 = (CharSequence)str1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      ae.i("MicroMsg.JsApiAppJoinGroup.", "appId is null");
      paramd.DQe.i(paraml.Efy, "joinGroup:fail", null);
      AppMethodBeat.o(199389);
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
    String str3 = (String)localObject1;
    localObject2 = paraml.xqN.get("nonceStr");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    localObject1 = (String)localObject1;
    localObject2 = new c.b();
    ((c.b)localObject2).appId = str1;
    ((c.b)localObject2).signature = str2;
    ((c.b)localObject2).vVS = str3;
    ((c.b)localObject2).vVT = ((String)localObject1);
    ((com.tencent.mm.plugin.messenger.foundation.a.c)g.ab(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(paramd.context, (c.b)localObject2);
    paramd.DQe.i(paraml.Efy, "joinGroup:success", null);
    AppMethodBeat.o(199389);
    return true;
  }
  
  public final int eSw()
  {
    return 377;
  }
  
  public final String eSx()
  {
    return "joinGroup";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.c
 * JD-Core Version:    0.7.0.1
 */