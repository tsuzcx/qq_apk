package com.tencent.mm.protocal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import junit.framework.Assert;

public final class d
  extends e
{
  public static final String DEVICE_NAME;
  public static int KyH;
  public static final String KyI;
  public static final String KyJ;
  public static String KyK;
  public static final String KyL;
  public static String KyM;
  public static long KyN;
  public static int KyO;
  public static boolean KyP;
  public static boolean KyQ;
  public static boolean KyR;
  public static boolean KyS;
  public static int KyT;
  public static final byte[] KyU;
  public static final byte[] KyV;
  public static final byte[] KyW;
  public static final String KyX;
  public static final String KyY;
  public static String ics;
  
  static
  {
    AppMethodBeat.i(133039);
    ics = "android-" + Build.VERSION.SDK_INT;
    KyH = 2;
    KyI = Build.BRAND;
    KyJ = Build.MODEL + Build.CPU_ABI;
    KyK = "android-" + Build.VERSION.SDK_INT;
    KyL = "android-" + Build.MANUFACTURER;
    KyM = Build.VERSION.SDK_INT;
    DEVICE_NAME = Build.MANUFACTURER + "-" + Build.MODEL;
    KyN = 0L;
    KyO = Integer.decode(BuildInfo.CLIENT_VERSION).intValue();
    Assert.assertNotNull(BuildInfo.CLIENT_VERSION);
    try
    {
      int i = MMApplicationContext.getContext().getPackageManager().getApplicationInfo(MMApplicationContext.getPackageName(), 128).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
      if ((i > KyO) && (i - KyO < 255) && ((i & 0xFF) >= 48)) {
        KyO = i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printDebugStack("MicroMsg.ConstantsProtocal", "", new Object[] { localException });
      }
    }
    KyP = gty();
    KyQ = gtx();
    KyR = gtv();
    KyS = gtw();
    KyT = 5;
    KyU = null;
    KyV = null;
    KyW = null;
    KyX = "http://" + WeChatHosts.domainString(2131761726) + "/mp/lifedetail?bid=%s&action=list#wechat_redirect";
    KyY = "http://" + WeChatHosts.domainString(2131761726) + "/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect";
    AppMethodBeat.o(133039);
  }
  
  public static void aiV(int paramInt)
  {
    AppMethodBeat.i(133038);
    KyO = paramInt;
    KyR = gtv();
    KyP = gty();
    KyQ = gtx();
    KyS = gtw();
    AppMethodBeat.o(133038);
  }
  
  private static boolean gtv()
  {
    return ((KyO & 0xFF) >= 16) && ((KyO & 0xFF) <= 47);
  }
  
  private static boolean gtw()
  {
    return ((KyO & 0xFF) >= 0) && ((KyO & 0xFF) <= 15);
  }
  
  private static boolean gtx()
  {
    return ((KyO & 0xFF) >= 96) && ((KyO & 0xFF) <= 255);
  }
  
  private static boolean gty()
  {
    return ((KyO & 0xFF) >= 48) && ((KyO & 0xFF) <= 95);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.d
 * JD-Core Version:    0.7.0.1
 */