package com.tencent.mm.plugin.soter.d;

import android.content.Context;
import com.tencent.mm.compatible.e.s;
import com.tencent.mm.compatible.e.x;
import com.tencent.mm.kernel.c;
import com.tencent.mm.m.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class m
{
  private static String TAG = "MicroMsg.SoterUtil";
  
  public static void bKS()
  {
    if (bk.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.DL().r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("SoterEntry"), 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      y.i(TAG, "alvinluo dynamic config support soter: %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        y.d(TAG, "alvinluo set all soter support flag to true");
        com.tencent.mm.compatible.e.q.dyj.cbb = true;
        com.tencent.mm.compatible.e.q.dyj.dyQ = 255;
        com.tencent.mm.compatible.e.q.dyh.dyq = 1;
        com.tencent.mm.compatible.e.q.dyh.dyr = 1;
        y.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", new Object[] { Boolean.valueOf(com.tencent.mm.compatible.e.q.dyj.cbb), Integer.valueOf(com.tencent.mm.compatible.e.q.dyh.dyq), Integer.valueOf(com.tencent.mm.compatible.e.q.dyh.dyr) });
      }
      return;
    }
  }
  
  public static String bKT()
  {
    try
    {
      String str = com.tencent.mm.a.g.o(com.tencent.mm.model.q.Gm().getBytes());
      if (str != null)
      {
        str = str.substring(0, 8);
        return str;
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace(TAG, localException, "alvinluo get md5 exception", new Object[0]);
    }
    return "";
  }
  
  public static String bKU()
  {
    return "WechatAuthKeyPay&" + com.tencent.mm.model.q.Gm();
  }
  
  public static boolean bKV()
  {
    if (!com.tencent.mm.compatible.e.q.dyj.cbb)
    {
      y.i(TAG, "hy: dynamic config is not support soter");
      return false;
    }
    return com.tencent.soter.a.a.cPw();
  }
  
  public static boolean ei(Context paramContext)
  {
    return (bKV()) && (com.tencent.soter.core.a.hF(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.m
 * JD-Core Version:    0.7.0.1
 */