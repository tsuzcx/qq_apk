package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiGetAdIdInfo;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "hostList", "", "kotlin.jvm.PlatformType", "getHostList", "()Ljava/util/List;", "hostList$delegate", "Lkotlin/Lazy;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "plugin-webview_release"})
public final class h
  extends com.tencent.mm.plugin.webview.d.c.a
{
  private static final int CDJ = 375;
  private static final kotlin.f Jxh;
  public static final h Jxi;
  private static final String edq = "getAdIdInfo";
  
  static
  {
    AppMethodBeat.i(210593);
    Jxi = new h();
    CDJ = 375;
    edq = "getAdIdInfo";
    Jxh = g.ah((kotlin.g.a.a)b.Jxj);
    AppMethodBeat.o(210593);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, final n paramn)
  {
    AppMethodBeat.i(210592);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    if ((paramn.IRs == null) || (Util.isNullOrNil(paramn.IRs.getString("name"))))
    {
      try
      {
        Object localObject1 = paramn.params.get("url");
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(210592);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.JsApiGetAdIdInfo", "getAdIdInfo ex " + localException.getMessage());
        paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail", null);
        AppMethodBeat.o(210592);
        return false;
      }
      Object localObject2 = Uri.parse((String)localException);
      p.g(localObject2, "Uri.parse(url)");
      localObject2 = ((Uri)localObject2).getHost();
      if ((Util.isNullOrNil((String)localObject2)) || (!((List)Jxh.getValue()).contains(localObject2)))
      {
        Log.w("MicroMsg.JsApiGetAdIdInfo", "getAdIdInfo but not valid host ".concat(String.valueOf(localObject2)));
        paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail invalid host", null);
        AppMethodBeat.o(210592);
        return false;
      }
    }
    d.i((kotlin.g.a.a)new a(paramf, paramn));
    AppMethodBeat.o(210592);
    return true;
  }
  
  public final int ePA()
  {
    return CDJ;
  }
  
  public final String ePz()
  {
    return edq;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(com.tencent.mm.plugin.webview.d.f paramf, n paramn)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<List<? extends String>>
  {
    public static final b Jxj;
    
    static
    {
      AppMethodBeat.i(210591);
      Jxj = new b();
      AppMethodBeat.o(210591);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.h
 * JD-Core Version:    0.7.0.1
 */