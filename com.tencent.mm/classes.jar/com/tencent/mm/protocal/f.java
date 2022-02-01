package com.tencent.mm.protocal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  public static boolean KyZ;
  public static boolean Kza;
  private static int Kzb;
  private static byte[] Kzc;
  private static byte[] Kzd;
  public static int Kze;
  private static long Kzf;
  
  static
  {
    AppMethodBeat.i(133044);
    KyZ = false;
    Kza = false;
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", g.aps());
    KyZ = localSharedPreferences.getBoolean("auth_info_prefs_use_new_ecdh", true);
    Kza = localSharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
    Log.i("MicroMsg.EcdhMgr", "summerauths USE_ECDH[%s] USE_ML[%s]", new Object[] { Boolean.valueOf(KyZ), Boolean.valueOf(Kza) });
    if (Kza)
    {
      Kze = 10001;
      Kzb = 415;
      Kzc = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
    }
    for (Kzd = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);; Kzd = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0))
    {
      Kzf = 0L;
      AppMethodBeat.o(133044);
      return;
      Kze = 10002;
      Kzb = 415;
      Kzc = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
    }
  }
  
  public static void Mt(long paramLong)
  {
    AppMethodBeat.i(133042);
    UtilsJni.ReleaseHybridEcdhCryptoEngine(paramLong);
    Log.i("MicroMsg.EcdhMgr", "summerauths releaseHybridEcdhCryptoEngine engine[%s] stack[%s]", new Object[] { Long.valueOf(paramLong), Util.getStack() });
    AppMethodBeat.o(133042);
  }
  
  public static long cF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133041);
    long l = UtilsJni.CreateHybridEcdhCryptoEngine(Kzb, Kzc, Kzd, paramArrayOfByte);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      Log.i("MicroMsg.EcdhMgr", "summerauths getHybridEcdhCryptoEngine engine[%s] autoauth_key[%s] nid[%s] stack[%s]", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(Kzb), Util.getStack() });
      AppMethodBeat.o(133041);
      return l;
    }
  }
  
  public static byte[] gtA()
  {
    return Kzc;
  }
  
  public static boolean gtz()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(133043);
        Log.i("MicroMsg.EcdhMgr", "summerauths switchCert LAST_SWITCH_TIME[%s] old USE_ML[%s] stack[%s]", new Object[] { Long.valueOf(Kzf), Boolean.valueOf(Kza), Util.getStack() });
        long l = SystemClock.elapsedRealtime();
        if ((600000L >= l - Kzf) && (Kzf > 0L))
        {
          Log.i("MicroMsg.EcdhMgr", "summerauths switchCert LAST_SWITCH_TIME freq limit [%s]ms ret false", new Object[] { Long.valueOf(l - Kzf) });
          AppMethodBeat.o(133043);
          return bool1;
        }
        Kzf = SystemClock.elapsedRealtime();
        bool1 = bool2;
        if (!Kza) {
          bool1 = true;
        }
        Kza = bool1;
        SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", g.aps());
        bool1 = localSharedPreferences.edit().putBoolean("auth_info_prefs_use_net_ml_cert", Kza).commit();
        localSharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
        Log.i("MicroMsg.EcdhMgr", "summerauths switchCert to [%s] save sp[%s]", new Object[] { Boolean.valueOf(Kza), Boolean.valueOf(bool1) });
        if (Kza)
        {
          Kze = 10001;
          Kzb = 415;
          Kzc = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
          Kzd = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
          AppMethodBeat.o(133043);
          continue;
        }
        Kze = 10002;
      }
      finally {}
      Kzb = 415;
      Kzc = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
      Kzd = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.f
 * JD-Core Version:    0.7.0.1
 */