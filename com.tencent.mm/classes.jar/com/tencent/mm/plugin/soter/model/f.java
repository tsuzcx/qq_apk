package com.tencent.mm.plugin.soter.model;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.x.a;
import com.tencent.mm.plugin.appbrand.x.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
{
  public static void aM(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145968);
    ((b)e.U(b.class)).b(13711, new Object[] { Integer.valueOf(0), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(145968);
  }
  
  public static void lX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145969);
    switch (paramInt2)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        Log.i("SoterLuggageReportManager", "luggage soter idkey report id: %d, key: %d, value: %d", new Object[] { Integer.valueOf(672), Integer.valueOf(paramInt1), Long.valueOf(1L) });
        ((a)e.U(a.class)).idkeyStat(672L, paramInt1, 1L, false);
      }
      AppMethodBeat.o(145969);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.model.f
 * JD-Core Version:    0.7.0.1
 */