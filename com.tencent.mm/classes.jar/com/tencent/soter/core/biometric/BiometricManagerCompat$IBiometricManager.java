package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;

abstract interface BiometricManagerCompat$IBiometricManager
{
  public abstract void authenticate(Context paramContext, BiometricManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler);
  
  public abstract String getBiometricName(Context paramContext);
  
  public abstract boolean hasEnrolledBiometric(Context paramContext);
  
  public abstract boolean isHardwareDetected(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.soter.core.biometric.BiometricManagerCompat.IBiometricManager
 * JD-Core Version:    0.7.0.1
 */