package com.tencent.mm.plugin.soter.d;

import com.tencent.luggage.b.e;
import com.tencent.mm.plugin.appbrand.p.a;
import com.tencent.mm.sdk.platformtools.y;

public final class i
{
  public static void eh(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        y.i("SoterLuggageReportManager", "luggage soter idkey report id: %d, key: %d, value: %d", new Object[] { Integer.valueOf(672), Integer.valueOf(paramInt1), Long.valueOf(1L) });
        ((a)e.j(a.class)).d(672L, paramInt1, 1L);
      }
      return;
      if (paramInt1 == 3)
      {
        paramInt1 = 0;
        continue;
        paramInt1 = 1;
        continue;
        paramInt1 = 2;
        continue;
        paramInt1 = 3;
        continue;
        paramInt1 = 4;
        continue;
        paramInt1 = 5;
      }
      else
      {
        paramInt1 = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.i
 * JD-Core Version:    0.7.0.1
 */