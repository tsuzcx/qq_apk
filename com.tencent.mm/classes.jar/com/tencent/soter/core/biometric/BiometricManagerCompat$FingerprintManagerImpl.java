package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

class BiometricManagerCompat$FingerprintManagerImpl
  implements BiometricManagerCompat.IBiometricManager
{
  private static final String TAG = "Soter.BiometricManagerCompat.Fingerprint";
  
  private static void informTooManyTrial(FingerprintManagerProxy.AuthenticationCallback paramAuthenticationCallback)
  {
    AppMethodBeat.i(88550);
    d.w("Soter.BiometricManagerCompat.Fingerprint", "soter: too many fail fingerprint callback. inform it.", new Object[0]);
    paramAuthenticationCallback.onAuthenticationError(10308, "Too many failed times");
    AppMethodBeat.o(88550);
  }
  
  private static boolean shouldInformTooManyTrial(FingerprintManagerProxy.AuthenticationCallback paramAuthenticationCallback, Context paramContext)
  {
    AppMethodBeat.i(88549);
    if (SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce())
    {
      d.v("Soter.BiometricManagerCompat.Fingerprint", "soter: using system anti brute force strategy", new Object[0]);
      AppMethodBeat.o(88549);
      return false;
    }
    if (SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(paramContext))
    {
      if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(paramContext))
      {
        d.v("Soter.BiometricManagerCompat.Fingerprint", "soter: unfreeze former frozen status", new Object[0]);
        SoterBiometricAntiBruteForceStrategy.unFreeze(paramContext);
      }
      AppMethodBeat.o(88549);
      return false;
    }
    if (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(paramContext))
    {
      d.v("Soter.BiometricManagerCompat.Fingerprint", "soter: failure time available", new Object[0]);
      AppMethodBeat.o(88549);
      return false;
    }
    informTooManyTrial(paramAuthenticationCallback);
    AppMethodBeat.o(88549);
    return true;
  }
  
  private static BiometricManagerCompat.CryptoObject unwrapCryptoObject(FingerprintManagerProxy.CryptoObject paramCryptoObject)
  {
    AppMethodBeat.i(88547);
    if (paramCryptoObject == null)
    {
      AppMethodBeat.o(88547);
      return null;
    }
    if (paramCryptoObject.getCipher() != null)
    {
      paramCryptoObject = new BiometricManagerCompat.CryptoObject(paramCryptoObject.getCipher());
      AppMethodBeat.o(88547);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getSignature() != null)
    {
      paramCryptoObject = new BiometricManagerCompat.CryptoObject(paramCryptoObject.getSignature());
      AppMethodBeat.o(88547);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getMac() != null)
    {
      paramCryptoObject = new BiometricManagerCompat.CryptoObject(paramCryptoObject.getMac());
      AppMethodBeat.o(88547);
      return paramCryptoObject;
    }
    AppMethodBeat.o(88547);
    return null;
  }
  
  private static FingerprintManagerProxy.AuthenticationCallback wrapCallback(final Context paramContext, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback)
  {
    AppMethodBeat.i(88548);
    paramContext = new FingerprintManagerProxy.AuthenticationCallback()
    {
      private boolean mMarkPermanentlyCallbacked = false;
      
      public final void onAuthenticationError(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(88539);
        for (;;)
        {
          d.d("Soter.BiometricManagerCompat.Fingerprint", "soter: basic onAuthenticationError", new Object[0]);
          if (this.mMarkPermanentlyCallbacked)
          {
            AppMethodBeat.o(88539);
            return;
          }
          this.mMarkPermanentlyCallbacked = true;
          if ((paramAnonymousInt == 5) || (paramAnonymousInt == 10))
          {
            d.i("Soter.BiometricManagerCompat.Fingerprint", "soter: user cancelled fingerprint authen", new Object[0]);
            this.val$callback.onAuthenticationCancelled();
            AppMethodBeat.o(88539);
            return;
          }
          if ((paramAnonymousInt != 7) && (paramAnonymousInt != 9)) {
            break;
          }
          d.i("Soter.BiometricManagerCompat.Fingerprint", "soter: system call too many trial.", new Object[0]);
          if ((!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(paramContext)) && (!SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(paramContext)) && (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce())) {
            SoterBiometricAntiBruteForceStrategy.freeze(paramContext);
          }
          this.mMarkPermanentlyCallbacked = false;
          if (paramAnonymousInt == 7)
          {
            paramAnonymousInt = 10308;
            paramAnonymousCharSequence = "Too many failed times";
          }
          else
          {
            paramAnonymousInt = 10309;
            paramAnonymousCharSequence = "Too many failed times";
          }
        }
        this.val$callback.onAuthenticationError(paramAnonymousInt, paramAnonymousCharSequence);
        AppMethodBeat.o(88539);
      }
      
      public final void onAuthenticationFailed()
      {
        AppMethodBeat.i(88542);
        d.d("Soter.BiometricManagerCompat.Fingerprint", "soter: basic onAuthenticationFailed", new Object[0]);
        if (this.mMarkPermanentlyCallbacked)
        {
          AppMethodBeat.o(88542);
          return;
        }
        if (!BiometricManagerCompat.FingerprintManagerImpl.access$000(this, paramContext))
        {
          if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce())
          {
            SoterBiometricAntiBruteForceStrategy.addFailTime(paramContext);
            if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(paramContext))
            {
              d.w("Soter.BiometricManagerCompat.Fingerprint", "soter: too many fail trials", new Object[0]);
              SoterBiometricAntiBruteForceStrategy.freeze(paramContext);
              BiometricManagerCompat.FingerprintManagerImpl.access$200(this);
              AppMethodBeat.o(88542);
              return;
            }
          }
          this.val$callback.onAuthenticationFailed();
        }
        AppMethodBeat.o(88542);
      }
      
      public final void onAuthenticationHelp(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(88540);
        d.d("Soter.BiometricManagerCompat.Fingerprint", "soter: basic onAuthenticationHelp", new Object[0]);
        if (this.mMarkPermanentlyCallbacked)
        {
          AppMethodBeat.o(88540);
          return;
        }
        if (!BiometricManagerCompat.FingerprintManagerImpl.access$000(this, paramContext)) {
          this.val$callback.onAuthenticationHelp(paramAnonymousInt, paramAnonymousCharSequence);
        }
        AppMethodBeat.o(88540);
      }
      
      public final void onAuthenticationSucceeded(FingerprintManagerProxy.AuthenticationResultInternal paramAnonymousAuthenticationResultInternal)
      {
        AppMethodBeat.i(88541);
        d.d("Soter.BiometricManagerCompat.Fingerprint", "soter: basic onAuthenticationSucceeded", new Object[0]);
        if (this.mMarkPermanentlyCallbacked)
        {
          AppMethodBeat.o(88541);
          return;
        }
        if (!BiometricManagerCompat.FingerprintManagerImpl.access$000(this, paramContext))
        {
          if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
            SoterBiometricAntiBruteForceStrategy.unFreeze(paramContext);
          }
          this.mMarkPermanentlyCallbacked = true;
          this.val$callback.onAuthenticationSucceeded(new BiometricManagerCompat.AuthenticationResult(BiometricManagerCompat.FingerprintManagerImpl.access$100(paramAnonymousAuthenticationResultInternal.getCryptoObject())));
        }
        AppMethodBeat.o(88541);
      }
    };
    AppMethodBeat.o(88548);
    return paramContext;
  }
  
  private static FingerprintManagerProxy.CryptoObject wrapCryptoObject(BiometricManagerCompat.CryptoObject paramCryptoObject)
  {
    AppMethodBeat.i(88546);
    if (paramCryptoObject == null)
    {
      AppMethodBeat.o(88546);
      return null;
    }
    if (paramCryptoObject.getCipher() != null)
    {
      paramCryptoObject = new FingerprintManagerProxy.CryptoObject(paramCryptoObject.getCipher());
      AppMethodBeat.o(88546);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getSignature() != null)
    {
      paramCryptoObject = new FingerprintManagerProxy.CryptoObject(paramCryptoObject.getSignature());
      AppMethodBeat.o(88546);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getMac() != null)
    {
      paramCryptoObject = new FingerprintManagerProxy.CryptoObject(paramCryptoObject.getMac());
      AppMethodBeat.o(88546);
      return paramCryptoObject;
    }
    AppMethodBeat.o(88546);
    return null;
  }
  
  public void authenticate(Context paramContext, BiometricManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    AppMethodBeat.i(88545);
    FingerprintManagerProxy.authenticate(paramContext, wrapCryptoObject(paramCryptoObject), paramInt, paramCancellationSignal, wrapCallback(paramContext, paramAuthenticationCallback), paramHandler);
    AppMethodBeat.o(88545);
  }
  
  public String getBiometricName(Context paramContext)
  {
    return "fingerprint";
  }
  
  public boolean hasEnrolledBiometric(Context paramContext)
  {
    AppMethodBeat.i(88543);
    boolean bool = FingerprintManagerProxy.hasEnrolledFingerprints(paramContext);
    AppMethodBeat.o(88543);
    return bool;
  }
  
  public boolean isHardwareDetected(Context paramContext)
  {
    AppMethodBeat.i(88544);
    boolean bool = FingerprintManagerProxy.isHardwareDetected(paramContext);
    AppMethodBeat.o(88544);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.soter.core.biometric.BiometricManagerCompat.FingerprintManagerImpl
 * JD-Core Version:    0.7.0.1
 */