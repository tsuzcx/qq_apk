package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletWXCreditOpenUI
  extends WalletBaseUI
{
  private Button frP;
  private Bankcard qkH;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_wxcredit_open_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.wallet_wxcredit_open_title);
    ((CheckBox)findViewById(a.f.agree_wx_cb)).setOnCheckedChangeListener(new WalletWXCreditOpenUI.1(this));
    findViewById(a.f.agree_btn).setOnClickListener(new WalletWXCreditOpenUI.2(this));
    this.frP = ((Button)findViewById(a.f.next_btn));
    this.frP.setOnClickListener(new WalletWXCreditOpenUI.3(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.qkH = ((Bankcard)this.BX.getParcelable("key_bankcard"));
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI
 * JD-Core Version:    0.7.0.1
 */