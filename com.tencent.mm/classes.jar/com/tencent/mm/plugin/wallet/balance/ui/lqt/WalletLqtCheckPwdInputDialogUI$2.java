package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletLqtCheckPwdInputDialogUI$2
  implements WcPayCashierDialog.a
{
  WalletLqtCheckPwdInputDialogUI$2(WalletLqtCheckPwdInputDialogUI paramWalletLqtCheckPwdInputDialogUI) {}
  
  public final void a(String paramString, FavorPayInfo paramFavorPayInfo, Bankcard paramBankcard)
  {
    AppMethodBeat.i(45517);
    paramFavorPayInfo = new Intent();
    paramFavorPayInfo.putExtra("lqt_fetch_enc_pwd", paramString);
    paramFavorPayInfo.putExtra("lqt_redeem_listid", WalletLqtCheckPwdInputDialogUI.a(this.tPi));
    this.tPi.setResult(-1, paramFavorPayInfo);
    this.tPi.finish();
    AppMethodBeat.o(45517);
  }
  
  public final void cQU() {}
  
  public final void onCancel()
  {
    AppMethodBeat.i(45518);
    ab.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: dialog cancel. finish");
    this.tPi.finish();
    AppMethodBeat.o(45518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI.2
 * JD-Core Version:    0.7.0.1
 */