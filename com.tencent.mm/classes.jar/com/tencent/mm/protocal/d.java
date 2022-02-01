package com.tencent.mm.protocal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.j.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import junit.framework.Assert;

public final class d
  extends e
{
  public static int YwZ;
  public static final String Yxa;
  public static final String Yxb;
  public static String Yxc;
  public static final String Yxd;
  public static String Yxe;
  public static final String Yxf;
  public static long Yxg;
  public static int Yxh;
  public static boolean Yxi;
  public static boolean Yxj;
  public static boolean Yxk;
  public static boolean Yxl;
  public static int Yxm;
  public static final byte[] Yxn;
  public static final byte[] Yxo;
  public static final byte[] Yxp;
  public static final String Yxq;
  public static final String Yxr;
  public static String nsC;
  
  static
  {
    AppMethodBeat.i(133039);
    nsC = "android-" + Build.VERSION.SDK_INT;
    YwZ = 2;
    Yxa = Build.BRAND;
    Yxb = q.aPo() + Build.CPU_ABI;
    Yxc = "android-" + Build.VERSION.SDK_INT;
    Yxd = "android-" + Build.MANUFACTURER;
    Yxe = Build.VERSION.SDK_INT;
    Yxf = Build.MANUFACTURER + "-" + q.aPo();
    Yxg = 0L;
    Yxh = Integer.decode(BuildInfo.CLIENT_VERSION).intValue();
    Assert.assertNotNull(BuildInfo.CLIENT_VERSION);
    try
    {
      int i = MMApplicationContext.getContext().getPackageManager().getApplicationInfo(MMApplicationContext.getPackageName(), 128).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
      if ((i > Yxh) && (i - Yxh < 255) && ((i & 0xFF) >= 48)) {
        Yxh = i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("MicroMsg.ConstantsProtocal", "", new Object[] { localException });
      }
    }
    Yxi = iPH();
    Yxj = iPG();
    Yxk = iPE();
    Yxl = iPF();
    Yxm = 5;
    Yxn = null;
    Yxo = null;
    Yxp = null;
    Yxq = "http://" + WeChatHosts.domainString(j.b.host_mp_weixin_qq_com) + "/mp/lifedetail?bid=%s&action=list#wechat_redirect";
    Yxr = "http://" + WeChatHosts.domainString(j.b.host_mp_weixin_qq_com) + "/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect";
    AppMethodBeat.o(133039);
  }
  
  public static void axo(int paramInt)
  {
    AppMethodBeat.i(133038);
    Yxh = paramInt;
    Yxk = iPE();
    Yxi = iPH();
    Yxj = iPG();
    Yxl = iPF();
    AppMethodBeat.o(133038);
  }
  
  private static boolean iPE()
  {
    return ((Yxh & 0xFF) >= 16) && ((Yxh & 0xFF) <= 47);
  }
  
  private static boolean iPF()
  {
    return ((Yxh & 0xFF) >= 0) && ((Yxh & 0xFF) <= 15);
  }
  
  private static boolean iPG()
  {
    return ((Yxh & 0xFF) >= 96) && ((Yxh & 0xFF) <= 255);
  }
  
  private static boolean iPH()
  {
    return ((Yxh & 0xFF) >= 48) && ((Yxh & 0xFF) <= 95);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.d
 * JD-Core Version:    0.7.0.1
 */