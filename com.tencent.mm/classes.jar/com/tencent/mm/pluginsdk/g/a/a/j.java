package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

public final class j
{
  private static final int vNG = i.b.vNC.bsY;
  private static final int vNH = i.b.vNE.bsY;
  private static final int vNI = i.b.vND.bsY;
  
  public static void B(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(79538);
    if ((paramLong1 > 0L) && (197L != paramLong1)) {
      h.qsU.idkeyStat(paramLong1, paramLong2, 1L, false);
    }
    h.qsU.idkeyStat(197L, paramLong2, 1L, false);
    AppMethodBeat.o(79538);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(79541);
    int j = vNH;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      a(paramInt1, paramInt2, "", paramInt3, j, i, a.vNK.ordinal(), 1, 1, 1, paramString);
      AppMethodBeat.o(79541);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    AppMethodBeat.i(79542);
    int n = vNI;
    int i;
    int i1;
    int j;
    label33:
    int k;
    if (paramBoolean1)
    {
      i = 0;
      i1 = a.vNK.ordinal();
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
      AppMethodBeat.o(79542);
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
    AppMethodBeat.i(79543);
    h.qsU.e(11906, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9) });
    if ((!bo.isNullOrNil(paramString2)) && (!paramString2.equals("0"))) {
      h.qsU.e(11907, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9), paramString2 });
    }
    AppMethodBeat.o(79543);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    AppMethodBeat.i(79540);
    int m = vNG;
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
      AppMethodBeat.o(79540);
      return;
      i = 1;
      break;
      j = 1;
      break label33;
    }
  }
  
  public static void nz(long paramLong)
  {
    AppMethodBeat.i(79539);
    B(paramLong, 2L);
    AppMethodBeat.o(79539);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(79537);
      vNJ = new a("SUCC", 0);
      vNK = new a("FAIL", 1);
      vNL = new a("RETRY_SUCC", 2);
      vNM = new a("FILE_LATEST", 3);
      vNN = new a("FILE_EXPIRED", 4);
      vNO = new a("DEVICE_NOT_MATCH", 5);
      vNP = new a[] { vNJ, vNK, vNL, vNM, vNN, vNO };
      AppMethodBeat.o(79537);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.j
 * JD-Core Version:    0.7.0.1
 */