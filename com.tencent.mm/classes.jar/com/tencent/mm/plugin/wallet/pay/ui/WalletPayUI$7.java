package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ad;

final class WalletPayUI$7
  implements WcPayCashierDialog.a
{
  WalletPayUI$7(WalletPayUI paramWalletPayUI) {}
  
  public final void a(String paramString, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(46040);
    if (WalletPayUI.h(this.tXq))
    {
      ab.w(this.tXq.TAG, "has received canceled");
      com.tencent.mm.plugin.report.service.h.qsU.j(965L, 3L, 1L);
      AppMethodBeat.o(46040);
      return;
    }
    WalletPayUI.i(this.tXq);
    this.tXq.hideVKB();
    this.tXq.tVQ = paramFavorPayInfo;
    this.tXq.tNH = paramBankcard;
    paramBankcard = this.tXq.TAG;
    int i;
    if (this.tXq.tVQ == null)
    {
      paramFavorPayInfo = "";
      ab.i(paramBankcard, "WalletPwdDialog showAlert with favinfo %s", new Object[] { paramFavorPayInfo });
      if (!bo.isNullOrNil(paramString))
      {
        if (this.tXq.mPayInfo != null) {
          break label193;
        }
        i = 0;
        label131:
        if (this.tXq.mPayInfo != null) {
          break label208;
        }
      }
    }
    label193:
    label208:
    for (paramFavorPayInfo = "";; paramFavorPayInfo = this.tXq.mPayInfo.cnI)
    {
      ad.e(i, paramFavorPayInfo, 9, "");
      this.tXq.gJv = paramString;
      this.tXq.nB(false);
      d.cWY();
      AppMethodBeat.o(46040);
      return;
      paramFavorPayInfo = this.tXq.tVQ.toString();
      break;
      i = this.tXq.mPayInfo.cCD;
      break label131;
    }
  }
  
  public final void cQU()
  {
    AppMethodBeat.i(46042);
    ab.i(this.tXq.TAG, "click add new bankcard");
    Object localObject = i.cTp();
    if (((i)localObject).Pk())
    {
      com.tencent.mm.ui.base.h.b(this.tXq.getContext(), ((i)localObject).pot, this.tXq.getString(2131297087), true);
      AppMethodBeat.o(46042);
      return;
    }
    int i;
    if (this.tXq.mPayInfo == null)
    {
      i = 0;
      if (this.tXq.mPayInfo != null) {
        break label138;
      }
    }
    label138:
    for (localObject = "";; localObject = this.tXq.mPayInfo.cnI)
    {
      ad.e(i, (String)localObject, 14, "");
      this.tXq.tWX.dismiss();
      this.tXq.tWX = null;
      this.tXq.cSi();
      AppMethodBeat.o(46042);
      return;
      i = this.tXq.mPayInfo.cCD;
      break;
    }
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(46041);
    ab.i(this.tXq.TAG, "cashier dialog canceled");
    WalletPayUI.j(this.tXq);
    int i;
    if (this.tXq.mPayInfo == null)
    {
      i = 0;
      if (this.tXq.mPayInfo != null) {
        break label96;
      }
    }
    label96:
    for (String str = "";; str = this.tXq.mPayInfo.cnI)
    {
      ad.e(i, str, 10, "");
      if (this.tXq.isTransparent()) {
        this.tXq.finish();
      }
      AppMethodBeat.o(46041);
      return;
      i = this.tXq.mPayInfo.cCD;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.7
 * JD-Core Version:    0.7.0.1
 */