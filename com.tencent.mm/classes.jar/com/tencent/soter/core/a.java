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
import com.tencent.soter.core.d.e;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;

public final class a
  implements com.tencent.soter.core.c.b
{
  private static boolean BlO;
  private static com.tencent.soter.core.d.b BlP;
  
  static
  {
    boolean bool = true;
    AppMethodBeat.i(72894);
    BlO = false;
    com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore is call static block to init SoterCore IMPL", new Object[0]);
    BlP = dUZ();
    if (BlP == null) {}
    for (;;)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore is call static block to init SoterCore IMPL, IMPL is null[%b]", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(72894);
      return;
      bool = false;
    }
  }
  
  public static void a(e parame)
  {
    AppMethodBeat.i(156549);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: setTrebleServiceListener IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(156549);
      return;
    }
    BlP.a(parame);
    AppMethodBeat.o(156549);
  }
  
  public static boolean aF(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(72892);
    if ((!BiometricManagerCompat.from(paramContext, Integer.valueOf(paramInt)).isCurrentFailTimeAvailable()) && (!BiometricManagerCompat.from(paramContext, Integer.valueOf(paramInt)).isCurrentTweenTimeAvailable(paramContext)))
    {
      AppMethodBeat.o(72892);
      return true;
    }
    AppMethodBeat.o(72892);
    return false;
  }
  
  public static f awJ(String paramString)
  {
    AppMethodBeat.i(72878);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: generateAuthKey IMPL is null, not support soter", new Object[0]);
      paramString = new f(2);
      AppMethodBeat.o(72878);
      return paramString;
    }
    paramString = BlP.awJ(paramString);
    AppMethodBeat.o(72878);
    return paramString;
  }
  
  public static boolean awK(String paramString)
  {
    AppMethodBeat.i(72880);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: hasAuthKey IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(72880);
      return false;
    }
    boolean bool = BlP.awK(paramString);
    AppMethodBeat.o(72880);
    return bool;
  }
  
  public static boolean awL(String paramString)
  {
    AppMethodBeat.i(72881);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isAuthKeyValid IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(72881);
      return false;
    }
    boolean bool = BlP.awL(paramString);
    AppMethodBeat.o(72881);
    return bool;
  }
  
  public static i awM(String paramString)
  {
    AppMethodBeat.i(72882);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: getAuthKeyModel IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(72882);
      return null;
    }
    paramString = BlP.awM(paramString);
    AppMethodBeat.o(72882);
    return paramString;
  }
  
  public static Signature awN(String paramString)
  {
    AppMethodBeat.i(72883);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: getAuthInitAndSign IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(72883);
      return null;
    }
    paramString = BlP.awN(paramString);
    AppMethodBeat.o(72883);
    return paramString;
  }
  
  public static void bNv()
  {
    AppMethodBeat.i(72867);
    com.tencent.soter.core.d.c.bNv();
    AppMethodBeat.o(72867);
  }
  
  public static j cr(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(72886);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "origin is null or nil. abort", new Object[0]);
      AppMethodBeat.o(72886);
      return null;
    }
    if (paramArrayOfByte.length < 4)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: length not correct 1", new Object[0]);
      AppMethodBeat.o(72886);
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
      AppMethodBeat.o(72886);
      return null;
    }
    localObject = new byte[i];
    if (paramArrayOfByte.length <= i + 4)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: length not correct 2", new Object[0]);
      AppMethodBeat.o(72886);
      return null;
    }
    System.arraycopy(paramArrayOfByte, 4, localObject, 0, i);
    localObject = j.awO(new String((byte[])localObject));
    j = paramArrayOfByte.length - (i + 4);
    com.tencent.soter.core.c.d.d("Soter.SoterCore", "soter: signature length: ".concat(String.valueOf(j)), new Object[0]);
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, i + 4, arrayOfByte, 0, j);
    if (localObject != null) {
      ((j)localObject).signature = Base64.encodeToString(arrayOfByte, 2);
    }
    AppMethodBeat.o(72886);
    return localObject;
  }
  
  public static f cu(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(72879);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: removeAuthKey IMPL is null, not support soter", new Object[0]);
      paramString = new f(2);
      AppMethodBeat.o(72879);
      return paramString;
    }
    paramString = BlP.cu(paramString, paramBoolean);
    AppMethodBeat.o(72879);
    return paramString;
  }
  
  public static void dUX()
  {
    boolean bool = true;
    AppMethodBeat.i(72869);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore IMPL is null then call getProviderSoterCore to init", new Object[0]);
      BlP = dUZ();
      if (BlP != null) {
        break label60;
      }
    }
    for (;;)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore IMPL is null[%b], after call getProviderSoterCore to init", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(72869);
      return;
      label60:
      bool = false;
    }
  }
  
  public static int dUY()
  {
    AppMethodBeat.i(72870);
    if (BlP == null)
    {
      AppMethodBeat.o(72870);
      return 0;
    }
    if ((BlP instanceof com.tencent.soter.core.d.d))
    {
      com.tencent.soter.core.c.d.d("Soter.SoterCore", "getSoterCoreType is TREBLE", new Object[0]);
      AppMethodBeat.o(72870);
      return 1;
    }
    com.tencent.soter.core.c.d.d("Soter.SoterCore", "getSoterCoreType is not TREBLE", new Object[0]);
    AppMethodBeat.o(72870);
    return 0;
  }
  
  private static com.tencent.soter.core.d.b dUZ()
  {
    AppMethodBeat.i(72871);
    com.tencent.soter.core.d.c.bNv();
    if (h.dVn())
    {
      AppMethodBeat.o(72871);
      return null;
    }
    Object localObject = Security.getProviders();
    if (localObject == null)
    {
      AppMethodBeat.o(72871);
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
          AppMethodBeat.o(72871);
          return localObject;
        }
        localObject = new com.tencent.soter.core.d.c(str);
        AppMethodBeat.o(72871);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(72871);
    return null;
  }
  
  public static boolean dVa()
  {
    AppMethodBeat.i(156547);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isTrebleServiceConnected IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(156547);
      return false;
    }
    boolean bool = BlP.dVa();
    AppMethodBeat.o(156547);
    return bool;
  }
  
  public static void dVb()
  {
    AppMethodBeat.i(156548);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: triggerConnecting IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(156548);
      return;
    }
    BlP.dVb();
    AppMethodBeat.o(156548);
  }
  
  public static boolean dVc()
  {
    AppMethodBeat.i(72872);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isNativeSupportSoter IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(72872);
      return false;
    }
    boolean bool = BlP.dVc();
    com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isNativeSupportSoter return[" + bool + "]", new Object[0]);
    AppMethodBeat.o(72872);
    return bool;
  }
  
  public static f dVd()
  {
    AppMethodBeat.i(72873);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: generateAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
      localf = new f(2);
      AppMethodBeat.o(72873);
      return localf;
    }
    f localf = BlP.dVd();
    AppMethodBeat.o(72873);
    return localf;
  }
  
  public static f dVe()
  {
    AppMethodBeat.i(72874);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: removeAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
      localf = new f(2);
      AppMethodBeat.o(72874);
      return localf;
    }
    f localf = BlP.dVe();
    AppMethodBeat.o(72874);
    return localf;
  }
  
  public static boolean dVf()
  {
    AppMethodBeat.i(72875);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: hasAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(72875);
      return false;
    }
    boolean bool = BlP.dVf();
    AppMethodBeat.o(72875);
    return bool;
  }
  
  public static boolean dVg()
  {
    AppMethodBeat.i(72876);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isAppGlobalSecureKeyValid IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(72876);
      return false;
    }
    boolean bool = BlP.dVg();
    AppMethodBeat.o(72876);
    return bool;
  }
  
  public static i dVh()
  {
    AppMethodBeat.i(72877);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: getAppGlobalSecureKeyModel IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(72877);
      return null;
    }
    i locali = BlP.dVh();
    AppMethodBeat.o(72877);
    return locali;
  }
  
  public static String dVi()
  {
    AppMethodBeat.i(72893);
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
    AppMethodBeat.o(72893);
    return localObject;
  }
  
  public static SoterSessionResult iS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72884);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: initSigh IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(72884);
      return null;
    }
    paramString1 = BlP.iS(paramString1, paramString2);
    AppMethodBeat.o(72884);
    return paramString1;
  }
  
  public static void jf(Context paramContext)
  {
    AppMethodBeat.i(72868);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore IMPL is null then call tryToInitSoterTreble to init", new Object[0]);
      com.tencent.soter.core.d.d locald = new com.tencent.soter.core.d.d();
      BlP = locald;
      if (!locald.jm(paramContext))
      {
        BlP = null;
        com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore IMPL is null after call tryToInitSoterTreble to init", new Object[0]);
      }
    }
    AppMethodBeat.o(72868);
  }
  
  @Deprecated
  public static boolean jg(Context paramContext)
  {
    AppMethodBeat.i(72887);
    boolean bool = com.tencent.soter.core.a.a.jl(paramContext).isHardwareDetected();
    com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isSupportFingerprint return[" + bool + "]", new Object[0]);
    AppMethodBeat.o(72887);
    return bool;
  }
  
  public static boolean jh(Context paramContext)
  {
    AppMethodBeat.i(72888);
    boolean bool = BiometricManagerCompat.from(paramContext, Integer.valueOf(2)).isHardwareDetected();
    com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isSupportBiometric type[2] return[" + bool + "]", new Object[0]);
    AppMethodBeat.o(72888);
    return bool;
  }
  
  @Deprecated
  public static boolean ji(Context paramContext)
  {
    AppMethodBeat.i(72889);
    boolean bool = com.tencent.soter.core.a.a.jl(paramContext).hasEnrolledFingerprints();
    AppMethodBeat.o(72889);
    return bool;
  }
  
  public static boolean jj(Context paramContext)
  {
    AppMethodBeat.i(72890);
    boolean bool = BiometricManagerCompat.from(paramContext, Integer.valueOf(2)).hasEnrolledBiometric();
    AppMethodBeat.o(72890);
    return bool;
  }
  
  @Deprecated
  public static boolean jk(Context paramContext)
  {
    AppMethodBeat.i(72891);
    if ((!com.tencent.soter.core.a.c.isCurrentFailTimeAvailable(paramContext)) && (!com.tencent.soter.core.a.c.isCurrentTweenTimeAvailable(paramContext)))
    {
      AppMethodBeat.o(72891);
      return true;
    }
    AppMethodBeat.o(72891);
    return false;
  }
  
  public static byte[] oY(long paramLong)
  {
    AppMethodBeat.i(72885);
    if (BlP == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: finishSign IMPL is null, not support soter", new Object[0]);
      AppMethodBeat.o(72885);
      return new byte[0];
    }
    byte[] arrayOfByte = BlP.oY(paramLong);
    AppMethodBeat.o(72885);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.a
 * JD-Core Version:    0.7.0.1
 */