package com.tencent.mm.protocal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.h;
import junit.framework.Assert;

public final class d
  extends e
{
  public static final String CpE;
  public static final String CpF;
  public static String CpG;
  public static final String CpH;
  public static String CpI;
  public static long CpJ;
  public static int CpK;
  public static boolean CpL;
  public static boolean CpM;
  public static boolean CpN;
  public static boolean CpO;
  public static int CpP;
  public static final byte[] CpQ;
  public static final byte[] CpR;
  public static final byte[] CpS;
  public static final String DEVICE_NAME;
  public static String glX;
  
  static
  {
    AppMethodBeat.i(133039);
    glX = "android-" + Build.VERSION.SDK_INT;
    CpE = Build.BRAND;
    CpF = Build.MODEL + Build.CPU_ABI;
    CpG = "android-" + Build.VERSION.SDK_INT;
    CpH = "android-" + Build.MANUFACTURER;
    CpI = Build.VERSION.SDK_INT;
    DEVICE_NAME = Build.MANUFACTURER + "-" + Build.MODEL;
    CpJ = 0L;
    CpK = Integer.decode(h.glW).intValue();
    Assert.assertNotNull(h.glW);
    try
    {
      int i = aj.getContext().getPackageManager().getApplicationInfo(aj.getPackageName(), 128).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
      if ((i > CpK) && (i - CpK < 255) && ((i & 0xFF) >= 48)) {
        CpK = i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.l("MicroMsg.ConstantsProtocal", "", new Object[] { localException });
      }
    }
    CpL = eBI();
    CpM = eBH();
    CpN = eBF();
    CpO = eBG();
    CpP = 5;
    CpQ = null;
    CpR = null;
    CpS = null;
    AppMethodBeat.o(133039);
  }
  
  public static void Vv(int paramInt)
  {
    AppMethodBeat.i(133038);
    CpK = paramInt;
    CpN = eBF();
    CpL = eBI();
    CpM = eBH();
    CpO = eBG();
    AppMethodBeat.o(133038);
  }
  
  private static boolean eBF()
  {
    return ((CpK & 0xFF) >= 0) && ((CpK & 0xFF) <= 47);
  }
  
  private static boolean eBG()
  {
    return ((CpK & 0xFF) >= 0) && ((CpK & 0xFF) <= 15);
  }
  
  private static boolean eBH()
  {
    return ((CpK & 0xFF) >= 96) && ((CpK & 0xFF) <= 255);
  }
  
  private static boolean eBI()
  {
    return ((CpK & 0xFF) >= 48) && ((CpK & 0xFF) <= 95);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.d
 * JD-Core Version:    0.7.0.1
 */