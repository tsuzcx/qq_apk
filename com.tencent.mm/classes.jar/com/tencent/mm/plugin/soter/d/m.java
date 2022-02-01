package com.tencent.mm.plugin.soter.d;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.soter.a.c.b;

public final class m
{
  public static int AXi = 2;
  public static String AXj = "";
  public static String AXk = "";
  public static String AXl = "";
  private static String TAG = "MicroMsg.SoterUtil";
  
  public static String SB(int paramInt)
  {
    AppMethodBeat.i(217886);
    if (paramInt == 1)
    {
      str = "WechatAuthKeyPay&" + AXj;
      AppMethodBeat.o(217886);
      return str;
    }
    String str = String.format("SoterAuthKey_salt%s_scene%d", new Object[] { com.tencent.soter.core.c.g.nullAsNil(ejp()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(217886);
    return str;
  }
  
  public static String SC(int paramInt)
  {
    AppMethodBeat.i(217887);
    String str = String.format("SoterAuthKeyV2_salt%s_scene%d", new Object[] { com.tencent.soter.core.c.g.nullAsNil(ejq()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(217887);
    return str;
  }
  
  public static void SD(int paramInt)
  {
    AppMethodBeat.i(130861);
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXd, Integer.valueOf(paramInt));
    AppMethodBeat.o(130861);
  }
  
  public static void SE(int paramInt)
  {
    AppMethodBeat.i(130863);
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXe, Integer.valueOf(paramInt));
    AppMethodBeat.o(130863);
  }
  
  public static void ejo()
  {
    AppMethodBeat.i(130854);
    if (bu.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ajN().ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("SoterEntry"), 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "alvinluo dynamic config support soter: %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        com.tencent.mm.sdk.platformtools.ae.d(TAG, "alvinluo set all soter support flag to true");
        com.tencent.mm.compatible.deviceinfo.ae.geS.dLM = true;
        com.tencent.mm.compatible.deviceinfo.ae.geS.geJ = 255;
        com.tencent.mm.compatible.deviceinfo.ae.geQ.gdg = 1;
        com.tencent.mm.compatible.deviceinfo.ae.geQ.gdh = 1;
        com.tencent.mm.sdk.platformtools.ae.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", new Object[] { Boolean.valueOf(com.tencent.mm.compatible.deviceinfo.ae.geS.dLM), Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.geQ.gdg), Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.geQ.gdh) });
      }
      AppMethodBeat.o(130854);
      return;
    }
  }
  
  private static String ejp()
  {
    AppMethodBeat.i(130855);
    try
    {
      String str = com.tencent.mm.b.g.getMessageDigest(AXj.getBytes());
      if (str != null)
      {
        str = str.substring(0, 8);
        AppMethodBeat.o(130855);
        return str;
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace(TAG, localException, "alvinluo get md5 exception", new Object[0]);
      AppMethodBeat.o(130855);
    }
    return "";
  }
  
  public static String ejq()
  {
    AppMethodBeat.i(217885);
    try
    {
      com.tencent.mm.kernel.g.ajP();
      String str = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.kernel.a.aiF().getBytes());
      if (str != null)
      {
        str = str.substring(0, 8);
        AppMethodBeat.o(217885);
        return str;
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace(TAG, localException, "alvinluo get md5 exception", new Object[0]);
      AppMethodBeat.o(217885);
    }
    return "";
  }
  
  public static String ejr()
  {
    AppMethodBeat.i(130856);
    String str2 = (String)b.fZv().fZx().get(1, "");
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = "WechatAuthKeyPay&" + AXj;
    }
    AppMethodBeat.o(130856);
    return str1;
  }
  
  public static boolean ejs()
  {
    AppMethodBeat.i(224504);
    boolean bool = ejt();
    AppMethodBeat.o(224504);
    return bool;
  }
  
  private static boolean ejt()
  {
    AppMethodBeat.i(130859);
    if (!com.tencent.mm.compatible.deviceinfo.ae.geS.dLM)
    {
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "hy: dynamic config is not support soter");
      AppMethodBeat.o(130859);
      return false;
    }
    boolean bool = com.tencent.soter.a.a.fZr();
    AppMethodBeat.o(130859);
    return bool;
  }
  
  public static int eju()
  {
    AppMethodBeat.i(130860);
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXd, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(130860);
    return i;
  }
  
  public static int ejv()
  {
    AppMethodBeat.i(130862);
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXe, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(130862);
    return i;
  }
  
  public static boolean gu(Context paramContext)
  {
    AppMethodBeat.i(130857);
    if ((ejt()) && (com.tencent.soter.core.a.fi(paramContext)))
    {
      AppMethodBeat.o(130857);
      return true;
    }
    AppMethodBeat.o(130857);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.m
 * JD-Core Version:    0.7.0.1
 */