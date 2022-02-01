package com.tencent.mm.plugin.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.z.a;
import java.util.Map;

final class c$5
  implements q
{
  c$5(c paramc) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(73750);
    if (paramMap != null)
    {
      paramString = (String)paramMap.get(".sysmsg.security");
      if (!bt.isNullOrNil(paramString)) {
        try
        {
          int i = bt.getInt(paramString, 0);
          g.ajC().ajl().set(al.a.IDl, Integer.valueOf(i));
          if (i != 0)
          {
            com.tencent.mm.z.c.aht().b(al.a.IDj, true);
            AppMethodBeat.o(73750);
            return;
          }
          com.tencent.mm.z.c.aht().b(al.a.IDj, false);
          AppMethodBeat.o(73750);
          return;
        }
        catch (Exception paramString)
        {
          ad.printErrStackTrace("MicroMsg.SubCoreSetting", paramString, "device protect security value is not number!", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(73750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c.5
 * JD-Core Version:    0.7.0.1
 */