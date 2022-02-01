package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

class BiometricManagerCompat$FaceidManagerImpl
  implements BiometricManagerCompat.IBiometricManager
{
  private static final String TAG = "Soter.BiometricManagerCompat.Faceid";
  
  private static void informTooManyTrial(FaceidManagerProxy.AuthenticationCallback paramAuthenticationCallback)
  {
    AppMethodBeat.i(88535);
    d.w("Soter.BiometricManagerCompat.Faceid", "soter: too many fail callback. inform it.", new Object[0]);
    paramAuthenticationCallback.onAuthenticationError(10308, "Too many failed times");
    AppMethodBeat.o(88535);
  }
  
  private static boolean shouldInformTooManyTrial(FaceidManagerProxy.AuthenticationCallback paramAuthenticationCallback, Context paramContext)
  {
    AppMethodBeat.i(88534);
    if (SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce())
    {
      d.v("Soter.BiometricManagerCompat.Faceid", "soter: using system anti brute force strategy", new Object[0]);
      AppMethodBeat.o(88534);
      return false;
    }
    if (SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(paramContext))
    {
      if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(paramContext))
      {
        d.v("Soter.BiometricManagerCompat.Faceid", "soter: unfreeze former frozen status", new Object[0]);
        SoterBiometricAntiBruteForceStrategy.unFreeze(paramContext);
      }
      AppMethodBeat.o(88534);
      return false;
    }
    if (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(paramContext))
    {
      d.v("Soter.BiometricManagerCompat.Faceid", "soter: failure time available", new Object[0]);
      AppMethodBeat.o(88534);
      return false;
    }
    informTooManyTrial(paramAuthenticationCallback);
    AppMethodBeat.o(88534);
    return true;
  }
  
  private static BiometricManagerCompat.CryptoObject unwrapCryptoObject(FaceidManagerProxy.CryptoObject paramCryptoObject)
  {
    AppMethodBeat.i(88532);
    if (paramCryptoObject == null)
    {
      AppMethodBeat.o(88532);
      return null;
    }
    if (paramCryptoObject.getCipher() != null)
    {
      paramCryptoObject = new BiometricManagerCompat.CryptoObject(paramCryptoObject.getCipher());
      AppMethodBeat.o(88532);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getSignature() != null)
    {
      paramCryptoObject = new BiometricManagerCompat.CryptoObject(paramCryptoObject.getSignature());
      AppMethodBeat.o(88532);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getMac() != null)
    {
      paramCryptoObject = new BiometricManagerCompat.CryptoObject(paramCryptoObject.getMac());
      AppMethodBeat.o(88532);
      return paramCryptoObject;
    }
    AppMethodBeat.o(88532);
    return null;
  }
  
  private static FaceidManagerProxy.AuthenticationCallback wrapCallback(final Context paramContext, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback)
  {
    AppMethodBeat.i(88533);
    paramContext = new FaceidManagerProxy.AuthenticationCallback()
    {
      private boolean mMarkPermanentlyCallbacked = false;
      
      public final void onAuthenticationError(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(88523);
        d.d("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationError code[%d], msg[%s] entered.", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        if (this.mMarkPermanentlyCallbacked)
        {
          d.d("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationError code[%d], msg[%s] returned cause permanently callback.", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
          AppMethodBeat.o(88523);
          return;
        }
        this.mMarkPermanentlyCallbacked = true;
        if (paramAnonymousInt == 5)
        {
          d.i("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned cause FACE_ERROR_CANCELED got.", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
          this.val$callback.onAuthenticationCancelled();
          AppMethodBeat.o(88523);
          return;
        }
        if (paramAnonymousInt == 7)
        {
          d.i("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned cause FACE_ERROR_LOCKOUT got.", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
          if ((!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(paramContext)) && (!SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(paramContext)) && (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce())) {
            SoterBiometricAntiBruteForceStrategy.freeze(paramContext);
          }
          this.val$callback.onAuthenticationError(10308, "Too many failed times");
          AppMethodBeat.o(88523);
          return;
        }
        d.d("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned.", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        this.val$callback.onAuthenticationError(paramAnonymousInt, paramAnonymousCharSequence);
        AppMethodBeat.o(88523);
      }
      
      public final void onAuthenticationFailed()
      {
        AppMethodBeat.i(88526);
        d.d("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationFailed", new Object[0]);
        if (this.mMarkPermanentlyCallbacked)
        {
          AppMethodBeat.o(88526);
          return;
        }
        this.mMarkPermanentlyCallbacked = true;
        if ((!BiometricManagerCompat.FaceidManagerImpl.access$300(this, paramContext)) && (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()))
        {
          SoterBiometricAntiBruteForceStrategy.addFailTime(paramContext);
          if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(paramContext))
          {
            d.w("Soter.BiometricManagerCompat.Faceid", "soter: too many fail trials", new Object[0]);
            SoterBiometricAntiBruteForceStrategy.freeze(paramContext);
            BiometricManagerCompat.FaceidManagerImpl.access$500(this);
            AppMethodBeat.o(88526);
            return;
          }
        }
        this.val$callback.onAuthenticationFailed();
        AppMethodBeat.o(88526);
      }
      
      public final void onAuthenticationHelp(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(88524);
        d.d("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationHelp helpMsgId[%d], helpString[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        System.currentTimeMillis();
        if (this.mMarkPermanentlyCallbacked)
        {
          AppMethodBeat.o(88524);
          return;
        }
        if (!BiometricManagerCompat.FaceidManagerImpl.access$300(this, paramContext)) {
          this.val$callback.onAuthenticationHelp(paramAnonymousInt, paramAnonymousCharSequence);
        }
        AppMethodBeat.o(88524);
      }
      
      public final void onAuthenticationSucceeded(FaceidManagerProxy.AuthenticationResult paramAnonymousAuthenticationResult)
      {
        AppMethodBeat.i(88525);
        d.d("Soter.BiometricManagerCompat.Faceid", "soter: basic onAuthenticationSucceeded", new Object[0]);
        if (this.mMarkPermanentlyCallbacked)
        {
          AppMethodBeat.o(88525);
          return;
        }
        this.mMarkPermanentlyCallbacked = true;
        if (!BiometricManagerCompat.FaceidManagerImpl.access$300(this, paramContext))
        {
          if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
            SoterBiometricAntiBruteForceStrategy.unFreeze(paramContext);
          }
          this.val$callback.onAuthenticationSucceeded(new BiometricManagerCompat.AuthenticationResult(BiometricManagerCompat.FaceidManagerImpl.access$400(paramAnonymousAuthenticationResult.getCryptoObject())));
        }
        AppMethodBeat.o(88525);
      }
    };
    AppMethodBeat.o(88533);
    return paramContext;
  }
  
  private static FaceidManagerProxy.CryptoObject wrapCryptoObject(BiometricManagerCompat.CryptoObject paramCryptoObject)
  {
    AppMethodBeat.i(88531);
    if (paramCryptoObject == null)
    {
      AppMethodBeat.o(88531);
      return null;
    }
    if (paramCryptoObject.getCipher() != null)
    {
      paramCryptoObject = new FaceidManagerProxy.CryptoObject(paramCryptoObject.getCipher());
      AppMethodBeat.o(88531);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getSignature() != null)
    {
      paramCryptoObject = new FaceidManagerProxy.CryptoObject(paramCryptoObject.getSignature());
      AppMethodBeat.o(88531);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getMac() != null)
    {
      paramCryptoObject = new FaceidManagerProxy.CryptoObject(paramCryptoObject.getMac());
      AppMethodBeat.o(88531);
      return paramCryptoObject;
    }
    AppMethodBeat.o(88531);
    return null;
  }
  
  public void authenticate(Context paramContext, BiometricManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    AppMethodBeat.i(88530);
    FaceidManagerProxy.authenticate(paramContext, wrapCryptoObject(paramCryptoObject), paramInt, paramCancellationSignal, wrapCallback(paramContext, paramAuthenticationCallback), paramHandler);
    AppMethodBeat.o(88530);
  }
  
  public String getBiometricName(Context paramContext)
  {
    AppMethodBeat.i(88529);
    paramContext = FaceidManagerProxy.getBiometricName(paramContext);
    AppMethodBeat.o(88529);
    return paramContext;
  }
  
  public boolean hasEnrolledBiometric(Context paramContext)
  {
    AppMethodBeat.i(88527);
    boolean bool = FaceidManagerProxy.hasEnrolledFaceids(paramContext);
    AppMethodBeat.o(88527);
    return bool;
  }
  
  public boolean isHardwareDetected(Context paramContext)
  {
    AppMethodBeat.i(88528);
    boolean bool = FaceidManagerProxy.isHardwareDetected(paramContext);
    AppMethodBeat.o(88528);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.biometric.BiometricManagerCompat.FaceidManagerImpl
 * JD-Core Version:    0.7.0.1
 */