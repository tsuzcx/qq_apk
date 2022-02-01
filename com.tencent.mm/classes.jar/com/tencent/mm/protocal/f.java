package com.tencent.mm.protocal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  public static boolean RAO;
  public static boolean RAP;
  private static int RAQ;
  private static byte[] RAR;
  private static byte[] RAS;
  private static int RAT;
  public static int RAU;
  private static long RAV;
  
  static
  {
    AppMethodBeat.i(133044);
    RAO = false;
    RAP = false;
    RAU = 1;
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.avK());
    RAO = localSharedPreferences.getBoolean("auth_info_prefs_use_new_ecdh", true);
    RAP = localSharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
    Log.i("MicroMsg.EcdhMgr", "summerauths USE_ECDH[%s] USE_ML[%s]", new Object[] { Boolean.valueOf(RAO), Boolean.valueOf(RAP) });
    hoQ();
    RAV = 0L;
    AppMethodBeat.o(133044);
  }
  
  public static void TX(long paramLong)
  {
    AppMethodBeat.i(133042);
    UtilsJni.ReleaseHybridEcdhCryptoEngine(paramLong);
    Log.i("MicroMsg.EcdhMgr", "summerauths releaseHybridEcdhCryptoEngine engine[%s] stack[%s]", new Object[] { Long.valueOf(paramLong), Util.getStack() });
    AppMethodBeat.o(133042);
  }
  
  private static void arh(int paramInt)
  {
    AppMethodBeat.i(194350);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(194350);
      return;
      hoQ();
      AppMethodBeat.o(194350);
      return;
      RAT = 10007;
      RAQ = 415;
      RAR = Base64.decode("BOplP5sD+V3TlZJ3I9Kq19fvdwLRfsj/35JH45uCHI2LT1/Z52MOK5D1T3DH2HX6359Rj2yaKBj57FV106blwJQ=", 0);
      RAS = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFZVlGbzdHZUxLUkZWYVBDVS82ZTZSanVQbWpSWgpaSFI1SmtIOHlCK3hzQVZzSHF3NFUzc2tHdUh6SUU2bW9HN2NlbUgxQVhjN0tVOW5VZWxnTytCaDdnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
    }
  }
  
  public static void ari(int paramInt)
  {
    AppMethodBeat.i(194354);
    RAT = paramInt;
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.avK());
    boolean bool = localSharedPreferences.edit().putInt("auth_info_prefs_test_ecdh_version", 1).commit();
    paramInt = localSharedPreferences.getInt("auth_info_prefs_test_ecdh_version", 0);
    Log.d("MicroMsg.EcdhMgr", "set test ecdh version " + bool + " get version " + paramInt);
    AppMethodBeat.o(194354);
  }
  
  public static long cW(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133041);
    long l = UtilsJni.CreateHybridEcdhCryptoEngine(RAQ, hoN(), hoO(), paramArrayOfByte);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      Log.i("MicroMsg.EcdhMgr", "summerauths getHybridEcdhCryptoEngine engine[%s] autoauth_key[%s] nid[%s] stack[%s]", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(RAQ), Util.getStack() });
      AppMethodBeat.o(133041);
      return l;
    }
  }
  
  /* Error */
  public static boolean hoM()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_0
    //   4: ldc 2
    //   6: monitorenter
    //   7: ldc 199
    //   9: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: ldc 63
    //   14: ldc 201
    //   16: iconst_3
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: getstatic 81	com/tencent/mm/protocal/f:RAV	J
    //   25: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: getstatic 29	com/tencent/mm/protocal/f:RAP	Z
    //   34: invokestatic 71	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   37: aastore
    //   38: dup
    //   39: iconst_2
    //   40: invokestatic 106	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   43: aastore
    //   44: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: invokestatic 207	android/os/SystemClock:elapsedRealtime	()J
    //   50: lstore_2
    //   51: ldc2_w 208
    //   54: lload_2
    //   55: getstatic 81	com/tencent/mm/protocal/f:RAV	J
    //   58: lsub
    //   59: lcmp
    //   60: iflt +43 -> 103
    //   63: getstatic 81	com/tencent/mm/protocal/f:RAV	J
    //   66: lconst_0
    //   67: lcmp
    //   68: ifle +35 -> 103
    //   71: ldc 63
    //   73: ldc 211
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: lload_2
    //   82: getstatic 81	com/tencent/mm/protocal/f:RAV	J
    //   85: lsub
    //   86: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: aastore
    //   90: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: ldc 199
    //   95: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: ldc 2
    //   100: monitorexit
    //   101: iload_0
    //   102: ireturn
    //   103: invokestatic 207	android/os/SystemClock:elapsedRealtime	()J
    //   106: putstatic 81	com/tencent/mm/protocal/f:RAV	J
    //   109: iload_1
    //   110: istore_0
    //   111: getstatic 29	com/tencent/mm/protocal/f:RAP	Z
    //   114: ifne +5 -> 119
    //   117: iconst_1
    //   118: istore_0
    //   119: iload_0
    //   120: putstatic 29	com/tencent/mm/protocal/f:RAP	Z
    //   123: invokestatic 37	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   126: ldc 39
    //   128: invokestatic 45	com/tencent/mm/compatible/util/g:avK	()I
    //   131: invokevirtual 51	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   134: astore 4
    //   136: aload 4
    //   138: invokeinterface 132 1 0
    //   143: ldc 61
    //   145: getstatic 29	com/tencent/mm/protocal/f:RAP	Z
    //   148: invokeinterface 215 3 0
    //   153: invokeinterface 144 1 0
    //   158: istore_0
    //   159: aload 4
    //   161: ldc 61
    //   163: iconst_0
    //   164: invokeinterface 59 3 0
    //   169: pop
    //   170: ldc 63
    //   172: ldc 217
    //   174: iconst_2
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: getstatic 29	com/tencent/mm/protocal/f:RAP	Z
    //   183: invokestatic 71	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: iload_0
    //   190: invokestatic 71	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   193: aastore
    //   194: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: invokestatic 79	com/tencent/mm/protocal/f:hoQ	()V
    //   200: ldc 199
    //   202: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: goto -107 -> 98
    //   208: astore 4
    //   210: ldc 2
    //   212: monitorexit
    //   213: aload 4
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	187	0	bool1	boolean
    //   1	109	1	bool2	boolean
    //   50	32	2	l	long
    //   134	26	4	localSharedPreferences	SharedPreferences
    //   208	6	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	98	208	finally
    //   103	109	208	finally
    //   111	117	208	finally
    //   119	205	208	finally
  }
  
  public static byte[] hoN()
  {
    AppMethodBeat.i(194342);
    int i = RAU;
    try
    {
      int j = h.aHF().kcd.lCD.getMMtlsRegion();
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        Log.e("MicroMsg.EcdhMgr", localException.getLocalizedMessage());
      }
    }
    catch (AssertionError localAssertionError)
    {
      break label85;
    }
    Log.i("MicroMsg.EcdhMgr", "getEcdhKey cert region " + i + " current: " + RAU);
    if (i != RAU)
    {
      RAU = i;
      arh(i);
    }
    arrayOfByte = RAR;
    AppMethodBeat.o(194342);
    return arrayOfByte;
  }
  
  private static byte[] hoO()
  {
    AppMethodBeat.i(194345);
    int i = RAU;
    try
    {
      int j = h.aHF().kcd.lCD.getMMtlsRegion();
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        Log.e("MicroMsg.EcdhMgr", localException.getLocalizedMessage());
      }
    }
    catch (AssertionError localAssertionError)
    {
      break label100;
    }
    Log.i("MicroMsg.EcdhMgr", "getEcdsaKey cert region " + i + " current: " + RAU + " " + RAT);
    if (i != RAU)
    {
      RAU = i;
      arh(i);
    }
    arrayOfByte = RAS;
    AppMethodBeat.o(194345);
    return arrayOfByte;
  }
  
  public static int hoP()
  {
    int i = 1;
    AppMethodBeat.i(194349);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.avK());
    int j = localSharedPreferences.getInt("auth_info_prefs_test_ecdh_version", 0);
    if (j == 1) {
      Log.d("MicroMsg.EcdhMgr", "clear test ecdh version ".concat(String.valueOf(localSharedPreferences.edit().remove("auth_info_prefs_test_ecdh_version").commit())));
    }
    if (j == 1) {}
    while (i != 0)
    {
      Log.d("MicroMsg.EcdhMgr", "return test version 10010");
      AppMethodBeat.o(194349);
      return 10010;
      i = 0;
    }
    i = RAT;
    AppMethodBeat.o(194349);
    return i;
  }
  
  private static void hoQ()
  {
    AppMethodBeat.i(194352);
    if (RAP)
    {
      RAT = 10001;
      RAQ = 415;
      RAR = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
      RAS = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
      AppMethodBeat.o(194352);
      return;
    }
    RAT = 10002;
    RAQ = 415;
    RAR = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
    RAS = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
    AppMethodBeat.o(194352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.f
 * JD-Core Version:    0.7.0.1
 */