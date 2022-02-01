package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiAppBindGroup;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class b
  extends a
{
  public static final b QuL;
  
  static
  {
    AppMethodBeat.i(264382);
    QuL = new b();
    AppMethodBeat.o(264382);
  }
  
  public final boolean a(final f paramf, final n paramn)
  {
    e.b localb = null;
    AppMethodBeat.i(264381);
    p.k(paramf, "env");
    p.k(paramn, "msg");
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
      Log.i("MicroMsg.JsApiAppBindGroup.", "url is null");
      paramf.PNo.h(paramn.POu, "bindGroup:fail", null);
      AppMethodBeat.o(264381);
      return true;
    }
    String str1 = paramf.PNo.bjW((String)localObject1);
    localObject1 = (CharSequence)str1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.JsApiAppBindGroup.", "appId is null");
      paramf.PNo.h(paramn.POu, "bindGroup:fail", null);
      AppMethodBeat.o(264381);
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
    localObject2 = (String)localObject1;
    localObject1 = paramn.params.get("nonceStr");
    if (!(localObject1 instanceof String)) {
      localObject1 = localb;
    }
    for (;;)
    {
      localObject1 = (String)localObject1;
      localb = new e.b();
      localb.appId = str1;
      localb.signature = str2;
      localb.EVw = ((String)localObject2);
      localb.EVx = ((String)localObject1);
      ((e)com.tencent.mm.kernel.h.ae(e.class)).a(paramf.context, localb, (e.a)new a((String)localObject2, paramf, paramn));
      AppMethodBeat.o(264381);
      return true;
    }
  }
  
  public final String fCm()
  {
    return "bindGroup";
  }
  
  public final int fCn()
  {
    return 376;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "errorMsg", "", "groupOpenId", "onDealEnd"})
  static final class a
    implements e.a
  {
    a(String paramString, f paramf, n paramn) {}
    
    public final void a(boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(262875);
      if (paramBoolean)
      {
        localObject1 = (CharSequence)paramString2;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          Log.i("MicroMsg.JsApiAppBindGroup.", "success:" + this.QuM);
          paramString1 = new HashMap();
          ((Map)paramString1).put("openId", paramString2);
          paramString2 = paramf.PNo;
          localObject1 = paramn.POu;
          localObject2 = new StringBuilder();
          b localb = b.QuL;
          paramString2.h((String)localObject1, "bindGroup:success", (Map)paramString1);
          AppMethodBeat.o(262875);
          return;
        }
      }
      Log.i("MicroMsg.JsApiAppBindGroup.", "fail:".concat(String.valueOf(paramString1)));
      paramString1 = paramf.PNo;
      paramString2 = paramn.POu;
      Object localObject1 = new StringBuilder();
      Object localObject2 = b.QuL;
      paramString1.h(paramString2, "bindGroup:fail", null);
      AppMethodBeat.o(262875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.b
 * JD-Core Version:    0.7.0.1
 */