package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.HashMap;
import java.util.HashSet;

public final class WalletPayUCardElementUI$b
{
  boolean uCh;
  boolean uCi;
  boolean uCj;
  
  protected WalletPayUCardElementUI$b(WalletPayUCardElementUI paramWalletPayUCardElementUI) {}
  
  protected final void cXn()
  {
    AppMethodBeat.i(48364);
    this.uCh = WalletPayUCardElementUI.c(this.uCg).asv();
    this.uCi = WalletPayUCardElementUI.b(this.uCg).asv();
    this.uCj = WalletPayUCardElementUI.a(this.uCg).asv();
    int i;
    if ((WalletPayUCardElementUI.e(this.uCg)) && (!this.uCj))
    {
      WalletPayUCardElementUI.f(this.uCg).setVisibility(0);
      WalletPayUCardElementUI.f(this.uCg).setText(2131304918);
      if (!WalletPayUCardElementUI.g(this.uCg)) {
        break label505;
      }
      if (this.uCh) {
        break label207;
      }
      WalletPayUCardElementUI.h(this.uCg).setVisibility(0);
      WalletPayUCardElementUI.h(this.uCg).setTextColor(this.uCg.getResources().getColor(2131690391));
      WalletPayUCardElementUI.h(this.uCg).setText(2131304904);
      i = 0;
    }
    for (;;)
    {
      if ((this.uCh) && (this.uCi) && (this.uCj) && (i == 0))
      {
        WalletPayUCardElementUI.j(this.uCg).setEnabled(true);
        AppMethodBeat.o(48364);
        return;
        WalletPayUCardElementUI.f(this.uCg).setVisibility(4);
        break;
        label207:
        if ((WalletPayUCardElementUI.d(this.uCg).containsKey(WalletPayUCardElementUI.c(this.uCg).getText())) && (!WalletPayUCardElementUI.i(this.uCg).contains(WalletPayUCardElementUI.c(this.uCg).getText())))
        {
          NetScenePayUElementQuery.PayUBankcardElement localPayUBankcardElement = (NetScenePayUElementQuery.PayUBankcardElement)WalletPayUCardElementUI.d(this.uCg).get(WalletPayUCardElementUI.c(this.uCg).getText());
          WalletPayUCardElementUI.h(this.uCg).setVisibility(0);
          if (!bo.isNullOrNil(localPayUBankcardElement.uBP))
          {
            WalletPayUCardElementUI.h(this.uCg).setTextColor(this.uCg.getResources().getColor(2131690168));
            WalletPayUCardElementUI.h(this.uCg).setText(localPayUBankcardElement.uBQ);
            i = 0;
            continue;
          }
          WalletPayUCardElementUI.h(this.uCg).setTextColor(this.uCg.getResources().getColor(2131690391));
          WalletPayUCardElementUI.h(this.uCg).setText(localPayUBankcardElement.uBQ);
          this.uCh = false;
          i = 0;
          continue;
        }
        this.uCg.doSceneProgress(new NetScenePayUElementQuery(WalletPayUCardElementUI.c(this.uCg).getText()), false);
        WalletPayUCardElementUI.i(this.uCg).add(WalletPayUCardElementUI.c(this.uCg).getText());
        WalletPayUCardElementUI.h(this.uCg).setVisibility(0);
        WalletPayUCardElementUI.h(this.uCg).setTextColor(this.uCg.getResources().getColor(2131690168));
        WalletPayUCardElementUI.h(this.uCg).setText(this.uCg.getString(2131304883));
        i = 1;
        continue;
      }
      WalletPayUCardElementUI.j(this.uCg).setEnabled(false);
      AppMethodBeat.o(48364);
      return;
      label505:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI.b
 * JD-Core Version:    0.7.0.1
 */