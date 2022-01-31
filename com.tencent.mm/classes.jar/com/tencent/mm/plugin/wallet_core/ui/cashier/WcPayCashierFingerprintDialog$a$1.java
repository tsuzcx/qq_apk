package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.ma.b;
import com.tencent.mm.plugin.soter.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class WcPayCashierFingerprintDialog$a$1
  implements Runnable
{
  WcPayCashierFingerprintDialog$a$1(WcPayCashierFingerprintDialog.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(47828);
    Object localObject = this.uvT.uvS.cCb;
    if (localObject == null)
    {
      ab.i("MicroMsg.WcPayCashierFingerprintDialog", "hy: FingerPrintAuthEvent callback, result == null");
      AppMethodBeat.o(47828);
      return;
    }
    int i = ((ma.b)localObject).errCode;
    ab.i("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint verify errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), ((ma.b)localObject).errMsg });
    if (i == 0)
    {
      ab.i("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint success, soterAuthReq: %s", new Object[] { ((ma.b)localObject).cCf });
      this.uvT.uvR.cWD();
      a.Fu(0);
      WcPayCashierFingerprintDialog.a.a(this.uvT);
      this.uvT.uvR.dismiss();
      if (WcPayCashierFingerprintDialog.a(this.uvT.uvR) != null)
      {
        WcPayCashierFingerprintDialog.a(this.uvT.uvR).a((ma.b)localObject);
        AppMethodBeat.o(47828);
      }
    }
    else
    {
      int j = (int)(System.currentTimeMillis() / 1000L);
      int k = j - this.uvT.mGM;
      if (k > 1)
      {
        this.uvT.mGM = j;
        WcPayCashierFingerprintDialog.a.a(this.uvT);
      }
      boolean bool1;
      if ((i == 2) || (i == 10308))
      {
        bool1 = true;
        if (((ma.b)localObject).cCg != 2) {
          break label419;
        }
      }
      label419:
      for (boolean bool2 = true;; bool2 = false)
      {
        ab.d("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint not match, shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(this.uvT.usY), Integer.valueOf(i), Boolean.valueOf(bool2) });
        if (((!bool2) && ((this.uvT.usY >= 3) || (k <= 1))) || (bool1)) {
          break label425;
        }
        ab.i("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint retry: %s", new Object[] { Integer.valueOf(this.uvT.usY) });
        localObject = this.uvT.uvR;
        ((WcPayCashierFingerprintDialog)localObject).uvN.setImageResource(2131231085);
        ((WcPayCashierFingerprintDialog)localObject).uvO.setTextColor(((WcPayCashierFingerprintDialog)localObject).getContext().getResources().getColor(2131689604));
        ((WcPayCashierFingerprintDialog)localObject).uvM.setVisibility(0);
        ((WcPayCashierFingerprintDialog)localObject).uvM.setOnClickListener(new WcPayCashierFingerprintDialog.4((WcPayCashierFingerprintDialog)localObject));
        al.p(new WcPayCashierFingerprintDialog.5((WcPayCashierFingerprintDialog)localObject), 500L);
        a.Fu(1);
        AppMethodBeat.o(47828);
        return;
        bool1 = false;
        break;
      }
      label425:
      if ((this.uvT.usY >= 3) || (bool1))
      {
        ab.w("MicroMsg.WcPayCashierFingerprintDialog", "fingerprint verify fail!");
        a.Fu(2);
        this.uvT.uvR.dismiss();
        if (WcPayCashierFingerprintDialog.a(this.uvT.uvR) != null) {
          WcPayCashierFingerprintDialog.a(this.uvT.uvR).cWz();
        }
      }
    }
    AppMethodBeat.o(47828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierFingerprintDialog.a.1
 * JD-Core Version:    0.7.0.1
 */