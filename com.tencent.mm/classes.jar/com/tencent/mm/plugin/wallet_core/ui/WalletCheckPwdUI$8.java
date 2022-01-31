package com.tencent.mm.plugin.wallet_core.ui;

import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.ma.b;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletCheckPwdUI$8
  implements Runnable
{
  WalletCheckPwdUI$8(WalletCheckPwdUI paramWalletCheckPwdUI, ma paramma) {}
  
  public final void run()
  {
    AppMethodBeat.i(47340);
    ab.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback");
    ma.b localb = this.val$fpevent.cCb;
    if (localb == null)
    {
      ab.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, result == null");
      AppMethodBeat.o(47340);
      return;
    }
    int i = localb.errCode;
    ab.v("Micromsg.WalletCheckPwdUI", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), localb.errMsg });
    if (i == 0)
    {
      ab.i("Micromsg.WalletCheckPwdUI", "hy: payInfo soterAuthReq: %s", new Object[] { localb.cCf });
      WalletCheckPwdUI.i(this.uqg).setVisibility(8);
      WalletCheckPwdUI.b(this.uqg, localb.cCf);
      com.tencent.mm.plugin.soter.d.a.Fu(0);
      AppMethodBeat.o(47340);
      return;
    }
    ab.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
    int j = (int)(System.currentTimeMillis() / 1000L);
    int k = j - WalletCheckPwdUI.j(this.uqg);
    if (k > 1)
    {
      WalletCheckPwdUI.b(this.uqg, j);
      WalletCheckPwdUI.k(this.uqg);
    }
    boolean bool1;
    if ((i == 2) || (i == 10308))
    {
      bool1 = true;
      if (localb.cCg != 2) {
        break label366;
      }
    }
    label366:
    for (boolean bool2 = true;; bool2 = false)
    {
      ab.v("Micromsg.WalletCheckPwdUI", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(WalletCheckPwdUI.l(this.uqg)), Integer.valueOf(i), Boolean.valueOf(bool2) });
      if (((!bool2) && ((WalletCheckPwdUI.l(this.uqg) >= 3) || (k <= 1))) || (bool1)) {
        break label372;
      }
      ab.v("Micromsg.WalletCheckPwdUI", "alvinluo fingerprint pay");
      if (WalletCheckPwdUI.m(this.uqg) == null) {
        WalletCheckPwdUI.a(this.uqg, com.tencent.mm.ui.c.a.eY(this.uqg.getContext()));
      }
      WalletCheckPwdUI.i(this.uqg).setVisibility(0);
      WalletCheckPwdUI.i(this.uqg).startAnimation(WalletCheckPwdUI.m(this.uqg));
      WalletCheckPwdUI.m(this.uqg).setFillAfter(true);
      com.tencent.mm.plugin.soter.d.a.Fu(1);
      AppMethodBeat.o(47340);
      return;
      bool1 = false;
      break;
    }
    label372:
    if ((WalletCheckPwdUI.l(this.uqg) >= 3) || (bool1))
    {
      ab.v("Micromsg.WalletCheckPwdUI", "alvinluo change to pwd pay");
      WalletCheckPwdUI.cVF();
      WalletCheckPwdUI.a(this.uqg, 0);
      WalletCheckPwdUI.g(this.uqg);
      WalletCheckPwdUI.n(this.uqg).setVisibility(8);
      com.tencent.mm.plugin.soter.d.a.Fu(2);
    }
    AppMethodBeat.o(47340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.8
 * JD-Core Version:    0.7.0.1
 */