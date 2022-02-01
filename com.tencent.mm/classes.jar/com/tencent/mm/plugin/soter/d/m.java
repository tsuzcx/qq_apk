package com.tencent.mm.plugin.soter.d;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.soter.a.c.b;

public final class m
{
  public static int AFF = 2;
  public static String AFG = "";
  public static String AFH = "";
  public static String AFI = "";
  private static String TAG = "MicroMsg.SoterUtil";
  
  public static String RU(int paramInt)
  {
    AppMethodBeat.i(214670);
    if (paramInt == 1)
    {
      str = "WechatAuthKeyPay&" + AFG;
      AppMethodBeat.o(214670);
      return str;
    }
    String str = String.format("SoterAuthKey_salt%s_scene%d", new Object[] { com.tencent.soter.core.c.g.nullAsNil(efH()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(214670);
    return str;
  }
  
  public static String RV(int paramInt)
  {
    AppMethodBeat.i(214671);
    String str = String.format("SoterAuthKeyV2_salt%s_scene%d", new Object[] { com.tencent.soter.core.c.g.nullAsNil(efI()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(214671);
    return str;
  }
  
  public static void RW(int paramInt)
  {
    AppMethodBeat.i(130861);
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICD, Integer.valueOf(paramInt));
    AppMethodBeat.o(130861);
  }
  
  public static void RX(int paramInt)
  {
    AppMethodBeat.i(130863);
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICE, Integer.valueOf(paramInt));
    AppMethodBeat.o(130863);
  }
  
  public static void efG()
  {
    AppMethodBeat.i(130854);
    if (bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ajy().ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("SoterEntry"), 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "alvinluo dynamic config support soter: %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.sdk.platformtools.ad.d(TAG, "alvinluo set all soter support flag to true");
        ae.gcK.dKx = true;
        ae.gcK.gcB = 255;
        ae.gcI.gaY = 1;
        ae.gcI.gaZ = 1;
        com.tencent.mm.sdk.platformtools.ad.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", new Object[] { Boolean.valueOf(ae.gcK.dKx), Integer.valueOf(ae.gcI.gaY), Integer.valueOf(ae.gcI.gaZ) });
      }
      AppMethodBeat.o(130854);
      return;
    }
  }
  
  private static String efH()
  {
    AppMethodBeat.i(130855);
    try
    {
      String str = com.tencent.mm.b.g.getMessageDigest(AFG.getBytes());
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
  
  public static String efI()
  {
    AppMethodBeat.i(214669);
    try
    {
      com.tencent.mm.kernel.g.ajA();
      String str = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.kernel.a.aiq().getBytes());
      if (str != null)
      {
        str = str.substring(0, 8);
        AppMethodBeat.o(214669);
        return str;
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace(TAG, localException, "alvinluo get md5 exception", new Object[0]);
      AppMethodBeat.o(214669);
    }
    return "";
  }
  
  public static String efJ()
  {
    AppMethodBeat.i(130856);
    String str2 = (String)b.fUW().fUY().get(1, "");
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = "WechatAuthKeyPay&" + AFG;
    }
    AppMethodBeat.o(130856);
    return str1;
  }
  
  public static boolean efK()
  {
    AppMethodBeat.i(221585);
    boolean bool = efL();
    AppMethodBeat.o(221585);
    return bool;
  }
  
  private static boolean efL()
  {
    AppMethodBeat.i(130859);
    if (!ae.gcK.dKx)
    {
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "hy: dynamic config is not support soter");
      AppMethodBeat.o(130859);
      return false;
    }
    boolean bool = com.tencent.soter.a.a.fUS();
    AppMethodBeat.o(130859);
    return bool;
  }
  
  public static int efM()
  {
    AppMethodBeat.i(130860);
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICD, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(130860);
    return i;
  }
  
  public static int efN()
  {
    AppMethodBeat.i(130862);
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICE, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(130862);
    return i;
  }
  
  public static boolean gp(Context paramContext)
  {
    AppMethodBeat.i(130857);
    if ((efL()) && (com.tencent.soter.core.a.fe(paramContext)))
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