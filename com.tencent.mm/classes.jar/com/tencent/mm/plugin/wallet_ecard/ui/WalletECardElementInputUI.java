package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletECardElementInputUI
  extends WalletECardBaseUI
{
  private Button fpF;
  private WalletFormView qBX;
  private ElementQuery qsa;
  
  private void aZ()
  {
    if (this.qsa == null) {
      this.qsa = new ElementQuery();
    }
    if (bk.bl(this.qsa.lnT))
    {
      this.qBX.setText("");
      return;
    }
    if (!bk.bl(this.qsa.qvg))
    {
      this.qBX.setText(this.qsa.lnT + " " + this.qsa.qvg);
      return;
    }
    if (2 == this.qsa.qvf)
    {
      this.qBX.setText(this.qsa.lnT + " " + getString(a.i.wallet_credit_card));
      return;
    }
    this.qBX.setText(this.qsa.lnT + " " + getString(a.i.wallet_deposit_card));
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.ecard_element_input_ui;
  }
  
  protected final void initView()
  {
    this.qBX = ((WalletFormView)findViewById(a.f.wallet_card_type));
    this.qBX.setOnClickListener(new WalletECardElementInputUI.1(this));
    this.fpF = ((Button)findViewById(a.f.next_btn));
    this.fpF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        y.i("MicroMsg.WalletECardElementInputUI", "goto next: %s", new Object[] { WalletECardElementInputUI.b(WalletECardElementInputUI.this).mOb });
        WalletECardElementInputUI.this.cNk().m(new Object[] { WalletECardElementInputUI.b(WalletECardElementInputUI.this) });
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.WalletECardElementInputUI", "onAcvityResult requestCode:" + paramInt1);
    if (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    this.qsa = ((ElementQuery)paramIntent.getParcelableExtra("elemt_query"));
    aZ();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.ecard_element_input_title);
    initView();
    aZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI
 * JD-Core Version:    0.7.0.1
 */