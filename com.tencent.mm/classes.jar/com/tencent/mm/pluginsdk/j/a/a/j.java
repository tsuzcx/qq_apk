package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bt;

public final class j
{
  private static final int EPZ = i.b.EPV.dDp;
  private static final int EQa = i.b.EPX.dDp;
  private static final int EQb = i.b.EPW.dDp;
  
  public static void A(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151981);
    if ((paramLong1 > 0L) && (197L != paramLong1)) {
      g.yhR.idkeyStat(paramLong1, paramLong2, 1L, false);
    }
    g.yhR.idkeyStat(197L, paramLong2, 1L, false);
    AppMethodBeat.o(151981);
  }
  
  public static void CD(long paramLong)
  {
    AppMethodBeat.i(151982);
    A(paramLong, 2L);
    AppMethodBeat.o(151982);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(151984);
    int j = EQa;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      a(paramInt1, paramInt2, "", paramInt3, j, i, a.EQd.ordinal(), 1, 1, 1, paramString);
      AppMethodBeat.o(151984);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    AppMethodBeat.i(151985);
    int n = EQb;
    int i;
    int i1;
    int j;
    label33:
    int k;
    if (paramBoolean1)
    {
      i = 0;
      i1 = a.EQd.ordinal();
      if (!paramBoolean3) {
        break label83;
      }
      j = 0;
      if (!paramBoolean2) {
        break label89;
      }
      k = 0;
      label41:
      if (!paramBoolean4) {
        break label95;
      }
    }
    label83:
    label89:
    label95:
    for (int m = 0;; m = 1)
    {
      a(paramInt1, paramInt2, "", paramInt3, n, i, i1, j, k, m, paramString);
      AppMethodBeat.o(151985);
      return;
      i = 1;
      break;
      j = 1;
      break label33;
      k = 1;
      break label41;
    }
  }
  
  private static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString2)
  {
    AppMethodBeat.i(151986);
    g.yhR.f(11906, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9) });
    if ((!bt.isNullOrNil(paramString2)) && (!paramString2.equals("0"))) {
      g.yhR.f(11907, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9), paramString2 });
    }
    AppMethodBeat.o(151986);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    AppMethodBeat.i(151983);
    int m = EPZ;
    int i;
    int n;
    int j;
    if (paramBoolean2)
    {
      i = 0;
      n = parama.ordinal();
      if (!paramBoolean3) {
        break label73;
      }
      j = 0;
      label33:
      if (!paramBoolean1) {
        break label79;
      }
    }
    label73:
    label79:
    for (int k = 0;; k = 1)
    {
      a(paramInt1, paramInt2, paramString1, paramInt3, m, i, n, j, 1, k, paramString2);
      AppMethodBeat.o(151983);
      return;
      i = 1;
      break;
      j = 1;
      break label33;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(151980);
      EQc = new a("SUCC", 0);
      EQd = new a("FAIL", 1);
      EQe = new a("RETRY_SUCC", 2);
      EQf = new a("FILE_LATEST", 3);
      EQg = new a("FILE_EXPIRED", 4);
      EQh = new a("DEVICE_NOT_MATCH", 5);
      EQi = new a[] { EQc, EQd, EQe, EQf, EQg, EQh };
      AppMethodBeat.o(151980);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.j
 * JD-Core Version:    0.7.0.1
 */