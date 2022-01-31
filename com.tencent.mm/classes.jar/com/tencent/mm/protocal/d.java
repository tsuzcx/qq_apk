package com.tencent.mm.protocal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class d
  extends e
{
  public static final String DEVICE_NAME;
  public static String dOM = "android-" + Build.VERSION.SDK_INT;
  public static final String soU = Build.BRAND;
  public static final String soV = Build.MODEL + Build.CPU_ABI;
  public static String soW = "android-" + Build.VERSION.SDK_INT;
  public static final String soX = "android-" + Build.MANUFACTURER;
  public static String soY = Build.VERSION.SDK_INT;
  public static long soZ;
  public static int spa;
  public static boolean spb = coU();
  public static boolean spc = coT();
  public static boolean spd = coR();
  public static boolean spe = coS();
  public static int spf = 5;
  public static final byte[] spg = null;
  public static final byte[] sph = null;
  public static final byte[] spi = null;
  
  static
  {
    DEVICE_NAME = Build.MANUFACTURER + "-" + Build.MODEL;
    soZ = 0L;
    spa = Integer.decode(com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION).intValue();
    Assert.assertNotNull(com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION);
    try
    {
      int i = ae.getContext().getPackageManager().getApplicationInfo(ae.getPackageName(), 128).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
      if ((i > spa) && (i - spa < 255) && ((i & 0xFF) >= 48)) {
        spa = i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.b("MicroMsg.ConstantsProtocal", "", new Object[] { localException });
      }
    }
  }
  
  public static void EC(int paramInt)
  {
    spa = paramInt;
    spd = coR();
    spb = coU();
    spc = coT();
    spe = coS();
  }
  
  private static boolean coR()
  {
    return ((spa & 0xFF) >= 0) && ((spa & 0xFF) <= 47);
  }
  
  private static boolean coS()
  {
    return ((spa & 0xFF) >= 0) && ((spa & 0xFF) <= 15);
  }
  
  private static boolean coT()
  {
    return ((spa & 0xFF) >= 96) && ((spa & 0xFF) <= 255);
  }
  
  private static boolean coU()
  {
    return ((spa & 0xFF) >= 48) && ((spa & 0xFF) <= 95);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.d
 * JD-Core Version:    0.7.0.1
 */