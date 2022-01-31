package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.soter.core.c.d;

class BiometricManagerCompat$FingerprintManagerImpl
  implements BiometricManagerCompat.IBiometricManager
{
  private static final String TAG = "Soter.BiometricManagerCompat.Fingerprint";
  
  private static void informTooManyTrial(FingerprintManagerProxy.AuthenticationCallback paramAuthenticationCallback)
  {
    d.w("Soter.BiometricManagerCompat.Fingerprint", "soter: too many fail fingerprint callback. inform it.", new Object[0]);
    paramAuthenticationCallback.onAuthenticationError(10308, "Too many failed times");
  }
  
  private static boolean shouldInformTooManyTrial(FingerprintManagerProxy.AuthenticationCallback paramAuthenticationCallback, Context paramContext)
  {
    if (SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
      d.v("Soter.BiometricManagerCompat.Fingerprint", "soter: using system anti brute force strategy", new Object[0]);
    }
    do
    {
      return false;
      if (!SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(paramContext)) {
        break;
      }
    } while (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(paramContext));
    d.v("Soter.BiometricManagerCompat.Fingerprint", "soter: unfreeze former frozen status", new Object[0]);
    SoterBiometricAntiBruteForceStrategy.unFreeze(paramContext);
    return false;
    if (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(paramContext))
    {
      d.v("Soter.BiometricManagerCompat.Fingerprint", "soter: failure time available", new Object[0]);
      return false;
    }
    informTooManyTrial(paramAuthenticationCallback);
    return true;
  }
  
  private static BiometricManagerCompat.CryptoObject unwrapCryptoObject(FingerprintManagerProxy.CryptoObject paramCryptoObject)
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
  
  private static FingerprintManagerProxy.AuthenticationCallback wrapCallback(Context paramContext, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback)
  {
    return new BiometricManagerCompat.FingerprintManagerImpl.1(paramAuthenticationCallback, paramContext);
  }
  
  private static FingerprintManagerProxy.CryptoObject wrapCryptoObject(BiometricManagerCompat.CryptoObject paramCryptoObject)
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
  
  public void authenticate(Context paramContext, BiometricManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    FingerprintManagerProxy.authenticate(paramContext, wrapCryptoObject(paramCryptoObject), paramInt, paramCancellationSignal, wrapCallback(paramContext, paramAuthenticationCallback), paramHandler);
  }
  
  public String getBiometricName(Context paramContext)
  {
    return "fingerprint";
  }
  
  public boolean hasEnrolledBiometric(Context paramContext)
  {
    return FingerprintManagerProxy.hasEnrolledFingerprints(paramContext);
  }
  
  public boolean isHardwareDetected(Context paramContext)
  {
    return FingerprintManagerProxy.isHardwareDetected(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.biometric.BiometricManagerCompat.FingerprintManagerImpl
 * JD-Core Version:    0.7.0.1
 */