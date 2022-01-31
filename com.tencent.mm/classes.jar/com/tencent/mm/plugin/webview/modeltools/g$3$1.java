package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

final class g$3$1
  implements Runnable
{
  g$3$1(g.3 param3, String paramString, m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(153145);
    ab.d("MicroMsg.SubCoreTools", "webview hijack sysMsgListener");
    Map localMap = br.F(this.gWF, "sysmsg");
    long l = bo.getLong((String)localMap.get(".sysmsg.hijackconfig.expiretime"), 9223372036854775807L);
    String str1 = ".sysmsg.hijackconfig.domainlist.domain";
    int i = 0;
    if (i > 0) {
      str1 = ".sysmsg.hijackconfig.domainlist.domain" + i;
    }
    for (;;)
    {
      i += 1;
      String str2 = (String)localMap.get(str1);
      if (!bo.isNullOrNil(str2))
      {
        i locali = new i();
        locali.field_expireTime = l;
        locali.field_host = str2;
        this.uYe.insert(locali);
        break;
      }
      AppMethodBeat.o(153145);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g.3.1
 * JD-Core Version:    0.7.0.1
 */