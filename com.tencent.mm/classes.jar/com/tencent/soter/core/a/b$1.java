package com.tencent.soter.core.a;

import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import com.tencent.soter.core.c.d;

final class b$1
  extends FingerprintManager.AuthenticationCallback
{
  b$1(b.a parama) {}
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    d.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationError", new Object[0]);
    this.wOv.onAuthenticationError(paramInt, paramCharSequence);
  }
  
  public final void onAuthenticationFailed()
  {
    d.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationFailed", new Object[0]);
    this.wOv.onAuthenticationFailed();
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    d.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationHelp", new Object[0]);
    this.wOv.onAuthenticationHelp(paramInt, paramCharSequence);
  }
  
  public final void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult paramAuthenticationResult)
  {
    d.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
    b.a locala = this.wOv;
    paramAuthenticationResult = paramAuthenticationResult.getCryptoObject();
    if (paramAuthenticationResult != null) {
      if (paramAuthenticationResult.getCipher() != null) {
        paramAuthenticationResult = new b.c(paramAuthenticationResult.getCipher());
      }
    }
    for (;;)
    {
      locala.a(new b.b(paramAuthenticationResult));
      return;
      if (paramAuthenticationResult.getSignature() != null) {
        paramAuthenticationResult = new b.c(paramAuthenticationResult.getSignature());
      } else if (paramAuthenticationResult.getMac() != null) {
        paramAuthenticationResult = new b.c(paramAuthenticationResult.getMac());
      } else {
        paramAuthenticationResult = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.a.b.1
 * JD-Core Version:    0.7.0.1
 */