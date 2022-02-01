package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.Map;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetAdIdInfo;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "hostList", "", "kotlin.jvm.PlatformType", "getHostList", "()Ljava/util/List;", "hostList$delegate", "Lkotlin/Lazy;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class i
  extends com.tencent.mm.plugin.webview.d.c.a
{
  private static final int IIl = 375;
  private static final kotlin.f QuZ;
  public static final i Qva;
  private static final String fXz = "getAdIdInfo";
  
  static
  {
    AppMethodBeat.i(233810);
    Qva = new i();
    IIl = 375;
    fXz = "getAdIdInfo";
    QuZ = g.ar((kotlin.g.a.a)b.Qvb);
    AppMethodBeat.o(233810);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, final n paramn)
  {
    AppMethodBeat.i(233806);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    if ((paramn.PNI == null) || (Util.isNullOrNil(paramn.PNI.getString("name"))))
    {
      try
      {
        Object localObject1 = paramn.params.get("url");
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(233806);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.JsApiGetAdIdInfo", "getAdIdInfo ex " + localException.getMessage());
        paramf.PNo.h(paramn.POu, paramn.function + ":fail", null);
        AppMethodBeat.o(233806);
        return false;
      }
      Object localObject2 = Uri.parse((String)localException);
      p.j(localObject2, "Uri.parse(url)");
      localObject2 = ((Uri)localObject2).getHost();
      if ((Util.isNullOrNil((String)localObject2)) || (!((List)QuZ.getValue()).contains(localObject2)))
      {
        Log.w("MicroMsg.JsApiGetAdIdInfo", "getAdIdInfo but not valid host ".concat(String.valueOf(localObject2)));
        paramf.PNo.h(paramn.POu, paramn.function + ":fail invalid host", null);
        AppMethodBeat.o(233806);
        return false;
      }
    }
    d.h((kotlin.g.a.a)new a(paramf, paramn));
    AppMethodBeat.o(233806);
    return true;
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(com.tencent.mm.plugin.webview.d.f paramf, n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<List<? extends String>>
  {
    public static final b Qvb;
    
    static
    {
      AppMethodBeat.i(266699);
      Qvb = new b();
      AppMethodBeat.o(266699);
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