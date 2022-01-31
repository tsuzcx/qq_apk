package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;

public final class j
{
  private static final int rWO = i.b.rWK.bcw;
  private static final int rWP = i.b.rWM.bcw;
  private static final int rWQ = i.b.rWL.bcw;
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString)
  {
    int j = rWP;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      a(paramInt1, paramInt2, "", paramInt3, j, i, a.rWS.ordinal(), 1, 1, 1, paramString);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    int n = rWQ;
    int i;
    int i1;
    int j;
    label28:
    int k;
    if (paramBoolean1)
    {
      i = 0;
      i1 = a.rWS.ordinal();
      if (!paramBoolean3) {
        break label73;
      }
      j = 0;
      if (!paramBoolean2) {
        break label79;
      }
      k = 0;
      label36:
      if (!paramBoolean4) {
        break label85;
      }
    }
    label73:
    label79:
    label85:
    for (int m = 0;; m = 1)
    {
      a(paramInt1, paramInt2, "", paramInt3, n, i, i1, j, k, m, paramString);
      return;
      i = 1;
      break;
      j = 1;
      break label28;
      k = 1;
      break label36;
    }
  }
  
  private static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString2)
  {
    h.nFQ.f(11906, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9) });
    if ((!bk.bl(paramString2)) && (!paramString2.equals("0"))) {
      h.nFQ.f(11907, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9), paramString2 });
    }
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    int m = rWO;
    int i;
    int n;
    int j;
    if (paramBoolean2)
    {
      i = 0;
      n = parama.ordinal();
      if (!paramBoolean3) {
        break label63;
      }
      j = 0;
      label28:
      if (!paramBoolean1) {
        break label69;
      }
    }
    label63:
    label69:
    for (int k = 0;; k = 1)
    {
      a(paramInt1, paramInt2, paramString1, paramInt3, m, i, n, j, 1, k, paramString2);
      return;
      i = 1;
      break;
      j = 1;
      break label28;
    }
  }
  
  public static void he(long paramLong)
  {
    s(paramLong, 2L);
  }
  
  public static void s(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > 0L) && (197L != paramLong1)) {
      h.nFQ.a(paramLong1, paramLong2, 1L, false);
    }
    h.nFQ.a(197L, paramLong2, 1L, false);
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.j
 * JD-Core Version:    0.7.0.1
 */