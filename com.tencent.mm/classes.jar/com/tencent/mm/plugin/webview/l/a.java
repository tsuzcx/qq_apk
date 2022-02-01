package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import kotlin.g.b.p;
import kotlin.l;
import org.apache.commons.b.f;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"htmlEncode", "", "kotlin.jvm.PlatformType", "toJsString", "webview-sdk_release"})
public final class a
{
  public static final String bbs(String paramString)
  {
    AppMethodBeat.i(82770);
    p.h(paramString, "$this$toJsString");
    paramString = "'" + f.bve(paramString) + '\'';
    AppMethodBeat.o(82770);
    return paramString;
  }
  
  public static final String htmlEncode(String paramString)
  {
    AppMethodBeat.i(82769);
    p.h(paramString, "$this$htmlEncode");
    paramString = q.encode(paramString, "UTF-8");
    AppMethodBeat.o(82769);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.a
 * JD-Core Version:    0.7.0.1
 */