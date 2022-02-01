package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
{
  private static final int JZo = i.b.JZk.cSx;
  private static final int JZp = i.b.JZm.cSx;
  private static final int JZq = i.b.JZl.cSx;
  
  public static void F(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151981);
    if ((paramLong1 > 0L) && (197L != paramLong1)) {
      h.CyF.idkeyStat(paramLong1, paramLong2, 1L, false);
    }
    h.CyF.idkeyStat(197L, paramLong2, 1L, false);
    AppMethodBeat.o(151981);
  }
  
  public static void Mr(long paramLong)
  {
    AppMethodBeat.i(151982);
    F(paramLong, 2L);
    AppMethodBeat.o(151982);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(151984);
    int j = JZp;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      a(paramInt1, paramInt2, "", paramInt3, j, i, a.JZs.ordinal(), 1, 1, 1, paramString);
      AppMethodBeat.o(151984);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    AppMethodBeat.i(151985);
    int n = JZq;
    int i;
    int i1;
    int j;
    label33:
    int k;
    if (paramBoolean1)
    {
      i = 0;
      i1 = a.JZs.ordinal();
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
    h.CyF.a(11906, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9) });
    if ((!Util.isNullOrNil(paramString2)) && (!paramString2.equals("0"))) {
      h.CyF.a(11907, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9), paramString2 });
    }
    AppMethodBeat.o(151986);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    AppMethodBeat.i(151983);
    int m = JZo;
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
  
  public static void m(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(223825);
    hj localhj = new hj();
    String str = "none";
    if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
      if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        break label136;
      }
    }
    label136:
    for (str = "wifi";; str = "4g")
    {
      localhj.eLN = localhj.x("Network", str, true);
      localhj.eLK = paramInt1;
      localhj.eLL = paramInt2;
      localhj.eLM = paramInt3;
      localhj.eLO = paramInt4;
      localhj.eLP = paramInt5;
      localhj.bfK();
      Log.i("MicroMsg.ConstantsCheckResUpdate", "kvStatDownload: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt5) });
      AppMethodBeat.o(223825);
      return;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(151980);
      JZr = new a("SUCC", 0);
      JZs = new a("FAIL", 1);
      JZt = new a("RETRY_SUCC", 2);
      JZu = new a("FILE_LATEST", 3);
      JZv = new a("FILE_EXPIRED", 4);
      JZw = new a("DEVICE_NOT_MATCH", 5);
      JZx = new a[] { JZr, JZs, JZt, JZu, JZv, JZw };
      AppMethodBeat.o(151980);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.j
 * JD-Core Version:    0.7.0.1
 */