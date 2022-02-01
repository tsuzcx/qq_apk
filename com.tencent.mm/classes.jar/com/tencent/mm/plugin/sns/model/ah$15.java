package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.g.a.nr.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;

final class ah$15
  extends c<nr>
{
  ah$15(ah paramah)
  {
    AppMethodBeat.i(160658);
    this.__eventId = nr.class.getName().hashCode();
    AppMethodBeat.o(160658);
  }
  
  private static boolean a(nr paramnr)
  {
    AppMethodBeat.i(176261);
    Object localObject2 = paramnr.dCG.dwq;
    q localq = ah.dXE();
    paramnr = ah.getDataDB();
    long l1 = paramnr.yi(-1L);
    try
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        long l2 = ((Long)((Iterator)localObject2).next()).longValue();
        p localp = localq.Rw((int)l2);
        if (localp != null)
        {
          localp.field_localFlag |= 0x40;
          ae.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
          localq.b((int)l2, localp);
        }
      }
      paramnr.sW(l1);
    }
    finally
    {
      paramnr.sW(l1);
      AppMethodBeat.o(176261);
    }
    AppMethodBeat.o(176261);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ah.15
 * JD-Core Version:    0.7.0.1
 */