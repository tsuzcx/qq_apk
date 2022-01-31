package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.plugin.walletlock.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public final class FingerprintWalletLockUI$a
  implements b
{
  private WeakReference<FingerprintWalletLockUI> mGZ;
  
  public FingerprintWalletLockUI$a(FingerprintWalletLockUI paramFingerprintWalletLockUI1, FingerprintWalletLockUI paramFingerprintWalletLockUI2)
  {
    AppMethodBeat.i(51513);
    this.mGZ = null;
    this.mGZ = new WeakReference(paramFingerprintWalletLockUI2);
    AppMethodBeat.o(51513);
  }
  
  private FingerprintWalletLockUI cXI()
  {
    AppMethodBeat.i(51514);
    if (this.mGZ != null)
    {
      FingerprintWalletLockUI localFingerprintWalletLockUI = (FingerprintWalletLockUI)this.mGZ.get();
      AppMethodBeat.o(51514);
      return localFingerprintWalletLockUI;
    }
    AppMethodBeat.o(51514);
    return null;
  }
  
  public final void U(int paramInt, String paramString)
  {
    AppMethodBeat.i(51516);
    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo onResult result: %d, errMsg: %s, isCancelled: %b", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(FingerprintWalletLockUI.c(this.uEG)) });
    if ((FingerprintWalletLockUI.d(this.uEG) != null) && (FingerprintWalletLockUI.d(this.uEG).equals("action.switch_on_pattern")))
    {
      paramString = new bt();
      paramString.cRI = 3L;
      paramString.cYT = 1L;
      paramString.ake();
    }
    if ((FingerprintWalletLockUI.d(this.uEG) != null) && (FingerprintWalletLockUI.d(this.uEG).equals("action.verify_pattern")))
    {
      if (FingerprintWalletLockUI.e(this.uEG) != 1) {
        break label167;
      }
      paramString = new bt();
      paramString.cRI = 7L;
      paramString.cYT = 1L;
      paramString.ake();
    }
    while (FingerprintWalletLockUI.c(this.uEG))
    {
      AppMethodBeat.o(51516);
      return;
      label167:
      if (FingerprintWalletLockUI.e(this.uEG) == 2)
      {
        paramString = new bt();
        paramString.cRI = 9L;
        paramString.cYT = 1L;
        paramString.ake();
      }
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51516);
      return;
      ab.i("MicroMsg.FingerprintWalletLockUI", "identify success");
      if (cXI() != null) {
        FingerprintWalletLockUI.f(cXI());
      }
      if ((FingerprintWalletLockUI.d(this.uEG) != null) && (FingerprintWalletLockUI.d(this.uEG).equals("action.switch_on_pattern")))
      {
        paramString = new bt();
        paramString.cRI = 3L;
        paramString.cYT = 2L;
        paramString.ake();
      }
      if ((FingerprintWalletLockUI.d(this.uEG) != null) && (FingerprintWalletLockUI.d(this.uEG).equals("action.verify_pattern")))
      {
        if (FingerprintWalletLockUI.e(this.uEG) == 1)
        {
          paramString = new bt();
          paramString.cRI = 7L;
          paramString.cYT = 2L;
          paramString.ake();
          AppMethodBeat.o(51516);
          return;
        }
        if (FingerprintWalletLockUI.e(this.uEG) == 2)
        {
          paramString = new bt();
          paramString.cRI = 9L;
          paramString.cYT = 2L;
          paramString.ake();
          AppMethodBeat.o(51516);
          return;
          ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user cancel");
          AppMethodBeat.o(51516);
          return;
          ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify ERR_NO_MATCH");
          if (cXI() != null)
          {
            FingerprintWalletLockUI.a(cXI(), paramInt, this.uEG.getString(2131305162));
            AppMethodBeat.o(51516);
            return;
            ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo identify TIMEOUT");
            if (cXI() != null)
            {
              FingerprintWalletLockUI.a(cXI(), paramInt, this.uEG.getString(2131305162));
              AppMethodBeat.o(51516);
              return;
              if (cXI() != null)
              {
                FingerprintWalletLockUI.b(cXI(), paramInt, this.uEG.getString(2131305154));
                AppMethodBeat.o(51516);
                return;
                if (cXI() != null)
                {
                  FingerprintWalletLockUI.b(cXI(), paramInt, this.uEG.getString(2131305171));
                  AppMethodBeat.o(51516);
                  return;
                  ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo on error: %d", new Object[] { Integer.valueOf(paramInt) });
                  if (cXI() != null) {
                    FingerprintWalletLockUI.b(cXI(), paramInt, this.uEG.getString(2131305161));
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void cXJ()
  {
    AppMethodBeat.i(51515);
    FingerprintWalletLockUI.a(this.uEG);
    FingerprintWalletLockUI.b(this.uEG);
    AppMethodBeat.o(51515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.a
 * JD-Core Version:    0.7.0.1
 */