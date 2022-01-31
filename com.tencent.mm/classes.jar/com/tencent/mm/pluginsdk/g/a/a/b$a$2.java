package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class b$a$2
  implements bx.a
{
  b$a$2(b.a parama) {}
  
  public final void a(e.a parama)
  {
    parama = aa.a(parama.dBs.svH);
    if (bk.bl(parama)) {
      y.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
    }
    label172:
    label180:
    for (;;)
    {
      return;
      y.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n" + parama);
      if (!bk.bl(parama))
      {
        Map localMap = bn.s(parama, "sysmsg");
        j.s(0L, 0L);
        if (localMap == null)
        {
          parama = "null";
          y.i("MicroMsg.CheckResUpdateNewXmlParser", "parsed values.size = %s", new Object[] { parama });
          if (localMap != null) {
            break label172;
          }
          j.s(0L, 30L);
        }
        for (;;)
        {
          if ((localMap == null) || (localMap.size() <= 0) || (!bk.pm((String)localMap.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr"))) {
            break label180;
          }
          e.j(".sysmsg", "delete", localMap);
          e.j(".sysmsg", "cache", localMap);
          e.j(".sysmsg", "decrypt", localMap);
          return;
          parama = String.valueOf(localMap.size());
          break;
          j.s(0L, 31L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b.a.2
 * JD-Core Version:    0.7.0.1
 */