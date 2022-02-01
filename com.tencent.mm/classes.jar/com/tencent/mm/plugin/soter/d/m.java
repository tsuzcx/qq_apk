package com.tencent.mm.plugin.soter.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public final class m
{
  private static String TAG = "MicroMsg.SoterUtil";
  public static int yaM = 2;
  public static String yaN = "";
  public static String yaO = "";
  
  public static void Oh(int paramInt)
  {
    AppMethodBeat.i(130861);
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fss, Integer.valueOf(paramInt));
    AppMethodBeat.o(130861);
  }
  
  public static void Oi(int paramInt)
  {
    AppMethodBeat.i(130863);
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fst, Integer.valueOf(paramInt));
    AppMethodBeat.o(130863);
  }
  
  public static void dES()
  {
    AppMethodBeat.i(130854);
    if (bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.afx().ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("SoterEntry"), 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "alvinluo dynamic config support soter: %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.sdk.platformtools.ad.d(TAG, "alvinluo set all soter support flag to true");
        ae.fFC.dAy = true;
        ae.fFC.fFt = 255;
        ae.fFA.fDR = 1;
        ae.fFA.fDS = 1;
        com.tencent.mm.sdk.platformtools.ad.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", new Object[] { Boolean.valueOf(ae.fFC.dAy), Integer.valueOf(ae.fFA.fDR), Integer.valueOf(ae.fFA.fDS) });
      }
      AppMethodBeat.o(130854);
      return;
    }
  }
  
  public static String dET()
  {
    AppMethodBeat.i(130855);
    try
    {
      String str = com.tencent.mm.b.g.getMessageDigest(u.aqJ().getBytes());
      if (str != null)
      {
        str = str.substring(0, 8);
        AppMethodBeat.o(130855);
        return str;
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace(TAG, localException, "alvinluo get md5 exception", new Object[0]);
      AppMethodBeat.o(130855);
    }
    return "";
  }
  
  public static String dEU()
  {
    AppMethodBeat.i(130856);
    String str = "WechatAuthKeyPay&" + u.aqJ();
    AppMethodBeat.o(130856);
    return str;
  }
  
  public static boolean dEV()
  {
    AppMethodBeat.i(204990);
    boolean bool = dEW();
    AppMethodBeat.o(204990);
    return bool;
  }
  
  private static boolean dEW()
  {
    AppMethodBeat.i(130859);
    if (!ae.fFC.dAy)
    {
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "hy: dynamic config is not support soter");
      AppMethodBeat.o(130859);
      return false;
    }
    boolean bool = com.tencent.soter.a.a.fnk();
    AppMethodBeat.o(130859);
    return bool;
  }
  
  public static int dEX()
  {
    AppMethodBeat.i(130860);
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fss, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(130860);
    return i;
  }
  
  public static int dEY()
  {
    AppMethodBeat.i(130862);
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fst, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(130862);
    return i;
  }
  
  public static boolean ga(Context paramContext)
  {
    AppMethodBeat.i(130857);
    if ((dEW()) && (com.tencent.soter.core.a.eO(paramContext)))
    {
      AppMethodBeat.o(130857);
      return true;
    }
    AppMethodBeat.o(130857);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.m
 * JD-Core Version:    0.7.0.1
 */