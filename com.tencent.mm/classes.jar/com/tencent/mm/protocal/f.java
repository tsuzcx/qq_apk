package com.tencent.mm.protocal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  public static boolean Yxs;
  public static boolean Yxt;
  private static int Yxu;
  private static byte[] Yxv;
  private static byte[] Yxw;
  private static int Yxx;
  public static int Yxy;
  private static long Yxz;
  
  static
  {
    AppMethodBeat.i(133044);
    Yxs = false;
    Yxt = false;
    Yxy = 1;
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.aQe());
    Yxs = localSharedPreferences.getBoolean("auth_info_prefs_use_new_ecdh", true);
    Yxt = localSharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
    Log.i("MicroMsg.EcdhMgr", "summerauths USE_ECDH[%s] USE_ML[%s]", new Object[] { Boolean.valueOf(Yxs), Boolean.valueOf(Yxt) });
    iPM();
    Yxz = 0L;
    AppMethodBeat.o(133044);
  }
  
  private static void axp(int paramInt)
  {
    AppMethodBeat.i(257311);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(257311);
      return;
      iPM();
      AppMethodBeat.o(257311);
      return;
      Yxx = 10007;
      Yxu = 415;
      Yxv = Base64.decode("BOplP5sD+V3TlZJ3I9Kq19fvdwLRfsj/35JH45uCHI2LT1/Z52MOK5D1T3DH2HX6359Rj2yaKBj57FV106blwJQ=", 0);
      Yxw = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFZVlGbzdHZUxLUkZWYVBDVS82ZTZSanVQbWpSWgpaSFI1SmtIOHlCK3hzQVZzSHF3NFUzc2tHdUh6SUU2bW9HN2NlbUgxQVhjN0tVOW5VZWxnTytCaDdnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
    }
  }
  
  public static void axq(int paramInt)
  {
    AppMethodBeat.i(257313);
    Yxx = paramInt;
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.aQe());
    boolean bool = localSharedPreferences.edit().putInt("auth_info_prefs_test_ecdh_version", 1).commit();
    paramInt = localSharedPreferences.getInt("auth_info_prefs_test_ecdh_version", 0);
    Log.d("MicroMsg.EcdhMgr", "set test ecdh version " + bool + " get version " + paramInt);
    AppMethodBeat.o(257313);
  }
  
  public static long cZ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133041);
    long l = UtilsJni.CreateHybridEcdhCryptoEngine(Yxu, iPJ(), iPK(), paramArrayOfByte);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      Log.i("MicroMsg.EcdhMgr", "summerauths getHybridEcdhCryptoEngine engine[%s] autoauth_key[%s] nid[%s] stack[%s]", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(Yxu), Util.getStack() });
      AppMethodBeat.o(133041);
      return l;
    }
  }
  
  /* Error */
  public static boolean iPI()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_0
    //   4: ldc 2
    //   6: monitorenter
    //   7: ldc 191
    //   9: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: ldc 63
    //   14: ldc 193
    //   16: iconst_3
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: getstatic 81	com/tencent/mm/protocal/f:Yxz	J
    //   25: invokestatic 178	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: getstatic 29	com/tencent/mm/protocal/f:Yxt	Z
    //   34: invokestatic 71	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   37: aastore
    //   38: dup
    //   39: iconst_2
    //   40: invokestatic 189	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   43: aastore
    //   44: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: invokestatic 199	android/os/SystemClock:elapsedRealtime	()J
    //   50: lstore_2
    //   51: ldc2_w 200
    //   54: lload_2
    //   55: getstatic 81	com/tencent/mm/protocal/f:Yxz	J
    //   58: lsub
    //   59: lcmp
    //   60: iflt +43 -> 103
    //   63: getstatic 81	com/tencent/mm/protocal/f:Yxz	J
    //   66: lconst_0
    //   67: lcmp
    //   68: ifle +35 -> 103
    //   71: ldc 63
    //   73: ldc 203
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: lload_2
    //   82: getstatic 81	com/tencent/mm/protocal/f:Yxz	J
    //   85: lsub
    //   86: invokestatic 178	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: aastore
    //   90: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: ldc 191
    //   95: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: ldc 2
    //   100: monitorexit
    //   101: iload_0
    //   102: ireturn
    //   103: invokestatic 199	android/os/SystemClock:elapsedRealtime	()J
    //   106: putstatic 81	com/tencent/mm/protocal/f:Yxz	J
    //   109: iload_1
    //   110: istore_0
    //   111: getstatic 29	com/tencent/mm/protocal/f:Yxt	Z
    //   114: ifne +5 -> 119
    //   117: iconst_1
    //   118: istore_0
    //   119: iload_0
    //   120: putstatic 29	com/tencent/mm/protocal/f:Yxt	Z
    //   123: invokestatic 37	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   126: ldc 39
    //   128: invokestatic 45	com/tencent/mm/compatible/util/g:aQe	()I
    //   131: invokevirtual 51	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   134: astore 4
    //   136: aload 4
    //   138: invokeinterface 111 1 0
    //   143: ldc 61
    //   145: getstatic 29	com/tencent/mm/protocal/f:Yxt	Z
    //   148: invokeinterface 207 3 0
    //   153: invokeinterface 123 1 0
    //   158: istore_0
    //   159: aload 4
    //   161: ldc 61
    //   163: iconst_0
    //   164: invokeinterface 59 3 0
    //   169: pop
    //   170: ldc 63
    //   172: ldc 209
    //   174: iconst_2
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: getstatic 29	com/tencent/mm/protocal/f:Yxt	Z
    //   183: invokestatic 71	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: iload_0
    //   190: invokestatic 71	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   193: aastore
    //   194: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: invokestatic 79	com/tencent/mm/protocal/f:iPM	()V
    //   200: ldc 191
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
  
  public static byte[] iPJ()
  {
    AppMethodBeat.i(257308);
    int i = Yxy;
    try
    {
      int j = h.baD().mCm.oun.getMMtlsRegion();
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
    Log.i("MicroMsg.EcdhMgr", "getEcdhKey cert region " + i + " current: " + Yxy);
    if (i != Yxy)
    {
      Yxy = i;
      axp(i);
    }
    arrayOfByte = Yxv;
    AppMethodBeat.o(257308);
    return arrayOfByte;
  }
  
  private static byte[] iPK()
  {
    AppMethodBeat.i(257309);
    int i = Yxy;
    try
    {
      int j = h.baD().mCm.oun.getMMtlsRegion();
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
      break label98;
    }
    Log.i("MicroMsg.EcdhMgr", "getEcdsaKey cert region " + i + " current: " + Yxy + " " + Yxx);
    if (i != Yxy)
    {
      Yxy = i;
      axp(i);
    }
    arrayOfByte = Yxw;
    AppMethodBeat.o(257309);
    return arrayOfByte;
  }
  
  public static int iPL()
  {
    int i = 1;
    AppMethodBeat.i(257310);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.aQe());
    int j = localSharedPreferences.getInt("auth_info_prefs_test_ecdh_version", 0);
    if (j == 1) {
      Log.d("MicroMsg.EcdhMgr", "clear test ecdh version ".concat(String.valueOf(localSharedPreferences.edit().remove("auth_info_prefs_test_ecdh_version").commit())));
    }
    if (j == 1) {}
    while (i != 0)
    {
      Log.d("MicroMsg.EcdhMgr", "return test version 10010");
      AppMethodBeat.o(257310);
      return 10010;
      i = 0;
    }
    i = Yxx;
    AppMethodBeat.o(257310);
    return i;
  }
  
  private static void iPM()
  {
    AppMethodBeat.i(257312);
    if (Yxt)
    {
      Yxx = 10001;
      Yxu = 415;
      Yxv = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
      Yxw = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
      AppMethodBeat.o(257312);
      return;
    }
    Yxx = 10009;
    Yxu = 415;
    Yxv = Base64.decode("BI2xbGdfzrMI1qWI8Yatcqv5Z1vFLwtLdm1DkHGEUh6ZzRqDMMVeQ4Xxy+YxgR8D/KPo6hGx5iaDKtdQs5XaeEE=", 0);
    Yxw = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFYmJLaC9KRGJxbnpLNWFPRzQ4cnF0YnlmQ2g5dAorMlNWZ3RsTGpUU2FwemFxUGlpY2RQUkVHSmM4L2xDaHUxU2cxa1hIcTRyNW1ieFpMcUxVVUhTODl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
    AppMethodBeat.o(257312);
  }
  
  public static void yn(long paramLong)
  {
    AppMethodBeat.i(133042);
    UtilsJni.ReleaseHybridEcdhCryptoEngine(paramLong);
    Log.i("MicroMsg.EcdhMgr", "summerauths releaseHybridEcdhCryptoEngine engine[%s] stack[%s]", new Object[] { Long.valueOf(paramLong), Util.getStack() });
    AppMethodBeat.o(133042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.f
 * JD-Core Version:    0.7.0.1
 */