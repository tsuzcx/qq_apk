package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.cf.h;
import com.tencent.mm.h.a.la;
import com.tencent.mm.h.a.la.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

final class af$18
  extends c<la>
{
  af$18(af paramaf)
  {
    this.udX = la.class.getName().hashCode();
  }
  
  private static boolean a(la paramla)
  {
    Object localObject2 = paramla.bUb.bPa;
    o localo = af.bDF();
    paramla = af.Dv();
    long l1 = paramla.eV(-1L);
    try
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        long l2 = ((Long)((Iterator)localObject2).next()).longValue();
        n localn = localo.yt((int)l2);
        if (localn != null)
        {
          localn.field_localFlag |= 0x40;
          y.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", new Object[] { Long.valueOf(l2) });
          localo.b((int)l2, localn);
        }
      }
    }
    finally
    {
      paramla.hI(l1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.af.18
 * JD-Core Version:    0.7.0.1
 */