package com.tencent.mm.plugin.wallet_core.ui;

import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mm.h.a.ll;
import com.tencent.mm.h.a.ll.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WalletCheckPwdUI$7
  implements Runnable
{
  WalletCheckPwdUI$7(WalletCheckPwdUI paramWalletCheckPwdUI, ll paramll) {}
  
  public final void run()
  {
    y.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback");
    ll.b localb = this.qDn.bUw;
    if (localb == null) {
      y.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, result == null");
    }
    boolean bool1;
    label349:
    label355:
    do
    {
      return;
      int i = localb.errCode;
      y.v("Micromsg.WalletCheckPwdUI", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), localb.aox });
      if (i == 0)
      {
        y.i("Micromsg.WalletCheckPwdUI", "hy: payInfo soterAuthReq: %s", new Object[] { localb.bUA });
        WalletCheckPwdUI.i(this.qDk).setVisibility(8);
        WalletCheckPwdUI.b(this.qDk, localb.bUA);
        com.tencent.mm.plugin.soter.d.a.zj(0);
        return;
      }
      y.i("Micromsg.WalletCheckPwdUI", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
      int j = (int)(System.currentTimeMillis() / 1000L);
      int k = j - WalletCheckPwdUI.j(this.qDk);
      if (k > 1)
      {
        WalletCheckPwdUI.b(this.qDk, j);
        WalletCheckPwdUI.k(this.qDk);
      }
      if ((i == 2) || (i == 10308))
      {
        bool1 = true;
        if (localb.bUB != 2) {
          break label349;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        y.v("Micromsg.WalletCheckPwdUI", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(WalletCheckPwdUI.l(this.qDk)), Integer.valueOf(i), Boolean.valueOf(bool2) });
        if (((!bool2) && ((WalletCheckPwdUI.l(this.qDk) >= 3) || (k <= 1))) || (bool1)) {
          break label355;
        }
        y.v("Micromsg.WalletCheckPwdUI", "alvinluo fingerprint pay");
        if (WalletCheckPwdUI.m(this.qDk) == null) {
          WalletCheckPwdUI.a(this.qDk, com.tencent.mm.ui.c.a.gE(this.qDk.mController.uMN));
        }
        WalletCheckPwdUI.i(this.qDk).setVisibility(0);
        WalletCheckPwdUI.i(this.qDk).startAnimation(WalletCheckPwdUI.m(this.qDk));
        WalletCheckPwdUI.m(this.qDk).setFillAfter(true);
        com.tencent.mm.plugin.soter.d.a.zj(1);
        return;
        bool1 = false;
        break;
      }
    } while ((WalletCheckPwdUI.l(this.qDk) < 3) && (!bool1));
    y.v("Micromsg.WalletCheckPwdUI", "alvinluo change to pwd pay");
    WalletCheckPwdUI.bWE();
    WalletCheckPwdUI.a(this.qDk, 0);
    WalletCheckPwdUI.g(this.qDk);
    WalletCheckPwdUI.n(this.qDk).setVisibility(8);
    com.tencent.mm.plugin.soter.d.a.zj(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.7
 * JD-Core Version:    0.7.0.1
 */