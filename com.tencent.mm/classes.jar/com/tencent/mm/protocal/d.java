package com.tencent.mm.protocal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.h;
import junit.framework.Assert;

public final class d
  extends e
{
  public static final String DEVICE_NAME;
  public static final String DHW;
  public static final String DHX;
  public static String DHY;
  public static final String DHZ;
  public static String DIa;
  public static long DIb;
  public static int DIc;
  public static boolean DId;
  public static boolean DIe;
  public static boolean DIf;
  public static boolean DIg;
  public static int DIh;
  public static final byte[] DIi;
  public static final byte[] DIj;
  public static final byte[] DIk;
  public static String gMK;
  
  static
  {
    AppMethodBeat.i(133039);
    gMK = "android-" + Build.VERSION.SDK_INT;
    DHW = Build.BRAND;
    DHX = Build.MODEL + Build.CPU_ABI;
    DHY = "android-" + Build.VERSION.SDK_INT;
    DHZ = "android-" + Build.MANUFACTURER;
    DIa = Build.VERSION.SDK_INT;
    DEVICE_NAME = Build.MANUFACTURER + "-" + Build.MODEL;
    DIb = 0L;
    DIc = Integer.decode(h.gMJ).intValue();
    Assert.assertNotNull(h.gMJ);
    try
    {
      int i = ai.getContext().getPackageManager().getApplicationInfo(ai.getPackageName(), 128).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
      if ((i > DIc) && (i - DIc < 255) && ((i & 0xFF) >= 48)) {
        DIc = i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.l("MicroMsg.ConstantsProtocal", "", new Object[] { localException });
      }
    }
    DId = eRd();
    DIe = eRc();
    DIf = eRa();
    DIg = eRb();
    DIh = 5;
    DIi = null;
    DIj = null;
    DIk = null;
    AppMethodBeat.o(133039);
  }
  
  public static void XE(int paramInt)
  {
    AppMethodBeat.i(133038);
    DIc = paramInt;
    DIf = eRa();
    DId = eRd();
    DIe = eRc();
    DIg = eRb();
    AppMethodBeat.o(133038);
  }
  
  private static boolean eRa()
  {
    return ((DIc & 0xFF) >= 0) && ((DIc & 0xFF) <= 47);
  }
  
  private static boolean eRb()
  {
    return ((DIc & 0xFF) >= 0) && ((DIc & 0xFF) <= 15);
  }
  
  private static boolean eRc()
  {
    return ((DIc & 0xFF) >= 96) && ((DIc & 0xFF) <= 255);
  }
  
  private static boolean eRd()
  {
    return ((DIc & 0xFF) >= 48) && ((DIc & 0xFF) <= 95);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.d
 * JD-Core Version:    0.7.0.1
 */