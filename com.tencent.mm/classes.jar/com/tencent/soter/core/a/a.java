package com.tencent.soter.core.a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
public final class a
{
  public static final e JVU;
  public Context mContext;
  
  static
  {
    AppMethodBeat.i(88614);
    if (com.tencent.soter.core.a.fDh())
    {
      JVU = new a();
      AppMethodBeat.o(88614);
      return;
    }
    JVU = new f();
    AppMethodBeat.o(88614);
  }
  
  private a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static a kR(Context paramContext)
  {
    AppMethodBeat.i(88611);
    paramContext = new a(paramContext);
    AppMethodBeat.o(88611);
    return paramContext;
  }
  
  public final void a(d paramd, CancellationSignal paramCancellationSignal, b paramb)
  {
    AppMethodBeat.i(88613);
    JVU.a(this.mContext, paramd, paramCancellationSignal, paramb);
    AppMethodBeat.o(88613);
  }
  
  public final boolean hasEnrolledFingerprints()
  {
    AppMethodBeat.i(88612);
    boolean bool = JVU.hasEnrolledFingerprints(this.mContext);
    AppMethodBeat.o(88612);
    return bool;
  }
  
  static final class a
    implements a.e
  {
    static void a(b.a parama)
    {
      AppMethodBeat.i(88609);
      d.w("Soter.FingerprintManagerCompat", "soter: too many fail fingerprint callback. inform it.", new Object[0]);
      parama.onAuthenticationError(10308, "Too many failed times");
      AppMethodBeat.o(88609);
    }
    
    public final void a(final Context paramContext, a.d paramd, CancellationSignal paramCancellationSignal, a.b paramb)
    {
      AppMethodBeat.i(88608);
      if (paramd != null) {
        if (paramd.mCipher != null) {
          paramd = new b.c(paramd.mCipher);
        }
      }
      for (;;)
      {
        paramb = new b.a()
        {
          private boolean mMarkPermanentlyCallbacked = false;
          
          public final void a(b.b paramAnonymousb)
          {
            AppMethodBeat.i(88604);
            d.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationSucceeded", new Object[0]);
            if (this.mMarkPermanentlyCallbacked)
            {
              AppMethodBeat.o(88604);
              return;
            }
            a.b localb;
            if (!a.a.a(this, paramContext))
            {
              if (!c.isSystemHasAntiBruteForce()) {
                c.unFreeze(paramContext);
              }
              this.mMarkPermanentlyCallbacked = true;
              localb = this.JVV;
              paramAnonymousb = paramAnonymousb.JVY;
              if (paramAnonymousb == null) {
                break label154;
              }
              if (paramAnonymousb.mCipher == null) {
                break label110;
              }
              paramAnonymousb = new a.d(paramAnonymousb.mCipher);
            }
            label154:
            for (;;)
            {
              new a.c(paramAnonymousb);
              localb.dTI();
              AppMethodBeat.o(88604);
              return;
              label110:
              if (paramAnonymousb.mSignature != null) {
                paramAnonymousb = new a.d(paramAnonymousb.mSignature);
              } else if (paramAnonymousb.mMac != null) {
                paramAnonymousb = new a.d(paramAnonymousb.mMac);
              } else {
                paramAnonymousb = null;
              }
            }
          }
          
          public final void onAuthenticationError(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(88602);
            for (;;)
            {
              d.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationError", new Object[0]);
              if (this.mMarkPermanentlyCallbacked)
              {
                AppMethodBeat.o(88602);
                return;
              }
              this.mMarkPermanentlyCallbacked = true;
              if (paramAnonymousInt == 5)
              {
                d.i("Soter.FingerprintManagerCompat", "soter: user cancelled fingerprint authen", new Object[0]);
                this.JVV.onAuthenticationCancelled();
                AppMethodBeat.o(88602);
                return;
              }
              if (paramAnonymousInt != 7) {
                break;
              }
              d.i("Soter.FingerprintManagerCompat", "soter: system call too many trial.", new Object[0]);
              if ((!c.isCurrentFailTimeAvailable(paramContext)) && (!c.isCurrentTweenTimeAvailable(paramContext)) && (!c.isSystemHasAntiBruteForce())) {
                c.freeze(paramContext);
              }
              this.mMarkPermanentlyCallbacked = false;
              paramAnonymousInt = 10308;
              paramAnonymousCharSequence = "Too many failed times";
            }
            this.JVV.onAuthenticationError(paramAnonymousInt, paramAnonymousCharSequence);
            AppMethodBeat.o(88602);
          }
          
          public final void onAuthenticationFailed()
          {
            AppMethodBeat.i(88605);
            d.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationFailed", new Object[0]);
            if (this.mMarkPermanentlyCallbacked)
            {
              AppMethodBeat.o(88605);
              return;
            }
            if (!a.a.a(this, paramContext))
            {
              if (!c.isSystemHasAntiBruteForce())
              {
                Context localContext = paramContext;
                c.setCurrentFailTime(localContext, Integer.valueOf(c.getCurrentFailTime(localContext)).intValue() + 1);
                if (!c.isCurrentFailTimeAvailable(paramContext))
                {
                  d.w("Soter.FingerprintManagerCompat", "soter: too many fail trials", new Object[0]);
                  c.freeze(paramContext);
                  a.a.a(this);
                  AppMethodBeat.o(88605);
                  return;
                }
              }
              this.JVV.onAuthenticationFailed();
            }
            AppMethodBeat.o(88605);
          }
          
          public final void onAuthenticationHelp(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(88603);
            d.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationHelp", new Object[0]);
            if (this.mMarkPermanentlyCallbacked)
            {
              AppMethodBeat.o(88603);
              return;
            }
            if (!a.a.a(this, paramContext)) {
              this.JVV.onAuthenticationHelp(paramAnonymousInt, paramAnonymousCharSequence);
            }
            AppMethodBeat.o(88603);
          }
        };
        if (b.checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") == 0) {
          break;
        }
        d.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: authenticate", new Object[0]);
        AppMethodBeat.o(88608);
        return;
        if (paramd.mSignature != null) {
          paramd = new b.c(paramd.mSignature);
        } else if (paramd.mMac != null) {
          paramd = new b.c(paramd.mMac);
        } else {
          paramd = null;
        }
      }
      for (;;)
      {
        try
        {
          FingerprintManager localFingerprintManager = b.getFingerprintManager(paramContext);
          if (localFingerprintManager == null) {
            break label238;
          }
          if (paramd == null) {
            break label255;
          }
          if (paramd.mCipher != null)
          {
            paramContext = new FingerprintManager.CryptoObject(paramd.mCipher);
            localFingerprintManager.authenticate(paramContext, (CancellationSignal)paramCancellationSignal, 0, new b.1(paramb), null);
            AppMethodBeat.o(88608);
            return;
          }
        }
        catch (SecurityException paramContext)
        {
          d.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
          AppMethodBeat.o(88608);
          return;
        }
        if (paramd.mSignature != null)
        {
          paramContext = new FingerprintManager.CryptoObject(paramd.mSignature);
        }
        else if (paramd.mMac != null)
        {
          paramContext = new FingerprintManager.CryptoObject(paramd.mMac);
          continue;
          label238:
          d.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
          AppMethodBeat.o(88608);
        }
        else
        {
          label255:
          paramContext = null;
        }
      }
    }
    
    public final boolean hasEnrolledFingerprints(Context paramContext)
    {
      AppMethodBeat.i(88606);
      boolean bool = b.hasEnrolledFingerprints(paramContext);
      AppMethodBeat.o(88606);
      return bool;
    }
    
    public final boolean isHardwareDetected(Context paramContext)
    {
      AppMethodBeat.i(88607);
      boolean bool = b.isHardwareDetected(paramContext);
      AppMethodBeat.o(88607);
      return bool;
    }
  }
  
  public static abstract class b
  {
    public void dTI() {}
    
    public void onAuthenticationCancelled() {}
    
    public void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationFailed() {}
    
    public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {}
  }
  
  public static final class c
  {
    private a.d JVW;
    
    public c(a.d paramd)
    {
      this.JVW = paramd;
    }
  }
  
  public static final class d
  {
    final Cipher mCipher;
    final Mac mMac;
    final Signature mSignature;
    
    public d(Signature paramSignature)
    {
      this.mSignature = paramSignature;
      this.mCipher = null;
      this.mMac = null;
    }
    
    public d(Cipher paramCipher)
    {
      this.mCipher = paramCipher;
      this.mSignature = null;
      this.mMac = null;
    }
    
    public d(Mac paramMac)
    {
      this.mMac = paramMac;
      this.mCipher = null;
      this.mSignature = null;
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(Context paramContext, a.d paramd, CancellationSignal paramCancellationSignal, a.b paramb);
    
    public abstract boolean hasEnrolledFingerprints(Context paramContext);
    
    public abstract boolean isHardwareDetected(Context paramContext);
  }
  
  static final class f
    implements a.e
  {
    public final void a(Context paramContext, a.d paramd, CancellationSignal paramCancellationSignal, a.b paramb) {}
    
    public final boolean hasEnrolledFingerprints(Context paramContext)
    {
      return false;
    }
    
    public final boolean isHardwareDetected(Context paramContext)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.a.a
 * JD-Core Version:    0.7.0.1
 */