package com.tencent.mm.protocal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import junit.framework.Assert;

public final class d
  extends e
{
  public static String RAA;
  public static final String RAB;
  public static long RAC;
  public static int RAD;
  public static boolean RAE;
  public static boolean RAF;
  public static boolean RAG;
  public static boolean RAH;
  public static int RAI;
  public static final byte[] RAJ;
  public static final byte[] RAK;
  public static final byte[] RAL;
  public static final String RAM;
  public static final String RAN;
  public static int RAv;
  public static final String RAw;
  public static final String RAx;
  public static String RAy;
  public static final String RAz;
  public static String kQZ;
  
  static
  {
    AppMethodBeat.i(133039);
    kQZ = "android-" + Build.VERSION.SDK_INT;
    RAv = 2;
    RAw = Build.BRAND;
    RAx = Build.MODEL + Build.CPU_ABI;
    RAy = "android-" + Build.VERSION.SDK_INT;
    RAz = "android-" + Build.MANUFACTURER;
    RAA = Build.VERSION.SDK_INT;
    RAB = Build.MANUFACTURER + "-" + Build.MODEL;
    RAC = 0L;
    RAD = Integer.decode(BuildInfo.CLIENT_VERSION).intValue();
    Assert.assertNotNull(BuildInfo.CLIENT_VERSION);
    try
    {
      int i = MMApplicationContext.getContext().getPackageManager().getApplicationInfo(MMApplicationContext.getPackageName(), 128).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
      if ((i > RAD) && (i - RAD < 255) && ((i & 0xFF) >= 48)) {
        RAD = i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("MicroMsg.ConstantsProtocal", "", new Object[] { localException });
      }
    }
    RAE = hoL();
    RAF = hoK();
    RAG = hoI();
    RAH = hoJ();
    RAI = 5;
    RAJ = null;
    RAK = null;
    RAL = null;
    RAM = "http://" + WeChatHosts.domainString(j.b.host_mp_weixin_qq_com) + "/mp/lifedetail?bid=%s&action=list#wechat_redirect";
    RAN = "http://" + WeChatHosts.domainString(j.b.host_mp_weixin_qq_com) + "/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect";
    AppMethodBeat.o(133039);
  }
  
  public static void arg(int paramInt)
  {
    AppMethodBeat.i(133038);
    RAD = paramInt;
    RAG = hoI();
    RAE = hoL();
    RAF = hoK();
    RAH = hoJ();
    AppMethodBeat.o(133038);
  }
  
  private static boolean hoI()
  {
    return ((RAD & 0xFF) >= 16) && ((RAD & 0xFF) <= 47);
  }
  
  private static boolean hoJ()
  {
    return ((RAD & 0xFF) >= 0) && ((RAD & 0xFF) <= 15);
  }
  
  private static boolean hoK()
  {
    return ((RAD & 0xFF) >= 96) && ((RAD & 0xFF) <= 255);
  }
  
  private static boolean hoL()
  {
    return ((RAD & 0xFF) >= 48) && ((RAD & 0xFF) <= 95);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.d
 * JD-Core Version:    0.7.0.1
 */