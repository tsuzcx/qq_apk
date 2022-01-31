package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class PayURemittanceResendMsgUI
  extends RemittanceResendMsgUI
{
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.bC(this, getString(a.i.remittance_resended));
        finish();
        return true;
      }
      h.bC(this, paramString);
      finish();
      return true;
    }
    return false;
  }
  
  protected final void j(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(new f(paramString1, getIntent().getIntExtra("total_fee", 0), getIntent().getStringExtra("fee_type"), paramString2, paramInt1), true, true);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceResendMsgUI
 * JD-Core Version:    0.7.0.1
 */