package com.tencent.mm.plugin.soter.d;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.soter.a.c.b;

public final class m
{
  private static String TAG = "MicroMsg.SoterUtil";
  public static int znL = 2;
  public static String znM = "";
  public static String znN = "";
  public static String znO = "";
  
  public static String Qm(int paramInt)
  {
    AppMethodBeat.i(207372);
    String str = String.format("SoterAuthKeyV2_salt%s_scene%d", new Object[] { com.tencent.soter.core.c.g.nullAsNil(dTt()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(207372);
    return str;
  }
  
  public static void Qn(int paramInt)
  {
    AppMethodBeat.i(130861);
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQj, Integer.valueOf(paramInt));
    AppMethodBeat.o(130861);
  }
  
  public static void Qo(int paramInt)
  {
    AppMethodBeat.i(130863);
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQk, Integer.valueOf(paramInt));
    AppMethodBeat.o(130863);
  }
  
  public static void dTs()
  {
    AppMethodBeat.i(130854);
    if (bs.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.agN().ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getValue("SoterEntry"), 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i(TAG, "alvinluo dynamic config support soter: %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        ac.d(TAG, "alvinluo set all soter support flag to true");
        com.tencent.mm.compatible.deviceinfo.ae.fJj.dyk = true;
        com.tencent.mm.compatible.deviceinfo.ae.fJj.fJa = 255;
        com.tencent.mm.compatible.deviceinfo.ae.fJh.fHy = 1;
        com.tencent.mm.compatible.deviceinfo.ae.fJh.fHz = 1;
        ac.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", new Object[] { Boolean.valueOf(com.tencent.mm.compatible.deviceinfo.ae.fJj.dyk), Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.fJh.fHy), Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.fJh.fHz) });
      }
      AppMethodBeat.o(130854);
      return;
    }
  }
  
  public static String dTt()
  {
    AppMethodBeat.i(207370);
    try
    {
      com.tencent.mm.kernel.g.agP();
      String str = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.kernel.a.afE().getBytes());
      if (str != null)
      {
        str = str.substring(0, 8);
        AppMethodBeat.o(207370);
        return str;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(TAG, localException, "alvinluo get md5 exception", new Object[0]);
      AppMethodBeat.o(207370);
    }
    return "";
  }
  
  public static String dTu()
  {
    AppMethodBeat.i(207371);
    String str = "WechatAuthKeyPay&" + znM;
    AppMethodBeat.o(207371);
    return str;
  }
  
  public static String dTv()
  {
    AppMethodBeat.i(130856);
    String str2 = (String)b.fDE().fDG().get(1, "");
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = "WechatAuthKeyPay&" + znM;
    }
    AppMethodBeat.o(130856);
    return str1;
  }
  
  public static boolean dTw()
  {
    AppMethodBeat.i(210541);
    boolean bool = dTx();
    AppMethodBeat.o(210541);
    return bool;
  }
  
  private static boolean dTx()
  {
    AppMethodBeat.i(130859);
    if (!com.tencent.mm.compatible.deviceinfo.ae.fJj.dyk)
    {
      ac.i(TAG, "hy: dynamic config is not support soter");
      AppMethodBeat.o(130859);
      return false;
    }
    boolean bool = com.tencent.soter.a.a.fDA();
    AppMethodBeat.o(130859);
    return bool;
  }
  
  public static int dTy()
  {
    AppMethodBeat.i(130860);
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQj, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(130860);
    return i;
  }
  
  public static int dTz()
  {
    AppMethodBeat.i(130862);
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQk, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(130862);
    return i;
  }
  
  public static boolean gm(Context paramContext)
  {
    AppMethodBeat.i(130857);
    if ((dTx()) && (com.tencent.soter.core.a.fb(paramContext)))
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