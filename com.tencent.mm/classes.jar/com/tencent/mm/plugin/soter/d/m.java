package com.tencent.mm.plugin.soter.d;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class m
{
  public static int LwF = 2;
  public static String LwG = "";
  public static String LwH = "";
  public static String LwI = "";
  private static String TAG = "MicroMsg.SoterUtil";
  
  public static String ahR(int paramInt)
  {
    AppMethodBeat.i(263162);
    if (paramInt == 1)
    {
      str = "WechatAuthKeyPay&" + LwG;
      AppMethodBeat.o(263162);
      return str;
    }
    String str = String.format("SoterAuthKey_salt%s_scene%d", new Object[] { com.tencent.soter.core.c.g.nullAsNil(gal()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(263162);
    return str;
  }
  
  public static String ahS(int paramInt)
  {
    AppMethodBeat.i(263163);
    String str = String.format("SoterAuthKeyV2_salt%s_scene%d", new Object[] { com.tencent.soter.core.c.g.nullAsNil(gam()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(263163);
    return str;
  }
  
  public static void ahT(int paramInt)
  {
    AppMethodBeat.i(130861);
    h.aHG().aHp().set(ar.a.VtI, Integer.valueOf(paramInt));
    AppMethodBeat.o(130861);
  }
  
  public static void ahU(int paramInt)
  {
    AppMethodBeat.i(130863);
    h.aHG().aHp().set(ar.a.VtJ, Integer.valueOf(paramInt));
    AppMethodBeat.o(130863);
  }
  
  public static void gak()
  {
    AppMethodBeat.i(130854);
    if (Util.getInt(((com.tencent.mm.plugin.zero.b.a)h.aHC().ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("SoterEntry"), 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(TAG, "alvinluo dynamic config support soter: %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        Log.d(TAG, "alvinluo set all soter support flag to true");
        af.juN.fXK = true;
        af.juN.juE = 255;
        af.juL.jsW = 1;
        af.juL.jsX = 1;
        Log.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", new Object[] { Boolean.valueOf(af.juN.fXK), Integer.valueOf(af.juL.jsW), Integer.valueOf(af.juL.jsX) });
      }
      AppMethodBeat.o(130854);
      return;
    }
  }
  
  private static String gal()
  {
    AppMethodBeat.i(130855);
    try
    {
      String str = com.tencent.mm.b.g.getMessageDigest(LwG.getBytes());
      if (str != null)
      {
        str = str.substring(0, 8);
        AppMethodBeat.o(130855);
        return str;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, localException, "alvinluo get md5 exception", new Object[0]);
      AppMethodBeat.o(130855);
    }
    return "";
  }
  
  public static String gam()
  {
    AppMethodBeat.i(263161);
    try
    {
      h.aHE();
      String str = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.kernel.b.aGq().getBytes());
      if (str != null)
      {
        str = str.substring(0, 8);
        AppMethodBeat.o(263161);
        return str;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, localException, "alvinluo get md5 exception", new Object[0]);
      AppMethodBeat.o(263161);
    }
    return "";
  }
  
  public static String gan()
  {
    AppMethodBeat.i(130856);
    String str2 = (String)com.tencent.soter.a.c.b.ipf().iph().get(1, "");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = "WechatAuthKeyPay&" + LwG;
    }
    AppMethodBeat.o(130856);
    return str1;
  }
  
  public static boolean gao()
  {
    AppMethodBeat.i(292931);
    boolean bool = gap();
    AppMethodBeat.o(292931);
    return bool;
  }
  
  private static boolean gap()
  {
    AppMethodBeat.i(130859);
    if (!af.juN.fXK)
    {
      Log.i(TAG, "hy: dynamic config is not support soter");
      AppMethodBeat.o(130859);
      return false;
    }
    boolean bool = com.tencent.soter.a.a.ipb();
    AppMethodBeat.o(130859);
    return bool;
  }
  
  public static int gaq()
  {
    AppMethodBeat.i(130860);
    int i = ((Integer)h.aHG().aHp().get(ar.a.VtI, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(130860);
    return i;
  }
  
  public static int gar()
  {
    AppMethodBeat.i(130862);
    int i = ((Integer)h.aHG().aHp().get(ar.a.VtJ, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(130862);
    return i;
  }
  
  public static boolean ig(Context paramContext)
  {
    AppMethodBeat.i(130857);
    if ((gap()) && (com.tencent.soter.core.a.gh(paramContext)))
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