package com.tencent.mm.protocal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import junit.framework.Assert;

public final class d
  extends e
{
  public static final String DEVICE_NAME;
  public static String eQs;
  public static final String whB;
  public static final String whC;
  public static String whD;
  public static final String whE;
  public static String whF;
  public static long whG;
  public static int whH;
  public static boolean whI;
  public static boolean whJ;
  public static boolean whK;
  public static boolean whL;
  public static int whM;
  public static final byte[] whN;
  public static final byte[] whO;
  public static final byte[] whP;
  
  static
  {
    AppMethodBeat.i(58789);
    eQs = "android-" + Build.VERSION.SDK_INT;
    whB = Build.BRAND;
    whC = Build.MODEL + Build.CPU_ABI;
    whD = "android-" + Build.VERSION.SDK_INT;
    whE = "android-" + Build.MANUFACTURER;
    whF = Build.VERSION.SDK_INT;
    DEVICE_NAME = Build.MANUFACTURER + "-" + Build.MODEL;
    whG = 0L;
    whH = Integer.decode(f.CLIENT_VERSION).intValue();
    Assert.assertNotNull(f.CLIENT_VERSION);
    try
    {
      int i = ah.getContext().getPackageManager().getApplicationInfo(ah.getPackageName(), 128).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
      if ((i > whH) && (i - whH < 255) && ((i & 0xFF) >= 48)) {
        whH = i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.a("MicroMsg.ConstantsProtocal", "", new Object[] { localException });
      }
    }
    whI = dqr();
    whJ = dqq();
    whK = dqo();
    whL = dqp();
    whM = 5;
    whN = null;
    whO = null;
    whP = null;
    AppMethodBeat.o(58789);
  }
  
  public static void MA(int paramInt)
  {
    AppMethodBeat.i(58788);
    whH = paramInt;
    whK = dqo();
    whI = dqr();
    whJ = dqq();
    whL = dqp();
    AppMethodBeat.o(58788);
  }
  
  private static boolean dqo()
  {
    return ((whH & 0xFF) >= 0) && ((whH & 0xFF) <= 47);
  }
  
  private static boolean dqp()
  {
    return ((whH & 0xFF) >= 0) && ((whH & 0xFF) <= 15);
  }
  
  private static boolean dqq()
  {
    return ((whH & 0xFF) >= 96) && ((whH & 0xFF) <= 255);
  }
  
  private static boolean dqr()
  {
    return ((whH & 0xFF) >= 48) && ((whH & 0xFF) <= 95);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.d
 * JD-Core Version:    0.7.0.1
 */