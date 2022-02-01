package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiAppJoinGroup;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  public static final c XmK;
  
  static
  {
    AppMethodBeat.i(297860);
    XmK = new c();
    AppMethodBeat.o(297860);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(297868);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Object localObject1 = paramp.params.get("url");
    if ((localObject1 instanceof String))
    {
      localObject1 = (String)localObject1;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label114;
      }
    }
    label114:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label119;
      }
      Log.i("MicroMsg.JsApiAppJoinGroup.", "url is null");
      paramh.WDy.doCallback(paramp.WEH, s.X("joinGroup", ":fail"), null);
      AppMethodBeat.o(297868);
      return true;
      localObject1 = null;
      break;
    }
    label119:
    if ((paramh.WDy instanceof j))
    {
      localObject1 = ((j)paramh.WDy).bjJ((String)localObject1);
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label212;
      }
    }
    label212:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label217;
      }
      Log.i("MicroMsg.JsApiAppJoinGroup.", "appId is null");
      paramh.WDy.doCallback(paramp.WEH, s.X("joinGroup", ":fail"), null);
      AppMethodBeat.o(297868);
      return true;
      localObject1 = null;
      break;
    }
    label217:
    Object localObject2 = paramp.params.get("signature");
    Object localObject3;
    if ((localObject2 instanceof String))
    {
      localObject2 = (String)localObject2;
      localObject3 = paramp.params.get("groupId");
      if (!(localObject3 instanceof String)) {
        break label391;
      }
      localObject3 = (String)localObject3;
      label273:
      localObject4 = paramp.params.get("nonceStr");
      if (!(localObject4 instanceof String)) {
        break label397;
      }
    }
    label391:
    label397:
    for (Object localObject4 = (String)localObject4;; localObject4 = null)
    {
      e.b localb = new e.b();
      localb.appId = ((String)localObject1);
      localb.signature = ((String)localObject2);
      localb.KQX = ((String)localObject3);
      localb.KQY = ((String)localObject4);
      ((com.tencent.mm.plugin.messenger.foundation.a.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.e.class)).a(paramh.context, localb);
      paramh.WDy.doCallback(paramp.WEH, s.X("joinGroup", ":success"), null);
      AppMethodBeat.o(297868);
      return true;
      localObject2 = null;
      break;
      localObject3 = null;
      break label273;
    }
  }
  
  public final String gPX()
  {
    return "joinGroup";
  }
  
  public final int gPZ()
  {
    return 377;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.c
 * JD-Core Version:    0.7.0.1
 */