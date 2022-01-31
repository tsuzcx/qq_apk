package com.tencent.mm.plugin.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.x.a;
import java.util.Map;

final class c$5
  implements o
{
  c$5(c paramc) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(126829);
    if (paramMap != null)
    {
      paramString = (String)paramMap.get(".sysmsg.security");
      if (!bo.isNullOrNil(paramString)) {
        try
        {
          int i = bo.getInt(paramString, 0);
          g.RL().Ru().set(ac.a.yJJ, Integer.valueOf(i));
          if (i != 0)
          {
            com.tencent.mm.x.c.PJ().b(ac.a.yJH, true);
            AppMethodBeat.o(126829);
            return;
          }
          com.tencent.mm.x.c.PJ().b(ac.a.yJH, false);
          AppMethodBeat.o(126829);
          return;
        }
        catch (Exception paramString)
        {
          ab.printErrStackTrace("MicroMsg.SubCoreSetting", paramString, "device protect security value is not number!", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(126829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c.5
 * JD-Core Version:    0.7.0.1
 */