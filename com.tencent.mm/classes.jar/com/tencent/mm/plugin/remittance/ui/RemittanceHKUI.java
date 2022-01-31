package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.fu;
import com.tencent.mm.plugin.remittance.model.p;
import com.tencent.mm.plugin.remittance.model.q;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class RemittanceHKUI
  extends RemittanceBaseUI
{
  private int nDS;
  private String nDT;
  private String nDU;
  private String nDV;
  
  public final void a(String paramString1, String paramString2, String paramString3, fu paramfu)
  {
    y.d("MicroMsg.RemittanceHKUI", "do scene gen pay");
    int i = 0;
    if (this.nzY == 33) {
      i = 1;
    }
    a(new q(Math.round(this.nzU * 100.0D), this.djD, this.nzW, this.nAl, this.dkv, this.nzZ, this.nDS, i), true, false);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    if ((paramm instanceof q))
    {
      paramm = (q)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (!bk.bl(paramm.nyt))
        {
          e.q(this.mController.uMN, paramm.nyt, 4);
          return;
        }
        y.e("MicroMsg.RemittanceHKUI", "empty payurl");
        return;
      }
      h.b(this.mController.uMN, paramString, "", false);
      return;
    }
    super.b(paramInt1, paramInt2, paramString, paramm, paramBoolean);
  }
  
  public final void bwo() {}
  
  public final void bwp()
  {
    y.d("MicroMsg.RemittanceHKUI", "do scene cancel");
    if (this.nzY == 33) {}
    for (int i = 1;; i = 0)
    {
      a(new p(this.djD, this.nzZ, this.nDS, this.nzU * 100L, i), false, false);
      return;
    }
  }
  
  public final void bwr()
  {
    com.tencent.mm.ui.base.s.makeText(this.mController.uMN, getString(a.i.remittance_os_amount_lowest_limit, new Object[] { this.nDT }), 0).show();
  }
  
  public final void bwu()
  {
    if (!bk.bl(this.nDU))
    {
      TextView localTextView = (TextView)findViewById(a.f.banner_tips);
      localTextView.setText(this.nDU);
      localTextView.setOnClickListener(new RemittanceHKUI.1(this));
    }
  }
  
  protected final void bwz() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 4) && (paramInt2 == -1)) {
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(1529);
    kh(1257);
    this.nDS = getIntent().getIntExtra("hk_currency", 0);
    this.nDT = getIntent().getStringExtra("hk_currencyuint");
    this.nDU = getIntent().getStringExtra("hk_notice");
    this.nDV = getIntent().getStringExtra("hk_notice_url");
    this.iKG.setTitleText(this.nDT);
    this.nAi.setText(this.nDT);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1529);
    ki(1257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceHKUI
 * JD-Core Version:    0.7.0.1
 */