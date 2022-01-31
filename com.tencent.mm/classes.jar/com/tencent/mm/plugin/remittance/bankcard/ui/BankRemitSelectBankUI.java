package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class BankRemitSelectBankUI
  extends BankRemitBaseUI
{
  private BankRemitSortView nxr;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof h))
    {
      paramString = (h)paramm;
      paramString.a(new BankRemitSelectBankUI.4(this, paramString)).b(new BankRemitSelectBankUI.3(this, paramString)).c(new BankRemitSelectBankUI.2(this, paramString));
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.bank_remit_select_bank_ui;
  }
  
  protected final void initView()
  {
    this.nxr = ((BankRemitSortView)findViewById(a.f.brsb_sort_view));
    this.nxr.setOnItemClickListener(new BankRemitSelectBankUI.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.bank_remit_select_bank_title);
    kh(1399);
    initView();
    y.i("MicroMsg.BankRemitSelectBankUI", "do fetch data");
    paramBundle = new h();
    paramBundle.m(this);
    a(paramBundle, true, true);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI
 * JD-Core Version:    0.7.0.1
 */