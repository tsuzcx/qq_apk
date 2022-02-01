package com.tencent.mm.protocal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.j;
import junit.framework.Assert;

public final class d
  extends e
{
  public static final String DEVICE_NAME;
  public static final String FFB;
  public static final String FFC;
  public static String FFD;
  public static final String FFE;
  public static String FFF;
  public static long FFG;
  public static int FFH;
  public static boolean FFI;
  public static boolean FFJ;
  public static boolean FFK;
  public static boolean FFL;
  public static int FFM;
  public static final byte[] FFN;
  public static final byte[] FFO;
  public static final byte[] FFP;
  public static String hjv;
  
  static
  {
    AppMethodBeat.i(133039);
    hjv = "android-" + Build.VERSION.SDK_INT;
    FFB = Build.BRAND;
    FFC = Build.MODEL + Build.CPU_ABI;
    FFD = "android-" + Build.VERSION.SDK_INT;
    FFE = "android-" + Build.MANUFACTURER;
    FFF = Build.VERSION.SDK_INT;
    DEVICE_NAME = Build.MANUFACTURER + "-" + Build.MODEL;
    FFG = 0L;
    FFH = Integer.decode(j.hju).intValue();
    Assert.assertNotNull(j.hju);
    try
    {
      int i = ak.getContext().getPackageManager().getApplicationInfo(ak.getPackageName(), 128).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
      if ((i > FFH) && (i - FFH < 255) && ((i & 0xFF) >= 48)) {
        FFH = i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.l("MicroMsg.ConstantsProtocal", "", new Object[] { localException });
      }
    }
    FFI = fjX();
    FFJ = fjW();
    FFK = fjU();
    FFL = fjV();
    FFM = 5;
    FFN = null;
    FFO = null;
    FFP = null;
    AppMethodBeat.o(133039);
  }
  
  public static void aag(int paramInt)
  {
    AppMethodBeat.i(133038);
    FFH = paramInt;
    FFK = fjU();
    FFI = fjX();
    FFJ = fjW();
    FFL = fjV();
    AppMethodBeat.o(133038);
  }
  
  private static boolean fjU()
  {
    return ((FFH & 0xFF) >= 0) && ((FFH & 0xFF) <= 47);
  }
  
  private static boolean fjV()
  {
    return ((FFH & 0xFF) >= 0) && ((FFH & 0xFF) <= 15);
  }
  
  private static boolean fjW()
  {
    return ((FFH & 0xFF) >= 96) && ((FFH & 0xFF) <= 255);
  }
  
  private static boolean fjX()
  {
    return ((FFH & 0xFF) >= 48) && ((FFH & 0xFF) <= 95);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.d
 * JD-Core Version:    0.7.0.1
 */