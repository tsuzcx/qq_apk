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
  static final Map<Integer, BiometricManagerCompat.IBiometricManager> IMPL_PROVIDER;
  private static final String TAG = "Soter.BiometricManagerCompat";
  private Integer mBiometricType;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(72934);
    IMPL_PROVIDER = new HashMap();
    if (a.dVc()) {}
    for (Object localObject = new BiometricManagerCompat.FingerprintManagerImpl();; localObject = new BiometricManagerCompat.LegacyFingerprintManagerImpl())
    {
      IMPL_PROVIDER.put(Integer.valueOf(1), localObject);
      if ((a.dVc()) && (isNativeSupportFaceid())) {
        IMPL_PROVIDER.put(Integer.valueOf(2), new BiometricManagerCompat.FaceidManagerImpl());
      }
      AppMethodBeat.o(72934);
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
    AppMethodBeat.i(72926);
    paramContext = new BiometricManagerCompat(paramContext, paramInteger);
    AppMethodBeat.o(72926);
    return paramContext;
  }
  
  public static boolean isNativeSupportFaceid()
  {
    AppMethodBeat.i(72927);
    try
    {
      Class.forName("com.tencent.soter.core.biometric.SoterFaceManagerFactory");
      AppMethodBeat.o(72927);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(72927);
    }
    return false;
  }
  
  public void authenticate(BiometricManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, BiometricManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    AppMethodBeat.i(72933);
    BiometricManagerCompat.IBiometricManager localIBiometricManager = (BiometricManagerCompat.IBiometricManager)IMPL_PROVIDER.get(this.mBiometricType);
    if (localIBiometricManager == null)
    {
      d.i("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
      paramAuthenticationCallback.onAuthenticationCancelled();
    }
    localIBiometricManager.authenticate(this.mContext, paramCryptoObject, paramInt, paramCancellationSignal, paramAuthenticationCallback, paramHandler);
    AppMethodBeat.o(72933);
  }
  
  public String getBiometricName()
  {
    AppMethodBeat.i(72929);
    Object localObject = (BiometricManagerCompat.IBiometricManager)IMPL_PROVIDER.get(this.mBiometricType);
    if (localObject == null)
    {
      d.i("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
      AppMethodBeat.o(72929);
      return null;
    }
    localObject = ((BiometricManagerCompat.IBiometricManager)localObject).getBiometricName(this.mContext);
    AppMethodBeat.o(72929);
    return localObject;
  }
  
  public boolean hasEnrolledBiometric()
  {
    AppMethodBeat.i(72928);
    BiometricManagerCompat.IBiometricManager localIBiometricManager = (BiometricManagerCompat.IBiometricManager)IMPL_PROVIDER.get(this.mBiometricType);
    if (localIBiometricManager == null)
    {
      d.i("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
      AppMethodBeat.o(72928);
      return false;
    }
    boolean bool = localIBiometricManager.hasEnrolledBiometric(this.mContext);
    AppMethodBeat.o(72928);
    return bool;
  }
  
  public boolean isCurrentFailTimeAvailable()
  {
    AppMethodBeat.i(72931);
    boolean bool = SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.mContext);
    AppMethodBeat.o(72931);
    return bool;
  }
  
  public boolean isCurrentTweenTimeAvailable(Context paramContext)
  {
    AppMethodBeat.i(72932);
    boolean bool = SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(this.mContext);
    AppMethodBeat.o(72932);
    return bool;
  }
  
  public boolean isHardwareDetected()
  {
    AppMethodBeat.i(72930);
    BiometricManagerCompat.IBiometricManager localIBiometricManager = (BiometricManagerCompat.IBiometricManager)IMPL_PROVIDER.get(this.mBiometricType);
    if (localIBiometricManager == null)
    {
      d.i("Soter.BiometricManagerCompat", "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
      AppMethodBeat.o(72930);
      return false;
    }
    boolean bool = localIBiometricManager.isHardwareDetected(this.mContext);
    AppMethodBeat.o(72930);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.soter.core.biometric.BiometricManagerCompat
 * JD-Core Version:    0.7.0.1
 */