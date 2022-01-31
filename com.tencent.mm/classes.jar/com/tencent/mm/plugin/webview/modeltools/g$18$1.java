package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class g$18$1
  implements Runnable
{
  g$18$1(g.18 param18, String paramString, k paramk) {}
  
  public final void run()
  {
    y.d("MicroMsg.SubCoreTools", "webview hijack sysMsgListener");
    Map localMap = bn.s(this.fEp, "sysmsg");
    long l = bk.getLong((String)localMap.get(".sysmsg.hijackconfig.expiretime"), 9223372036854775807L);
    String str1 = ".sysmsg.hijackconfig.domainlist.domain";
    int i = 0;
    if (i > 0) {
      str1 = ".sysmsg.hijackconfig.domainlist.domain" + i;
    }
    for (;;)
    {
      i += 1;
      String str2 = (String)localMap.get(str1);
      if (!bk.bl(str2))
      {
        i locali = new i();
        locali.field_expireTime = l;
        locali.field_host = str2;
        this.riF.b(locali);
        break;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g.18.1
 * JD-Core Version:    0.7.0.1
 */