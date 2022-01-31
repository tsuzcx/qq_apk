package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;

final class RemittanceBusiUI$a
{
  private View hNa;
  private float nCI;
  private float nCJ;
  private float nCK;
  private TenpaySecureEditText nCL;
  private TextView nCM;
  private View nCN;
  
  RemittanceBusiUI$a(RemittanceBusiUI paramRemittanceBusiUI, int paramInt1, int paramInt2, float paramFloat)
  {
    this.nCI = paramInt1;
    this.nCJ = paramInt2;
    this.nCK = paramFloat;
  }
  
  final void update()
  {
    RemittanceBusiUI.b(this.nCA).setTextSize(1, RemittanceBusiUI.a(this.nCA).nCJ);
    RemittanceBusiUI.c(this.nCA).setTextSize(1, RemittanceBusiUI.a(this.nCA).nCI);
    if (this.nCM == null) {
      this.nCM = ((TextView)RemittanceBusiUI.d(this.nCA).findViewById(a.f.wallet_title));
    }
    if (this.nCM != null) {
      this.nCM.setTextSize(this.nCI);
    }
    if (this.nCL == null) {
      this.nCL = ((TenpaySecureEditText)RemittanceBusiUI.d(this.nCA).findViewById(a.f.wallet_content));
    }
    if (this.nCL != null) {
      this.nCL.setTextSize(this.nCJ);
    }
    if (this.hNa == null) {
      this.hNa = this.nCL.findViewById(a.f.money_et_layout);
    }
    if (this.hNa != null) {
      this.hNa.setMinimumHeight(BackwardSupportUtil.b.b(this.nCA, RemittanceBusiUI.a(this.nCA).nCJ));
    }
    if (this.nCN == null) {
      this.nCN = this.nCA.findViewById(a.f.walletformline);
    }
    if (this.nCN != null) {
      ((LinearLayout.LayoutParams)this.nCN.getLayoutParams()).topMargin = BackwardSupportUtil.b.b(this.nCA, this.nCK);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.a
 * JD-Core Version:    0.7.0.1
 */