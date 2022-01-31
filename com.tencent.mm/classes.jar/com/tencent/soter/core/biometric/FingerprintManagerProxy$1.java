package com.tencent.soter.core.biometric;

import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

final class FingerprintManagerProxy$1
  extends FingerprintManager.AuthenticationCallback
{
  FingerprintManagerProxy$1(FingerprintManagerProxy.AuthenticationCallback paramAuthenticationCallback) {}
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(72948);
    d.d("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationError", new Object[0]);
    this.val$callback.onAuthenticationError(paramInt, paramCharSequence);
    AppMethodBeat.o(72948);
  }
  
  public final void onAuthenticationFailed()
  {
    AppMethodBeat.i(72951);
    d.d("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationFailed", new Object[0]);
    this.val$callback.onAuthenticationFailed();
    AppMethodBeat.o(72951);
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(72949);
    d.d("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationHelp", new Object[0]);
    this.val$callback.onAuthenticationHelp(paramInt, paramCharSequence);
    AppMethodBeat.o(72949);
  }
  
  public final void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult paramAuthenticationResult)
  {
    AppMethodBeat.i(72950);
    d.d("Soter.FingerprintManagerProxy", "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
    this.val$callback.onAuthenticationSucceeded(new FingerprintManagerProxy.AuthenticationResultInternal(FingerprintManagerProxy.access$000(paramAuthenticationResult.getCryptoObject())));
    AppMethodBeat.o(72950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.soter.core.biometric.FingerprintManagerProxy.1
 * JD-Core Version:    0.7.0.1
 */