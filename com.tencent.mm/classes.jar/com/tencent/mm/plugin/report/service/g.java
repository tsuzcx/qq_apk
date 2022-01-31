package com.tencent.mm.plugin.report.service;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class g
{
  private static SparseArray<Long> qsJ;
  private static SparseArray<HashMap<Integer, Integer>> qsK;
  private static boolean qsL;
  private static long qsM;
  private static long qsN;
  private static long qsO;
  
  static
  {
    AppMethodBeat.i(72750);
    qsJ = new SparseArray();
    qsK = new SparseArray();
    qsL = true;
    qsM = 0L;
    qsN = 0L;
    qsO = 0L;
    AppMethodBeat.o(72750);
  }
  
  public static void Cx(int paramInt)
  {
    AppMethodBeat.i(72744);
    if (!qsL)
    {
      AppMethodBeat.o(72744);
      return;
    }
    qsJ.put(paramInt, Long.valueOf(bo.aoy()));
    ab.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  time:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bo.aoy()) });
    AppMethodBeat.o(72744);
  }
  
  public static void Cy(int paramInt)
  {
    AppMethodBeat.i(72746);
    if (!qsL)
    {
      AppMethodBeat.o(72746);
      return;
    }
    Long localLong = (Long)qsJ.get(paramInt);
    if (localLong == null)
    {
      AppMethodBeat.o(72746);
      return;
    }
    if (localLong.longValue() == -1L)
    {
      AppMethodBeat.o(72746);
      return;
    }
    qsJ.put(paramInt, Long.valueOf(-1L));
    long l = bo.aoy() - localLong.longValue();
    if (l <= 0L)
    {
      AppMethodBeat.o(72746);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      ab.i("MicroMsg.ReportLogInfo", "ReportLogInfo operationEnd eventID:%d  time:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) });
      AppMethodBeat.o(72746);
      return;
      if (ah.ynK)
      {
        h.qsU.d(23, 4, 5, (int)l, false);
      }
      else
      {
        aa(1, l);
        Z(227, l);
        h.qsU.d(23, 1, 2, (int)l, false);
        continue;
        aa(3, l);
        Z(229, l);
        h.qsU.d(27, 1, 2, (int)l, false);
        continue;
        aa(2, l);
        Z(228, l);
        h.qsU.d(28, 1, 2, (int)l, false);
        continue;
        aa(6, l);
        continue;
        aa(7, l);
        continue;
        aa(8, l);
        continue;
        aa(10, l);
        continue;
        aa(14, l);
        continue;
        aa(15, l);
        continue;
        aa(9, l);
        continue;
        aa(11, l);
        continue;
        aa(16, l);
        continue;
        aa(13, l);
        continue;
        aa(12, l);
      }
    }
  }
  
  public static void Cz(int paramInt)
  {
    AppMethodBeat.i(72749);
    if (!qsL)
    {
      AppMethodBeat.o(72749);
      return;
    }
    ab.d("MicroMsg.ReportLogInfo", "ReportLogInfo stopOperation stop eventID:%d", new Object[] { Integer.valueOf(paramInt) });
    qsJ.put(paramInt, Long.valueOf(-1L));
    AppMethodBeat.o(72749);
  }
  
  private static void Z(int paramInt, long paramLong)
  {
    AppMethodBeat.i(72747);
    if (paramLong <= 0L)
    {
      AppMethodBeat.o(72747);
      return;
    }
    if (paramLong < 1000L)
    {
      h.qsU.af(paramInt, 0, 1);
      AppMethodBeat.o(72747);
      return;
    }
    if (paramLong < 2000L)
    {
      h.qsU.af(paramInt, 0, 3);
      AppMethodBeat.o(72747);
      return;
    }
    if (paramLong < 5000L)
    {
      h.qsU.af(paramInt, 0, 5);
      AppMethodBeat.o(72747);
      return;
    }
    if (paramLong < 10000L)
    {
      h.qsU.af(paramInt, 0, 7);
      AppMethodBeat.o(72747);
      return;
    }
    h.qsU.af(paramInt, 0, 9);
    AppMethodBeat.o(72747);
  }
  
  private static void aa(int paramInt, long paramLong)
  {
    AppMethodBeat.i(72748);
    long l;
    if (paramInt == 6)
    {
      l = System.currentTimeMillis();
      if (l < qsM + 60000L)
      {
        AppMethodBeat.o(72748);
        return;
      }
      qsM = l;
    }
    for (;;)
    {
      g.a locala = g.a.chR();
      if (!locala.hasInit) {
        break;
      }
      h.qsU.a(11335, true, false, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(locala.qsQ), Long.valueOf(locala.qsP[0]), Long.valueOf(locala.qsP[1]), Long.valueOf(locala.qsS) });
      AppMethodBeat.o(72748);
      return;
      if (paramInt == 7)
      {
        l = System.currentTimeMillis();
        if (l < qsN + 60000L)
        {
          AppMethodBeat.o(72748);
          return;
        }
        qsN = l;
      }
      else if (paramInt == 8)
      {
        l = System.currentTimeMillis();
        if (l < qsO + 60000L)
        {
          AppMethodBeat.o(72748);
          return;
        }
        qsO = l;
      }
    }
    h.qsU.a(11335, true, false, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AppMethodBeat.o(72748);
  }
  
  public static void lb(long paramLong)
  {
    AppMethodBeat.i(72745);
    if (!qsL)
    {
      AppMethodBeat.o(72745);
      return;
    }
    ab.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  with time:%d", new Object[] { Integer.valueOf(8), Long.valueOf(paramLong) });
    qsJ.put(8, Long.valueOf(paramLong));
    AppMethodBeat.o(72745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.g
 * JD-Core Version:    0.7.0.1
 */