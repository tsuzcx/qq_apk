package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletCheckIdentityUI
  extends WalletBaseUI
{
  private WalletFormView qAx;
  private WalletFormView qpk;
  private String rRj;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_wxcredit_check_indentity_ui;
  }
  
  public final void initView()
  {
    setMMTitle(a.i.wallet_check_indentity_title);
    this.qAx = ((WalletFormView)findViewById(a.f.name_et));
    a.e(this, this.qAx);
    this.qpk = ((WalletFormView)findViewById(a.f.identity_et));
    a.c(this.qpk);
    e(this.qpk, 1, false);
    String str = this.BX.getString("key_pre_name");
    this.rRj = this.BX.getString("key_pre_indentity");
    if (!bk.bl(str))
    {
      this.qAx.getPrefilledTv().setText(str);
      this.qAx.setHint(getString(a.i.wallet_card_username_last_hint));
    }
    if (!bk.bl(this.rRj))
    {
      this.qpk.setMaxInputLength(4);
      this.qpk.getPrefilledTv().setText(this.rRj);
      this.qpk.setHint(getString(a.i.wallet_card_identify_last_hint));
    }
    findViewById(a.f.next_btn).setOnClickListener(new WalletCheckIdentityUI.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI
 * JD-Core Version:    0.7.0.1
 */