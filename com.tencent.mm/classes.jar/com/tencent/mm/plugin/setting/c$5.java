package com.tencent.mm.plugin.setting;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.y.a;
import java.util.Map;

final class c$5
  implements o
{
  c$5(c paramc) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    if (paramMap != null)
    {
      paramString = (String)paramMap.get(".sysmsg.security");
      if (!bk.bl(paramString)) {
        try
        {
          int i = bk.getInt(paramString, 0);
          g.DP().Dz().c(ac.a.uyV, Integer.valueOf(i));
          if (i != 0)
          {
            com.tencent.mm.y.c.BS().b(ac.a.uyT, true);
            return;
          }
          com.tencent.mm.y.c.BS().b(ac.a.uyT, false);
          return;
        }
        catch (Exception paramString)
        {
          y.printErrStackTrace("MicroMsg.SubCoreSetting", paramString, "device protect security value is not number!", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c.5
 * JD-Core Version:    0.7.0.1
 */