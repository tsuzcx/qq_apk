package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSetClipboardData;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "controlByte", "", "getControlByte", "()I", "funcName", "", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private static final int OOk;
  public static final ai XnY;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297518);
    XnY = new ai();
    OOk = 403;
    idA = "setClipboardData";
    AppMethodBeat.o(297518);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297546);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Object localObject1 = paramp.params.get("data");
    Object localObject2;
    if ((localObject1 instanceof String))
    {
      localObject1 = (String)localObject1;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = paramp.params.get("htmlText");
      if (!(localObject1 instanceof String)) {
        break label150;
      }
      localObject1 = (String)localObject1;
      label76:
      if (localObject1 != null) {
        break label155;
      }
      localObject1 = "";
    }
    label150:
    label155:
    for (;;)
    {
      ClipboardHelper.setText(paramh.context, (CharSequence)"text", (CharSequence)localObject2, (String)localObject1);
      d.uiThread((kotlin.g.a.a)new a(paramh));
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
      AppMethodBeat.o(297546);
      return true;
      localObject1 = null;
      break;
      localObject1 = null;
      break label76;
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.ai
 * JD-Core Version:    0.7.0.1
 */