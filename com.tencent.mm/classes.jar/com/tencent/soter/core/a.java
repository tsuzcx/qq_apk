package com.tencent.soter.core;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.soter.core.biometric.BiometricManagerCompat;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.i;
import com.tencent.soter.core.c.j;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;

public final class a
  implements com.tencent.soter.core.c.b
{
  private static boolean wOq;
  private static com.tencent.soter.core.d.b wOr;
  
  static
  {
    boolean bool = true;
    wOq = false;
    com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore is call static block to init SoterCore IMPL", new Object[0]);
    wOr = cPg();
    if (wOr == null) {}
    for (;;)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore is call static block to init SoterCore IMPL, IMPL is null[%b]", new Object[] { Boolean.valueOf(bool) });
      return;
      bool = false;
    }
  }
  
  public static f afO(String paramString)
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: generateAuthKey IMPL is null, not support soter", new Object[0]);
      return new f(2);
    }
    return wOr.afO(paramString);
  }
  
  public static boolean afP(String paramString)
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: hasAuthKey IMPL is null, not support soter", new Object[0]);
      return false;
    }
    return wOr.afP(paramString);
  }
  
  public static boolean afQ(String paramString)
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isAuthKeyValid IMPL is null, not support soter", new Object[0]);
      return false;
    }
    return wOr.afQ(paramString);
  }
  
  public static i afR(String paramString)
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: getAuthKeyModel IMPL is null, not support soter", new Object[0]);
      return null;
    }
    return wOr.afR(paramString);
  }
  
  public static Signature afS(String paramString)
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: getAuthInitAndSign IMPL is null, not support soter", new Object[0]);
      return null;
    }
    return wOr.afS(paramString);
  }
  
  public static boolean ap(Context paramContext, int paramInt)
  {
    return (!BiometricManagerCompat.from(paramContext, Integer.valueOf(paramInt)).isCurrentFailTimeAvailable()) && (!BiometricManagerCompat.from(paramContext, Integer.valueOf(paramInt)).isCurrentTweenTimeAvailable(paramContext));
  }
  
  public static f bR(String paramString, boolean paramBoolean)
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: removeAuthKey IMPL is null, not support soter", new Object[0]);
      return new f(2);
    }
    return wOr.bR(paramString, paramBoolean);
  }
  
  public static j bR(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    int i;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      i = 1;
      if (i == 0) {
        break label37;
      }
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "origin is null or nil. abort", new Object[0]);
      paramArrayOfByte = (byte[])localObject;
    }
    label37:
    byte[] arrayOfByte;
    do
    {
      return paramArrayOfByte;
      i = 0;
      break;
      if (paramArrayOfByte.length < 4)
      {
        com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: length not correct 1", new Object[0]);
        return null;
      }
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, 4);
      int j = 0;
      i = 0;
      while (j < 4)
      {
        i += ((localObject[j] & 0xFF) << j * 8);
        j += 1;
      }
      com.tencent.soter.core.c.d.d("Soter", "parsed raw length: " + i, new Object[0]);
      if (i > 1048576)
      {
        com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: too large signature result!", new Object[0]);
        return null;
      }
      localObject = new byte[i];
      if (paramArrayOfByte.length <= i + 4)
      {
        com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: length not correct 2", new Object[0]);
        return null;
      }
      System.arraycopy(paramArrayOfByte, 4, localObject, 0, i);
      localObject = j.afT(new String((byte[])localObject));
      j = paramArrayOfByte.length - (i + 4);
      com.tencent.soter.core.c.d.d("Soter.SoterCore", "soter: signature length: " + j, new Object[0]);
      arrayOfByte = new byte[j];
      System.arraycopy(paramArrayOfByte, i + 4, arrayOfByte, 0, j);
      paramArrayOfByte = (byte[])localObject;
    } while (localObject == null);
    ((j)localObject).signature = Base64.encodeToString(arrayOfByte, 2);
    return localObject;
  }
  
  public static void cPe()
  {
    boolean bool = true;
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore IMPL is null then call getProviderSoterCore to init", new Object[0]);
      wOr = cPg();
      if (wOr != null) {
        break label50;
      }
    }
    for (;;)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore IMPL is null[%b], after call getProviderSoterCore to init", new Object[] { Boolean.valueOf(bool) });
      return;
      label50:
      bool = false;
    }
  }
  
  public static int cPf()
  {
    if (wOr == null) {
      return 0;
    }
    if ((wOr instanceof com.tencent.soter.core.d.d))
    {
      com.tencent.soter.core.c.d.d("Soter.SoterCore", "getSoterCoreType is TREBLE", new Object[0]);
      return 1;
    }
    com.tencent.soter.core.c.d.d("Soter.SoterCore", "getSoterCoreType is not TREBLE", new Object[0]);
    return 0;
  }
  
  private static com.tencent.soter.core.d.b cPg()
  {
    
    if (h.cPs()) {}
    for (;;)
    {
      return null;
      Provider[] arrayOfProvider = Security.getProviders();
      if (arrayOfProvider != null)
      {
        int j = arrayOfProvider.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfProvider[i].getName();
          if ((str != null) && (str.startsWith("SoterKeyStore")))
          {
            if (str.split("\\.").length > 1) {
              return new com.tencent.soter.core.d.a(str);
            }
            return new com.tencent.soter.core.d.c(str);
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean cPh()
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isNativeSupportSoter IMPL is null, not support soter", new Object[0]);
      return false;
    }
    boolean bool = wOr.cPh();
    com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isNativeSupportSoter return[" + bool + "]", new Object[0]);
    return bool;
  }
  
  public static f cPi()
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: generateAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
      return new f(2);
    }
    return wOr.cPi();
  }
  
  public static f cPj()
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: removeAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
      return new f(2);
    }
    return wOr.cPj();
  }
  
  public static boolean cPk()
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: hasAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
      return false;
    }
    return wOr.cPk();
  }
  
  public static boolean cPl()
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isAppGlobalSecureKeyValid IMPL is null, not support soter", new Object[0]);
      return false;
    }
    return wOr.cPl();
  }
  
  public static i cPm()
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: getAppGlobalSecureKeyModel IMPL is null, not support soter", new Object[0]);
      return null;
    }
    return wOr.cPm();
  }
  
  public static String cPn()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<deviceinfo>");
    localStringBuilder.append("<MANUFACTURER name=\"");
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("\">");
    localStringBuilder.append("<MODEL name=\"");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("\">");
    localStringBuilder.append("<VERSION_RELEASE name=\"");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append("\">");
    localStringBuilder.append("<VERSION_INCREMENTAL name=\"");
    localStringBuilder.append(Build.VERSION.INCREMENTAL);
    localStringBuilder.append("\">");
    localStringBuilder.append("<DISPLAY name=\"");
    localStringBuilder.append(Build.DISPLAY);
    localStringBuilder.append("\">");
    localStringBuilder.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
    com.tencent.soter.core.c.d.d("Soter.SoterCore", "soter: getFingerprint  " + localStringBuilder.toString(), new Object[0]);
    return localStringBuilder.toString();
  }
  
  public static SoterSessionResult gM(String paramString1, String paramString2)
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: initSigh IMPL is null, not support soter", new Object[0]);
      return null;
    }
    return wOr.gM(paramString1, paramString2);
  }
  
  public static void hE(Context paramContext)
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore IMPL is null then call tryToInitSoterTreble to init", new Object[0]);
      com.tencent.soter.core.d.d locald = new com.tencent.soter.core.d.d();
      wOr = locald;
      if (!locald.hL(paramContext))
      {
        wOr = null;
        com.tencent.soter.core.c.d.i("Soter.SoterCore", "soter: SoterCore IMPL is null after call tryToInitSoterTreble to init", new Object[0]);
      }
    }
  }
  
  public static boolean hF(Context paramContext)
  {
    boolean bool = com.tencent.soter.core.a.a.hK(paramContext).isHardwareDetected();
    com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isSupportFingerprint return[" + bool + "]", new Object[0]);
    return bool;
  }
  
  public static boolean hG(Context paramContext)
  {
    boolean bool = BiometricManagerCompat.from(paramContext, Integer.valueOf(2)).isHardwareDetected();
    com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: isSupportBiometric type[2] return[" + bool + "]", new Object[0]);
    return bool;
  }
  
  public static boolean hH(Context paramContext)
  {
    return com.tencent.soter.core.a.a.hK(paramContext).hasEnrolledFingerprints();
  }
  
  public static boolean hI(Context paramContext)
  {
    return BiometricManagerCompat.from(paramContext, Integer.valueOf(2)).hasEnrolledBiometric();
  }
  
  public static boolean hJ(Context paramContext)
  {
    return (!com.tencent.soter.core.a.c.isCurrentFailTimeAvailable(paramContext)) && (!com.tencent.soter.core.a.c.isCurrentTweenTimeAvailable(paramContext));
  }
  
  public static byte[] im(long paramLong)
  {
    if (wOr == null)
    {
      com.tencent.soter.core.c.d.e("Soter.SoterCore", "soter: finishSign IMPL is null, not support soter", new Object[0]);
      return new byte[0];
    }
    return wOr.im(paramLong);
  }
  
  public static void setUp() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.core.a
 * JD-Core Version:    0.7.0.1
 */