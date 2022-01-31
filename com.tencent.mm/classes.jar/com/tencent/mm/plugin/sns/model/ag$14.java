package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.a.lo.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;

final class ag$14
  extends c<lo>
{
  ag$14(ag paramag)
  {
    AppMethodBeat.i(36434);
    this.__eventId = lo.class.getName().hashCode();
    AppMethodBeat.o(36434);
  }
  
  private static boolean a(lo paramlo)
  {
    AppMethodBeat.i(36435);
    Object localObject2 = paramlo.cBG.cwr;
    o localo = ag.cpf();
    paramlo = ag.Rq();
    long l1 = paramlo.kr(-1L);
    try
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        long l2 = ((Long)((Iterator)localObject2).next()).longValue();
        n localn = localo.Ez((int)l2);
        if (localn != null)
        {
          localn.field_localFlag |= 0x40;
          ab.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
          localo.b((int)l2, localn);
        }
      }
      paramlo.nY(l1);
    }
    finally
    {
      paramlo.nY(l1);
      AppMethodBeat.o(36435);
    }
    AppMethodBeat.o(36435);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ag.14
 * JD-Core Version:    0.7.0.1
 */