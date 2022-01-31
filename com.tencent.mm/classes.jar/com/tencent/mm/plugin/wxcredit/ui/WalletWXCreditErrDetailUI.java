package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletWXCreditErrDetailUI
  extends WalletBaseUI
{
  private Bankcard qhv;
  private String rRN;
  private TextView rRO;
  private TextView rRP;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_wxcredit_err_detail_ui;
  }
  
  protected final void initView()
  {
    this.qhv = ((Bankcard)this.BX.getParcelable("key_bankcard"));
    this.rRN = this.BX.getString("key_repayment_url");
    if (this.qhv == null) {
      return;
    }
    this.rRO = ((TextView)findViewById(a.f.wallet_bankcard_detail_repayment));
    this.rRO.setOnClickListener(new WalletWXCreditErrDetailUI.1(this));
    this.rRP = ((TextView)findViewById(a.f.wallet_bankcard_detail_unbind));
    this.rRP.setOnClickListener(new WalletWXCreditErrDetailUI.2(this));
    boolean bool = this.BX.getBoolean("key_can_unbind", true);
    TextView localTextView = this.rRP;
    if (bool) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_bankcard_detail_title);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI
 * JD-Core Version:    0.7.0.1
 */