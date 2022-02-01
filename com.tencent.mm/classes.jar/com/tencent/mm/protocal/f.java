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
  public static boolean Fns;
  public static boolean Fnt;
  private static int Fnu;
  private static byte[] Fnv;
  private static byte[] Fnw;
  public static int Fnx;
  private static long Fny;
  
  static
  {
    AppMethodBeat.i(133044);
    Fns = false;
    Fnt = false;
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("auth_info_key_prefs", g.abm());
    Fns = localSharedPreferences.getBoolean("auth_info_prefs_use_new_ecdh", true);
    Fnt = localSharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
    ad.i("MicroMsg.EcdhMgr", "summerauths USE_ECDH[%s] USE_ML[%s]", new Object[] { Boolean.valueOf(Fns), Boolean.valueOf(Fnt) });
    if (Fnt)
    {
      Fnx = 10001;
      Fnu = 415;
      Fnv = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
    }
    for (Fnw = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);; Fnw = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0))
    {
      Fny = 0L;
      AppMethodBeat.o(133044);
      return;
      Fnx = 10002;
      Fnu = 415;
      Fnv = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
    }
  }
  
  public static void CF(long paramLong)
  {
    AppMethodBeat.i(133042);
    UtilsJni.ReleaseHybridEcdhCryptoEngine(paramLong);
    ad.i("MicroMsg.EcdhMgr", "summerauths releaseHybridEcdhCryptoEngine engine[%s] stack[%s]", new Object[] { Long.valueOf(paramLong), bt.flS() });
    AppMethodBeat.o(133042);
  }
  
  public static long cl(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133041);
    long l = UtilsJni.CreateHybridEcdhCryptoEngine(Fnu, Fnv, Fnw, paramArrayOfByte);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      ad.i("MicroMsg.EcdhMgr", "summerauths getHybridEcdhCryptoEngine engine[%s] autoauth_key[%s] nid[%s] stack[%s]", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(Fnu), bt.flS() });
      AppMethodBeat.o(133041);
      return l;
    }
  }
  
  public static boolean fgi()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(133043);
        ad.i("MicroMsg.EcdhMgr", "summerauths switchCert LAST_SWITCH_TIME[%s] old USE_ML[%s] stack[%s]", new Object[] { Long.valueOf(Fny), Boolean.valueOf(Fnt), bt.flS() });
        long l = SystemClock.elapsedRealtime();
        if ((600000L >= l - Fny) && (Fny > 0L))
        {
          ad.i("MicroMsg.EcdhMgr", "summerauths switchCert LAST_SWITCH_TIME freq limit [%s]ms ret false", new Object[] { Long.valueOf(l - Fny) });
          AppMethodBeat.o(133043);
          return bool1;
        }
        Fny = SystemClock.elapsedRealtime();
        bool1 = bool2;
        if (!Fnt) {
          bool1 = true;
        }
        Fnt = bool1;
        SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("auth_info_key_prefs", g.abm());
        bool1 = localSharedPreferences.edit().putBoolean("auth_info_prefs_use_net_ml_cert", Fnt).commit();
        localSharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
        ad.i("MicroMsg.EcdhMgr", "summerauths switchCert to [%s] save sp[%s]", new Object[] { Boolean.valueOf(Fnt), Boolean.valueOf(bool1) });
        if (Fnt)
        {
          Fnx = 10001;
          Fnu = 415;
          Fnv = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
          Fnw = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
          AppMethodBeat.o(133043);
          continue;
        }
        Fnx = 10002;
      }
      finally {}
      Fnu = 415;
      Fnv = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
      Fnw = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
    }
  }
  
  public static byte[] fgj()
  {
    return Fnv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.f
 * JD-Core Version:    0.7.0.1
 */