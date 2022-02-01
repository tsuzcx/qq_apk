package com.tencent.soter.core.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import java.lang.reflect.Method;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
final class FaceidManagerProxy
{
  public static final String FACEMANAGER_FACTORY_CLASS_NAME = "com.tencent.soter.core.biometric.SoterFaceManagerFactory";
  private static final String TAG = "Soter.FaceidManagerProxy";
  
  public static void authenticate(Context paramContext, CryptoObject paramCryptoObject, int paramInt, Object paramObject, AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    AppMethodBeat.i(88570);
    try
    {
      paramContext = getFaceManager(paramContext);
      if (paramContext != null)
      {
        paramContext.authenticate(wrapCryptoObject(paramCryptoObject), (CancellationSignal)paramObject, paramInt, wrapCallback(paramAuthenticationCallback), paramHandler);
        AppMethodBeat.o(88570);
        return;
      }
      d.e("Soter.FaceidManagerProxy", "soter: facemanager is null in authenticate! Should never happen", new Object[0]);
      AppMethodBeat.o(88570);
      return;
    }
    catch (Exception paramContext)
    {
      d.e("Soter.FaceidManagerProxy", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(88570);
    }
  }
  
  public static String getBiometricName(Context paramContext)
  {
    AppMethodBeat.i(88574);
    try
    {
      FaceManager localFaceManager = getFaceManager(paramContext);
      if (localFaceManager != null)
      {
        paramContext = localFaceManager.getBiometricName(paramContext);
        AppMethodBeat.o(88574);
        return paramContext;
      }
      d.e("Soter.FaceidManagerProxy", "soter: faceid manager is null! no biometric name returned.", new Object[0]);
      AppMethodBeat.o(88574);
      return null;
    }
    catch (Exception paramContext)
    {
      d.e("Soter.FaceidManagerProxy", "soter: triggered SecurityException in getBiometricName! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(88574);
    }
    return null;
  }
  
  private static FaceManager getFaceManager(Context paramContext)
  {
    AppMethodBeat.i(88567);
    try
    {
      paramContext = (FaceManager)Class.forName("com.tencent.soter.core.biometric.SoterFaceManagerFactory").getDeclaredMethod("getFaceManager", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      AppMethodBeat.o(88567);
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
    AppMethodBeat.i(88568);
    try
    {
      paramContext = getFaceManager(paramContext);
      if (paramContext != null)
      {
        boolean bool = paramContext.hasEnrolledFaces();
        AppMethodBeat.o(88568);
        return bool;
      }
      d.e("Soter.FaceidManagerProxy", "soter: facemanager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
      AppMethodBeat.o(88568);
      return false;
    }
    catch (Exception paramContext)
    {
      d.e("Soter.FaceidManagerProxy", "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(88568);
    }
    return false;
  }
  
  public static boolean isHardwareDetected(Context paramContext)
  {
    AppMethodBeat.i(88569);
    try
    {
      paramContext = getFaceManager(paramContext);
      if (paramContext != null)
      {
        boolean bool = paramContext.isHardwareDetected();
        AppMethodBeat.o(88569);
        return bool;
      }
      d.e("Soter.FaceidManagerProxy", "soter: facemanager is null in isHardwareDetected! Should never happen", new Object[0]);
      AppMethodBeat.o(88569);
      return false;
    }
    catch (Exception paramContext)
    {
      d.e("Soter.FaceidManagerProxy", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(88569);
    }
    return false;
  }
  
  private static CryptoObject unwrapCryptoObject(FaceManager.CryptoObject paramCryptoObject)
  {
    AppMethodBeat.i(88572);
    if (paramCryptoObject == null)
    {
      AppMethodBeat.o(88572);
      return null;
    }
    if (paramCryptoObject.getCipher() != null)
    {
      paramCryptoObject = new CryptoObject(paramCryptoObject.getCipher());
      AppMethodBeat.o(88572);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getSignature() != null)
    {
      paramCryptoObject = new CryptoObject(paramCryptoObject.getSignature());
      AppMethodBeat.o(88572);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getMac() != null)
    {
      paramCryptoObject = new CryptoObject(paramCryptoObject.getMac());
      AppMethodBeat.o(88572);
      return paramCryptoObject;
    }
    AppMethodBeat.o(88572);
    return null;
  }
  
  private static FaceManager.AuthenticationCallback wrapCallback(AuthenticationCallback paramAuthenticationCallback)
  {
    AppMethodBeat.i(88573);
    paramAuthenticationCallback = new FaceManager.AuthenticationCallback()
    {
      public final void onAuthenticationError(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(88563);
        d.d("Soter.FaceidManagerProxy", "hy: lowest level return onAuthenticationError", new Object[0]);
        this.val$callback.onAuthenticationError(paramAnonymousInt, paramAnonymousCharSequence);
        AppMethodBeat.o(88563);
      }
      
      public final void onAuthenticationFailed()
      {
        AppMethodBeat.i(88566);
        d.d("Soter.FaceidManagerProxy", "hy: lowest level return onAuthenticationFailed", new Object[0]);
        this.val$callback.onAuthenticationFailed();
        AppMethodBeat.o(88566);
      }
      
      public final void onAuthenticationHelp(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(88564);
        d.d("Soter.FaceidManagerProxy", "hy: lowest level return onAuthenticationHelp", new Object[0]);
        this.val$callback.onAuthenticationHelp(paramAnonymousInt, paramAnonymousCharSequence);
        AppMethodBeat.o(88564);
      }
      
      public final void onAuthenticationSucceeded(FaceManager.AuthenticationResult paramAnonymousAuthenticationResult)
      {
        AppMethodBeat.i(88565);
        d.d("Soter.FaceidManagerProxy", "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
        this.val$callback.onAuthenticationSucceeded(new FaceidManagerProxy.AuthenticationResult(FaceidManagerProxy.access$000(paramAnonymousAuthenticationResult.getCryptoObject())));
        AppMethodBeat.o(88565);
      }
    };
    AppMethodBeat.o(88573);
    return paramAuthenticationCallback;
  }
  
  private static FaceManager.CryptoObject wrapCryptoObject(CryptoObject paramCryptoObject)
  {
    AppMethodBeat.i(88571);
    if (paramCryptoObject == null)
    {
      AppMethodBeat.o(88571);
      return null;
    }
    if (paramCryptoObject.getCipher() != null)
    {
      paramCryptoObject = new FaceManager.CryptoObject(paramCryptoObject.getCipher());
      AppMethodBeat.o(88571);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getSignature() != null)
    {
      paramCryptoObject = new FaceManager.CryptoObject(paramCryptoObject.getSignature());
      AppMethodBeat.o(88571);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getMac() != null)
    {
      paramCryptoObject = new FaceManager.CryptoObject(paramCryptoObject.getMac());
      AppMethodBeat.o(88571);
      return paramCryptoObject;
    }
    AppMethodBeat.o(88571);
    return null;
  }
  
  public static abstract class AuthenticationCallback
  {
    public void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationFailed() {}
    
    public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationSucceeded(FaceidManagerProxy.AuthenticationResult paramAuthenticationResult) {}
  }
  
  public static final class AuthenticationResult
  {
    private FaceidManagerProxy.CryptoObject mCryptoObject;
    
    public AuthenticationResult(FaceidManagerProxy.CryptoObject paramCryptoObject)
    {
      this.mCryptoObject = paramCryptoObject;
    }
    
    public final FaceidManagerProxy.CryptoObject getCryptoObject()
    {
      return this.mCryptoObject;
    }
  }
  
  public static class CryptoObject
  {
    private final Cipher mCipher;
    private final Mac mMac;
    private final Signature mSignature;
    
    public CryptoObject(Signature paramSignature)
    {
      this.mSignature = paramSignature;
      this.mCipher = null;
      this.mMac = null;
    }
    
    public CryptoObject(Cipher paramCipher)
    {
      this.mCipher = paramCipher;
      this.mSignature = null;
      this.mMac = null;
    }
    
    public CryptoObject(Mac paramMac)
    {
      this.mMac = paramMac;
      this.mCipher = null;
      this.mSignature = null;
    }
    
    public Cipher getCipher()
    {
      return this.mCipher;
    }
    
    public Mac getMac()
    {
      return this.mMac;
    }
    
    public Signature getSignature()
    {
      return this.mSignature;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.soter.core.biometric.FaceidManagerProxy
 * JD-Core Version:    0.7.0.1
 */