package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bt;

public final class j
{
  private static final int BSH = i.b.BSD.dtM;
  private static final int BSI = i.b.BSF.dtM;
  private static final int BSJ = i.b.BSE.dtM;
  
  public static void D(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151981);
    if ((paramLong1 > 0L) && (197L != paramLong1)) {
      h.vKh.idkeyStat(paramLong1, paramLong2, 1L, false);
    }
    h.vKh.idkeyStat(197L, paramLong2, 1L, false);
    AppMethodBeat.o(151981);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(151984);
    int j = BSI;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      a(paramInt1, paramInt2, "", paramInt3, j, i, a.BSL.ordinal(), 1, 1, 1, paramString);
      AppMethodBeat.o(151984);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    AppMethodBeat.i(151985);
    int n = BSJ;
    int i;
    int i1;
    int j;
    label33:
    int k;
    if (paramBoolean1)
    {
      i = 0;
      i1 = a.BSL.ordinal();
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
    h.vKh.f(11906, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9) });
    if ((!bt.isNullOrNil(paramString2)) && (!paramString2.equals("0"))) {
      h.vKh.f(11907, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9), paramString2 });
    }
    AppMethodBeat.o(151986);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    AppMethodBeat.i(151983);
    int m = BSH;
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
  
  public static void vm(long paramLong)
  {
    AppMethodBeat.i(151982);
    D(paramLong, 2L);
    AppMethodBeat.o(151982);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(151980);
      BSK = new a("SUCC", 0);
      BSL = new a("FAIL", 1);
      BSM = new a("RETRY_SUCC", 2);
      BSN = new a("FILE_LATEST", 3);
      BSO = new a("FILE_EXPIRED", 4);
      BSP = new a("DEVICE_NOT_MATCH", 5);
      BSQ = new a[] { BSK, BSL, BSM, BSN, BSO, BSP };
      AppMethodBeat.o(151980);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.j
 * JD-Core Version:    0.7.0.1
 */