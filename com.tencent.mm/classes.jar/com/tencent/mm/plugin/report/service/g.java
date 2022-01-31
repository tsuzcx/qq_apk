package com.tencent.mm.plugin.report.service;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class g
{
  private static SparseArray<Long> nFF = new SparseArray();
  private static SparseArray<HashMap<Integer, Integer>> nFG = new SparseArray();
  private static boolean nFH = true;
  private static long nFI = 0L;
  private static long nFJ = 0L;
  private static long nFK = 0L;
  
  private static void J(int paramInt, long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    if (paramLong < 1000L)
    {
      h.nFQ.U(paramInt, 0, 1);
      return;
    }
    if (paramLong < 2000L)
    {
      h.nFQ.U(paramInt, 0, 3);
      return;
    }
    if (paramLong < 5000L)
    {
      h.nFQ.U(paramInt, 0, 5);
      return;
    }
    if (paramLong < 10000L)
    {
      h.nFQ.U(paramInt, 0, 7);
      return;
    }
    h.nFQ.U(paramInt, 0, 9);
  }
  
  private static void K(int paramInt, long paramLong)
  {
    long l;
    if (paramInt == 6)
    {
      l = System.currentTimeMillis();
      if (l < nFI + 60000L) {
        return;
      }
      nFI = l;
    }
    for (;;)
    {
      g.a locala = g.a.bwY();
      if (!locala.hasInit) {
        break label177;
      }
      h.nFQ.a(11335, true, false, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(locala.nFM), Long.valueOf(locala.nFL[0]), Long.valueOf(locala.nFL[1]), Long.valueOf(locala.nFO) });
      return;
      if (paramInt == 7)
      {
        l = System.currentTimeMillis();
        if (l < nFJ + 60000L) {
          break;
        }
        nFJ = l;
        continue;
      }
      if (paramInt == 8)
      {
        l = System.currentTimeMillis();
        if (l < nFK + 60000L) {
          break;
        }
        nFK = l;
      }
    }
    label177:
    h.nFQ.a(11335, true, false, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
  }
  
  public static void fx(long paramLong)
  {
    if (!nFH) {
      return;
    }
    y.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  with time:%d", new Object[] { Integer.valueOf(8), Long.valueOf(paramLong) });
    nFF.put(8, Long.valueOf(paramLong));
  }
  
  public static void wI(int paramInt)
  {
    if (!nFH) {
      return;
    }
    nFF.put(paramInt, Long.valueOf(bk.UY()));
    y.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  time:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bk.UY()) });
  }
  
  public static void wJ(int paramInt)
  {
    if (!nFH) {}
    long l;
    do
    {
      Long localLong;
      do
      {
        return;
        localLong = (Long)nFF.get(paramInt);
      } while ((localLong == null) || (localLong.longValue() == -1L));
      nFF.put(paramInt, Long.valueOf(-1L));
      l = bk.UY() - localLong.longValue();
    } while (l <= 0L);
    switch (paramInt)
    {
    }
    for (;;)
    {
      y.i("MicroMsg.ReportLogInfo", "ReportLogInfo operationEnd eventID:%d  time:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) });
      return;
      if (ae.ufk)
      {
        h.nFQ.d(23, 4, 5, (int)l, false);
      }
      else
      {
        K(1, l);
        J(227, l);
        h.nFQ.d(23, 1, 2, (int)l, false);
        continue;
        K(3, l);
        J(229, l);
        h.nFQ.d(27, 1, 2, (int)l, false);
        continue;
        K(2, l);
        J(228, l);
        h.nFQ.d(28, 1, 2, (int)l, false);
        continue;
        K(6, l);
        continue;
        K(7, l);
        continue;
        K(8, l);
        continue;
        K(10, l);
        continue;
        K(14, l);
        continue;
        K(15, l);
        continue;
        K(9, l);
        continue;
        K(11, l);
        continue;
        K(16, l);
        continue;
        K(13, l);
        continue;
        K(12, l);
      }
    }
  }
  
  public static void wK(int paramInt)
  {
    if (!nFH) {
      return;
    }
    y.d("MicroMsg.ReportLogInfo", "ReportLogInfo stopOperation stop eventID:%d", new Object[] { Integer.valueOf(paramInt) });
    nFF.put(paramInt, Long.valueOf(-1L));
  }
  
  final class a$a
    implements FileFilter
  {
    public final boolean accept(File paramFile)
    {
      return Pattern.matches("cpu[0-9]", paramFile.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.g
 * JD-Core Version:    0.7.0.1
 */