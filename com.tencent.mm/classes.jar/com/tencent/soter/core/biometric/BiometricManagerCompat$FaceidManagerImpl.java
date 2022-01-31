package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.soter.core.c.d;

class BiometricManagerCompat$FaceidManagerImpl
  implements BiometricManagerCompat.IBiometricManager
{
  private static final String TAG = "Soter.BiometricManagerCompat.Faceid";
  
  private static void informTooManyTrial(FaceidManagerProxy.AuthenticationCallback paramAuthenticationCallback)
  {
    d.w("Soter.BiometricManagerCompat.Faceid", "soter: too many fail callback. inform it.", new Object[0]);
    paramAuthenticationCallback.onAuthenticationError(10308, "Too many failed times");
  }
  
  private static boolean shouldInformTooManyTrial(FaceidManagerProxy.AuthenticationCallback paramAuthenticationCallback, Context paramContext)
  {
    if (SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
      d.v("Soter.BiometricManagerCompat.Faceid", "soter: using system anti brute force strategy", new Object[0]);
    }
    do
    {
      return false;
      if (!SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(paramContext)) {
        break;
      }
    } while (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(paramContext));
    d.v("Soter.BiometricManagerCompat.Faceid", "soter: unfreeze former frozen status", new Object[0]);
    SoterBiometricAntiBruteForceStrategy.unFreeze(paramContext);
    return false;
    if (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(paramContext))
    {
      d.v("Soter.BiometricManagerCompat.Faceid", "soter: failure time available", new Object[0]);
      return false;
    }
    informTooManyTrial(paramAuthenticationCallback);
    return true;
  }
  
  private static BiometricManagerCompat.CryptoObject unwrapCryptoObject(FaceidManagerProxy.CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null) {}
    do
    {
      return null;
      if (paramCryptoObject.getCipher() != null) {
        return new BiometricManagerCompat.CryptoObject(paramCryptoObject.getCipher());
      }
      if (paramCryptoObject.getSignature() != null) {
        return new BiometricManagerCompat.CryptoObject(paramCryptoObject.getSignature());
      }
    } while (paramCryptoObject.getMac() == null);
    return new BiometricManagerCompat.CryptoObject(paramCryptoObject.getMac());
  }
  
  private static FaceidManagerProxy.AuthenticationCallback wrapCallback(Context paramContext, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback)
  {
    return new BiometricManagerCompat.FaceidManagerImpl.1(paramAuthenticationCallback, paramContext);
  }
  
  private static FaceidManagerProxy.CryptoObject wrapCryptoObject(BiometricManagerCompat.CryptoObject paramCryptoObject)
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
  
  public void authenticate(Context paramContext, BiometricManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    FaceidManagerProxy.authenticate(paramContext, wrapCryptoObject(paramCryptoObject), paramInt, paramCancellationSignal, wrapCallback(paramContext, paramAuthenticationCallback), paramHandler);
  }
  
  public String getBiometricName(Context paramContext)
  {
    return FaceidManagerProxy.getBiometricName(paramContext);
  }
  
  public boolean hasEnrolledBiometric(Context paramContext)
  {
    return FaceidManagerProxy.hasEnrolledFaceids(paramContext);
  }
  
  public boolean isHardwareDetected(Context paramContext)
  {
    return FaceidManagerProxy.isHardwareDetected(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.soter.core.biometric.BiometricManagerCompat.FaceidManagerImpl
 * JD-Core Version:    0.7.0.1
 */