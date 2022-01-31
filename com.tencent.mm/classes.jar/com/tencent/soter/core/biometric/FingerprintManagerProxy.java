package com.tencent.soter.core.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;

@SuppressLint({"NewApi"})
final class FingerprintManagerProxy
{
  public static final String FINGERPRINT_SERVICE = "fingerprint";
  private static final String TAG = "Soter.FingerprintManagerProxy";
  
  public static void authenticate(Context paramContext, FingerprintManagerProxy.CryptoObject paramCryptoObject, int paramInt, Object paramObject, FingerprintManagerProxy.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: permission check failed: authenticate", new Object[0]);
      return;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null)
      {
        paramContext.authenticate(wrapCryptoObject(paramCryptoObject), (CancellationSignal)paramObject, paramInt, wrapCallback(paramAuthenticationCallback), paramHandler);
        return;
      }
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
      return;
    }
    d.e("Soter.FingerprintManagerProxy", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
  }
  
  private static int checkSelfPermission(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: check self permission: context is null", new Object[0]);
      return -1;
    }
    if (g.bl(paramString))
    {
      d.e("Soter.FingerprintManagerProxy", "soter: requested permission is null or nil", new Object[0]);
      return -1;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      d.d("Soter.FingerprintManagerProxy", "soter: below 23. directly return.", new Object[0]);
      return 0;
    }
    return paramContext.checkSelfPermission(paramString);
  }
  
  private static FingerprintManager getFingerprintManager(Context paramContext)
  {
    return (FingerprintManager)paramContext.getSystemService("fingerprint");
  }
  
  public static boolean hasEnrolledFingerprints(Context paramContext)
  {
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: permission check failed: hasEnrolledBiometric", new Object[0]);
      return false;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null) {
        return paramContext.hasEnrolledFingerprints();
      }
      d.e("Soter.FingerprintManagerProxy", "soter: fingerprint manager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
      return false;
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
    }
    return false;
  }
  
  public static boolean isHardwareDetected(Context paramContext)
  {
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: permission check failed: isHardwareDetected", new Object[0]);
      return false;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null) {
        return paramContext.isHardwareDetected();
      }
      d.e("Soter.FingerprintManagerProxy", "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
      return false;
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
    }
    return false;
  }
  
  private static FingerprintManagerProxy.CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null) {}
    do
    {
      return null;
      if (paramCryptoObject.getCipher() != null) {
        return new FingerprintManagerProxy.CryptoObject(paramCryptoObject.getCipher());
      }
      if (paramCryptoObject.getSignature() != null) {
        return new FingerprintManagerProxy.CryptoObject(paramCryptoObject.getSignature());
      }
    } while (paramCryptoObject.getMac() == null);
    return new FingerprintManagerProxy.CryptoObject(paramCryptoObject.getMac());
  }
  
  private static FingerprintManager.AuthenticationCallback wrapCallback(FingerprintManagerProxy.AuthenticationCallback paramAuthenticationCallback)
  {
    return new FingerprintManagerProxy.1(paramAuthenticationCallback);
  }
  
  private static FingerprintManager.CryptoObject wrapCryptoObject(FingerprintManagerProxy.CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null) {}
    do
    {
      return null;
      if (paramCryptoObject.getCipher() != null) {
        return new FingerprintManager.CryptoObject(paramCryptoObject.getCipher());
      }
      if (paramCryptoObject.getSignature() != null) {
        return new FingerprintManager.CryptoObject(paramCryptoObject.getSignature());
      }
    } while (paramCryptoObject.getMac() == null);
    return new FingerprintManager.CryptoObject(paramCryptoObject.getMac());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.core.biometric.FingerprintManagerProxy
 * JD-Core Version:    0.7.0.1
 */