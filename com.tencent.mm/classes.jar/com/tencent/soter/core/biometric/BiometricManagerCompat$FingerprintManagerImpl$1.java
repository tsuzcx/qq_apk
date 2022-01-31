package com.tencent.soter.core.biometric;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

final class BiometricManagerCompat$FingerprintManagerImpl$1
  extends FingerprintManagerProxy.AuthenticationCallback
{
  private boolean mMarkPermanentlyCallbacked = false;
  
  BiometricManagerCompat$FingerprintManagerImpl$1(BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback, Context paramContext) {}
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(72911);
    for (;;)
    {
      d.d("Soter.BiometricManagerCompat.Fingerprint", "soter: basic onAuthenticationError", new Object[0]);
      if (this.mMarkPermanentlyCallbacked)
      {
        AppMethodBeat.o(72911);
        return;
      }
      this.mMarkPermanentlyCallbacked = true;
      if (paramInt == 5)
      {
        d.i("Soter.BiometricManagerCompat.Fingerprint", "soter: user cancelled fingerprint authen", new Object[0]);
        this.val$callback.onAuthenticationCancelled();
        AppMethodBeat.o(72911);
        return;
      }
      if (paramInt != 7) {
        break;
      }
      d.i("Soter.BiometricManagerCompat.Fingerprint", "soter: system call too many trial.", new Object[0]);
      if ((!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.val$context)) && (!SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(this.val$context)) && (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce())) {
        SoterBiometricAntiBruteForceStrategy.freeze(this.val$context);
      }
      this.mMarkPermanentlyCallbacked = false;
      paramInt = 10308;
      paramCharSequence = "Too many failed times";
    }
    this.val$callback.onAuthenticationError(paramInt, paramCharSequence);
    AppMethodBeat.o(72911);
  }
  
  public final void onAuthenticationFailed()
  {
    AppMethodBeat.i(72914);
    d.d("Soter.BiometricManagerCompat.Fingerprint", "soter: basic onAuthenticationFailed", new Object[0]);
    if (this.mMarkPermanentlyCallbacked)
    {
      AppMethodBeat.o(72914);
      return;
    }
    if (!BiometricManagerCompat.FingerprintManagerImpl.access$000(this, this.val$context))
    {
      if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce())
      {
        SoterBiometricAntiBruteForceStrategy.addFailTime(this.val$context);
        if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.val$context))
        {
          d.w("Soter.BiometricManagerCompat.Fingerprint", "soter: too many fail trials", new Object[0]);
          SoterBiometricAntiBruteForceStrategy.freeze(this.val$context);
          BiometricManagerCompat.FingerprintManagerImpl.access$200(this);
          AppMethodBeat.o(72914);
          return;
        }
      }
      this.val$callback.onAuthenticationFailed();
    }
    AppMethodBeat.o(72914);
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(72912);
    d.d("Soter.BiometricManagerCompat.Fingerprint", "soter: basic onAuthenticationHelp", new Object[0]);
    if (this.mMarkPermanentlyCallbacked)
    {
      AppMethodBeat.o(72912);
      return;
    }
    if (!BiometricManagerCompat.FingerprintManagerImpl.access$000(this, this.val$context)) {
      this.val$callback.onAuthenticationHelp(paramInt, paramCharSequence);
    }
    AppMethodBeat.o(72912);
  }
  
  public final void onAuthenticationSucceeded(FingerprintManagerProxy.AuthenticationResultInternal paramAuthenticationResultInternal)
  {
    AppMethodBeat.i(72913);
    d.d("Soter.BiometricManagerCompat.Fingerprint", "soter: basic onAuthenticationSucceeded", new Object[0]);
    if (this.mMarkPermanentlyCallbacked)
    {
      AppMethodBeat.o(72913);
      return;
    }
    if (!BiometricManagerCompat.FingerprintManagerImpl.access$000(this, this.val$context))
    {
      if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
        SoterBiometricAntiBruteForceStrategy.unFreeze(this.val$context);
      }
      this.mMarkPermanentlyCallbacked = true;
      this.val$callback.onAuthenticationSucceeded(new BiometricManagerCompat.AuthenticationResult(BiometricManagerCompat.FingerprintManagerImpl.access$100(paramAuthenticationResultInternal.getCryptoObject())));
    }
    AppMethodBeat.o(72913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.soter.core.biometric.BiometricManagerCompat.FingerprintManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */