package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

public class WalletECardCheckOtherCardUI
  extends WalletECardBaseUI
  implements WalletFormView.a
{
  private Button frP;
  private String iLj;
  private WalletFormView nvD;
  private WalletFormView qKL;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public final void gG(boolean paramBoolean)
  {
    y.d("MicroMsg.WalletECardCheckOtherCardUI", "is valid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.nvD.YL()) && (this.qKL.YL()))
    {
      this.frP.setEnabled(true);
      this.frP.setClickable(true);
      return;
    }
    this.frP.setEnabled(false);
    this.frP.setClickable(false);
  }
  
  protected final int getLayoutId()
  {
    return a.g.ecard_check_other_card_ui;
  }
  
  protected final void initView()
  {
    this.nvD = ((WalletFormView)findViewById(a.f.check_other_card_input_et));
    this.qKL = ((WalletFormView)findViewById(a.f.check_other_card_mobile_input_et));
    this.frP = ((Button)findViewById(a.f.check_other_card_next_btn));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.nvD);
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.qKL);
    if (!bk.bl(this.iLj)) {
      this.nvD.setHint(getString(a.i.ecard_check_other_card_hint_text, new Object[] { this.iLj }));
    }
    for (;;)
    {
      this.qKL.setHint(getString(a.i.ecard_check_other_card_phone_hint_text));
      this.nvD.setOnInputValidChangeListener(this);
      this.qKL.setOnInputValidChangeListener(this);
      e(this.nvD, 0, false);
      e(this.qKL, 0, false);
      this.frP.setEnabled(false);
      this.frP.setClickable(false);
      this.frP.setOnClickListener(new WalletECardCheckOtherCardUI.1(this));
      return;
      this.nvD.setHint(getString(a.i.ecard_check_other_card_hint_without_name_text));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.iLj = this.BX.getString(com.tencent.mm.plugin.wallet_ecard.a.a.qKi, "");
    setMMTitle(getString(a.i.ecard_check_other_card_title));
    this.wCh.kh(385);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.wCh.ki(385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI
 * JD-Core Version:    0.7.0.1
 */