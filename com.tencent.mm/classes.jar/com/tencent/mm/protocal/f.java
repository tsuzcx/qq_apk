package com.tencent.mm.protocal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class f
{
  public static boolean DIl;
  public static boolean DIm;
  private static int DIn;
  private static byte[] DIo;
  private static byte[] DIp;
  public static int DIq;
  private static long DIr;
  
  static
  {
    AppMethodBeat.i(133044);
    DIl = false;
    DIm = false;
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("auth_info_key_prefs", g.YK());
    DIl = localSharedPreferences.getBoolean("auth_info_prefs_use_new_ecdh", true);
    DIm = localSharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
    ac.i("MicroMsg.EcdhMgr", "summerauths USE_ECDH[%s] USE_ML[%s]", new Object[] { Boolean.valueOf(DIl), Boolean.valueOf(DIm) });
    if (DIm)
    {
      DIq = 10001;
      DIn = 415;
      DIo = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
    }
    for (DIp = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);; DIp = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0))
    {
      DIr = 0L;
      AppMethodBeat.o(133044);
      return;
      DIq = 10002;
      DIn = 415;
      DIo = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
    }
  }
  
  public static long ce(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133041);
    long l = UtilsJni.CreateHybridEcdhCryptoEngine(DIn, DIo, DIp, paramArrayOfByte);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      ac.i("MicroMsg.EcdhMgr", "summerauths getHybridEcdhCryptoEngine engine[%s] autoauth_key[%s] nid[%s] stack[%s]", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(DIn), bs.eWi() });
      AppMethodBeat.o(133041);
      return l;
    }
  }
  
  public static boolean eRe()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(133043);
        ac.i("MicroMsg.EcdhMgr", "summerauths switchCert LAST_SWITCH_TIME[%s] old USE_ML[%s] stack[%s]", new Object[] { Long.valueOf(DIr), Boolean.valueOf(DIm), bs.eWi() });
        long l = SystemClock.elapsedRealtime();
        if ((600000L >= l - DIr) && (DIr > 0L))
        {
          ac.i("MicroMsg.EcdhMgr", "summerauths switchCert LAST_SWITCH_TIME freq limit [%s]ms ret false", new Object[] { Long.valueOf(l - DIr) });
          AppMethodBeat.o(133043);
          return bool1;
        }
        DIr = SystemClock.elapsedRealtime();
        bool1 = bool2;
        if (!DIm) {
          bool1 = true;
        }
        DIm = bool1;
        SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("auth_info_key_prefs", g.YK());
        bool1 = localSharedPreferences.edit().putBoolean("auth_info_prefs_use_net_ml_cert", DIm).commit();
        localSharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
        ac.i("MicroMsg.EcdhMgr", "summerauths switchCert to [%s] save sp[%s]", new Object[] { Boolean.valueOf(DIm), Boolean.valueOf(bool1) });
        if (DIm)
        {
          DIq = 10001;
          DIn = 415;
          DIo = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
          DIp = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
          AppMethodBeat.o(133043);
          continue;
        }
        DIq = 10002;
      }
      finally {}
      DIn = 415;
      DIo = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
      DIp = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
    }
  }
  
  public static byte[] eRf()
  {
    return DIo;
  }
  
  public static void zR(long paramLong)
  {
    AppMethodBeat.i(133042);
    UtilsJni.ReleaseHybridEcdhCryptoEngine(paramLong);
    ac.i("MicroMsg.EcdhMgr", "summerauths releaseHybridEcdhCryptoEngine engine[%s] stack[%s]", new Object[] { Long.valueOf(paramLong), bs.eWi() });
    AppMethodBeat.o(133042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.f
 * JD-Core Version:    0.7.0.1
 */