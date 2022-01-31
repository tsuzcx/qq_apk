package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

final class PhoneRechargeUI$19
  implements View.OnClickListener
{
  PhoneRechargeUI$19(PhoneRechargeUI paramPhoneRechargeUI) {}
  
  public final void onClick(View paramView)
  {
    if (PhoneRechargeUI.f(this.nrb) != null)
    {
      f.eZ(6, 1);
      if ((PhoneRechargeUI.a(this.nrb, PhoneRechargeUI.f(this.nrb).qkP, PhoneRechargeUI.f(this.nrb).dTJ)) || (bk.bl(PhoneRechargeUI.f(this.nrb).url))) {}
    }
    try
    {
      paramView = URLDecoder.decode(PhoneRechargeUI.f(this.nrb).url, "utf-8");
      PhoneRechargeUI.c(this.nrb, paramView);
      return;
    }
    catch (UnsupportedEncodingException paramView)
    {
      y.printErrStackTrace("MicroMsg.PhoneRechargeUI", paramView, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI.19
 * JD-Core Version:    0.7.0.1
 */