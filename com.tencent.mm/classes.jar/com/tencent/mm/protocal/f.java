package com.tencent.mm.protocal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
{
  public static boolean CpT;
  public static boolean CpU;
  private static int CpV;
  private static byte[] CpW;
  private static byte[] CpX;
  public static int CpY;
  private static long CpZ;
  
  static
  {
    AppMethodBeat.i(133044);
    CpT = false;
    CpU = false;
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("auth_info_key_prefs", g.XN());
    CpT = localSharedPreferences.getBoolean("auth_info_prefs_use_new_ecdh", true);
    CpU = localSharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
    ad.i("MicroMsg.EcdhMgr", "summerauths USE_ECDH[%s] USE_ML[%s]", new Object[] { Boolean.valueOf(CpT), Boolean.valueOf(CpU) });
    if (CpU)
    {
      CpY = 10001;
      CpV = 415;
      CpW = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
    }
    for (CpX = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);; CpX = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0))
    {
      CpZ = 0L;
      AppMethodBeat.o(133044);
      return;
      CpY = 10002;
      CpV = 415;
      CpW = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
    }
  }
  
  public static long cf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133041);
    long l = UtilsJni.CreateHybridEcdhCryptoEngine(CpV, CpW, CpX, paramArrayOfByte);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      ad.i("MicroMsg.EcdhMgr", "summerauths getHybridEcdhCryptoEngine engine[%s] autoauth_key[%s] nid[%s] stack[%s]", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(CpV), bt.eGN() });
      AppMethodBeat.o(133041);
      return l;
    }
  }
  
  public static boolean eBJ()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(133043);
        ad.i("MicroMsg.EcdhMgr", "summerauths switchCert LAST_SWITCH_TIME[%s] old USE_ML[%s] stack[%s]", new Object[] { Long.valueOf(CpZ), Boolean.valueOf(CpU), bt.eGN() });
        long l = SystemClock.elapsedRealtime();
        if ((600000L >= l - CpZ) && (CpZ > 0L))
        {
          ad.i("MicroMsg.EcdhMgr", "summerauths switchCert LAST_SWITCH_TIME freq limit [%s]ms ret false", new Object[] { Long.valueOf(l - CpZ) });
          AppMethodBeat.o(133043);
          return bool1;
        }
        CpZ = SystemClock.elapsedRealtime();
        bool1 = bool2;
        if (!CpU) {
          bool1 = true;
        }
        CpU = bool1;
        SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("auth_info_key_prefs", g.XN());
        bool1 = localSharedPreferences.edit().putBoolean("auth_info_prefs_use_net_ml_cert", CpU).commit();
        localSharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
        ad.i("MicroMsg.EcdhMgr", "summerauths switchCert to [%s] save sp[%s]", new Object[] { Boolean.valueOf(CpU), Boolean.valueOf(bool1) });
        if (CpU)
        {
          CpY = 10001;
          CpV = 415;
          CpW = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
          CpX = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
          AppMethodBeat.o(133043);
          continue;
        }
        CpY = 10002;
      }
      finally {}
      CpV = 415;
      CpW = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
      CpX = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
    }
  }
  
  public static byte[] eBK()
  {
    return CpW;
  }
  
  public static void vo(long paramLong)
  {
    AppMethodBeat.i(133042);
    UtilsJni.ReleaseHybridEcdhCryptoEngine(paramLong);
    ad.i("MicroMsg.EcdhMgr", "summerauths releaseHybridEcdhCryptoEngine engine[%s] stack[%s]", new Object[] { Long.valueOf(paramLong), bt.eGN() });
    AppMethodBeat.o(133042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.f
 * JD-Core Version:    0.7.0.1
 */