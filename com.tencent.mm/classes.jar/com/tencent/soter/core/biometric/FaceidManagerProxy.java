package com.tencent.soter.core.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import java.lang.reflect.Method;

@SuppressLint({"NewApi"})
final class FaceidManagerProxy
{
  public static final String FACEMANAGER_FACTORY_CLASS_NAME = "com.tencent.soter.core.biometric.SoterFaceManagerFactory";
  private static final String TAG = "Soter.FaceidManagerProxy";
  
  public static void authenticate(Context paramContext, FaceidManagerProxy.CryptoObject paramCryptoObject, int paramInt, Object paramObject, FaceidManagerProxy.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    AppMethodBeat.i(72942);
    try
    {
      paramContext = getFaceManager(paramContext);
      if (paramContext != null)
      {
        paramContext.authenticate(wrapCryptoObject(paramCryptoObject), (CancellationSignal)paramObject, paramInt, wrapCallback(paramAuthenticationCallback), paramHandler);
        AppMethodBeat.o(72942);
        return;
      }
      d.e("Soter.FaceidManagerProxy", "soter: facemanager is null in authenticate! Should never happen", new Object[0]);
      AppMethodBeat.o(72942);
      return;
    }
    catch (Exception paramContext)
    {
      d.e("Soter.FaceidManagerProxy", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(72942);
    }
  }
  
  public static String getBiometricName(Context paramContext)
  {
    AppMethodBeat.i(72946);
    try
    {
      FaceManager localFaceManager = getFaceManager(paramContext);
      if (localFaceManager != null)
      {
        paramContext = localFaceManager.getBiometricName(paramContext);
        AppMethodBeat.o(72946);
        return paramContext;
      }
      d.e("Soter.FaceidManagerProxy", "soter: faceid manager is null! no biometric name returned.", new Object[0]);
      AppMethodBeat.o(72946);
      return null;
    }
    catch (Exception paramContext)
    {
      d.e("Soter.FaceidManagerProxy", "soter: triggered SecurityException in getBiometricName! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(72946);
    }
    return null;
  }
  
  private static FaceManager getFaceManager(Context paramContext)
  {
    AppMethodBeat.i(72939);
    try
    {
      paramContext = (FaceManager)Class.forName("com.tencent.soter.core.biometric.SoterFaceManagerFactory").getDeclaredMethod("getFaceManager", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      AppMethodBeat.o(72939);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        d.e("Soter.FaceidManagerProxy", "soter: FaceManager init failed, maybe not support." + paramContext.toString(), new Object[0]);
        paramContext = null;
      }
    }
  }
  
  public static boolean hasEnrolledFaceids(Context paramContext)
  {
    AppMethodBeat.i(72940);
    try
    {
      paramContext = getFaceManager(paramContext);
      if (paramContext != null)
      {
        boolean bool = paramContext.hasEnrolledFaces();
        AppMethodBeat.o(72940);
        return bool;
      }
      d.e("Soter.FaceidManagerProxy", "soter: facemanager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
      AppMethodBeat.o(72940);
      return false;
    }
    catch (Exception paramContext)
    {
      d.e("Soter.FaceidManagerProxy", "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(72940);
    }
    return false;
  }
  
  public static boolean isHardwareDetected(Context paramContext)
  {
    AppMethodBeat.i(72941);
    try
    {
      paramContext = getFaceManager(paramContext);
      if (paramContext != null)
      {
        boolean bool = paramContext.isHardwareDetected();
        AppMethodBeat.o(72941);
        return bool;
      }
      d.e("Soter.FaceidManagerProxy", "soter: facemanager is null in isHardwareDetected! Should never happen", new Object[0]);
      AppMethodBeat.o(72941);
      return false;
    }
    catch (Exception paramContext)
    {
      d.e("Soter.FaceidManagerProxy", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(72941);
    }
    return false;
  }
  
  private static FaceidManagerProxy.CryptoObject unwrapCryptoObject(FaceManager.CryptoObject paramCryptoObject)
  {
    AppMethodBeat.i(72944);
    if (paramCryptoObject == null)
    {
      AppMethodBeat.o(72944);
      return null;
    }
    if (paramCryptoObject.getCipher() != null)
    {
      paramCryptoObject = new FaceidManagerProxy.CryptoObject(paramCryptoObject.getCipher());
      AppMethodBeat.o(72944);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getSignature() != null)
    {
      paramCryptoObject = new FaceidManagerProxy.CryptoObject(paramCryptoObject.getSignature());
      AppMethodBeat.o(72944);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getMac() != null)
    {
      paramCryptoObject = new FaceidManagerProxy.CryptoObject(paramCryptoObject.getMac());
      AppMethodBeat.o(72944);
      return paramCryptoObject;
    }
    AppMethodBeat.o(72944);
    return null;
  }
  
  private static FaceManager.AuthenticationCallback wrapCallback(FaceidManagerProxy.AuthenticationCallback paramAuthenticationCallback)
  {
    AppMethodBeat.i(72945);
    paramAuthenticationCallback = new FaceidManagerProxy.1(paramAuthenticationCallback);
    AppMethodBeat.o(72945);
    return paramAuthenticationCallback;
  }
  
  private static FaceManager.CryptoObject wrapCryptoObject(FaceidManagerProxy.CryptoObject paramCryptoObject)
  {
    AppMethodBeat.i(72943);
    if (paramCryptoObject == null)
    {
      AppMethodBeat.o(72943);
      return null;
    }
    if (paramCryptoObject.getCipher() != null)
    {
      paramCryptoObject = new FaceManager.CryptoObject(paramCryptoObject.getCipher());
      AppMethodBeat.o(72943);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getSignature() != null)
    {
      paramCryptoObject = new FaceManager.CryptoObject(paramCryptoObject.getSignature());
      AppMethodBeat.o(72943);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getMac() != null)
    {
      paramCryptoObject = new FaceManager.CryptoObject(paramCryptoObject.getMac());
      AppMethodBeat.o(72943);
      return paramCryptoObject;
    }
    AppMethodBeat.o(72943);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.biometric.FaceidManagerProxy
 * JD-Core Version:    0.7.0.1
 */