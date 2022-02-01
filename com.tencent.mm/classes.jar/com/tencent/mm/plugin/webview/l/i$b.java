package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.b;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "callbackId", "", "kotlin.jvm.PlatformType", "ret", "retValue", "", "", "", "doCallback"})
final class i$b
  implements b
{
  i$b(i parami) {}
  
  public final void h(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(82936);
    Object localObject = new HashMap();
    Map localMap = (Map)localObject;
    p.g(paramString2, "ret");
    localMap.put("err_msg", paramString2);
    if (paramMap != null) {
      ((HashMap)localObject).putAll(paramMap);
    }
    paramMap = n.a.a(paramString1, (Map)localObject, false, "");
    localObject = i.JEK;
    Log.d(i.access$getTAG$cp(), "invoke callback: " + paramString2 + ", " + paramMap);
    paramString2 = this.JEL;
    localObject = new StringBuilder("WeixinWebCompt._callback(");
    p.g(paramString1, "callbackId");
    i.a(paramString2, a.bbs(paramString1) + ", " + paramMap + "['__params'])");
    AppMethodBeat.o(82936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.l.i.b
 * JD-Core Version:    0.7.0.1
 */