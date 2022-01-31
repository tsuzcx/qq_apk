package com.tencent.soter.core.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;

@SuppressLint({"NewApi"})
final class FingerprintManagerProxy
{
  public static final String FINGERPRINT_SERVICE = "fingerprint";
  private static final String TAG = "Soter.FingerprintManagerProxy";
  
  public static void authenticate(Context paramContext, FingerprintManagerProxy.CryptoObject paramCryptoObject, int paramInt, Object paramObject, FingerprintManagerProxy.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    AppMethodBeat.i(72956);
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: permission check failed: authenticate", new Object[0]);
      AppMethodBeat.o(72956);
      return;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null)
      {
        paramContext.authenticate(wrapCryptoObject(paramCryptoObject), (CancellationSignal)paramObject, paramInt, wrapCallback(paramAuthenticationCallback), paramHandler);
        AppMethodBeat.o(72956);
        return;
      }
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(72956);
      return;
    }
    d.e("Soter.FingerprintManagerProxy", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
    AppMethodBeat.o(72956);
  }
  
  private static int checkSelfPermission(Context paramContext, String paramString)
  {
    AppMethodBeat.i(72954);
    if (paramContext == null)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: check self permission: context is null", new Object[0]);
      AppMethodBeat.o(72954);
      return -1;
    }
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.FingerprintManagerProxy", "soter: requested permission is null or nil", new Object[0]);
      AppMethodBeat.o(72954);
      return -1;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      d.d("Soter.FingerprintManagerProxy", "soter: below 23. directly return.", new Object[0]);
      AppMethodBeat.o(72954);
      return 0;
    }
    int i = paramContext.checkSelfPermission(paramString);
    AppMethodBeat.o(72954);
    return i;
  }
  
  private static FingerprintManager getFingerprintManager(Context paramContext)
  {
    AppMethodBeat.i(72952);
    paramContext = (FingerprintManager)paramContext.getSystemService("fingerprint");
    AppMethodBeat.o(72952);
    return paramContext;
  }
  
  public static boolean hasEnrolledFingerprints(Context paramContext)
  {
    AppMethodBeat.i(72953);
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: permission check failed: hasEnrolledBiometric", new Object[0]);
      AppMethodBeat.o(72953);
      return false;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null)
      {
        boolean bool = paramContext.hasEnrolledFingerprints();
        AppMethodBeat.o(72953);
        return bool;
      }
      d.e("Soter.FingerprintManagerProxy", "soter: fingerprint manager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
      AppMethodBeat.o(72953);
      return false;
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(72953);
    }
    return false;
  }
  
  public static boolean isHardwareDetected(Context paramContext)
  {
    AppMethodBeat.i(72955);
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: permission check failed: isHardwareDetected", new Object[0]);
      AppMethodBeat.o(72955);
      return false;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null)
      {
        boolean bool = paramContext.isHardwareDetected();
        AppMethodBeat.o(72955);
        return bool;
      }
      d.e("Soter.FingerprintManagerProxy", "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
      AppMethodBeat.o(72955);
      return false;
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(72955);
    }
    return false;
  }
  
  private static FingerprintManagerProxy.CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject paramCryptoObject)
  {
    AppMethodBeat.i(72958);
    if (paramCryptoObject == null)
    {
      AppMethodBeat.o(72958);
      return null;
    }
    if (paramCryptoObject.getCipher() != null)
    {
      paramCryptoObject = new FingerprintManagerProxy.CryptoObject(paramCryptoObject.getCipher());
      AppMethodBeat.o(72958);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getSignature() != null)
    {
      paramCryptoObject = new FingerprintManagerProxy.CryptoObject(paramCryptoObject.getSignature());
      AppMethodBeat.o(72958);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getMac() != null)
    {
      paramCryptoObject = new FingerprintManagerProxy.CryptoObject(paramCryptoObject.getMac());
      AppMethodBeat.o(72958);
      return paramCryptoObject;
    }
    AppMethodBeat.o(72958);
    return null;
  }
  
  private static FingerprintManager.AuthenticationCallback wrapCallback(FingerprintManagerProxy.AuthenticationCallback paramAuthenticationCallback)
  {
    AppMethodBeat.i(72959);
    paramAuthenticationCallback = new FingerprintManagerProxy.1(paramAuthenticationCallback);
    AppMethodBeat.o(72959);
    return paramAuthenticationCallback;
  }
  
  private static FingerprintManager.CryptoObject wrapCryptoObject(FingerprintManagerProxy.CryptoObject paramCryptoObject)
  {
    AppMethodBeat.i(72957);
    if (paramCryptoObject == null)
    {
      AppMethodBeat.o(72957);
      return null;
    }
    if (paramCryptoObject.getCipher() != null)
    {
      paramCryptoObject = new FingerprintManager.CryptoObject(paramCryptoObject.getCipher());
      AppMethodBeat.o(72957);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getSignature() != null)
    {
      paramCryptoObject = new FingerprintManager.CryptoObject(paramCryptoObject.getSignature());
      AppMethodBeat.o(72957);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getMac() != null)
    {
      paramCryptoObject = new FingerprintManager.CryptoObject(paramCryptoObject.getMac());
      AppMethodBeat.o(72957);
      return paramCryptoObject;
    }
    AppMethodBeat.o(72957);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.biometric.FingerprintManagerProxy
 * JD-Core Version:    0.7.0.1
 */