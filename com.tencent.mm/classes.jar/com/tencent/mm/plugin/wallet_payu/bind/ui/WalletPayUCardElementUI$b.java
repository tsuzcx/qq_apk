package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.HashMap;
import java.util.HashSet;

public final class WalletPayUCardElementUI$b
{
  boolean qNa;
  boolean qNb;
  boolean qNc;
  
  protected WalletPayUCardElementUI$b(WalletPayUCardElementUI paramWalletPayUCardElementUI) {}
  
  protected final void bXF()
  {
    this.qNa = WalletPayUCardElementUI.c(this.qMZ).YL();
    this.qNb = WalletPayUCardElementUI.b(this.qMZ).YL();
    this.qNc = WalletPayUCardElementUI.a(this.qMZ).YL();
    int i;
    if ((WalletPayUCardElementUI.e(this.qMZ)) && (!this.qNc))
    {
      WalletPayUCardElementUI.f(this.qMZ).setVisibility(0);
      WalletPayUCardElementUI.f(this.qMZ).setText(a.i.wallet_card_cvv_err_hint);
      if (!WalletPayUCardElementUI.g(this.qMZ)) {
        break label498;
      }
      if (this.qNa) {
        break label200;
      }
      WalletPayUCardElementUI.h(this.qMZ).setVisibility(0);
      WalletPayUCardElementUI.h(this.qMZ).setTextColor(this.qMZ.getResources().getColor(a.c.red));
      WalletPayUCardElementUI.h(this.qMZ).setText(a.i.wallet_card_bankcard_type_err_tips);
      i = 0;
    }
    for (;;)
    {
      if ((this.qNa) && (this.qNb) && (this.qNc) && (i == 0))
      {
        WalletPayUCardElementUI.j(this.qMZ).setEnabled(true);
        return;
        WalletPayUCardElementUI.f(this.qMZ).setVisibility(4);
        break;
        label200:
        if ((WalletPayUCardElementUI.d(this.qMZ).containsKey(WalletPayUCardElementUI.c(this.qMZ).getText())) && (!WalletPayUCardElementUI.i(this.qMZ).contains(WalletPayUCardElementUI.c(this.qMZ).getText())))
        {
          NetScenePayUElementQuery.PayUBankcardElement localPayUBankcardElement = (NetScenePayUElementQuery.PayUBankcardElement)WalletPayUCardElementUI.d(this.qMZ).get(WalletPayUCardElementUI.c(this.qMZ).getText());
          WalletPayUCardElementUI.h(this.qMZ).setVisibility(0);
          if (!bk.bl(localPayUBankcardElement.qMI))
          {
            WalletPayUCardElementUI.h(this.qMZ).setTextColor(this.qMZ.getResources().getColor(a.c.hint_text_color));
            WalletPayUCardElementUI.h(this.qMZ).setText(localPayUBankcardElement.qMJ);
            i = 0;
            continue;
          }
          WalletPayUCardElementUI.h(this.qMZ).setTextColor(this.qMZ.getResources().getColor(a.c.red));
          WalletPayUCardElementUI.h(this.qMZ).setText(localPayUBankcardElement.qMJ);
          this.qNa = false;
          i = 0;
          continue;
        }
        this.qMZ.a(new NetScenePayUElementQuery(WalletPayUCardElementUI.c(this.qMZ).getText()), false, false);
        WalletPayUCardElementUI.i(this.qMZ).add(WalletPayUCardElementUI.c(this.qMZ).getText());
        WalletPayUCardElementUI.h(this.qMZ).setVisibility(0);
        WalletPayUCardElementUI.h(this.qMZ).setTextColor(this.qMZ.getResources().getColor(a.c.hint_text_color));
        WalletPayUCardElementUI.h(this.qMZ).setText(this.qMZ.getString(a.i.wallet_bind_querying_card_element_payu));
        i = 1;
        continue;
      }
      WalletPayUCardElementUI.j(this.qMZ).setEnabled(false);
      return;
      label498:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI.b
 * JD-Core Version:    0.7.0.1
 */