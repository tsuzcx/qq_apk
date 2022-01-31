package com.tencent.soter.core.biometric;

import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import com.tencent.soter.core.c.d;

final class FingerprintManagerProxy$1
  extends FingerprintManager.AuthenticationCallback
{
  FingerprintManagerProxy$1(FingerprintManagerProxy.AuthenticationCallback paramAuthenticationCallback) {}
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    d.d("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationError", new Object[0]);
    this.val$callback.onAuthenticationError(paramInt, paramCharSequence);
  }
  
  public final void onAuthenticationFailed()
  {
    d.d("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationFailed", new Object[0]);
    this.val$callback.onAuthenticationFailed();
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    d.d("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationHelp", new Object[0]);
    this.val$callback.onAuthenticationHelp(paramInt, paramCharSequence);
  }
  
  public final void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult paramAuthenticationResult)
  {
    d.d("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
    this.val$callback.onAuthenticationSucceeded(new FingerprintManagerProxy.AuthenticationResultInternal(FingerprintManagerProxy.access$000(paramAuthenticationResult.getCryptoObject())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.soter.core.biometric.FingerprintManagerProxy.1
 * JD-Core Version:    0.7.0.1
 */