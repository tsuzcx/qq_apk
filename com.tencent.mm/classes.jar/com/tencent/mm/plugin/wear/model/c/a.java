package com.tencent.mm.plugin.wear.model.c;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.protocal.c.cjl;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class a
{
  public static final void Bf(int paramInt)
  {
    h.nFQ.a(249L, paramInt, 1L, false);
  }
  
  public static final void ez(int paramInt1, int paramInt2)
  {
    cjl localcjl = com.tencent.mm.plugin.wear.model.a.bYL().qRu.qRL.qSA;
    if (localcjl != null)
    {
      y.v("MicroMsg.Wear.ReportKVUtil", "report kv operation=%d scene=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      h.nFQ.f(11632, new Object[] { Integer.valueOf(paramInt1), localcjl.hQd, localcjl.tXj, Integer.valueOf(paramInt2) });
    }
  }
  
  public static final void kX(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(249);
    localIDKey.SetKey(12);
    localIDKey.SetValue(1L);
    localArrayList.add(localIDKey);
    if (paramBoolean)
    {
      localIDKey = new IDKey();
      localIDKey.SetID(249);
      localIDKey.SetKey(13);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    h.nFQ.b(localArrayList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.c.a
 * JD-Core Version:    0.7.0.1
 */