package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.e;

final class WalletForgotPwdUI$a$1$1
  implements DialogInterface.OnClickListener
{
  WalletForgotPwdUI$a$1$1(WalletForgotPwdUI.a.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46282);
    e.m(WalletForgotPwdUI.a.a(this.tZi.tZh), "https://kf.qq.com/touch/sappfaq/180704b6Zb2q180704IfqY3u.html?scene_id=kf1&platform=15", true);
    AppMethodBeat.o(46282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.a.1.1
 * JD-Core Version:    0.7.0.1
 */