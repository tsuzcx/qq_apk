package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.o.c;

final class WalletLqtCheckPwdInputDialogUI$2
  implements o.c
{
  WalletLqtCheckPwdInputDialogUI$2(WalletLqtCheckPwdInputDialogUI paramWalletLqtCheckPwdInputDialogUI) {}
  
  public final void a(String paramString, FavorPayInfo paramFavorPayInfo, boolean paramBoolean)
  {
    WalletLqtCheckPwdInputDialogUI.a(this.qhM).dismiss();
    paramFavorPayInfo = new Intent();
    paramFavorPayInfo.putExtra("lqt_fetch_enc_pwd", paramString);
    paramFavorPayInfo.putExtra("lqt_redeem_listid", WalletLqtCheckPwdInputDialogUI.b(this.qhM));
    this.qhM.setResult(-1, paramFavorPayInfo);
    this.qhM.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI.2
 * JD-Core Version:    0.7.0.1
 */