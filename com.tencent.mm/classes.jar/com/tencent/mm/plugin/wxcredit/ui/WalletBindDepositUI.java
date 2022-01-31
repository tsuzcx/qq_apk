package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletBindDepositUI
  extends WalletBaseUI
{
  private Button fpF;
  private boolean kYh = true;
  private WalletFormView qAw;
  private WalletFormView qBX;
  private ElementQuery qsa = new ElementQuery();
  private WalletFormView rRh;
  
  private void aZ()
  {
    if (bk.bl(this.qsa.lnT))
    {
      this.qBX.setText("");
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
    boolean bool = false;
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof t)))
    {
      paramString = (t)paramm;
      if (paramString.qqX != null)
      {
        if (!paramString.qqX.bVc())
        {
          h.h(this, a.i.wallet_bind_deposit_bank_type_err, a.i.app_tip);
          return true;
        }
        this.qsa = paramString.qqX;
        aZ();
        if ((this.qsa.qvd) && (this.qsa.isError()))
        {
          h.h(this, a.i.wallet_bank_broken, a.i.app_tip);
          return true;
        }
        paramString = com.tencent.mm.wallet_core.a.aj(this);
        if (paramString != null)
        {
          paramInt1 = this.qsa.qqY;
          if (paramString == null)
          {
            if (bool) {
              break label224;
            }
            if (!paramString.bXd()) {
              break label203;
            }
            y.w("MicroMsg.WalletBindDepositUI", "Overseas user try to bind domestic card!");
            h.h(this, a.i.wallet_allow_international_bankcard, a.i.app_tip);
          }
          for (;;)
          {
            this.qAw.bvr();
            return true;
            if (!paramString.kke.containsKey("key_support_bankcard"))
            {
              bool = true;
              break;
            }
            paramInt2 = paramString.cMm();
            if (paramInt2 == 0)
            {
              bool = true;
              break;
            }
            bool = Bankcard.eu(paramInt2, paramInt1);
            break;
            label203:
            y.w("MicroMsg.WalletBindDepositUI", "Domestic user try to bind international card!");
            h.h(this, a.i.wallet_allow_domestic_bankcard, a.i.app_tip);
          }
        }
        label224:
        aZ();
        return true;
      }
    }
    return false;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.walle_wxcredit_bind_deposit_ui;
  }
  
  public final void initView()
  {
    setMMTitle(a.i.wallet_bind_deposit_title);
    this.qAw = ((WalletFormView)findViewById(a.f.wallet_card_bankcard_id));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.qAw);
    this.qBX = ((WalletFormView)findViewById(a.f.wallet_card_type));
    this.rRh = ((WalletFormView)findViewById(a.f.mobile_et));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.rRh);
    this.fpF = ((Button)findViewById(a.f.next_btn));
    e(this.qAw, 0, false);
    e(this.rRh, 0, false);
    this.qBX.setOnClickListener(new WalletBindDepositUI.1(this));
    this.fpF.setOnClickListener(new WalletBindDepositUI.2(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.WalletBindDepositUI", "onAcvityResult requestCode:" + paramInt1);
    if (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramIntent = (ElementQuery)paramIntent.getParcelableExtra("elemt_query");
    if (paramIntent.bVc())
    {
      this.qsa = paramIntent;
      aZ();
      return;
    }
    h.h(this, a.i.wallet_bind_deposit_bank_type_err, a.i.app_tip);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI
 * JD-Core Version:    0.7.0.1
 */