package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.protocal.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

final class PhoneRechargeUI$19
  implements View.OnClickListener
{
  PhoneRechargeUI$19(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44273);
    if (PhoneRechargeUI.f(this.pWp) != null)
    {
      g.gK(6, 1);
      if ((!PhoneRechargeUI.a(this.pWp, PhoneRechargeUI.f(this.pWp).tTY, PhoneRechargeUI.f(this.pWp).fjP)) && (!bo.isNullOrNil(PhoneRechargeUI.f(this.pWp).url))) {
        try
        {
          paramView = URLDecoder.decode(PhoneRechargeUI.f(this.pWp).url, "utf-8");
          PhoneRechargeUI.c(this.pWp, paramView);
          AppMethodBeat.o(44273);
          return;
        }
        catch (UnsupportedEncodingException paramView)
        {
          ab.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramView, "", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(44273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.19
 * JD-Core Version:    0.7.0.1
 */