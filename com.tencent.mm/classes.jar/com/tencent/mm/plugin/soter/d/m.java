package com.tencent.mm.plugin.soter.d;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.soter.a.c.b;

public final class m
{
  public static int Fia = 2;
  public static String Fib = "";
  public static String Fic = "";
  public static String Fid = "";
  private static String TAG = "MicroMsg.SoterUtil";
  
  public static void aaA(int paramInt)
  {
    AppMethodBeat.i(130863);
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ofx, Integer.valueOf(paramInt));
    AppMethodBeat.o(130863);
  }
  
  public static String aax(int paramInt)
  {
    AppMethodBeat.i(192232);
    if (paramInt == 1)
    {
      str = "WechatAuthKeyPay&" + Fib;
      AppMethodBeat.o(192232);
      return str;
    }
    String str = String.format("SoterAuthKey_salt%s_scene%d", new Object[] { com.tencent.soter.core.c.g.nullAsNil(flP()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(192232);
    return str;
  }
  
  public static String aay(int paramInt)
  {
    AppMethodBeat.i(192233);
    String str = String.format("SoterAuthKeyV2_salt%s_scene%d", new Object[] { com.tencent.soter.core.c.g.nullAsNil(flQ()), Integer.valueOf(paramInt) });
    AppMethodBeat.o(192233);
    return str;
  }
  
  public static void aaz(int paramInt)
  {
    AppMethodBeat.i(130861);
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ofw, Integer.valueOf(paramInt));
    AppMethodBeat.o(130861);
  }
  
  public static void flO()
  {
    AppMethodBeat.i(130854);
    if (Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.aAd().af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("SoterEntry"), 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(TAG, "alvinluo dynamic config support soter: %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        Log.d(TAG, "alvinluo set all soter support flag to true");
        ae.gKz.edB = true;
        ae.gKz.gKq = 255;
        ae.gKx.gIE = 1;
        ae.gKx.gIF = 1;
        Log.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", new Object[] { Boolean.valueOf(ae.gKz.edB), Integer.valueOf(ae.gKx.gIE), Integer.valueOf(ae.gKx.gIF) });
      }
      AppMethodBeat.o(130854);
      return;
    }
  }
  
  private static String flP()
  {
    AppMethodBeat.i(130855);
    try
    {
      String str = com.tencent.mm.b.g.getMessageDigest(Fib.getBytes());
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
  
  public static String flQ()
  {
    AppMethodBeat.i(192231);
    try
    {
      com.tencent.mm.kernel.g.aAf();
      String str = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.kernel.a.ayV().getBytes());
      if (str != null)
      {
        str = str.substring(0, 8);
        AppMethodBeat.o(192231);
        return str;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(TAG, localException, "alvinluo get md5 exception", new Object[0]);
      AppMethodBeat.o(192231);
    }
    return "";
  }
  
  public static String flR()
  {
    AppMethodBeat.i(130856);
    String str2 = (String)b.hlG().hlI().get(1, "");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = "WechatAuthKeyPay&" + Fib;
    }
    AppMethodBeat.o(130856);
    return str1;
  }
  
  public static boolean flS()
  {
    AppMethodBeat.i(258690);
    boolean bool = flT();
    AppMethodBeat.o(258690);
    return bool;
  }
  
  private static boolean flT()
  {
    AppMethodBeat.i(130859);
    if (!ae.gKz.edB)
    {
      Log.i(TAG, "hy: dynamic config is not support soter");
      AppMethodBeat.o(130859);
      return false;
    }
    boolean bool = com.tencent.soter.a.a.hlC();
    AppMethodBeat.o(130859);
    return bool;
  }
  
  public static int flU()
  {
    AppMethodBeat.i(130860);
    int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ofw, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(130860);
    return i;
  }
  
  public static int flV()
  {
    AppMethodBeat.i(130862);
    int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ofx, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(130862);
    return i;
  }
  
  public static boolean hf(Context paramContext)
  {
    AppMethodBeat.i(130857);
    if ((flT()) && (com.tencent.soter.core.a.fN(paramContext)))
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