package com.tencent.soter.core.a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import com.tencent.soter.core.c.d;

final class a$a
  implements a.e
{
  static void a(b.a parama)
  {
    d.w("Soter.FingerprintManagerCompat", "soter: too many fail fingerprint callback. inform it.", new Object[0]);
    parama.onAuthenticationError(10308, "Too many failed times");
  }
  
  public final void a(Context paramContext, a.d paramd, CancellationSignal paramCancellationSignal, a.b paramb)
  {
    if (paramd != null) {
      if (paramd.mCipher != null) {
        paramd = new b.c(paramd.mCipher);
      }
    }
    for (;;)
    {
      paramb = new a.a.1(paramb, paramContext);
      if (b.checkSelfPermission(paramContext, "android.permission.USE_FINGERPRINT") == 0) {
        break;
      }
      d.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: authenticate", new Object[0]);
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
          break label218;
        }
        if (paramd == null) {
          break label230;
        }
        if (paramd.mCipher != null)
        {
          paramContext = new FingerprintManager.CryptoObject(paramd.mCipher);
          localFingerprintManager.authenticate(paramContext, (CancellationSignal)paramCancellationSignal, 0, new b.1(paramb), null);
          return;
        }
      }
      catch (SecurityException paramContext)
      {
        d.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
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
        label218:
        d.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
      }
      else
      {
        label230:
        paramContext = null;
      }
    }
  }
  
  public final boolean hasEnrolledFingerprints(Context paramContext)
  {
    return b.hasEnrolledFingerprints(paramContext);
  }
  
  public final boolean isHardwareDetected(Context paramContext)
  {
    return b.isHardwareDetected(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.soter.core.a.a.a
 * JD-Core Version:    0.7.0.1
 */