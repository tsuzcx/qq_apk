package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.d;
import java.util.HashMap;
import java.util.Map;

public class BiometricManagerCompat
{
  static final Map<Integer, IBiometricManager> IMPL_PROVIDER;
  private static final String TAG = "Soter.BiometricManagerCompat";
  private Integer mBiometricType;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(88562);
    IMPL_PROVIDER = new HashMap();
    if (a.hlj()) {}
    for (Object localObject = new BiometricManagerCompat.FingerprintManagerImpl();; localObject = new LegacyFingerprintManagerImpl())
    {
      IMPL_PROVIDER.put(Integer.valueOf(1), localObject);
      if ((a.hlj()) && (isNativeSupportFaceid())) {
        IMPL_PROVIDER.put(Integer.valueOf(2), new BiometricManagerCompat.FaceidManagerImpl());
      }
      AppMethodBeat.o(88562);
      return;
    }
  }
  
  private BiometricManagerCompat(Context paramContext, Integer paramInteger)
  {
    this.mContext = paramContext;
    this.mBiometricType = paramInteger;
  }
  
  public static BiometricManagerCompat from(Context paramContext, Integer paramInteger)
  {
    AppMethodBeat.i(88554);
    paramContext = new BiometricManagerCompat(paramContext, paramInteger);
    AppMethodBeat.o(88554);
    return paramContext;
  }
  
  public static boolean isNativeSupportFaceid()
  {
    AppMethodBeat.i(88555);
    try
    {
      Class.forName("com.tencent.soter.core.biometric.SoterFaceManagerFactory");
      AppMethodBeat.o(88555);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(88555);
    }
    return false;
  }
  
  public void authenticate(BiometricManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    AppMethodBeat.i(88561);
    IBiometricManager localIBiometricManager = (IBiometricManager)IMPL_PROVIDER.get(this.mBiometricType);
    if (localIBiometricManager == null)
    {
      d.i("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
      paramAuthenticationCallback.onAuthenticationCancelled();
    }
    localIBiometricManager.authenticate(this.mContext, paramCryptoObject, paramInt, paramCancellationSignal, paramAuthenticationCallback, paramHandler);
    AppMethodBeat.o(88561);
  }
  
  public String getBiometricName()
  {
    AppMethodBeat.i(88557);
    Object localObject = (IBiometricManager)IMPL_PROVIDER.get(this.mBiometricType);
    if (localObject == null)
    {
      d.i("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
      AppMethodBeat.o(88557);
      return null;
    }
    localObject = ((IBiometricManager)localObject).getBiometricName(this.mContext);
    AppMethodBeat.o(88557);
    return localObject;
  }
  
  public boolean hasEnrolledBiometric()
  {
    AppMethodBeat.i(88556);
    IBiometricManager localIBiometricManager = (IBiometricManager)IMPL_PROVIDER.get(this.mBiometricType);
    if (localIBiometricManager == null)
    {
      d.i("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
      AppMethodBeat.o(88556);
      return false;
    }
    boolean bool = localIBiometricManager.hasEnrolledBiometric(this.mContext);
    AppMethodBeat.o(88556);
    return bool;
  }
  
  public boolean isCurrentFailTimeAvailable()
  {
    AppMethodBeat.i(88559);
    boolean bool = SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.mContext);
    AppMethodBeat.o(88559);
    return bool;
  }
  
  public boolean isCurrentTweenTimeAvailable(Context paramContext)
  {
    AppMethodBeat.i(88560);
    boolean bool = SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(this.mContext);
    AppMethodBeat.o(88560);
    return bool;
  }
  
  public boolean isHardwareDetected()
  {
    AppMethodBeat.i(88558);
    IBiometricManager localIBiometricManager = (IBiometricManager)IMPL_PROVIDER.get(this.mBiometricType);
    if (localIBiometricManager == null)
    {
      d.i("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
      AppMethodBeat.o(88558);
      return false;
    }
    boolean bool = localIBiometricManager.isHardwareDetected(this.mContext);
    AppMethodBeat.o(88558);
    return bool;
  }
  
  public static abstract class AuthenticationCallback
  {
    public void onAuthenticationCancelled() {}
    
    public void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationFailed() {}
    
    public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationSucceeded(BiometricManagerCompat.AuthenticationResult paramAuthenticationResult) {}
  }
  
  static abstract interface IBiometricManager
  {
    public abstract void authenticate(Context paramContext, BiometricManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler);
    
    public abstract String getBiometricName(Context paramContext);
    
    public abstract boolean hasEnrolledBiometric(Context paramContext);
    
    public abstract boolean isHardwareDetected(Context paramContext);
  }
  
  static class LegacyFingerprintManagerImpl
    implements BiometricManagerCompat.IBiometricManager
  {
    public void authenticate(Context paramContext, BiometricManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler) {}
    
    public String getBiometricName(Context paramContext)
    {
      return null;
    }
    
    public boolean hasEnrolledBiometric(Context paramContext)
    {
      return false;
    }
    
    public boolean isHardwareDetected(Context paramContext)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.biometric.BiometricManagerCompat
 * JD-Core Version:    0.7.0.1
 */