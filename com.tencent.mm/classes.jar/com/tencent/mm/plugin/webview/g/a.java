package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ba.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class a
{
  public static final String vVP;
  
  static
  {
    AppMethodBeat.i(294677);
    vVP = "https://" + WeChatHosts.domainString(a.e.host_mp_weixin_qq_com) + "/__tmpl__/";
    AppMethodBeat.o(294677);
  }
  
  public static void atO(int paramInt)
  {
    AppMethodBeat.i(103128);
    c(974, paramInt, 1, false);
    AppMethodBeat.o(103128);
  }
  
  public static void atP(int paramInt)
  {
    AppMethodBeat.i(103132);
    bk(paramInt, 1L);
    AppMethodBeat.o(103132);
  }
  
  public static void bk(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103133);
    h.OAn.p(1009L, paramInt, paramLong);
    AppMethodBeat.o(103133);
  }
  
  private static void c(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(103131);
    Log.i("ConstantsPreload", "id:%d, key:%d, valye:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt1 > 0) {
      h.OAn.idkeyStat(paramInt1, paramInt2, paramInt3, false);
    }
    if ((paramBoolean) && (paramInt1 != 908) && (paramInt1 != 0)) {
      h.OAn.idkeyStat(908L, paramInt2, paramInt3, false);
    }
    h.OAn.b(15792, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103131);
  }
  
  public static void ik(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186127);
    c(paramInt1, paramInt2, 1, true);
    AppMethodBeat.o(186127);
  }
  
  public static void nk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103130);
    c(908, paramInt1, paramInt2, true);
    AppMethodBeat.o(103130);
  }
  
  public static void rG(int paramInt)
  {
    AppMethodBeat.i(103127);
    c(908, paramInt, 1, true);
    AppMethodBeat.o(103127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.a
 * JD-Core Version:    0.7.0.1
 */