package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.a.ll;
import com.tencent.mm.h.a.ll.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

final class n$5
  implements Runnable
{
  n$5(n paramn, ll paramll) {}
  
  public final void run()
  {
    y.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback");
    ll.b localb = this.qDn.bUw;
    if (localb == null)
    {
      n.a(this.qGa, 0);
      y.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, result == null");
    }
    boolean bool1;
    label598:
    label604:
    do
    {
      return;
      int i = localb.errCode;
      y.v("MicroMsg.WalletPwdCustomDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), localb.aox });
      if (i == 0)
      {
        y.i("MicroMsg.WalletPwdCustomDialog", "hy: payInfo soterAuthReq: %s", new Object[] { localb.bUA });
        n.a(this.qGa, 1);
        n.a(this.qGa, localb.bUA);
        n.e(this.qGa);
        this.qGa.qFP.setText("");
        this.qGa.bWR();
        h.nFQ.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
        com.tencent.mm.plugin.soter.d.a.zj(0);
        return;
      }
      y.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
      n.a(this.qGa, 0);
      n.a(this.qGa, "");
      this.qGa.qFO.setVisibility(0);
      this.qGa.qFP.setTextColor(this.qGa.getContext().getResources().getColor(a.c.red));
      this.qGa.qFP.setText(a.i.wallet_finger_print_fail);
      int j = (int)(System.currentTimeMillis() / 1000L);
      int k = j - n.f(this.qGa);
      if (k > 1)
      {
        n.b(this.qGa, j);
        n.g(this.qGa);
        n.e(this.qGa);
      }
      h.nFQ.f(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
      if ((i == 2) || (i == 10308))
      {
        bool1 = true;
        if (localb.bUB != 2) {
          break label598;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        y.v("MicroMsg.WalletPwdCustomDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(n.h(this.qGa)), Integer.valueOf(i), Boolean.valueOf(bool2) });
        if (((!bool2) && ((n.h(this.qGa) >= 3) || (k <= 1))) || (bool1)) {
          break label604;
        }
        y.v("MicroMsg.WalletPwdCustomDialog", "alvinluo fingerprint pay");
        if (n.i(this.qGa) == null) {
          n.a(this.qGa, com.tencent.mm.ui.c.a.gE(this.qGa.getContext()));
        }
        this.qGa.qFQ.setVisibility(8);
        this.qGa.qFP.setVisibility(4);
        n.i(this.qGa).reset();
        n.i(this.qGa).setAnimationListener(new n.5.1(this));
        this.qGa.qFP.startAnimation(n.i(this.qGa));
        com.tencent.mm.plugin.soter.d.a.zj(1);
        return;
        bool1 = false;
        break;
      }
    } while ((n.h(this.qGa) < 3) && (!bool1));
    y.v("MicroMsg.WalletPwdCustomDialog", "alvinluo change to pwd pay");
    n.bWT();
    this.qGa.qFR = 0;
    n.j(this.qGa);
    this.qGa.qFN.setVisibility(8);
    this.qGa.qFO.setVisibility(8);
    this.qGa.qFP.setVisibility(0);
    this.qGa.qFP.setText(a.i.wallet_finger_print_not_recorded);
    this.qGa.qFP.setTextColor(this.qGa.getContext().getResources().getColor(a.c.wallet_pwd_bank_card_text_color));
    this.qGa.qFt.setText(a.i.wallet_pwd_dialog_titile);
    this.qGa.qFy.setVisibility(0);
    if (!this.qGa.lMr.isShown()) {
      this.qGa.lMr.setVisibility(0);
    }
    com.tencent.mm.plugin.soter.d.a.zj(2);
    n.bWU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.n.5
 * JD-Core Version:    0.7.0.1
 */