package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.d;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;

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
    if (a.fmR()) {}
    for (Object localObject = new FingerprintManagerImpl();; localObject = new LegacyFingerprintManagerImpl())
    {
      IMPL_PROVIDER.put(Integer.valueOf(1), localObject);
      if ((a.fmR()) && (isNativeSupportFaceid())) {
        IMPL_PROVIDER.put(Integer.valueOf(2), new FaceidManagerImpl());
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
  
  public void authenticate(CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
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
  
  public static final class AuthenticationResult
  {
    private BiometricManagerCompat.CryptoObject mCryptoObject;
    
    public AuthenticationResult(BiometricManagerCompat.CryptoObject paramCryptoObject)
    {
      this.mCryptoObject = paramCryptoObject;
    }
    
    public final BiometricManagerCompat.CryptoObject getCryptoObject()
    {
      return this.mCryptoObject;
    }
  }
  
  public static class CryptoObject
  {
    private final Cipher mCipher;
    private final Mac mMac;
    private final Signature mSignature;
    
    public CryptoObject(Signature paramSignature)
    {
      this.mSignature = paramSignature;
      this.mCipher = null;
      this.mMac = null;
    }
    
    public CryptoObject(Cipher paramCipher)
    {
      this.mCipher = paramCipher;
      this.mSignature = null;
      this.mMac = null;
    }
    
    public CryptoObject(Mac paramMac)
    {
      this.mMac = paramMac;
      this.mCipher = null;
      this.mSignature = null;
    }
    
    public Cipher getCipher()
    {
      return this.mCipher;
    }
    
    public Mac getMac()
    {
      return this.mMac;
    }
    
    public Signature getSignature()
    {
      return this.mSignature;
    }
  }
  
  static class FaceidManagerImpl
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
  
  static class FingerprintManagerImpl
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