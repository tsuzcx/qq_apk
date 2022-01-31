package com.tencent.soter.core.biometric;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

final class BiometricManagerCompat$FaceidManagerImpl$1
  extends FaceidManagerProxy.AuthenticationCallback
{
  private boolean mMarkPermanentlyCallbacked = false;
  
  BiometricManagerCompat$FaceidManagerImpl$1(BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback, Context paramContext) {}
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(72895);
    d.d("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationError code[%d], msg[%s] entered.", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    if (this.mMarkPermanentlyCallbacked)
    {
      d.d("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationError code[%d], msg[%s] returned cause permanently callback.", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
      AppMethodBeat.o(72895);
      return;
    }
    this.mMarkPermanentlyCallbacked = true;
    if (paramInt == 5)
    {
      d.i("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned cause FACE_ERROR_CANCELED got.", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
      this.val$callback.onAuthenticationCancelled();
      AppMethodBeat.o(72895);
      return;
    }
    if (paramInt == 7)
    {
      d.i("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned cause FACE_ERROR_LOCKOUT got.", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
      if ((!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.val$context)) && (!SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(this.val$context)) && (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce())) {
        SoterBiometricAntiBruteForceStrategy.freeze(this.val$context);
      }
      this.val$callback.onAuthenticationError(10308, "Too many failed times");
      AppMethodBeat.o(72895);
      return;
    }
    d.d("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned.", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    this.val$callback.onAuthenticationError(paramInt, paramCharSequence);
    AppMethodBeat.o(72895);
  }
  
  public final void onAuthenticationFailed()
  {
    AppMethodBeat.i(72898);
    d.d("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationFailed", new Object[0]);
    if (this.mMarkPermanentlyCallbacked)
    {
      AppMethodBeat.o(72898);
      return;
    }
    this.mMarkPermanentlyCallbacked = true;
    if ((!BiometricManagerCompat.FaceidManagerImpl.access$300(this, this.val$context)) && (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()))
    {
      SoterBiometricAntiBruteForceStrategy.addFailTime(this.val$context);
      if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.val$context))
      {
        d.w("Soter.BiometricManagerCompat.Faceid", "soter: too many fail trials", new Object[0]);
        SoterBiometricAntiBruteForceStrategy.freeze(this.val$context);
        BiometricManagerCompat.FaceidManagerImpl.access$500(this);
        AppMethodBeat.o(72898);
        return;
      }
    }
    this.val$callback.onAuthenticationFailed();
    AppMethodBeat.o(72898);
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(72896);
    d.d("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationHelp helpMsgId[%d], helpString[%s]", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    System.currentTimeMillis();
    if (this.mMarkPermanentlyCallbacked)
    {
      AppMethodBeat.o(72896);
      return;
    }
    if (!BiometricManagerCompat.FaceidManagerImpl.access$300(this, this.val$context)) {
      this.val$callback.onAuthenticationHelp(paramInt, paramCharSequence);
    }
    AppMethodBeat.o(72896);
  }
  
  public final void onAuthenticationSucceeded(FaceidManagerProxy.AuthenticationResult paramAuthenticationResult)
  {
    AppMethodBeat.i(72897);
    d.d("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationSucceeded", new Object[0]);
    if (this.mMarkPermanentlyCallbacked)
    {
      AppMethodBeat.o(72897);
      return;
    }
    this.mMarkPermanentlyCallbacked = true;
    if (!BiometricManagerCompat.FaceidManagerImpl.access$300(this, this.val$context))
    {
      if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
        SoterBiometricAntiBruteForceStrategy.unFreeze(this.val$context);
      }
      this.val$callback.onAuthenticationSucceeded(new BiometricManagerCompat.AuthenticationResult(BiometricManagerCompat.FaceidManagerImpl.access$400(paramAuthenticationResult.getCryptoObject())));
    }
    AppMethodBeat.o(72897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.core.biometric.BiometricManagerCompat.FaceidManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */