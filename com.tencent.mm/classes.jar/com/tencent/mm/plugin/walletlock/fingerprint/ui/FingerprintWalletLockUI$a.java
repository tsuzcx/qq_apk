package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import com.tencent.mm.h.b.a.aa;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.c.b;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class FingerprintWalletLockUI$a
  implements b
{
  private WeakReference<FingerprintWalletLockUI> kmj = null;
  
  public FingerprintWalletLockUI$a(FingerprintWalletLockUI paramFingerprintWalletLockUI1, FingerprintWalletLockUI paramFingerprintWalletLockUI2)
  {
    this.kmj = new WeakReference(paramFingerprintWalletLockUI2);
  }
  
  private FingerprintWalletLockUI bYa()
  {
    if (this.kmj != null) {
      return (FingerprintWalletLockUI)this.kmj.get();
    }
    return null;
  }
  
  public final void J(int paramInt, String paramString)
  {
    y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onResult result: %d, errMsg: %s, isCancelled: %b", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(FingerprintWalletLockUI.c(this.qPy)) });
    if ((FingerprintWalletLockUI.d(this.qPy) != null) && (FingerprintWalletLockUI.d(this.qPy).equals("action.switch_on_pattern")))
    {
      paramString = new aa();
      paramString.ckr = 3L;
      paramString.cks = 1L;
      paramString.QX();
    }
    if ((FingerprintWalletLockUI.d(this.qPy) != null) && (FingerprintWalletLockUI.d(this.qPy).equals("action.verify_pattern")))
    {
      if (FingerprintWalletLockUI.e(this.qPy) != 1) {
        break label157;
      }
      paramString = new aa();
      paramString.ckr = 7L;
      paramString.cks = 1L;
    }
    label156:
    label157:
    do
    {
      paramString.QX();
      break label156;
      if (FingerprintWalletLockUI.c(this.qPy)) {}
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (FingerprintWalletLockUI.e(this.qPy) != 2) {
                    break;
                  }
                  paramString = new aa();
                  paramString.ckr = 9L;
                  paramString.cks = 1L;
                  paramString.QX();
                  break;
                  switch (paramInt)
                  {
                  case 6: 
                  case 7: 
                  default: 
                    return;
                  case 0: 
                    y.i("MicroMsg.FingerprintWalletLockUI", "identify success");
                    if (bYa() != null) {
                      FingerprintWalletLockUI.f(bYa());
                    }
                    if ((FingerprintWalletLockUI.d(this.qPy) != null) && (FingerprintWalletLockUI.d(this.qPy).equals("action.switch_on_pattern")))
                    {
                      paramString = new aa();
                      paramString.ckr = 3L;
                      paramString.cks = 2L;
                      paramString.QX();
                    }
                    break;
                  }
                } while ((FingerprintWalletLockUI.d(this.qPy) == null) || (!FingerprintWalletLockUI.d(this.qPy).equals("action.verify_pattern")));
                if (FingerprintWalletLockUI.e(this.qPy) == 1)
                {
                  paramString = new aa();
                  paramString.ckr = 7L;
                  paramString.cks = 2L;
                  paramString.QX();
                  return;
                }
              } while (FingerprintWalletLockUI.e(this.qPy) != 2);
              paramString = new aa();
              paramString.ckr = 9L;
              paramString.cks = 2L;
              paramString.QX();
              return;
              y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
              return;
              y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
            } while (bYa() == null);
            FingerprintWalletLockUI.a(bYa(), paramInt, this.qPy.getString(a.g.wallet_lock_fingerprint_verify_not_match_error));
            return;
            y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
          } while (bYa() == null);
          FingerprintWalletLockUI.a(bYa(), paramInt, this.qPy.getString(a.g.wallet_lock_fingerprint_verify_not_match_error));
          return;
        } while (bYa() == null);
        FingerprintWalletLockUI.b(bYa(), paramInt, this.qPy.getString(a.g.wallet_lock_fingerprint_system_error));
        return;
      } while (bYa() == null);
      FingerprintWalletLockUI.b(bYa(), paramInt, this.qPy.getString(a.g.wallet_lock_no_fingerprint_when_offline_verify));
      return;
      y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", new Object[] { Integer.valueOf(paramInt) });
    } while (bYa() == null);
    FingerprintWalletLockUI.b(bYa(), paramInt, this.qPy.getString(a.g.wallet_lock_fingerprint_too_many_trial_error));
  }
  
  public final void bYb()
  {
    FingerprintWalletLockUI.a(this.qPy);
    FingerprintWalletLockUI.b(this.qPy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.a
 * JD-Core Version:    0.7.0.1
 */