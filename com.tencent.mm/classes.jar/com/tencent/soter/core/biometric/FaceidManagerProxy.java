package com.tencent.soter.core.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.soter.core.c.d;
import java.lang.reflect.Method;

@SuppressLint({"NewApi"})
final class FaceidManagerProxy
{
  public static final String FACEMANAGER_FACTORY_CLASS_NAME = "com.tencent.soter.core.biometric.SoterFaceManagerFactory";
  private static final String TAG = "Soter.FaceidManagerProxy";
  
  public static void authenticate(Context paramContext, FaceidManagerProxy.CryptoObject paramCryptoObject, int paramInt, Object paramObject, FaceidManagerProxy.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    try
    {
      paramContext = getFaceManager(paramContext);
      if (paramContext != null)
      {
        paramContext.authenticate(wrapCryptoObject(paramCryptoObject), (CancellationSignal)paramObject, paramInt, wrapCallback(paramAuthenticationCallback), paramHandler);
        return;
      }
      d.e("Soter.FaceidManagerProxy", "soter: facemanager is null in authenticate! Should never happen", new Object[0]);
      return;
    }
    catch (Exception paramContext)
    {
      d.e("Soter.FaceidManagerProxy", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
    }
  }
  
  public static String getBiometricName(Context paramContext)
  {
    try
    {
      FaceManager localFaceManager = getFaceManager(paramContext);
      if (localFaceManager != null) {
        return localFaceManager.getBiometricName(paramContext);
      }
      d.e("Soter.FaceidManagerProxy", "soter: faceid manager is null! no biometric name returned.", new Object[0]);
      return null;
    }
    catch (Exception paramContext)
    {
      d.e("Soter.FaceidManagerProxy", "soter: triggered SecurityException in getBiometricName! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
    }
    return null;
  }
  
  private static FaceManager getFaceManager(Context paramContext)
  {
    try
    {
      paramContext = (FaceManager)Class.forName("com.tencent.soter.core.biometric.SoterFaceManagerFactory").getDeclaredMethod("getFaceManager", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      d.e("Soter.FaceidManagerProxy", "soter: FaceManager init failed, maybe not support." + paramContext.toString(), new Object[0]);
    }
    return null;
  }
  
  public static boolean hasEnrolledFaceids(Context paramContext)
  {
    try
    {
      paramContext = getFaceManager(paramContext);
      if (paramContext != null) {
        return paramContext.hasEnrolledFaces();
      }
      d.e("Soter.FaceidManagerProxy", "soter: facemanager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
      return false;
    }
    catch (Exception paramContext)
    {
      d.e("Soter.FaceidManagerProxy", "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
    }
    return false;
  }
  
  public static boolean isHardwareDetected(Context paramContext)
  {
    try
    {
      paramContext = getFaceManager(paramContext);
      if (paramContext != null) {
        return paramContext.isHardwareDetected();
      }
      d.e("Soter.FaceidManagerProxy", "soter: facemanager is null in isHardwareDetected! Should never happen", new Object[0]);
      return false;
    }
    catch (Exception paramContext)
    {
      d.e("Soter.FaceidManagerProxy", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
    }
    return false;
  }
  
  private static FaceidManagerProxy.CryptoObject unwrapCryptoObject(FaceManager.CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null) {}
    do
    {
      return null;
      if (paramCryptoObject.getCipher() != null) {
        return new FaceidManagerProxy.CryptoObject(paramCryptoObject.getCipher());
      }
      if (paramCryptoObject.getSignature() != null) {
        return new FaceidManagerProxy.CryptoObject(paramCryptoObject.getSignature());
      }
    } while (paramCryptoObject.getMac() == null);
    return new FaceidManagerProxy.CryptoObject(paramCryptoObject.getMac());
  }
  
  private static FaceManager.AuthenticationCallback wrapCallback(FaceidManagerProxy.AuthenticationCallback paramAuthenticationCallback)
  {
    return new FaceidManagerProxy.1(paramAuthenticationCallback);
  }
  
  private static FaceManager.CryptoObject wrapCryptoObject(FaceidManagerProxy.CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null) {}
    do
    {
      return null;
      if (paramCryptoObject.getCipher() != null) {
        return new FaceManager.CryptoObject(paramCryptoObject.getCipher());
      }
      if (paramCryptoObject.getSignature() != null) {
        return new FaceManager.CryptoObject(paramCryptoObject.getSignature());
      }
    } while (paramCryptoObject.getMac() == null);
    return new FaceManager.CryptoObject(paramCryptoObject.getMac());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.biometric.FaceidManagerProxy
 * JD-Core Version:    0.7.0.1
 */