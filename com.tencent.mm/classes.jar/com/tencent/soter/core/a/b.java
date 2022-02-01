package com.tencent.soter.core.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
@SuppressLint({"NewApi"})
final class b
{
  static int checkSelfPermission(Context paramContext, String paramString)
  {
    AppMethodBeat.i(88621);
    if (paramContext == null)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: check self permission: context is null", new Object[0]);
      AppMethodBeat.o(88621);
      return -1;
    }
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: requested permission is null or nil", new Object[0]);
      AppMethodBeat.o(88621);
      return -1;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      d.d("Soter.FingerprintManagerCompatApi23", "soter: below 23. directly return.", new Object[0]);
      AppMethodBeat.o(88621);
      return 0;
    }
    int i = paramContext.checkSelfPermission(paramString);
    AppMethodBeat.o(88621);
    return i;
  }
  
  static FingerprintManager getFingerprintManager(Context paramContext)
  {
    AppMethodBeat.i(88619);
    paramContext = (FingerprintManager)paramContext.getSystemService("fingerprint");
    AppMethodBeat.o(88619);
    return paramContext;
  }
  
  public static boolean hasEnrolledFingerprints(Context paramContext)
  {
    AppMethodBeat.i(88620);
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: hasEnrolledFingerprints", new Object[0]);
      AppMethodBeat.o(88620);
      return false;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null)
      {
        boolean bool = paramContext.hasEnrolledFingerprints();
        AppMethodBeat.o(88620);
        return bool;
      }
      d.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in hasEnrolledFingerprints! Should never happen", new Object[0]);
      AppMethodBeat.o(88620);
      return false;
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in hasEnrolledFingerprints! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(88620);
    }
    return false;
  }
  
  public static boolean isHardwareDetected(Context paramContext)
  {
    AppMethodBeat.i(88622);
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: isHardwareDetected", new Object[0]);
      AppMethodBeat.o(88622);
      return false;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null)
      {
        boolean bool = paramContext.isHardwareDetected();
        AppMethodBeat.o(88622);
        return bool;
      }
      d.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
      AppMethodBeat.o(88622);
      return false;
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(88622);
    }
    return false;
  }
  
  public static abstract class a
  {
    public void a(b.b paramb) {}
    
    public void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationFailed() {}
    
    public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {}
  }
  
  public static final class b
  {
    b.c Iup;
    
    public b(b.c paramc)
    {
      this.Iup = paramc;
    }
  }
  
  public static final class c
  {
    final Cipher mCipher;
    final Mac mMac;
    final Signature mSignature;
    
    public c(Signature paramSignature)
    {
      this.mSignature = paramSignature;
      this.mCipher = null;
      this.mMac = null;
    }
    
    public c(Cipher paramCipher)
    {
      this.mCipher = paramCipher;
      this.mSignature = null;
      this.mMac = null;
    }
    
    public c(Mac paramMac)
    {
      this.mMac = paramMac;
      this.mCipher = null;
      this.mSignature = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.a.b
 * JD-Core Version:    0.7.0.1
 */