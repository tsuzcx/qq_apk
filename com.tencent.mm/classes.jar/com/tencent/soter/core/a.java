package com.tencent.soter.core;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.biometric.BiometricManagerCompat;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.i;
import com.tencent.soter.core.c.j;
import com.tencent.soter.core.d.c;
import com.tencent.soter.core.d.e;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;

public final class a
  implements com.tencent.soter.core.c.b
{
  private static e RPi;
  private static com.tencent.soter.core.d.b RPj;
  
  static
  {
    boolean bool = true;
    AppMethodBeat.i(88522);
    com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore is call static block to init SoterCore IMPL", new Object[0]);
    RPj = hlg();
    if (RPj == null) {}
    for (;;)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore is call static block to init SoterCore IMPL, IMPL is null[%b]", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(88522);
      return;
      bool = false;
    }
  }
  
  public static byte[] Oz(long paramLong)
  {
    AppMethodBeat.i(88513);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: finishSign IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(88513);
      return new byte[0];
    }
    byte[] arrayOfByte = RPj.Oz(paramLong);
    AppMethodBeat.o(88513);
    return arrayOfByte;
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(88499);
    RPi = parame;
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: setTrebleServiceListener IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(88499);
      return;
    }
    RPj.a(parame);
    AppMethodBeat.o(88499);
  }
  
  public static boolean aU(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(88516);
    boolean bool = BiometricManagerCompat.from(paramContext, Integer.valueOf(paramInt)).isHardwareDetected();
    com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isSupportBiometric type[" + paramInt + "] return[" + bool + "]", new Object[0]);
    AppMethodBeat.o(88516);
    return bool;
  }
  
  public static boolean aV(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(88518);
    boolean bool = BiometricManagerCompat.from(paramContext, Integer.valueOf(paramInt)).hasEnrolledBiometric();
    AppMethodBeat.o(88518);
    return bool;
  }
  
  public static boolean aW(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(88520);
    if ((!BiometricManagerCompat.from(paramContext, Integer.valueOf(paramInt)).isCurrentFailTimeAvailable()) && (!BiometricManagerCompat.from(paramContext, Integer.valueOf(paramInt)).isCurrentTweenTimeAvailable(paramContext)))
    {
      AppMethodBeat.o(88520);
      return true;
    }
    AppMethodBeat.o(88520);
    return false;
  }
  
  public static f bqg(String paramString)
  {
    AppMethodBeat.i(88506);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: generateAuthKey IMPL is null, not support soter", new Object[0]);
      paramString = new f(2);
      AppMethodBeat.o(88506);
      return paramString;
    }
    paramString = RPj.bqg(paramString);
    AppMethodBeat.o(88506);
    return paramString;
  }
  
  public static boolean bqh(String paramString)
  {
    AppMethodBeat.i(88508);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: hasAuthKey IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(88508);
      return false;
    }
    boolean bool = RPj.bqh(paramString);
    AppMethodBeat.o(88508);
    return bool;
  }
  
  public static boolean bqi(String paramString)
  {
    AppMethodBeat.i(88509);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isAuthKeyValid IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(88509);
      return false;
    }
    boolean bool = RPj.bqi(paramString);
    AppMethodBeat.o(88509);
    return bool;
  }
  
  public static i bqj(String paramString)
  {
    AppMethodBeat.i(88510);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: getAuthKeyModel IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(88510);
      return null;
    }
    paramString = RPj.bqj(paramString);
    AppMethodBeat.o(88510);
    return paramString;
  }
  
  public static Signature bqk(String paramString)
  {
    AppMethodBeat.i(88511);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: getAuthInitAndSign IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(88511);
      return null;
    }
    paramString = RPj.bqk(paramString);
    AppMethodBeat.o(88511);
    return paramString;
  }
  
  public static j cY(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88514);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "origin is null or nil. abort", new Object[0]);
      AppMethodBeat.o(88514);
      return null;
    }
    if (paramArrayOfByte.length < 4)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: length not correct 1", new Object[0]);
      AppMethodBeat.o(88514);
      return null;
    }
    Object localObject = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, 4);
    int j = 0;
    i = 0;
    while (j < 4)
    {
      i += ((localObject[j] & 0xFF) << j * 8);
      j += 1;
    }
    com.tencent.soter.core.c.d.d("Soter", "parsed raw length: ".concat(String.valueOf(i)), new Object[0]);
    if (i > 1048576)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: too large signature result!", new Object[0]);
      AppMethodBeat.o(88514);
      return null;
    }
    localObject = new byte[i];
    if (paramArrayOfByte.length <= i + 4)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: length not correct 2", new Object[0]);
      AppMethodBeat.o(88514);
      return null;
    }
    System.arraycopy(paramArrayOfByte, 4, localObject, 0, i);
    localObject = j.bql(new String((byte[])localObject));
    j = paramArrayOfByte.length - (i + 4);
    com.tencent.soter.core.c.d.d("Soter.SoterCore", "soter: signature length: ".concat(String.valueOf(j)), new Object[0]);
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, i + 4, arrayOfByte, 0, j);
    if (localObject != null) {
      ((j)localObject).signature = Base64.encodeToString(arrayOfByte, 2);
    }
    AppMethodBeat.o(88514);
    return localObject;
  }
  
  public static f dE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(88507);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: removeAuthKey IMPL is null, not support soter", new Object[0]);
      paramString = new f(2);
      AppMethodBeat.o(88507);
      return paramString;
    }
    paramString = RPj.dE(paramString, paramBoolean);
    AppMethodBeat.o(88507);
    return paramString;
  }
  
  public static void efp()
  {
    AppMethodBeat.i(88492);
    c.efp();
    AppMethodBeat.o(88492);
  }
  
  @Deprecated
  public static boolean fN(Context paramContext)
  {
    AppMethodBeat.i(88515);
    boolean bool = BiometricManagerCompat.from(paramContext, Integer.valueOf(1)).isHardwareDetected();
    com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isSupportFingerprint return[" + bool + "]", new Object[0]);
    AppMethodBeat.o(88515);
    return bool;
  }
  
  public static void hle()
  {
    boolean bool = true;
    AppMethodBeat.i(88494);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore IMPL is null then call getProviderSoterCore to init", new Object[0]);
      RPj = hlg();
      if (RPj != null) {
        break label60;
      }
    }
    for (;;)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore IMPL is null[%b], after call getProviderSoterCore to init", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(88494);
      return;
      label60:
      bool = false;
    }
  }
  
  public static int hlf()
  {
    AppMethodBeat.i(88495);
    if (RPj == null)
    {
      AppMethodBeat.o(88495);
      return 0;
    }
    if ((RPj instanceof com.tencent.soter.core.d.d))
    {
      com.tencent.soter.core.c.d.d("Soter.SoterCore", "getSoterCoreType is TREBLE", new Object[0]);
      AppMethodBeat.o(88495);
      return 1;
    }
    com.tencent.soter.core.c.d.d("Soter.SoterCore", "getSoterCoreType is not TREBLE", new Object[0]);
    AppMethodBeat.o(88495);
    return 0;
  }
  
  private static com.tencent.soter.core.d.b hlg()
  {
    AppMethodBeat.i(88496);
    c.efp();
    if (h.hlu())
    {
      AppMethodBeat.o(88496);
      return null;
    }
    Object localObject = Security.getProviders();
    if (localObject == null)
    {
      AppMethodBeat.o(88496);
      return null;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String str = localObject[i].getName();
      if ((str != null) && (str.startsWith("SoterKeyStore")))
      {
        if (str.split("\\.").length > 1)
        {
          localObject = new com.tencent.soter.core.d.a(str);
          AppMethodBeat.o(88496);
          return localObject;
        }
        localObject = new c(str);
        AppMethodBeat.o(88496);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(88496);
    return null;
  }
  
  public static boolean hlh()
  {
    AppMethodBeat.i(88497);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isTrebleServiceConnected IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(88497);
      return false;
    }
    boolean bool = RPj.hlh();
    AppMethodBeat.o(88497);
    return bool;
  }
  
  public static void hli()
  {
    AppMethodBeat.i(88498);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: triggerConnecting IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(88498);
      return;
    }
    RPj.hli();
    AppMethodBeat.o(88498);
  }
  
  public static boolean hlj()
  {
    AppMethodBeat.i(88500);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isNativeSupportSoter IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(88500);
      return false;
    }
    boolean bool = RPj.hlj();
    com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isNativeSupportSoter return[" + bool + "]", new Object[0]);
    AppMethodBeat.o(88500);
    return bool;
  }
  
  public static f hlk()
  {
    AppMethodBeat.i(88501);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: generateAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
      localf = new f(2);
      AppMethodBeat.o(88501);
      return localf;
    }
    f localf = RPj.hlk();
    AppMethodBeat.o(88501);
    return localf;
  }
  
  public static f hll()
  {
    AppMethodBeat.i(88502);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: removeAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
      localf = new f(2);
      AppMethodBeat.o(88502);
      return localf;
    }
    f localf = RPj.hll();
    AppMethodBeat.o(88502);
    return localf;
  }
  
  public static boolean hlm()
  {
    AppMethodBeat.i(88503);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: hasAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(88503);
      return false;
    }
    boolean bool = RPj.hlm();
    AppMethodBeat.o(88503);
    return bool;
  }
  
  public static boolean hln()
  {
    AppMethodBeat.i(88504);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isAppGlobalSecureKeyValid IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(88504);
      return false;
    }
    boolean bool = RPj.hln();
    AppMethodBeat.o(88504);
    return bool;
  }
  
  public static i hlo()
  {
    AppMethodBeat.i(88505);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: getAppGlobalSecureKeyModel IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(88505);
      return null;
    }
    i locali = RPj.hlo();
    AppMethodBeat.o(88505);
    return locali;
  }
  
  public static String hlp()
  {
    AppMethodBeat.i(88521);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<deviceinfo>");
    ((StringBuilder)localObject).append("<MANUFACTURER name=\"");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("\">");
    ((StringBuilder)localObject).append("<MODEL name=\"");
    ((StringBuilder)localObject).append(Build.MODEL);
    ((StringBuilder)localObject).append("\">");
    ((StringBuilder)localObject).append("<VERSION_RELEASE name=\"");
    ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append("\">");
    ((StringBuilder)localObject).append("<VERSION_INCREMENTAL name=\"");
    ((StringBuilder)localObject).append(Build.VERSION.INCREMENTAL);
    ((StringBuilder)localObject).append("\">");
    ((StringBuilder)localObject).append("<DISPLAY name=\"");
    ((StringBuilder)localObject).append(Build.DISPLAY);
    ((StringBuilder)localObject).append("\">");
    ((StringBuilder)localObject).append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
    com.tencent.soter.core.c.d.d("Soter.SoterCore", "soter: getFingerprint  " + ((StringBuilder)localObject).toString(), new Object[0]);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(88521);
    return localObject;
  }
  
  /* Error */
  public static void lc(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 380
    //   6: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 34	com/tencent/soter/core/a:RPj	Lcom/tencent/soter/core/d/b;
    //   12: ifnonnull +88 -> 100
    //   15: ldc 21
    //   17: ldc_w 382
    //   20: iconst_0
    //   21: anewarray 4	java/lang/Object
    //   24: invokestatic 28	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: invokestatic 385	com/tencent/soter/core/d/d:isInitializing	()Z
    //   30: ifne +58 -> 88
    //   33: new 248	com/tencent/soter/core/d/d
    //   36: dup
    //   37: invokespecial 386	com/tencent/soter/core/d/d:<init>	()V
    //   40: astore_1
    //   41: aload_1
    //   42: putstatic 34	com/tencent/soter/core/a:RPj	Lcom/tencent/soter/core/d/b;
    //   45: aload_1
    //   46: getstatic 63	com/tencent/soter/core/a:RPi	Lcom/tencent/soter/core/d/e;
    //   49: invokevirtual 67	com/tencent/soter/core/d/b:a	(Lcom/tencent/soter/core/d/e;)V
    //   52: getstatic 34	com/tencent/soter/core/a:RPj	Lcom/tencent/soter/core/d/b;
    //   55: aload_0
    //   56: invokevirtual 389	com/tencent/soter/core/d/b:lg	(Landroid/content/Context;)Z
    //   59: ifne +41 -> 100
    //   62: aconst_null
    //   63: putstatic 34	com/tencent/soter/core/a:RPj	Lcom/tencent/soter/core/d/b;
    //   66: ldc 21
    //   68: ldc_w 391
    //   71: iconst_0
    //   72: anewarray 4	java/lang/Object
    //   75: invokestatic 28	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: ldc_w 380
    //   81: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: ldc 2
    //   86: monitorexit
    //   87: return
    //   88: ldc 21
    //   90: ldc_w 393
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 28	com/tencent/soter/core/c/d:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: ldc_w 380
    //   103: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: goto -22 -> 84
    //   109: astore_0
    //   110: ldc 2
    //   112: monitorexit
    //   113: aload_0
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramContext	Context
    //   40	6	1	locald	com.tencent.soter.core.d.d
    // Exception table:
    //   from	to	target	type
    //   3	84	109	finally
    //   88	100	109	finally
    //   100	106	109	finally
  }
  
  @Deprecated
  public static boolean ld(Context paramContext)
  {
    AppMethodBeat.i(88517);
    boolean bool = BiometricManagerCompat.from(paramContext, Integer.valueOf(1)).hasEnrolledBiometric();
    AppMethodBeat.o(88517);
    return bool;
  }
  
  @Deprecated
  public static boolean le(Context paramContext)
  {
    AppMethodBeat.i(88519);
    if ((!BiometricManagerCompat.from(paramContext, Integer.valueOf(1)).isCurrentFailTimeAvailable()) && (!BiometricManagerCompat.from(paramContext, Integer.valueOf(1)).isCurrentTweenTimeAvailable(paramContext)))
    {
      AppMethodBeat.o(88519);
      return true;
    }
    AppMethodBeat.o(88519);
    return false;
  }
  
  public static SoterSessionResult nI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88512);
    if (RPj == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: initSigh IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(88512);
      return null;
    }
    paramString1 = RPj.nI(paramString1, paramString2);
    AppMethodBeat.o(88512);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.a
 * JD-Core Version:    0.7.0.1
 */