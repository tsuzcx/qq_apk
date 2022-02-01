package com.tencent.mm.plugin.soter.model;

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
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class j
{
  public static int Sae = 2;
  public static String Saf = "";
  public static String Sag = "";
  public static String Sah = "";
  private static String TAG = "MicroMsg.SoterUtil";
  
  public static String amS(int paramInt)
  {
    AppMethodBeat.i(262500);
    if (paramInt == 1)
    {
      str = "WechatAuthKeyPay&" + Saf;
      AppMethodBeat.o(262500);
      return str;
    }
    String str = String.format("SoterAuthKey_salt%s_scene%d", new Object[] { com.tencent.soter.core.c.g.nullAsNil(htC()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(262500);
    return str;
  }
  
  public static String amT(int paramInt)
  {
    AppMethodBeat.i(262503);
    String str = String.format("SoterAuthKeyV2_salt%s_scene%d", new Object[] { com.tencent.soter.core.c.g.nullAsNil(htD()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(262503);
    return str;
  }
  
  public static void amU(int paramInt)
  {
    AppMethodBeat.i(130861);
    h.baE().ban().set(at.a.acVn, Integer.valueOf(paramInt));
    AppMethodBeat.o(130861);
  }
  
  public static void amV(int paramInt)
  {
    AppMethodBeat.i(130863);
    h.baE().ban().set(at.a.acVo, Integer.valueOf(paramInt));
    AppMethodBeat.o(130863);
  }
  
  public static void htB()
  {
    AppMethodBeat.i(130854);
    if (Util.getInt(((com.tencent.mm.plugin.zero.b.a)h.baA().ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("SoterEntry"), 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(TAG, "alvinluo dynamic config support soter: %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        Log.d(TAG, "alvinluo set all soter support flag to true");
        af.lYe.idL = true;
        af.lYe.lXV = 255;
        af.lYc.lWo = 1;
        af.lYc.lWp = 1;
        Log.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", new Object[] { Boolean.valueOf(af.lYe.idL), Integer.valueOf(af.lYc.lWo), Integer.valueOf(af.lYc.lWp) });
      }
      AppMethodBeat.o(130854);
      return;
    }
  }
  
  private static String htC()
  {
    AppMethodBeat.i(130855);
    try
    {
      String str = com.tencent.mm.b.g.getMessageDigest(Saf.getBytes());
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
  
  public static String htD()
  {
    AppMethodBeat.i(262497);
    try
    {
      h.baC();
      String str = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.kernel.b.aZs().getBytes());
      if (str != null)
      {
        str = str.substring(0, 8);
        AppMethodBeat.o(262497);
        return str;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, localException, "alvinluo get md5 exception", new Object[0]);
      AppMethodBeat.o(262497);
    }
    return "";
  }
  
  public static String htE()
  {
    AppMethodBeat.i(130856);
    String str2 = (String)com.tencent.soter.a.c.b.jYt().jYv().get(1, "");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = "WechatAuthKeyPay&" + Saf;
    }
    AppMethodBeat.o(130856);
    return str1;
  }
  
  public static boolean htF()
  {
    AppMethodBeat.i(369730);
    boolean bool = htG();
    AppMethodBeat.o(369730);
    return bool;
  }
  
  private static boolean htG()
  {
    AppMethodBeat.i(130859);
    if (!af.lYe.idL)
    {
      Log.i(TAG, "hy: dynamic config is not support soter");
      AppMethodBeat.o(130859);
      return false;
    }
    boolean bool = com.tencent.soter.a.a.jYp();
    AppMethodBeat.o(130859);
    return bool;
  }
  
  public static int htH()
  {
    AppMethodBeat.i(130860);
    int i = ((Integer)h.baE().ban().get(at.a.acVn, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(130860);
    return i;
  }
  
  public static int htI()
  {
    AppMethodBeat.i(130862);
    int i = ((Integer)h.baE().ban().get(at.a.acVo, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(130862);
    return i;
  }
  
  public static boolean jW(Context paramContext)
  {
    AppMethodBeat.i(130857);
    if ((htG()) && (com.tencent.soter.core.a.hC(paramContext)))
    {
      AppMethodBeat.o(130857);
      return true;
    }
    AppMethodBeat.o(130857);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.model.j
 * JD-Core Version:    0.7.0.1
 */