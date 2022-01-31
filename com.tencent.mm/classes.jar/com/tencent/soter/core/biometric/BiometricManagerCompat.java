package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.d;
import java.util.HashMap;
import java.util.Map;

public class BiometricManagerCompat
{
  static final Map<Integer, BiometricManagerCompat.IBiometricManager> IMPL_PROVIDER = new HashMap();
  private static final String TAG = "Soter.BiometricManagerCompat";
  private Integer mBiometricType;
  private Context mContext;
  
  static
  {
    if (a.cPh()) {}
    for (Object localObject = new BiometricManagerCompat.FingerprintManagerImpl();; localObject = new BiometricManagerCompat.LegacyFingerprintManagerImpl())
    {
      IMPL_PROVIDER.put(Integer.valueOf(1), localObject);
      if ((a.cPh()) && (isNativeSupportFaceid())) {
        IMPL_PROVIDER.put(Integer.valueOf(2), new BiometricManagerCompat.FaceidManagerImpl());
      }
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
    return new BiometricManagerCompat(paramContext, paramInteger);
  }
  
  public static boolean isNativeSupportFaceid()
  {
    try
    {
      Class.forName("com.tencent.soter.core.biometric.SoterFaceManagerFactory");
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public void authenticate(BiometricManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    BiometricManagerCompat.IBiometricManager localIBiometricManager = (BiometricManagerCompat.IBiometricManager)IMPL_PROVIDER.get(this.mBiometricType);
    if (localIBiometricManager == null)
    {
      d.i("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
      paramAuthenticationCallback.onAuthenticationCancelled();
    }
    localIBiometricManager.authenticate(this.mContext, paramCryptoObject, paramInt, paramCancellationSignal, paramAuthenticationCallback, paramHandler);
  }
  
  public String getBiometricName()
  {
    BiometricManagerCompat.IBiometricManager localIBiometricManager = (BiometricManagerCompat.IBiometricManager)IMPL_PROVIDER.get(this.mBiometricType);
    if (localIBiometricManager == null)
    {
      d.i("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
      return null;
    }
    return localIBiometricManager.getBiometricName(this.mContext);
  }
  
  public boolean hasEnrolledBiometric()
  {
    BiometricManagerCompat.IBiometricManager localIBiometricManager = (BiometricManagerCompat.IBiometricManager)IMPL_PROVIDER.get(this.mBiometricType);
    if (localIBiometricManager == null)
    {
      d.i("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
      return false;
    }
    return localIBiometricManager.hasEnrolledBiometric(this.mContext);
  }
  
  public boolean isCurrentFailTimeAvailable()
  {
    return SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.mContext);
  }
  
  public boolean isCurrentTweenTimeAvailable(Context paramContext)
  {
    return SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(this.mContext);
  }
  
  public boolean isHardwareDetected()
  {
    BiometricManagerCompat.IBiometricManager localIBiometricManager = (BiometricManagerCompat.IBiometricManager)IMPL_PROVIDER.get(this.mBiometricType);
    if (localIBiometricManager == null)
    {
      d.i("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
      return false;
    }
    return localIBiometricManager.isHardwareDetected(this.mContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.soter.core.biometric.BiometricManagerCompat
 * JD-Core Version:    0.7.0.1
 */