package com.tencent.mm.plugin.wallet.pay.ui;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.ui.b;
import com.tencent.mm.plugin.wallet_core.ui.c;
import com.tencent.mm.plugin.wallet_core.ui.l.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.ad;

final class WalletPayUI$30$1
  implements l.b
{
  WalletPayUI$30$1(WalletPayUI.30 param30) {}
  
  public final void a(FavorPayInfo paramFavorPayInfo)
  {
    int j = 1;
    AppMethodBeat.i(46071);
    this.tXv.tXq.tVQ = paramFavorPayInfo;
    Object localObject = this.tXv.tXq.TAG;
    int i;
    label82:
    label98:
    boolean bool;
    if (paramFavorPayInfo == null)
    {
      paramFavorPayInfo = "";
      ab.i((String)localObject, "WalletFavorDialog onSelectionDone %s", new Object[] { paramFavorPayInfo });
      if (this.tXv.tXq.tVQ != null)
      {
        if (this.tXv.tXq.mPayInfo != null) {
          break label467;
        }
        i = 0;
        if (this.tXv.tXq.mPayInfo != null) {
          break label485;
        }
        paramFavorPayInfo = "";
        ad.e(i, paramFavorPayInfo, 15, this.tXv.tXq.tVQ.uhU);
        if ((this.tXv.tXq.tNH != null) && (!b.a(this.tXv.tXq.tVQ, this.tXv.tXq.tNH))) {
          break label502;
        }
        this.tXv.tXq.tWR.setVisibility(8);
        this.tXv.tXq.qqy.setOnClickListener(new WalletPayUI.30.1.1(this));
        bool = true;
      }
    }
    for (;;)
    {
      label197:
      ab.i(this.tXv.tXq.TAG, "needBindBankCard %s", new Object[] { Boolean.valueOf(bool) });
      WalletPayUI.c(this.tXv.tXq).setVisibility(0);
      WalletPayUI.d(this.tXv.tXq).setVisibility(0);
      if (this.tXv.tXq.tVQ != null)
      {
        this.tXv.tXq.tWD = c.umO.a(this.tXv.tXq.qrf);
        paramFavorPayInfo = this.tXv.tXq.tWD.afD(this.tXv.tXq.tVQ.uhU);
        if ((paramFavorPayInfo != null) && (paramFavorPayInfo.tUe == 0.0D))
        {
          WalletPayUI.c(this.tXv.tXq).setVisibility(8);
          WalletPayUI.d(this.tXv.tXq).setVisibility(8);
          bool = false;
        }
      }
      for (i = j;; i = 0)
      {
        if (!bool)
        {
          this.tXv.tXq.tWQ.setVisibility(8);
          this.tXv.tXq.tWR.setVisibility(0);
          this.tXv.tXq.qqy.setOnClickListener(new WalletPayUI.30.1.3(this));
        }
        if (i != 0) {
          this.tXv.tXq.tWR.setVisibility(8);
        }
        this.tXv.tXq.cSc();
        AppMethodBeat.o(46071);
        return;
        paramFavorPayInfo = paramFavorPayInfo.toString();
        break;
        label467:
        i = this.tXv.tXq.mPayInfo.cCD;
        break label82;
        label485:
        paramFavorPayInfo = this.tXv.tXq.mPayInfo.cnI;
        break label98;
        label502:
        paramFavorPayInfo = this.tXv.tXq.tWD.afD(this.tXv.tXq.tVQ.uhU);
        if ((paramFavorPayInfo == null) || (!this.tXv.tXq.tNH.cTf())) {
          break label644;
        }
        s.cRG();
        localObject = s.cRH().tOD;
        double d = paramFavorPayInfo.tUe;
        if ((localObject == null) || (((Bankcard)localObject).ufM >= d)) {
          break label644;
        }
        ab.i(this.tXv.tXq.TAG, "balance not meet");
        this.tXv.tXq.tWR.setVisibility(8);
        this.tXv.tXq.qqy.setOnClickListener(new WalletPayUI.30.1.2(this));
        bool = true;
        break label197;
      }
      label644:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.30.1
 * JD-Core Version:    0.7.0.1
 */