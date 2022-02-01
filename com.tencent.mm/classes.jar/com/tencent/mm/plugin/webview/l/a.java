package com.tencent.mm.plugin.webview.l;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.appcache.q;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.apache.commons.c.h;

@Metadata(d1={""}, d2={"cache", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "config", "Lcom/tencent/mm/json/JSONObject;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getConfig", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)Lcom/tencent/mm/json/JSONObject;", "host", "getHost", "(Ljava/lang/String;)Ljava/lang/String;", "meta", "getMeta", "pkgVersion", "getPkgVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "htmlEncode", "kotlin.jvm.PlatformType", "toJsString", "webview-sdk_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final HashMap<String, Integer> cache;
  
  static
  {
    AppMethodBeat.i(295437);
    cache = new HashMap();
    AppMethodBeat.o(295437);
  }
  
  public static final String bne(String paramString)
  {
    AppMethodBeat.i(82769);
    s.u(paramString, "<this>");
    paramString = com.tencent.mm.compatible.util.r.as(paramString, "UTF-8");
    AppMethodBeat.o(82769);
    return paramString;
  }
  
  public static final String bnf(String paramString)
  {
    AppMethodBeat.i(82770);
    s.u(paramString, "<this>");
    paramString = "'" + h.bLc(paramString) + '\'';
    AppMethodBeat.o(82770);
    return paramString;
  }
  
  public static final i f(q paramq)
  {
    AppMethodBeat.i(295423);
    s.u(paramq, "<this>");
    paramq = new i(com.tencent.mm.plugin.appbrand.appcache.r.a(paramq, "/meta.json"));
    AppMethodBeat.o(295423);
    return paramq;
  }
  
  public static final i g(q paramq)
  {
    AppMethodBeat.i(295428);
    s.u(paramq, "<this>");
    paramq = new i(com.tencent.mm.plugin.appbrand.appcache.r.a(paramq, "/config.json"));
    AppMethodBeat.o(295428);
    return paramq;
  }
  
  public static final String getHost(String paramString)
  {
    AppMethodBeat.i(295408);
    s.u(paramString, "<this>");
    try
    {
      String str = Uri.parse(paramString).getHost();
      paramString = str;
      if (str == null) {
        paramString = "unknow";
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = "unknow";
      }
    }
    AppMethodBeat.o(295408);
    return paramString;
  }
  
  public static final int h(q paramq)
  {
    AppMethodBeat.i(295431);
    s.u(paramq, "<this>");
    Integer localInteger2 = (Integer)cache.get(paramq.cfJ());
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(f(paramq).optInt("version"));
    }
    int i = ((Number)localInteger1).intValue();
    AppMethodBeat.o(295431);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.a
 * JD-Core Version:    0.7.0.1
 */