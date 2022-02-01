package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mb;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
{
  private static final int XVV = i.b.XVR.eQp;
  private static final int XVW = i.b.XVT.eQp;
  private static final int XVX = i.b.XVS.eQp;
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(151984);
    int j = XVW;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      a(paramInt1, paramInt2, "", paramInt3, j, i, a.XVZ.ordinal(), 1, 1, 1, paramString);
      AppMethodBeat.o(151984);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    AppMethodBeat.i(151985);
    int n = XVX;
    int i;
    int i1;
    int j;
    label33:
    int k;
    if (paramBoolean1)
    {
      i = 0;
      i1 = a.XVZ.ordinal();
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
    h.OAn.b(11906, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9) });
    if ((!Util.isNullOrNil(paramString2)) && (!paramString2.equals("0"))) {
      h.OAn.b(11907, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9), paramString2 });
    }
    AppMethodBeat.o(151986);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2)
  {
    AppMethodBeat.i(151983);
    int m = XVV;
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
  
  public static void ac(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151981);
    if ((paramLong1 > 0L) && (197L != paramLong1)) {
      h.OAn.idkeyStat(paramLong1, paramLong2, 1L, false);
    }
    h.OAn.idkeyStat(197L, paramLong2, 1L, false);
    AppMethodBeat.o(151981);
  }
  
  public static void r(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(245044);
    mb localmb = new mb();
    String str = "none";
    if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
      if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        break label136;
      }
    }
    label136:
    for (str = "wifi";; str = "4g")
    {
      localmb.jaW = localmb.F("Network", str, true);
      localmb.iUt = paramInt1;
      localmb.jaU = paramInt2;
      localmb.jaV = paramInt3;
      localmb.jaX = paramInt4;
      localmb.jaY = paramInt5;
      localmb.bMH();
      Log.i("MicroMsg.ConstantsCheckResUpdate", "kvStatDownload: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt5) });
      AppMethodBeat.o(245044);
      return;
    }
  }
  
  public static void yk(long paramLong)
  {
    AppMethodBeat.i(151982);
    ac(paramLong, 2L);
    AppMethodBeat.o(151982);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(151980);
      XVY = new a("SUCC", 0);
      XVZ = new a("FAIL", 1);
      XWa = new a("RETRY_SUCC", 2);
      XWb = new a("FILE_LATEST", 3);
      XWc = new a("FILE_EXPIRED", 4);
      XWd = new a("DEVICE_NOT_MATCH", 5);
      XWe = new a[] { XVY, XVZ, XWa, XWb, XWc, XWd };
      AppMethodBeat.o(151980);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.j
 * JD-Core Version:    0.7.0.1
 */