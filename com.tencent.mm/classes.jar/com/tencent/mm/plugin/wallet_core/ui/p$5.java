package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.ma.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import org.json.JSONObject;

final class p$5
  implements Runnable
{
  p$5(p paramp, ma paramma) {}
  
  public final void run()
  {
    AppMethodBeat.i(47562);
    ab.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback");
    Object localObject = this.val$fpevent.cCb;
    if (localObject == null)
    {
      p.a(this.utf, 0);
      ab.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, result == null");
      AppMethodBeat.o(47562);
      return;
    }
    int i = ((ma.b)localObject).errCode;
    ab.v("MicroMsg.WalletPwdCustomDialog", "alvinluo errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), ((ma.b)localObject).errMsg });
    if (i == 0)
    {
      ab.i("MicroMsg.WalletPwdCustomDialog", "hy: payInfo soterAuthReq: %s", new Object[] { ((ma.b)localObject).cCf });
      p.a(this.utf, 1);
      p.a(this.utf, ((ma.b)localObject).cCf);
      try
      {
        localObject = new JSONObject(p.e(this.utf));
        ((JSONObject)localObject).put("soter_type", "1");
        p.a(this.utf, ((JSONObject)localObject).toString());
        p.f(this.utf);
        this.utf.usV.setText("");
        this.utf.cVU();
        h.qsU.e(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
        com.tencent.mm.plugin.soter.d.a.Fu(0);
        AppMethodBeat.o(47562);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.WalletPwdCustomDialog", localException, "", new Object[0]);
        }
      }
    }
    ab.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
    p.a(this.utf, 0);
    p.a(this.utf, "");
    this.utf.usU.setVisibility(0);
    this.utf.usV.setTextColor(this.utf.getContext().getResources().getColor(2131690391));
    this.utf.usV.setText(2131305070);
    int j = (int)(System.currentTimeMillis() / 1000L);
    int k = j - p.g(this.utf);
    if (k > 1)
    {
      p.b(this.utf, j);
      p.h(this.utf);
      p.f(this.utf);
    }
    h.qsU.e(11977, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) });
    boolean bool1;
    if ((i == 2) || (i == 10308))
    {
      bool1 = true;
      if (localException.cCg != 2) {
        break label673;
      }
    }
    label673:
    for (boolean bool2 = true;; bool2 = false)
    {
      ab.v("MicroMsg.WalletPwdCustomDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(p.i(this.utf)), Integer.valueOf(i), Boolean.valueOf(bool2) });
      if (((!bool2) && ((p.i(this.utf) >= 3) || (k <= 1))) || (bool1)) {
        break label679;
      }
      ab.v("MicroMsg.WalletPwdCustomDialog", "alvinluo fingerprint pay");
      if (p.j(this.utf) == null) {
        p.a(this.utf, com.tencent.mm.ui.c.a.eY(this.utf.getContext()));
      }
      this.utf.upK.setVisibility(8);
      this.utf.usV.setVisibility(4);
      p.j(this.utf).reset();
      p.j(this.utf).setAnimationListener(new p.5.1(this));
      this.utf.usV.startAnimation(p.j(this.utf));
      com.tencent.mm.plugin.soter.d.a.Fu(1);
      AppMethodBeat.o(47562);
      return;
      bool1 = false;
      break;
    }
    label679:
    if ((p.i(this.utf) >= 3) || (bool1))
    {
      ab.v("MicroMsg.WalletPwdCustomDialog", "alvinluo change to pwd pay");
      p.cVW();
      this.utf.usW = 0;
      p.k(this.utf);
      this.utf.usT.setVisibility(8);
      this.utf.usU.setVisibility(8);
      this.utf.usV.setVisibility(0);
      this.utf.usV.setText(2131305071);
      this.utf.usV.setTextColor(this.utf.getContext().getResources().getColor(2131690665));
      this.utf.usz.setText(2131305532);
      this.utf.usE.setVisibility(0);
      if (!this.utf.mKBLayout.isShown()) {
        this.utf.mKBLayout.setVisibility(0);
      }
      com.tencent.mm.plugin.soter.d.a.Fu(2);
      p.cVX();
    }
    AppMethodBeat.o(47562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.p.5
 * JD-Core Version:    0.7.0.1
 */