package com.tencent.soter.core.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
final class FingerprintManagerProxy
{
  public static final String FINGERPRINT_SERVICE = "fingerprint";
  private static final String TAG = "Soter.FingerprintManagerProxy";
  
  public static void authenticate(Context paramContext, CryptoObject paramCryptoObject, int paramInt, Object paramObject, AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    AppMethodBeat.i(88584);
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: permission check failed: authenticate", new Object[0]);
      AppMethodBeat.o(88584);
      return;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null)
      {
        paramContext.authenticate(wrapCryptoObject(paramCryptoObject), (CancellationSignal)paramObject, paramInt, wrapCallback(paramAuthenticationCallback), paramHandler);
        AppMethodBeat.o(88584);
        return;
      }
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(88584);
      return;
    }
    d.e("Soter.FingerprintManagerProxy", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
    AppMethodBeat.o(88584);
  }
  
  private static int checkSelfPermission(Context paramContext, String paramString)
  {
    AppMethodBeat.i(88582);
    if (paramContext == null)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: check self permission: context is null", new Object[0]);
      AppMethodBeat.o(88582);
      return -1;
    }
    if (g.isNullOrNil(paramString))
    {
      d.e("Soter.FingerprintManagerProxy", "soter: requested permission is null or nil", new Object[0]);
      AppMethodBeat.o(88582);
      return -1;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      d.d("Soter.FingerprintManagerProxy", "soter: below 23. directly return.", new Object[0]);
      AppMethodBeat.o(88582);
      return 0;
    }
    int i = paramContext.checkSelfPermission(paramString);
    AppMethodBeat.o(88582);
    return i;
  }
  
  private static FingerprintManager getFingerprintManager(Context paramContext)
  {
    AppMethodBeat.i(88580);
    paramContext = (FingerprintManager)paramContext.getSystemService("fingerprint");
    AppMethodBeat.o(88580);
    return paramContext;
  }
  
  public static boolean hasEnrolledFingerprints(Context paramContext)
  {
    AppMethodBeat.i(88581);
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: permission check failed: hasEnrolledBiometric", new Object[0]);
      AppMethodBeat.o(88581);
      return false;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null)
      {
        boolean bool = paramContext.hasEnrolledFingerprints();
        AppMethodBeat.o(88581);
        return bool;
      }
      d.e("Soter.FingerprintManagerProxy", "soter: fingerprint manager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
      AppMethodBeat.o(88581);
      return false;
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(88581);
    }
    return false;
  }
  
  public static boolean isHardwareDetected(Context paramContext)
  {
    AppMethodBeat.i(88583);
    if (checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") != 0)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: permission check failed: isHardwareDetected", new Object[0]);
      AppMethodBeat.o(88583);
      return false;
    }
    try
    {
      paramContext = getFingerprintManager(paramContext);
      if (paramContext != null)
      {
        boolean bool = paramContext.isHardwareDetected();
        AppMethodBeat.o(88583);
        return bool;
      }
      d.e("Soter.FingerprintManagerProxy", "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
      AppMethodBeat.o(88583);
      return false;
    }
    catch (SecurityException paramContext)
    {
      d.e("Soter.FingerprintManagerProxy", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
      AppMethodBeat.o(88583);
    }
    return false;
  }
  
  private static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject paramCryptoObject)
  {
    AppMethodBeat.i(88586);
    if (paramCryptoObject == null)
    {
      AppMethodBeat.o(88586);
      return null;
    }
    if (paramCryptoObject.getCipher() != null)
    {
      paramCryptoObject = new CryptoObject(paramCryptoObject.getCipher());
      AppMethodBeat.o(88586);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getSignature() != null)
    {
      paramCryptoObject = new CryptoObject(paramCryptoObject.getSignature());
      AppMethodBeat.o(88586);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getMac() != null)
    {
      paramCryptoObject = new CryptoObject(paramCryptoObject.getMac());
      AppMethodBeat.o(88586);
      return paramCryptoObject;
    }
    AppMethodBeat.o(88586);
    return null;
  }
  
  private static FingerprintManager.AuthenticationCallback wrapCallback(AuthenticationCallback paramAuthenticationCallback)
  {
    AppMethodBeat.i(88587);
    paramAuthenticationCallback = new FingerprintManager.AuthenticationCallback()
    {
      public final void onAuthenticationError(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(88576);
        d.d("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationError", new Object[0]);
        this.val$callback.onAuthenticationError(paramAnonymousInt, paramAnonymousCharSequence);
        AppMethodBeat.o(88576);
      }
      
      public final void onAuthenticationFailed()
      {
        AppMethodBeat.i(88579);
        d.d("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationFailed", new Object[0]);
        this.val$callback.onAuthenticationFailed();
        AppMethodBeat.o(88579);
      }
      
      public final void onAuthenticationHelp(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(88577);
        d.d("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationHelp", new Object[0]);
        this.val$callback.onAuthenticationHelp(paramAnonymousInt, paramAnonymousCharSequence);
        AppMethodBeat.o(88577);
      }
      
      public final void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult paramAnonymousAuthenticationResult)
      {
        AppMethodBeat.i(88578);
        d.d("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
        this.val$callback.onAuthenticationSucceeded(new FingerprintManagerProxy.AuthenticationResultInternal(FingerprintManagerProxy.access$000(paramAnonymousAuthenticationResult.getCryptoObject())));
        AppMethodBeat.o(88578);
      }
    };
    AppMethodBeat.o(88587);
    return paramAuthenticationCallback;
  }
  
  private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject paramCryptoObject)
  {
    AppMethodBeat.i(88585);
    if (paramCryptoObject == null)
    {
      AppMethodBeat.o(88585);
      return null;
    }
    if (paramCryptoObject.getCipher() != null)
    {
      paramCryptoObject = new FingerprintManager.CryptoObject(paramCryptoObject.getCipher());
      AppMethodBeat.o(88585);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getSignature() != null)
    {
      paramCryptoObject = new FingerprintManager.CryptoObject(paramCryptoObject.getSignature());
      AppMethodBeat.o(88585);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getMac() != null)
    {
      paramCryptoObject = new FingerprintManager.CryptoObject(paramCryptoObject.getMac());
      AppMethodBeat.o(88585);
      return paramCryptoObject;
    }
    AppMethodBeat.o(88585);
    return null;
  }
  
  public static abstract class AuthenticationCallback
  {
    public void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationFailed() {}
    
    public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationSucceeded(FingerprintManagerProxy.AuthenticationResultInternal paramAuthenticationResultInternal) {}
  }
  
  public static final class AuthenticationResultInternal
  {
    private FingerprintManagerProxy.CryptoObject mCryptoObject;
    
    public AuthenticationResultInternal(FingerprintManagerProxy.CryptoObject paramCryptoObject)
    {
      this.mCryptoObject = paramCryptoObject;
    }
    
    public final FingerprintManagerProxy.CryptoObject getCryptoObject()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.biometric.FingerprintManagerProxy
 * JD-Core Version:    0.7.0.1
 */