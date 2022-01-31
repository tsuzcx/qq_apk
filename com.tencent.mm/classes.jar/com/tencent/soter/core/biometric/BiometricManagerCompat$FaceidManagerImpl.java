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
    AppMethodBeat.i(72907);
    d.w("Soter.BiometricManagerCompat.Faceid", "soter: too many fail callback. inform it.", new Object[0]);
    paramAuthenticationCallback.onAuthenticationError(10308, "Too many failed times");
    AppMethodBeat.o(72907);
  }
  
  private static boolean shouldInformTooManyTrial(FaceidManagerProxy.AuthenticationCallback paramAuthenticationCallback, Context paramContext)
  {
    AppMethodBeat.i(72906);
    if (SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce())
    {
      d.v("Soter.BiometricManagerCompat.Faceid", "soter: using system anti brute force strategy", new Object[0]);
      AppMethodBeat.o(72906);
      return false;
    }
    if (SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(paramContext))
    {
      if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(paramContext))
      {
        d.v("Soter.BiometricManagerCompat.Faceid", "soter: unfreeze former frozen status", new Object[0]);
        SoterBiometricAntiBruteForceStrategy.unFreeze(paramContext);
      }
      AppMethodBeat.o(72906);
      return false;
    }
    if (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(paramContext))
    {
      d.v("Soter.BiometricManagerCompat.Faceid", "soter: failure time available", new Object[0]);
      AppMethodBeat.o(72906);
      return false;
    }
    informTooManyTrial(paramAuthenticationCallback);
    AppMethodBeat.o(72906);
    return true;
  }
  
  private static BiometricManagerCompat.CryptoObject unwrapCryptoObject(FaceidManagerProxy.CryptoObject paramCryptoObject)
  {
    AppMethodBeat.i(72904);
    if (paramCryptoObject == null)
    {
      AppMethodBeat.o(72904);
      return null;
    }
    if (paramCryptoObject.getCipher() != null)
    {
      paramCryptoObject = new BiometricManagerCompat.CryptoObject(paramCryptoObject.getCipher());
      AppMethodBeat.o(72904);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getSignature() != null)
    {
      paramCryptoObject = new BiometricManagerCompat.CryptoObject(paramCryptoObject.getSignature());
      AppMethodBeat.o(72904);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getMac() != null)
    {
      paramCryptoObject = new BiometricManagerCompat.CryptoObject(paramCryptoObject.getMac());
      AppMethodBeat.o(72904);
      return paramCryptoObject;
    }
    AppMethodBeat.o(72904);
    return null;
  }
  
  private static FaceidManagerProxy.AuthenticationCallback wrapCallback(Context paramContext, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback)
  {
    AppMethodBeat.i(72905);
    paramContext = new BiometricManagerCompat.FaceidManagerImpl.1(paramAuthenticationCallback, paramContext);
    AppMethodBeat.o(72905);
    return paramContext;
  }
  
  private static FaceidManagerProxy.CryptoObject wrapCryptoObject(BiometricManagerCompat.CryptoObject paramCryptoObject)
  {
    AppMethodBeat.i(72903);
    if (paramCryptoObject == null)
    {
      AppMethodBeat.o(72903);
      return null;
    }
    if (paramCryptoObject.getCipher() != null)
    {
      paramCryptoObject = new FaceidManagerProxy.CryptoObject(paramCryptoObject.getCipher());
      AppMethodBeat.o(72903);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getSignature() != null)
    {
      paramCryptoObject = new FaceidManagerProxy.CryptoObject(paramCryptoObject.getSignature());
      AppMethodBeat.o(72903);
      return paramCryptoObject;
    }
    if (paramCryptoObject.getMac() != null)
    {
      paramCryptoObject = new FaceidManagerProxy.CryptoObject(paramCryptoObject.getMac());
      AppMethodBeat.o(72903);
      return paramCryptoObject;
    }
    AppMethodBeat.o(72903);
    return null;
  }
  
  public void authenticate(Context paramContext, BiometricManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    AppMethodBeat.i(72902);
    FaceidManagerProxy.authenticate(paramContext, wrapCryptoObject(paramCryptoObject), paramInt, paramCancellationSignal, wrapCallback(paramContext, paramAuthenticationCallback), paramHandler);
    AppMethodBeat.o(72902);
  }
  
  public String getBiometricName(Context paramContext)
  {
    AppMethodBeat.i(72901);
    paramContext = FaceidManagerProxy.getBiometricName(paramContext);
    AppMethodBeat.o(72901);
    return paramContext;
  }
  
  public boolean hasEnrolledBiometric(Context paramContext)
  {
    AppMethodBeat.i(72899);
    boolean bool = FaceidManagerProxy.hasEnrolledFaceids(paramContext);
    AppMethodBeat.o(72899);
    return bool;
  }
  
  public boolean isHardwareDetected(Context paramContext)
  {
    AppMethodBeat.i(72900);
    boolean bool = FaceidManagerProxy.isHardwareDetected(paramContext);
    AppMethodBeat.o(72900);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.soter.core.biometric.BiometricManagerCompat.FaceidManagerImpl
 * JD-Core Version:    0.7.0.1
 */