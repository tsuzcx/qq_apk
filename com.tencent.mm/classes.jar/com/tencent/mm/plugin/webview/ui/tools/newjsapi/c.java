package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiAppJoinGroup;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class c
  extends a
{
  public static final c JwY;
  
  static
  {
    AppMethodBeat.i(210582);
    JwY = new c();
    AppMethodBeat.o(210582);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(210581);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    Object localObject2 = paramn.params.get("url");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    localObject1 = (String)localObject1;
    localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.JsApiAppJoinGroup.", "url is null");
      paramf.IQZ.h(paramn.ISe, "joinGroup:fail", null);
      AppMethodBeat.o(210581);
      return true;
    }
    String str1 = paramf.IQZ.aXZ((String)localObject1);
    localObject1 = (CharSequence)str1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.JsApiAppJoinGroup.", "appId is null");
      paramf.IQZ.h(paramn.ISe, "joinGroup:fail", null);
      AppMethodBeat.o(210581);
      return true;
    }
    localObject2 = paramn.params.get("signature");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    String str2 = (String)localObject1;
    localObject2 = paramn.params.get("groupId");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    String str3 = (String)localObject1;
    localObject2 = paramn.params.get("nonceStr");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    localObject1 = (String)localObject1;
    localObject2 = new c.b();
    ((c.b)localObject2).appId = str1;
    ((c.b)localObject2).signature = str2;
    ((c.b)localObject2).zpX = str3;
    ((c.b)localObject2).zpY = ((String)localObject1);
    ((com.tencent.mm.plugin.messenger.foundation.a.c)g.af(com.tencent.mm.plugin.messenger.foundation.a.c.class)).a(paramf.context, (c.b)localObject2);
    paramf.IQZ.h(paramn.ISe, "joinGroup:success", null);
    AppMethodBeat.o(210581);
    return true;
  }
  
  public final int ePA()
  {
    return 377;
  }
  
  public final String ePz()
  {
    return "joinGroup";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.c
 * JD-Core Version:    0.7.0.1
 */