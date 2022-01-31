package com.tencent.soter.core.biometric;

import com.tencent.soter.core.c.d;

final class FaceidManagerProxy$1
  extends FaceManager.AuthenticationCallback
{
  FaceidManagerProxy$1(FaceidManagerProxy.AuthenticationCallback paramAuthenticationCallback) {}
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    d.d("Soter.FaceidManagerProxy", "hy: lowest level return onAuthenticationError", new Object[0]);
    this.val$callback.onAuthenticationError(paramInt, paramCharSequence);
  }
  
  public final void onAuthenticationFailed()
  {
    d.d("Soter.FaceidManagerProxy", "hy: lowest level return onAuthenticationFailed", new Object[0]);
    this.val$callback.onAuthenticationFailed();
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    d.d("Soter.FaceidManagerProxy", "hy: lowest level return onAuthenticationHelp", new Object[0]);
    this.val$callback.onAuthenticationHelp(paramInt, paramCharSequence);
  }
  
  public final void onAuthenticationSucceeded(FaceManager.AuthenticationResult paramAuthenticationResult)
  {
    d.d("Soter.FaceidManagerProxy", "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
    this.val$callback.onAuthenticationSucceeded(new FaceidManagerProxy.AuthenticationResult(FaceidManagerProxy.access$000(paramAuthenticationResult.getCryptoObject())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.biometric.FaceidManagerProxy.1
 * JD-Core Version:    0.7.0.1
 */