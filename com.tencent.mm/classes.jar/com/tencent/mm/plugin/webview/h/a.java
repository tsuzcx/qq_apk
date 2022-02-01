package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class a
{
  public static final String pFm;
  
  static
  {
    AppMethodBeat.i(224502);
    pFm = "https://" + WeChatHosts.domainString(2131761726) + "/__tmpl__/";
    AppMethodBeat.o(224502);
  }
  
  public static void aP(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103133);
    h.CyF.n(1009L, paramInt, paramLong);
    AppMethodBeat.o(103133);
  }
  
  public static void agh(int paramInt)
  {
    AppMethodBeat.i(103128);
    e(974, paramInt, 1, false);
    AppMethodBeat.o(103128);
  }
  
  public static void agi(int paramInt)
  {
    AppMethodBeat.i(103132);
    aP(paramInt, 1L);
    AppMethodBeat.o(103132);
  }
  
  private static void e(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(103131);
    Log.i("ConstantsPreload", "id:%d, key:%d, valye:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt1 > 0) {
      h.CyF.idkeyStat(paramInt1, paramInt2, paramInt3, false);
    }
    if ((paramBoolean) && (paramInt1 != 908) && (paramInt1 != 0)) {
      h.CyF.idkeyStat(908L, paramInt2, paramInt3, false);
    }
    h.CyF.a(15792, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103131);
  }
  
  public static void gH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186127);
    e(paramInt1, paramInt2, 1, true);
    AppMethodBeat.o(186127);
  }
  
  public static void kh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103130);
    e(908, paramInt1, paramInt2, true);
    AppMethodBeat.o(103130);
  }
  
  public static void pl(int paramInt)
  {
    AppMethodBeat.i(103127);
    e(908, paramInt, 1, true);
    AppMethodBeat.o(103127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.a
 * JD-Core Version:    0.7.0.1
 */