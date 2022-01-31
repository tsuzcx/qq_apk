package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;

class BiometricManagerCompat$LegacyFingerprintManagerImpl
  implements BiometricManagerCompat.IBiometricManager
{
  public void authenticate(Context paramContext, BiometricManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler) {}
  
  public String getBiometricName(Context paramContext)
  {
    return null;
  }
  
  public boolean hasEnrolledBiometric(Context paramContext)
  {
    return false;
  }
  
  public boolean isHardwareDetected(Context paramContext)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.biometric.BiometricManagerCompat.LegacyFingerprintManagerImpl
 * JD-Core Version:    0.7.0.1
 */