package com.tencent.mm.plugin.wallet.pay.ui;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.ui.a;
import com.tencent.mm.plugin.wallet_core.ui.b;
import com.tencent.mm.plugin.wallet_core.ui.j.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.aa;

final class WalletPayUI$29$1
  implements j.b
{
  WalletPayUI$29$1(WalletPayUI.29 param29) {}
  
  public final void a(FavorPayInfo paramFavorPayInfo)
  {
    int j = 1;
    this.qoa.qnV.qmA = paramFavorPayInfo;
    int i;
    label65:
    label81:
    boolean bool;
    if (paramFavorPayInfo == null)
    {
      paramFavorPayInfo = "";
      y.i("MicroMsg.WalletPayUI", "WalletFavorDialog onSelectionDone %s", new Object[] { paramFavorPayInfo });
      if (this.qoa.qnV.qmA != null)
      {
        if (this.qoa.qnV.nDu != null) {
          break label437;
        }
        i = 0;
        if (this.qoa.qnV.nDu != null) {
          break label455;
        }
        paramFavorPayInfo = "";
        aa.d(i, paramFavorPayInfo, 15, this.qoa.qnV.qmA.qvC);
        if ((this.qoa.qnV.qgs != null) && (!a.a(this.qoa.qnV.qmA, this.qoa.qnV.qgs))) {
          break label472;
        }
        this.qoa.qnV.qnA.setVisibility(8);
        this.qoa.qnV.nBL.setOnClickListener(new WalletPayUI.29.1.1(this));
        bool = true;
      }
    }
    for (;;)
    {
      label180:
      y.i("MicroMsg.WalletPayUI", "needBindBankCard %s", new Object[] { Boolean.valueOf(bool) });
      WalletPayUI.c(this.qoa.qnV).setVisibility(0);
      WalletPayUI.d(this.qoa.qnV).setVisibility(0);
      if (this.qoa.qnV.qmA != null)
      {
        this.qoa.qnV.qnm = b.qAd.a(this.qoa.qnV.nEh);
        paramFavorPayInfo = this.qoa.qnV.qnm.QF(this.qoa.qnV.qmA.qvC);
        if ((paramFavorPayInfo != null) && (paramFavorPayInfo.qkV == 0.0D))
        {
          WalletPayUI.c(this.qoa.qnV).setVisibility(8);
          WalletPayUI.d(this.qoa.qnV).setVisibility(8);
          bool = false;
        }
      }
      for (i = j;; i = 0)
      {
        if (!bool)
        {
          this.qoa.qnV.qnz.setVisibility(8);
          this.qoa.qnV.qnA.setVisibility(0);
          this.qoa.qnV.nBL.setOnClickListener(new WalletPayUI.29.1.3(this));
        }
        if (i != 0) {
          this.qoa.qnV.qnA.setVisibility(8);
        }
        this.qoa.qnV.bUi();
        return;
        paramFavorPayInfo = paramFavorPayInfo.toString();
        break;
        label437:
        i = this.qoa.qnV.nDu.bUV;
        break label65;
        label455:
        paramFavorPayInfo = this.qoa.qnV.nDu.bMX;
        break label81;
        label472:
        paramFavorPayInfo = this.qoa.qnV.qnm.QF(this.qoa.qnV.qmA.qvC);
        if ((paramFavorPayInfo == null) || (!this.qoa.qnV.qgs.bUQ())) {
          break label606;
        }
        p.bTK();
        Bankcard localBankcard = p.bTL().qhj;
        double d = paramFavorPayInfo.qkV;
        if ((localBankcard == null) || (localBankcard.qty >= d)) {
          break label606;
        }
        y.i("MicroMsg.WalletPayUI", "balance not meet");
        this.qoa.qnV.qnA.setVisibility(8);
        this.qoa.qnV.nBL.setOnClickListener(new WalletPayUI.29.1.2(this));
        bool = true;
        break label180;
      }
      label606:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.29.1
 * JD-Core Version:    0.7.0.1
 */