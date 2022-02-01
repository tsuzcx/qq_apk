package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetAdIdInfo;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "hostList", "", "kotlin.jvm.PlatformType", "getHostList", "()Ljava/util/List;", "hostList$delegate", "Lkotlin/Lazy;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.tencent.mm.plugin.webview.jsapi.c.a
{
  private static final int OOk;
  public static final i XmW;
  private static final j XmX;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297862);
    XmW = new i();
    OOk = 375;
    idA = "getAdIdInfo";
    XmX = k.cm((kotlin.g.a.a)b.XmZ);
    AppMethodBeat.o(297862);
  }
  
  public final boolean a(h paramh, final p paramp)
  {
    AppMethodBeat.i(297874);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    if ((paramp.WDU == null) || (Util.isNullOrNil(paramp.WDU.getString("name"))))
    {
      try
      {
        Object localObject = paramp.params.get("url");
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(297874);
          throw ((Throwable)localObject);
        }
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.JsApiGetAdIdInfo", s.X("getAdIdInfo ex ", localException.getMessage()));
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
        AppMethodBeat.o(297874);
        return false;
      }
      String str = Uri.parse((String)localException).getHost();
      if ((Util.isNullOrNil(str)) || (!((List)XmX.getValue()).contains(str)))
      {
        Log.w("MicroMsg.JsApiGetAdIdInfo", s.X("getAdIdInfo but not valid host ", str));
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail invalid host"), null);
        AppMethodBeat.o(297874);
        return false;
      }
    }
    d.B((kotlin.g.a.a)new a(paramh, paramp));
    AppMethodBeat.o(297874);
    return true;
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
    a(h paramh, p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<List<? extends String>>
  {
    public static final b XmZ;
    
    static
    {
      AppMethodBeat.i(297878);
      XmZ = new b();
      AppMethodBeat.o(297878);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.i
 * JD-Core Version:    0.7.0.1
 */