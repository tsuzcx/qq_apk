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
import com.tencent.mm.sdk.platformtools.i;
import junit.framework.Assert;

public final class d
  extends e
{
  public static final String DEVICE_NAME;
  public static final String Fnd;
  public static final String Fne;
  public static String Fnf;
  public static final String Fng;
  public static String Fnh;
  public static long Fni;
  public static int Fnj;
  public static boolean Fnk;
  public static boolean Fnl;
  public static boolean Fnm;
  public static boolean Fnn;
  public static int Fno;
  public static final byte[] Fnp;
  public static final byte[] Fnq;
  public static final byte[] Fnr;
  public static String hgH;
  
  static
  {
    AppMethodBeat.i(133039);
    hgH = "android-" + Build.VERSION.SDK_INT;
    Fnd = Build.BRAND;
    Fne = Build.MODEL + Build.CPU_ABI;
    Fnf = "android-" + Build.VERSION.SDK_INT;
    Fng = "android-" + Build.MANUFACTURER;
    Fnh = Build.VERSION.SDK_INT;
    DEVICE_NAME = Build.MANUFACTURER + "-" + Build.MODEL;
    Fni = 0L;
    Fnj = Integer.decode(i.hgG).intValue();
    Assert.assertNotNull(i.hgG);
    try
    {
      int i = aj.getContext().getPackageManager().getApplicationInfo(aj.getPackageName(), 128).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
      if ((i > Fnj) && (i - Fnj < 255) && ((i & 0xFF) >= 48)) {
        Fnj = i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.l("MicroMsg.ConstantsProtocal", "", new Object[] { localException });
      }
    }
    Fnk = fgh();
    Fnl = fgg();
    Fnm = fge();
    Fnn = fgf();
    Fno = 5;
    Fnp = null;
    Fnq = null;
    Fnr = null;
    AppMethodBeat.o(133039);
  }
  
  public static void ZA(int paramInt)
  {
    AppMethodBeat.i(133038);
    Fnj = paramInt;
    Fnm = fge();
    Fnk = fgh();
    Fnl = fgg();
    Fnn = fgf();
    AppMethodBeat.o(133038);
  }
  
  private static boolean fge()
  {
    return ((Fnj & 0xFF) >= 0) && ((Fnj & 0xFF) <= 47);
  }
  
  private static boolean fgf()
  {
    return ((Fnj & 0xFF) >= 0) && ((Fnj & 0xFF) <= 15);
  }
  
  private static boolean fgg()
  {
    return ((Fnj & 0xFF) >= 96) && ((Fnj & 0xFF) <= 255);
  }
  
  private static boolean fgh()
  {
    return ((Fnj & 0xFF) >= 48) && ((Fnj & 0xFF) <= 95);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.d
 * JD-Core Version:    0.7.0.1
 */