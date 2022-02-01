package com.tencent.mm.protocal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class f
{
  public static boolean FFQ;
  public static boolean FFR;
  private static int FFS;
  private static byte[] FFT;
  private static byte[] FFU;
  public static int FFV;
  private static long FFW;
  
  static
  {
    AppMethodBeat.i(133044);
    FFQ = false;
    FFR = false;
    SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("auth_info_key_prefs", g.abv());
    FFQ = localSharedPreferences.getBoolean("auth_info_prefs_use_new_ecdh", true);
    FFR = localSharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
    ae.i("MicroMsg.EcdhMgr", "summerauths USE_ECDH[%s] USE_ML[%s]", new Object[] { Boolean.valueOf(FFQ), Boolean.valueOf(FFR) });
    if (FFR)
    {
      FFV = 10001;
      FFS = 415;
      FFT = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
    }
    for (FFU = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);; FFU = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0))
    {
      FFW = 0L;
      AppMethodBeat.o(133044);
      return;
      FFV = 10002;
      FFS = 415;
      FFT = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
    }
  }
  
  public static void Dd(long paramLong)
  {
    AppMethodBeat.i(133042);
    UtilsJni.ReleaseHybridEcdhCryptoEngine(paramLong);
    ae.i("MicroMsg.EcdhMgr", "summerauths releaseHybridEcdhCryptoEngine engine[%s] stack[%s]", new Object[] { Long.valueOf(paramLong), bu.fpN() });
    AppMethodBeat.o(133042);
  }
  
  public static long co(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133041);
    long l = UtilsJni.CreateHybridEcdhCryptoEngine(FFS, FFT, FFU, paramArrayOfByte);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      ae.i("MicroMsg.EcdhMgr", "summerauths getHybridEcdhCryptoEngine engine[%s] autoauth_key[%s] nid[%s] stack[%s]", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(FFS), bu.fpN() });
      AppMethodBeat.o(133041);
      return l;
    }
  }
  
  public static boolean fjY()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(133043);
        ae.i("MicroMsg.EcdhMgr", "summerauths switchCert LAST_SWITCH_TIME[%s] old USE_ML[%s] stack[%s]", new Object[] { Long.valueOf(FFW), Boolean.valueOf(FFR), bu.fpN() });
        long l = SystemClock.elapsedRealtime();
        if ((600000L >= l - FFW) && (FFW > 0L))
        {
          ae.i("MicroMsg.EcdhMgr", "summerauths switchCert LAST_SWITCH_TIME freq limit [%s]ms ret false", new Object[] { Long.valueOf(l - FFW) });
          AppMethodBeat.o(133043);
          return bool1;
        }
        FFW = SystemClock.elapsedRealtime();
        bool1 = bool2;
        if (!FFR) {
          bool1 = true;
        }
        FFR = bool1;
        SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("auth_info_key_prefs", g.abv());
        bool1 = localSharedPreferences.edit().putBoolean("auth_info_prefs_use_net_ml_cert", FFR).commit();
        localSharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
        ae.i("MicroMsg.EcdhMgr", "summerauths switchCert to [%s] save sp[%s]", new Object[] { Boolean.valueOf(FFR), Boolean.valueOf(bool1) });
        if (FFR)
        {
          FFV = 10001;
          FFS = 415;
          FFT = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
          FFU = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
          AppMethodBeat.o(133043);
          continue;
        }
        FFV = 10002;
      }
      finally {}
      FFS = 415;
      FFT = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
      FFU = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
    }
  }
  
  public static byte[] fjZ()
  {
    return FFT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.f
 * JD-Core Version:    0.7.0.1
 */