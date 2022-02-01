package com.tencent.mm.plugin.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.y.a;
import java.util.Map;

final class c$4
  implements MStorage.IOnStorageChange
{
  c$4(c paramc) {}
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(67338);
    if ((paramString != null) && (paramString.length() > 0) && ("event_updated".equals(paramString)))
    {
      paramString = com.tencent.mm.model.c.d.aXu().Fu("100324");
      if ((!paramString.isValid()) || (!"1".equals(paramString.gzz().get("open")))) {
        break label172;
      }
    }
    label172:
    for (int i = 1;; i = 0)
    {
      paramString = g.aAh().azQ();
      paramString.set(ar.a.OeI, Integer.valueOf(i));
      int j = ((Integer)paramString.get(ar.a.OeJ, Integer.valueOf(0))).intValue();
      Log.i("MicroMsg.SubCoreRemittance", "receive abtest open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j == 0)
      {
        com.tencent.mm.y.c.axV().b(ar.a.OeD, true);
        paramString.set(ar.a.OeJ, Integer.valueOf(1));
        g.aAh().azQ().set(ar.a.OeE, Boolean.FALSE);
      }
      AppMethodBeat.o(67338);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.c.4
 * JD-Core Version:    0.7.0.1
 */