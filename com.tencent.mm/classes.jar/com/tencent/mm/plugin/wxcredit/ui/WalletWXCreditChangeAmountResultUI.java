package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditChangeAmountResultUI
  extends WalletBaseUI
{
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_wxcredit_change_amount_result_ui;
  }
  
  protected final void initView()
  {
    ((TextView)findViewById(a.f.wallet_wxcredit_amount)).setText(e.B(this.BX.getDouble("key_credit_amount")));
    showHomeBtn(false);
    enableBackMenu(false);
    addTextOptionMenu(0, getString(a.i.app_finish), new WalletWXCreditChangeAmountResultUI.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI
 * JD-Core Version:    0.7.0.1
 */