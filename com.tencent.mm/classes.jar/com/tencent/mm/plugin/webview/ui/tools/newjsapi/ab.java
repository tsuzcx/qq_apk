package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.luggage.sdk.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRecordOperateUserData;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends a
{
  public static final ab XnO;
  
  static
  {
    AppMethodBeat.i(297630);
    XnO = new ab();
    AppMethodBeat.o(297630);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297641);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i("MicroMsg.JsApiRecordOperateUserData", s.X("msg:", paramp));
    for (;;)
    {
      try
      {
        localObject = paramp.params.get("datalist");
        if (!(localObject instanceof String)) {
          continue;
        }
        localObject = (String)localObject;
        if (localObject != null) {
          c.a((JSONArray)new f((String)localObject), (b)a.XnP);
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        Log.printErrStackTrace("MicroMsg.JsApiRecordOperateUserData", (Throwable)localException, null, new Object[0]);
        continue;
      }
      paramh.WDy.doCallback(paramp.WEH, s.X("recordOperateUserData", ":ok"), null);
      AppMethodBeat.o(297641);
      return true;
      localObject = null;
    }
  }
  
  public final String gPX()
  {
    return "recordOperateUserData";
  }
  
  public final int gPZ()
  {
    return 445;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<String, ah>
  {
    public static final a XnP;
    
    static
    {
      AppMethodBeat.i(297603);
      XnP = new a();
      AppMethodBeat.o(297603);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.ab
 * JD-Core Version:    0.7.0.1
 */